package org.challengingLavelProject.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String number = "";
    protected LocalDateTime created;
    protected LocalDateTime edited;

    protected Contact() {
        created = LocalDateTime.now().withSecond(0).withNano(0);
        edited = created;
    }

    public abstract List<String> getEditableFields();

    public abstract void setField(String field, String value);

    public abstract String getField(String field);

    public abstract String getSummary();

    public abstract String searchableText();

    protected void updateEditTime() {
        edited = LocalDateTime.now().withSecond(0).withNano(0);
    }

    protected String validateNumber(String phoneNumber) {

        String regex = "^\\+?(\\([\\w]+\\)|[\\w]+([\\s-]\\([\\w]+\\))?)([\\s-][\\w]{2,})*$";

        if (phoneNumber.matches(regex)) {
            return phoneNumber;
        }

        System.out.println("Wrong number format!");
        return "[no data]";
    }

    protected String safe(String s) {
        return (s == null || s.isEmpty()) ? "[no data]" : s;
    }
}