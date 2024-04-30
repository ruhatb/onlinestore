package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.OrderDTO;
import onlinestore.onlinestore.dto.OrderResponse;
import onlinestore.onlinestore.entity.Order;
import onlinestore.onlinestore.exceptions.NotFoundExceptions;
import onlinestore.onlinestore.repository.OrderRepository;
import onlinestore.onlinestore.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderResponse placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCostumerId(orderDTO.costumerId());
        order.setTotalPrice(orderDTO.totalPrice());
        Order savedOrder = orderRepository.save(order);

        return Converter.convertToResponse(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long orderCode) {
        Order order = orderRepository.findById(orderCode).orElse(null);
        if (order != null) {
            return Converter.convertToDto(order);
        } else {
            throw new NoSuchElementException("Order not found with id: " + orderCode);
        }
    }

    @Override
    public List<OrderDTO> getAllOrdersForCustomer(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        if (orders.isEmpty()) {
            throw new NotFoundExceptions("No orders found: " + customerId);
        } else {
            return orders.stream().map(Converter::convertToDto).collect(Collectors.toList());
        }
    }

}
