package main.com.myApp.controller;

import main.com.myApp.model.UserModel;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
    public String processForm(@Valid @ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            return "formPage";
        }

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

    @InitBinder
    public void initbinder(WebDataBinder binder)
    {
        StringTrimmerEditor editor=new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,editor);

    }

}