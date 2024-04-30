package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.CostumerDTO;

import java.util.List;

public interface CostumerService {

    CostumerDTO addCostumer(CostumerDTO costumerDTO);
    CostumerDTO getCostumerById(Long costumerId);



    List<CostumerDTO> getAllCostumers();
}
