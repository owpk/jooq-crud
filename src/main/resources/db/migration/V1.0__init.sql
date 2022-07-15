create TABLE IF NOT EXISTS "phones" (
    "id" bigserial PRIMARY KEY,
    "type" varchar(200)
);

create TABLE IF NOT EXISTS "users" (
    "id" bigserial PRIMARY KEY,
    "phone" varchar(20),
    "email" varchar(50),
    "phoneId" bigint
);

create TABLE IF NOT EXISTS "role_user" (
    "id" bigserial PRIMARY KEY,
    "userId" bigint,
    "roleId" bigint
);

create TABLE IF NOT EXISTS "roles" (
    "id" bigserial PRIMARY KEY,
    "code" varchar(255),
    "name" varchar(255)
);

create TABLE IF NOT EXISTS "records" (
    "id" bigserial PRIMARY KEY,
    "name" varchar(255),
    "data" varchar(255),
    "innerRecordId" bigint
);

create TABLE IF NOT EXISTS "inner_records" (
    "id" bigserial PRIMARY KEY,
    "name" varchar(255)
--    "innerInnerRecordId" bigint
);

create TABLE IF NOT EXISTS "inner_inner_records" (
    "id" bigserial PRIMARY KEY,
    "name" varchar(255)
);

create TABLE IF NOT exists "unique_test" (
    "id" bigserial primary key,
    "name" varchar(255),
    "val" varchar(255)
);

alter table "unique_test" add UNIQUE ("name");
alter table "unique_test" add UNIQUE ("val");

ALTER TABLE "records" ADD CONSTRAINT "fk_31" FOREIGN KEY ("innerRecordId") REFERENCES "inner_records" ("id");
--ALTER TABLE "inner_records" ADD CONSTRAINT "fk_31" FOREIGN KEY ("innerInnerRecordId") REFERENCES "inner_inner_records" ("id");

alter table "users" add CONSTRAINT "fk_4" FOREIGN KEY ("phoneId") REFERENCES "phones" ("id") ON delete CASCADE;
alter table "role_user" add CONSTRAINT "fk_5" FOREIGN KEY ("userId") REFERENCES "users" ("id") ON delete CASCADE;
alter table "role_user" add CONSTRAINT "fk_6" FOREIGN KEY ("roleId") REFERENCES "roles" ("id");
alter table "role_user" add UNIQUE ("userId", "roleId");
alter table "users" add UNIQUE ("email");
alter table "users" add UNIQUE ("phone");

alter table "records" add UNIQUE ("name");

insert into "roles" ("code", "name") values ('anonymous', 'Анонимный пользователь');
insert into "roles" ("code", "name") values ('client', 'Покупатель');
insert into "roles" ("code", "name") values ('admin', 'Администратор');
insert into "roles" ("code", "name") values ('manager', 'Менеджер');

insert into "phones" ("type") values ('Iphone');
insert into "phones" ("type") values ('Android');
insert into "phones" ("type") values ('Xiaomi');
insert into "phones" ("type") values ('Nokia');

insert into "users" ("phone", "email", "phoneId") values ('7800504', 'email@email.ru', '1');
insert into "users" ("phone", "email", "phoneId") values ('7999503', 'emaww@email.ru', '2');
insert into "users" ("phone", "email", "phoneId") values ('7000502', 'emadd@email.ru', '3');
insert into "users" ("phone", "email", "phoneId") values ('7833901', 'emass@email.ru', '4');

insert into "role_user" ("userId", "roleId") values (1, 1);
insert into "role_user" ("userId", "roleId") values (1, 2);
insert into "role_user" ("userId", "roleId") values (2, 3);
insert into "role_user" ("userId", "roleId") values (2, 4);
insert into "role_user" ("userId", "roleId") values (3, 1);
insert into "role_user" ("userId", "roleId") values (4, 2);

--insert into "inner_inner_records" ("name") values ('asddsa');
insert into "inner_records" ("name") values ('asddsa');
insert into "records" ("name", "innerRecordId") values ('asddsa', 1);

