package models;

import java.util.ArrayList;

public class ContactManager {
    
    ArrayList<Contact> contactList;

    public ContactManager() {
        this.contactList = new ArrayList<Contact>();
    }

    public Contact getContact(int index) {
        return new Contact(this.contactList.get(index));
    }

    public void setContact(int index, Contact contact) {
        this.contactList.set(index, new Contact(contact));
    }

    public void addContact(Contact contact) {
       this.contactList.add(new Contact(contact));
    }

    public void removeContact(String name) {
        if (this.contactList.isEmpty()) {
            throw new IllegalStateException("contact list must contain a contact");
        }
        for (Contact contact : this.contactList) {
            if (contact.getName().equals(name)) {
                this.contactList.remove(contact);
                break;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (Contact contact : this.contactList) {
            temp += contact.toString();
            temp += "\n\n";
        }
        return temp;
    }
}
