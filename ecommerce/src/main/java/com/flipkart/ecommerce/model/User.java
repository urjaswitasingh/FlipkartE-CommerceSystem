package com.flipkart.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    @Column
    @NotBlank(message = "User name cannot be blank")
    @Size(min = 2, max = 50, message = "User name must be between 2 and 50 characters")
    String userName;
    @Column
    @NotBlank(message = "User mail cannot be blank")
    @Email(message = "User mail must be a valid email address")
    String userMail;
    @Column
    @NotBlank(message = "User password cannot be blank")
    @Size(min = 8, message = "User password must be at least 8 characters long")
    String userPassword;
}
