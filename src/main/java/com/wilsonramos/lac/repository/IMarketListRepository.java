package com.wilsonramos.lac.repository;

import com.wilsonramos.lac.domain.MarketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wilsonramos
 */
@Repository
public interface IMarketListRepository extends JpaRepository<MarketList, Long> {
    
}
