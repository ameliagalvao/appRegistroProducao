package br.edu.infnet.appRegistroProducao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.edu.infnet.appRegistroProducao.model.domain")
public class AppRegistroProducaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppRegistroProducaoApplication.class, args);
	}

}
