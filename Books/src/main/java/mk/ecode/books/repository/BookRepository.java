package mk.ecode.books.repository;

import mk.ecode.books.bootstrap.DataHolder;
import mk.ecode.books.model.Author;
import mk.ecode.books.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    public List<Book> findAll() {
        return DataHolder.books;
    }

    public Book findByIsbn(String isbn) {
        return DataHolder.books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow();
    }

    public Book addAuthorToBook(Author author, Book book) {
        book.getAuthors().add(author);
        return book;
    }
}
