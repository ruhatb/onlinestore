package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.OrderDTO;
import onlinestore.onlinestore.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse placeOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(Long orderCode);
    List<OrderDTO> getAllOrdersForCustomer(Long customerId);
}