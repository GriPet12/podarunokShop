package com.hryhorchuk.podarunokShop.Service.Implement;

import com.hryhorchuk.podarunokShop.Dto.ProductDto;
import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Model.ProductEntity;
import com.hryhorchuk.podarunokShop.Repository.ProductCardRepository;
import com.hryhorchuk.podarunokShop.Repository.ProductRepository;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserServiceImpl userServiceImpl;
    private final ProductCardRepository productCardRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserServiceImpl userServiceImpl, ProductCardRepository productCardRepository, UserRepository userRepository){
        this.productRepository = productRepository;
        this.userServiceImpl = userServiceImpl;
        this.productCardRepository = productCardRepository;
        this.userRepository = userRepository;
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

    @Override
    public ArrayList<ProductCardItemEntity> getProductList() {
        Long idUser = userServiceImpl.getIdThisUser();
        ProductCardEntity productCard = productCardRepository.findByUserId(userRepository.findByIdUser(idUser));
        ArrayList<ProductCardItemEntity> list;

        if (productCard != null) {
            list = (ArrayList<ProductCardItemEntity>) productCard.getProductList();
        } else {
            list = new ArrayList<>();
        }

        return list;
    }
}
