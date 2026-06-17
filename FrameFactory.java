package patientManagement;

import javax.swing.JFrame;

public class FrameFactory {
    
    public static JFrame getFrame(String frameType) {
        if (frameType == null) return null;
        
        switch (frameType.toUpperCase()) {
            case "LOGIN":
                return new LoginFrame();
            case "REGISTER":
                return new RegisterPatientFrame(); 
            case "FORGOT_PASSWORD":
                return new ForgotPassword(); 
            case "SEARCH_PATIENT":
                return new SearchPatientFrame();
            default:
                return null;
        }
    }
}
