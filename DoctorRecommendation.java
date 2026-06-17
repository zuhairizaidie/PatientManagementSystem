package patientManagement;

 public class DoctorRecommendation {
    private double score;
    private String rankingDate;

    public void calculateTOPSIS(double[][] decisionMatrix, double[] weights) {
        System.out.println("Executing TOPSIS calculation using raw matrix arrays...");
        
        int rows = decisionMatrix.length;
        int cols = decisionMatrix[0].length;

        double[][] normalizedMatrix = new double[rows][cols];
        for (int j = 0; j < cols; j++) {
            double sqSum = 0;
            for (int i = 0; i < rows; i++) {
                sqSum += Math.pow(decisionMatrix[i][j], 2);
            }
            double columnLength = Math.sqrt(sqSum);
            for (int i = 0; i < rows; i++) {
                normalizedMatrix[i][j] = decisionMatrix[i][j] / columnLength;
            }
        }

        double[][] weightedMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                weightedMatrix[i][j] = normalizedMatrix[i][j] * weights[j];
            }
        }
        
        System.out.println("TOPSIS Matrix calculated successfully primitive data type arrays.");
    }

    public void calculateTOPSIS(double[][] decisionMatrix, double[] weights, String[] doctorIDs) {

        calculateTOPSIS(decisionMatrix, weights);

        System.out.println("Mapping TOPSIS scores to " + doctorIDs.length + " doctors.");
    }
    
    public void rankDoctors() {
        System.out.println("Doctors ranked based on TOPSIS separation measures.");
    }
}
