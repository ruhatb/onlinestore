package onlinestore.onlinestore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseEntity {

    @Column(name = "cart_no")
    private Long cartNo;

    @ManyToOne
    private Costumer costumer;

    @OneToMany(mappedBy = "cart")
    private List<SelectCart> selectCarts;

    public Costumer getCustomer() {
        return this.costumer;

    }

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
