package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(OrderDTO orderDTO);
    OrderDTO getOrderForCode(String orderCode);
    List<OrderDTO> getAllOrdersForCustomer(Long customerId);
}