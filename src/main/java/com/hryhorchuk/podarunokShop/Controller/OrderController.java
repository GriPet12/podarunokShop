package com.hryhorchuk.podarunokShop.Controller;

import com.hryhorchuk.podarunokShop.Service.Implement.OrderServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderServiceImpl orderService;
    private final UserServiceImpl userService;

    @Autowired
    public OrderController(OrderServiceImpl orderService, UserServiceImpl userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/buy")
    public String buy() {
        if(userService.getIdThisUser() != null) {
            Long userId = userService.getIdThisUser();
            orderService.buyFromProductCard(userId);
        } else {
            // buy from session
        }
        return "redirect:/order/list";
    }

}
