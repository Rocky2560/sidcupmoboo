package com.example.Expense.Tracking.System.Config;
import com.example.Expense.Tracking.System.Entity.Franchise;
import com.example.Expense.Tracking.System.Entity.Item;
import com.example.Expense.Tracking.System.Enum.UserRole;
import com.example.Expense.Tracking.System.Entity.InventoryItem;
import com.example.Expense.Tracking.System.Repository.ItemRepository;
import com.example.Expense.Tracking.System.Service.UserService;
import com.example.Expense.Tracking.System.Entity.User;
import com.example.Expense.Tracking.System.Repository.FranchiseRepository;
import com.example.Expense.Tracking.System.Repository.InventoryItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public void run(String... args) throws Exception {
        // Create franchises
        Franchise centralLondon = franchiseRepository.save(
                new Franchise("Moboo Central London", "central@moboo.com")
        );

        Franchise manchester = franchiseRepository.save(
                new Franchise("Moboo Manchester", "manchester@moboo.com")
        );

        Franchise birmingham = franchiseRepository.save(
                new Franchise("Moboo Birmingham", "birmingham@moboo.com")
        );

        // Create userss
        userService.saveUser(new User("Sidcup Shop", "sidcup@moboo.com", "sidcup123", UserRole.ADMIN));
        userService.saveUser(new User("Central London", "central@moboo.com", "franchise123", UserRole.FRANCHISE));
        userService.saveUser(new User("Manchester", "manchester@moboo.com", "franchise123", UserRole.FRANCHISE));
        userService.saveUser(new User("Birmingham", "birmingham@moboo.com", "franchise123", UserRole.FRANCHISE));

        // Create inventory items
        inventoryItemRepository.saveAll(Arrays.asList(
                new InventoryItem("Tapioca Pearls", "Ingredients", 25, LocalDate.of(2024, 1, 15), centralLondon),
                new InventoryItem("Milk Tea Base", "Ingredients", 8, LocalDate.of(2024, 1, 20), centralLondon),
                new InventoryItem("Strawberry Syrup", "Syrups", 15, LocalDate.of(2024, 2, 10), centralLondon),
                new InventoryItem("Tapioca Pearls", "Ingredients", 3, LocalDate.of(2024, 1, 10), manchester),
                new InventoryItem("Green Tea Powder", "Ingredients", 12, LocalDate.of(2024, 3, 15), manchester),
                new InventoryItem("Mango Puree", "Fruits", 7, LocalDate.of(2024, 1, 25), birmingham)
        ));

        itemRepository.saveAll(Arrays.asList(
                // 🧃 SYRUPS
                new Item("Mango SY", "Syrup"),
                new Item("Passionfruit SY", "Syrup"),
                new Item("Strawberry SY", "Syrup"),
                new Item("Lychee SY", "Syrup"),
                new Item("Peach SY", "Syrup"),
                new Item("Green Apple SY", "Syrup"),
                new Item("Pineapple SY", "Syrup"),
                new Item("Watermelon SY", "Syrup"),
                new Item("Wintermelon SY", "Syrup"),
                new Item("Honey SY", "Syrup"),
                new Item("Vanilla SY", "Syrup"),
                new Item("Mint SY", "Syrup"),
                new Item("Hazelnut SY", "Syrup"),
                new Item("Caramel SY", "Syrup"),
                new Item("Brown Sugar SY", "Syrup"),
                new Item("Golden SY", "Syrup"),
                new Item("Cane Sugar", "Syrup"),

                // 🧋 TOPPINGS
                new Item("Coconut Jelly", "Topping"),
                new Item("Jelly Ball", "Topping"),
                new Item("Strawberry Pop", "Topping"),
                new Item("Lychee Pop", "Topping"),
                new Item("Mango Pop", "Topping"),
                new Item("Passionfruit Pop", "Topping"),
                new Item("Blueberry Pop", "Topping"),
                new Item("Green Apple Pop", "Topping"),
                new Item("Cherry Pop", "Topping"),
                new Item("Watermelon Pop", "Topping"),
                new Item("Tapioca", "Topping"),
                new Item("Brown Sugar Powder", "Topping"),
                new Item("Golden Boba", "Topping"),
                new Item("Coconut Strips", "Topping"),
                new Item("Lychee Jelly", "Topping"),
                new Item("Grape Pop", "Topping"),

                // 🍶 TOPPING INGREDIENTS
                new Item("Crème Brulee PD", "Topping Ingredient"),
                new Item("Milk", "Topping Ingredient"),
                new Item("Whipping Cream", "Topping Ingredient"),
                new Item("Vanilla Paste", "Topping Ingredient"),
                new Item("Cheese Powder", "Topping Ingredient"),
                new Item("Sugar", "Topping Ingredient"),

                // ☕ POWDERS
                new Item("Creamer (per pack)", "Powder"),
                new Item("Coconut", "Powder"),
                new Item("Chocolate", "Powder"),
                new Item("Taro", "Powder"),
                new Item("Perfect Ted Matcha", "Powder"),
                new Item("Honeydew", "Powder"),
                new Item("Mocha", "Powder"),
                new Item("Thai Tea", "Powder"),
                new Item("Soya", "Powder"),
                new Item("Oat", "Powder"),
                new Item("Raspberry", "Powder"),
                new Item("Smoothie", "Powder"),
                new Item("Masalla", "Powder"),

                // 🍃 TEAS
                new Item("Black Tea", "Tea"),
                new Item("Green Tea", "Tea"),
                new Item("Honey Oolong", "Tea"),
                new Item("Rose Tie", "Tea"),

                // 🍪 OTHERS
                new Item("Oreo (per pack)", "Other"),
                new Item("Demerara Sugar", "Other"),

                // 🍡 SNACKS
                new Item("Milk Mochi", "Snack"),
                new Item("Matcha Mochi", "Snack"),
                new Item("Mango Mochi", "Snack"),
                new Item("Grape Mochi", "Snack"),
                new Item("Strawberry Mochi", "Snack"),

                // 🧴 OTHER MATERIALS
                new Item("Sealing Film", "Material"),
                new Item("Piping Bags", "Material"),
                new Item("1 Cup Bag (per pack)", "Material"),
                new Item("2 Cups Bag (per pack)", "Material"),
                new Item("4 Cups Bag (per pack)", "Material"),
                new Item("Drinks Label (per roll)", "Material"),
                new Item("Disposable Straws (per pack)", "Material"),
                new Item("Reusable Straw", "Material"),
                new Item("Tote Bag", "Material"),
                new Item("Reusable Cup", "Material"),
                new Item("Cups & Lids (per packet)", "Material"),
                new Item("Hot Cup Lid", "Material"),
                new Item("Flat Cup Lid", "Material"),
                new Item("Diamond Cup Lid", "Material"),
                new Item("12oz Paper Cup", "Material"),
                new Item("16oz Paper Cup", "Material"),
                new Item("12oz Plastic Cup", "Material"),
                new Item("16oz Plastic Cup", "Material"),
                new Item("20oz Plastic Cup", "Material"),

                // 🧽 CLEANING & SUPPLIES
                new Item("Napkins", "Cleaning"),
                new Item("Toilet Rolls", "Cleaning"),
                new Item("Blue Towels", "Cleaning"),
                new Item("Milton Tablet (per box)", "Cleaning"),
                new Item("Floor Cleaner (bottle)", "Cleaning"),
                new Item("Kitchen Cleaner (bottle)", "Cleaning"),
                new Item("Surface Spray (bottle)", "Cleaning"),
                new Item("Window Cleaner (bottle)", "Cleaning"),
                new Item("Bleach (bottle)", "Cleaning"),
                new Item("Washing Up Liquid Refill", "Cleaning"),
                new Item("Hand Wash Liquid Refill", "Cleaning"),
                new Item("Sink Bleach", "Cleaning"),
                new Item("Descaler", "Cleaning"),
                new Item("Hand Gloves", "Cleaning"),
                new Item("Thermo Rolls (Big)", "Cleaning"),
                new Item("Thermo Rolls (Small)", "Cleaning"),
                new Item("Use By Label", "Cleaning"),
                new Item("Black Bins Liner", "Cleaning"),
                new Item("Soda Stream Refill", "Cleaning"),
                new Item("Cup Holders", "Cleaning"),

                // 🧁 EXTRA ITEMS
                new Item("Herbal Pudding Powder", "Extra"),
                new Item("Caramel Pudding Powder", "Extra"),
                new Item("Choco Puff", "Extra"),
                new Item("Strawberry Puff", "Extra"),
                new Item("Grape Marshmallow", "Extra"),
                new Item("Peach Marshmallow", "Extra"),
                new Item("Cookie & Cream Roll", "Extra"),
                new Item("Handheld Fan", "Extra")
        ));



    }
}
