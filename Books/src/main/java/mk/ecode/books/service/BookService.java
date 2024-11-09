package mk.ecode.books.service;

import mk.ecode.books.model.Author;
import mk.ecode.books.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();

    Book addAuthorToBook(Long authorId, String isbn);

    Book findBookByIsbn(String isbn);
}
