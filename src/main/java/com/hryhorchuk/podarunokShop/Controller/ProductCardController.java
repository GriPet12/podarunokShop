package com.hryhorchuk.podarunokShop.Controller;

import com.hryhorchuk.podarunokShop.Dto.ProductCardDto;
import com.hryhorchuk.podarunokShop.Model.ProductCardItemEntity;
import com.hryhorchuk.podarunokShop.Service.Implement.ProductCardServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/product")
public class ProductCardController {

    private final ProductCardServiceImpl productCardService;
    private final UserServiceImpl userService;

    @Autowired
    public ProductCardController(ProductCardServiceImpl productCardService, UserServiceImpl userService) {
        this.productCardService = productCardService;
        this.userService = userService;
    }

    @PostMapping("/item/{idProduct}")
    public String addToProductCard(@PathVariable Long idProduct, ProductCardDto productCardDto, HttpSession session) {
        if (userService.getIdThisUser() != null) {
            Long userId = userService.getIdThisUser();
            productCardService.addToCardUser(userId, idProduct, productCardDto.getNumber());
        } else {
            productCardService.addToSession(session, idProduct, productCardDto.getNumber());
        }

        return "redirect:/product/product-card";
    }

    @GetMapping("/product-card")
    public String productCardView(Model model, HttpSession session) {
        ArrayList<ProductCardItemEntity> list = productCardService.getProductCardItemsFromSession(session);
        model.addAttribute("card", list);

        return "ProductCard";
    }
}
