package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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

			Map<String, Double> mappedSellerTotals = new HashMap<String, Double>();

			sales.stream().forEach(sale -> {
				String sellerName = sale.getSeller();
				Double currentMappedValue = mappedSellerTotals.containsKey(sellerName)
						? mappedSellerTotals.get(sellerName)
						: 0;
				Double totalAmount = sale.getTotal() + currentMappedValue;
				mappedSellerTotals.put(sellerName, totalAmount);
			});

			System.out.println();
			System.out.println("Total de vendas por vendedor:");
			mappedSellerTotals.forEach((x, y) -> System.out.printf("%s - R$%.2f%n", x, y));

		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			sc.close();
		}

	}
}
