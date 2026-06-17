package patientManagement;

import javax.swing.JFrame;

public class Main {

public static void main(String[] args) {
       
        java.awt.EventQueue.invokeLater(() -> {
            JFrame login = FrameFactory.getFrame("LOGIN");
            if (login != null) {
                login.setVisible(true);
            }
        });

        System.out.println("\n--- Testing Academic Requirements ---");
        DoctorRecommendation recommendation = new DoctorRecommendation();
        
        double[][] sampleMatrix = { {5, 4, 7}, {9, 3, 5} };
        double[] sampleWeights = { 0.4, 0.3, 0.3 };
        String[] sampleDoctors = { "DOC101", "DOC102" };
        
        recommendation.calculateTOPSIS(sampleMatrix, sampleWeights); 
        recommendation.calculateTOPSIS(sampleMatrix, sampleWeights, sampleDoctors); 
    }
    
}

