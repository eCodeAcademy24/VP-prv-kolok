# Books Application

## Опис на проектот

Креирајте нов Spring Boot проект со група mk.ecode и artefactId=books

Дефинирајте пакет mk.ecode.books.model и во него креирајте ја Author класата. Таа треба да содржи:

- Long id
- String name
- String surname
- String biography

Во mk.ecode.books.model креирајте Book класа која ќе содржи:

- String isbn
- String title
- String genre
- int year
```java 
List<Author> authors;
```

Една песна може да има повеќе автори

Креирајте класа AuthorRepository во пакетот mk.ecode.books.repository, во која ќе чувате List<Author> иницијализирана со 5 вредности.

Имплементирајте метод public List<Author> findAll(); кој само ќе ја врати листата.
Имплементирајте метод public Optional<Author> findById(Long id); кој ќе го врати авторот со id еднакво на пратената вредност во параметарот.

Креирајте класа BookRepository во пакетот mk.ecode.books.repository, во која ќе чувате List<Book> иницијализирана со 5 вредности.

Имплементирајте метод public List<Book> findAll(); кој само ќе ја врати листата.
Имплементирајте метод public Book findByIsbn(String isbn); кој ќе ја врати книгата чиј isbn е еднаков на испратената вредност на isbn во параметарот на функцијата.
Имплементирајте метод Book addAuthorToBook(Author author, Book book); кој ќе направи додавање на нов автор во листата од автори за одредена книга.

Дефинирајте ги следните интерфејси во mk.ecode.books.service кои ќе ги претставуваат бизнис функционалностите на апликацијата:
```java
public interface AuthorService{
    List<Author> listAuthors();
    Author findById(Long id);
}
public interface BookService{
    List<Book> listBooks();
    Book addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
}
```

Имплементирајте ги сервисите AuthorService (треба да зависи од AuthorRepository) и BookService (треба да зависи од BookRepository и AuthorRepository).
Целта на вежбата е да се креираат страници од кои ќе се избере книга и автор, а потоа избраниот автор да се додаде во листата на автори за избраната книга. 
Следете ги наредните чекори за да го имплементирате ваквото однесување.

Креирајте сервлет BookListServlet во пакетот mk.ecode.books.web и мапирајте го на патеката /listBooks. 
Овој сервлет треба да зависи од BookService и да ги прикаже сите добиени книги од методот listBooks().

Прилагодете го фајлот listBooks.html за изгледот на оваа страница.

```html
<html>
<head>
    <meta charset="utf-8">
    <title>Books Homepage - Welcome to My Book Store</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
        }
    </style>
</head>
<body>
<header>
    <h1>Welcome to My Book Store</h1>
</header>
<main>
    <h2>Choose book:</h2>
    <!-- Display radio buttons for each book,
            the value should be the isbn 
            and the displayed text should be Title: <bookTitle>, Genre:<genre>, Year: <year> -->
    <input type="radio" name="bookIsbn" value="1"> Book 1 <br/>
    <input type="radio" name="bookIsbn" value="2"> Book 2<br/>
    <input type="radio" name="bookIsbn" value="3"> Book 3 <br/>
    <input type='submit' value='Submit'>
</main>
</body>
</html>
```

Забелешка. Вредноста на секоја ставка во radio листата е isbn-от на книгата.

По избор на книга, треба да ја прикажете страница со автори. За оваа цел креирајте сервлет АuthorServlet мапиран на /author.

Овој сервлет треба да ја прикажете страната за избор на автор за додавање на книгата
Во фолдерот src/main/resources/templates додадете фајл authorList.html.

Прилагодете го фајлот authorList.html за изгледот на оваа страница.

```html
<html>
<head>
    <meta charset="utf-8">
    <title>Add new Author to Book</title>
    <style type = "text/css">
        body {
            width: 800px;
            margin: auto;
        }
        table {
            width:100%;
        }
        table, td, th {
            border: 1px solid black;
            padding:3px 2px;
        }
        section {
            float: left;
            margin: 0 1.5%;
            width: 63%;
        }
        aside {
            float: right;
            margin: 0 1.5%;
            width: 30%;
        }
    </style>
</head>
<body>
<header>
    <h1>Select the Author to add to the Book </h1>
</header>
<section>
    <h2>Select author:</h2>
    <!-- Make changes to this code to dynamically display radio buttons for each author as in the example -->
    <input type="radio" name="authorId" value="1"> Петар Петров <br/>
    <input type="radio" name="authorId" value="2"> Миле Милев <br/>
    <input type="radio" name="authorId" value="3"> Ѓорѓи Ѓорѓиев <br/>
    <br/>

    <input type='submit' value='Add author'>
</section>
<aside>
    <table>
        <tr>
            <!-- change to show selected book isbn -->
            <td><b>Book Isbn</b></td>
            <td>2</td>
        </tr>
    </table>
</aside>
</body>
</html>
```

Забелешка. Вредноста на секоја ставка во radio листата е id-от на авторот.

Креирајте сервлет со име bookDetails. Овој сервлет треба да ги прикаже сите детали за книгата во која е додаден селектираниот автор од претходниот чекор. 
При тоа, треба да ги излистате насловот, жанрот, годината на објавување и сите автори на книгата.
Прилагодете го фајлот bookDetails.html за изгледот на оваа страница.

```html
</head>
<body>
<!-- dynamically display data -- >
<header>
   <h1>Book title</h1>
</header>
<section>
    <h2>Genre</h2>
    <h2>Year</h2>
    <h2>Authors:</h2>
    <ul>
        <li>Петар Петров</li>
        <li>Јован Јованов</li>
    </ul>
</section>

</body>
```