INSERT INTO public.category(
	id, name)
	VALUES (1, 'Еда');

INSERT INTO public.category(
	id, name)
	VALUES (2, 'Техника');

INSERT INTO public.category(
	id, name)
	VALUES (3, 'Спорт товары');

INSERT INTO public.product(
	id, description, name, price, category_id)
	VALUES (1, 'Невкусная', 'Каша',100 ,1 );

INSERT INTO public.product(
	id, description, name, price, category_id)
	VALUES (2, 'Вкусное', 'Мясо',200 , 1);

INSERT INTO public.product(
	id, description, name, price, category_id)
	VALUES (3, 'Мощный', 'Компьютер',100000 ,2 );

INSERT INTO public.product(
	id, description, name, price, category_id)
	VALUES (4, 'Простой', 'Телефон', 5000,2 );

INSERT INTO public.product(
	id, description, name, price, category_id)
	VALUES (5, 'Быстрый', 'Велосипед', 10000,3 );

INSERT INTO public.product(
	id, description, name, price, category_id)
	VALUES (6, 'Прыгучий', 'Мяч',1000 ,3 );
