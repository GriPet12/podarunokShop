package com.hryhorchuk.podarunokShop.Repository;

import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCardRepository extends CrudRepository<ProductCardEntity, Long> {
}
