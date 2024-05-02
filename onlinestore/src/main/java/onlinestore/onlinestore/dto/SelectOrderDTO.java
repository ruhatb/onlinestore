package onlinestore.onlinestore.dto;

import java.math.BigDecimal;

public record SelectOrderDTO(Long id, Long orderId, Long productId, int quantity, BigDecimal totalPrice) {
}