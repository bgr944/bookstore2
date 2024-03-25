package hh_sof03.bookstore2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh_sof03.bookstore2.domain.Book;

import hh_sof03.bookstore2.domain.BookRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByIdShouldReturnBook() {
        List<Book> books = repository.findByTitle("Big Scary Book");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getIsbn()).isEqualTo("943-46575-8");
    }
    
    @Test
    public void createNewBook() {
        Book book = new Book("943-46575-7", "Big Scary Book", "John Author", 2021, 15.00, null);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }


    @Test
    public void deleteEveryBook() {
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }
}