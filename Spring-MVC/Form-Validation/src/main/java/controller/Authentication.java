package controller;

import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class Authentication {
    private UserDAO userDAO = new UserDAO();


    // Show register form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/register";
    }

    // Handle register submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        boolean saved = userDAO.saveUser(user);
        if (saved) {
            model.addAttribute("msg", "Registration successful. Please login.");
            return "redirect:/login";
        } else {
            model.addAttribute("error", "User already exists.");
            return "register";
        }
    }

    // Show login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // Handle login submission
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        boolean isValid = userDAO.validateUser(user.getEmail(), user.getPassword());
        if (isValid) {
            model.addAttribute("name", user.getEmail());
            return "welcome"; // You should create a welcome.jsp
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }
}
