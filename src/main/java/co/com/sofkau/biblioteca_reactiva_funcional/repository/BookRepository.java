package co.com.sofkau.biblioteca_reactiva_funcional.repository;

import co.com.sofkau.biblioteca_reactiva_funcional.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findByThematic(String thematic);
    Flux<Book> findByType(String type);
}
