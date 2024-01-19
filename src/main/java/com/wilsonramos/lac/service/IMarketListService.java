package com.wilsonramos.lac.service;

import com.wilsonramos.lac.dto.MarketListDTO;
import java.util.List;

/**
 *
 * @author wilsonramos
 */
public interface IMarketListService {
    void save(MarketListDTO marketListDTO) throws Exception;
    
    MarketListDTO update(Long id,MarketListDTO marketListDTO) throws Exception;
    
    void delete(Long id);
    
    MarketListDTO findByid(Long id) throws Exception;
    
    List<MarketListDTO> findAll();
}
