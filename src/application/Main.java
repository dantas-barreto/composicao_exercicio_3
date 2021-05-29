package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = teclado.nextLine();
		System.out.print("Email: ");
		String clientEmail = teclado.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirthDate = sdf.parse(teclado.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(teclado.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = teclado.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " data:");
			System.out.print("Product name: ");
			teclado.nextLine();
			String productName = teclado.nextLine();
			System.out.print("Product price: ");
			double productPrice = teclado.nextDouble();			
			System.out.print("Quantity: ");
			int productQuantity = teclado.nextInt();
						
			Product product = new Product(productName, productPrice);
			
			OrderItem it = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(it);
		}
		
		System.out.println();
		System.out.println(order);
		
		teclado.close();
	}
}