# 🛒 Flipkart E-Commerce System (Kafka-Enabled Microservice Architecture)

## 📘 Project Description

The **Flipkart E-Commerce System** is a Spring Boot-based RESTful application designed to simulate product purchases and notify downstream services (like Delivery) using **Apache Kafka**. 

This microservice acts as a **Kafka Producer** that:
- Accepts product purchase requests
- Calculates the transaction amount
- Saves purchase details
- Sends purchase events to a Kafka topic (`notification`) for real-time communication with other services (e.g., delivery, billing).

---

## 🚀 Key Features

### 📦 Purchase Service (Producer):
- Accepts purchase requests from users
- Calculates total price based on product quantity and unit price
- Saves purchase details to the database
- Sends purchase information asynchronously via Kafka

### 🔁 Kafka Integration:
- Serializes user ID and product list into a structured string
- Publishes messages to the `notification` topic
- Enables downstream consumers (like delivery services) to listen and act on purchase events

---

## ✅ System Validations

- Ensures a valid user exists before processing a purchase
- Handles multiple products in a single transaction
- Accurately computes total cost per product
- Sends a clean, structured message to Kafka after transaction is completed
- Handles persistence of transaction data reliably

---

## 🛠 Technologies Used

- **Java 17** – Core language
- **Spring Boot** – REST API and application framework
- **Spring Data JPA** – ORM for interacting with the database
- **Apache Kafka** – Messaging queue for real-time communication
- **PostgreSQL / H2** – Database for users, products, and purchases
- **KafkaTemplate** – To produce messages
- **Lombok (optional)** – Reduces boilerplate in model classes

---

## ⚙️ Core Logic

### Purchase Flow:

1. `purchase(String accountNumber, Integer userId, List<Product> productArray)` is called.
2. Validates the user.
3. For each product:
   - Calculates total amount (`quantity * price`)
   - Creates a `Purchase` record
4. Saves all purchases using `purchaseRepo.saveAll(...)`
5. Sends a message with `userId` and `productArray` to Kafka via `pushMessage(...)`
6. Returns a `ReturnResponse` with the purchase data.

---

## 📦 Kafka Message Example

The following structure is sent to the Kafka topic `notification`:

```json
{
  "userId": 101,
  "products": [
    {
      "productId": 1,
      "name": "Wireless Mouse",
      "quantity": 2,
      "price": 499.99
    },
    {
      "productId": 2,
      "name": "USB-C Charger",
      "quantity": 1,
      "price": 999.00
    }
  ]
}
