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
program: 'PROGRAM' id 'BEGIN' pgm_body 'END';			// global scope

id: IDENTIFIER;

pgm_body: data_declarations func_declarations;






// data declarations

data_declarations: 	  string_decl data_declarations 
					| var_decl data_declarations 
					| 
					;


string_decl: 'STRING' variable_name=id ':=' string_value=STRINGLITERAL ';'; 							// declaration


var_decl: var_type id_list ';';														// declaration, get type from here


var_type: 	  'INT' 			#declareInt
			| 'FLOAT'			#declareFloat
			;
			
			
id_list: variable_name=id id_tail;													// declaration


id_tail: 	 ',' variable_name=id id_tail 										// declaration
			| 									
			;
			






// function declarations

func_declarations:   func_decl func_declarations 	#nextFunction
					|								#noFunction
					;

func_decl: 'FUNCTION' func_type function_name=id '(' parameter_list ')' 'BEGIN' func_body 'END'; 			// function scope 

func_type: 'VOID' | var_type;

parameter_list: parameter_decl parameter_tail | ;

parameter_decl: var_type variable_name=id;																			//declaration

parameter_tail: 	 ',' parameter_decl parameter_tail 
					|
					;






// function body
func_body: data_declarations stmt_list;

stmt_list: stmt stmt_list | ;

stmt: basic_stmt | if_stmt | for_stmt;





// basic statment
basic_stmt: (assign_stmt | read_stmt | write_stmt | return_stmt) ';';

assign_stmt: id ':=' expr; // to be defined later

read_stmt: 'READ' '(' var_list ')';

write_stmt: 'WRITE' '(' var_list ')';

return_stmt: 'RETURN' expr;

var_list: variable_name=id var_list_tail;
var_list_tail:   ',' variable_name=id var_list_tail
				|
				;



// if statment

if_stmt: 'IF' '(' condition ')' data_declarations stmt_list else_part 'ENDIF';				        // if scope

else_part: 	 'ELSE' data_declarations myVar=stmt_list 	#elseRule										// else scope
			|											#noElse
			;											

condition: expr1 compare expr2;
expr1: expr;
expr2: expr;

compare: '=' | '!=' | '<' | '>' | '<=' | '>=';



// for statment

for_stmt: 'FOR' '(' init_stmt ';' condition ';' incr_stmt ')' data_declarations stmt_list 'ENDFOR';        // for scope

init_stmt: 	 assign_stmt 
			|
			;

incr_stmt: 	 assign_stmt 
			|
			;




// expressions

expr: expr_prefix term;

expr_prefix: expr_prefix term op=addop 		
			| 
			;

term: factor_prefix factor;

factor_prefix: 	factor_prefix factor op=mulop 
				| 
					;

factor: primary | call_expr;

primary: 	'(' expr ')' 		#exprFactor
			| INTLITERAL 		#intImmediateFactor
			| FLOATLITERAL 		#floatImmediateFactor
			| id 				#symbolFactor
			;

call_expr: id '(' expr_list ')';								// function call

expr_list: expr expr_list_tail | ;

expr_list_tail: ',' expr expr_list_tail | ;

addop: '+' | '-';

mulop: '*' | '/';


