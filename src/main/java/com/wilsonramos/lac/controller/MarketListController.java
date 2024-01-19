package com.wilsonramos.lac.controller;

import com.wilsonramos.lac.dto.MarketListDTO;
import com.wilsonramos.lac.service.IMarketListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("marketlist")
public class MarketListController {

    @Autowired
    private IMarketListService marketListService;

    @PostMapping
    public ResponseEntity save(@RequestBody MarketListDTO marketListDTO) throws Exception {
        marketListService.save(marketListDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(marketListService.findByid(id));
    }
    
    @PostMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody MarketListDTO marketListDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(marketListService.update(id, marketListDTO));
    }
    
    @GetMapping()
    public ResponseEntity getAll() throws Exception{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(marketListService.findAll());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception{
        marketListService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
            
}
