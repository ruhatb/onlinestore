package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.OrderDTO;
import onlinestore.onlinestore.dto.OrderResponse;
import onlinestore.onlinestore.entity.Order;
import onlinestore.onlinestore.repository.OrderRepository;
import onlinestore.onlinestore.util.OrderDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {

        Order order = OrderDtoConvertion.convertOrder(OrderDTO orderDTO);


        Order savedOrder = orderRepository.save(order);


        OrderResponse  orderResponse = OrderDtoConvertion.convertOrder(savedOrder);


        return OrderDtoConvertion.convertOrder(orderResponse);
    }
    @Override
    public OrderDTO getOrderForCode(String orderCode) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrdersForCustomer(Long customerId) {
        return null;
    }
}

    @Override
    public OrderDTO getOrderForCode(String orderCode) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrdersForCustomer(Long customerId) {
        return null;
    }
}
