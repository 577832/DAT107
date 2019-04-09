//ANSATT




CREATE table Ansatt
(
	AnsattId serial not null,
	Brukernavn VARCHAR(4), 
	Fornavn VARCHAR(255), 
	Etternavn VARCHAR(255), 
	AnsDato DATE not null, 
	Stilling VARCHAR(20), 
	Lonn INTEGER, 
	unique (AnsattId, Brukernavn),
	primary key(AnsattId)
)

select* from Ansatt
order by ansattid; 

alter table ansatt
add foreign key (avdelingsid) references Avdeling(avdelingsId)

alter table Ansatt
add column avdelingsId integer



update ansatt  ---Oppdaterer lønn til ansatt.
set lonn = 400000
where ansattid = 9; 


update ansatt 
set avdelingsid = 1
where ansattid = 1; 


insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('CN', 'Christian', 'Norill', '1996-07-11', 'Lærling', 900000)

insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('NVR', 'Niklas', 'Raa', '1997-01-28', 'Lærling', 800000)


insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('SET', 'Stefan', 'Taranger', '2008-01-28', 'Sushimann', 20000)

insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('JN', 'Jonas', 'Norill', '2008-01-28', 'Selger', 750000)


insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('EN', 'Espen', 'Norvang', '2019-04-01', 'COO', 1000000)

insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('JV', 'Jon', 'Vollset', '2019-04-02', 'Personlig trener', 500000)

insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('BS', 'Bendik', 'Simonsen', '2019-02-22', 'Løpegutt', 300000)

insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('KG', 'Kari	', 'Gundersen', '2019-03-22', 'Kundeservice', 300000)

insert into Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, Lonn)
values('BY', 'Bente', 'Ytre', '2019-03-22', 'Kundeservice', 4000000)


insert into Ansatt(Brukernavn, Fornavn, etternavn, ansdato, stilling, lonn)
values('FGM', 'Fredrik', 'Mork', '2010-01-12', 'Mentor', 475000)



//AVDELING



CREATE table Avdeling
(
	avdelingsId serial not null,
	navn varchar(255),
	sjef INTEGER,
	unique(avdelingsId),
	primary key (avdelingsId)
);

select*from Avdeling

insert into Avdeling(navn, sjef)
values('Styret', 1)

alter table Avdeling
add foreign key(sjef) references Ansatt(ansattId)




