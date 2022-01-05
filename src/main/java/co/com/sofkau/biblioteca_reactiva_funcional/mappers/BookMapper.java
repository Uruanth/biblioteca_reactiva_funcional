package co.com.sofkau.biblioteca_reactiva_funcional.mappers;

import co.com.sofkau.biblioteca_reactiva_funcional.dto.BookDTO;
import co.com.sofkau.biblioteca_reactiva_funcional.model.Book;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookMapper {

    public Function<BookDTO, Book>  mapperToBook(String id){
        return updateBook -> {
            var book = new Book();
            book.setId(id);
            book.setName(updateBook.getName());
            book.setState(updateBook.getState());
            book.setLoanDate(updateBook.getLoanDate());
            book.setType(updateBook.getType());
            book.setThematic(updateBook.getThematic());
            return book;
        };
    }

    public Function<Book, BookDTO> mapToDTO(){
        return entity -> new BookDTO(
                entity.getId(),
                entity.getName(),
                entity.getState(),
                entity.getLoanDate(),
                entity.getType(),
                entity.getThematic()
        );
    }
}
