package com.example.SpringBootHR.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee", columnDefinition = "bigserial")
    private long idEmployee;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "date_birthday")
    private LocalDate dateBirthday;
    @Column(name = "date_start_position")
    private LocalDate dateStartPosition;

    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "id_position", foreignKey = @ForeignKey(name = "id_position_fk"))
    private Position position;

    public Employee() {
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public LocalDate getDateStartPosition() {
        return dateStartPosition;
    }

    public void setDateStartPosition(LocalDate dateStartPosition) {
        this.dateStartPosition = dateStartPosition;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
