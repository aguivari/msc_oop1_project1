public enum Speciality {
    NUTRITION("Nutrition"),
    ENDOCHRINOLOGY("Endochrinology"),
    PHYSIOTHERAPY("Physiotherapy"),
    GENERALPRACTICE("General Practice"),
    UNDEFINED("Undefined");

    public final String label;
    private Speciality(String label) {
        this.label = label;
    }
}
