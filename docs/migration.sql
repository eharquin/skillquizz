CREATE TABLE `answers`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `order`       int DEFAULT NULL,
    `active`      tinyint(1) DEFAULT NULL,
    `question_id` int DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `answers_courses`
(
    `course_id` int DEFAULT NULL,
    `answer_id` int DEFAULT NULL
);

CREATE TABLE `courses`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `user_id`  int DEFAULT NULL,
    `quizz_id` int DEFAULT NULL,
    `score`    int DEFAULT NULL,
    `duration` int DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `questions`
(
    `id`              int NOT NULL AUTO_INCREMENT,
    `order`           int DEFAULT NULL,
    `active`          tinyint(1) DEFAULT NULL,
    `version_id`      int DEFAULT NULL,
    `right_answer_id` int DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `quizzes`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `user_id`  int DEFAULT NULL,
    `skill_id` int DEFAULT NULL,
    `active`   tinyint(1) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `skills`
(
    `id`      int NOT NULL AUTO_INCREMENT,
    `subject` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `users`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `type`         int          DEFAULT NULL,
    `email`        varchar(255) DEFAULT NULL,
    `name`         varchar(255) DEFAULT NULL,
    `company`      varchar(255) DEFAULT NULL,
    `phone_number` varchar(255) DEFAULT NULL,
    `password`     varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `versions`
(
    `id`        int NOT NULL AUTO_INCREMENT,
    `active`    tinyint(1) DEFAULT NULL,
    `survey_id` int DEFAULT NULL,
    PRIMARY KEY (`id`)
);