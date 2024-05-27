package com.hryhorchuk.podarunokShop.RestController;

import com.hryhorchuk.podarunokShop.Dto.JwtTokenDto;
import com.hryhorchuk.podarunokShop.Dto.SignInRequest;
import com.hryhorchuk.podarunokShop.Dto.SignUpRequest;
import com.hryhorchuk.podarunokShop.Dto.UserInfoDto;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.Implement.AuthenticationServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class RestUserController {
    private final AuthenticationServiceImpl authenticationService;
    private final UserServiceImpl userService;

    @Autowired
    public RestUserController(AuthenticationServiceImpl authenticationService, UserServiceImpl userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }
    @PostMapping("/reg")
    public JwtTokenDto signUp(@RequestBody SignUpRequest request) {
        return authenticationService.RegistingUser(request);
    }

    @PostMapping("/log")
    public JwtTokenDto signIn(@RequestBody SignInRequest request) {
        return authenticationService.LoginUser(request);
    }

    @GetMapping("/account")
    public UserInfoDto loadAccount(Model model) {
        Long id = userService.getIdThisUser();
        return userService.getByIdUser(id);
    }
}
