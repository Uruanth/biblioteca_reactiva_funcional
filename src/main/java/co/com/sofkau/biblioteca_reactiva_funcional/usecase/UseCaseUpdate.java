package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.dto.BookDTO;
import co.com.sofkau.biblioteca_reactiva_funcional.mappers.BookMapper;
import co.com.sofkau.biblioteca_reactiva_funcional.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;


@Service
@Validated
public class UseCaseUpdate implements Function<BookDTO, Mono<BookDTO>> {
    private final BookRepository repository;
    private final BookMapper mapper;

    public UseCaseUpdate(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Mono<BookDTO> apply(BookDTO bookDTO) {
        return repository.findById(bookDTO.getId())
                .flatMap(book ->
                        repository.save(mapper.mapperToBook(bookDTO.getId())
                                        .apply(bookDTO))
                                .map(mapper.mapToDTO()))
                .switchIfEmpty(Mono.empty());
    }
}

