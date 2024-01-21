package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "The \"First name\" field must not be empty")
    @Size(min = 2, max = 25, message = "First name must be from 2 to 25 characters")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty(message = "The \"Last name\" field must not be empty")
    @Size(min = 2, max = 30, message = "Last name must be from 2 to 30 characters")
    private String lastName;

    @Column(name = "email")
    @NotEmpty(message = "The \"Email\" field must not be empty")
    @Email(message = "Email is not valid")
    private String email;

    public User() {}
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
