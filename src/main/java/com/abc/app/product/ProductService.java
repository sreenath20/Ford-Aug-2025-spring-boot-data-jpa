package com.abc.app.product;

import java.util.Collection;

public interface ProductService {

    Product addNewProduct(Product newProduct) throws ProductException;

    Product getProductById(Integer id) throws ProductException;

    Product updateProductPriceById(Integer id, Double price) throws ProductException;

    Collection<Product> getAllProducts() throws ProductException;


}
