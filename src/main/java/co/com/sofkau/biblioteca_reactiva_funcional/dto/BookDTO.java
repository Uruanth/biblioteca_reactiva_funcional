package co.com.sofkau.biblioteca_reactiva_funcional.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class BookDTO {

    private String id;
    @NotBlank
    private String name;
    private Boolean state;
    private LocalDate loanDate;
    private String type;
    private String thematic;

    public BookDTO() {
    }

    public BookDTO(String name, Boolean state, LocalDate loanDate, String type, String thematic) {
        this.name = name;
        this.state = state;
        this.loanDate = loanDate;
        this.type = type;
        this.thematic = thematic;
    }

    public BookDTO(String name) {
        this.name = name;
    }

    public BookDTO(String id, String name, Boolean state, LocalDate loanDate, String type, String thematic) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDTO)) return false;

        BookDTO bookDTO = (BookDTO) o;

        if (id != null ? !id.equals(bookDTO.id) : bookDTO.id != null) return false;
        if (name != null ? !name.equals(bookDTO.name) : bookDTO.name != null) return false;
        if (state != null ? !state.equals(bookDTO.state) : bookDTO.state != null) return false;
        if (loanDate != null ? !loanDate.equals(bookDTO.loanDate) : bookDTO.loanDate != null) return false;
        if (type != null ? !type.equals(bookDTO.type) : bookDTO.type != null) return false;
        return thematic != null ? thematic.equals(bookDTO.thematic) : bookDTO.thematic == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (loanDate != null ? loanDate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (thematic != null ? thematic.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResourceDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", loanDate=" + loanDate +
                ", type='" + type + '\'' +
                ", thematic='" + thematic + '\'' +
                '}';
    }
}
