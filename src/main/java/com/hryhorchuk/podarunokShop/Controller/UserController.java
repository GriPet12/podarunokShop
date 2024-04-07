package com.hryhorchuk.podarunokShop.Controller;

import com.hryhorchuk.podarunokShop.Dto.UserDto;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    UserController(UserServiceImpl userService) { this.userService = userService; }

    @GetMapping("/register")
    public String regisUser(UserDto userDto, Model model) {
        model.addAttribute(userDto);
        return "user/registering";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute UserDto userDto) {
        userService.createUser(userDto);
        return "redirect:/";
    }
}
