package Records;

import java.io.Serializable;

import AuxClasses.Date;
import BaseClasses.Consultant;
import BaseClasses.Patient;
import Enums.DateFormat;

public record Measurement  (
        Patient patient,
        Consultant consultant,
        Date measurementDate,
        double height,
        double weight,
        double circunference) implements Serializable {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Measurement date: ").append(this.measurementDate.getFullDate(DateFormat.DMY));
        sb.append("\n").append("Measurement for patient: ").append(this.patient.getName()).append(" ").append(this.patient().getSurname());
        sb.append("\n").append("Measurement by consultant: ").append(this.consultant.getName()).append(" ").append(this.consultant().getSurname());
        sb.append("\n").append("Measurements:\n");
        sb.append(" - Height: ").append(this.height()).append("\n");
        sb.append(" - Weight: ").append(this.weight()).append("\n");
        sb.append(" - Abdominal Circunference: ").append(this.circunference());
        sb.append("\n");
        return sb.toString();
    }
}
