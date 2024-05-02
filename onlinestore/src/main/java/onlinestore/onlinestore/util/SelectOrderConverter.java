package onlinestore.onlinestore.util;

import onlinestore.onlinestore.dto.SelectOrderDTO;
import onlinestore.onlinestore.dto.SelectOrderResponse;
import onlinestore.onlinestore.entity.Order;
import onlinestore.onlinestore.entity.Product;
import onlinestore.onlinestore.entity.SelectOrder;

public class SelectOrderConverter {
    public static SelectOrderDTO convertToDto(SelectOrder selectOrder) {
        return new SelectOrderDTO(
                selectOrder.getId(),
                selectOrder.getOrder().getId(),
                selectOrder.getProduct().getId(),
                selectOrder.getQuantity(),
                selectOrder.getTagPrice());
    }

    public static SelectOrderResponse convertToResponse(SelectOrder selectOrder) {
        return new SelectOrderResponse(
                selectOrder.getId(),
                selectOrder.getOrder().getId(),
                selectOrder.getProduct().getId(),
                selectOrder.getQuantity(),
                selectOrder.getTagPrice()
        );
    }

    public static SelectOrder convertToEntity(SelectOrderDTO selectOrderDTO) {
        SelectOrder selectOrder = new SelectOrder();
        Order order = new Order();
        order.setId(selectOrderDTO.id());
        Product product = new Product();
        product.setId(selectOrderDTO.productId());
        selectOrder.setOrder(order);
        selectOrder.setProduct(product);
        selectOrder.setQuantity(selectOrderDTO.quantity());
        selectOrder.setTagPrice(selectOrderDTO.totalPrice());
        return selectOrder;
    }
}