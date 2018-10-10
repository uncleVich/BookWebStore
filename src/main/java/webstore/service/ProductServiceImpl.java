package webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstore.domain.Product;
import webstore.repository.ProductRepository;

import java.util.List;

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
}
