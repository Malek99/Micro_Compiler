// Generated from Micro.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MicroParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MicroVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MicroParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MicroParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(MicroParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#pgm_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPgm_body(MicroParser.Pgm_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#data_declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_declarations(MicroParser.Data_declarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#string_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_decl(MicroParser.String_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(MicroParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declareInt}
	 * labeled alternative in {@link MicroParser#var_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareInt(MicroParser.DeclareIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declareFloat}
	 * labeled alternative in {@link MicroParser#var_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareFloat(MicroParser.DeclareFloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(MicroParser.Id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#id_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_tail(MicroParser.Id_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#func_declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_declarations(MicroParser.Func_declarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#func_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_decl(MicroParser.Func_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#func_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_type(MicroParser.Func_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(MicroParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#parameter_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_decl(MicroParser.Parameter_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#parameter_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_tail(MicroParser.Parameter_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#func_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_body(MicroParser.Func_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(MicroParser.Stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(MicroParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#basic_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic_stmt(MicroParser.Basic_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(MicroParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#read_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_stmt(MicroParser.Read_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#write_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_stmt(MicroParser.Write_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(MicroParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#var_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_list(MicroParser.Var_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#var_list_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_list_tail(MicroParser.Var_list_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(MicroParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elseRule}
	 * labeled alternative in {@link MicroParser#else_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseRule(MicroParser.ElseRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noElse}
	 * labeled alternative in {@link MicroParser#else_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoElse(MicroParser.NoElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MicroParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(MicroParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(MicroParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#init_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_stmt(MicroParser.Init_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#incr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncr_stmt(MicroParser.Incr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MicroParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#expr_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_prefix(MicroParser.Expr_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(MicroParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#factor_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor_prefix(MicroParser.Factor_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(MicroParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MicroParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_expr(MicroParser.Call_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(MicroParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#expr_list_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list_tail(MicroParser.Expr_list_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(MicroParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MicroParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(MicroParser.MulopContext ctx);
}