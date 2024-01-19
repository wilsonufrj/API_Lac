package com.wilsonramos.lac.service;

import com.wilsonramos.lac.dto.CartDTO;
import java.util.List;

/**
 *
 * @author wilsonramos
 */
public interface ICartService {
    void save(CartDTO cartDTO) throws Exception;
    
    CartDTO update(Long id,CartDTO cartDTO) throws Exception;
    
    void delete(Long id);
    
    CartDTO findByid(Long id) throws Exception;
    
    List<CartDTO> findAll() throws Exception;
}
