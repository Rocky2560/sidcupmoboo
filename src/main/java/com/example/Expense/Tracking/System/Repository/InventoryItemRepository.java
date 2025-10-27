package com.example.Expense.Tracking.System.Repository;

import com.example.Expense.Tracking.System.Entity.InventoryItem;
import com.example.Expense.Tracking.System.Entity.Franchise;
import com.example.Expense.Tracking.System.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    List<InventoryItem> findByFranchise(Franchise franchise);

    @Query("SELECT i FROM InventoryItem i WHERE i.franchise = :franchise AND i.expiryDate < :today")
    List<InventoryItem> findExpiredItems(@Param("franchise") Franchise franchise, @Param("today") LocalDate today);

    @Query("SELECT i FROM InventoryItem i WHERE i.franchise = :franchise AND i.expiryDate BETWEEN :today AND :weekLater")
    List<InventoryItem> findExpiringSoonItems(@Param("franchise") Franchise franchise,
                                              @Param("today") LocalDate today,
                                              @Param("weekLater") LocalDate weekLater);

    @Query("SELECT i FROM InventoryItem i WHERE i.franchise = :franchise AND i.count < 10")
    List<InventoryItem> findLowStockItems(@Param("franchise") Franchise franchise);


    List<InventoryItem> findByFranchiseIsNull();
//    Page<InventoryItem> findByFr(User user, Pageable pageable);x
    Page<InventoryItem> findByFranchise(Franchise franchise, Pageable pageable);
}
