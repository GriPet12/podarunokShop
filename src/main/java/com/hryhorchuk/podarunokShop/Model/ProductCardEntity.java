package com.hryhorchuk.podarunokShop.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

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
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity userId;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private Map<Integer, ProductEntity> productMap;
}
