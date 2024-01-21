package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "index";
    }

    @GetMapping("/")
    public String showUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }

        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "users/update";
    }

    @PostMapping("/update")
    public String editUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult,
                           @RequestParam("id") int id) {
        if (bindingResult.hasErrors()) {
            return "/users/update";
        }

        userService.updateUser(id,user);
        return "redirect:/users";
    }

    @GetMapping("/delete/")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
