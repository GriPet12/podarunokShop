package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Dto.OrderInfoDto;
import com.hryhorchuk.podarunokShop.Model.OrderEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import com.hryhorchuk.podarunokShop.Repository.OrderRepository;
import com.hryhorchuk.podarunokShop.Repository.ProductCardRepository;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final ProductCardRepository productCardRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(UserRepository userRepository, ProductCardRepository productCardRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productCardRepository = productCardRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void buyFromProductCard(Long userId, OrderInfoDto info) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        UserEntity user = optionalUser.get();

        ProductCardEntity productCard = productCardRepository.findByUserId(user).get();

        List<ProductCardItemEntity> itemList = new ArrayList<>(productCard.getProductList());

        OrderEntity order = new OrderEntity(null, user, itemList);


        sendOrder(order, info);

        orderRepository.save(order);
        productCardRepository.delete(productCardRepository.findByUserId(user).get());
    }

    @Override
    public void buyFromProductSession(ProductCardEntity card, OrderInfoDto info) {
        // Send order to email or telegram.
    }

    @Override
    public void sendOrder(OrderEntity OrderId, OrderInfoDto info) {
        // Send order to email or telegram.
    }
}
