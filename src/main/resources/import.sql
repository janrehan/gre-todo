\c database tests;

CREATE SEQUENCE project_id_seq;
ALTER TABLE project ALTER COLUMN id SET DEFAULT nextval('project_id_seq');
SELECT setval('project_id_seq', 0);

CREATE SEQUENCE person_id_seq;
ALTER TABLE person ALTER COLUMN id SET DEFAULT nextval('person_id_seq');
SELECT setval('person_id_seq', 11);

CREATE SEQUENCE building_id_seq;
ALTER TABLE building ALTER COLUMN id SET DEFAULT nextval('building_id_seq');
SELECT setval('building_id_seq', 11);

CREATE SEQUENCE project_prog_id_seq;
ALTER TABLE project_progress ALTER COLUMN id SET DEFAULT nextval('project_prog_id_seq');
SELECT setval('project_prog_id_seq', 0);

INSERT INTO project (id, name) VALUES (1, 'Cleaning Facade');
INSERT INTO project (id, name) VALUES (2, 'Fixing Defects');
INSERT INTO project (id, name) VALUES (3, 'Renewing Fire Extinguishers');
INSERT INTO building (id, name,location) VALUES (1, 'Building 101','JBR');
INSERT INTO building (id, name,location) VALUES (2, 'Building 201','Discovery Gardens');
INSERT INTO building (id, name,location) VALUES (3, 'Building 301','Marina');
INSERT INTO building (id, name,location) VALUES (4, 'Building 401','Al Barsha');
INSERT INTO building (id, name,location) VALUES (5, 'Building 501','Gardens');
INSERT INTO building (id, name,location) VALUES (6, 'Building 601','Tecom');
INSERT INTO building (id, name,location) VALUES (7, 'Building 701','IMPZ');
INSERT INTO building (id, name,location) VALUES (8, 'Building 801','Sports City');
INSERT INTO building (id, name,location) VALUES (9, 'Building 901','Studio City');
INSERT INTO building (id, name,location) VALUES (10, 'Building 1001','JBR');
INSERT INTO person (id, first_name, last_name, email) VALUES (1, 'Andrew','Fayole','andrew@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (2, 'Simon','Haris','simon@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (3, 'Berry','Kaufmen','berry@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (4, 'Robert','Dinero','robert@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (5, 'John','Trafong','john@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (6, 'Harry','James','harry@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (7, 'Jesica','Alba','jesica@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (8, 'Joe','Dave','joe@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (9, 'Henry','John','henry@gmail.com');
INSERT INTO person (id, first_name, last_name, email) VALUES (10, 'David','Patel','david@gmail.com');
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (1, 1,1,1,true);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (2, 1,2,2,false);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (3, 1,3,3,false);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (4, 2,4,4,true);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (5, 2,5,5,false);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (6, 2,6,6,false);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (7, 3,7,7,true);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (8, 3,8,8,false);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (9, 3,9,9,true);
INSERT INTO project_progress (id, project_id,building_id,person_id,is_status_done) VALUES (10, 3,10,10,false);