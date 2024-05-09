package com.hryhorchuk.podarunokShop.Controller;

import com.hryhorchuk.podarunokShop.Dto.ProductCardDto;
import com.hryhorchuk.podarunokShop.Dto.ProductDto;
import com.hryhorchuk.podarunokShop.Service.Implement.ProductCardServiceImpl;
import com.hryhorchuk.podarunokShop.Service.Implement.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;
    private final ProductCardServiceImpl productCardService;

    @Autowired
    public ProductController(ProductServiceImpl productService, ProductCardServiceImpl productCardService) {
        this.productCardService = productCardService;
        this.productService = productService;
    }

    @GetMapping("/catalog")
    public String catalogPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "catalogPage";
    }

    @GetMapping("/add")
    public String addPage(ProductDto productDto, Model model) {
        model.addAttribute("dto", productDto);
        return "addPage";
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
        } else {
            return "error/er404";
        }
    }

    @GetMapping("/edit/{idProduct}")
    public String editProductLoadPage(@PathVariable Long idProduct, Model model) {
        ProductDto productDto = productService.productEntityToDto(idProduct);
        model.addAttribute("dto", productDto);
        return "editPage";
    }

    @PostMapping("/edit/{idProduct}")
    public String editProduct(@PathVariable Long idProduct, @ModelAttribute("dto") ProductDto productDto) {
        if(productService.editProduct(idProduct, productDto)) {
            return "redirect:/product/item/" + idProduct;
        } else {
            return "error/er404";
        }
    }

    @GetMapping("/item/{idProduct}")
    public String openProduct(@PathVariable Long idProduct, ProductCardDto productCardDto, Model model) {
        model.addAttribute("cardDto", productCardDto);
        model.addAttribute("form", productService.productEntityToDto(idProduct));
        return "productPage";
    }

    @PostMapping("/item/{idProduct}")
    public String addToProductCard(@ModelAttribute("cardDto") ProductCardDto productCardDto, Model model) {
        productCardService.addToCard(productCardDto);
        return "redirect:/product/{idProduct}";
    }
}
