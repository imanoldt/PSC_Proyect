	/* DELETE 'LudoFunDB' database*/
	DROP SCHEMA IF EXISTS LudoFunDB;
	/* DELETE USER 'spq' AT LOCAL SERVER*/
	DROP USER IF EXISTS 'spq'@'localhost';

	/* CREATE 'LudoFunDB' DATABASE */
	CREATE SCHEMA LudoFunDB;
	/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'Imanol*123' */
	CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'Imanol*123';

	GRANT ALL ON LudoFunDB.* TO 'spq'@'localhost';