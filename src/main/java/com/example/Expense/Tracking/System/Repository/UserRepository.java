package com.example.Expense.Tracking.System.Repository;

import com.example.Expense.Tracking.System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

       Optional<User> findByName(String name);
}
