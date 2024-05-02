package onlinestore.onlinestore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class SelectOrder extends BaseEntity{


    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
    private int quantity;
    private BigDecimal tagPrice;
}
