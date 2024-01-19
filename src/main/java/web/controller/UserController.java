package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        System.out.println("create UserService");
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/index";
    }

    @GetMapping("/")
    public String showUser(@RequestParam("id") int id, Model model) {
        System.out.println(id);
        model.addAttribute("user", userService.findUserById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        return "users/new";
    }

}
