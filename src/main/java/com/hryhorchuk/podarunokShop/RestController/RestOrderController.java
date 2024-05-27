package com.hryhorchuk.podarunokShop.RestController;

import com.hryhorchuk.podarunokShop.Dto.OrderInfoDto;
import com.hryhorchuk.podarunokShop.Model.ProductCardEntity;
import com.hryhorchuk.podarunokShop.Model.UserEntity;
import com.hryhorchuk.podarunokShop.Repository.UserRepository;
import com.hryhorchuk.podarunokShop.Service.Implement.OrderServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest-api/product")
public class RestOrderController {

    private final OrderServiceImpl orderService;
    private final UserServiceImpl userService;

    @Autowired
    public RestOrderController(OrderServiceImpl orderService, UserServiceImpl userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/buy")
    public boolean buy(@ModelAttribute("orderInfo")OrderInfoDto info, HttpSession session) {
        if(userService.getIdThisUser() != null) {
            Long userId = userService.getIdThisUser();
            orderService.buyFromProductCard(userId, info);
        } else {
            ProductCardEntity card = (ProductCardEntity) session.getAttribute("card");
            orderService.buyFromProductSession(card, info);
        }
        return true;
    }
}
