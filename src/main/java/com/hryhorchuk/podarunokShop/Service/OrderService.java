package com.hryhorchuk.podarunokShop.Service;

import com.hryhorchuk.podarunokShop.Model.OrderEntity;

public interface OrderService {
    boolean buyFromProductCard(Long userId);
    void createOrder(Long userId, Long productCardId);
    void sendOrder(OrderEntity OrderId);
}
