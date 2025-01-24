package guru.springframework.spring6webapp.respositories;

import guru.springframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

// spring data jpa is going to provide us the implementations for CRUD operations - a spring bean we can use
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
