package com.bowang.service.impl;

import com.bowang.dao.IProductDao;
import com.bowang.domain.Product;
import com.bowang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("iProductService")
@Transactional
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductDao iProductDao;


    @Override
    public List<Product> findAll() throws Exception {
        return iProductDao.findAll();
    }
}
