package org.challengingLavelProject.model;

import java.util.Arrays;
import java.util.List;

/**
 * Represents an organization contact in the phone book.
 * An Organization contact contains information related to
 * a company or institution such as organization name, address,
 * and phone number.
 */
public class Organization extends Contact {

    private String name = "";
    private String address = "";

    @Override
    public List<String> getEditableFields() {
        return Arrays.asList("name", "address", "number");
    }

    @Override
    public void setField(String field, String value) {

        switch (field.toLowerCase()) {

            case "name":
                name = value;
                break;

            case "address":
                address = value;
                break;

            case "number":
                number = validateNumber(value);
                break;
        }

        updateEditTime();
    }

    @Override
    public String getField(String field) {

        return switch (field.toLowerCase()) {
            case "name" -> name;
            case "address" -> address;
            case "number" -> number;
            default -> "";
        };
    }

    @Override
    public String getSummary() {
        return name;
    }

    @Override
    public String searchableText() {
        return (name + " " + address + " " + number).toLowerCase();
    }

    @Override
    public String toString() {
        return "Organization name: " + safe(name) + "\n" +
                "Address: " + safe(address) + "\n" +
                "Number: " + safe(number) + "\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + edited;
    }
}