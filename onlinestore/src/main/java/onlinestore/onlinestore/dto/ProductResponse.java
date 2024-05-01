package onlinestore.onlinestore.dto;

import java.math.BigDecimal;

public record ProductResponse(String name, BigDecimal price, Long stock) {
}
