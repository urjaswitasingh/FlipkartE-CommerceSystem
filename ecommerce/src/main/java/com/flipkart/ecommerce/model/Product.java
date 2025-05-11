package com.flipkart.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;
@Column
    String productName;
@Column
@NotNull(message = "Price must not be null")
@Min(value = 1, message = "Price must be at least 1")
    Double price;
@Column
@NotNull(message = "Quantity must not be null")
@Min(value = 1, message = "Quantity must be at least 1")
    int quantity;

}
