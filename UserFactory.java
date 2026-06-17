package patientManagement;

public class UserFactory {
    
 public static User verifyAndCreateUser(String username, String password) {
        
        // 1. Cuba cari dalam jadual Patient dahulu
        Patient p = Patient.getPatientFromDatabase(username);
        if (p != null && p.getPassword().equals(password)) {
            return p; // Pulangkan objek Patient sebagai jenis User
        }
        
        // 2. Jika tiada, sistem boleh semak jadual Doctor (jika ada fungsi database)
        // Doctor d = Doctor.getDoctorFromDatabase(username);
        // if (d != null && d.getPassword().equals(password)) { return d; }
        
        // 3. Jika tiada padanan langsung, pulangkan null (Login Gagal)
        return null;
    }
}
