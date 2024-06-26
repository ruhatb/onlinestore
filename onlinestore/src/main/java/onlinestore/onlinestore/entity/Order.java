package onlinestore.onlinestore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order" , schema = "onlinestore")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Long costumerId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<SelectOrder> orderItems = new ArrayList<>();

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
