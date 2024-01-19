package com.wilsonramos.lac.serviceImp;

import com.wilsonramos.lac.converter.Converter;
import com.wilsonramos.lac.domain.Cart;
import com.wilsonramos.lac.dto.CartDTO;
import com.wilsonramos.lac.repository.ICartRepository;
import com.wilsonramos.lac.service.ICartService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author wilsonramos
 */
public class CartService implements ICartService {

    @Autowired
    private Converter converter;

    @Autowired
    private ICartRepository cartRepository;

    @Override
    public void save(CartDTO cartDTO) throws Exception {
        Cart cart = converter.convert(cartDTO, Cart.class);
        cartRepository.save(cart);
    }

    @Override
    public CartDTO update(Long id, CartDTO cartDTO) throws Exception {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new Exception("Cart not found"));

        cart.setName(cartDTO.getName());
        cart.setMarket_list(cartDTO.getMarket_list());

        return converter.convert(cart, CartDTO.class);
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public CartDTO findByid(Long id) throws Exception {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new Exception("Cart not found"));
        return converter.convert(cart, CartDTO.class);
    }

    @Override
    public List<CartDTO> findAll() throws Exception {
        return cartRepository.findAll()
                .stream()
                .map(cart -> {
                    try {
                        return converter.convert(cart, CartDTO.class);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());
    }

}
