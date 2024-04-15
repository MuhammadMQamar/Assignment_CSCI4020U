package backend

abstract class Data {}

object None:Data() {
    override fun toString() = "None"
}

class IntData(val value: Int): Data() {
    override fun toString() = value.toString()
    override fun equals(other: Any?) = other is IntData && other.value == value
    override fun hashCode() = value.hashCode()
}

class StringData(val value: String): Data() {
    override fun toString() = value
    override fun equals(other: Any?) = other is StringData && other.value == value
    override fun hashCode() = value.hashCode()
}

class BooleanData(val value: Boolean): Data() {
    override fun toString() = value.toString()
    override fun equals(other: Any?) = other is BooleanData && other.value == value
    override fun hashCode() = value.hashCode()
}

class FuncData(
    val name: String,
    val params: List<String>,
    val body: Expr
): Data() {
    override fun toString() = "Function $name"
}

class ArrayData(val elements: MutableList<Data>) : Data() {
    override fun toString() = elements.joinToString(prefix = "[", postfix = "]")
}

class ListData(val elements: MutableList<Data>) : Data() {
    override fun toString() = elements.joinToString(prefix = "listOf[", postfix = "]")
}

class MapData(val pairs: MutableMap<Data, Data>) : Data() {
    override fun toString() = pairs.entries.joinToString(prefix = "{", postfix = "}") { "${it.key}: ${it.value}" }
}

class SetData(val elements: MutableSet<Data>) : Data() {
    override fun toString() = elements.joinToString(prefix = "setOf(", postfix = ")")
}

class PairData(val first: Data, val second: Data): Data() {
    override fun toString() = "($first, $second)"
}
