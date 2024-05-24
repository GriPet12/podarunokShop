package com.hryhorchuk.podarunokShop.Controller;

import com.hryhorchuk.podarunokShop.Dto.SignInRequest;
import com.hryhorchuk.podarunokShop.Dto.SignUpRequest;
import com.hryhorchuk.podarunokShop.Service.Implement.AuthenticationServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;
    private final AuthenticationServiceImpl authenticationService;

    @Autowired
    UserController(UserServiceImpl userService, AuthenticationServiceImpl authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/register")
    public String loadReg(SignUpRequest request, Model model) {
        model.addAttribute("userDto", request);
        return "user/registering";
    }

    @GetMapping("/login")
    public String loadLog(SignInRequest request, Model model) {
        model.addAttribute("userDto", request);
        return "user/login";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("userDto") SignUpRequest request) {
        authenticationService.RegistingUser(request);
        return "redirect:/product/catalog";
    }

    @PostMapping("/login")
    public String signIn(@ModelAttribute("userDto") SignInRequest request, HttpServletResponse response) {

        String jwt = authenticationService.LoginUser(request).getToken();

        Cookie cookie = new Cookie("Authorization", jwt);
        cookie.setPath("/");
        cookie.setMaxAge(86400);
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping("/account/{userId}")
    public String loadAccount(@PathVariable Long userId, Model model) {
        model.addAttribute("info", userService.getByIdUser(userId));
        return "user/account";
    }
}
