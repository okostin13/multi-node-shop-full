CREATE TABLE public.orders (
                id BIGINT NOT NULL,
                address VARCHAR(255),
                purchaser_name VARCHAR(255),
                status VARCHAR(255),
                CONSTRAINT orders_pk PRIMARY KEY (id)
);


CREATE TABLE public.item (
                id BIGINT NOT NULL,
                product_id BIGINT,
                order_id BIGINT,
                CONSTRAINT item_pk PRIMARY KEY (id)
);


ALTER TABLE public.item ADD CONSTRAINT orders_item_fk
FOREIGN KEY (order_id)
REFERENCES public.orders (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

CREATE SEQUENCE hibernate_sequence START 1;

