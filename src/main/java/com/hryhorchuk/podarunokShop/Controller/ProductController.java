package com.hryhorchuk.podarunokShop.Controller;

import com.hryhorchuk.podarunokShop.Dto.ProductCardDto;
import com.hryhorchuk.podarunokShop.Dto.ProductDto;
import com.hryhorchuk.podarunokShop.Service.Implement.ProductServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productService, UserServiceImpl userServiceImpl) {
        this.productService = productService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/catalog")
    public String catalogPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/catalogPage";
    }

    @GetMapping("/add")
    public String addPage(ProductDto productDto, Model model) {
        model.addAttribute("dto", productDto);
        return "product/addPage";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("dto") ProductDto productDto) {
        Long idResult = productService.addProduct(productDto);
        return "redirect:/product/item/" + idResult;
    }

    @GetMapping("/delete/{idProduct}")
    public String deleteProduct(@PathVariable Long idProduct) {
        if (productService.deleteProduct(idProduct)) {
            return "redirect:/product/catalog";
        }
        return null;
    }

    @GetMapping("/edit/{idProduct}")
    public String editProductLoadPage(@PathVariable Long idProduct, Model model) {
        ProductDto productDto = productService.productEntityToDto(idProduct);
        model.addAttribute("dto", productDto);
        return "product/editPage";
    }

    @PostMapping("/edit/{idProduct}")
    public String editProduct(@PathVariable Long idProduct, @ModelAttribute("dto") ProductDto productDto) {
        if(productService.editProduct(idProduct, productDto)) {
            return "redirect:/product/item/" + idProduct;
        }
        return null;
    }

    @GetMapping("/item/{idProduct}")
    public String openProduct(@PathVariable Long idProduct, ProductCardDto productCardDto, Model model) {
        model.addAttribute("cardDto", productCardDto);
        model.addAttribute("form", productService.productEntityToDto(idProduct));

        boolean isAdmin = userServiceImpl.userIsAdmin();
        model.addAttribute("isAdmin", isAdmin);

        return "product/productPage";
    }
}
