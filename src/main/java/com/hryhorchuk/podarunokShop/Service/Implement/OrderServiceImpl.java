package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Model.OrderEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Repository.ProductCardRepository;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final ProductCardRepository productCardRepository;

    @Autowired
    public OrderServiceImpl(UserRepository userRepository, ProductCardRepository productCardRepository) {
        this.userRepository = userRepository;
        this.productCardRepository = productCardRepository;
    }

    @Override
    public boolean buyFromProductCard(Long userId) {
        Long productCardId = productCardRepository.
                getIdByUserId(userRepository.findByIdUser(userId));
        createOrder(userId, productCardId);
        return false;
    }

    @Override
    public void createOrder(Long userId, Long productCardId) {
        List<ProductCardItemEntity> item = productCardRepository.
                findProductListByIdCard(productCardId);

        OrderEntity order = new OrderEntity(
                null,
                userRepository.findByIdUser(userId),
                item
        );

        sendOrder(order);
    }

    @Override
    public void sendOrder(OrderEntity OrderId) {
        // Send order to email or telegram.
    }
}
