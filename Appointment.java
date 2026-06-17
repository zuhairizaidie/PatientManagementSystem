package patientManagement;

    import java.util.Date;

public class Appointment {
    private String appointmentID;
    private Date appointmentDate;
    private String timeSlot;
    private String status;
    private String reason;

    public Appointment(String appointmentID, Date appointmentDate, String timeSlot, String status, String reason) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.status = status;
        this.reason = reason;
    }

    public void bookAppointment() {
        System.out.println("Appointment " + appointmentID + " has been booked.");
    }

    public void cancelAppointment() {
        System.out.println("Appointment " + appointmentID + " has been canceled.");
    }

    public void rescheduleAppointment() {
        System.out.println("Appointment " + appointmentID + " has been rescheduled.");
    }
}
