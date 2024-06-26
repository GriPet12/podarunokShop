package com.hryhorchuk.podarunokShop.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductCardDto {
    private Long productId;
    private Integer number;
}
