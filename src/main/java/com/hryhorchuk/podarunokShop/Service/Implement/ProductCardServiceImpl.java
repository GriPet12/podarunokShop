package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Repository.ProductCardItemRepository;
import com.hryhorchuk.podarunokShop.Repository.ProductCardRepository;
import com.hryhorchuk.podarunokShop.Repository.ProductRepository;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.ProductCardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductCardServiceImpl implements ProductCardService {
    private final ProductCardRepository productCardRepository;
    private final ProductCardItemRepository productCardItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductCardServiceImpl(ProductCardRepository productCardRepository, UserRepository userRepository,
                                  ProductRepository productRepository, ProductCardItemRepository productCardItemRepository) {
        this.productCardRepository = productCardRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productCardItemRepository = productCardItemRepository;
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
        if (productCardRepository.findByUserId(userRepository.findByIdUser(userId)) == null) {
            ProductCardItemEntity productCardItem =
                    productCardItemRepository.save(new ProductCardItemEntity(
                            null,
                            productRepository.getById(id),
                            number
                    ));

            ArrayList<ProductCardItemEntity> tempItem = new ArrayList<>();
            tempItem.add(productCardItem);

            productCardRepository.save(new ProductCardEntity(
                    null,
                    userRepository.findByIdUser(userId),
                    tempItem
            ));
        } else {
            ProductCardEntity productCard = productCardRepository.findByUserId(userRepository.findByIdUser(userId));
            if (productCard.getProductList().contains(productCardItemRepository.findByProductId(id))) {
                int quantity = productCardItemRepository.findByProductId(id).getQuantity();
                productCardItemRepository.findByProductId(id).setQuantity(quantity + number);
            } else {
                productCard.getProductList().add(new ProductCardItemEntity(
                        null,
                        productRepository.getById(id),
                        number
                ));
            }
        }
    }

    @Override
    public ArrayList<ProductCardItemEntity> getProductCardItemsFromSession(HttpSession session) {
        return (ArrayList<ProductCardItemEntity>) session.getAttribute("ProductCard");
    }
}
