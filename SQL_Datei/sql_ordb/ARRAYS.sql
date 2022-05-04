DROP TABLE IF EXISTS tictactoe , messages;


CREATE TABLE tictactoe (
    squares   integer[3][3]
);

INSERT INTO tictactoe VALUES('{{1,2,3},{4,5,6},{7,8,9}}');



CREATE TABLE messages (
     msg  text[]
) ;

INSERT INTO messages VALUES ('{"hello", "world"}') ;
INSERT INTO messages VALUES ('{"I", "feel", "so", "free"}') ;

