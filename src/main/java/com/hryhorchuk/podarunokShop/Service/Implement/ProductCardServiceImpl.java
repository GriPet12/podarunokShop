package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Dto.ProductCardDto;
import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Repository.ProductCardRepository;
import com.hryhorchuk.podarunokShop.Service.ProductCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductCardServiceImpl implements ProductCardService {
    private final ProductCardRepository productCardRepository;

    @Autowired
    public ProductCardServiceImpl(ProductCardRepository productCardRepository) { this.productCardRepository = productCardRepository; }

    @Override
    public boolean addToCard(ProductCardDto productCardDto) {
        ProductCardEntity productCardEntity = new ProductCardEntity(

        );
        return false;
    }
}
