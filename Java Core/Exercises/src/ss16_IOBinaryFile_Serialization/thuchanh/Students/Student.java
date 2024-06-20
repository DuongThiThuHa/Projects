package ss16_IOBinaryFile_Serialization.thuchanh.Students;

import java.io.Serializable;

public class Student implements Serializable {
    private int code;
    private String name;
    private String address;

    public Student() {
    }

    public Student(int code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BenhThuong {" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
