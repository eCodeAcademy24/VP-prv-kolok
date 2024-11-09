package mk.ecode.books.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ecode.books.model.Author;
import mk.ecode.books.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        authors.add(new Author(1L, "Author", "1", "bio 1"));
        authors.add(new Author(2L, "Author", "2", "bio 2"));
        authors.add(new Author(3L, "Author", "3", "bio 3"));
        authors.add(new Author(4L, "Author", "4", "bio 4"));
        authors.add(new Author(5L, "Author", "5", "bio 5"));

        books.add(new Book("isbn 1", "Title 1", "Genre 1", 2002));
        books.add(new Book("isbn 2", "Title 2", "Genre 2", 2003));
        books.add(new Book("isbn 3", "Title 3", "Genre 3", 2004));
        books.add(new Book("isbn 4", "Title 4", "Genre 4", 2005));
        books.add(new Book("isbn 5", "Title 5", "Genre 5", 2006));
    }
}
