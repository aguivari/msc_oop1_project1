package Enums;

public enum ContractType {
    PERMANENT("Permanent"),
    TEMPORARY("Temporary"),
    UNDEFINED("Undefined");

    public final String label;
    private ContractType(String label) {
        this.label = label;
    }
}