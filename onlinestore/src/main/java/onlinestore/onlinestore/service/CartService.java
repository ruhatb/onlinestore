package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.CartDTO;
import onlinestore.onlinestore.dto.CartResponse;

import java.util.List;

public interface CartService {
    CartResponse getCartById(Long cartId);
    CartResponse updateCart(Long cartId, CartDTO cartDTO);
    void emptyCart(Long cartId);
}
