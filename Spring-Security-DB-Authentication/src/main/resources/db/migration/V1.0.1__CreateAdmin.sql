INSERT INTO USER (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, password, username, version)
            VALUES(1, 1, 1, 1, 1, 'deepak', 'sp', '$2a$10$SErEA9tktBS601aOxp3g5uRrZt9uCOydihIzzrqIPQQRlnyF3GkNK', 'deepak', 0);
INSERT INTO ROLE (id,role) VALUES (2,'ROLE_ADMIN');
INSERT INTO USER_ROLES (user_id,roles_id) VALUES (1,2);