package main.com.myApp.controller;

import main.com.myApp.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{

    @RequestMapping("/showForm")
    public String showHomePage(Model model)
    {
        model.addAttribute("userModel" , new UserModel());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("userModel") UserModel userModel, Model model)
    {

        String usernameAsUpperCase = userModel.getUserName().toUpperCase();
        userModel.setUserName(usernameAsUpperCase);

        //step1: add bean to model
       model.addAttribute("userModelResult" , userModel);

       //step2: return view page
        return "resultPage";
    }

    @RequestMapping("/showTestForm")
    public String showTestForm()
    {
        return "test";
    }
}