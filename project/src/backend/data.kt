package backend

abstract class Data

object None:Data() {
    override fun toString() = "None"
}

class IntData(val value: Int): Data() {
    override fun toString() = value.toString()
}

class StringData(val value: String): Data() {
    override fun toString() = value
}

class BooleanData(val value: Boolean): Data() {
    override fun toString() = value.toString()
}

class FuncData(
    val name: String,
    val params: List<String>,
    val body: Expr
): Data() {
    override fun toString() = "Function $name"
}