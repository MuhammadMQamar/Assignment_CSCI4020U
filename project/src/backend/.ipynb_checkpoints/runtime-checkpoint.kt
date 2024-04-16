package backend

class Runtime() {
    val symbolTable:MutableMap<String, Data> = mutableMapOf()

    fun lookup(name: String): Data {
        val data = symbolTable[name]
        if (data == null) {
            throw RuntimeException("Undefined variable: $name")
        }
        // Handle LambdaData type
        if (data is LambdaData) {
            return data
        }
        return data
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