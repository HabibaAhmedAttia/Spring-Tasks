package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import sun.misc.Contended;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage()
    {
        return "homePage";
    }
}
