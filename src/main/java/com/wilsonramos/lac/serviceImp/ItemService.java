package com.wilsonramos.lac.serviceImp;

import com.wilsonramos.lac.converter.Converter;
import com.wilsonramos.lac.domain.Item;
import com.wilsonramos.lac.dto.ItemDTO;
import com.wilsonramos.lac.repository.IItemRepository;
import com.wilsonramos.lac.service.IItemService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author wilsonramos
 */
public class ItemService implements IItemService {

    @Autowired
    private Converter converter;

    private IItemRepository itemRepository;

    @Override
    public void save(ItemDTO itemDTO) throws Exception {
        Item item = converter.convert(itemDTO, Item.class);
        itemRepository.save(item);

    }

    @Override
    public ItemDTO update(Long id, ItemDTO itemDTO) throws Exception {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new Exception("Item not found"));
        
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(itemDTO.getQuantity());
        item.setUnit_measurement(itemDTO.getUnit_measurement());
        item.setCart(itemDTO.getCart());
        
        return converter.convert(item, ItemDTO.class);
        
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDTO findByid(Long id) throws Exception {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new Exception("Item not found"));

        return converter.convert(item, ItemDTO.class);

    }

    @Override
    public List<ItemDTO> findAll() throws Exception {
        return itemRepository.findAll()
                .stream()
                .map(item -> {
                    try {
                        return converter.convert(item, ItemDTO.class);
                    } catch (Exception ex) {
                        throw new RuntimeException();
                    }
                })
                .collect(Collectors.toList());

    }

}
