grammar BoogyQ;

program : (statement NEWLINE)* statement;
statement : flow DEL;

flow    : flow (PLACEOPR TYPE? |PIPEOPR)  ID
        | expr (PLACEOPR TYPE? |PIPEOPR)  ID
        | expr;


expr    : ID
        | NUMBER
        | LPAR flow RPAR
        | expr (AND|OR) expr
        | expr HAT expr
        | expr (TIMES|DIVIDE) expr
        | expr (PLUS|MINUS) expr
        | expr operator expr
        | MINUS expr
        | NEGATION expr;

operator : HAT | TIMES | DIVIDE | PLUS | MINUS |
           AND | OR | COMP_EQ | COMP_NE | COMP_LE
           | COMP_LT | COMP_GE | COMP_GT;


TYPE: ('int'|'bool'|'char') '[]'*;

ID : [a-zA-Z] [a-zA-Z0-9]*;
DEL: '.';
NUMBER : [1-9] [0-9]* ;
IF : 'if' ;
LPAR   : '(';
RPAR   : ')';
COLON : ':' ;
TAB: '\t';
NEWLINE: '\n';
WS : ' ' -> skip;



HAT     : '^';
TIMES   : '*';
DIVIDE  : '/';
PLUS    : '+';
MINUS   : '-';
AND     : '&&';
OR      : '||';
COMP_EQ : '==';
COMP_NE : '!=';
COMP_LE : '<=';
COMP_LT : '<';
COMP_GE : '>=';
COMP_GT : '>';
NEGATION: '!';




PLACEOPR: '->';
PIPEOPR: '=>';

