package com.flipkart.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int Id;
@Column
LocalDate time;
@Column
int quantity;
@Column
double amount;
@ManyToOne
@JoinColumn(name = "userId", nullable = false)
private User user;

@ManyToOne
@JoinColumn(name = "productId", nullable = false)
private Product product;
}









