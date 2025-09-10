package com.abc.app.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @NativeQuery("SELECT * FROM ElectronicsProduct WHERE name = :pName")
    Collection<ElectronicsProduct> serachByName(@Param("pName") String name);

    @Query("select p from ElectronicsProduct p where p.name = :productName or p.description = :description")
    ElectronicsProduct findByNameOrDescription(@Param("description") String desc,
                                               @Param("productName") String name);

    Collection<ElectronicsProduct> findByNameContaining(String name);// search for substring name : wraps %name%
    // JPQL

    // SELECT product FROM Product product WHERE product.name like % ?1 % ORDER By product.price ASC
    Collection<ElectronicsProduct> findByNameContainingOrderByPriceDesc(String name);// search for substring name : wraps %name%
    // 2. Custom query by @Query

    @Query("SELECT product FROM ElectronicsProduct product WHERE product.name like %?1% ORDER By product.price ASC")
    Collection<ElectronicsProduct> serachByNameContainingOrderByPriceAsc(String name);// search for substring name : wraps %name%

    Collection<ElectronicsProduct> findByNameContainingIgnoreCaseOrderByPriceDesc(String name);

    // update & delete queries

    @Modifying
    @Query("DELETE FROM ElectronicsProduct ep WHERE ep.id = :pid")
    void deleteProductById(@Param("pid") Integer id);



}
// ProductDao IS-A JpaRepository