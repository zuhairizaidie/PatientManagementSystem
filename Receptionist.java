package patientManagement;

public class Receptionist extends User {

    private int receptionistID;

    public Receptionist() {
        super();
        this.receptionistID = 0;
    }

    public Receptionist(String username, String password, String email, String name, int receptionistID) {
    
        super(username, password, email, name); 
        this.receptionistID = receptionistID;
    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(int receptionistID) {
        this.receptionistID = receptionistID;
    }

    public void registerPatient() {
        System.out.println("Receptionist is processing a new patient registration.");
    }

    public void searchPatient() {
        System.out.println("Searching database for patient records...");
    }

    public void scheduleAppointment() {
        System.out.println("New appointment booked by Receptionist.");
    }

    public void updatePatientProfile() {
        System.out.println("Patient profile updated by Receptionist.");
    }

    @Override
    public void displayDashboard() {
        javax.swing.JOptionPane.showMessageDialog(null, "Welcome to Receptionist Dashboard!");
    }
}
