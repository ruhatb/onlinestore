package onlinestore.onlinestore.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderDTO(Long id, Long costumerId, BigDecimal totalPrice)
{
}
