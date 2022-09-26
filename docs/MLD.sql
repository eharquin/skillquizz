CREATE TABLE `Utilisateur` (
  `id` int,
  `type` int,
  `active` bool,
  `email` string,
  `name` string,
  `societe` string,
  `telephone` string,
  `password` string
);

CREATE TABLE `Questionnaire` (
  `id` int,
  `utilisateur_id` int,
  `competence_id` int,
  `active` boolean
);

CREATE TABLE `Version` (
  `id` int,
  `active` bool,
  `questionnaire_id` int
);

CREATE TABLE `Question` (
  `id` int,
  `order` int,
  `active` boolean,
  `version_id` int,
  `bonne_reponse_id` int
);

CREATE TABLE `Reponse` (
  `id` int,
  `order` int,
  `active` boolean,
  `question_id` int
);

CREATE TABLE `Parcours` (
  `id` int,
  `utilisateur_id` int,
  `version_id` int,
  `score` int,
  `duree` int
);

CREATE TABLE `parcours_reponses` (
  `parcours_id` int,
  `reponse_id` int
);

CREATE TABLE `Competence` (
  `id` int,
  `sujet` string
);

ALTER TABLE `Questionnaire` ADD FOREIGN KEY (`utilisateur_id`) REFERENCES `Utilisateur` (`id`);

ALTER TABLE `Questionnaire` ADD FOREIGN KEY (`competence_id`) REFERENCES `Competence` (`id`);

ALTER TABLE `Version` ADD FOREIGN KEY (`questionnaire_id`) REFERENCES `Questionnaire` (`id`);

ALTER TABLE `Question` ADD FOREIGN KEY (`version_id`) REFERENCES `Version` (`id`);

ALTER TABLE `Question` ADD FOREIGN KEY (`bonne_reponse_id`) REFERENCES `Reponse` (`id`);

ALTER TABLE `Reponse` ADD FOREIGN KEY (`question_id`) REFERENCES `Question` (`id`);

ALTER TABLE `Parcours` ADD FOREIGN KEY (`utilisateur_id`) REFERENCES `Utilisateur` (`id`);

ALTER TABLE `Parcours` ADD FOREIGN KEY (`version_id`) REFERENCES `Version` (`id`);

ALTER TABLE `parcours_reponses` ADD FOREIGN KEY (`parcours_id`) REFERENCES `Parcours` (`id`);

ALTER TABLE `parcours_reponses` ADD FOREIGN KEY (`reponse_id`) REFERENCES `Reponse` (`id`);
