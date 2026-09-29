package Stock_Trading_Platform;

import java.util.ArrayList;

//---------------- USER CLASS ----------------
class User {

 private String name;
 private double balance;

 private ArrayList<Stock> portfolioStocks;
 private ArrayList<Integer> quantities;
 private ArrayList<Transaction> transactions;

 public User(String name, double balance) {

     this.name = name;
     this.balance = balance;

     portfolioStocks = new ArrayList<>();
     quantities = new ArrayList<>();
     transactions = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public double getBalance() {
     return balance;
 }


 // ---------------- BUY STOCK ----------------
 public void buyStock(Stock stock, int quantity) {

     double totalCost = stock.getPrice() * quantity;

     if (quantity <= 0) {
         System.out.println("Invalid quantity.");
         return;
     }

     if (totalCost > balance) {

         System.out.println("Insufficient balance.");
         return;
     }

     int index = findStock(stock.getSymbol());

     if (index == -1) {

         portfolioStocks.add(stock);
         quantities.add(quantity);

     } else {

         int currentQuantity = quantities.get(index);
         quantities.set(index, currentQuantity + quantity);
     }

     balance -= totalCost;

     transactions.add(
             new Transaction(
                     "BUY",
                     stock.getSymbol(),
                     quantity,
                     stock.getPrice()
             )
     );

     System.out.println(
             "Successfully bought " +
             quantity + " shares of " +
             stock.getSymbol()
     );
 }


 // ---------------- SELL STOCK ----------------
 public void sellStock(Stock stock, int quantity) {

     int index = findStock(stock.getSymbol());

     if (index == -1) {

         System.out.println(
                 "You do not own this stock."
         );

         return;
     }

     int ownedQuantity = quantities.get(index);

     if (quantity <= 0 || quantity > ownedQuantity) {

         System.out.println(
                 "Invalid quantity."
         );

         return;
     }

     double totalAmount =
             stock.getPrice() * quantity;

     balance += totalAmount;

     int remainingQuantity =
             ownedQuantity - quantity;

     if (remainingQuantity == 0) {

         portfolioStocks.remove(index);
         quantities.remove(index);

     } else {

         quantities.set(index, remainingQuantity);
     }

     transactions.add(
             new Transaction(
                     "SELL",
                     stock.getSymbol(),
                     quantity,
                     stock.getPrice()
             )
     );

     System.out.println(
             "Successfully sold " +
             quantity + " shares of " +
             stock.getSymbol()
     );
 }


 // ---------------- FIND STOCK ----------------
 private int findStock(String symbol) {

     for (int i = 0; i < portfolioStocks.size(); i++) {

         if (portfolioStocks
                 .get(i)
                 .getSymbol()
                 .equalsIgnoreCase(symbol)) {

             return i;
         }
     }

     return -1;
 }


 // ---------------- PORTFOLIO ----------------
 public void displayPortfolio() {

     System.out.println("\n==============================================");
     System.out.println("                 PORTFOLIO");
     System.out.println("==============================================");

     if (portfolioStocks.isEmpty()) {

         System.out.println("Portfolio is empty.");

     } else {

         System.out.printf(
                 "%-10s %-20s %-10s %-15s%n",
                 "Symbol",
                 "Company",
                 "Quantity",
                 "Current Value"
         );

         System.out.println("----------------------------------------------");

         double totalPortfolioValue = 0;

         for (int i = 0; i < portfolioStocks.size(); i++) {

             Stock stock = portfolioStocks.get(i);

             int quantity = quantities.get(i);

             double value =
                     stock.getPrice() * quantity;

             totalPortfolioValue += value;

             System.out.printf(
                     "%-10s %-20s %-10d ₹%.2f%n",
                     stock.getSymbol(),
                     stock.getCompanyName(),
                     quantity,
                     value
             );
         }

         System.out.println("----------------------------------------------");

         System.out.printf(
                 "Total Portfolio Value: ₹%.2f%n",
                 totalPortfolioValue
         );
     }

     System.out.printf(
             "Available Balance: ₹%.2f%n",
             balance
     );
 }


 // ---------------- TRANSACTION HISTORY ----------------
 public void displayTransactions() {

     System.out.println("\n==============================================");
     System.out.println("             TRANSACTION HISTORY");
     System.out.println("==============================================");

     if (transactions.isEmpty()) {

         System.out.println("No transactions yet.");

         return;
     }

     System.out.printf(
             "%-8s %-10s %-10s %-15s%n",
             "Type",
             "Stock",
             "Quantity",
             "Price"
     );

     System.out.println("----------------------------------------------");

     for (Transaction transaction : transactions) {

         transaction.displayTransaction();
     }
 }
}


