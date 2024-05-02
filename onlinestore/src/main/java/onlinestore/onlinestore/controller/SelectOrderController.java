package onlinestore.onlinestore.controller;

import onlinestore.onlinestore.dto.SelectOrderDTO;
import onlinestore.onlinestore.dto.SelectOrderResponse;
import onlinestore.onlinestore.service.SelectOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selectOrder")
public class SelectOrderController {

    private final SelectOrderService selectOrderService;

    public SelectOrderController(SelectOrderService selectOrderService) {
        this.selectOrderService = selectOrderService;
    }


    @PostMapping
    public SelectOrderResponse createSelectOrder(@RequestBody SelectOrderDTO selectOrderDTO) {
        return selectOrderService.createSelectOrder(selectOrderDTO);
    }


    @PutMapping("/{id}")
    public SelectOrderResponse updateSelectOrder(@PathVariable("id") Long id, @RequestBody SelectOrderDTO selectOrderDTO) {
        return selectOrderService.updateSelectOrder(id, selectOrderDTO);
    }

    @GetMapping
    public List<SelectOrderDTO> getAllSelectOrders() {
        return selectOrderService.getAllSelectOrder();
    }

    @DeleteMapping("/{id}")
    public void deleteSelectOrder(@PathVariable("id") Long id) {
        selectOrderService.deleteSelectOrder(id);
    }
}