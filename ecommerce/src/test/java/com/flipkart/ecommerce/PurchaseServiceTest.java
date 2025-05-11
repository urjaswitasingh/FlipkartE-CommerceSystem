package com.flipkart.ecommerce;


import com.flipkart.ecommerce.model.Product;
import com.flipkart.ecommerce.repository.ProductRepo;
import com.flipkart.ecommerce.responce.ReturnResponse;
import com.flipkart.ecommerce.services.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PurchaseServiceTest {

@Autowired
private PurchaseService purchaseService;
@Autowired
private ProductRepo productRepo;


@Test
void testPurchaseSuccessful() {
    Integer userId = 1;
    String accountNumber = "123456";
    List<Product> productArray = productRepo.findAll();
    ResponseEntity<ReturnResponse> result = purchaseService.purchase(accountNumber, userId, productArray);
    assertEquals(HttpStatus.OK, result.getStatusCode());

}

}

