package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Bill;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		Bill bill = new Bill();

		System.out.print("Sexo: ");
		do {
			bill.gender = scanner.next().toUpperCase().charAt(0);
			
			if (bill.gender != 'M' && bill.gender != 'F') {
				System.out.print("Por favor, insira um gênero válido (M/F): ");
			}
		} while (bill.gender != 'M' && bill.gender != 'F');

		System.out.print("Quantidade de cervejas: ");
		bill.beer = scanner.nextInt();

		System.out.print("Quantidade de refrigerantes: ");
		bill.softDrink = scanner.nextInt();

		System.out.print("Quantidade de espetinhos: ");
		bill.barbecue = scanner.nextInt();

		System.out.println();
		System.out.println("RELATÓRIO:");
		System.out.printf("Consumo = R$ %.2f%n", bill.feeding());

		double cover = bill.cover();

		if (cover != 0) {
			System.out.printf("Couvert = R$ %.2f%n", bill.cover());
		} else {
			System.out.println("Isento de Couvert");
		}

		System.out.printf("Ingresso = R$ %.2f%n%n", bill.ticket());
		System.out.printf("Valor a pagar = R$ %.2f%n", bill.total());

		scanner.close();
	}

}
