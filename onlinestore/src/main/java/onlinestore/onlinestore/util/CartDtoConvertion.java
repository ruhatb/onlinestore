package onlinestore.onlinestore.util;

import onlinestore.onlinestore.dto.CartResponse;
import onlinestore.onlinestore.entity.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartDtoConvertion {

    public static List<CartResponse> convertCartList(List<Cart> cartList) {
        return cartList.stream()
                .map(cart -> new CartResponse(cart.getCartNo(), cart.getCostumer().getId()))
                .collect(Collectors.toList());
    }

    public static CartResponse convertCart(Cart cart) {
        return new CartResponse(cart.getCartNo(), cart.getCostumer().getId());
    }
}
