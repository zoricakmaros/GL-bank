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
						
insert into Employees VALUES(1,'Jan','Kollar','kollar@pobox.sk','C');
insert into Employees VALUES(2,'Daniel','Molnar','molnar@pobox.sk','C');
insert into loginemployee values(1,1,'kollar','kollar');
insert into loginemployee values(2,2,'molnar','molnar');

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
					
INSERT INTO Clients(idc,firstname, lastname) VALUES (1, 'Dominik','Kovac');
INSERT INTO Clients(idc,firstname, lastname) VALUES (2, 'Martin','Cuper');
INSERT INTO Clients(idc,firstname, lastname) VALUES (3, 'Eva','Mizerova');
INSERT INTO Clients(idc,firstname, lastname) VALUES (4, 'Filip','Barbas');
INSERT INTO Clients(idc,firstname, lastname) VALUES (5, 'Martina','Balazova');

INSERT INTO LoginClient(idlc, idc, login , password) VALUES (1,1,'kovac','kovac');					
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (2,2,'cuper','cuper');	
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (3,3,'mizerova','mizerova');
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (4,4,'barbas','barbas');	
INSERT INTO LoginClient(idlc, idc, login , password) VALUES (5,5,'balazova','balazova');

INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (1,1,'Humenska',15,'04011','Kosice','1984-04-15','kovac@zoznam.sk');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (2,2,'Krosnianska',41,'04022','Kosice','1985-07-01','cupi@zoznam.sk');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city,dob, email)
VALUES (3,3,'Havanska',83,'04023','Kosice','1995-08-30','mizerova@pobox.sk');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (4,4,'Dneperska',19,'04012','Kosice','1989-10-25','barbas@gmail.com');
INSERT INTO ClientDetails (idcd,idc, street, housenumber, postcode, city, dob, email)
VALUES (5,5,'Levocska',4,'08001','Presov','1980-12-25','balazova@zoznam.sk');	