package com.jp.house.information.recording.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("listAllUser", users);
        return "users";
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registration-process")
    public String processRegistration(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return "registration-success";
    }

}
