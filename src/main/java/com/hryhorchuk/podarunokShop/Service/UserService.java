package com.hryhorchuk.podarunokShop.Service;

import com.hryhorchuk.podarunokShop.Dto.UserInfoDto;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    Long getIdThisUser();
    boolean checkIfUserAuth();
    UserEntity create(UserEntity user);
    UserEntity save(UserEntity user);
    UserEntity getByUsername(String username);
    UserDetailsService userDetailsService();
    UserEntity getCurrentUser();
    UserInfoDto getByIdUser(Long idUser);
}
