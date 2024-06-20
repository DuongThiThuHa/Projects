package org.example.controller;

import jdk.internal.classfile.impl.BufferedCodeBuilder;
import org.example.model.Product;
import org.example.service.IProductService;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showIndex(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("product",products);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product){
        product.setId(product.getId());
        productService.save(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model,@PathVariable int id){
        Product product = productService.findById(id);
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String viewSearch(Model model, @RequestParam("name_inp") String name){
        List<Product> searchList = productService.findByName(name);
        model.addAttribute("products", searchList);
        return "/index";
    }
}
