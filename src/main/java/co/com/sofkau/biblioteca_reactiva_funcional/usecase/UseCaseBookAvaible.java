package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;


@Service
@Validated
public class UseCaseBookAvaible implements Function<String, Mono<String>> {

    private final BookRepository repository;

    public UseCaseBookAvaible(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<String> apply(String id) {
        return repository.findById(id)
                .flatMap(book -> Mono.just(book.getState().toString()));
    }
}
