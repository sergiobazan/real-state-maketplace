INSERT INTO users.roles (id, name)
VALUES (gen_random_uuid(), 'USER'),
       (gen_random_uuid(), 'SELLER'),
       (gen_random_uuid(), 'BUYER')
    ON CONFLICT (name) DO NOTHING;
