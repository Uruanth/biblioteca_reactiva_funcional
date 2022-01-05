package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.dto.BookDTO;
import co.com.sofkau.biblioteca_reactiva_funcional.mappers.BookMapper;
import co.com.sofkau.biblioteca_reactiva_funcional.model.Book;
import co.com.sofkau.biblioteca_reactiva_funcional.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;


@Service
@Validated
public class UseCaseCreate implements CreateBook{

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public UseCaseCreate(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Mono<String> apply(BookDTO bookDTO) {
        return bookRepository.save(bookMapper.mapperToBook(null).apply(bookDTO)).map(Book::getId);
    }
}
