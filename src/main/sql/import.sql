\c database tests;
INSERT INTO project (id, name) VALUES (1, 'Cleaning Facade');
INSERT INTO project (id, name) VALUES (2, 'Fixing Defects');
INSERT INTO project (id, name) VALUES (3, 'Renewing Fire Extinguishers');
INSERT INTO building (id, name) VALUES (1, 'Building 101');
INSERT INTO building (id, name) VALUES (2, 'Building 201');
INSERT INTO building (id, name) VALUES (3, 'Building 301');
INSERT INTO building (id, name) VALUES (4, 'Building 401');
INSERT INTO building (id, name) VALUES (5, 'Building 501');
INSERT INTO building (id, name) VALUES (6, 'Building 601');
INSERT INTO building (id, name) VALUES (7, 'Building 701');
INSERT INTO building (id, name) VALUES (8, 'Building 801');
INSERT INTO building (id, name) VALUES (9, 'Building 901');
INSERT INTO building (id, name) VALUES (10, 'Building 1001');
INSERT INTO person (id, name) VALUES (1, 'Andrew');
INSERT INTO person (id, name) VALUES (2, 'Simon');
INSERT INTO person (id, name) VALUES (3, 'Berry');
INSERT INTO person (id, name) VALUES (4, 'Robert');
INSERT INTO person (id, name) VALUES (5, 'John');
INSERT INTO person (id, name) VALUES (6, 'Harry');
INSERT INTO person (id, name) VALUES (7, 'Jesica');
INSERT INTO person (id, name) VALUES (8, 'Joe');
INSERT INTO person (id, name) VALUES (9, 'Henry');
INSERT INTO person (id, name) VALUES (10, 'David');
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