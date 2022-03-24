package live.adabe.contactapp.data.repository

import live.adabe.contactapp.data.model.Contact

interface ContactsRepository {

    fun addContact(contact: Contact)

    fun addContactByDetails(name: String, phone: String, email: String)

    fun getAllContacts(): List<Contact>

    fun getContactByPhone(phone: String): Contact

    fun getContactByName(name: String): Contact

}