package se.lexicon.jpaworkshop.entity;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(length = 250,nullable = false,unique = true)
    private String isbn;

    @Column(nullable = false,length = 250)
    private String title;
    @Column(nullable = false)
    private int maxLoanDays;

    @ManyToMany(
            mappedBy = "writtenBooks",
            cascade = {CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY)

    private Set<Author> authors;

 // todo: add to convinient method for adding and removing author into the list


    public void addAuthor(Author author) {
        authors.add(author);
        author.getWrittenBooks().add(this);
    }

    public void removeAuthor(Author author) {
        author.getWrittenBooks().remove(this);
        authors.remove(author);
    }


    public Book() {
    }

    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public Book(int bookId, String isbn, String title, int maxLoanDays) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public Book(String isbn, String title, int maxLoanDays, Set<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        setAuthors(new HashSet<>());
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() && getMaxLoanDays() == book.getMaxLoanDays() && getIsbn().equals(book.getIsbn()) && getTitle().equals(book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getIsbn(), getTitle(), getMaxLoanDays());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", maxLoanDays=" + maxLoanDays +
                '}';
    }
}
