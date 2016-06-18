grammar BoogyQ;

program : (statement NEWLINE)* statement EOF;
statement : PRIMITIVE ID DEL
          | flow DEL;

flow    : flow (PLACEOPR type? |PIPEOPR)  ID
        | expr;


expr    : ID
        | NUMBER
        | array
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
array   : '[' (ID|NUMBER|BOOL|) (',' (ID|NUMBER|BOOL|))* ']'
        | '{'(ID|NUMBER|BOOL)'}' (TIMES NUMBER)+;


type: PRIMITIVE '[]'*;

PRIMITIVE : 'int'|'bool'|'char';

ID : [a-zA-Z] [a-zA-Z0-9]*;
NUMBER : '0' | [1-9] [0-9]* ;
BOOL: ('True' | 'False');


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

