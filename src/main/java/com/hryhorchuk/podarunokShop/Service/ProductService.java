package com.hryhorchuk.podarunokShop.Service;

import com.hryhorchuk.podarunokShop.Dto.ProductDto;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;

import java.util.ArrayList;

public interface ProductService {
    Long addProduct(ProductDto productDto);

    boolean deleteProduct(Long idProduct);

    ProductDto productEntityToDto(Long idProduct);

    boolean editProduct(Long idProduct, ProductDto productDto);

    ArrayList<ProductDto> findAll();

    ArrayList<ProductCardItemEntity> getProductList();
}
