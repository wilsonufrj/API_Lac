package com.wilsonramos.lac.dto;

import com.wilsonramos.lac.domain.Cart;
import lombok.*;

/**
 *
 * @author wilsonramos
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    
    private Long id;
    
    private String name;
    
    private float quantity;
    
    private String unit_measurement;
    
    private float price;

    private Cart cart;

    

}
