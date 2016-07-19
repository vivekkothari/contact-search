package com.github.vivekkothari.contact;

import com.github.vivekkothari.contact.bean.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vivek.kothari on 19/07/16.
 */
public class InMemoryContactDao
        implements IContactDao {

    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(final Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> search(final String term) {
        return contacts.stream()
                       .filter(contact -> contact.getFirstName()
                                                 .contains(term) || contact.getLastName()
                                                                           .contains(term))
                       .sorted()
                       .collect(Collectors.toList());
    }
}
