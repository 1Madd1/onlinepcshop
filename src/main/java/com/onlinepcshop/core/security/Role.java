package com.onlinepcshop.core.security;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER"),
    UNKNOWN("UNKNOWN");

    private String name;

    Role(String n) {
        this.name = n;
    }

    public static Role fromName(String name) {
        for (Role r : Role.values()) {
            if (r.name.equals(name)) {
                return r;
            }
        }
        return UNKNOWN;
    }

    public String getName() {
        return this.name;
    }
}
