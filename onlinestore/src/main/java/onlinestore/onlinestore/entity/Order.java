package onlinestore.onlinestore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order" , schema = "onlinestore")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Costumer costumer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<SelectOrder> orderItems = new ArrayList<>();
}
