package homework2.controller;

import homework2.model.User;
import homework2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable int id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUserById(@PathVariable int id, Model model){
        userService.deleteById(id);
        return "redirect:/users";
    }


    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}
