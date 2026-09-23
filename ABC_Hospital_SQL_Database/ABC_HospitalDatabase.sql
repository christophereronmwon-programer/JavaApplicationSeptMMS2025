/* ============================================================
   ABC HOSPITAL MANAGEMENT DATABASE
   SQL Server
   Fresh-install script for the console application.
   ============================================================ */

IF DB_ID(N'ABCHospitalDatabase') IS NULL
    CREATE DATABASE ABCHospitalDatabase;
GO

USE ABCHospitalDatabase;
GO

/* =========================
   CORE PEOPLE
   ========================= */

CREATE TABLE Person(
    PersonId INT IDENTITY(1,1) PRIMARY KEY,
    FirstName NVARCHAR(100) NOT NULL,
    LastName NVARCHAR(100) NOT NULL,
    Gender CHAR(1) NOT NULL,
    DateOfBirth DATE NOT NULL,
    Phone NVARCHAR(30),
    Email NVARCHAR(150),
    Street NVARCHAR(200),
    City NVARCHAR(100),
    Country NVARCHAR(100)
);
GO

CREATE TABLE Department(
    DepartmentId INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Description NVARCHAR(500),
    Location NVARCHAR(200)
);
GO

CREATE TABLE Patient(
    PatientId INT IDENTITY(1,1) PRIMARY KEY,
    BloodGroup NVARCHAR(10),
    Genotype NVARCHAR(10),
    Allergies NVARCHAR(500),
    EmergencyContact NVARCHAR(150),
    EmergencyPhone NVARCHAR(30),
    PersonId INT NOT NULL,
    CONSTRAINT FK_Patient_Person
        FOREIGN KEY (PersonId) REFERENCES Person(PersonId)
);
GO

CREATE TABLE Staff(
    StaffId INT IDENTITY(1,1) PRIMARY KEY,
    EmploymentDate DATE,
    Salary DECIMAL(18,2),
    DepartmentId INT,
    PersonId INT NOT NULL,
    CONSTRAINT FK_Staff_Person
        FOREIGN KEY(PersonId) REFERENCES Person(PersonId),
    CONSTRAINT FK_Staff_Departments
        FOREIGN KEY(DepartmentId) REFERENCES Department(DepartmentId)
);
GO

CREATE TABLE Doctor(
    DoctorId INT IDENTITY(1,1) PRIMARY KEY,
    Specialization NVARCHAR(150) NOT NULL,
    LicenseNumber NVARCHAR(100) NOT NULL UNIQUE,
    StaffId INT,
    CONSTRAINT FK_Doctor_Staff
        FOREIGN KEY(StaffId) REFERENCES Staff(StaffId)
);
GO

CREATE TABLE Nurse(
    NurseId INT IDENTITY(1,1) PRIMARY KEY,
    NursingLicense NVARCHAR(100) NOT NULL UNIQUE,
    Qualification NVARCHAR(150),
    StaffId INT,
    CONSTRAINT FK_Nurse_Staff
        FOREIGN KEY(StaffId) REFERENCES Staff(StaffId)
);
GO

CREATE TABLE Pharmacist(
    PharmacistId INT IDENTITY(1,1) PRIMARY KEY,
    Qualification NVARCHAR(150),
    LicenseNumber NVARCHAR(100) NOT NULL UNIQUE,
    StaffId INT,
    CONSTRAINT FK_Pharmacist_Staff
        FOREIGN KEY(StaffId) REFERENCES Staff(StaffId)
);
GO

CREATE TABLE LaboratoryTechnician(
    LaboratoryTechnicianId INT IDENTITY(1,1) PRIMARY KEY,
    Qualification NVARCHAR(100),
    LicenseNumber NVARCHAR(150) NOT NULL UNIQUE,
    StaffId INT,
    CONSTRAINT FK_LaboratoryTechnician_Staff
        FOREIGN KEY(StaffId) REFERENCES Staff(StaffId)
);
GO

/* =========================
   HOSPITAL ADMINISTRATION
   ========================= */

