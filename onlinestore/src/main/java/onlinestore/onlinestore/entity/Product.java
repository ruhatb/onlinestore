package onlinestore.onlinestore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product" ,schema = "onlinestore" )
public class Product extends  BaseEntity{



    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Long stock;
}
