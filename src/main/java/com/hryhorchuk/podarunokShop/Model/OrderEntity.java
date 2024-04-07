package com.hryhorchuk.podarunokShop.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private List<ProductEntity> products = new ArrayList<>();
}
