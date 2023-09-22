package aster.kz.controllers;

import aster.kz.models.dtos.User;
import aster.kz.servicies.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String addUser(User user, Principal principal) {
        userService.addUser(user, principal);
        return "login";
    }
    @GetMapping("/sign-up-btn")
    public String registerBtn() {
        return "register";
    }

}
