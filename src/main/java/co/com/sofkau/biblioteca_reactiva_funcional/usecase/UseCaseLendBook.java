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
public class UseCaseLendBook implements Function<String, Mono<BookDTO>> {

    private final BookRepository repository;
    private final BookMapper mapper;
    private final UseCaseGetById getById;
    private final UseCaseBookAvaible avaible;

    public UseCaseLendBook(BookRepository repository, BookMapper mapper, UseCaseGetById getById, UseCaseBookAvaible avaible) {
        this.repository = repository;
        this.mapper = mapper;
        this.getById = getById;
        this.avaible = avaible;
    }

    @Override
    public Mono<BookDTO> apply(String id) {
        return avaible.apply(id)
                .filter(isAvailable -> isAvailable == "true")
                .flatMap(isAvailable ->
                        getById.apply(id)
                                .flatMap(book -> {
                                            book.setState(false);
                                            return repository.save(mapper.mapperToBook(id)
                                                            .apply(book))
                                                    .map(mapper.mapToDTO());
                                        }

                                ));
    }
}
