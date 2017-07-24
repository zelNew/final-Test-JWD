package jwd.Modul3.Test12.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	@Autowired
	private TestData td;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
