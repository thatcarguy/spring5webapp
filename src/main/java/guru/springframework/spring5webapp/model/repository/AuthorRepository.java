package guru.springframework.spring5webapp.model.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
