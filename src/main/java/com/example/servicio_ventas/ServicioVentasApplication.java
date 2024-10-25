package com.example.servicio_ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicioVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVentasApplication.class, args);
	}

}
