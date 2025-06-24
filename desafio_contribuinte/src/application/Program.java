package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int payers;
		
		do {
			payers = scanner.nextInt();
			
			if (payers <= 0) {
				System.out.print("Digite um número de contribuintes positivo: ");
			}
			
		} while (payers <= 0);
		
		List<TaxPayer> taxPayerList = new ArrayList<>();
		
		for (int i = 0; i < payers; i++) {
			System.out.println();
			System.out.println("Digite os dados do " + (i + 1) + "o contribuinte:");
			
			TaxPayer payer = new TaxPayer();
			
			System.out.print("Renda anual com salário: ");
			payer.setSalaryIncome(scanner.nextDouble());
			
			System.out.print("Renda anual com prestação de serviço: ");
			payer.setServicesIncome(scanner.nextDouble());
			
			System.out.print("Renda anual com ganho de capital: ");
			payer.setCapitalIncome(scanner.nextDouble());
			
			System.out.print("Gastos médicos: ");
			payer.setHealthSpending(scanner.nextDouble());
			
			System.out.print("Gastos educacionais: ");
			payer.setEducationSpending(scanner.nextDouble());
			
			taxPayerList.add(payer);
		}
		
		for (TaxPayer payer : taxPayerList) {
			int payerNumber = taxPayerList.indexOf(payer) + 1;
			System.out.println("\nResumo do " + payerNumber + "o contribuinte:");
			System.out.printf("Imposto bruto total: %.2f%n", payer.grossTax());
			System.out.printf("Abatimento: %.2f%n", payer.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", payer.netTax());
		}
		
		scanner.close();
	}
}
