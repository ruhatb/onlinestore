package onlinestore.onlinestore.controller;


import onlinestore.onlinestore.dto.CostumerDTO;
import onlinestore.onlinestore.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumers")
public class CostumerController {

    private final CostumerService costumerService;

    @Autowired
    public CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @PostMapping
    public ResponseEntity<CostumerDTO> addCostumer(@RequestBody CostumerDTO costumerDTO) {
        CostumerDTO createdCostumer = costumerService.addCostumer(costumerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCostumer);
    }

    @GetMapping("/{costumerId}")

    public ResponseEntity<CostumerDTO> getCostumerById(@PathVariable Long costumerId) {
        CostumerDTO costumerDTO = costumerService.getCostumerById(costumerId);
        return ResponseEntity.ok(costumerDTO);
    }

    @GetMapping
    public ResponseEntity<List<CostumerDTO>> getAllCustomers() {
        List<CostumerDTO> costumerDTOList = costumerService.getAllCostumers();
        return ResponseEntity.ok(costumerDTOList);
    }

}
