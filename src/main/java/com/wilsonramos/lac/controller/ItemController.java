package com.wilsonramos.lac.controller;

import com.wilsonramos.lac.dto.ItemDTO;
import com.wilsonramos.lac.service.IItemService;
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

@RestController()
@RequestMapping("item")
public class ItemController {
    
    @Autowired
    private IItemService itemService;
    
    @PostMapping
    public ResponseEntity save(@RequestBody ItemDTO itemDTO) throws Exception {
        itemService.save(itemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(itemService.findByid(id));
    }
    
    @PostMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody ItemDTO itemDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(itemService.update(id, itemDTO));
    }
    
    @GetMapping()
    public ResponseEntity getAll() throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(itemService.findAll());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception{
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    
}
