package backend

class Runtime() {
    val symbolTable:MutableMap<String, Data> = mutableMapOf()

    fun lookup(name: String): Data {
        return symbolTable[name] ?: throw RuntimeException("Undefined variable: $name")
    }

    fun assign(name: String, value: Data) {
        symbolTable[name] = value
    }

    fun subscope(bindings:Map<String, Data>):Runtime {
        val parentSymbolTable = this.symbolTable
        return Runtime().apply {
            symbolTable.putAll(parentSymbolTable)
            symbolTable.putAll(bindings)
        }
    }

    override fun toString():String =
        symbolTable.map { 
            entry -> "${entry.key} = ${entry.value}"
        }.joinToString("; ")
}