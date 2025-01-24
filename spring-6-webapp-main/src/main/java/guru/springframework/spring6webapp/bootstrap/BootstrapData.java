package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.respositories.AuthorRepository;
import guru.springframework.spring6webapp.respositories.BookRepository;
import guru.springframework.spring6webapp.respositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner { // when it detects this component, it will create a spring bean for this and execute the run everytime springboot starts up

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // saving 2 authors and 2 books

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("987654321");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        Publisher johny = new Publisher();
        johny.setName("John Doe");
        johny.setAddress("Moon");
        johny.setCity("London");
        johny.setState("New York");
        johny.setZip("44000");

        Publisher johnySaved = publisherRepository.save(johny);

        Publisher manny = new Publisher();
        manny.setName("Manny Doe");
        manny.setAddress("Mars");
        manny.setCity("Nova One");
        manny.setState("Colombia State");
        manny.setZip("44001");

        Publisher mannySaved = publisherRepository.save(manny);

        // association between the 2 authors and the 2 books

        // null pointer if authors and books are not initialized
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        johnySaved.getBooks().add(noEJBSaved);
        mannySaved.getBooks().add(dddSaved);

        // persist objects so that changes made in the relationship between the 2 are saved in the H2 in memory database
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);
        publisherRepository.save(mannySaved);
        publisherRepository.save(johnySaved);

        System.out.println("In BootStrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
