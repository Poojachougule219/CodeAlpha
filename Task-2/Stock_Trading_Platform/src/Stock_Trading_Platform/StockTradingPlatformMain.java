package Stock_Trading_Platform;

import java.util.ArrayList;
import java.util.Scanner;

public class StockTradingPlatformMain {
	
	

	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        ArrayList<Stock> stocks = new ArrayList<>();

	        // Market stocks
	        stocks.add(
	                new Stock(
	                        "TCS",
	                        "Tata Consultancy",
	                        3500
	                )
	        );

	        stocks.add(
	                new Stock(
	                        "INFY",
	                        "Infosys",
	                        1800
	                )
	        );

	        stocks.add(
	                new Stock(
	                        "RELIANCE",
	                        "Reliance Industries",
	                        2900
	                )
	        );

	        stocks.add(
	                new Stock(
	                        "HDFC",
	                        "HDFC Bank",
	                        1700
	                )
	        );

	        stocks.add(
	                new Stock(
	                        "WIPRO",
	                        "Wipro",
	                        600
	                )
	        );


	        System.out.println("==============================================");
	        System.out.println("          STOCK TRADING PLATFORM");
	        System.out.println("==============================================");

	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter initial balance: ₹");
	        double balance = scanner.nextDouble();

	        User user = new User(name, balance);

	        int choice;

	        do {

	            System.out.println("\n==============================================");
	            System.out.println("                    MENU");
	            System.out.println("==============================================");

	            System.out.println("1. Display Market Data");
	            System.out.println("2. Buy Stock");
	            System.out.println("3. Sell Stock");
	            System.out.println("4. View Portfolio");
	            System.out.println("5. View Transactions");
	            System.out.println("6. Exit");

	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {

	                case 1:

	                    System.out.println("\n==============================================");
	                    System.out.println("                 MARKET DATA");
	                    System.out.println("==============================================");

	                    System.out.printf(
	                            "%-10s %-20s %s%n",
	                            "Symbol",
	                            "Company",
	                            "Price"
	                    );

	                    System.out.println("----------------------------------------------");

	                    for (Stock stock : stocks) {
	                        stock.displayStock();
	                    }

	                    break;


	                case 2:

	                    System.out.print(
	                            "Enter stock symbol: "
	                    );

	                    String buySymbol =
	                            scanner.next();

	                    Stock buyStock = findStock(
	                            stocks,
	                            buySymbol
	                    );

	                    if (buyStock == null) {

	                        System.out.println(
	                                "Stock not found."
	                        );

	                        break;
	                    }

	                    System.out.print(
	                            "Enter quantity: "
	                    );

	                    int buyQuantity =
	                            scanner.nextInt();

	                    user.buyStock(
	                            buyStock,
	                            buyQuantity
	                    );

	                    break;


	                case 3:

	                    System.out.print(
	                            "Enter stock symbol: "
	                    );

	                    String sellSymbol =
	                            scanner.next();

	                    Stock sellStock = findStock(
	                            stocks,
	                            sellSymbol
	                    );

	                    if (sellStock == null) {

	                        System.out.println(
	                                "Stock not found."
	                        );

	                        break;
	                    }

	                    System.out.print(
	                            "Enter quantity: "
	                    );

	                    int sellQuantity =
	                            scanner.nextInt();

	                    user.sellStock(
	                            sellStock,
	                            sellQuantity
	                    );

	                    break;


	                case 4:

	                    user.displayPortfolio();

	                    break;


	                case 5:

	                    user.displayTransactions();

	                    break;


	                case 6:

	                    System.out.println(
	                            "\nThank you for using " +
	                            "Stock Trading Platform!"
	                    );

	                    break;


	                default:

	                    System.out.println(
	                            "Invalid choice."
	                    );
	            }

	        } while (choice != 6);

	        scanner.close();
	    }


	    // Find stock by symbol
	    private static Stock findStock(
	            ArrayList<Stock> stocks,
	            String symbol) {

	        for (Stock stock : stocks) {

	            if (stock.getSymbol()
	                    .equalsIgnoreCase(symbol)) {

	                return stock;
	            }
	        }

	        return null;
	    }
	}


