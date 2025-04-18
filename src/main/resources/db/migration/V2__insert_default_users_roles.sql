-- Insert roles
INSERT INTO "roles" (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

-- Insert users (passwords should be encoded in the application)
-- everyone has the same password 12345
INSERT INTO "users" (username, password) VALUES
('john', '$2a$12$ybpqNOTUAurUGjDH.xED9.A341wGZsXl0G6wworXUaBbSk00OgJG6'),
('jane', '$2a$12$ybpqNOTUAurUGjDH.xED9.A341wGZsXl0G6wworXUaBbSk00OgJG6'),
('alice', '$2a$12$ybpqNOTUAurUGjDH.xED9.A341wGZsXl0G6wworXUaBbSk00OgJG6'),
('bob', '$2a$12$ybpqNOTUAurUGjDH.xED9.A341wGZsXl0G6wworXUaBbSk00OgJG6'),
('charlie', '$2a$12$ybpqNOTUAurUGjDH.xED9.A341wGZsXl0G6wworXUaBbSk00OgJG6'),
('diana', '$2a$12$ybpqNOTUAurUGjDH.xED9.A341wGZsXl0G6wworXUaBbSk00OgJG6'),
('eric', '$2a$12$ybpqNOTUAurUGjDH.xED9.A341wGZsXl0G6wworXUaBbSk00OgJG6');

-- Assign roles to users
INSERT INTO "user_roles" (user_id, role_id)
VALUES
((SELECT id FROM "users" WHERE username = 'john'), (SELECT id FROM "roles" WHERE name = 'ROLE_ADMIN')),
((SELECT id FROM "users" WHERE username = 'jane'), (SELECT id FROM "roles" WHERE name = 'ROLE_USER')),
((SELECT id FROM "users" WHERE username = 'alice'), (SELECT id FROM "roles" WHERE name = 'ROLE_USER')),
((SELECT id FROM "users" WHERE username = 'bob'), (SELECT id FROM "roles" WHERE name = 'ROLE_USER')),
((SELECT id FROM "users" WHERE username = 'charlie'), (SELECT id FROM "roles" WHERE name = 'ROLE_USER')),
((SELECT id FROM "users" WHERE username = 'diana'), (SELECT id FROM "roles" WHERE name = 'ROLE_USER')),
((SELECT id FROM "users" WHERE username = 'eric'), (SELECT id FROM "roles" WHERE name = 'ROLE_USER'));
