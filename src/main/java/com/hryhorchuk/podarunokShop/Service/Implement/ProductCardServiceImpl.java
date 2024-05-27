package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Model.ProductEntity;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import com.hryhorchuk.podarunokShop.Repository.ProductCardItemRepository;
import com.hryhorchuk.podarunokShop.Repository.ProductCardRepository;
import com.hryhorchuk.podarunokShop.Repository.ProductRepository;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.ProductCardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCardServiceImpl implements ProductCardService {
    private final ProductCardRepository productCardRepository;
    private final ProductCardItemRepository productCardItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public ProductCardServiceImpl(ProductCardRepository productCardRepository, UserRepository userRepository,
                                  ProductRepository productRepository, ProductCardItemRepository productCardItemRepository, UserServiceImpl userServiceImpl) {
        this.productCardRepository = productCardRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productCardItemRepository = productCardItemRepository;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public List<ProductCardItemEntity> getProductCardItemsFromUser() {
        Long userId = userServiceImpl.getIdThisUser();
        Optional<ProductCardEntity> productCardEntityOptional = productCardRepository.findByUserId(userRepository.findByIdUser(userId));

        if (productCardEntityOptional.isPresent()) {
            ProductCardEntity productCard = productCardEntityOptional.get();
            return new ArrayList<>(productCard.getProductList());
        } else {
            return Collections.emptyList();
        }
    }


    public void addToSession(HttpSession session, Long idProduct, int number) {
        if (session.getAttribute("ProductCard") == null) {
            ArrayList<ProductCardItemEntity> productCardItems = addToCardNewSession(idProduct, number);
            session.setAttribute("ProductCard", productCardItems);
        } else {
            ArrayList<ProductCardItemEntity> productCardItems = getProductCardItemsFromSession(session);
            productCardItems = addToCardOldSession(productCardItems, idProduct, number);
            session.setAttribute("ProductCard", productCardItems);
        }
    }

    @Override
    public ArrayList<ProductCardItemEntity> addToCardNewSession(Long idProduct, Integer number) {
        ArrayList<ProductCardItemEntity> list = new ArrayList<>();
        list.add(new ProductCardItemEntity(
                null,
                productRepository.getById(idProduct),
                number
        ));
        return list;
    }

    @Override
    public ArrayList<ProductCardItemEntity> addToCardOldSession(ArrayList<ProductCardItemEntity> list, Long idProduct, Integer number) {
        boolean productExists = false;
        for(ProductCardItemEntity item : list) {
            if(item.getProduct().getId().equals(idProduct)) {
                item.setQuantity(number + item.getQuantity());
                productExists = true;
            }
        }
        if (!productExists) {
            list.add(new ProductCardItemEntity(
                    null,
                    productRepository.getById(idProduct),
                    number
            ));
        }
        return list;
    }

    @Override
    public void addToCardUser(Long userId, Long id, int number) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return;
        }
        UserEntity user = userOptional.get();

        Optional<ProductEntity> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            return;
        }
        ProductEntity product = productOptional.get();

        Optional<ProductCardEntity> productCardOptional = productCardRepository.findByUserId(user);
        ProductCardEntity productCard;

        if (productCardOptional.isPresent()) {
            productCard = productCardOptional.get();
        } else {
            productCard = new ProductCardEntity();
            productCard.setUserId(user);
            productCard.setProductList(new ArrayList<>());
        }

        Optional<ProductCardItemEntity> existingProductOptional = productCard.getProductList().stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst();

        if (existingProductOptional.isPresent()) {
            ProductCardItemEntity existingProduct = existingProductOptional.get();
            existingProduct.setQuantity(existingProduct.getQuantity() + number);
        } else {
            ProductCardItemEntity newItem = new ProductCardItemEntity();
            newItem.setProduct(product);
            newItem.setQuantity(number);

            productCard.getProductList().add(newItem);
            productCardItemRepository.save(newItem);
        }

        productCardRepository.save(productCard);
    }



    @Override
    public ArrayList<ProductCardItemEntity> getProductCardItemsFromSession(HttpSession session) {
        return (ArrayList<ProductCardItemEntity>) session.getAttribute("ProductCard");
    }
}
