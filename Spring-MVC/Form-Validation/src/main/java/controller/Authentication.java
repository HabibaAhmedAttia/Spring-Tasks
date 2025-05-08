package controller;

import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
public class Authentication {
    private UserDAO userDAO = new UserDAO();

    @RequestMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        if (userDAO.emailExists(user.getEmail())) {
            model.addAttribute("error", "Email already exists.");
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

    @RequestMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        boolean isValid = userDAO.validateUser(user.getEmail(), user.getPassword());
        if (isValid) {
            model.addAttribute("name", user.getEmail());
            return "index";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }
}
