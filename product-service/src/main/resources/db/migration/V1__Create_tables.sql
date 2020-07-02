CREATE TABLE public.category (
                id BIGINT NOT NULL,
                name VARCHAR(255),
                CONSTRAINT category_pk PRIMARY KEY (id)
);


CREATE TABLE public.product (
                id BIGINT NOT NULL,
                description VARCHAR(255),
                name VARCHAR(255),
                price INTEGER,
                category_id BIGINT,
                CONSTRAINT product_pk PRIMARY KEY (id)
);


ALTER TABLE public.product ADD CONSTRAINT category_product_fk
FOREIGN KEY (category_id)
REFERENCES public.category (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;