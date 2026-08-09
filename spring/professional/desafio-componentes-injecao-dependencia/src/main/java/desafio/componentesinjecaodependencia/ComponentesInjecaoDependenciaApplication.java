package desafio.componentesinjecaodependencia;

import desafio.componentesinjecaodependencia.entities.Order;
import desafio.componentesinjecaodependencia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ComponentesInjecaoDependenciaApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ComponentesInjecaoDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Order order = new Order();

		System.out.print("Insira o código do pedido: ");
		order.setCode(sc.nextInt());

		System.out.print("Insira o valor do pedido: ");
		order.setBasic(sc.nextDouble());

		System.out.print("Insira o desconto (%): ");
		order.setDiscount(sc.nextDouble());

		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f", orderService.total(order));
	}
}
