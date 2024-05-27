package com.hryhorchuk.podarunokShop.Repository;

import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Model.ProductEntity;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCardItemRepository extends CrudRepository<ProductCardItemEntity, Long> {
    ProductCardItemEntity findByProductId(Long productId);
    Optional<ProductCardItemEntity> findByProduct(ProductEntity product);
}
