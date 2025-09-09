package com.abc.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final double pi = 3.145;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        //   pi =3.3;

    }

    @Override
    public Product addNewProduct(Product newProduct) throws ProductException {
        // this.productDao = productDao;
        return null;
    }

    @Override
    public Product getProductById(Integer id) throws ProductException {
        return null;
    }

    @Override
    public Product updateProductPriceById(Integer id, Double price) throws ProductException {
        return null;
    }

    @Override
    public Collection<Product> getAllProducts() throws ProductException {
        return List.of();
    }
}
