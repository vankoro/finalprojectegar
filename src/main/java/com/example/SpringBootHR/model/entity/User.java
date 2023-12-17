package com.example.SpringBootHR.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", columnDefinition = "bigserial")
    private long id;

    @Column(name = "login", unique = true)
    @Size(min = 4, max = 30, message = "Логин должен быть от 4 до 30 символов!")
    private String login;

    @Column(name = "password")
    @Size(min = 8, message = "Пароль должен содержать не менее 8 символов!")
    private String password;

    @Column(name = "role")
    private String role;

    public User() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
