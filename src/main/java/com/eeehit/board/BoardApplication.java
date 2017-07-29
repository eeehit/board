package com.eeehit.board;

import com.eeehit.board.article.Article;
import com.eeehit.board.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoardApplication implements CommandLineRunner {

	@Autowired
	ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
		};
	}

	@Override
	public void run(String... args) throws Exception {
		articleRepository.save(new Article("do kka bi", "awesome"));
		articleRepository.save(new Article("harry potter", "good"));
	}
}