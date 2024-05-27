package com.hryhorchuk.podarunokShop.Service;

import com.hryhorchuk.podarunokShop.Dto.OrderInfoDto;
import com.hryhorchuk.podarunokShop.Model.OrderEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;

public interface OrderService {
    void sendOrder(OrderEntity OrderId, OrderInfoDto info);
    void buyFromProductSession(ProductCardEntity card, OrderInfoDto info);
    void buyFromProductCard(Long userId, OrderInfoDto info);
}
