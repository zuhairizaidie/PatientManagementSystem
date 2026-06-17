package patientManagement;

import java.util.Date;

public class MedicalRecord {
   private String recordID;
    private String patientID;
    private String diagnosis;
    private String treatment;
    private String dateRecorded;

    public MedicalRecord() {
    }

    public MedicalRecord(String recordID, String patientID, String diagnosis, String treatment, String dateRecorded) {
        this.recordID = recordID;
        this.patientID = patientID;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.dateRecorded = dateRecorded;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(String dateRecorded) {
        this.dateRecorded = dateRecorded;
    }
}