package com.wilsonramos.lac.repository;

import com.wilsonramos.lac.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wilsonramos
 */
@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {
    
}
