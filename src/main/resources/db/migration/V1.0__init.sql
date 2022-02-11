CREATE TABLE IF NOT EXISTS "users" (
    "id" bigserial PRIMARY KEY,
    "phone" varchar(20),
    "email" varchar(50)
);

CREATE TABLE IF NOT EXISTS "role_user" (
    "id" bigserial PRIMARY KEY,
    "userId" bigint,
    "roleId" bigint
);

CREATE TABLE IF NOT EXISTS "roles" (
    "id" bigserial PRIMARY KEY,
    "code" varchar(255),
    "name" varchar(255)
);

ALTER TABLE "role_user" ADD CONSTRAINT "fk_5" FOREIGN KEY ("userId") REFERENCES "users" ("id");
ALTER TABLE "role_user" ADD CONSTRAINT "fk_6" FOREIGN KEY ("roleId") REFERENCES "roles" ("id");
ALTER TABLE "role_user" ADD UNIQUE ("userId", "roleId");
ALTER TABLE "users" ADD UNIQUE ("phone");

INSERT INTO "roles" ("code", "name") VALUES ('anonymous', 'Анонимный пользователь');
INSERT INTO "roles" ("code", "name") VALUES ('client', 'Покупатель');
INSERT INTO "roles" ("code", "name") VALUES ('admin', 'Администратор');
INSERT INTO "roles" ("code", "name") VALUES ('manager', 'Менеджер');

INSERT INTO "users" ("phone", "email") VALUES ('7800504', 'email@email.ru');
INSERT INTO "users" ("phone", "email") VALUES ('7999503', 'emaww@email.ru');
INSERT INTO "users" ("phone", "email") VALUES ('7000502', 'emadd@email.ru');
INSERT INTO "users" ("phone", "email") VALUES ('7833901', 'emass@email.ru');

INSERT INTO "role_user" ("userId", "roleId") VALUES (1, 1);
INSERT INTO "role_user" ("userId", "roleId") VALUES (1, 2);
INSERT INTO "role_user" ("userId", "roleId") VALUES (2, 3);
INSERT INTO "role_user" ("userId", "roleId") VALUES (2, 4);
INSERT INTO "role_user" ("userId", "roleId") VALUES (3, 1);
INSERT INTO "role_user" ("userId", "roleId") VALUES (4, 2);
