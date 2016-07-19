package com.github.vivekkothari.contact.bean;

import lombok.Getter;

/**
 * @author vivek.kothari on 19/07/16.
 */
@Getter
public class Contact
        implements Comparable<Contact> {

    private final String firstName;
    private final String lastName;

    public Contact(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName == null ? "" : lastName;
    }

    public int compareTo(final Contact o) {
        if (o.firstName.equals(firstName) || o.lastName.equals(lastName)) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
