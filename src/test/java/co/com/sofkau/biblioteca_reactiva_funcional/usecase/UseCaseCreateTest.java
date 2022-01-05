package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.mappers.BookMapper;
import co.com.sofkau.biblioteca_reactiva_funcional.repository.BookRepository;
import co.com.sofkau.biblioteca_reactiva_funcional.utils.Constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;

class UseCaseCreateTest {
    BookRepository repository;
    UseCaseCreate usecase;
    BookMapper mapper;

    @BeforeEach
    public void setUp() throws Exception {
        repository = Mockito.mock(BookRepository.class);
        mapper = new BookMapper();
        usecase = new UseCaseCreate(repository, mapper);
    }

    @Test
    void createBook(){

        var bookDTO = mapper.mapToDTO().apply(Constantes.bookToCreate);
        var id =  Constantes.bookCreated.getId();

        Mockito.when(repository.save(Mockito.any())).thenReturn(Mono.just(Constantes.bookCreated));

        StepVerifier.create(usecase.apply(bookDTO))
                .expectNext(id)
                .verifyComplete();

        Mockito.verify(repository, Mockito.times(1)).save(refEq(Constantes.bookToCreate));

    }
}