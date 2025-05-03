package main.com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@Setter
@Getter
public class UserModel
{
    private String userName;
    private String password;
    private String country;
    private String programmingLanguage;
    private String operatingSystem;
}
/**
 * 1- define UserModel inside the model object (/showForm)
 * 2- linking between the fields inside the jsp page and attributes inside the jsp page
 * 3- recieve the UserModel object inside the /process after filling it in the form page
 */
