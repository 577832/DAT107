--
-- Eksempel F6a forelesning fredag 5. april 2019.
--
-- Alternativ a: Subtyping med tabeller b�de for supertypen og 
-- subtypene, dvs. @Inheritance(strategy = InheritanceType.JOINED)
--

DROP SCHEMA IF EXISTS forelesning6a CASCADE;
CREATE SCHEMA forelesning6a;
SET search_path TO forelesning6a;

CREATE TABLE Person
(
  FNr        CHAR(11), -- Kan ogs� bruke UNSIGNED BIGINT(11). 
                       -- INTEGER er for liten for 11 sifre.
  Fornavn    VARCHAR(30),
  Etternavn  VARCHAR(30),
  Dtype      VARCHAR(30),  -- NB! En reservert kolonne brukt av JPA ved arv.
                           -- Brukes for � markere hvilken (sub)klasse det er.
  CONSTRAINT Person_PK PRIMARY KEY (FNr)
);

CREATE TABLE Ansatt
(
  FNr        CHAR(11),
  Stilling   VARCHAR(30),
  CONSTRAINT Ansatt_PK PRIMARY KEY (FNr),
  CONSTRAINT Person_FK FOREIGN KEY (FNr) REFERENCES Person(FNr)
);

CREATE TABLE Student
(
  FNr        CHAR(11),
  Studium    VARCHAR(30),
  CONSTRAINT Student_PK PRIMARY KEY (FNr),
  CONSTRAINT Person_FK FOREIGN KEY (FNr) REFERENCES Person(FNr)
);

INSERT INTO 
    Person(FNr, Fornavn, Etternavn, Dtype)
VALUES
    ('12345678901', 'Arne', 'Arnesen', 'Ansatt'),
    ('23456789012', 'Stig', 'Stigsen', 'Student'),
    ('34567890123', 'Pers', 'Perssen', 'Person');
    
INSERT INTO 
    Ansatt(FNr, Stilling)
VALUES
    ('12345678901', 'L�rer');
    
INSERT INTO 
    Student(FNr, Studium)
VALUES
    ('23456789012', 'Informasjonsteknologi');
    




