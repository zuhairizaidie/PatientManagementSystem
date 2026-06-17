package patientManagement;

import java.sql.*;
import java.util.Random;

public class Patient extends User {
private String patientID;
    private String icPassport;
    private String dateOfBirth;
    private int age;
    private String gender;
    private String phoneNo;
    private String nationality;
    private String race;
    private String knownAllergies;
    private String bloodType;
    private String maritalStatus;

    public Patient() {
        super();
    }

    public Patient(String username, String password, String email, String name, 
                   String icPassport, String dateOfBirth, int age, String gender, String phoneNo) {
        super(username, password, email, name);
        this.patientID = String.valueOf(100000 + new java.util.Random().nextInt(900000));
        this.icPassport = icPassport;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }
    
    public Patient(String username, String password, String email, String name, 
                   String icPassport, String dateOfBirth, int age, String gender, String phoneNo,
                   String nationality, String race, String knownAllergies, String bloodType, String maritalStatus) {
        super(username, password, email, name);
        this.patientID = String.valueOf(100000 + new java.util.Random().nextInt(900000));
        this.icPassport = icPassport;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.nationality = nationality;
        this.race = race;
        this.knownAllergies = knownAllergies;
        this.bloodType = bloodType;
        this.maritalStatus = maritalStatus;
    }
    
    public static Patient getPatientFromDatabase(String searchUsername) {
    Connection conn = DBConnection.getConnection();
        if (conn == null) return null;

        String query = "SELECT * FROM patients WHERE username = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, searchUsername);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Patient p = new Patient(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("icPassport"),
                    rs.getString("dateOfBirth"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("phoneNo")
                );
                p.patientID = rs.getString("patientID");
                p.nationality = rs.getString("nationality");
                p.race = rs.getString("race");
                p.knownAllergies = rs.getString("knownAllergies");
                p.bloodType = rs.getString("bloodType");
                p.maritalStatus = rs.getString("maritalStatus");
                return p;
            }
        } catch (SQLException e) {
            System.out.println("Error fetching patient: " + e.getMessage());
        }
        return null;
    }
    
    public boolean registerInDatabase() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return false;
        }

        String query = "INSERT INTO patients (patientID, userID, name, icPassport, dateOfBirth, age, "
                + "gender, phoneNo, email, nationality, race, knownAllergies, bloodType, maritalStatus, "
                + "username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            int randomUserID = 500000 + new Random().nextInt(400000);

            pst.setString(1, this.patientID);
            pst.setInt(2, randomUserID);
            pst.setString(3, this.getName()); 
            pst.setString(4, this.icPassport);
            pst.setString(5, this.dateOfBirth);
            pst.setInt(6, this.age);
            pst.setString(7, this.gender);
            pst.setString(8, this.phoneNo);
            pst.setString(9, this.getEmail());
            pst.setString(10, this.nationality);
            pst.setString(11, this.race);
            pst.setString(12, this.knownAllergies);
            pst.setString(13, this.bloodType);
            pst.setString(14, this.maritalStatus);
            pst.setString(15, this.getUsername());
            pst.setString(16, this.getPassword());

            int result = pst.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            System.out.println("SQL Save Error: " + e.getMessage());
            return false;
        }
    }

    public boolean register1InDatabase() {
        return this.registerInDatabase();
    }

    @Override
    public String getName() {
        return super.getName(); 
    }
    
    public String getPatientID() { return patientID; }
    public String getIcPassport() { return icPassport; }
    public String getDateOfBirth() { return dateOfBirth; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getPhoneNo() { return phoneNo; }
    public String getNationality() { return nationality; }
    public String getRace() { return race; }
    public String getKnownAllergies() { return knownAllergies; }
    public String getBloodType() { return bloodType; }
    public String getMaritalStatus() { return maritalStatus; }

    
    public void register() {
        System.out.println("Patient registration was successful.");
    }

    public void updateProfile() {
        System.out.println("Patient profile has been updated.");
    }

    public void viewMedicalHistory() {

        System.out.println("Fetching medical history for Patient ID: " + this.patientID);

        MedicalRecord record = new MedicalRecord("REC9981", this.patientID, "High Fever & Cough", "Paracetamol 500mg & Rest", "2026-06-18");

        System.out.println("Date: " + record.getDateRecorded() + " | Diagnosis: " + record.getDiagnosis());
    }

    public boolean scheduleAppointment(int doctorID, Date date, String time) {
        System.out.println("Appointment successfully scheduled with Doctor ID: " + doctorID);
        return true;
    }
    
    @Override
    public void displayDashboard() {
        javax.swing.JFrame frame = FrameFactory.getFrame("SEARCH_PATIENT");
        if (frame != null) {
            frame.setVisible(true);
        }
    }
}
