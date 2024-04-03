package com.hryhorchuk.podarunokShop.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String inscription;
    private int price;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
}
