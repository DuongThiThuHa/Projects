package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/sandwich")
    public ModelAndView sandwich (@RequestParam String sandwich) {
        return new ModelAndView("index", "res", sandwich);
    }
}
