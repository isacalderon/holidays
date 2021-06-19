
CREATE DATABASE holidays_manager
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


-- -----------------------------------------------------
-- Table "CAT_STATUS"
-- -----------------------------------------------------
CREATE TABLE  CAT_STATUS (
  "id" SERIAL NOT NULL,
  "description" VARCHAR(45) NOT NULL,
  "active" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"));
  
-- -----------------------------------------------------
-- Table "EMPLOYEE"
-- -----------------------------------------------------
  
  CREATE TABLE public.employees
(
    id SERIAL NOT NULL DEFAULT nextval('employee_id_seq'::regclass),
    name character varying(40) COLLATE pg_catalog."default",
    last_name character varying(100) COLLATE pg_catalog."default",
    email character varying(70) COLLATE pg_catalog."default",
    deparment character varying(100) COLLATE pg_catalog."default",
    date_hiring timestamp without time zone,
    document_id character varying(40) COLLATE pg_catalog."default",
    "position" character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employees
    OWNER to postgres;
	
-- -----------------------------------------------------
-- Table "HOLIDAY_REQUEST"
-- -----------------------------------------------------
	
CREATE TABLE public.holiday_requests
(
    id SERIAL NOT NULL DEFAULT nextval('holiday_requests_id'::regclass),
    id_employee integer NOT NULL,
    resolved_by integer,
    id_status integer NOT NULL,
    vacation_start_date timestamp without time zone,
    vacation_end_date timestamp without time zone,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    manager_id integer,
    days_to_used integer,
    CONSTRAINT holiday_request_pkey PRIMARY KEY (id),
    CONSTRAINT "fk_HOLIDAY_REQUEST_EMPLOYEE" FOREIGN KEY (id_employee)
        REFERENCES public.employees (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "fk_HOLIDAY_REQUEST_STATUS" FOREIGN KEY (id_status)
        REFERENCES public.cat_status (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.holiday_requests
    OWNER to postgres;
  
  