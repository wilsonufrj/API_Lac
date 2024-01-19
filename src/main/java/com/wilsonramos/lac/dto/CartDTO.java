package com.wilsonramos.lac.dto;

import com.wilsonramos.lac.domain.MarketList;
import lombok.*;

/**
 *
 * @author wilsonramos
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO{

    private Long id;

    private String name;

    private MarketList market_list;
}
