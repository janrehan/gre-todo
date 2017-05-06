INSERT INTO `tests`.`project` (`id`, `name`) VALUES (1, 'Cleaning Facade');
INSERT INTO `tests`.`project` (`id`, `name`) VALUES (2, 'Fixing Defects');
INSERT INTO `tests`.`project` (`id`, `name`) VALUES (3, 'Renewing Fire Extinguishers');

INSERT INTO `tests`.`building` (`id`, `name`) VALUES (1, 'Building 101');
INSERT INTO `tests`.`building` (`id`, `name`) VALUES (2, 'Building 201');
INSERT INTO `tests`.`building` (`id`, `name`) VALUES (3, 'Building 301');
INSERT INTO `tests`.`building` (`id`, `name`) VALUES (4, 'Building 401');
INSERT INTO `tests`.`building` (`id`, `name`) VALUES (5, 'Building 501');
INSERT INTO `tests`.`building` (`id`, `name`) VALUES (6, 'Building 601');


INSERT INTO `tests`.`person` (`id`, `name`) VALUES (1, 'Andrew');
INSERT INTO `tests`.`person` (`id`, `name`) VALUES (2, 'Simon');
INSERT INTO `tests`.`person` (`id`, `name`) VALUES (3, 'Berry');
INSERT INTO `tests`.`person` (`id`, `name`) VALUES (4, 'Robert');
INSERT INTO `tests`.`person` (`id`, `name`) VALUES (5, 'John');
INSERT INTO `tests`.`person` (`id`, `name`) VALUES (6, 'Nathen');


INSERT INTO `tests`.`project_progress` (`id`, `project_id`,`building_id`,`person_id`,`is_status_done`) VALUES (1, 1,2,1,0);
INSERT INTO `tests`.`project_progress` (`id`, `project_id`,`building_id`,`person_id`,`is_status_done`) VALUES (2, 1,3,2,0);
INSERT INTO `tests`.`project_progress` (`id`, `project_id`,`building_id`,`person_id`,`is_status_done`) VALUES (3, 3,4,3,0);
INSERT INTO `tests`.`project_progress` (`id`, `project_id`,`building_id`,`person_id`,`is_status_done`) VALUES (4, 3,5,3,1);


