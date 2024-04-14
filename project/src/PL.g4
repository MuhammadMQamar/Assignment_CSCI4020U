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
    
funtionCall returns [Expr expr] : 
    ID '(' args=argumentsList ')' {
        List<Expr> arguments = $args.list != null ? $args.list : new ArrayList<>();
        $expr = new Invoke($ID.text, arguments);
    }
    ;

value returns [Expr expr]: 
    STRING {$expr = new StringLiteral($STRING.text.substring(1, $STRING.text.length() - 1));}
    | BOOLEAN { $expr = new BooleanLiteral($BOOLEAN.text); }
    | ID { $expr = new Deref($ID.text); }
    | NUMBER { $expr = new IntLiteral($NUMBER.text); }
    ;

fragment INT : '0' | [1-9] [0-9]*;
STRING : '"' (~["\\])* '"';
NUMBER :  INT ('.' [0-9]+)? | INT;
ID : [a-zA-Z][a-zA-Z_0-9]*;
BOOLEAN : 'true' | 'false';
WS : [ \t\n\r]+ -> skip;