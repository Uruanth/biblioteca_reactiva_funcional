package co.com.sofkau.biblioteca_reactiva_funcional.routers;

import co.com.sofkau.biblioteca_reactiva_funcional.dto.BookDTO;
import co.com.sofkau.biblioteca_reactiva_funcional.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<ServerResponse> createBook(UseCaseCreate useCaseCreate) {

        Function<BookDTO, Mono<ServerResponse>> executor = BookDTO -> {
            return useCaseCreate.apply(BookDTO)
                    .flatMap(result -> ServerResponse.ok()
                            .contentType(MediaType.TEXT_PLAIN)
                            .bodyValue(result));
        };

        return route(POST("/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> {
                    System.out.println(request.bodyToMono(BookDTO.class));
                    return request.bodyToMono(BookDTO.class).flatMap(executor);
                }

        );
    }


    @Bean
    public RouterFunction<ServerResponse> getAll(UseCaseGetAll useCaseGetAll) {
        return route(
                GET("/getall")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseGetAll.get(), BookDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> bookAvaible(UseCaseBookAvaible useCase) {
        return route(
                GET("/getAvaible/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")),
                                String.class))
        );
    }


    @Bean
    public RouterFunction<ServerResponse> getById(UseCaseGetById usecase) {
        return route(
                GET("/book/{id}"),
                request -> {
                    System.out.println(request.pathVariable("id"));
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromPublisher(usecase.apply(
                                            request.pathVariable("id")
                                    ),
                                    BookDTO.class));
                }
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getByThematic(UseCaseGetByThematic usecase) {

        return route(
                GET("/thematic/{thematic}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(usecase.apply(
                                request.pathVariable("thematic")
                        ), BookDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getByType(UseCaseGetByType usecase) {
        return route(
                GET("/type/{type}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                usecase.apply(
                                        request.pathVariable("type")),
                                BookDTO.class
                        ))

        );
    }


    @Bean
    public RouterFunction<ServerResponse> update(UseCaseUpdate usecase) {
        return route(
                PUT("/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BookDTO.class)
                        .flatMap(bookDTO -> usecase.apply(bookDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        ));
    }

    @Bean
    public RouterFunction<ServerResponse> delete(UseCaseDelete usecase) {
        return route(
                DELETE("/delete/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(usecase.apply(
                                request.pathVariable("id")), Void.class)
                        )
        );
    }

    @Bean
    public RouterFunction<ServerResponse> lendAResource(UseCaseLendBook usecase) {
        return route(
                GET("/lend/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                usecase.apply(request.pathVariable("id")),
                                BookDTO.class))
        );
    }


    @Bean
    public RouterFunction<ServerResponse> returnResource(UseCaseReturnBook usecase) {
        return route(
                GET("/returnBook/{id}"),
                request -> ServerResponse.accepted()
                        .body(BodyInserters.fromPublisher(
                                usecase.apply(request.pathVariable("id"))
                                , BookDTO.class))
        );

    }
}
