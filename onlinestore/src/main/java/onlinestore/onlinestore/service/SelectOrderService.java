package onlinestore.onlinestore.service;

import onlinestore.onlinestore.dto.SelectOrderDTO;
import onlinestore.onlinestore.dto.SelectOrderResponse;

import java.util.List;

public interface SelectOrderService {

    SelectOrderResponse createSelectOrder(SelectOrderDTO selectOrderDTO);
    SelectOrderResponse updateSelectOrder(Long id, SelectOrderDTO selectOrderDTO);
    List<SelectOrderDTO> getAllSelectOrder();
   void deleteSelectOrder(Long id);

}
