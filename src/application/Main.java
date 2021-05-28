package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = teclado.nextLine();
		System.out.print("Email: ");
		String clientEmail = teclado.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirthDate = sdf.parse(teclado.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("Enter order data:");
		System.out.println("How many items to this order? ");
		int n = teclado.nextInt();
		teclado.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " data:");
			System.out.print("Status: ");
			String orderStatus = teclado.nextLine();
			System.out.print("Product name: ");
			String productName = teclado.nextLine();
			System.out.print("Product price: ");
			double productPrice = teclado.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = teclado.nextInt();
			
			
		}
		
		teclado.close();
	}

}
