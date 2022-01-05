package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.dto.BookDTO;
import co.com.sofkau.biblioteca_reactiva_funcional.mappers.BookMapper;
import co.com.sofkau.biblioteca_reactiva_funcional.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Validated
public class UseCaseGetById implements Function<String, Mono<BookDTO>> {
//public class UseCaseGetById implements Supplier<BookDTO> {

    private final BookRepository repository;
    private final BookMapper mapper;

    public UseCaseGetById(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Mono<BookDTO> apply(String id) {

        return repository.findById(id)
                .map(book -> {
                    System.out.println("book = " + book);
                    return mapper.mapToDTO().apply(book);
                });
    }

}
