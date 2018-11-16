package webstore.repository;

import webstore.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {

    List<Product> getAllProducts();
    void updateStock(String productId, long noOfUnits);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    Product getProductById(String productID);
    List<Product> getProductsByManyParams(String productCategory, Map<String, List<String>> filterParams,
                                          String productBrand);
}