CREATE TABLE Ward(
    WardId INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    WardType NVARCHAR(100),
    Capacity INT NOT NULL,
    CONSTRAINT CK_Ward_Capacity CHECK (Capacity > 0)
);
GO

CREATE TABLE Room(
    RoomId INT IDENTITY(1,1) PRIMARY KEY,
    WardId INT NOT NULL,
    RoomNumber NVARCHAR(50) NOT NULL,
    RoomType NVARCHAR(100),
    Capacity INT NOT NULL,
    CONSTRAINT FK_Room_Ward
        FOREIGN KEY(WardId) REFERENCES Ward(WardId),
    CONSTRAINT CK_Room_Capacity CHECK (Capacity > 0),
    CONSTRAINT UQ_Room_Ward_Number UNIQUE(WardId, RoomNumber)
);
GO

CREATE TABLE Bed(
    BedId INT IDENTITY(1,1) PRIMARY KEY,
    RoomId INT NOT NULL,
    BedNumber NVARCHAR(50) NOT NULL,
    Occupied BIT NOT NULL DEFAULT 0,
    CONSTRAINT FK_Bed_Room
        FOREIGN KEY(RoomId) REFERENCES Room(RoomId),
    CONSTRAINT UQ_Bed_Room_Number UNIQUE(RoomId, BedNumber)
);
GO

/* =========================
   APPOINTMENTS / ADMISSIONS
   ========================= */

CREATE TABLE Appointment(
    AppointmentId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    DoctorId INT NOT NULL,
    AppointmentDate DATETIME2 NOT NULL,
    Reason NVARCHAR(500),
    Status NVARCHAR(50),
    Notes NVARCHAR(1000),
    CONSTRAINT FK_Appointment_Patient
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT FK_Appointment_Doctor
        FOREIGN KEY(DoctorId) REFERENCES Doctor(DoctorId)
);
GO

CREATE TABLE Admission(
    AdmissionId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    AdmissionDate DATETIME2 NOT NULL,
    DischargeDate DATETIME2,
    Reason NVARCHAR(500),
    Status NVARCHAR(50),
    CONSTRAINT FK_Admission_Patients
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT CK_Discharge_Date
        CHECK (DischargeDate IS NULL OR DischargeDate >= AdmissionDate)
);
GO

/* =========================
   CLINICAL
   ========================= */

CREATE TABLE Diagnose(
    DiagnosisId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    DoctorId INT NOT NULL,
    DiagnosisDate DATE NOT NULL,
    Condition NVARCHAR(200) NOT NULL,
    Description NVARCHAR(1000),
    Notes NVARCHAR(1000),
    CONSTRAINT FK_Diagnose_Patient
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT FK_Diagnose_Doctor
        FOREIGN KEY(DoctorId) REFERENCES Doctor(DoctorId)
);
GO

CREATE TABLE Treatment(
    TreatmentId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    DoctorId INT NOT NULL,
    DiagnosisId INT,
    TreatmentDate DATE NOT NULL,
    TreatmentName NVARCHAR(200) NOT NULL,
    Description NVARCHAR(1000),
    Notes NVARCHAR(1000),
    Status NVARCHAR(50),
    CONSTRAINT FK_Treatment_Patient
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT FK_Treatments_Doctors
        FOREIGN KEY(DoctorId) REFERENCES Doctor(DoctorId),
    CONSTRAINT FK_Treatments_Diagnoses
        FOREIGN KEY(DiagnosisId) REFERENCES Diagnose(DiagnosisId)
);
GO

CREATE TABLE NurseAssignment(
    NurseAssignmentId INT IDENTITY(1,1) PRIMARY KEY,
    NurseId INT NOT NULL,
    PatientId INT NOT NULL,
    AdmissionId INT,
    AssignmentDate DATETIME2 NOT NULL,
    EndDate DATETIME2,
    Shift NVARCHAR(50),
    Status NVARCHAR(50),
    Notes NVARCHAR(1000),
    CONSTRAINT FK_NurseAssignments_Nurses
        FOREIGN KEY(NurseId) REFERENCES Nurse(NurseId),
    CONSTRAINT FK_NurseAssignments_Patients
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT FK_NurseAssignments_Admissions
        FOREIGN KEY(AdmissionId) REFERENCES Admission(AdmissionId),
    CONSTRAINT CK_NurseAssignments_Dates
        CHECK (EndDate IS NULL OR EndDate >= AssignmentDate)
);
GO

