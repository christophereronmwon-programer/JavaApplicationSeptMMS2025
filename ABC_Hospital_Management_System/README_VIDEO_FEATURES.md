# ABC Hospital Management System – video feature version

This update implements the feature areas shown in `ABC Hospital Frontend.mp4`.

## Main menu
1. Patient Management
2. Staff Management
3. Appointment Management
4. Admission & Bed Management
5. Clinical Management
6. Laboratory Services
7. Pharmacy Services
8. Billing & Payment
9. Hospital Administration
10. User Account
0. Logout

## Files changed / added

### Changed
- `src/hospital/ABCHospitalApp.java`
  - Replaced the patient-only console program with the complete menu-driven application.
  - Adds login, dashboard, patient, staff, appointment, admission/bed, clinical, laboratory, pharmacy, billing, administration and user-account features.
  - Uses transactions for operations that create a Person + Staff/Patient.
  - Uses SHA-256 for the application password value stored in `Users.PasswordHash`.

### Added
- `src/hospital/dao/HospitalDAO.java`
  - Common JDBC repository for SELECT, INSERT, UPDATE, DELETE and transactions.
- `database/ABC_HospitalDatabase.sql`
  - Fresh database schema matching the application.
  - Adds the missing `Ward`, `Room` and `Bed` tables required by the video.
  - Fixes the original admission discharge-date check.
  - Creates a first login: `admin` / `admin123`.

### Does NOT need to be changed
- `src/hospital/database/DatabaseConnection.java` (provided your SQL Server credentials are still `mainhospital` / `12345`)
- All files in `src/hospital/models/`
- `src/hospital/services/PatientService.java`
- `src/hospital/userview/PatientView.java`
- `src/hospital/dao/PatientDAO.java`
- NetBeans `nbproject` configuration

The old PatientDAO/PatientService/PatientView can remain in the project. The new application uses HospitalDAO so that the complete set of menu features does not require creating one DAO per table.

## Important database setup

Run `database/ABC_HospitalDatabase.sql` in SQL Server Management Studio on a fresh database setup.

If your existing `ABCHospitalDatabase` already contains data, do NOT blindly run the fresh-install script. Back up the database first and migrate the missing Ward/Room/Bed tables and the admission constraint separately.

## First login

Username: `admin`
Password: `admin123`

Change this password after the first login.

## Date/time input

Dates:
`yyyy-MM-dd`

Date/time:
`yyyy-MM-ddTHH:mm`

Example:
`2026-09-14T10:30`

## Notes

The supplied "ABC FRONTEND.zip" contains a video recording rather than HTML/CSS frontend source. The Java application in the other ZIP is a console application, so this update reproduces the functionality/menu structure shown in that recording rather than creating a web frontend.
