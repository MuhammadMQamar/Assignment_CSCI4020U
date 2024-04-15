// Generated from f:/School/University/Year 2/Semester 2/Compilers/Final Project/Assignment_CSCI4020U/project/src/PL.g4 by ANTLR 4.13.1

import backend.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PLParser}.
 */
public interface PLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(PLParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(PLParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(PLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(PLParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmt(PLParser.IfElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmt(PLParser.IfElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(PLParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(PLParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(PLParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(PLParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(PLParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(PLParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(PLParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(PLParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#argumentsList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsList(PLParser.ArgumentsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#argumentsList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsList(PLParser.ArgumentsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void enterParametersList(PLParser.ParametersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void exitParametersList(PLParser.ParametersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#expressionsList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionsList(PLParser.ExpressionsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#expressionsList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionsList(PLParser.ExpressionsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#funtionCall}.
	 * @param ctx the parse tree
	 */
	void enterFuntionCall(PLParser.FuntionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#funtionCall}.
	 * @param ctx the parse tree
	 */
	void exitFuntionCall(PLParser.FuntionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(PLParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(PLParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#arrayIndexing}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndexing(PLParser.ArrayIndexingContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#arrayIndexing}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndexing(PLParser.ArrayIndexingContext ctx);
	/**
	 * Enter a parse tree produced by {@link PLParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(PLParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PLParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(PLParser.ArrayAssignmentContext ctx);
}