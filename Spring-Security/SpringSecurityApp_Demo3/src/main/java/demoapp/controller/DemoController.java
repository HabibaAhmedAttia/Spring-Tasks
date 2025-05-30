package demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome()
    {
        return "home";
    }

    @GetMapping("/loginPage")
    public String showLoginPage()
    {
        return "loginPage";
    }

    @GetMapping("/systems/systemParent")
    public String showSystemPage()
    {
        return "systemParentPage";
    }

    @GetMapping("/systems/systemChild")
    public String showSystemChildPage()
    {
        return "systemPageChild";
    }

    @GetMapping("/accessDenied")
    public String showAccessDeniedPage()
    {
        return "accessDenied";
    }
}



