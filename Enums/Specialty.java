package Enums;

public enum Specialty {
    NUTRITION("Nutrition"),
    ENDOCHRINOLOGY("Endochrinology"),
    PHYSIOTHERAPY("Physiotherapy"),
    GENERALPRACTICE("GeneralPractice"),
    PAEDIATRICIAN("Paediatrician"),
    NURSE("Nurse"),
    UNDEFINED("Undefined");

    public final String label;

    private Specialty(String label) {
        this.label = label;
    }
}
