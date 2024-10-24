package Enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNDEFINED("Undefined");

    public final String label;
    private Gender(String label) {
        this.label = label;
    }
}