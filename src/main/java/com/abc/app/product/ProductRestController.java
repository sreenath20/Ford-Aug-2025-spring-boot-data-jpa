package com.abc.app.product;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ElectronicsProduct addNewProduct(@Valid @RequestBody ElectronicsProduct newProduct) throws ProductException {
        return this.productService.addNewProduct(newProduct);
    }

    @GetMapping("/{id}")
    public ElectronicsProduct getProductById(@PathVariable Integer id) throws ProductException {
        return this.productService.getProductById(id);
    }

    @PatchMapping
    public ElectronicsProduct updateProduct(@RequestBody ElectronicsProduct product) throws ProductException {
        return this.productService.updateProductPriceById(product.getId(), product.getPrice());
    }

    @GetMapping("/all")
    public Collection<ElectronicsProduct> getAllProducts() throws ProductException {
        return this.productService.getAllProducts();
    }

    @GetMapping("/name/{name}")
    public Collection<ElectronicsProduct> getAllProductsByName(@PathVariable String name) throws ProductException {
        return this.productService.getAllProductsByName(name);
    }

    @DeleteMapping("/{id}")
    public ElectronicsProduct deleteProductById(@PathVariable Integer id) throws ProductException {
        return this.productService.deleteProductById(id);
    }


}
