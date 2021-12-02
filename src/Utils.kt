import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src/resources", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
fun readInputAsIntegerList(name: String): List<Int> = readInput(name).map { Integer.parseInt(it) }
fun readInputAsCoords(name: String): List<Pair<String, Int>> {
    val transform: (String) -> Pair<String, Int> = {
        val split = it.split(" ")
        split[0].uppercase(Locale.getDefault()) to Integer.parseInt(split[1])
    }
    return readInput(name).map(transform)
}
