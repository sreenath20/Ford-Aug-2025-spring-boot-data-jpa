package com.abc.app.product;

import java.util.Collection;

public interface ProductService {

    ElectronicsProduct addNewProduct(ElectronicsProduct newProduct) throws ProductException;

    ElectronicsProduct getProductById(Integer id) throws ProductException;

    ElectronicsProduct updateProductPriceById(Integer id, Double price) throws ProductException;

    Collection<ElectronicsProduct> getAllProducts() throws ProductException;


    Collection<ElectronicsProduct> getAllProductsByName(String name) throws ProductException;

    ElectronicsProduct deleteProductById(Integer id)throws ProductException ;
}
