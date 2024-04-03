package com.hryhorchuk.podarunokShop.Repository;

import com.hryhorchuk.podarunokShop.Model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity getById(Long id);
    ProductEntity getByNameProduct(String nameProduct);
}
