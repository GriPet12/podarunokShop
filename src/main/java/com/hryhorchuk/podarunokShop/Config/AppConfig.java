package com.hryhorchuk.podarunokShop.Config;

import com.hryhorchuk.podarunokShop.Service.Implement.JwtServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public JwtServiceImpl jwtService() {
        return new JwtServiceImpl();
    }
}
