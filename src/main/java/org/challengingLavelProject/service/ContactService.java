package org.challengingLavelProject.service;

import org.challengingLavelProject.model.Contact;
import org.challengingLavelProject.repository.PhoneBookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Service layer responsible for handling business logic related
 * to contacts.
 * This class acts as an intermediary between the controller
 * and repository layers.
 */
public class ContactService {

    private final PhoneBookRepository repository;

    public ContactService(PhoneBookRepository repository) {
        this.repository = repository;
    }

    public void addContact(Contact contact) {
        repository.add(contact);
    }

    public void deleteContact(Contact contact) {
        repository.remove(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public int count() {
        return repository.count();
    }

    public List<Contact> search(String query) {

        List<Contact> results = new ArrayList<>();

        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);

        for (Contact c : repository.findAll()) {

            if (pattern.matcher(c.searchableText()).find()) {
                results.add(c);
            }
        }

        return results;
    }

    public void save() {
        repository.save();
    }
}