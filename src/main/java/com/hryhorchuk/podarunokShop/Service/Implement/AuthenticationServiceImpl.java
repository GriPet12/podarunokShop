package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Dto.JwtTokenDto;
import com.hryhorchuk.podarunokShop.Dto.SignInRequest;
import com.hryhorchuk.podarunokShop.Dto.SignUpRequest;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import com.hryhorchuk.podarunokShop.Model.UserRole;
import com.hryhorchuk.podarunokShop.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDetailsServiceImpl userDetailsService;
    private final UserServiceImpl userService;
    private final JwtServiceImpl jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtTokenDto RegistingUser(SignUpRequest request) {

        UserEntity user = new UserEntity(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                UserRole.ROLE_USER);

        JwtTokenDto jwt = new JwtTokenDto(jwtService.generateToken(user));

        userService.create(user);

        return jwt;
    }

    @Override
    public JwtTokenDto LoginUser(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());

        String jwt = jwtService.generateToken(user);
        return new JwtTokenDto(jwt);
    }
}