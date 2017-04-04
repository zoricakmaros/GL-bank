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
insert into Employees VALUES(2,'Matej','Novak','matejnovak@gmail.com','C');
insert into loginemployee values(1,1,'maros','maros');
insert into loginemployee values(2,2,'novak','novak');

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
					
INSERT INTO Clients(idc,firstname, lastname) VALUES (1, 'Jana','Tenka');
INSERT INTO Clients(idc,firstname, lastname) VALUES (2, 'Marketa','Ivanova');
INSERT INTO Clients(idc,firstname, lastname) VALUES (3, 'Miroslav','Korbac');
INSERT INTO Clients(idc,firstname, lastname) VALUES (4, 'Peter','Maly');
INSERT INTO Clients(idc,firstname, lastname) VALUES (5, 'Petra','Hlupa');

INSERT INTO LoginClient(idlc, idc, login , password) VALUES (1,1,'Tenka','Tenka');					
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (2,2,'Ivanova','Ivanova');	
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (3,3,'Korbac','Korbac');
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (4,4,'Maly','Maly');	
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (5,5,'Hlupa','Hlupa');

INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (1,1,'Kezmarska',45,'07850','Kezmarok','1987-04-15','Tenk@gmail@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (2,2,'Sesejova',78,'09745','Kremnica','1954-08-09','Ivanova@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city,dob, email)
VALUES (3,3,'Nova',115,'04725','Poprad','1987-06-20','Korbac@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (4,4,'Uhlikova',25,'04721','Bratislava','1962-11-05','Maly@gmail@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (5,5,'Novomeskeho',7,'04785','Kosice','1947-10-08','Hlupa@gmail.com');

CREATE TABLE Accounts(idacc BIGINT UNIQUE,
					idc INTEGER NOT NULL,
					balance FLOAT (10,2),
					PRIMARY KEY (idacc),
					FOREIGN KEY (idc)
					REFERENCES Clients(idc)
					ON DELETE CASCADE
					ON UPDATE RESTRICT);
					
INSERT INTO Accounts VALUES (3372057348,1,90.33);	
INSERT INTO Accounts VALUES (5095871571,1,10.50);
INSERT INTO Accounts VALUES (34050790,1,62389.50);		
INSERT INTO Accounts VALUES (6539179939,2,2989.99);
INSERT INTO Accounts VALUES (1478206897,2,145.12);
INSERT INTO Accounts VALUES (7547201642,3,74.20);
INSERT INTO Accounts VALUES (7841205895,3,54.78);
INSERT INTO Accounts VALUES (5247812984,4,1542.12);
INSERT INTO Accounts VALUES (9898416548,4,768.58);
INSERT INTO Accounts VALUES (7412535871,5,210.14);
INSERT INTO Accounts VALUES (4514551548,5,1526.12);


CREATE TABLE banktransaction (idbt INT AUTO_INCREMENT,
							amount FLOAT(10,2) NOT NULL,
							transdatetime datetime NOT NULL,
							description VARCHAR(140) DEFAULT NULL,
							idemp INT DEFAULT 0,
							srcacc BIGINT NOT NULL,
							destacc BIGINT NOT NULL,
							srcbank INT NOT NULL,
							destbank INT NOT NULL,
							PRIMARY KEY(idbt),
							FOREIGN KEY (idemp) REFERENCES Employees(idemp)
							);
	
CREATE TABLE cashtransaction (idct INT AUTO_INCREMENT,
							idemp INT NOT NULL,
							amount FLOAT(10,2) DEFAULT 0,
							idacc BIGINT NOT NULL,
							cashdatetime datetime NOT NULL,
							PRIMARY KEY (idct),
							FOREIGN KEY (idemp) REFERENCES Employees(idemp),
							FOREIGN KEY (idacc) REFERENCES Accounts(idacc)
							ON UPDATE RESTRICT
							);
							
							
CREATE TABLE bankCards    ( idcard INTEGER AUTO_INCREMENT,
                           cardnumber BIGINT UNIQUE NOT NULL,
                           idacc bigint NOT NULL,							 
						   blocked char(1) Default 'F',
						   pin int NOT NULL default '0',
						   PRIMARY key(idcard),
						   Foreign key(idacc) 
						   REFERENCES Accounts(idacc)
						   ON DELETE CASCADE
						   ON UPDATE RESTRICT);
											  
											  
Create TABLE AtmWithdrawals   (idatmw INTEGER AUTO_INCREMENT,
                               amount float(10,2) NOT NULL,
							   Idatm INTEGER default 0,
							   datetime DATETIME DEFAULT CURRENT_TIMESTAMP,
							   idCard integer NOT NULL,
								PRIMARY key(idatmw),
								FOREIGN key(idcard)
								REFERENCES BankCards(idcard)
								ON DELETE CASCADE
								ON UPDATE RESTRICT);