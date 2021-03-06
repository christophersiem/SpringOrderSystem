package de.neuefische.ordersystemspring.controller;

import de.neuefische.ordersystemspring.model.Product;
import de.neuefische.ordersystemspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")

public class ProductController {

    private final ProductService service;


    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> listProducts(){
        return service.listProducts();
    }

    @GetMapping("{productId}")
    public Optional<Product> getProductById(@PathVariable String productId){
        return service.getProductById(productId);
    }

}
