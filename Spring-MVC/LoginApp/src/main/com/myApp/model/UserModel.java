package main.com.myApp.model;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.validation.constraints.*;

@Component
public class UserModel
{
    @NotEmpty(message = "required")
    //@NotBlank(message = "required")
    private String userName;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,}")
    private String email;
    @Min(value = 15, message = "age must be between 15 and 20")
    @Max(value = 20,message = "age must be between 15 and 20")
    private int age;
    private String password;
    private String country;
    private String programmingLanguage;
    private String operatingSystem;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
/**
 * 1- define UserModel inside the model object (/showForm)
 * 2- linking between the fields inside the jsp page and attributes inside the jsp page
 * 3- recieve the UserModel object inside the /process after filling it in the form page
 */
