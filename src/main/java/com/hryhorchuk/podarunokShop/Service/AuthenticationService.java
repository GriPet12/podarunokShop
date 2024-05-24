package com.hryhorchuk.podarunokShop.Service;

import com.hryhorchuk.podarunokShop.Dto.JwtTokenDto;
import com.hryhorchuk.podarunokShop.Dto.SignInRequest;
import com.hryhorchuk.podarunokShop.Dto.SignUpRequest;

public interface AuthenticationService {
    JwtTokenDto RegistingUser(SignUpRequest request);
    JwtTokenDto LoginUser(SignInRequest request);
}