CREATE TABLE MedicalRecord(
    MedicalRecordId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL UNIQUE,
    CreatedDate DATE NOT NULL,
    CONSTRAINT FK_MedicalRecords_Patients
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId)
);
GO

/* =========================
   LABORATORY
   ========================= */

CREATE TABLE LaboratoryTest(
    LaboratoryTestId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    LaboratoryTechnicianId INT NOT NULL,
    TestName NVARCHAR(200) NOT NULL,
    TestDate DATETIME2 NOT NULL,
    Result NVARCHAR(2000),
    ReferenceRange NVARCHAR(500),
    Status NVARCHAR(50),
    CONSTRAINT FK_LaboratoryTest_Patient
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT FK_LaboratoryTest_Technician
        FOREIGN KEY(LaboratoryTechnicianId)
        REFERENCES LaboratoryTechnician(LaboratoryTechnicianId)
);
GO

/* =========================
   PHARMACY
   ========================= */

CREATE TABLE Medication(
    MedicationId INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(200) NOT NULL,
    Description NVARCHAR(1000),
    DosageForm NVARCHAR(100),
    Price DECIMAL(18,2) NOT NULL,
    QuantityInStock INT NOT NULL DEFAULT 0,
    CONSTRAINT CK_Medication_Price CHECK (Price >= 0),
    CONSTRAINT CK_Medication_Stock CHECK (QuantityInStock >= 0)
);
GO

CREATE TABLE Prescription(
    PrescriptionId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    DoctorId INT NOT NULL,
    PrescriptionDate DATE NOT NULL,
    CONSTRAINT FK_Prescription_Patient
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT FK_Prescription_Doctor
        FOREIGN KEY(DoctorId) REFERENCES Doctor(DoctorId)
);
GO

CREATE TABLE PrescriptionItem(
    PrescriptionItemId INT IDENTITY(1,1) PRIMARY KEY,
    PrescriptionId INT NOT NULL,
    MedicationId INT NOT NULL,
    Dosage NVARCHAR(100),
    Frequency NVARCHAR(100),
    Duration INT,
    DurationUnit NVARCHAR(50),
    Instructions NVARCHAR(1000),
    CONSTRAINT FK_PrescriptionItem_Prescription
        FOREIGN KEY(PrescriptionId) REFERENCES Prescription(PrescriptionId),
    CONSTRAINT FK_PrescriptionItem_Medication
        FOREIGN KEY(MedicationId) REFERENCES Medication(MedicationId),
    CONSTRAINT CK_PrescriptionItems_Duration
        CHECK (Duration IS NULL OR Duration > 0)
);
GO

CREATE TABLE MedicationDispensing(
    MedicationDispensingId INT IDENTITY(1,1) PRIMARY KEY,
    PrescriptionId INT NOT NULL,
    PrescriptionItemId INT NOT NULL,
    PharmacistId INT NOT NULL,
    PatientId INT NOT NULL,
    DispensingDate DATETIME2 NOT NULL,
    Quantity INT NOT NULL,
    Status NVARCHAR(50),
    Notes NVARCHAR(1000),
    CONSTRAINT FK_Dispensings_Prescriptions
        FOREIGN KEY(PrescriptionId) REFERENCES Prescription(PrescriptionId),
    CONSTRAINT FK_Dispensings_PrescriptionItems
        FOREIGN KEY(PrescriptionItemId) REFERENCES PrescriptionItem(PrescriptionItemId),
    CONSTRAINT FK_Dispensings_Pharmacists
        FOREIGN KEY(PharmacistId) REFERENCES Pharmacist(PharmacistId),
    CONSTRAINT FK_Dispensings_Patients
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT CK_Dispensings_Quantity CHECK (Quantity > 0)
);
GO

