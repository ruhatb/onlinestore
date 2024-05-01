package onlinestore.onlinestore.dto;

import java.math.BigDecimal;

public record CartDTO(Long cartNo, String customer, BigDecimal totalPrice) {
}
