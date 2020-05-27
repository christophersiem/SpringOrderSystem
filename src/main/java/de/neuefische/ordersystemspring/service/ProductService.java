package de.neuefische.ordersystemspring.service;

import de.neuefische.ordersystemspring.db.ProductDb;
import de.neuefische.ordersystemspring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    

    private final ProductDb productDb;


    @Autowired
    public ProductService(ProductDb productDb) {

        this.productDb = productDb;
    }

    public List<Product> listProducts() {
        return productDb.listProducts();

    }

    public Optional<Product> getProductById(String id){
        return productDb.getProductById(id);
    }

}
