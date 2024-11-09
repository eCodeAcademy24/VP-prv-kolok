package mk.ecode.books.service.impl;

import mk.ecode.books.model.Author;
import mk.ecode.books.model.Book;
import mk.ecode.books.repository.BookRepository;
import mk.ecode.books.service.AuthorService;
import mk.ecode.books.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addAuthorToBook(Long authorId, String isbn) {
        Author author = authorService.findById(authorId);
        Book book = findBookByIsbn(isbn);
        return bookRepository.addAuthorToBook(author, book);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
