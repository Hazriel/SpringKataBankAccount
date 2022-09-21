INSERT INTO account_owners (id, firstname, lastname) VALUES (1, 'John', 'Doe');
INSERT INTO accounts (id, money, owner_id, created_at) VALUES (1, 100, 1, NOW());