package com.hryhorchuk.podarunokShop.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCardDto {
    private Long productId;
    private Integer number;
}
