package onlinestore.onlinestore.dto;

import java.util.List;

public record OrderDTO(Long id, Long costumerId, List<OrderItemDto> orderItems) {
}
