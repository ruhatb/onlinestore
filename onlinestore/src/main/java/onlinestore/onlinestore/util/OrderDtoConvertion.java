package onlinestore.onlinestore.util;


import onlinestore.onlinestore.dto.OrderResponse;
import onlinestore.onlinestore.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDtoConvertion {

        public static List<OrderResponse> convertOrderList(List<Order> orderList) {
            return orderList.stream()
                    .map(OrderDtoConvertion::convertOrder)
                    .collect(Collectors.toList());
        }


    public static OrderResponse convertOrder(Order order) {
        return new OrderResponse(order.getId(), order.getCostumer().getId());
    }

    }