package onlinestore.onlinestore.service;

import jakarta.persistence.EntityNotFoundException;
import onlinestore.onlinestore.dto.ProductResponse;
import onlinestore.onlinestore.entity.Product;
import onlinestore.onlinestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }


    @Override
    public Product createProduct(ProductResponse response) {
        Product product = new Product();
        product.setName(response.name());
        product.setPrice(response.price());
        product.setStock(response.stock());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductResponse response) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found  id: " + id));

        existingProduct.setName(response.name());
        existingProduct.setPrice(response.price());
        existingProduct.setStock(response.stock());

        return productRepository.save(existingProduct);
    }


    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found  id: " + id));
        productRepository.delete(product);
    }
}
