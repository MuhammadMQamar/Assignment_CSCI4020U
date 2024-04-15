package backend

abstract class Expr {
    abstract fun eval(runtime:Runtime):Data
}

class NoneExpr(): Expr() {
    override fun eval(runtime:Runtime) = None
}

class IntLiteral(val lexeme:String): Expr() {
    override fun eval(runtime:Runtime): Data
    = IntData(Integer.parseInt(lexeme))
}

class StringLiteral(val lexeme:String): Expr() {
    override fun eval(runtime:Runtime): Data
    = StringData(lexeme)
}

enum class Operator {
    Add,
    Sub,
    Mul,
    Div
}

class Arithmetics(
    val op:Operator,
    val left:Expr,
    val right:Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        return when (op) {
            Operator.Mul -> {
                if (x is StringData && y is IntData) {
                    StringData(x.value.repeat(y.value))
                } else if (x is IntData && y is IntData) {
                    IntData(x.value * y.value)
                } else {
                    throw Exception("Unsupported operand types for *")
                }
            }
            Operator.Add -> {
                if (x is IntData && y is IntData) {
                    // Add the integers
                    IntData(x.value + y.value)
                } else {
                    throw Exception("Unsupported operand types for +")
                }
            }
            Operator.Sub -> {
                if (x is IntData && y is IntData) {
                    // Subtract the integers
                    IntData(x.value - y.value)
                } else {
                    throw Exception("Unsupported operand types for -")
                }
            }
            Operator.Div -> {
                if (x is IntData && y is IntData) {
                    // Divide the integers
                    if (y.value != 0) {
                        IntData(x.value / y.value)
                    } else {
                        throw Exception("Cannot divide by zero")
                    }
                } else {
                    throw Exception("Unsupported operand types for /")
                }
            }
        }
    }
}

class Deref(val name:String): Expr() {
    override fun eval(runtime:Runtime):Data {
        val data = runtime.symbolTable[name]
        if(data == null) {
            throw Exception("$name is not assigned.")
        }
        return data
    }
}

class Block(val exprList: List<Expr>): Expr() {
    override fun eval(runtime:Runtime): Data {
        var result:Data = None
        exprList.forEach {
            result = it.eval(runtime)
        }
        return result
    }
}

class BooleanLiteral(val lexeme:String): Expr() {
    override fun eval(runtime:Runtime): Data
    = BooleanData(lexeme.equals("true"))
}

class Assign(val symbol:String, val expr:Expr): Expr() {
    override fun eval(runtime:Runtime): Data
    = expr.eval(runtime).apply {
        runtime.symbolTable.put(symbol, this)
    }
}

enum class Comparator {
    LT,
    LE,
    GT,
    GE,
    EQ,
    NE,
}

class Compare(
    val comparator: Comparator,
    val left: Expr,
    val right: Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val x = left.eval(runtime) as IntData
        val y = right.eval(runtime) as IntData
        return BooleanData(
            when(comparator) {
                Comparator.LT -> x.value < y.value
                Comparator.LE -> x.value <= y.value
                Comparator.GT -> x.value > y.value
                Comparator.GE -> x.value >= y.value
                Comparator.EQ -> x.value == y.value
                Comparator.NE -> x.value != y.value
            }
        )
    }
}

class Invoke(val name:String, val args:List<Expr>):Expr() {
    override fun eval(runtime:Runtime):Data {
        val func:Data? = runtime.symbolTable[name]
        if(func == null) {
            throw Exception("$name does not exist")
        }
        if(func !is FuncData) {
            throw Exception("$name is not a function.")
        }
        if(func.params.size != args.size) {
            throw Exception(
                "$name expects ${func.params.size} arguments "
                + "but received ${args.size}"
            )
        }
        
        val r = runtime.subscope(
            func.params.zip(args.map {it.eval(runtime)}).toMap()
        )
        return func.body.eval(r)
    }
}

class Declare(
    val name: String,
    val params: List<String>,
    val body: Expr
): Expr() {
    override fun eval(runtime:Runtime):Data
    = FuncData(name, params, body).also {
        runtime.symbolTable[name] = it
    }
}

