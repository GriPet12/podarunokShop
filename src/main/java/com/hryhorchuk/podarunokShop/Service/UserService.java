package com.hryhorchuk.podarunokShop.Service;

import com.hryhorchuk.podarunokShop.Dto.UserDto;
import com.hryhorchuk.podarunokShop.Dto.UserInfoDto;

public interface UserService {
    void createUser(UserDto userDto);
    UserInfoDto getUser(Long idUser);
}
