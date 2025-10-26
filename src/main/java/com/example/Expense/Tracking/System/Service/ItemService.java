package com.example.Expense.Tracking.System.Service;

import com.example.Expense.Tracking.System.Entity.Franchise;
import com.example.Expense.Tracking.System.Entity.Item;
import com.example.Expense.Tracking.System.Repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

//    // Paginated & filtered
//    public Page<Item> getItems(String search, String category, Pageable pageable) {
//        String searchTerm = search != null ? search : "";
//        String categoryTerm = category != null && !category.equalsIgnoreCase("All") ? category : "";
//        return repo.findByNameContainingIgnoreCaseAndCategory(searchTerm, categoryTerm, pageable);
//    }



//    // Full list for stats
//    public List<Item> getAllItemsForStats(String search, String category) {
//        String searchTerm = search != null ? search : "";
//        String categoryTerm = category != null && !category.equalsIgnoreCase("All") ? category : "";
//        return repo.findByNameContainingIgnoreCase(searchTerm);
//    }

    // ✅ All categories
    public List<String> getAllCategories() {
        return repo.findAll().stream()
                .map(Item::getCategory)
                .distinct()
                .sorted()
                .toList();
    }

    public Page<Item> searchItemsPaginated(String search, String category, Pageable pageable) {
        if ("All".equalsIgnoreCase(category)) {
            return repo.findByNameContainingIgnoreCase(search, pageable);
        } else {
            return repo.findByNameContainingIgnoreCaseAndCategory(search, category, pageable);
        }
    }


    // ✅ All items (unfiltered)
    public List<Item> getAllItems() {
        return repo.findAll();
    }

    // ✅ Get paginated list without filters
    public Page<Item> getPaginatedItems(int pageNo, int pageSize) {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(pageNo);
        return repo.findAll(pageable);
    }

    // ✅ Save or update item
    public void saveItem(Item item) {
        repo.save(item);
    }

    // ✅ Get item by ID
    public Item getItemById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ Delete item by ID
    public void deleteItem(Long id) {
        repo.deleteById(id);
    }
}
