package com.wilsonramos.lac.dto;

import com.wilsonramos.lac.domain.Cart;
import java.util.List;

import lombok.*;

/**
 *
 * @author wilsonramos
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketListDTO {

    private Long id;

    private String name;

    private String description;

    private List<Cart> carts;
    
    
}
