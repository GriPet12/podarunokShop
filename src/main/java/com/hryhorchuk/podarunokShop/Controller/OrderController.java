package com.hryhorchuk.podarunokShop.Controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class OrderController {

    private final OrderServiceImpl orderService;
    private final UserServiceImpl userService;
    private final UserRepository userRepository;

    @Autowired
    public OrderController(OrderServiceImpl orderService, UserServiceImpl userService, UserRepository userRepository) {
        this.orderService = orderService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/buy")
    public String buyLoad(Model model) {
        if (userService.getIdThisUser() != null) {
            Long userId = userService.getIdThisUser();
            UserEntity user = userRepository.findByIdUser(userId);
            OrderInfoDto info = new OrderInfoDto(
                    user.getName(),
                    user.getNumber(),
                    user.getCity(),
                    user.getDepartment()
            );
            model.addAttribute("orderInfo", info);
        }
        return "product/OrderPage";
    }

    @PostMapping("/buy")
    public String buy(@ModelAttribute("orderInfo")OrderInfoDto info, HttpSession session) {
        if(userService.getIdThisUser() != null) {
            Long userId = userService.getIdThisUser();
            orderService.buyFromProductCard(userId, info);
        } else {
            var card = (ProductCardEntity) session.getAttribute("card");
            orderService.buyFromProductSession(card, info);
            session.removeAttribute("card");
        }
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String listOrders() {
        return "product/OrderList";
    }

}
