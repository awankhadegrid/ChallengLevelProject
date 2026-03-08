package org.challengingLavelProject.model;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a personal contact in the phone book.
 * A Person contact contains personal information such as
 * name, surname, birth date, gender, and phone number.
 */
public class Person extends Contact {

    private String name = "";
    private String surname = "";
    private String birth = "";
    private String gender = "";

    @Override
    public List<String> getEditableFields() {
        return Arrays.asList("name", "surname", "birth", "gender", "number");
    }

    @Override
    public void setField(String field, String value) {

        switch (field.toLowerCase()) {

            case "name":
                name = value;
                break;

            case "surname":
                surname = value;
                break;

            case "birth":
                birth = value;
                break;

            case "gender":
                gender = value;
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
            case "surname" -> surname;
            case "birth" -> birth;
            case "gender" -> gender;
            case "number" -> number;
            default -> "";
        };
    }

    @Override
    public String getSummary() {
        return name + " " + surname;
    }

    @Override
    public String searchableText() {
        return (name + " " + surname + " " + number).toLowerCase();
    }

    @Override
    public String toString() {
        return "Name: " + safe(name) + "\n" +
                "Surname: " + safe(surname) + "\n" +
                "Birth date: " + safe(birth) + "\n" +
                "Gender: " + safe(gender) + "\n" +
                "Number: " + safe(number) + "\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + edited;
    }
}