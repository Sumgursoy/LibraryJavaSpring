package com.acunmedya_jvrfs1.Library.Service.dtos;

import lombok.Data;

@Data
public class ProductEntityRequest {
    private String name;
    private double price;
    private int stock;
} 