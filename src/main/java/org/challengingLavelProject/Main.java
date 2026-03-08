package org.challengingLavelProject;

/**
 * Hello world!
 *
 */


import org.challengingLavelProject.controller.ContactController;
import org.challengingLavelProject.repository.PhoneBookRepository;
import org.challengingLavelProject.service.ContactService;

public class Main {

    public static void main(String[] args) {

        String fileName = args.length > 0 ? args[0] : null;

        PhoneBookRepository repository = new PhoneBookRepository(fileName);

        ContactService service = new ContactService(repository);

        ContactController controller = new ContactController(service);

        controller.start();
    }
}