package mk.ecode.books.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Author {
    private Long id;
    private String name;
    private String surname;
    private String biography;
}
