package org.challengingLavelProject.repository;

import org.challengingLavelProject.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class responsible for managing the storage and
 * retrieval of contacts.
 * This class acts as the data access layer of the application.
 * It stores contacts in memory and persists them to a file using
 * Java object serialization.
 */
public class PhoneBookRepository {

    private List<Contact> contacts = new ArrayList<>();

    private final String fileName;

    public PhoneBookRepository(String fileName) {
        this.fileName = fileName;
        load();
    }

    public void add(Contact contact) {
        contacts.add(contact);
        save();
    }

    public void remove(Contact contact) {
        contacts.remove(contact);
        save();
    }

    public List<Contact> findAll() {
        return contacts;
    }

    public int count() {
        return contacts.size();
    }

    public void save() {

        if (fileName == null) return;

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(contacts);

        } catch (IOException ignored) {
        }
    }

    private void load() {

        if (fileName == null) return;

        File file = new File(fileName);

        if (!file.exists()) return;

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            contacts = (List<Contact>) ois.readObject();

        } catch (Exception ignored) {
        }
    }
}