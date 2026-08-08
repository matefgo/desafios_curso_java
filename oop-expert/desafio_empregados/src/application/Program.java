package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Department dept = new Department();
		Address address = new Address();

		System.out.print("Nome do departamento: ");
		dept.setName(sc.nextLine());
	
		System.out.print("Dia do pagamento: ");
		dept.setPayDay(sc.nextInt());

		sc.nextLine();
		
		System.out.print("Email: ");
		address.setEmail(sc.nextLine());

		System.out.print("Phone: ");
		address.setPhone(sc.nextLine());

		dept.setAddress(address);

		System.out.print("Quantos funcionários tem o departamento? ");
		int quantity = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < quantity; i++) {
			Employee employee = new Employee();
			System.out.println("Dados do funcionário " + (i + 1));

			System.out.print("Nome: ");
			employee.setName(sc.nextLine());

			System.out.print("Salário: ");
			employee.setSalary(sc.nextDouble());
			sc.nextLine();

			dept.addEmployee(employee);
		}

		showReport(dept);
		sc.close();
	}

	private static void showReport(Department department) {
		StringBuilder sb = new StringBuilder();

		sb.append("\nFOLHA DE PAGAMENTO\n");
		sb.append("Departamento ");
		sb.append(department.getName());
		sb.append(" = R$ ");
		sb.append(String.format("%.2f", department.payroll()));
		sb.append("\nPagamento realizado no dia ");
		sb.append(department.getPayDay());
		sb.append("\nFuncionários:\n");

		for (Employee e : department.getEmployees()) {
			sb.append(e.getName());
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
