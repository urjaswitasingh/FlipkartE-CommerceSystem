package com.flipkart.ecommerce.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnResponse<T> {
private int statusCode;
private String statusMessage;
private T data;
}


