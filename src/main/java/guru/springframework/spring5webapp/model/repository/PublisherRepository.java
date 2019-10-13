package guru.springframework.spring5webapp.model.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
