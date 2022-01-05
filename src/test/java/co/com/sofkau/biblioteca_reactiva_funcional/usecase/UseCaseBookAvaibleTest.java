package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.model.Book;
import co.com.sofkau.biblioteca_reactiva_funcional.repository.BookRepository;
import co.com.sofkau.biblioteca_reactiva_funcional.utils.Constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;


class UseCaseBookAvaibleTest {

    BookRepository repository;
    UseCaseBookAvaible usecase;

    @BeforeEach
    public void setUp() throws Exception {
        repository = Mockito.mock(BookRepository.class);
        usecase = new UseCaseBookAvaible(repository);
    }

    @Test
    void avaibleTest() {

        Mockito.when(repository.findById("idBook")).thenReturn(Mono.just(Constantes.bookAvaible));

        StepVerifier.create(usecase.apply("idBook"))
                .expectNext("true")
                .verifyComplete();


        Mockito.verify(repository, Mockito.times(1)).findById("idBook");

    }

}