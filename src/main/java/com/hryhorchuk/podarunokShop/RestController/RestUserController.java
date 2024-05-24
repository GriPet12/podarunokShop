package com.hryhorchuk.podarunokShop.RestController;

import com.hryhorchuk.podarunokShop.Dto.JwtTokenDto;
import com.hryhorchuk.podarunokShop.Dto.SignInRequest;
import com.hryhorchuk.podarunokShop.Dto.SignUpRequest;
import com.hryhorchuk.podarunokShop.Service.Implement.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RestUserController {
    private final AuthenticationServiceImpl authenticationService;

    @Autowired
    public RestUserController(AuthenticationServiceImpl authenticationService) { this.authenticationService = authenticationService; }

    @PostMapping("/reg")
    public JwtTokenDto signUp(@RequestBody SignUpRequest request) {
        return authenticationService.RegistingUser(request);
    }

    @PostMapping("/log")
    public JwtTokenDto signIn(@RequestBody SignInRequest request) {
        return authenticationService.LoginUser(request);
    }
}
