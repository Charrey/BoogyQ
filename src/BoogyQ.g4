grammar BoogyQ;

program : (statement NEWLINE)* statement;
statement : flow DEL;

flow    : flow (PLACEOPR TYPE? |PIPEOPR)  ID
        | expr (PLACEOPR TYPE? |PIPEOPR)  ID
        | expr;


expr    : ID
        | NUMBER
        | ARRAY
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
NUMBER : [1-9] [0-9]* ;
BOOL: ('True' | 'False');
ARRAY   : '[' (ID|NUMBER|BOOL|) (',' (ID|NUMBER|BOOL|))* ']';
DEL: '.';
IF : 'if' ;
LPAR   : '(';
RPAR   : ')';
COLON : ':' ;
TAB: '\t';
NEWLINE: '\n';
WS : ' ' -> skip;

OPENSCOPE : 'OPENSCOPE';
CLOSESCOPE : 'CLOSESCOPE';

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

