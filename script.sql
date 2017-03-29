create database GLBank;

use GLBank;

create table Employees (idemp INTEGER AUTO_INCREMENT, 
                         firstname VARCHAR(20) NOT NULL,
						 lastname VARCHAR(20) NOT NULL,
						 email VARCHAR(30) NOT NULL UNIQUE,
						 position CHAR(1) NOT NULL DEFAULT 'C',
						 PRIMARY KEY (idemp) );
						 
create table LoginEmployee (id INTEGER AUTO_INCREMENT,
						idemp INTEGER,
						login varchar(15),
						password varchar(60),
						PRIMARY KEY (id),
						FOREIGN KEY (idemp) REFERENCES Employees(idemp)
						ON DELETE CASCADE
						ON UPDATE RESTRICT);
						
create table HistoryLoginEmployee ( id INTEGER AUTO_INCREMENT,
						idemp INTEGER ,
						logindate DATETIME,
						PRIMARY KEY(id),
						FOREIGN KEY (idemp) REFERENCES Employees(idemp)
						ON DELETE CASCADE
						ON UPDATE RESTRICT);
						
insert into Employees VALUES(1,'Maros','Zoricak','maroszoricak@gmail.com','C');
insert into Employees VALUES(2,'Adrian','Matta','adrianmatta@gmail.com','C');
insert into loginemployee values(1,1,'maros','maros');
insert into loginemployee values(2,2,'matta','matta');

CREATE TABLE Clients (idc INTEGER AUTO_INCREMENT,
					firstname VARCHAR(20) NOT NULL,
					lastname VARCHAR(20) NOT NULL,
					disable CHAR(1) DEFAULT 'F',
					PRIMARY KEY (idc)
					);

CREATE TABLE ClientDetails(idcd INTEGER AUTO_INCREMENT,
					idc INTEGER NOT NULL,
					street VARCHAR(30) NOT NULL,
					housenumber INTEGER NOT NULL,
					postcode CHAR(5) NOT NULL,
					city VARCHAR(30) NOT NULL,
					dob DATE NOT NULL,
					email VARCHAR(30),
					PRIMARY KEY (idcd),
			   	    FOREIGN KEY (idc)
				    REFERENCES Clients(idc)
					ON DELETE CASCADE 
					ON UPDATE RESTRICT
					);
					
CREATE TABLE LoginClient (idlc INTEGER AUTO_INCREMENT,
					idc INTEGER NOT NULL,
					login VARCHAR(20) NOT NULL UNIQUE,
					password VARCHAR(60) NOT NULL,
					blocked CHAR(1) DEFAULT 'F',
					PRIMARY KEY(idlc),
					FOREIGN KEY (idc)
					REFERENCES Clients (idc)
					ON DELETE CASCADE
					ON UPDATE RESTRICT
					);
					
INSERT INTO Clients(idc,firstname, lastname) VALUES (1, 'Jana','Hoffmannova');
INSERT INTO Clients(idc,firstname, lastname) VALUES (2, 'Denisa','Červena');
INSERT INTO Clients(idc,firstname, lastname) VALUES (3, 'Jaroslav','Vanik');
INSERT INTO Clients(idc,firstname, lastname) VALUES (4, 'Ladislav','Konár');
INSERT INTO Clients(idc,firstname, lastname) VALUES (5, 'Michaela','Mila');

INSERT INTO LoginClient(idlc, idc, login , password) VALUES (1,1,'hoffmannova','hoffmannova');					
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (2,2,'Červena','Červena');	
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (3,3,'Vanik','Vanik');
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (4,4,'Konár','Konár');	
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (5,5,'Mila','Mila');

INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (1,1,'Cingovska',15,'04012','Presov','1994-08-20','hoffmannova@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (2,2,'Jenisejska',41,'04012','Presov','1989-01-02','markova@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city,dob, email)
VALUES (3,3,'Ladozska',83,'04012','Presov,'1992-03-29','vanik@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (4,4,'Rovnikova',19,'04012','Presov','1986-09-15','kodad@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (5,5,'Zdiarska',4,'04012','Presov','1990-11-05','pasekova@gmail.com');	