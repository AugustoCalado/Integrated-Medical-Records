/*CREATE SCHEMA  IF NOT EXISTS  MEDICAL_RECORDS  AUTHORIZATION admin

INSERT INTO MEDICAL_RECORDS.PATIENT (ID_PATIENT,NAME,CPF,GENDER,BIRTHDATE,MOTHER_NAME) values (1,'augusto','42736743865','MALE',DATE '1998-01-11','Telma')
INSERT INTO MEDICAL_RECORDS.PATIENT (ID_PATIENT,NAME,CPF,GENDER,BIRTHDATE,MOTHER_NAME) values (1,'augusto','42736743865','MALE',DATE '1998-01-11','Telma')
INSERT INTO MEDICAL_RECORDS.PATIENT (ID_PATIENT,NAME,CPF,GENDER,BIRTHDATE,MOTHER_NAME) values (1,'augusto','42736743865','MALE',DATE '1998-01-11','Telma')

INSERT INTO MEDICAL_RECORDS.USER (ID_USER, CELL_PHONE, EMAIL, NAME_LOGIN, PASSWORD, ID_PATIENT) VALUES ()
INSERT INTO MEDICAL_RECORDS.USER (ID_USER, CELL_PHONE, EMAIL, NAME_LOGIN, PASSWORD, ID_PATIENT) VALUES ()
INSERT INTO MEDICAL_RECORDS.USER (ID_USER, CELL_PHONE, EMAIL, NAME_LOGIN, PASSWORD, ID_PATIENT) VALUES ()
INSERT INTO MEDICAL_RECORDS.USER (ID_USER, CELL_PHONE, EMAIL, NAME_LOGIN, PASSWORD, ID_PATIENT) VALUES ()

INSERT INTO MEDICAL_RECORDS.HEALTH_INSURANCE
  (ID_HEALTH_INSURANCE,HEALTH_INSURANCE_COMPANY,HEALTH_INSURANCE_NAME,INSURANCE_CARD_NUMBER,CARD_EXPIRATION_DATE,ID_PATIENT)
  VALUES ()
INSERT INTO MEDICAL_RECORDS.HEALTH_INSURANCE
  (ID_HEALTH_INSURANCE,HEALTH_INSURANCE_COMPANY,HEALTH_INSURANCE_NAME,INSURANCE_CARD_NUMBER,CARD_EXPIRATION_DATE,ID_PATIENT)
  VALUES ()
INSERT INTO MEDICAL_RECORDS.HEALTH_INSURANCE
  (ID_HEALTH_INSURANCE,HEALTH_INSURANCE_COMPANY,HEALTH_INSURANCE_NAME,INSURANCE_CARD_NUMBER,CARD_EXPIRATION_DATE,ID_PATIENT)
  VALUES ()


INSERT INTO MEDICAL_RECORDS.VACCINE (ID_VACCINE, DESCRIPTION, NAME, N_DOSES) VALUES  ()
INSERT INTO MEDICAL_RECORDS.VACCINE (ID_VACCINE, DESCRIPTION, NAME, N_DOSES) VALUES  ()
INSERT INTO MEDICAL_RECORDS.VACCINE (ID_VACCINE, DESCRIPTION, NAME, N_DOSES) VALUES  ()
INSERT INTO MEDICAL_RECORDS.VACCINE (ID_VACCINE, DESCRIPTION, NAME, N_DOSES) VALUES  ()
INSERT INTO MEDICAL_RECORDS.VACCINE (ID_VACCINE, DESCRIPTION, NAME, N_DOSES) VALUES  ()

INSERT INTO MEDICAL_RECORDS.IMMUNIZATION_SCHEDULE
  (ID_IMMUNIZATION_SCHEDULE, START_AGE, END_AGE, RECOMMENDED_DOSAGE, ID_VACCINE)
  VALUES ()
INSERT INTO MEDICAL_RECORDS.IMMUNIZATION_SCHEDULE
  (ID_IMMUNIZATION_SCHEDULE, START_AGE, END_AGE, RECOMMENDED_DOSAGE, ID_VACCINE)
  VALUES ()
INSERT INTO MEDICAL_RECORDS.IMMUNIZATION_SCHEDULE
  (ID_IMMUNIZATION_SCHEDULE, START_AGE, END_AGE, RECOMMENDED_DOSAGE, ID_VACCINE)
  VALUES ()

INSERT INTO MEDICAL_RECORDS.VACCINE_HAS_PATIENT
  (IDVACCINES_HAS_PATIENT, ID_VACCINE, ID_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED)
  VALUES()
INSERT INTO MEDICAL_RECORDS.VACCINE_HAS_PATIENT
  (IDVACCINES_HAS_PATIENT, ID_VACCINE, ID_PATIENT, DATA_IMMUNIZATION, PLACE_VACCINE_APPLIED)
  VALUES()




*/