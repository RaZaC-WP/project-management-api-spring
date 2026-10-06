package com.razac.projectmanagementapi.task.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(nullable = false, length = 30)
    private TaskStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDate dueDate;

    @Column(nullable = false)
    private Long projectId;

    private Long employeeId;

    public Task(String title, String description, TaskStatus status,
                LocalDate dueDate, Long projectId, Long employeeId) {
        this.createdAt = LocalDateTime.now();
        assign(title, description, status, dueDate, projectId, employeeId);
    }

    public void update(String title, String description, TaskStatus status,
                       LocalDate dueDate, Long projectId, Long employeeId) {
        assign(title, description, status, dueDate, projectId, employeeId);
    }

    private void assign(String title, String description, TaskStatus status,
                        LocalDate dueDate, Long projectId, Long employeeId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.projectId = projectId;
        this.employeeId = employeeId;
    }
}