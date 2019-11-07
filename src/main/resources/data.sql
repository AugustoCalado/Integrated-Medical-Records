--DROP ALL OBJECTS

--CREATE SCHEMA  IF NOT EXISTS  MEDICAL_RECORDS  AUTHORIZATION admin;

/*
INSERT INTO USER (ID_USER, CELL_PHONE, EMAIL, NAME_LOGIN, PASSWORD) VALUES (1,'95998908436','augusto.test@test.com', 'augusto','001122');
INSERT INTO USER (ID_USER, CELL_PHONE, EMAIL, NAME_LOGIN, PASSWORD) VALUES (2,'9525450534','fernanda.test@test.com', 'fernanda','001122');
INSERT INTO USER (ID_USER, CELL_PHONE, EMAIL, NAME_LOGIN, PASSWORD) VALUES (3,'84987017681','diana.test@test.com', 'diana','001122');
INSERT INTO USER (ID_USER, CELL_PHONE, EMAIL, NAME_LOGIN, PASSWORD) VALUES (4,'8428003056','marcos.test@test.com', 'marcos','001122');


INSERT INTO PATIENT (ID_PATIENT,NAME,CPF,GENDER,BIRTHDATE,ID_USER) values (1,'augusto','42367438123','MALE',DATE '1997-01-11',1);
INSERT INTO PATIENT (ID_PATIENT,NAME,CPF,GENDER,BIRTHDATE,ID_USER) values (2,'fernanda','52224720190','FEMALE',DATE '1980-01-22',2);
INSERT INTO PATIENT (ID_PATIENT,NAME,CPF,GENDER,BIRTHDATE,ID_USER) values (3,'diana','42736783865','FEMALE',DATE '2000-01-06',3);
INSERT INTO PATIENT (ID_PATIENT,NAME,CPF,GENDER,BIRTHDATE,ID_USER) values (4,'marcos','42736743861','MALE',DATE '1993-01-11',4);


INSERT INTO VACCINE (ID_VACCINE, DESCRIPTION, NAME) VALUES  (1,'vacina contra febre amarela','FA');
INSERT INTO VACCINE (ID_VACCINE, DESCRIPTION, NAME) VALUES  (5,'vacina contra a hepatite B.','VHB');
INSERT INTO VACCINE (ID_VACCINE, DESCRIPTION, NAME) VALUES  (2,'vacina contra a poliomielite.','SABIN');
INSERT INTO VACCINE (ID_VACCINE, DESCRIPTION, NAME) VALUES  (3,'vacina contra difteria, coqueluche, tétano e H. influenzae tipo b.','DPT-Hib');
INSERT INTO VACCINE (ID_VACCINE, DESCRIPTION, NAME) VALUES  (4,'vacina contra a tuberculose.','BCG');


INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(1,1,1, DATE '2015-08-11', 'UBS ERMELINO MATARAZZO');
INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(2,5,1, DATE '2016-01-21', 'UBS ERMELINO MATARAZZO');
INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(3,2,1, DATE '2012-08-11', 'UBS ERMELINO MATARAZZO');
INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(4,3,3, DATE '2010-02-22', 'UBS ERMELINO MATARAZZO');
INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(5,2,3, DATE '2012-12-22', 'UBS ERMELINO MATARAZZO');
INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(6,1,3, DATE '2014-05-02', 'UBS ERMELINO MATARAZZO');
INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(7,1,3, DATE '2016-09-18', 'UBS ERMELINO MATARAZZO');
INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(8,2,3, DATE '2017-02-28', 'UBS ERMELINO MATARAZZO');
INSERT INTO VACCINE_HAS_PATIENT (IDVACCINES_HAS_PATIENT, ID_VACCINE, FK_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED) VALUES(9,4,3, DATE '2019-02-23', 'UBS ERMELINO MATARAZZO');


INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(1, 'Tipo sanguíneo','A+',1);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(2, 'Alergia Severa','Frutos do Mar',1);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(3, 'Alergia Severa','Amoxicilina',1);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(4, 'Tipo sanguíneo','AB+',2);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(5, 'Alergia Severa','Amendoin',2);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(6, 'Tipo sanguíneo','O-',3);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(7, 'Alergia Severa','Lactose',3);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(8, 'Tipo sanguíneo','B-',4);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(10, 'Doença Crônica','Diabetes Mellitus',3);
INSERT INTO EMERGENCY_CARD (ID_EMERGENCY_CARD, DECLARATION, OBSERVATIONS, FK_PATIENT) VALUES(11, 'Doença Crônica','Hipertensão',4);


INSERT INTO MEDICAL_RECORD (ID_MEDICAL_RECORD, DOCTOR_CRM, MAIN_COMPLAIN, CURRENT_DISEASE_INFORMATION, DIAGNOSTIC, PRESCRIPTION, MEDICAL_RECORD_DATE, MEDICAL_RECORD_PLACE, FK_PATIENT) VALUES(1, '123456','Dores na região das costas','Fortes dores nas costas ao permanecer sentado ou em pé','Mal jeito na região lombar', 'Paracetamol de 8 em 8h' ,DATE '2015-08-11', 'AMA São Miguel Paulista', 1);

-- DATE '2015-08-11'
--
-- INSERT INTO IMMUNIZATION_SCHEDULE (ID_IMMUNIZATION_SCHEDULE, START_AGE, END_AGE, RECOMMENDED_DOSAGE, ID_VACCINE) VALUES (1, 1, 3, 2, 4)
-- INSERT INTO IMMUNIZATION_SCHEDULE (ID_IMMUNIZATION_SCHEDULE, START_AGE, END_AGE, RECOMMENDED_DOSAGE, ID_VACCINE) VALUES (2, 5, 20, 1, 5)
-- INSERT INTO IMMUNIZATION_SCHEDULE (ID_IMMUNIZATION_SCHEDULE, START_AGE, END_AGE, RECOMMENDED_DOSAGE, ID_VACCINE) VALUES (3, 15, 20, 1, 2)
--
--





INSERT INTO PATIENT_HISTORIC (ID_PATHOLOGY_HISTORIC, DESCRIPTION, EXTRA_OBSERVATION, TYPE_HISTORIC, FK_PATIENT) VALUES(1, 'Arritmia cardíaca','Avó com arritmia cardiaca','FAMILY',1);
INSERT INTO PATIENT_HISTORIC (ID_PATHOLOGY_HISTORIC, DESCRIPTION, EXTRA_OBSERVATION, TYPE_HISTORIC, FK_PATIENT) VALUES(2, 'Estenose de Jup','Estenose de Jup rim direito','LIFE',1);
INSERT INTO PATIENT_HISTORIC (ID_PATHOLOGY_HISTORIC, DESCRIPTION, EXTRA_OBSERVATION, TYPE_HISTORIC, FK_PATIENT) VALUES(3, 'Cancer prostata','Pai teve cancer prostata','FAMILY',2);
INSERT INTO PATIENT_HISTORIC (ID_PATHOLOGY_HISTORIC, DESCRIPTION, EXTRA_OBSERVATION, TYPE_HISTORIC, FK_PATIENT) VALUES(4, 'Sarampo','Contraiu de sarambo aos 29','PATHOLOGIC',3);
INSERT INTO PATIENT_HISTORIC (ID_PATHOLOGY_HISTORIC, DESCRIPTION, EXTRA_OBSERVATION, TYPE_HISTORIC, FK_PATIENT) VALUES(5, 'Derrame articular ','Derrame articular joelho esquerdo','LIFE',4);
INSERT INTO PATIENT_HISTORIC (ID_PATHOLOGY_HISTORIC, DESCRIPTION, EXTRA_OBSERVATION, TYPE_HISTORIC, FK_PATIENT) VALUES(6, 'Hipertensão','Avô com hipertensão','FAMILY',4);


*/