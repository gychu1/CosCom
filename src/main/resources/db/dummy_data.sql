INSERT INTO user_profile(age, email, name, profile_image, username)
VALUES
    (18, 'test@test.com', 'Test One', 'image1', 'test-user-1'),
    (18, 'test2@test.com', 'Test Two', 'image2', 'test-user-2'),
    (18, 'test3@test.com', 'Test Three', 'image3', 'test-user-3'),
    (18, 'test4@test.com', 'Test Four', 'image4', 'test-user-4'),
    (18, 'test5@test.com', 'Test Five', 'image5', 'test-user-5'),
    (18, 'test6@test.com', 'Test Six', 'image6', 'test-user-6'),
    (18, 'test7@test.com', 'Test Seven', 'image7', 'test-user-7'),
    (18, 'test8@test.com', 'Test Eight', 'image8', 'test-user-8');

INSERT INTO post(date, description, imageurl, user_profile_id)
VALUES
    ('2022-08-01', 'Bunny Girl', 'url1', 1),
    ('2022-08-02', 'Battle Tank', 'url2', 1),
    ('2022-08-03', 'Crazy Girl', 'url3', 2),
    ('2022-08-01', 'Bunny Boy', 'url4', 3),
    ('2022-08-07', 'Cat Dog', 'url5', 6),
    ('2022-08-02', 'Hot Dog', 'url6', 8),
    ('2022-08-28', 'Pizza', 'url7', 8);

INSERT INTO comment(date, text, post_id, user_profile_id)
VALUES
    ('2022-08-01', 'Nice looking Bunny Girl!', 1, 2),
    ('2022-08-02', 'Pretty cosplay', 1, 8),
    ('2022-08-02', 'Sick Tank bro!', 2, 1),
    ('2022-08-02', 'ewwww', 3, 2),
    ('2022-08-02', 'Yummmmmmy', 7, 1);