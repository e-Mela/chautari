package org.emela.chautari.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TitleEnum {
    MS("Ms"),
    MR("Mr"),
    MISS("Miss"),
    NOT_SPECIFIED("Not Specified");

    private final String value;

    TitleEnum(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TitleEnum fromValue(String text) {
        for (TitleEnum b : TitleEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
