CREATE TABLE employees (
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    email     VARCHAR(100) NOT NULL,
    position  VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uq_employees_email UNIQUE (email)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE projects (
    id          BIGINT        NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255)  NOT NULL,
    description VARCHAR(2000) NULL,
    start_date  DATE          NOT NULL,
    end_date    DATE          NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE project_employee (
    project_id  BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, employee_id),
    CONSTRAINT fk_project_employee_project  FOREIGN KEY (project_id)  REFERENCES projects (id)  ON DELETE CASCADE,
    CONSTRAINT fk_project_employee_employee FOREIGN KEY (employee_id) REFERENCES employees (id) ON DELETE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE tasks (
    id          BIGINT        NOT NULL AUTO_INCREMENT,
    title       VARCHAR(255)  NOT NULL,
    description VARCHAR(2000) NULL,
    status      VARCHAR(30)   NOT NULL DEFAULT 'PENDING',
    created_at  DATETIME(6)   NOT NULL,
    due_date    DATE          NULL,
    project_id  BIGINT        NOT NULL,
    employee_id BIGINT        NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_tasks_project  FOREIGN KEY (project_id)  REFERENCES projects (id),
    CONSTRAINT fk_tasks_employee FOREIGN KEY (employee_id) REFERENCES employees (id),
    INDEX idx_tasks_status (status)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;