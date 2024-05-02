package onlinestore.onlinestore.dto;

import java.math.BigDecimal;

public record SelectOrderResponse(Long id, Long orderıd, Long prdocutId, int quantity, BigDecimal totalPrice) {
}
