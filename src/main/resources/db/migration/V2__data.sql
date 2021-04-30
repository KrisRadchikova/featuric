--инициализация админа
-- INSERT INTO ftrc_user(id, firstName, lastName, image, login, password, email, userStatus)
--     VALUE (1, 'Admin', 'Admin', null, 'Administrator', 'qwertyuiolkjhgfdcvbnm34567uhgf', 'admin@gmail.com', 'ADMIN')

-- категории для тестов
INSERT INTO ftrc_category(id, name, description) VALUES (2, 'Развлечения', 'Развлечения');
INSERT INTO ftrc_category(id, name, description) VALUES (3, 'Киноиндустрия', 'Киноиндустрия');
INSERT INTO ftrc_category(id, name, description) VALUES (4, 'Школьные вопросы', 'Школьные вопросы');

-- тест киноиндустрия
INSERT INTO ftrc_test(id, name, image, description, category_id)
VALUES (5, 'Вселенная Гарри Поттера', '-', 'Знание вселенной Гарри Поттера', 3 )

-- 1 вопрос
INSERT INTO ftrc_question(id, name, image, description, test_id)
VALUES (6, 'Сколько лучших друзей было у Гарри Поттера?', 'картинка', '---', 5)


-- INSERT INTO ftrc_answer(id, description, rightAnswer, question_id) VALUES (7, '1', false, 6)
-- INSERT INTO ftrc_answer(id, description, rightAnswer, question_id) VALUES (8, '3', false, 6)
-- INSERT INTO ftrc_answer(id, description, rightAnswer, question_id) VALUES (9, '2', true, 6)
-- INSERT INTO ftrc_answer(id, description, rightAnswer, question_id) VALUES (10, '4', false, 6)

-- -- 2 вопрос
-- INSERT INTO ftrc_questions(id, name, image, description)
-- VALUES (11, 'Кто ведет Историю магии?', 'картинка', '---')
--
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (12, 'Кентавр', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (13, 'Великан', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (14, 'Русалка', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (15, 'Приведение', true, 2)
--
-- -- 3 вопрос
-- INSERT INTO ftrc_questions(id, name, image, description)
-- VALUES (16, 'Сколько существует книг про Мальчика-который-выжил?', 'картинка', '---')
--
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (17, '8', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (18, '5', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (19, '7', true, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (20, '6', false, 2)
--
-- -- 4 вопрос
-- INSERT INTO ftrc_questions(id, name, image, description)
-- VALUES (21, 'Кто был чемпионом от школы Дурмстранг?', 'image', '---')
--
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (22, 'Виктор Крам', true, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (23, 'Седрик Диггори', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (24, 'Гарри Поттер', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (25, 'Флёр ДеЛакур', false, 2)
--
-- -- 5 вопрос
-- INSERT INTO ftrc_questions(id, name, image, description)
-- VALUES (26, 'Кто из Мародёров оказался предателем?', 'image', '---')
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (27, 'Джеймс Поттер', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (28, 'Сириус Блэк', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (29, 'Питер Петтигрю', true, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (30, 'Римус Люпин', false, 2)
--
-- -- 6 вопрос
-- INSERT INTO ftrc_questions(id, name, image, description)
-- VALUES (31, 'Кем был Гарри Поттер в Гриффиндорской сборной по Квиддичу?', '---', '---')
--
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (32, 'Заганщик', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (33, 'Ловец', true, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (34, 'Вратарь', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (35, 'Охотник', false, 2)
--
-- --7 вопрос
-- INSERT INTO ftrc_questions(id, name, image, description)
-- VALUES (36, 'Сколько раз Малфой пытался убить Альбуса Дамблдора?', '---', '---')
--
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (38, '3', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (39, '1', true, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (40, '4', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (41, '2', false, 2)
--
-- -- 8 вопрос
-- INSERT INTO ftrc_questions(id, name, image, description)
-- VALUES (42, 'Сколько Даров смерти было в сказке Барда Биддля?', '---', '---')
--
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (43, '3', truefalse, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (44, '4', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (45, '7', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (46, '8', false, 2)
--
-- --9 вопрос
-- INSERT INTO ftrc_questions(id, name, image, description)
-- VALUES (47, 'Сколько крестражей создал Том Рэддл?', '---', '---')
--
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (48, '9', false, 2)
-- INSERT INTO ftrc_answers(id, description, rightAnswer, category) VALUES (49, '3', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (50, '7', true, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (51, '5', false, 2)
--
-- --10 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (52, 'Как Том Рэддл узнал о хоркруксах (крестражах)?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (53, 'Ему рассказал Армандо Диппет', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (54, 'Ему рассказал Гораций Слизорт', true, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (55, 'Прочитал в библиотеке', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (56, 'Ему рассказал Альбус Дамблдор', false, 2)
--
-- --11 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (57, 'Какая фамилия была у матери Северуса Снейпа?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (58, 'Лорд', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (59, 'Князь', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (60, 'Барон', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (61, 'Принц', true, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (62, 'Герцог', false, 2)
--
-- --12 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (63, 'В каких животных превращались Мародёры?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (64, 'пес, хомяк, олень, волк', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (65, 'крыса, пес, олень, волк', true, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (66, 'олень, пес, крыса, медведь', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (67, 'олень, кошка, медведь, волк', false, 2)
--
-- --13 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (68, 'Какое имя было у жены Римуса Люпина?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (69, 'Нимфадора Тонкс', true, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (70, 'Андромеда Тонкс', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (71, 'Белатрисса Блэк', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (72, 'Нарцисса Блэк', false, 2)
--
-- --14 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (73, 'На каком факультете нужно отгадать загадку для того, чтобы попасть в гостиную?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (74, 'Пуффендуй', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (75, 'Слизерин', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (76, 'Когтевран', true, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (77, 'Гриффиндор', false, 2)
--
-- --15 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (78, 'Как называется зверек, любящий золото и драгоценности?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (79, 'Обскур', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (80, 'Мозгошмыг', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (81, 'Демимаска', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (82, 'Нюхлер', true, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (83, 'Оками', false, 2)
--
-- --16 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (84, 'У кого Геллерт Гриндевальд украл Бузинную палочку?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (85, 'Григорович', true, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (86, 'Оливандер', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (87, 'Дамблдор', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (88, 'Диппет', false, 2)
--
-- --17 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (89, 'Спальни каких факультетов расположены в башнях?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (90, 'Слизерин и Когтевран', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (91, 'Пуффендуй и Когтевран', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (92, 'Слизерин и Гриффиндор', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (93, 'Когтевран и Гриффиндор', true, 2)
--
-- --18 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (94, 'Какого из этих имён не было у Альбуса Дамблдора?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (95, 'Персиваль', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (96, 'Геллерт', true , 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (97, 'Вулфрик', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (98, 'Брайан', false, 2)
--
-- --19 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (99, 'Сколько лет подряд Слизерин выигрывал Кубок по Квиддичу до поступления Гарри Поттера в Хогвартс?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (100, '8', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (101, '5', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (102, '3', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (103, '6', true , 2)
--
-- --20 вопрос
-- INSERT INTO questions(id, name, image, description)
-- VALUES (104, 'В каком заклинании преуспел Гилдерой Локхарт?', '---', '---')
--
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (105, 'Петрификус Тоталус', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (106, 'Ступефай', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (107, 'Нокс', false, 2)
-- INSERT INTO answers(id, description, rightAnswer, category) VALUES (108, 'Обливейт', true , 2)