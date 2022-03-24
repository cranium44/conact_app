package live.adabe.contactapp.data.model

import live.adabe.contactapp.util.generateStringId

data class Contact(
    val id: String = generateStringId(),
    var name: String,
    var phone: String,
    var email: String,
    var dateCreated: String
)
