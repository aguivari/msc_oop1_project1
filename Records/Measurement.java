package Records;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import AuxClasses.Date;
import BaseClasses.Consultant;
import BaseClasses.Patient;
import Enums.DateFormat;

public record Measurement(
        Patient patient,
        Consultant consultant,
        Date measurementDate,
        double height,
        double weight,
        double circunference) implements Serializable {

    // copy constructor
    public Measurement(Measurement m) {
        this(new Patient(m.patient),
                new Consultant(m.consultant()),
                new Date(m.measurementDate()),
                m.height(),
                m.weight(),
                m.circunference());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ResourceBundle measurementsResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());

        sb.append(measurementsResourceBundle.getString("Measurementdate"));
        sb.append(": ").append(this.measurementDate.getFullDate(DateFormat.DMY));
        sb.append("\n").append(measurementsResourceBundle.getString("MeasurementForPatient"));
        sb.append(": ").append(this.patient.getName());
        sb.append(" ").append(this.patient().getSurname());
        sb.append("\n").append(measurementsResourceBundle.getString("MeasurementByConsultant"));
        sb.append(": ").append(this.consultant.getName());
        sb.append(" ").append(this.consultant().getSurname());
        sb.append("\n").append(measurementsResourceBundle.getString("ConsultantSpeciality"));
        sb.append(": ").append(this.consultant.getSpeciality());
        sb.append("\n").append(measurementsResourceBundle.getString("Measurements")).append("\n");
        sb.append(" - ").append(measurementsResourceBundle.getString("Height"));
        sb.append(": ").append(this.height()).append("\n");
        sb.append(" - ").append(measurementsResourceBundle.getString("Weight"));
        sb.append(": ").append(this.weight()).append("\n");
        sb.append(" - ").append(measurementsResourceBundle.getString("AbdominalCirc"));
        sb.append(": ").append(this.circunference()).append("\n");
        sb.append("\n");
        return sb.toString();
    }
}
