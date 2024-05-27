package com.hryhorchuk.podarunokShop.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCard;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity userId;

    @OneToMany(mappedBy = "idItem", fetch = FetchType.EAGER)
    private List<ProductCardItemEntity> productList;
}
