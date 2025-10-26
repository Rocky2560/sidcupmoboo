package com.example.Expense.Tracking.System.Repository;


import com.example.Expense.Tracking.System.Entity.Franchise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Expense.Tracking.System.Entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Item> findByNameContainingIgnoreCaseAndCategory( String name, String category, Pageable pageable);
}
