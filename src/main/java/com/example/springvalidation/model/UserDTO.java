package com.example.springvalidation.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long SerialVersionUID=1L;
    private String name;
    private String password;
    private String email;
    private String phone;

    public UserDTO() { }

    public UserDTO(String name, String password, String email, String phone) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    @NotBlank(message="{error.user.name}")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message="{error.user.empty}")
    @Size(min=8,max=20,message = "{error.user.password}")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
@NotBlank(message = "{error.user.email}")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

@NotBlank(message="{error.user.phone}")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
