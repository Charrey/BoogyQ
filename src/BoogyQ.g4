grammar BoogyQ;

program : statement*;
statement : flow DEL;

flow    : place
        | pipe;

place   : (place|pipe) PLACEOPR TYPE? ID
        | expr PLACEOPR TYPE? ID;
pipe    : (place|pipe) PIPEOPR TYPE? ID
        | expr PIPEOPR TYPE? ID;

expr : ID | NUMBER | '(' expr ')' | '(' (place|pipe) ')';

ID : [a-zA-Z] [a-zA-Z0-9]*;
DEL: '.';
NUMBER : [1-9] [0-9]* ;
IF : 'if' ;
BRACKETOPEN : '(' ;
BRACKETCLOSE : ')' ;
COLON : ':' ;
TAB: '\t';

TYPE: ('int'|'bool'|'char') '[]'*;
PLACEOPR: '->';
PIPEOPR: '=>';

