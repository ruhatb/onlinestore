package onlinestore.onlinestore.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "costumer" , schema = "onlinestore")
public class Costumer extends BaseEntity {

    @Column(name = "name")
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costumer")
    private List<Cart> cartList = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costumer")
    private List<Order> orderList = new ArrayList<>();

}