/* =========================
   BILLING
   ========================= */

CREATE TABLE Invoice(
    InvoiceId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    InvoiceDate DATE NOT NULL,
    TotalAmount DECIMAL(18,2) NOT NULL DEFAULT 0,
    Status NVARCHAR(50),
    CONSTRAINT FK_Invoices_Patients
        FOREIGN KEY(PatientId) REFERENCES Patient(PatientId),
    CONSTRAINT CK_Invoices_TotalAmount CHECK (TotalAmount >= 0)
);
GO

CREATE TABLE InvoiceItem(
    InvoiceItemId INT IDENTITY(1,1) PRIMARY KEY,
    InvoiceId INT NOT NULL,
    Description NVARCHAR(500) NOT NULL,
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(18,2) NOT NULL,
    Amount AS (Quantity * UnitPrice) PERSISTED,
    CONSTRAINT FK_InvoiceItems_Invoices
        FOREIGN KEY(InvoiceId) REFERENCES Invoice(InvoiceId),
    CONSTRAINT CK_InvoiceItems_Quantity CHECK (Quantity > 0),
    CONSTRAINT CK_InvoiceItems_UnitPrice CHECK (UnitPrice >= 0)
);
GO

CREATE TABLE Payment(
    PaymentId INT IDENTITY(1,1) PRIMARY KEY,
    InvoiceId INT NOT NULL,
    Amount DECIMAL(18,2) NOT NULL,
    PaymentDate DATE NOT NULL,
    PaymentMethod NVARCHAR(50),
    CONSTRAINT FK_Payments_Invoices
        FOREIGN KEY(InvoiceId) REFERENCES Invoice(InvoiceId),
    CONSTRAINT CK_Payments_Amount CHECK (Amount > 0)
);
GO

/* =========================
   USERS
   ========================= */

CREATE TABLE Users(
    UserId INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(100) NOT NULL UNIQUE,
    PasswordHash NVARCHAR(500) NOT NULL,
    Role NVARCHAR(50) NOT NULL,
    StaffId INT,
    IsActive BIT NOT NULL DEFAULT 1,
    CONSTRAINT FK_Users_Staff
        FOREIGN KEY(StaffId) REFERENCES Staff(StaffId),
    CONSTRAINT CK_Users_Role CHECK (
        Role IN (
            'STAFF',
            'DOCTOR',
            'NURSE',
            'PHARMACIST',
            'LABORATORY_TECHNICIAN'
        )
    )
);
GO

/* =========================
   USEFUL INDEXES
   ========================= */

CREATE INDEX IX_Patient_PersonId ON Patient(PersonId);
CREATE INDEX IX_Staff_DepartmentId ON Staff(DepartmentId);
CREATE INDEX IX_Staff_PersonId ON Staff(PersonId);
CREATE INDEX IX_Appointment_PatientId ON Appointment(PatientId);
CREATE INDEX IX_Appointment_DoctorId ON Appointment(DoctorId);
CREATE INDEX IX_Appointment_Date ON Appointment(AppointmentDate);
CREATE INDEX IX_Admission_PatientId ON Admission(PatientId);
CREATE INDEX IX_LaboratoryTest_PatientId ON LaboratoryTest(PatientId);
CREATE INDEX IX_Prescription_PatientId ON Prescription(PatientId);
CREATE INDEX IX_Invoice_PatientId ON Invoice(PatientId);
GO

/* Default login for first run:
   username: admin
   password: admin123
*/
INSERT INTO Users(Username, PasswordHash, Role, StaffId)
VALUES
('admin',
 '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9',
 'STAFF',
 NULL);
GO

create login mainhospital with password = '12345';
create user mainhospital for login mainhospital; 

Grant insert, delete, update on Patient to mainhospital

USE ABCHospitalDatabase
GO
 

ALTER ROLE db_datareader
ADD MEMBER mainhospital; 

ALTER ROLE db_datawriter
ADD MEMBER mainhospital; 