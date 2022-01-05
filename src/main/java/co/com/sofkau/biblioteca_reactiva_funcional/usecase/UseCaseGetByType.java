package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.dto.BookDTO;
import co.com.sofkau.biblioteca_reactiva_funcional.mappers.BookMapper;
import co.com.sofkau.biblioteca_reactiva_funcional.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class UseCaseGetByType implements Function<String, Flux<BookDTO>> {
    private final BookRepository repository;
    private final BookMapper mapper;

    public UseCaseGetByType(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Flux<BookDTO> apply(String type) {
        return repository.findByType(type)
                .map(mapper.mapToDTO());
    }
}
