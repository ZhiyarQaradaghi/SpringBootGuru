package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.respositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository;

    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
