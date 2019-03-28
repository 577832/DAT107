-- SQL for en-til-mange-eksemplet gjennomgått i timen fredag 29. mars 2019 

DROP SCHEMA IF EXISTS forelesning4todo CASCADE;
CREATE SCHEMA forelesning4todo;
SET search_path TO forelesning4todo;
    
CREATE TABLE Todoliste
(
    ListeId     SERIAL,
    Navn        VARCHAR,
    CONSTRAINT TodolistePN PRIMARY KEY (ListeId)
);

CREATE TABLE Todo
(
    TodoId      SERIAL,
    Tekst       VARCHAR,
    ListeId     INTEGER,
    CONSTRAINT TodoPN PRIMARY KEY (TodoId),
    CONSTRAINT ListeFN FOREIGN KEY (ListeId) REFERENCES Todoliste(ListeId)
);
