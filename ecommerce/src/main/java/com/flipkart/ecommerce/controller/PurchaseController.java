package com.flipkart.ecommerce.controller;

import com.flipkart.ecommerce.model.Product;
import com.flipkart.ecommerce.responce.ReturnResponse;
import com.flipkart.ecommerce.services.PurchaseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/shopping")
@Validated
public class PurchaseController {
@Autowired
PurchaseService purchaseService;
@PostMapping("/buyProduct")
public ResponseEntity<ReturnResponse> purchase(@RequestParam @NotBlank(message = "Account number cannot be blank")String accountNumber, @RequestParam @NotNull(message = "User ID cannot be null") Integer userId, @RequestBody @Valid List<Product> productArray){
    return purchaseService.purchase(accountNumber,userId,productArray);
}
}