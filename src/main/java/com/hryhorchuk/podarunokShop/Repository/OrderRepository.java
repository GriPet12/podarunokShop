package com.hryhorchuk.podarunokShop.Repository;

import com.hryhorchuk.podarunokShop.Model.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
