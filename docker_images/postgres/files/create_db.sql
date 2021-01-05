-- Database: temperature_stats

-- DROP DATABASE temperature_stats;

CREATE DATABASE temperature_stats
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.temperature_data

-- DROP TABLE public.temperature_data;

CREATE TABLE public.temperature_data
(
    id bigint NOT NULL,
    device_id character varying(255) COLLATE pg_catalog."default",
    device_name character varying(255) COLLATE pg_catalog."default",
    temp_celcius character varying(255) COLLATE pg_catalog."default",
    temp_farenheit character varying(255) COLLATE pg_catalog."default",
    "timestamp" timestamp without time zone,
    CONSTRAINT temperature_data_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.temperature_data
    OWNER to postgres;
