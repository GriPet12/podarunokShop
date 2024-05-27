package com.hryhorchuk.podarunokShop.Repository;

import com.hryhorchuk.podarunokShop.Model.OrderEntity;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByUser(UserEntity user);
}
