package jay.springframework.spring5webapp.repositories;

import jay.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepositories extends CrudRepository<Publisher, Long> {
}
