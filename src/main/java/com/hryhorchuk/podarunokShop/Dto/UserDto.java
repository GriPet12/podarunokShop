package com.hryhorchuk.podarunokShop.Dto;

import com.hryhorchuk.podarunokShop.Model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String username;
    private String password;
    private String name;
    private UserRole userRole;
}
