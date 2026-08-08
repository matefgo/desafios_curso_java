package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Champion;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		String name;
		int life, attack, armor;

		System.out.println("Digite os dados do primeiro campeão:");

		System.out.print("Nome: ");
		name = scanner.nextLine();
		
		System.out.print("Vida inicial: ");
		life = scanner.nextInt();
		
		System.out.print("Ataque: ");
		attack = scanner.nextInt();
		
		System.out.print("Armadura: ");
		armor = scanner.nextInt();
		
		Champion first = new Champion(name, life, attack, armor);
		
		System.out.println();
		System.out.println("Digite os dados do segundo campeão:");

		System.out.print("Nome: ");
		scanner.nextLine();
		name = scanner.nextLine();
		
		System.out.print("Vida inicial: ");
		life = scanner.nextInt();
		
		System.out.print("Ataque: ");
		attack = scanner.nextInt();
		
		System.out.print("Armadura: ");
		armor = scanner.nextInt();
		
		Champion second = new Champion(name, life, attack, armor);

		System.out.println();
		System.out.print("Quantos turnos você deseja executar? ");
		int rounds;
		
		do {
			rounds = scanner.nextInt();
			
			if (rounds <= 0) {
				System.out.print("Digite um número de turnos positivo: ");
			}
			
		} while (rounds <= 0);
		
		System.out.println();
		
		for (int i = 0; i < rounds; i++) {
			first.takeDamage(second);
			second.takeDamage(first);
			
			System.out.println("Resultado do turno " + (i + 1));
			System.out.println(first.status());
			System.out.println(second.status());
			System.out.println();
			
			if (first.getLife() == 0 || second.getLife() == 0) {
				break;
			}
		}
		
		System.out.println("FIM DO COMBATE");

		scanner.close();
	}

}
