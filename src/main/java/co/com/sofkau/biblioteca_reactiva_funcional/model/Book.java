package co.com.sofkau.biblioteca_reactiva_funcional.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document("book")
public class Book {
    @Id
    private String id;
    private String name;
    private Boolean state;
    private LocalDate loanDate;
    private String type;
    private String thematic;

    public Book() {
    }

    public Book(String name, Boolean state, LocalDate loanDate, String type, String thematic) {
        this.name = name;
        this.state = state;
        this.loanDate = loanDate;
        this.type = type;
        this.thematic = thematic;
    }

    public Book(String id, String name, Boolean state, LocalDate loanDate, String type, String thematic) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.loanDate = loanDate;
        this.type = type;
        this.thematic = thematic;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", loanDate=" + loanDate +
                ", type='" + type + '\'' +
                ", thematic='" + thematic + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThematic() {
        return thematic;
    }

    public void setThematic(String thematic) {
        this.thematic = thematic;
    }
}
