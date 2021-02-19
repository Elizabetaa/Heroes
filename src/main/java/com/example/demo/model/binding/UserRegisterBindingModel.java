package com.example.demo.model.binding;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String country;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 2, max = 20, message = "Username must between two and twenty symbols!")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @NotBlank(message = "Email cannot be empty")
    @Email
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 2,max = 20,message = "Password must between two and twenty symbols!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
    @NotBlank(message = "Country cannot be empty")
    @Size(min = 3,max = 20,message = "Country must between three and twenty symbols!")
    public String getCountry() {
        return country;
    }

    public UserRegisterBindingModel setCountry(String country) {
        this.country = country;
        return this;
    }
}
