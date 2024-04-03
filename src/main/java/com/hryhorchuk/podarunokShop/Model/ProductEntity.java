package com.hryhorchuk.podarunokShop.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private String inscription;

    @Column(nullable = false)
    private int price;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;
}
