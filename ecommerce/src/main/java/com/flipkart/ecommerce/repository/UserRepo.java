package com.flipkart.ecommerce.repository;

import com.flipkart.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
User findByUserId(Integer userId);
}
