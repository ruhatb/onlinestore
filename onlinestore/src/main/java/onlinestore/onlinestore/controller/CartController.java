package onlinestore.onlinestore.controller;

import onlinestore.onlinestore.dto.CartDTO;
import onlinestore.onlinestore.dto.CartResponse;
import onlinestore.onlinestore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable Long cartId) {
        CartResponse cartResponse = cartService.getCartById(cartId);
        return ResponseEntity.ok(cartResponse);
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<CartResponse> updateCart(@PathVariable Long cartId, @RequestBody CartDTO cartDTO) {
        CartResponse updatedCart = cartService.updateCart(cartId, cartDTO);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> emptyCart(@PathVariable Long cartId) {
        cartService.emptyCart(cartId);
        return ResponseEntity.noContent().build();
    }

}