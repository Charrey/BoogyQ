grammar BoogyQ;

program : (statement NEWLINE)* statement;
statement : flow DEL;

flow    : flow (PLACEOPR TYPE? |PIPEOPR)  ID
        | expr (PLACEOPR TYPE? |PIPEOPR)  ID;


expr : ID | NUMBER | '(' expr ')' | '(' flow ')';

ID : [a-zA-Z] [a-zA-Z0-9]*;
DEL: '.';
NUMBER : [1-9] [0-9]* ;
IF : 'if' ;
BRACKETOPEN : '(' ;
BRACKETCLOSE : ')' ;
COLON : ':' ;
TAB: '\t';
NEWLINE: '\n';

TYPE: ('int'|'bool'|'char') '[]'*;
PLACEOPR: '->';
PIPEOPR: '=>';

