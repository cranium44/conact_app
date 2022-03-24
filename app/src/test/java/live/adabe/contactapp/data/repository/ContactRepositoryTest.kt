package live.adabe.contactapp.data.repository

import live.adabe.contactapp.data.model.Contact
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class ContactRepositoryTest {

    private lateinit var SUT: ContactsRepository

    private val names = listOf("John", "Bob", "Mage", "Jessie")
    private val phones = listOf("12345", "12346", "12347", "12348")

    @Before
    fun setUp() {
        SUT = ContactRepositoryImpl()
    }


    @Test
    fun `user can add to contacts by object`(){
        val contact = Contact(name = "Johnson", phone =  "12345678", email =  "foo@x.bar", dateCreated =  "23/03/1985")
        SUT.addContact(contact)

        print(ContactsProvider.contacts)
        assertNotEquals(ContactsProvider.contacts.size, 0)
        assertEquals(SUT.getContactByName("Johnson").phone, "12345678")
    }

    @Test
    fun `user can add contacts by details`(){
        SUT.addContactByDetails(name = "Muhammad", phone = "09012345678", email = "bar@xyz.co")

        assertNotEquals(ContactsProvider.contacts.size, 0)
        assertEquals(SUT.getContactByName("Muhammad").phone, "09012345678")
    }

    @Test
    fun `user can get a contact by searching the name`(){
        for ((i, name) in names.withIndex()){
            SUT.addContactByDetails(name= name, "12345$i", "foo@bar.co")
        }

        assertEquals(SUT.getContactByName("Bob").phone, "123451")
        assertEquals(SUT.getContactByName("John").phone, "123450")
        assertEquals(SUT.getContactByName("Jessie").phone, "123453")
    }

    @Test
    fun `user can get a contact by searching the phone number`(){
        for ((i, phone) in phones.withIndex()){
            SUT.addContactByDetails(name= "User ${i+1}", phone = phone, "foo@bar.co")
        }

        assertEquals(SUT.getContactByPhone("12345").name, "User 1")
        assertEquals(SUT.getContactByPhone("12348").name, "User 4")
    }

    @Test
    fun `user can get the full contact list`(){
        for ((i, phone) in phones.withIndex()){
            SUT.addContactByDetails(name= "User ${i+1}", phone = phone, "foo@bar.co")
        }

        val result = SUT.getAllContacts()

        assertNotEquals(result.size, 0)
        assertNotNull(SUT.getContactByName("User 1"))
    }


}