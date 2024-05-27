package com.hryhorchuk.podarunokShop.RestController;

import com.hryhorchuk.podarunokShop.Dto.ProductCardDto;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Repository.ProductCardRepository;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.Implement.ProductCardServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @PutMapping("/item/{idProduct}")
    public ArrayList<ProductCardItemEntity> addToProductCard(@PathVariable Long idProduct, @RequestBody ProductCardDto productCardDto, HttpSession session) {
        ArrayList<ProductCardItemEntity> list;

        Integer number = productCardDto.getNumber();
        if (number == null) {
            throw new IllegalArgumentException("Number cannot be null");
        }

        if (userService.getIdThisUser() != null) {
            Long userId = userService.getIdThisUser();
            productCardService.addToCardUser(userId, idProduct, number);

            list = (ArrayList<ProductCardItemEntity>) productCardService.getProductCardItemsFromUser();
        } else {
            productCardService.addToSession(session, idProduct, number);

            list = productCardService.getProductCardItemsFromSession(session);
        }

        return list;
    }


    @GetMapping("/product-card")
    public ArrayList<ProductCardItemEntity> productCardView(Model model, HttpSession session) {
        ArrayList<ProductCardItemEntity> list;
        if (userService.getIdThisUser() != null) {
            list = (ArrayList<ProductCardItemEntity>) productCardService.getProductCardItemsFromUser();
        } else {
            list = productCardService.getProductCardItemsFromSession(session);
        }
        model.addAttribute("card", list);

        return list;
    }
}
