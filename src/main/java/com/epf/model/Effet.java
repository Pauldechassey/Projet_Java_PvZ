package com.epf.model;

public enum Effet {
    NORMAL("normal"),
    SLOW_LOW("slow_low"),
    SLOW_MEDIUM("slow_medium"),
    SLOW_STOP("slow_stop");

    private final String code;

    Effet(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static Effet fromCode(String code) {
        for (Effet effet : Effet.values()) {
            if (effet.getCode().equals(code)) {
                return effet;
            }
        }
        throw new IllegalArgumentException("Code d'effet inconnu: " + code);
    }

    @Override
    public String toString() {
        return this.code;
    }
}