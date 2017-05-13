# gre-todo
golden real estate to do list


How did i setup project:
==============================

-- There is a quickstart on apache wicket site so i generated following command to setup a new web project
	mvn archetype:generate -DarchetypeGroupId=org.apache.wicket -DarchetypeArtifactId=wicket-archetype-quickstart
	-DarchetypeVersion=7.6.0 -DgroupId=com.gre.todo -DartifactId=gre-todo -DarchetypeRepository=https://repository.apache.org/ -DinteractiveMode=false

-- Project was not compiling due to snapshot verson of wicket 7.5, although i choose 7.6.0. so i made correction in default pom -  maybe its a bug which i should report to wicket team
-- mvn jetty:run
-- server is up so hit the url http://localhost:8080/
-- now a web project is setup and deployed on jetty with default pages

How did i setup project hierarchy:
=================================

-- There is a nice article about it on dzone "https://dzone.com/articles/wicket-setting-project" to setup project hierarchy for wicket project.
-- Project hierarchy is very important to keep things in a managed way. (models, repository, service, web[keep java and html pages separately])
-- I placed hibernate, postgres, and bootstrap dependency and enabled apache wicket extension

How i started coding:
=================================

-- After understanding the problem i drew a small diagram to illustrate relationships between Projects, buildings, and Persons and their associations.
-- Created a script which is available in import.sql file for sample data.
-- Started coding from backend services, created entities, repository/DAO, services.
-- As entities should stay till the service or business layer i also created some DTO's to transfer data beyond service layer.
-- After backend services i moved to UI part and started working on "todolist" page.
-- Created a stream locator by using mkyong code snippet to keep java and html pages in separate packages.

What is left:
================================

-- Test cases
-- In data grid there should be a check box to mark todos completed or not completed


Features:
================================
-- todos can be filtered by Projects, buildings and Persons


Challenges:
================================
-- Wicket help is very limited and there are things which do not work due to wicket version mismatch.
-- Wicket documentation provide a small solution to keep java and html pages in separate packages which does not work so i had to use mkyong code snippet
-- Code becomes a mess in Wicket so extra care is required to write and manage code.
















