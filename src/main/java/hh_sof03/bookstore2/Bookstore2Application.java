package hh_sof03.bookstore2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh_sof03.bookstore2.domain.BookRepository;
import hh_sof03.bookstore2.domain.Book;

@SpringBootApplication
public class Bookstore2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2Application.class, args);
	}

	@Bean(destroyMethod="")
	public CommandLineRunner bookDemo(BookRepository BookRepository) {
		return (args) -> {

			BookRepository.save(new Book("9780582461512", "Cannery Row", "John Steinbeck", 1945, 15.00));
			BookRepository.save(new Book("978-951-0-322-95-6", "1984", "George Orwell", 1949, 20.00));
			BookRepository.save(new Book("10-5050000149", "Crime and Punishment", "Fyodor Dostoevsky", 1866, 40.00));

		};
	}
	
}
