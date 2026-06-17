package patientManagement;

import java.util.Date;

public class Prescription {
    private String prescriptionID;
    private String recordID;
    private String medicationName;
    private String dosage;
    private String frequency;

    public Prescription() {
    }

    public Prescription(String prescriptionID, String recordID, String medicationName, String dosage, String frequency) {
        this.prescriptionID = prescriptionID;
        this.recordID = recordID;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.frequency = frequency;
    }

    public String getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(String prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
