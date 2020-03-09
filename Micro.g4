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



// pruduction rules

// program
program: 'PROGRAM' id 'BEGIN' pgm_body 'END';
id: IDENTIFIER;
pgm_body: data_declarations func_declarations;


// data declarations
data_declarations: (string_decl | var_decl) data_declarations | ;
string_decl: 'STRING' id ':=' STRINGLITERAL ';';
var_decl: var_type id_list ';';
var_type: 'INT' | 'FLOAT';
id_list: id id_tail;
id_tail: ',' id id_tail | ;


// function declarations
func_declarations:  func_decl func_declarations | ;
func_decl: 'FUNCTION' func_type id '(' parameter_list ')' 'BEGIN' func_body 'END';
func_type: 'VOID' | var_type;
parameter_list: parameter_decl parameter_tail | ;
parameter_decl: var_type id;
parameter_tail: ',' parameter_decl parameter_tail | ;


// function body
func_body: data_declarations stmt_list;
stmt_list: stmt stmt_list | ;
stmt: basic_stmt | if_stmt | for_stmt;


// basic statment
basic_stmt: (assign_stmt | read_stmt | write_stmt | return_stmt) ';';
assign_stmt: id ':=' expr; // to be defined later
read_stmt: 'READ' '(' id_list ')';
write_stmt: 'WRITE' '(' id_list ')';
return_stmt: 'RETURN' expr;


// if statment
if_stmt: 'IF' '(' condition ')' data_declarations stmt_list else_part 'ENDIF';
else_part: 'ELSE' data_declarations stmt_list | ;
condition: expr compare expr;
compare: '=' | '!=' | '<' | '>' | '<=' | '>=';


// for statment
for_stmt: 'FOR' '(' init_stmt ';' condition ';' incr_stmt ')' data_declarations stmt_list 'ENDFOR';
init_stmt: assign_stmt | ;
incr_stmt: assign_stmt | ;

// exressions
expr: expr_prefix term;
expr_prefix: expr_prefix term addop | ;
term: factor_prefix factor;
factor_prefix: factor_prefix factor mulop | ;
factor: primary | call_expr;
primary: '(' expr ')' | INTLITERAL | FLOATLITERAL | id ;
call_expr: id '(' expr_list ')';
expr_list: expr expr_list_tail | ;
expr_list_tail: ',' expr expr_list_tail | ;
addop: '+' | '-';
mulop: '*' | '/';






