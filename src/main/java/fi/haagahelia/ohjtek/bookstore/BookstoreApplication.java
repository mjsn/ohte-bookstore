package fi.haagahelia.ohjtek.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.ohjtek.bookstore.domain.Book;
import fi.haagahelia.ohjtek.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("Add some books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 10));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 12));	
			
			log.info("Getch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
