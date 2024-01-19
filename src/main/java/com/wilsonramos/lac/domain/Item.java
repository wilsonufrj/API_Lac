package com.wilsonramos.lac.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author wilsonramos
 */
@Entity
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "quantity")
    private float quantity;
    
    @Column(name = "unit_measurement")
    private String unit_measurement;
    
    @Column(name = "price")
    private float price;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cart", referencedColumnName = "id")
    @JsonBackReference
    private Cart cart;
}
