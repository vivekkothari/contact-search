package com.github.vivekkothari.contact.dao;

import com.github.vivekkothari.contact.IContactDao;
import com.github.vivekkothari.contact.bean.Contact;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vivek.kothari on 22/07/16.
 */
public class TrieDaoImpl
        implements IContactDao {

    private final Trie trie;

    public TrieDaoImpl(final Trie trie) {
        this.trie = trie;
    }

    @Override
    public void addContact(final Contact contact) {
        trie.addWord(contact.toString());
    }

    @Override
    public List<Contact> search(final String term) {
        final List<String> words = trie.getWords(term.toLowerCase());
        return words.stream()
                    .map(word -> word.split(" "))
                    .map(split -> new Contact(split[0], split.length > 1 ? split[1] : null))
                    .collect(Collectors.toList());
    }
}
