package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.CartResponse;
import onlinestore.onlinestore.entity.Cart;
import onlinestore.onlinestore.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImp implements CartService {

    private CartRepository cartRepository;
    @Override
    public List<CartResponse> findAll() {
        List<Cart> cartList = cartRepository.findAll();
        return cartList.stream()
                .map(this::convertToCartResponse)
                .collect(Collectors.toList());
    }

    private CartResponse convertToCartResponse(Cart cart) {
        return new CartResponse(cart.getCartNo(), cart.getCostumer().getId());
    }
}
