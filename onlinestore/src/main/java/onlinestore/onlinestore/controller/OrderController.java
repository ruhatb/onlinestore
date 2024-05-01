package onlinestore.onlinestore.controller;

import onlinestore.onlinestore.dto.OrderDTO;
import onlinestore.onlinestore.dto.OrderResponse;
import onlinestore.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderDTO orderDTO) {
        OrderResponse orderResponse = orderService.placeOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }

    @GetMapping("/{orderCode}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderCode) {
        OrderDTO orderDTO = orderService.getOrderById(orderCode);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getAllOrdersForCustomer(@PathVariable Long customerId) {
        List<OrderDTO> orderDTOList = orderService.getAllOrdersForCustomer(customerId);
        return ResponseEntity.ok(orderDTOList);
    }
}
