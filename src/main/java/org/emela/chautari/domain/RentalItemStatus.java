package org.emela.chautari.domain;

public enum RentalItemStatus {

    NEW("New"),

    PENDING("Pending"),

    BOOKED("Booked");

    private final String value;

    RentalItemStatus(String value) {
        this.value = value;
    }

    public static RentalItemStatus fromValue(String text) {
        for (RentalItemStatus b : RentalItemStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

    public String toString() {
        return String.valueOf(value);
    }

}
