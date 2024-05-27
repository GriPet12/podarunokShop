package com.hryhorchuk.podarunokShop.Service;

import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public interface ProductCardService {

    void addToCardUser(Long userId, Long id, int number);

    ArrayList<ProductCardItemEntity> addToCardNewSession(Long idProduct, Integer number);

    ArrayList<ProductCardItemEntity> addToCardOldSession(ArrayList<ProductCardItemEntity> list, Long idProduct, Integer number);

    ArrayList<ProductCardItemEntity> getProductCardItemsFromSession(HttpSession session);

    List<ProductCardItemEntity> getProductCardItemsFromUser();
}
