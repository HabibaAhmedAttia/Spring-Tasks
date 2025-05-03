package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request , Model model)
    {
        //step1: get name from request
        String nameFromRequest = request.getParameter("name");
        nameFromRequest = nameFromRequest.toUpperCase();

        //step2: add name to model
        model.addAttribute("studentName" , nameFromRequest);

        //step3: return view page
        return "resultPage";
    }
}


