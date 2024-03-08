package hh_sof03.bookstore2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh_sof03.bookstore2.domain.BookRepository;
import hh_sof03.bookstore2.domain.CategoryRepository;
import hh_sof03.bookstore2.domain.Book;
import hh_sof03.bookstore2.domain.Category;
import hh_sof03.bookstore2.domain.User;
import hh_sof03.bookstore2.domain.UserRepository;

@SpringBootApplication
public class Bookstore2Application {

	private static final Logger log = LoggerFactory.getLogger(Bookstore2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2Application.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository BookRepository,
	CategoryRepository cRepository, UserRepository uRepository) {
		return (args) -> {
			log.info("saving books");
			cRepository.save(new Category("Comedy"));
			cRepository.save(new Category("Horror"));
			cRepository.save(new Category("Tragedy"));

			BookRepository.save(new Book("943-46575-7", "Big Scary Book", "Matias Lento", 2021, 15.00,
					cRepository.findByName("Horror").get(0)));
			BookRepository.save(new Book("8464-2523", "Little Funny Book", "Matias Lento", 2022, 10.00,
					cRepository.findByName("Comedy").get(0)));
			BookRepository.save(new Book("835-728357458", "Short Sad Book", "Matias Lento", 2023, 100.00,
					cRepository.findByName("Tragedy").get(0)));

			User user1 = new User("user", "$2a$10$rXDzQdck/8YPYyqgBLJODe.3/.P7l18ZibXzsTSLZP4NHYYHWE5qm", "USER");
			User user2 = new User("admin", "$2a$10$zxXy45iQui5/DqaiQMBXNOZ3kkQGfvbwIcnOz.02cIAQOT05Nzf2O", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);

			for (Book book : BookRepository.findAll()) {
				log.info(book.toString());
			}
			;
		};
	}
}
