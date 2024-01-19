package com.wilsonramos.lac.service;

import com.wilsonramos.lac.dto.ItemDTO;
import java.util.List;

/**
 *
 * @author wilsonramos
 */
public interface IItemService {
    void save(ItemDTO itemDTO) throws Exception;
    
    ItemDTO update(Long id,ItemDTO itemDTO) throws Exception;
    
    void delete(Long id);
    
    ItemDTO findByid(Long id) throws Exception;
    
    List<ItemDTO> findAll() throws Exception;
}
