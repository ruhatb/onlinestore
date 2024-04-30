package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.CartResponse;

import java.util.List;

public interface CartService {
    List<CartResponse> findAll();
}
