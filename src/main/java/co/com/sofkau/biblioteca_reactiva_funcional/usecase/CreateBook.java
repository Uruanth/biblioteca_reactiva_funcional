package co.com.sofkau.biblioteca_reactiva_funcional.usecase;

import co.com.sofkau.biblioteca_reactiva_funcional.dto.BookDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateBook {
    public Mono<String> apply(BookDTO bookDTO);
}
