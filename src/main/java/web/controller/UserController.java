package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping()
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

//    @PostMapping()
//    public String create(@RequestParam("name") String name,
//                         @RequestParam("lastname") String lastName,
//                         @RequestParam("email") String email,
//                         Model model) {
//
//        User user = new User();
//
//        user.setFirstName(name);
//        user.setLastName(lastName);
//        user.setEmail(email);
//
//        model.addAttribute("user", user);
//
//        return "success";
//    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {

        return "success";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

}
