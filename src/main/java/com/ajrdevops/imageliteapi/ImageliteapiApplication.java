package com.ajrdevops.imageliteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImageliteapiApplication {

	/* 
	// Exemplo de como usar a execução de comando na subida da aplicação
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ImageRepository repository) {
		return args -> {
			Image	image = Image 
					.builder()
					.extension(ImageExtension.JPEG)
					.size(1000L)
					.name("myimage")
					.tags("teste")
					.build();

			repository.save(image);
		};
	}
	*/

	public static void main(String[] args) {
		SpringApplication.run(ImageliteapiApplication.class, args);
	}

}
