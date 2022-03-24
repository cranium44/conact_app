package live.adabe.contactapp.data.repository

import android.os.Build
import live.adabe.contactapp.data.model.Contact
import live.adabe.contactapp.util.generateStringId
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ContactRepositoryImpl : ContactsRepository {
    override fun addContact(contact: Contact) {
        ContactsProvider.contacts.add(contact)
    }

    override fun addContactByDetails(name: String, phone: String, email: String) {
            val contact = Contact(
                name = name,
                phone = phone,
                email = email,
                dateCreated = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Calendar.getInstance().time)
            )
            ContactsProvider.contacts.add(contact)
    }

    override fun getAllContacts(): List<Contact> {
        return ContactsProvider.contacts
    }

    override fun getContactByPhone(phone: String): Contact {
        return ContactsProvider.contacts.filter {
            it.phone == phone
        }[0]
    }

    override fun getContactByName(name: String): Contact {
        return ContactsProvider.contacts.filter {
            it.name == name
        }[0]
    }
}