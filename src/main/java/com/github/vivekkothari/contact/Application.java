package com.github.vivekkothari.contact;

import com.github.vivekkothari.contact.bean.Contact;
import com.github.vivekkothari.contact.dao.Trie;
import com.github.vivekkothari.contact.dao.TrieDaoImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @author vivek.kothari on 19/07/16.
 */
public class Application {

    private static final String OPTIONS = "1) Add contact 2) Search 3) Exit";

    public static void main(String[] args) {
        final IContactDao contactDao = new TrieDaoImpl(new Trie());
        final ContactService contactService = new ContactService(contactDao);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(OPTIONS);
            final int option = cast(scanner.nextLine());
            if (option != 0) {
                System.out.print("Enter name: ");
            }
            switch (option) {
                case 1:
                    try {
                        contactService.addContact(scanner.nextLine());
                    } catch (ContactException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    final List<Contact> contacts = contactService.searchContact(scanner.nextLine());
                    contacts.stream()
                            .forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Happy Searching..");
                    System.exit(0);
                default:
                    System.out.println("Invalid default. Please try again.");
                    break;
            }
        } while (true);
    }

    private static int cast(final String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
