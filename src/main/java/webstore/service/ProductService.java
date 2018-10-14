package webstore.service;

import webstore.domain.Product;

import java.util.List;

public interface ProductService {
    void updateAllStock();
    List<Product> getAllProducts();
}
