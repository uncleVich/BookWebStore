package webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstore.domain.Product;
import webstore.repository.ProductRepository;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    public void updateAllStock() {
        List<Product> allProducts =
                productRepository.getAllProducts();
        for (Product product: allProducts) {
            if (product.getUnitsInStock()<500)
            productRepository.updateStock(product.getProductId(),
                    product.getUnitsInStock()+1000);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> result = productRepository.getAllProducts();
        return result;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public Product getProductById(String productID) {
        return productRepository.getProductById(productID);
    }
}
