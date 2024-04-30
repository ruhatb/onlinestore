package onlinestore.onlinestore.util;

import onlinestore.onlinestore.dto.OrderDTO;
import onlinestore.onlinestore.dto.OrderResponse;
import onlinestore.onlinestore.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static OrderDTO convertToDto(Order order) {
        return new OrderDTO(order.getId(), order.getCostumerId(), order.getTotalPrice());
    }

    public static OrderResponse convertToResponse(Order order) {
        return new OrderResponse(order.getId(), order.getCostumerId());
    }

    public static List<OrderDTO> convertToDtoList(List<Order> orders) {
        return orders.stream().map(Converter::convertToDto).collect(Collectors.toList());
    }
}