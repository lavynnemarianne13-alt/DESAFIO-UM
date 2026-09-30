package com.desafioum.desafioum;

import com.desafioum.desafioum.entities.Order;
import com.desafioum.desafioum.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DesafioumApplication implements CommandLineRunner {
	private OrderService orderService;

	public DesafioumApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {

		SpringApplication.run(DesafioumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc= new Scanner(System.in);

		System.out.print("Code: ");
		Integer code = sc.nextInt();
		System.out.print("Basic: ");
		Double basic = sc.nextDouble();
		System.out.print("Discount: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code,basic,discount);

		System.out.println("Pedido codigo : " + order.getCode());
		System.out.printf("Valor total: %.2f", orderService.total(order));

		sc.close();


	}
}
