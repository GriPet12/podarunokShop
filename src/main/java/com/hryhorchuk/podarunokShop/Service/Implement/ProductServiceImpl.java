package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Dto.ProductDto;
import com.hryhorchuk.podarunokShop.Model.ProductEntity;
import com.hryhorchuk.podarunokShop.Repository.ProductRepository;
import com.hryhorchuk.podarunokShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Long addProduct(ProductDto productDto) {
        productRepository.save(new ProductEntity(
                null,
                productDto.getName(),
                productDto.getInscription(),
                productDto.getPrice(),
                productDto.getImage1(),
                productDto.getImage2(),
                productDto.getImage3(),
                productDto.getImage4(),
                productDto.getImage5()
        ));
        return productRepository.getByNameProduct(productDto.getName()).getId();
    }
    public boolean deleteProduct(Long idProduct) {
        if(productRepository.existsById(idProduct)) {
            productRepository.deleteById(idProduct);
            return true;
        } else {
            return false;
        }
    }

    public ProductDto productEntityToDto(Long idProduct) {
        ProductEntity productEntity = productRepository.getById(idProduct);
        return new ProductDto(
                productEntity.getId(),
                productEntity.getNameProduct(),
                productEntity.getInscription(),
                productEntity.getPrice(),
                productEntity.getImage1(),
                productEntity.getImage2(),
                productEntity.getImage3(),
                productEntity.getImage4(),
                productEntity.getImage5()
                );
    }

    public boolean editProduct(Long idProduct, ProductDto productDto) {
        if(productRepository.existsById(idProduct)) {
            ProductEntity productEntity = new ProductEntity(
                    idProduct,
                    productDto.getName(),
                    productDto.getInscription(),
                    productDto.getPrice(),
                    productDto.getImage1(),
                    productDto.getImage2(),
                    productDto.getImage3(),
                    productDto.getImage4(),
                    productDto.getImage5()
            );
            productRepository.save(productEntity);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<ProductDto> findAll() {
        ArrayList<ProductDto> result = new ArrayList<>();

        ArrayList<ProductEntity> tempProduct = (ArrayList<ProductEntity>) productRepository.findAll();

        for (ProductEntity PE : tempProduct) {
            result.add(productEntityToDto(PE.getId()));
        }

        return result;
    }
}
