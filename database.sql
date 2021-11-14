--          Create table                    --
CREATE TABLE game_saves (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    wins int NOT NULL
);
--              Query                       --
SELECT * FROM game_saves WHERE name = ;

SELECT * FROM game_saves;

UPDATE game_saves SET wins = WHERE name = ;

DELETE FROM game_saves WHERE name = ;

INSERT INTO game_saves (name, wins) VALUES (name, wins);