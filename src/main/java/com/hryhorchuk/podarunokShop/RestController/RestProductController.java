package com.hryhorchuk.podarunokShop.RestController;

import com.hryhorchuk.podarunokShop.Dto.ProductDto;
import com.hryhorchuk.podarunokShop.Service.Implement.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/rest-api/product")
public class RestProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public RestProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/catalog")
    public ArrayList<ProductDto> catalogPage() {
        return productService.findAll();
    }

    @PostMapping("/add")
    public Long addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long idProduct) {
        return productService.deleteProduct(idProduct)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/edit/{idProduct}")
    public ResponseEntity<?> editProduct(@PathVariable Long idProduct, @RequestBody ProductDto productDto) {
        return productService.editProduct(idProduct, productDto)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
