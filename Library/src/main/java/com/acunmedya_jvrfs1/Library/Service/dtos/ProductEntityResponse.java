package com.acunmedya_jvrfs1.Library.Service.dtos;

import lombok.Data;

@Data
public class ProductEntityResponse {
    private int id;
    private String name;
    private double price;
    private int stock;
} 