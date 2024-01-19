package com.wilsonramos.lac.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import lombok.*;

/**
 *
 * @author wilsonramos
 */
@Entity
@Table(name = "market_list")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MarketList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name = "name")
    private String name;

 
    @Column(name = "description")
    private String description;
    
    @OneToMany(
            mappedBy = "market_list",
            targetEntity = Cart.class,
            cascade = CascadeType.ALL
    )
    private List<Cart> carts;

}
