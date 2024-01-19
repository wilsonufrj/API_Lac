package com.wilsonramos.lac.serviceImp;

import com.wilsonramos.lac.converter.Converter;
import com.wilsonramos.lac.domain.MarketList;
import com.wilsonramos.lac.dto.MarketListDTO;
import com.wilsonramos.lac.repository.IMarketListRepository;
import com.wilsonramos.lac.service.IMarketListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author wilsonramos
 */
@Service
public class MarketListService implements IMarketListService{

    @Autowired
    private Converter converter;

    @Autowired
    private IMarketListRepository marketListRepository;
    @Override
    public void save(MarketListDTO marketListDTO) throws Exception{
        MarketList marketList = converter.convert(marketListDTO, MarketList.class);
        marketListRepository.save(marketList);
    }

    @Override
    public MarketListDTO update(Long id, MarketListDTO marketListDTO) throws Exception{
        MarketList marketList = marketListRepository.findById(id)
                .orElseThrow(()->new Exception("Market list not found"));

        marketList.setName(marketListDTO.getName());
        marketList.setDescription(marketListDTO.getDescription());
        marketList.setCarts(marketListDTO.getCarts());

        return converter.convert(marketListRepository.save(marketList),MarketListDTO.class);
    }

    @Override
    public void delete(Long id) {
        marketListRepository.deleteById(id);
    }

    @Override
    public MarketListDTO findByid(Long id) throws Exception {
        MarketList marketList = marketListRepository.findById(id)
                .orElseThrow(()->new Exception("Market list not found"));
        return converter.convert(marketList, MarketListDTO.class);
    }

    @Override
    public List<MarketListDTO> findAll() {
        return marketListRepository.findAll()
                .stream()
                .map(marketList -> {
                    try {
                        return converter.convert(marketList, MarketListDTO.class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }

}
