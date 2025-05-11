package com.flipkart.ecommerce.services;

import com.flipkart.ecommerce.kafka.Producer;
import com.flipkart.ecommerce.model.Product;
import com.flipkart.ecommerce.model.Purchase;
import com.flipkart.ecommerce.model.User;
import com.flipkart.ecommerce.repository.ProductRepo;
import com.flipkart.ecommerce.repository.PurchaseRepo;
import com.flipkart.ecommerce.repository.UserRepo;
import com.flipkart.ecommerce.responce.ReturnResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseService {
@Autowired
ProductRepo productRepo;
@Autowired
PurchaseRepo purchaseRepo;
@Autowired
UserRepo userRepo;
@Autowired
Producer producer;
public ResponseEntity<ReturnResponse> purchase(String accountNumber, Integer userId, List<Product> productArray) {
User user = userRepo.findByUserId(userId);
List<Purchase> purchaseDetail = new ArrayList<Purchase>();
for (int i = 0; i < productArray.size(); i++) {
Product purchaseProduct = productArray.get(i);
double totalPrice = purchaseProduct.getQuantity() * purchaseProduct.getPrice();
// connect from transaction service
Purchase purchase = new Purchase();
purchase.setAmount(totalPrice);
purchase.setProduct(purchaseProduct);
purchase.setUser(user);
purchase.setTime(LocalDate.now());
purchaseDetail.add(purchase);
}

purchaseRepo.saveAll(purchaseDetail);
pushMessage(userId,productArray);
ReturnResponse returnResponse = new ReturnResponse();
returnResponse.setStatusCode(200);
returnResponse.setStatusMessage("Purchase successful");
returnResponse.setData(purchaseDetail);
return ResponseEntity.ok(returnResponse);
}

private void pushMessage(Integer userId, List<Product> productArray){
Map<String, Object> map = new HashMap<>();
map.put("userId", userId);
map.put("products", productArray);
producer.sendMessage(map.toString());
}
}

