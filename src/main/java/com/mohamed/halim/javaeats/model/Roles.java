package com.mohamed.halim.javaeats.model;

public enum Roles {
    ADMIN, MANAGER, CUSTOMER;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
