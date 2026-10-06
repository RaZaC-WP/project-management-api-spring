package com.razac.projectmanagementapi.employee.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String fullName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String position;

    public Employee(String fullName, String email, String position) {
        assign(fullName, email, position);
    }

    public void update(String fullName, String email, String position) {
        assign(fullName, email, position);
    }

    private void assign(String fullName, String email, String position) {
        this.fullName = fullName;
        this.email = email;
        this.position = position;
    }
}