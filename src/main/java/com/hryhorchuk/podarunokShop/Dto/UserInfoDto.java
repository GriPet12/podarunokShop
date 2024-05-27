package com.hryhorchuk.podarunokShop.Dto;

import com.hryhorchuk.podarunokShop.Model.OrderEntity;
import com.hryhorchuk.podarunokShop.Model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto {
    private Long idUser;
    private String name;
    private String username;
    private String password;
    private UserRole userRole;
    private String number;
    private String city;
    private String department;
    private List<OrderEntity> orders;
}
