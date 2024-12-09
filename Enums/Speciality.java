package Enums;

public enum Speciality {
    NUTRITION("Nutrition"),
    ENDOCHRINOLOGY("Endochrinology"),
    PHYSIOTHERAPY("Physiotherapy"),
    GENERALPRACTICE("General Practice"),
    PAEDIATRICIAN("Paediatrician"),
    NURSE("Nurse"),
    UNDEFINED("Undefined");

    public final String label;
    private Speciality(String label) {
        this.label = label;
    }
}
