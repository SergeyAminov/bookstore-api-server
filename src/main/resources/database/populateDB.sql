INSERT INTO authors
	(full_name)
VALUES
    ('Ли Цисинь'),
	('Макс Максимов'),
	('Деннис Тейлор'),
	('Элизабет Мун'),
	('Крис Хэдфилд'),
	('Роберт Хайнлайн'),
	('Ольга Токарчук'),
	('Лиззи Пэйдж'),
	('Светлана Сачкова'),
	('Маша Трауб'),
	('Михаил Барщевский'),
	('Робин Роу'),
	('Клеменс Мишальон');

INSERT INTO genres
	(genre)
VALUES
	('Научная фантастика'),
	('Современная проза'),
	('Детектив');

INSERT INTO roles
	(role)
VALUES
	('ROLE_ADMIN'),
	('ROLE_USER');

INSERT INTO books
	(title, author_id, release_date, genre_id, cover, pages, price, amount)
VALUES
	('О муравьях и динозаврах', 1, '2023-11-17', 1, 'https://cdn.eksmo.ru/v2/ITD000000001330259/COVER/cover1__w820.jpg', 452, 959, 999),
	('Небо титана', 2, '2024-1-24', 1, 'https://cdn.eksmo.ru/v2/ITD000000001358240/COVER/cover1__w820.jpg', 288, 662, 999),
	('Небесная река', 3, '2023-10-2', 1, 'https://cdn.eksmo.ru/v2/ITD000000001351240/COVER/cover1__w820.jpg', 640, 644, 999),
	('Скорость тьмы', 4, '2023-12-22', 1, 'https://cdn.eksmo.ru/v2/ITD000000001351056/COVER/cover1__w820.jpg', 416, 844, 999),
	('Удержать небо', 1, '2023-3-21', 1, 'https://cdn.eksmo.ru/v2/ITD000000001307614/COVER/cover1__w820.jpg', 448, 869, 999),
	('Все эти миры', 3, '2023-2-1', 1, 'https://cdn.eksmo.ru/v2/ITD000000001307241/COVER/cover1__w820.jpg', 352, 625, 999),
	('Орбита Смерти', 5, '2023-3-15', 1, 'https://cdn.eksmo.ru/v2/ITD000000001294412/COVER/cover1__w820.jpg', 608, 713, 999),
	('Погоня за панкерой', 6, '2022-4-6', 1, 'https://cdn.eksmo.ru/v2/ITD000000001176432/COVER/cover1__w820.jpg', 640, 165, 999),
	('Задача трех тел', 1, '2023-12-11', 1, 'https://cdn.eksmo.ru/v2/ITD000000001353170/COVER/cover1__w820.jpg', 512, 711, 999),
	('Книги Якова', 7, '2023-6-25', 2, 'https://cdn.eksmo.ru/v2/ITD000000001161414/COVER/cover1__w820.jpg', 752, 1731, 999),
	('Сиротский дом', 8, '2023-7-24', 2, 'https://cdn.eksmo.ru/v2/ITD000000001250352/COVER/cover1__w820.jpg', 512, 600, 999),
	('Люди и птицы', 9, '2020-9-9', 2, 'https://cdn.eksmo.ru/v2/ITD000000001107771/COVER/cover1__w820.jpg', 480, 600, 999),
	('Пополам', 10, '2023-11-27', 2, 'https://cdn.eksmo.ru/v2/ITD000000001351865/COVER/cover1__w820.jpg', 320, 513, 999),
	('Правда о лжи', 11, '2023-11-7', 2, 'https://cdn.eksmo.ru/v2/ITD000000001361186/COVER/cover1__w820.jpg', 224, 581, 999),
	('Этикет темной комнаты', 12, '2024-2-6', 3, 'https://cdn.eksmo.ru/v2/ITD000000001353435/COVER/cover1__w820.jpg', 448, 625, 999),
	('Тихая квартирантка', 13, '2024-1-15', 3, 'https://cdn.eksmo.ru/v2/ITD000000001295272/COVER/cover1__w820.jpg', 352, 593, 999);
