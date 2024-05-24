package com.hryhorchuk.podarunokShop.RestController;

import com.hryhorchuk.podarunokShop.Dto.ProductCardDto;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Repository.ProductCardRepository;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.Implement.ProductCardServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/rest-api/product")
public class RestProductCardController {

    private final ProductCardServiceImpl productCardService;
    private final UserServiceImpl userService;
    private final ProductCardRepository productCardRepository;
    private final UserRepository userRepository;

    @Autowired
    public RestProductCardController(ProductCardServiceImpl productCardService, UserServiceImpl userService, ProductCardRepository productCardRepository, UserRepository userRepository) {
        this.productCardService = productCardService;
        this.userService = userService;
        this.productCardRepository = productCardRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/item/{idProduct}")
    public ArrayList<ProductCardItemEntity> addToProductCard(@PathVariable Long idProduct, @RequestBody ProductCardDto productCardDto, HttpSession session) {

        if(userService.getIdThisUser() != null) {
            Long userId = userService.getIdThisUser();
            productCardService.addToCardUser(userId, idProduct, productCardDto.getNumber());

            return (ArrayList<ProductCardItemEntity>)
                    productCardRepository.findProductListByIdCard(productCardRepository.getIdByUserId(userRepository.findByIdUser(userId)));
        } else {
            ArrayList<ProductCardItemEntity> list = (ArrayList<ProductCardItemEntity>)
                    session.getAttribute("ProductCard");

            if(list == null) {
                list = productCardService.addToCardNewSession(idProduct, productCardDto.getNumber());
                session.setAttribute(
                        "ProductCard",
                        list
                );
            } else {
                list = productCardService.addToCardOldSession(list, idProduct, productCardDto.getNumber());
                session.setAttribute("ProductCard", list);
            }

            return (ArrayList<ProductCardItemEntity>) session.getAttribute("ProductCard");
        }
    }
}
