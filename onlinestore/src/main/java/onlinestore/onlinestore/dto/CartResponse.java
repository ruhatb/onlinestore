package onlinestore.onlinestore.dto;

import java.math.BigDecimal;

public record CartResponse(Long cartNo, Long costumerId, BigDecimal totalPrice){

}