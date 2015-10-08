CREATE DATABASE snakesandladders;

USE snakesandladders;

CREATE TABLE game_results (
	game_id VARCHAR(20) NOT NULL
	,date VARCHAR(20) NULL
	,winner VARCHAR(20) NULL
	,PRIMARY KEY (game_id)
	);

CREATE TABLE game_details (
	game_id VARCHAR(20) NOT NULL
	,player_name VARCHAR(20) NULL
	,position VARCHAR(20) NULL
	,INDEX Game_id(Game_id ASC)
	,CONSTRAINT game_id FOREIGN KEY (game_id) REFERENCES game_results(game_id) ON DELETE CASCADE ON UPDATE CASCADE
	);

CREATE TABLE logs (
	user_id VARCHAR(20) NOT NULL
	,date DATE NOT NULL
	,logger VARCHAR(50) NOT NULL
	,level VARCHAR(10) NOT NULL
	,message VARCHAR(1000) NOT NULL
	);