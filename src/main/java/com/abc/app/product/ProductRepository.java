package com.abc.app.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

//@Repository
public interface ProductRepository extends JpaRepository<ElectronicsProduct, Integer> {

    // Custom JPQL queries
    //1. named Query
    // JPQL will be written looking at method name
    // SELECT product FROM Product product WHERE product.name = ?1
    // its Multi object Query so return type must be collection
    Collection<ElectronicsProduct> findByName(String name);
    Collection<ElectronicsProduct> findByNameContaining(String name);// search for substring name : wraps %name%
    // JPQL

    // SELECT product FROM Product product WHERE product.name like % ?1 % ORDER By product.price ASC
    Collection<ElectronicsProduct> findByNameContainingOrderByPriceDesc(String name);// search for substring name : wraps %name%
   // 2. Custom query by @Query

    @Query("SELECT product FROM ElectronicsProduct product WHERE product.name like %?1% ORDER By product.price ASC")
    Collection<ElectronicsProduct> serachByNameContainingOrderByPriceAsc(String name);// search for substring name : wraps %name%

    Collection<ElectronicsProduct> findByNameContainingIgnoreCaseOrderByPriceDesc(String name);
}
// ProductDao IS-A JpaRepository