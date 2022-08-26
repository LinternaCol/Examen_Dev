package com.prueba.prueba;

import com.prueba.prueba.carry.Read;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaApplication {
	static Read read = new Read();

	public static void main(String[] args) {
		read.leer();
		SpringApplication.run(PruebaApplication.class, args);





	}

}
