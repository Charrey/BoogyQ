grammar BoogyQ;

program : (statement NEWLINE)* statement EOF;
statement : statement NEWLINE                                                                 #emptystat
          | statement comment                                                                 #commentstat
          | IF LPAR expr RPAR COLON NEWLINE openscope NEWLINE (statement NEWLINE)* closescope #ifstat
          | FUNCTION LPAR functionvars RPAR ID COLON NEWLINE openscope NEWLINE (statement NEWLINE)* closescope #functiondecl
          | CONCURRENT COLON NEWLINE openscope NEWLINE (statement NEWLINE)* closescope        #concurrentstat
          | flow? DEL                                                                         #flowstat
          | LOOP '{' NUMBER '}' DEL                                                           #loopstat
          | BREAK '{' NUMBER '}' DEL                                                          #breakstat;


openscope : OPENSCOPE;
closescope : CLOSESCOPE;
functionvars : ((type ID) (',' type ID)*)? PLACEOPR type ID  ;

flow    : flow PLACEOPR ID              #assignstandardflow
        | flow PLACEOPR type ID         #declstandardflow

        | PIPEOPR ID                    #assigngeneratorflow // Voor functies zonder argumenten
        | PIPEOPR type ID               #declgeneratorflow  // Voor functies zonder argumenten
        | flow (',' flow)* PIPEOPR ID   #assignfunctionflow
        | flow (',' flow)* PIPEOPR type ID   #declfunctionflow
        | expr                          #ignoreme;


expr    : ID                            #idenexpr
        | PRIMITIVE ID                  #declexpr
        | NUMBER                        #numberexpr
        | array                         #arraydecl
        | LPAR flow RPAR                #flowexpr
        | expr (AND|OR) expr            #andorexpr
        | expr comparator expr          #comparatorexpr
        | expr HAT expr                 #powerexpr
        | expr (TIMES|DIVIDE) expr      #timesexpr
        | expr (PLUS|MINUS) expr        #plusexpr
        | MINUS expr                    #minusexpr
        | NEGATION expr                 #notexpr;

comparator :  COMP_EQ | COMP_NE | COMP_LE
           | COMP_LT | COMP_GE | COMP_GT;

array   : '[' (ID|NUMBER|BOOL|) (',' (ID|NUMBER|BOOL|))* ']'
        | '{'(ID|NUMBER|BOOL)'}' (TIMES NUMBER)+;

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

ID : [a-zA-Z] [a-zA-Z0-9]*;
NUMBER : '0' | [1-9] [0-9]* ;
BOOL: ('True' | 'False');


DEL: '.';
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

