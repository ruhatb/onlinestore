package onlinestore.onlinestore.repository;

import onlinestore.onlinestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
