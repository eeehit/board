package com.eeehit.board;

import com.eeehit.board.article.Article;
import com.eeehit.board.article.ArticleRepository;
import com.eeehit.board.user.User;
import com.eeehit.board.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class BoardApplication implements CommandLineRunner {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	UserRepository userRepository;

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
		userRepository.save(new User("Trinity", "hello", "ROLE_ADMIN"));
		userRepository.save(new User("guest", "guest", "ROLE_GUEST"));
	}
}