class Ifelse(
    val cond:Expr,
    val trueExpr:Expr,
    val falseExpr:Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val cond_data = cond.eval(runtime) as BooleanData
        return if(cond_data.value) {
            trueExpr.eval(runtime)
        } else {
            falseExpr.eval(runtime)
        }
    }
}

class ForLoop(
    val loopVar: String, 
    val startExpr: Expr, 
    val endExpr: Expr, 
    val body: Expr
) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val start = startExpr.eval(runtime)
        val end = endExpr.eval(runtime)

        if (start !is IntData || end !is IntData) {
            throw Exception("For loop bounds must be integers")
        }

        var lastValue: Data = None
        for (i in start.value..end.value) {
            runtime.symbolTable[loopVar] = IntData(i)
            lastValue = body.eval(runtime)
        }
        return lastValue 
    }
}

class While(val cond:Expr, val body:Expr): Expr() {
    override fun eval(runtime:Runtime): Data {
        var flag = cond.eval(runtime) as BooleanData
        var result:Data = None
       
        var iter:Int = 1_000_000
        while(flag.value) {
            result = body.eval(runtime)
            flag = cond.eval(runtime) as BooleanData
            if(iter == 0) {
                println("MAX_ITER reached")
                println(runtime)
                return None
            }
            iter --
        }
        return result
    }
}

class Concatenation(
    val left: Expr,
    val right: Expr
) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val leftEval = left.eval(runtime)
        val rightEval = right.eval(runtime)
        val leftStr = when (leftEval) {
            is StringData -> leftEval.value
            is IntData -> leftEval.value.toString()
            else -> throw Exception("Unsupported data type for concatenation")
        }

        val rightStr = when (rightEval) {
            is StringData -> rightEval.value
            is IntData -> rightEval.value.toString()
            else -> throw Exception("Unsupported data type for concatenation")
        }
        return StringData(leftStr + rightStr)
    }
}

class Print(val args: List<Expr>): Expr() {
    override fun eval(runtime:Runtime): Data {
        var lastEvaluated: Data = None
        args.forEach { arg ->
            val evaluated = arg.eval(runtime)
            lastEvaluated = evaluated
            if (evaluated is ListData) {
                println(evaluated.elements.joinToString(prefix = "[", postfix = "]"))
            } else {
                println(evaluated)
            }
        }
        return lastEvaluated 
    }
}

class ArrayLiteral(val elements: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val arrayData = elements.map { it.eval(runtime) }.toMutableList()
        return ArrayData(arrayData)
    }
}

class ArrayIndexing(val name: String, val index: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val arrayData = runtime.lookup(name) as ArrayData
        val indexData = index.eval(runtime) as IntData
        val element = arrayData.elements[indexData.value]
        return if (element is IntData) {
            element
        } else {
            throw Exception("Array contains non-integer element at index $indexData")
        }
    }
}

class ArrayAssignment(val name: String, val index: Expr, val value: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val arrayData = runtime.lookup(name) as ArrayData
        val indexData = index.eval(runtime) as IntData
        val valueData = value.eval(runtime)
        arrayData.elements[indexData.value] = valueData
        return valueData
    }
}

class LengthFunctionCall(val arg: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val data = arg.eval(runtime)
        return when (data) {
            is ArrayData -> IntData(data.elements.size)
            is MapData -> IntData(data.pairs.size)
            is SetData -> IntData(data.elements.size)
            else -> throw Exception("Unsupported data type for length function")
        }
    }
}

class ListLiteral(val elements: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val listData = elements.map { it.eval(runtime) }.toMutableList()
        return ListData(listData)
    }
}

class MapLiteral(val pairs: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val mapData = pairs.map { it.eval(runtime) as PairData }.associate { it.first to it.second }.toMutableMap()
        return MapData(mapData)
    }
}

class SetLiteral(val elements: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val setData = elements.map { it.eval(runtime) }.toMutableSet()
        return SetData(setData)
    }
}

class PairExpr(val first: Expr, val second: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        return PairData(first.eval(runtime), second.eval(runtime))
    }
}









