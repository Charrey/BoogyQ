grammar BoogyQ;

program : NEWLINE* (statement NEWLINE+)* statement NEWLINE* EOF;
statement : statement comment                                                                 #commentstat
          | IF LPAR expr RPAR COLON NEWLINE openscope NEWLINE (statement NEWLINE)* closescope #ifstat
          | FUNCTION LPAR functionvars RPAR ID COLON NEWLINE openscope NEWLINE (statement NEWLINE)* closescope #functiondecl
          | CONCURRENT COLON NEWLINE openscope NEWLINE (statement NEWLINE)* closescope        #concurrentstat
          | flow? DEL                                                                         #flowstat
          | LOOP '{' NUMBER '}' DEL                                                           #loopstat
          | BREAK '{' NUMBER '}' DEL                                                          #breakstat
          | comment                                                                           #barecomment;


openscope : OPENSCOPE;
closescope : CLOSESCOPE;
functionvars : ((type ID) (',' type ID)*)? PLACEOPR type ID  ;

flow    : flow PLACEOPR ID              #assignstandardflow
        | flow PLACEOPR REACH? type ID         #declstandardflow

        | PIPEOPR ID                    #assigngeneratorflow // Voor functies zonder argumenten
        | flow (',' flow)* PIPEOPR ID   #assignfunctionflow
        | expr                          #exprflow;


expr    : BOOL                          #boolexpr
        | ID                            #idenexpr
        | REACH? PRIMITIVE ID           #declexpr
        | CHAR                          #charexpr
        | NUMBER                        #numberexpr
        | array                         #arraydecl
        | LPAR flow RPAR                #flowexpr

        | NEGATION expr                 #notexpr
        | MINUS expr                    #minusexpr
        | <assoc = right> expr HAT expr #powerexpr
        | expr (TIMES|DIVIDE) expr      #timesexpr
        | expr (PLUS|MINUS) expr        #plusexpr

        | expr (equality | inequality) expr      #comparatorexpr
        | expr (AND|OR) expr            #andorexpr;




equality : COMP_EQ | COMP_NE;
inequality : COMP_LE | COMP_LT | COMP_GE | COMP_GT;

array   : '[' (ID|NUMBER|BOOL|) (',' (ID|NUMBER|BOOL|))* ']'   #presetarray
        | '{'(ID|NUMBER|BOOL|CHAR)'}' (TIMES NUMBER)+               #multiarray;

comment : '//' (~'\n')*;

type: PRIMITIVE '[]'*;

PRIMITIVE : 'int'|'bool'|'char';
IF : 'if' ;
CONCURRENT: 'concurrent';
FUNCTION: 'function';
OPENSCOPE : 'OPENSCOPE';
CLOSESCOPE : 'CLOSESCOPE';
LOOP : 'loop';
BREAK : 'break';
REACH   : 'global'
        | 'local';

BOOL: ('True' | 'False');
ID : [a-zA-Z] [a-zA-Z0-9]*;
NUMBER : '0' | [1-9] [0-9]* ;
CHAR : '\'' . '\'';

DEL: '.';
LPAR   : '(';
RPAR   : ')';
COLON : ':' ;
TAB: '\t' -> skip;
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

