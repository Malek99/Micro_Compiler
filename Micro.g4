grammar Micro;


KEYWORD:  'PROGRAM' | 'BEGIN' | 'END' | 'FUNCTION'|
         'READ' | 'WRITE' | 'IF' | 'ELSE' | 
         'ENDIF' | 'FOR' | 'ENDFOR' | 'RETURN' | 
         'INT' | 'VOID' | 'STRING' | 'FLOAT' ;
       
 
OPERATOR: ':=' | '+' | '-' | '*' | '/' | '=' | '!=' |
          '<' | '>' | '(' | ')' | ';' | ',' | '<=' | '>=';


IDENTIFIER: ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])*;

INTLITERAL: [0-9]+;

FLOATLITERAL: [0-9]*'.'[0-9]+;

STRINGLITERAL: '"' ~'"'* '"';

COMMENT: '--' ~'\n'* '\n' -> skip;

WS : (' '|'\t'|'\r'|'\n')+ -> skip ;  // skip spaces, tabs, newlines

