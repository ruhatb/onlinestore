package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.ProductResponse;
import onlinestore.onlinestore.entity.Product;

public interface ProductService {
    Product getProductById(Long id);
    Product createProduct(ProductResponse response);
    Product updateProduct(Long id, ProductResponse response);
    void deleteProduct(Long id);
}
