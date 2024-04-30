package onlinestore.onlinestore.service;


import onlinestore.onlinestore.dto.CostumerDTO;
import onlinestore.onlinestore.entity.Costumer;
import onlinestore.onlinestore.exceptions.CostumerNotException;
import onlinestore.onlinestore.repository.CostumerRepository;
import onlinestore.onlinestore.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostumerServiceImp implements CostumerService {


    private final CostumerRepository costumerRepository;

    @Autowired
    public CostumerServiceImp(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;


    }

    @Override
    public CostumerDTO addCostumer(CostumerDTO costumerDTO) {
        Costumer costumer = new Costumer();
        costumer.setName(costumerDTO.name());
        Costumer savedCostumer = costumerRepository.save(costumer);
        return Converter.convertToDto(savedCostumer);
    }

    @Override
    public CostumerDTO getCostumerById(Long costumerId) {
        Costumer costumer = costumerRepository.findById(costumerId).orElseThrow(() -> new CostumerNotException("Customer not found with id: " + costumerId));
        return Converter.convertToDto(costumer);
    }



    @Override
    public List<CostumerDTO> getAllCostumers() {
        List<Costumer> customers = costumerRepository.findAll();
        return customers.stream().map(Converter::convertToDto).collect(Collectors.toList());
    }
}
