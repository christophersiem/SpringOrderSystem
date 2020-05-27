package de.neuefische.ordersystemspring.db;

import de.neuefische.ordersystemspring.model.Product;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@ToString
@Repository

public class ProductDb {



    private final ArrayList<Product> products = new ArrayList<>(List.of(
            new Product("1", "Gurke"),
            new Product("2", "Tomate"),
            new Product("3", "Wurst")
    ));

    public List<Product> listProducts() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }

        }
        return Optional.empty();
    }
}


