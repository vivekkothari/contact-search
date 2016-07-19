package com.github.vivekkothari.contact;

import com.github.vivekkothari.contact.bean.Contact;

import java.util.List;

/**
 * @author vivek.kothari on 19/07/16.
 */
public interface IContactDao {

    void addContact(final Contact contact);

    List<Contact> search(final String term);

}
