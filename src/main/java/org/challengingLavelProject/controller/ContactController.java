package org.challengingLavelProject.controller;

import org.challengingLavelProject.model.Contact;
import org.challengingLavelProject.model.Organization;
import org.challengingLavelProject.model.Person;
import org.challengingLavelProject.service.ContactService;

import java.util.List;
import java.util.Scanner;

public class ContactController {

    private final ContactService service;
    private final Scanner scanner = new Scanner(System.in);

    public ContactController(ContactService service) {
        this.service = service;
    }

    public void start() {

        while (true) {

            System.out.print("[menu] Enter action (add, list, search, count, exit): > ");

            String action = scanner.nextLine().toLowerCase();

            switch (action) {

                case "add":
                    addRecord();
                    break;

                case "list":
                    listRecords();
                    break;

                case "search":
                    search();
                    break;

                case "count":
                    System.out.println("The Phone Book has " + service.count() + " records.");
                    break;

                case "exit":
                    return;
            }

            System.out.println();
        }
    }

    private void addRecord() {

        System.out.print("Enter the type (person, organization): > ");

        String type = scanner.nextLine().toLowerCase();

        Contact contact =
                type.equals("person") ? new Person() : new Organization();

        for (String field : contact.getEditableFields()) {

            System.out.print("Enter " + field + ": > ");

            contact.setField(field, scanner.nextLine());
        }

        service.addContact(contact);

        System.out.println("The record added.");
    }

    private void listRecords() {

        List<Contact> contacts = service.getAllContacts();

        for (int i = 0; i < contacts.size(); i++) {

            System.out.println((i + 1) + ". " + contacts.get(i).getSummary());
        }
    }

    private void search() {

        System.out.print("Enter search query: > ");

        String query = scanner.nextLine();

        List<Contact> results = service.search(query);

        System.out.println("Found " + results.size() + " results:");

        for (int i = 0; i < results.size(); i++) {

            System.out.println((i + 1) + ". " + results.get(i).getSummary());
        }
    }
}