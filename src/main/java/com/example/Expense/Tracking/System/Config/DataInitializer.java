//package com.example.Expense.Tracking.System.Config;
//import com.example.Expense.Tracking.System.Entity.Franchise;
//import com.example.Expense.Tracking.System.Entity.Item;
//import com.example.Expense.Tracking.System.Enum.UserRole;
//import com.example.Expense.Tracking.System.Entity.InventoryItem;
//import com.example.Expense.Tracking.System.Repository.ItemRepository;
//import com.example.Expense.Tracking.System.Service.UserService;
//import com.example.Expense.Tracking.System.Entity.User;
//import com.example.Expense.Tracking.System.Repository.FranchiseRepository;
//import com.example.Expense.Tracking.System.Repository.InventoryItemRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private FranchiseRepository franchiseRepository;
//
//    @Autowired
//    private InventoryItemRepository inventoryItemRepository;
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        itemRepository.saveAll(Arrays.asList(
//                // 🧃 SYRUPS
//                new Item("Mango SY", "Syrups"),
//                new Item("Passionfruit SY", "Syrups"),
//                new Item("Strawberry SY", "Syrups"),
//                new Item("Lychee SY", "Syrups"),
//                new Item("Peach SY", "Syrups"),
//                new Item("Green Apple SY", "Syrups"),
//                new Item("Pineapple SY", "Syrups"),
//                new Item("Watermelon SY", "Syrups"),
//                new Item("Wintermelon SY", "Syrups"),
//                new Item("Honey SY", "Syrups"),
//                new Item("Vanilla SY", "Syrups"),
//                new Item("Mint SY", "Syrups"),
//                new Item("Hazelnut SY", "Syrups"),
//                new Item("Caramel SY", "Syrups"),
//                new Item("Brown Sugar SY", "Syrups"),
//                new Item("Golden SY", "Syrups"),
//                new Item("Cane Sugar", "Syrups"),
//
//                // 🧋 TOPPINGS
//                new Item("Coconut Jelly", "Toppings"),
//                new Item("Jelly Ball", "Toppings"),
//                new Item("Strawberry Pop", "Toppings"),
//                new Item("Lychee Pop", "Toppings"),
//                new Item("Mango Pop", "Toppings"),
//                new Item("Passionfruit Pop", "Toppings"),
//                new Item("Blueberry Pop", "Toppings"),
//                new Item("Green Apple Pop", "Toppings"),
//                new Item("Cherry Pop", "Toppings"),
//                new Item("Watermelon Pop", "Toppings"),
//                new Item("Tapioca", "Toppings"),
//                new Item("Brown Sugar Powder", "Toppings"),
//                new Item("Golden Boba", "Toppings"),
//                new Item("Coconut Strips", "Toppings"),
//                new Item("Lychee Jelly", "Toppings"),
//                new Item("Grape Pop", "Toppings"),
//
//                // 🍶 TOPPING INGREDIENTS
//                new Item("Crème Brulee PD", "Topping Ingredients"),
//                new Item("Milk", "Topping Ingredients"),
//                new Item("Whipping Cream", "Topping Ingredients"),
//                new Item("Vanilla Paste", "Topping Ingredients"),
//                new Item("Cheese Powder", "Topping Ingredients"),
//                new Item("Sugar", "Topping Ingredients"),
//
//                // ☕ POWDERS
//                new Item("Creamer (per pack)", "Powders"),
//                new Item("Coconut", "Powders"),
//                new Item("Chocolate", "Powders"),
//                new Item("Taro", "Powders"),
//                new Item("Perfect Ted Matcha", "Powders"),
//                new Item("Honeydew", "Powders"),
//                new Item("Mocha", "Powders"),
//                new Item("Thai Tea", "Powders"),
//                new Item("Soya", "Powders"),
//                new Item("Oat", "Powders"),
//                new Item("Raspberry", "Powders"),
//                new Item("Smoothie", "Powders"),
//                new Item("Masalla", "Powders"),
//
//                // 🍃 TEAS
//                new Item("Black Tea", "Teas"),
//                new Item("Green Tea", "Teas"),
//                new Item("Honey Oolong", "Teas"),
//                new Item("Rose Tie", "Teas"),
//
//                // 🍪 OTHERS
//                new Item("Oreo (per pack)", "Other"),
//                new Item("Demerara Sugar", "Other"),
//
//                // 🍡 SNACKS
//                new Item("Milk Mochi", "Snacks"),
//                new Item("Matcha Mochi", "Snacks"),
//                new Item("Mango Mochi", "Snacks"),
//                new Item("Grape Mochi", "Snacks"),
//                new Item("Strawberry Mochi", "Snacks"),
//
//                // 🧴 OTHER MATERIALS
//                new Item("Sealing Film", "Materials"),
//                new Item("Piping Bags", "Materials"),
//                new Item("1 Cup Bag (per pack)", "Materials"),
//                new Item("2 Cups Bag (per pack)", "Materials"),
//                new Item("4 Cups Bag (per pack)", "Materials"),
//                new Item("Drinks Label (per roll)", "Materials"),
//                new Item("Disposable Straws (per pack)", "Materials"),
//                new Item("Reusable Straw", "Materials"),
//                new Item("Tote Bag", "Materials"),
//                new Item("Reusable Cup", "Materials"),
//                new Item("Cups & Lids (per packet)", "Materials"),
//                new Item("Hot Cup Lid", "Materials"),
//                new Item("Flat Cup Lid", "Materials"),
//                new Item("Diamond Cup Lid", "Materials"),
//                new Item("12oz Paper Cup", "Materials"),
//                new Item("16oz Paper Cup", "Materials"),
//                new Item("12oz Plastic Cup", "Materials"),
//                new Item("16oz Plastic Cup", "Materials"),
//                new Item("20oz Plastic Cup", "Materials"),
//
//                // 🧽 CLEANING & SUPPLIES
//                new Item("Napkins", "Cleaning"),
//                new Item("Toilet Rolls", "Cleaning"),
//                new Item("Blue Towels", "Cleaning"),
//                new Item("Milton Tablet (per box)", "Cleaning"),
//                new Item("Floor Cleaner (bottle)", "Cleaning"),
//                new Item("Kitchen Cleaner (bottle)", "Cleaning"),
//                new Item("Surface Spray (bottle)", "Cleaning"),
//                new Item("Window Cleaner (bottle)", "Cleaning"),
//                new Item("Bleach (bottle)", "Cleaning"),
//                new Item("Washing Up Liquid Refill", "Cleaning"),
//                new Item("Hand Wash Liquid Refill", "Cleaning"),
//                new Item("Sink Bleach", "Cleaning"),
//                new Item("Descaler", "Cleaning"),
//                new Item("Hand Gloves", "Cleaning"),
//                new Item("Thermo Rolls (Big)", "Cleaning"),
//                new Item("Thermo Rolls (Small)", "Cleaning"),
//                new Item("Use By Label", "Cleaning"),
//                new Item("Black Bins Liner", "Cleaning"),
//                new Item("Soda Stream Refill", "Cleaning"),
//                new Item("Cup Holders", "Cleaning"),
//
//                // 🧁 EXTRA ITEMS
//                new Item("Herbal Pudding Powder", "Extra"),
//                new Item("Caramel Pudding Powder", "Extra"),
//                new Item("Choco Puff", "Extra"),
//                new Item("Strawberry Puff", "Extra"),
//                new Item("Grape Marshmallow", "Extra"),
//                new Item("Peach Marshmallow", "Extra"),
//                new Item("Cookie & Cream Roll", "Extra"),
//                new Item("Handheld Fan", "Extra")
//        ));
//        // Create franchises
//        Franchise centralLondon = franchiseRepository.save(
//                new Franchise("sidcup Shop", "sidcup@moboo.com")
//        );
//
//        Franchise manchester = franchiseRepository.save(
//                new Franchise("Moboo Manchester", "manchester@moboo.com")
//        );
//
//        Franchise birmingham = franchiseRepository.save(
//                new Franchise("Moboo Birmingham", "birmingham@moboo.com")
//        );
//
//
//
//        // Create userss
//        userService.saveUser(new User("Sidcup Shop", "sidcup@moboo.com", "sidcup123", UserRole.ADMIN));
//        userService.saveUser(new User("Central London", "central@moboo.com", "franchise123", UserRole.FRANCHISE));
//        userService.saveUser(new User("Manchester", "manchester@moboo.com", "franchise123", UserRole.FRANCHISE));
//        userService.saveUser(new User("Birmingham", "birmingham@moboo.com", "franchise123", UserRole.FRANCHISE));
//
//        // Create inventory items
//        inventoryItemRepository.saveAll(Arrays.asList(
//                new InventoryItem("Tapioca Pearls", "Ingredients", 25, LocalDate.of(2024, 1, 15), centralLondon),
//                new InventoryItem("Milk Tea Base", "Ingredients", 8, LocalDate.of(2024, 1, 20), centralLondon),
//                new InventoryItem("Strawberry Syrup", "Syrups", 15, LocalDate.of(2024, 2, 10), centralLondon),
//                new InventoryItem("Tapioca Pearls", "Ingredients", 3, LocalDate.of(2024, 1, 10), manchester),
//                new InventoryItem("Green Tea Powder", "Ingredients", 12, LocalDate.of(2024, 3, 15), manchester),
//                new InventoryItem("Mango Puree", "Fruits", 7, LocalDate.of(2024, 1, 25), birmingham)
//        ));
//
//
//
//    }
//}
