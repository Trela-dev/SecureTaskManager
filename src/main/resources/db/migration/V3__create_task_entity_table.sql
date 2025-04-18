-- Tworzenie tabeli task_entity
CREATE TABLE task_entity (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    description VARCHAR(255),
    status VARCHAR(50) NOT NULL DEFAULT 'STARTED',
    deadline TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES "users"(id) ON DELETE CASCADE
);

-- Insert tasks for user with id = 1
INSERT INTO task_entity (user_id, description, status, deadline) VALUES
(1, 'Fix bug in login authentication module', 'STARTED', '2025-04-18'),
(1, 'Implement new feature for user profile settings', 'IN_PROGRESS', '2025-04-20');

-- Insert tasks for user with id = 2
INSERT INTO task_entity (user_id, description, status, deadline) VALUES
(2, 'Write unit tests for the order processing system', 'IN_PROGRESS', '2025-04-22'),
(2, 'Refactor the database schema for better performance', 'FINISHED', '2025-04-15');

-- Insert tasks for user with id = 3
INSERT INTO task_entity (user_id, description, status, deadline) VALUES
(3, 'Update documentation for API endpoints', 'STARTED', '2025-04-25'),
(3, 'Optimize image loading on the front-end', 'CANCELLED', '2025-04-12');

-- Insert tasks for user with id = 4
INSERT INTO task_entity (user_id, description, status, deadline) VALUES
(4, 'Set up CI/CD pipeline for new microservice', 'IN_PROGRESS', '2025-04-19'),
(4, 'Resolve memory leak in file upload module', 'IN_PROGRESS', '2025-04-21');

-- Insert tasks for user with id = 5
INSERT INTO task_entity (user_id, description, status, deadline) VALUES
(5, 'Improve accessibility for sign-up form', 'STARTED', '2025-04-23'),
(5, 'Design mockups for the new dashboard', 'FINISHED', '2025-04-14');

-- Insert tasks for user with id = 6
INSERT INTO task_entity (user_id, description, status, deadline) VALUES
(6, 'Implement logging with ELK stack', 'IN_PROGRESS', '2025-04-24'),
(6, 'Add pagination to comments section', 'STARTED', '2025-04-28');

-- Insert tasks for user with id = 7
INSERT INTO task_entity (user_id, description, status, deadline) VALUES
(7, 'Research GraphQL integration options', 'STARTED', '2025-04-30'),
(7, 'Fix CSS issues in dark mode layout', 'CANCELLED', '2025-04-10');
