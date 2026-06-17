package patientManagement;

public class Doctor extends User {
    private int doctorID;
    private String specialty;
    private int experience;
    private double rating;

    public Doctor(String username, String password, String email, String name, 
                  int doctorID, String specialty, int experience, double rating) {
        super(username, password, email, name);
        this.doctorID = doctorID;
        this.specialty = specialty;
        this.experience = experience;
        this.rating = rating;
    }

    public void viewMedicalHistory(String patientID) {

        System.out.println("Dr. " + getName() + " is viewing records for Patient ID: " + patientID);
    }

    public boolean addMedicalRecord(String patientID, String diagnosis, String treatment, String notes) {
        System.out.println("New medical record successfully added for Patient ID: " + patientID);
        return true;
    }
    
    public void writePrescription(String recordID, String medication, String dosage, String freq) {

        Prescription newPrescript = new Prescription("PRE6601", recordID, medication, dosage, freq);
        
        System.out.println("Doctor " + this.getName() + " prescribed " + 
                           newPrescript.getMedicationName() + " (" + newPrescript.getDosage() + ")");
    }

    public int getDoctorID() { return doctorID; }
    public String getSpecialty() { return specialty; }
    public int getExperience() { return experience; }
    public double getRating() { return rating; }
    
    @Override
    public void displayDashboard() {
        javax.swing.JOptionPane.showMessageDialog(null, "Welcome to Doctor Dashboard!");
    }
    
    
    
}
