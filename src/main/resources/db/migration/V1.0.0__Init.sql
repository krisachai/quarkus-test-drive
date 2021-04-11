

CREATE SEQUENCE public.caridseq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


CREATE SEQUENCE public.manufactureridseq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

    
CREATE TABLE manufacturer
(
    manufacturerid bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT manufacturer_pkey PRIMARY KEY (manufacturerid)
);


CREATE TABLE car
(
    carid bigint NOT NULL,
    color character varying(255) COLLATE pg_catalog."default",
    model character varying(255) COLLATE pg_catalog."default",
    year integer,
    manufactureid bigint,
    CONSTRAINT car_pkey PRIMARY KEY (carid),
    CONSTRAINT manufacturerid_fk FOREIGN KEY (manufactureid)
        REFERENCES public.manufacturer (manufacturerid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


 