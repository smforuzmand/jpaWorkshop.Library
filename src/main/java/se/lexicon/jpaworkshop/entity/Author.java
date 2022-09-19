package se.lexicon.jpaworkshop.entity;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(length = 255, nullable = false)
    private String firstName;
    @Column(length = 255, nullable = false)
    private String lastName;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_Id"),
            inverseJoinColumns = @JoinColumn(name = "book_Id")
    )
    private Set<Book> writtenBooks;


    // add two method add and remove

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Parameter Book is null");
        if (writtenBooks == null) setWrittenBooks(new HashSet<>());


        if (!writtenBooks.contains(book)){
            book.getAuthors().add(this);
            writtenBooks.add(book);
        }
    }

    public void removeBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Parameter Book is null");
        if (writtenBooks == null) setWrittenBooks(new HashSet<>());

        if (writtenBooks.contains(book)){
            book.getAuthors().remove(this);
            writtenBooks.remove(book);
        }
    }


    public Author(String firstName, String lastName, Set<Book> writtenBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }

    public Author() {

    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        setWrittenBooks(new HashSet<>());
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(Set<Book> writtenBooks) {
        this.writtenBooks = new HashSet<>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getAuthorId() == author.getAuthorId() && Objects.equals(getFirstName(), author.getFirstName()) && Objects.equals(getLastName(), author.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getFirstName(), getLastName());
    }



    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", writtenBooks=" + writtenBooks +
                '}';
    }
}



