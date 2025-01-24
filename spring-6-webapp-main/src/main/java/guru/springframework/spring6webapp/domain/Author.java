package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity // telling JPA that this is an entity persisted to the database
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // used to persist this entity to the database
    private String firstName;
    private String lastName;


    // When working with JPA entities - set an equals and hashCode method because hibernate is going to use this internally to determine object equity
    // YOu can just use the id property - if 2 entities have the same ID then hibernate considers them equal entities
    // YOu can use the variables/properties of the entire class instead of just the id

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    // equals and hashcode for hibernate to determine object equity -- basically for hibernate to tell if 2 objects are the same or not
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Author)) {
            return false;
        }
        Author author = (Author) o;

        return getId() != null ? getId().equals(author.getId()) : author.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() !=null ? getId().hashCode() : 0;
    }
}
