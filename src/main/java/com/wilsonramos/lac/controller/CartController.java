package com.wilsonramos.lac.controller;

import com.wilsonramos.lac.dto.CartDTO;
import com.wilsonramos.lac.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilsonramos
 */
@RestController
@RequestMapping("cart")
public class CartController {
    
    @Autowired
    private ICartService cartService;
    
    @PostMapping
    public ResponseEntity save(@RequestBody CartDTO cartDTO) throws Exception {
        cartService.save(cartDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.findByid(id));
    }
    
    @PostMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody CartDTO cartDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.update(id, cartDTO));
    }
    
    @GetMapping()
    public ResponseEntity getAll() throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.findAll());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception{
        cartService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
