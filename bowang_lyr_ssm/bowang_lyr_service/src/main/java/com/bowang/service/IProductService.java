package com.bowang.service;

import com.bowang.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll() throws Exception;
}
