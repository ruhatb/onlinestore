package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.CartDTO;
import onlinestore.onlinestore.dto.CartResponse;
import onlinestore.onlinestore.entity.Cart;


import onlinestore.onlinestore.exceptions.EntyNotFoundException;
import onlinestore.onlinestore.repository.CartRepository;
import onlinestore.onlinestore.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImp implements CartService {


    private final CartRepository cartRepository;
    @Autowired
    public CartServiceImp(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartResponse getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntyNotFoundException("Cart not found with id: " + cartId));
        return Converter.convertToCartResponse(cart);
    }

    @Override
    public CartResponse updateCart(Long cartId, CartDTO cartDTO) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntyNotFoundException("Cart not found with id: " + cartId));


        cart.getCustomer().setName(cartDTO.customer());


        cart.setTotalPrice(cartDTO.totalPrice());


        Cart savedCart = cartRepository.save(cart);
        return Converter.convertToCartResponse(savedCart) ;
    }

    @Override
    public void emptyCart(Long cartId) {

    }
}
