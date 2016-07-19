package com.github.vivekkothari.contact;

import com.github.vivekkothari.contact.ContactException.ErrorCode;
import com.github.vivekkothari.contact.bean.Contact;

import java.util.List;

/**
 * @author vivek.kothari on 19/07/16.
 */
public class ContactService {

    private final IContactDao contactDao;

    public ContactService(final IContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void addContact(final String userInput) throws ContactException {
        if (userInput == null || userInput.isEmpty()) {
            throw new ContactException(ErrorCode.invalid_contact, "Contact cannot be empty");
        }
        final String[] split = userInput.split(" ");
        if (split.length > 2) {
            throw new ContactException(ErrorCode.invalid_contact, "Invalid contact format");
        }
        contactDao.addContact(new Contact(split[0], split.length == 2 ? split[1] : ""));
    }

    public List<Contact> searchContact(final String term) {
        return contactDao.search(term);
    }
}
