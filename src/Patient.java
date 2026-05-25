public class Patient {
    int age;
    String diagnosis;
    String service;
    String payer;
    String notes;

    public Patient(int age, String diagnosis, String service, String payer, String notes) {
        this.age = age;
        this.diagnosis = diagnosis;
        this.service = service;
        this.payer = payer;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return age + "yo - " + diagnosis + " - " + service;
    }
}

