package onlinestore.onlinestore.service;

import jakarta.persistence.EntityNotFoundException;
import onlinestore.onlinestore.dto.SelectOrderDTO;
import onlinestore.onlinestore.dto.SelectOrderResponse;

import onlinestore.onlinestore.entity.SelectOrder;
import onlinestore.onlinestore.repository.SelectOrderRepository;
import onlinestore.onlinestore.util.SelectOrderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
    public class SelectOrderServiceImp implements SelectOrderService {

        private final SelectOrderRepository selectOrderRepository;


        @Autowired
        public SelectOrderServiceImp(SelectOrderRepository selectOrderRepository, SelectOrderConverter selectOrderConverter) {
            this.selectOrderRepository = selectOrderRepository;

        }

    @Override
    public SelectOrderResponse createSelectOrder(SelectOrderDTO selectOrderDTO) {
        SelectOrder selectOrder = SelectOrderConverter.convertToEntity(selectOrderDTO);
        SelectOrder savedSelectOrder = selectOrderRepository.save(selectOrder);
        return SelectOrderConverter.convertToResponse(savedSelectOrder);
    }

        @Override
        public SelectOrderResponse updateSelectOrder(Long id, SelectOrderDTO selectOrderDTO) {
            SelectOrder updateSelectOrder = selectOrderRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("SelectOrder not found : " + id));


            updateSelectOrder.setQuantity(selectOrderDTO.quantity());
            updateSelectOrder.setTagPrice(selectOrderDTO.totalPrice());

            SelectOrder savedSelectOrder = selectOrderRepository.save(updateSelectOrder);
            return SelectOrderConverter.convertToResponse(savedSelectOrder);
        }

    @Override
    public List<SelectOrderDTO> getAllSelectOrder() {
        List<SelectOrder> selectOrders = selectOrderRepository.findAll();
        return selectOrders.stream()
                .map(SelectOrderConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
        public void deleteSelectOrder(Long id) {
            selectOrderRepository.deleteById(id);
        }
    }

