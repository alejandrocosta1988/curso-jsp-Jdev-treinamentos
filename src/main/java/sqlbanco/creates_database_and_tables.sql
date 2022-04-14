CREATE DATABASE "curso-jsp"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

 CREATE TABLE IF NOT EXISTS public.table_model_login
(
    login character varying(200) COLLATE pg_catalog."default",
    senha character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT login_unique UNIQUE (login)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.table_model_login
    OWNER to postgres;