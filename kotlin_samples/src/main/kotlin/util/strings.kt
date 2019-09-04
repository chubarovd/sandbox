@file:JvmName("StringUtil")

package util

fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val sb = StringBuilder(prefix)
    for ((index, item) in collection.withIndex()) {
        if (index > 0) sb.append(separator)
        sb.append(item)
    }
    sb.append(postfix)
    return sb.toString()
}