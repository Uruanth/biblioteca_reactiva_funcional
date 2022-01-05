package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.dto.BookDTO;
import co.com.sofkau.biblioteca_reactiva_funcional.mappers.BookMapper;
import co.com.sofkau.biblioteca_reactiva_funcional.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;


@Service
@Validated
public class UseCaseGetAll implements Supplier<Flux<BookDTO>> {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public UseCaseGetAll(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Flux<BookDTO> get() {
        return bookRepository.findAll().map(bookMapper.mapToDTO());
    }
}
