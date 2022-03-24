package live.adabe.contactapp.util

private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
const val STRING_LENGTH = 10;
const val ALPHANUMERIC_REGEX = "[a-zA-Z0-9]+";

fun generateStringId(): String{
    return (1..STRING_LENGTH)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")
}