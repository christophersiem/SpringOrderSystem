package de.neuefische.ordersystemspring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter/Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    private String id;
    private String name;
}
