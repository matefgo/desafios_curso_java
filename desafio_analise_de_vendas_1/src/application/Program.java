package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.nextLine();
		List<Sale> sales = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				Integer month = Integer.parseInt(fields[0]);
				Integer year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				Integer items = Integer.parseInt(fields[3]);
				Double total = Double.parseDouble(fields[4]);
				sales.add(new Sale(month, year, seller, items, total));
				line = br.readLine();
			}

			System.out.println();
			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");
			sales.stream().filter(sale -> sale.getYear() == 2016)
					.sorted((x, y) -> y.averagePrice().compareTo(x.averagePrice())).limit(5)
					.forEach(System.out::println);

			Double loganTotalValue = sales.stream()
					.filter(sale -> sale.getSeller().equals("Logan") && (sale.getMonth() == 1 || sale.getMonth() == 7))
					.map(sale -> sale.getTotal()).reduce(0.0, (x, y) -> x + y);

			System.out.println();
			System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f", loganTotalValue);

		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
