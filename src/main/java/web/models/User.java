package web.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public User(long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "first_name")
    @NotEmpty(message = "Name can't be empty")
    @Pattern(regexp = "^[\\p{L}]+(?: [\\p{L}]+)*$", message = "Имя может содержать только буквы")
    @Size(min = 2, max = 20, message = "Имя в пределах от 2 до 10 знаков")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "lastname can't be empty")
    @Pattern(regexp = "^[\\p{L}]+(?: [\\p{L}]+)*$", message = "Фамилия может содержать только буквы")
    @Size(min = 2, max = 20, message = "Фамилия в пределах от 2 до 10 знаков")
    private String lastName;



    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return String.format("firstname = %s  lastname = %s", name, lastName);
    }
}
