package com.hooli.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name is required.")
    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ]+(\s[a-zA-Zà-ÿÀ-Ÿ]+)*$",
            message = "First name must only contain alphabetical characters.")
    @Size(min = 2, message = "First name must be at least 2 characters.")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name is required.")
    @Pattern(regexp = "^[a-zA-Zà-ÿÀ-Ÿ]+(\s[a-zA-Zà-ÿÀ-Ÿ]+)*$",
            message = "Last name must only contain alphabetical characters.")
    @Size(min = 2, message = "Last name must be at least 2 characters.")
    private String lastName;

    @Email(message = "Email address is required.")
    @Column(name = "email_address", unique = true)
    private String emailAddress;

    @Column(nullable = false)
    @Size(min = 8, message = "Password must be at least 8 characters.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password is required.")
    private String password;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}