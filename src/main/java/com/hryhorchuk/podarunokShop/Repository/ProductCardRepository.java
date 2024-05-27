package com.hryhorchuk.podarunokShop.Repository;

import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCardRepository extends CrudRepository<ProductCardEntity, Long> {
    Optional<ProductCardEntity> findByUserId(UserEntity userId);
    Long getIdByUserId(UserEntity userId);

}
