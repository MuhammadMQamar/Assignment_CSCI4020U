grammar PL;

@header {
import backend.*;
}

@members {
}

program returns [Expr expr]:
{  List<Expr> list = new ArrayList<Expr>();}
 (stmt{list.add($stmt.expr);})+ EOF 
{$expr = new Block(list); }
   ;

stmt returns [Expr expr] : 
    assign { $expr = $assign.expr; } ';'?
    | block  { $expr = $block.expr; }
    | ifElseStmt { $expr = $ifElseStmt.expr; }
    | forLoop { $expr = $forLoop.expr; }
    | expressions { $expr = $expressions.expr; } ';'
    | printStmt { $expr = $printStmt.expr; } ';'?
    | declare { $expr = $declare.expr; }
    | arrayAssignment { $expr = $arrayAssignment.expr; } ';'
    | arrayIndexing { $expr = $arrayIndexing.expr; } ';'
    ;
    
assign returns [Expr expr] : 
    ID '=' expressions { $expr = new Assign($ID.text, $expressions.expr); }
    ;
    
block returns [Expr expr] :
{  List<Expr> list = new ArrayList<Expr>();}
    '{' (stmt {list.add($stmt.expr);} )* '}' 
{$expr = new Block(list); }
    ;

ifElseStmt returns [Expr expr] :
    'if' '(' expressions ')' trueBlock=block ('else' falseBlock=block)? {
        Expr falseExpr = $falseBlock.expr!= null ? $falseBlock.expr: new NoneExpr();
        $expr= new Ifelse($expressions.expr, $trueBlock.expr, falseExpr);
    }
    ;

forLoop returns [Expr expr] :
    'for' '(' ID 'in' startExpr=expressions '..' endExpr=expressions ')' body=block {
        $expr = new ForLoop($ID.text, $startExpr.expr, $endExpr.expr, $body.expr);
    }
    ;
    
expressions returns [Expr expr] : 
    left=expressions '*' right=expressions { $expr= new Arithmetics(Operator.Mul, $left.expr, $right.expr); }
    | left=expressions '<' right=expressions { $expr = new Compare(Comparator.LT, $left.expr, $right.expr); }
    | left=expressions '<=' right=expressions { $expr = new Compare(Comparator.LE, $left.expr, $right.expr); }
    | left=expressions '>' right=expressions { $expr = new Compare(Comparator.GT, $left.expr, $right.expr); }
    | left=expressions '>=' right=expressions { $expr = new Compare(Comparator.GE, $left.expr, $right.expr); }
    | left=expressions '==' right=expressions { $expr = new Compare(Comparator.EQ, $left.expr, $right.expr); }
    | left=expressions '!=' right=expressions { $expr = new Compare(Comparator.NE, $left.expr, $right.expr); }
    | left=expressions '/' right=expressions { $expr= new Arithmetics(Operator.Div, $left.expr, $right.expr); }
    | left=expressions '+' right=expressions { $expr= new Arithmetics(Operator.Add, $left.expr, $right.expr); }
    | left=expressions '-' right=expressions { $expr = new Arithmetics(Operator.Sub, $left.expr, $right.expr); }
    | left=expressions '++' right=expressions { $expr = new Concatenation($left.expr, $right.expr); }
    | '-' expressions { $expr = new Arithmetics(Operator.Sub, new IntLiteral("0"), $expressions.expr); }
    | '(' expressions ')' { $expr = $expressions.expr; }
    | funtionCall { $expr = $funtionCall.expr; }
    | value { $expr = $value.expr; }
    | arrayLiteral { $expr = $arrayLiteral.expr; }
    | ID '[' index=expressions ']' { $expr = new ArrayIndexing($ID.text, $index.expr); }
    | mapLiteral { $expr = $mapLiteral.expr; }
    | setLiteral { $expr = $setLiteral.expr; }
    ;
    
printStmt returns [Expr expr] : 
    'print' '(' args=argumentsList ')' { $expr = new Print($args.list); }
    ;

declare returns [Expr expr] :
    'function' ID '(' params=parametersList? ')' block {
        List<String> paramNames = $params.list != null ? $params.list : new ArrayList<>();
        $expr = new Declare($ID.text, paramNames, $block.expr);
    }
    ;

argumentsList returns [List<Expr> list] : 
    { $list = new ArrayList<Expr>(); }
    (expressions { $list.add($expressions.expr); } (',' expressions { $list.add($expressions.expr); })*)? 
   ;
    
parametersList returns [List<String> list] :
    { $list = new ArrayList<String>(); } 
   ID { $list.add($ID.text); } (',' ID { $list.add($ID.text); })* 
    ;

expressionsList returns [List<Expr> list]
: { $list = new ArrayList<Expr>(); }
  (expressions { $list.add($expressions.expr); } (',' expressions { $list.add($expressions.expr); })*)?
;
    
funtionCall returns [Expr expr] : 
    ID '(' args=argumentsList ')' {
        List<Expr> arguments = $args.list != null ? $args.list : new ArrayList<>();
        if ($ID.text.equals("length") && arguments.size() == 1) {
            $expr = new LengthFunctionCall(arguments.get(0));
        } else {
            $expr = new Invoke($ID.text, arguments);
        }
    }
;

value returns [Expr expr]: 
    STRING {$expr = new StringLiteral($STRING.text.substring(1, $STRING.text.length() - 1));}
    | BOOLEAN { $expr = new BooleanLiteral($BOOLEAN.text); }
    | ID { $expr = new Deref($ID.text); }
    | NUMBER { $expr = new IntLiteral($NUMBER.text); }
    ;

arrayLiteral returns [Expr expr]
: '[' elements=expressionsList ']' { $expr = new ArrayLiteral($elements.list); };

arrayIndexing returns [Expr expr]
: ID '[' index=expressions ']' { $expr = new ArrayIndexing($ID.text, $index.expr); };

arrayAssignment returns [Expr expr]
: ID '[' index=expressions ']' '=' valueExpr=expressions { $expr = new ArrayAssignment($ID.text, $index.expr, $valueExpr.expr); };

listLiteral returns [Expr expr]
: 'listOf[' elements=expressionsList ']' { $expr = new ListLiteral($elements.list); };

mapLiteral returns [Expr expr]
: '{' pairs=keyValuePairs '}' { $expr = new MapLiteral($pairs.list); };

setLiteral returns [Expr expr]
: 'setOf(' elements=expressionsList ')' { $expr = new SetLiteral($elements.list); };

keyValuePairs returns [List<PairExpr> list]
: { $list = new ArrayList<PairExpr>(); }
  (key=expressions ':' valExpr=expressions { $list.add(new PairExpr($key.expr, $valExpr.expr)); } (',' key=expressions ':' valExpr=expressions { $list.add(new PairExpr($key.expr, $valExpr.expr)); })*)?
;

fragment INT : '0' | [1-9] [0-9]*;
STRING : '"' (~["\\])* '"';
NUMBER :  INT ('.' [0-9]+)? | INT;
ID : [a-zA-Z][a-zA-Z_0-9]*;
BOOLEAN : 'true' | 'false';
WS : [ \t\n\r]+ -> skip;
COMMENT : '//' .*? '\n' -> skip ;

