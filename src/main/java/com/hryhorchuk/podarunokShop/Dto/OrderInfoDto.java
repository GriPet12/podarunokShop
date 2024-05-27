package com.hryhorchuk.podarunokShop.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderInfoDto {
    String name;
    String number;
    String city;
    String department;
}
