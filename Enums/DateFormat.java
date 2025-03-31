package Enums;

public enum DateFormat {
    DMY("DMY"),
    YMD("YMD"),
    MDY("MDY");

    public final String label;

    private DateFormat(String label) {
        this.label = label;
    }
}
