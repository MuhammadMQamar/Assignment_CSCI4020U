// Generated from java-escape by ANTLR 4.11.1

import backend.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, STRING=26, NUMBER=27, ID=28, BOOLEAN=29, WS=30;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_assign = 2, RULE_block = 3, RULE_ifElseStmt = 4, 
		RULE_forLoop = 5, RULE_expressions = 6, RULE_printStmt = 7, RULE_declare = 8, 
		RULE_argumentsList = 9, RULE_parametersList = 10, RULE_funtionCall = 11, 
		RULE_value = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "assign", "block", "ifElseStmt", "forLoop", "expressions", 
			"printStmt", "declare", "argumentsList", "parametersList", "funtionCall", 
			"value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'{'", "'}'", "'if'", "'('", "')'", "'else'", "'for'", 
			"'in'", "'..'", "'*'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", 
			"'/'", "'+'", "'-'", "'++'", "'print'", "'function'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "STRING", "NUMBER", "ID", "BOOLEAN", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public PLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Expr expr;
		public StmtContext stmt;
		public TerminalNode EOF() { return getToken(PLParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			  List<Expr> list = new ArrayList<Expr>();
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				((ProgramContext)_localctx).stmt = stmt();
				list.add(((ProgramContext)_localctx).stmt.expr);
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1033896552L) != 0 );
			setState(34);
			match(EOF);
			((ProgramContext)_localctx).expr =  new Block(list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public Expr expr;
		public AssignContext assign;
		public BlockContext block;
		public IfElseStmtContext ifElseStmt;
		public ForLoopContext forLoop;
		public ExpressionsContext expressions;
		public PrintStmtContext printStmt;
		public DeclareContext declare;
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfElseStmtContext ifElseStmt() {
			return getRuleContext(IfElseStmtContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public DeclareContext declare() {
			return getRuleContext(DeclareContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		int _la;
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				((StmtContext)_localctx).assign = assign();
				 ((StmtContext)_localctx).expr =  ((StmtContext)_localctx).assign.expr; 
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(39);
					match(T__0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				((StmtContext)_localctx).block = block();
				 ((StmtContext)_localctx).expr =  ((StmtContext)_localctx).block.expr; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				((StmtContext)_localctx).ifElseStmt = ifElseStmt();
				 ((StmtContext)_localctx).expr =  ((StmtContext)_localctx).ifElseStmt.expr; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				((StmtContext)_localctx).forLoop = forLoop();
				 ((StmtContext)_localctx).expr =  ((StmtContext)_localctx).forLoop.expr; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				((StmtContext)_localctx).expressions = expressions(0);
				 ((StmtContext)_localctx).expr =  ((StmtContext)_localctx).expressions.expr; 
				setState(53);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(55);
				((StmtContext)_localctx).printStmt = printStmt();
				 ((StmtContext)_localctx).expr =  ((StmtContext)_localctx).printStmt.expr; 
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(57);
					match(T__0);
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(60);
				((StmtContext)_localctx).declare = declare();
				 ((StmtContext)_localctx).expr =  ((StmtContext)_localctx).declare.expr; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public Expr expr;
		public Token ID;
		public ExpressionsContext expressions;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			((AssignContext)_localctx).ID = match(ID);
			setState(66);
			match(T__1);
			setState(67);
			((AssignContext)_localctx).expressions = expressions(0);
			 ((AssignContext)_localctx).expr =  new Assign((((AssignContext)_localctx).ID!=null?((AssignContext)_localctx).ID.getText():null), ((AssignContext)_localctx).expressions.expr); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public Expr expr;
		public StmtContext stmt;
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			  List<Expr> list = new ArrayList<Expr>();
			setState(71);
			match(T__2);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1033896552L) != 0) {
				{
				{
				setState(72);
				((BlockContext)_localctx).stmt = stmt();
				list.add(((BlockContext)_localctx).stmt.expr);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(T__3);
			((BlockContext)_localctx).expr =  new Block(list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfElseStmtContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionsContext expressions;
		public BlockContext trueBlock;
		public BlockContext falseBlock;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStmt; }
	}

	public final IfElseStmtContext ifElseStmt() throws RecognitionException {
		IfElseStmtContext _localctx = new IfElseStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifElseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__4);
			setState(84);
			match(T__5);
			setState(85);
			((IfElseStmtContext)_localctx).expressions = expressions(0);
			setState(86);
			match(T__6);
			setState(87);
			((IfElseStmtContext)_localctx).trueBlock = block();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(88);
				match(T__7);
				setState(89);
				((IfElseStmtContext)_localctx).falseBlock = block();
				}
			}


			        Expr falseExpr = ((IfElseStmtContext)_localctx).falseBlock.expr!= null ? ((IfElseStmtContext)_localctx).falseBlock.expr: new NoneExpr();
			        ((IfElseStmtContext)_localctx).expr =  new Ifelse(((IfElseStmtContext)_localctx).expressions.expr, ((IfElseStmtContext)_localctx).trueBlock.expr, falseExpr);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public Expr expr;
		public Token ID;
		public ExpressionsContext startExpr;
		public ExpressionsContext endExpr;
		public BlockContext body;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public List<ExpressionsContext> expressions() {
			return getRuleContexts(ExpressionsContext.class);
		}
		public ExpressionsContext expressions(int i) {
			return getRuleContext(ExpressionsContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__8);
			setState(95);
			match(T__5);
			setState(96);
			((ForLoopContext)_localctx).ID = match(ID);
			setState(97);
			match(T__9);
			setState(98);
			((ForLoopContext)_localctx).startExpr = expressions(0);
			setState(99);
			match(T__10);
			setState(100);
			((ForLoopContext)_localctx).endExpr = expressions(0);
			setState(101);
			match(T__6);
			setState(102);
			((ForLoopContext)_localctx).body = block();

			        ((ForLoopContext)_localctx).expr =  new ForLoop((((ForLoopContext)_localctx).ID!=null?((ForLoopContext)_localctx).ID.getText():null), ((ForLoopContext)_localctx).startExpr.expr, ((ForLoopContext)_localctx).endExpr.expr, ((ForLoopContext)_localctx).body.expr);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public Expr expr;
		public ExpressionsContext left;
		public ExpressionsContext expressions;
		public FuntionCallContext funtionCall;
		public ValueContext value;
		public ExpressionsContext right;
		public List<ExpressionsContext> expressions() {
			return getRuleContexts(ExpressionsContext.class);
		}
		public ExpressionsContext expressions(int i) {
			return getRuleContext(ExpressionsContext.class,i);
		}
		public FuntionCallContext funtionCall() {
			return getRuleContext(FuntionCallContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		return expressions(0);
	}

	private ExpressionsContext expressions(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, _parentState);
		ExpressionsContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expressions, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(106);
				match(T__20);
				setState(107);
				((ExpressionsContext)_localctx).expressions = expressions(4);
				 ((ExpressionsContext)_localctx).expr =  new Arithmetics(Operator.Sub, new IntLiteral("0"), ((ExpressionsContext)_localctx).expressions.expr); 
				}
				break;
			case 2:
				{
				setState(110);
				match(T__5);
				setState(111);
				((ExpressionsContext)_localctx).expressions = expressions(0);
				setState(112);
				match(T__6);
				 ((ExpressionsContext)_localctx).expr =  ((ExpressionsContext)_localctx).expressions.expr; 
				}
				break;
			case 3:
				{
				setState(115);
				((ExpressionsContext)_localctx).funtionCall = funtionCall();
				 ((ExpressionsContext)_localctx).expr =  ((ExpressionsContext)_localctx).funtionCall.expr; 
				}
				break;
			case 4:
				{
				setState(118);
				((ExpressionsContext)_localctx).value = value();
				 ((ExpressionsContext)_localctx).expr =  ((ExpressionsContext)_localctx).value.expr; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(123);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(124);
						match(T__11);
						setState(125);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(16);
						 ((ExpressionsContext)_localctx).expr =  new Arithmetics(Operator.Mul, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(128);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(129);
						match(T__12);
						setState(130);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(15);
						 ((ExpressionsContext)_localctx).expr =  new Compare(Comparator.LT, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(133);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(134);
						match(T__13);
						setState(135);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(14);
						 ((ExpressionsContext)_localctx).expr =  new Compare(Comparator.LE, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(138);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(139);
						match(T__14);
						setState(140);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(13);
						 ((ExpressionsContext)_localctx).expr =  new Compare(Comparator.GT, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(143);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(144);
						match(T__15);
						setState(145);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(12);
						 ((ExpressionsContext)_localctx).expr =  new Compare(Comparator.GE, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(148);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(149);
						match(T__16);
						setState(150);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(11);
						 ((ExpressionsContext)_localctx).expr =  new Compare(Comparator.EQ, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 7:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(153);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(154);
						match(T__17);
						setState(155);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(10);
						 ((ExpressionsContext)_localctx).expr =  new Compare(Comparator.NE, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 8:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(158);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(159);
						match(T__18);
						setState(160);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(9);
						 ((ExpressionsContext)_localctx).expr =  new Arithmetics(Operator.Div, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 9:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(163);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(164);
						match(T__19);
						setState(165);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(8);
						 ((ExpressionsContext)_localctx).expr =  new Arithmetics(Operator.Add, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 10:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(168);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(169);
						match(T__20);
						setState(170);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(7);
						 ((ExpressionsContext)_localctx).expr =  new Arithmetics(Operator.Sub, ((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					case 11:
						{
						_localctx = new ExpressionsContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expressions);
						setState(173);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(174);
						match(T__21);
						setState(175);
						((ExpressionsContext)_localctx).right = ((ExpressionsContext)_localctx).expressions = expressions(6);
						 ((ExpressionsContext)_localctx).expr =  new Concatenation(((ExpressionsContext)_localctx).left.expr, ((ExpressionsContext)_localctx).right.expr); 
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends ParserRuleContext {
		public Expr expr;
		public ArgumentsListContext args;
		public ArgumentsListContext argumentsList() {
			return getRuleContext(ArgumentsListContext.class,0);
		}
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__22);
			setState(184);
			match(T__5);
			setState(185);
			((PrintStmtContext)_localctx).args = argumentsList();
			setState(186);
			match(T__6);
			 ((PrintStmtContext)_localctx).expr =  new Print(((PrintStmtContext)_localctx).args.list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareContext extends ParserRuleContext {
		public Expr expr;
		public Token ID;
		public ParametersListContext params;
		public BlockContext block;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersListContext parametersList() {
			return getRuleContext(ParametersListContext.class,0);
		}
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__23);
			setState(190);
			((DeclareContext)_localctx).ID = match(ID);
			setState(191);
			match(T__5);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(192);
				((DeclareContext)_localctx).params = parametersList();
				}
			}

			setState(195);
			match(T__6);
			setState(196);
			((DeclareContext)_localctx).block = block();

			        List<String> paramNames = ((DeclareContext)_localctx).params.list != null ? ((DeclareContext)_localctx).params.list : new ArrayList<>();
			        ((DeclareContext)_localctx).expr =  new Declare((((DeclareContext)_localctx).ID!=null?((DeclareContext)_localctx).ID.getText():null), paramNames, ((DeclareContext)_localctx).block.expr);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsListContext extends ParserRuleContext {
		public List<Expr> list;
		public ExpressionsContext expressions;
		public List<ExpressionsContext> expressions() {
			return getRuleContexts(ExpressionsContext.class);
		}
		public ExpressionsContext expressions(int i) {
			return getRuleContext(ExpressionsContext.class,i);
		}
		public ArgumentsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentsList; }
	}

	public final ArgumentsListContext argumentsList() throws RecognitionException {
		ArgumentsListContext _localctx = new ArgumentsListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_argumentsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentsListContext)_localctx).list =  new ArrayList<Expr>(); 
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1008730176L) != 0) {
				{
				setState(200);
				((ArgumentsListContext)_localctx).expressions = expressions(0);
				 _localctx.list.add(((ArgumentsListContext)_localctx).expressions.expr); 
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(202);
					match(T__24);
					setState(203);
					((ArgumentsListContext)_localctx).expressions = expressions(0);
					 _localctx.list.add(((ArgumentsListContext)_localctx).expressions.expr); 
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersListContext extends ParserRuleContext {
		public List<String> list;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(PLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PLParser.ID, i);
		}
		public ParametersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersList; }
	}

	public final ParametersListContext parametersList() throws RecognitionException {
		ParametersListContext _localctx = new ParametersListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parametersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParametersListContext)_localctx).list =  new ArrayList<String>(); 
			setState(214);
			((ParametersListContext)_localctx).ID = match(ID);
			 _localctx.list.add((((ParametersListContext)_localctx).ID!=null?((ParametersListContext)_localctx).ID.getText():null)); 
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(216);
				match(T__24);
				setState(217);
				((ParametersListContext)_localctx).ID = match(ID);
				 _localctx.list.add((((ParametersListContext)_localctx).ID!=null?((ParametersListContext)_localctx).ID.getText():null)); 
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuntionCallContext extends ParserRuleContext {
		public Expr expr;
		public Token ID;
		public ArgumentsListContext args;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ArgumentsListContext argumentsList() {
			return getRuleContext(ArgumentsListContext.class,0);
		}
		public FuntionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funtionCall; }
	}

	public final FuntionCallContext funtionCall() throws RecognitionException {
		FuntionCallContext _localctx = new FuntionCallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funtionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			((FuntionCallContext)_localctx).ID = match(ID);
			setState(225);
			match(T__5);
			setState(226);
			((FuntionCallContext)_localctx).args = argumentsList();
			setState(227);
			match(T__6);

			        List<Expr> arguments = ((FuntionCallContext)_localctx).args.list != null ? ((FuntionCallContext)_localctx).args.list : new ArrayList<>();
			        ((FuntionCallContext)_localctx).expr =  new Invoke((((FuntionCallContext)_localctx).ID!=null?((FuntionCallContext)_localctx).ID.getText():null), arguments);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public Expr expr;
		public Token STRING;
		public Token BOOLEAN;
		public Token ID;
		public Token NUMBER;
		public TerminalNode STRING() { return getToken(PLParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(PLParser.BOOLEAN, 0); }
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(PLParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_value);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				((ValueContext)_localctx).STRING = match(STRING);
				((ValueContext)_localctx).expr =  new StringLiteral((((ValueContext)_localctx).STRING!=null?((ValueContext)_localctx).STRING.getText():null).substring(1, (((ValueContext)_localctx).STRING!=null?((ValueContext)_localctx).STRING.getText():null).length() - 1));
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				((ValueContext)_localctx).BOOLEAN = match(BOOLEAN);
				 ((ValueContext)_localctx).expr =  new BooleanLiteral((((ValueContext)_localctx).BOOLEAN!=null?((ValueContext)_localctx).BOOLEAN.getText():null)); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				((ValueContext)_localctx).ID = match(ID);
				 ((ValueContext)_localctx).expr =  new Deref((((ValueContext)_localctx).ID!=null?((ValueContext)_localctx).ID.getText():null)); 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 4);
				{
				setState(236);
				((ValueContext)_localctx).NUMBER = match(NUMBER);
				 ((ValueContext)_localctx).expr =  new IntLiteral((((ValueContext)_localctx).NUMBER!=null?((ValueContext)_localctx).NUMBER.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expressions_sempred((ExpressionsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressions_sempred(ExpressionsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00f1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u001f\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001)\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001;\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001@\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003L\b\u0003\n\u0003\f\u0003O\t"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004[\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006z\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00b3\b\u0006\n\u0006\f\u0006"+
		"\u00b6\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00c2\b\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u00cf\b\t\n\t\f\t\u00d2\t\t\u0003\t\u00d4\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00dc\b\n\n\n\f\n\u00df"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u00ef\b\f\u0001\f\u0000\u0001\f\r\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0000\u0103\u0000\u001a\u0001"+
		"\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000\u0004A\u0001\u0000\u0000"+
		"\u0000\u0006F\u0001\u0000\u0000\u0000\bS\u0001\u0000\u0000\u0000\n^\u0001"+
		"\u0000\u0000\u0000\fy\u0001\u0000\u0000\u0000\u000e\u00b7\u0001\u0000"+
		"\u0000\u0000\u0010\u00bd\u0001\u0000\u0000\u0000\u0012\u00c7\u0001\u0000"+
		"\u0000\u0000\u0014\u00d5\u0001\u0000\u0000\u0000\u0016\u00e0\u0001\u0000"+
		"\u0000\u0000\u0018\u00ee\u0001\u0000\u0000\u0000\u001a\u001e\u0006\u0000"+
		"\uffff\uffff\u0000\u001b\u001c\u0003\u0002\u0001\u0000\u001c\u001d\u0006"+
		"\u0000\uffff\uffff\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u001b"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000 !\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005"+
		"\u0000\u0000\u0001#$\u0006\u0000\uffff\uffff\u0000$\u0001\u0001\u0000"+
		"\u0000\u0000%&\u0003\u0004\u0002\u0000&(\u0006\u0001\uffff\uffff\u0000"+
		"\')\u0005\u0001\u0000\u0000(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000"+
		"\u0000)@\u0001\u0000\u0000\u0000*+\u0003\u0006\u0003\u0000+,\u0006\u0001"+
		"\uffff\uffff\u0000,@\u0001\u0000\u0000\u0000-.\u0003\b\u0004\u0000./\u0006"+
		"\u0001\uffff\uffff\u0000/@\u0001\u0000\u0000\u000001\u0003\n\u0005\u0000"+
		"12\u0006\u0001\uffff\uffff\u00002@\u0001\u0000\u0000\u000034\u0003\f\u0006"+
		"\u000045\u0006\u0001\uffff\uffff\u000056\u0005\u0001\u0000\u00006@\u0001"+
		"\u0000\u0000\u000078\u0003\u000e\u0007\u00008:\u0006\u0001\uffff\uffff"+
		"\u00009;\u0005\u0001\u0000\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;@\u0001\u0000\u0000\u0000<=\u0003\u0010\b\u0000=>\u0006\u0001"+
		"\uffff\uffff\u0000>@\u0001\u0000\u0000\u0000?%\u0001\u0000\u0000\u0000"+
		"?*\u0001\u0000\u0000\u0000?-\u0001\u0000\u0000\u0000?0\u0001\u0000\u0000"+
		"\u0000?3\u0001\u0000\u0000\u0000?7\u0001\u0000\u0000\u0000?<\u0001\u0000"+
		"\u0000\u0000@\u0003\u0001\u0000\u0000\u0000AB\u0005\u001c\u0000\u0000"+
		"BC\u0005\u0002\u0000\u0000CD\u0003\f\u0006\u0000DE\u0006\u0002\uffff\uffff"+
		"\u0000E\u0005\u0001\u0000\u0000\u0000FG\u0006\u0003\uffff\uffff\u0000"+
		"GM\u0005\u0003\u0000\u0000HI\u0003\u0002\u0001\u0000IJ\u0006\u0003\uffff"+
		"\uffff\u0000JL\u0001\u0000\u0000\u0000KH\u0001\u0000\u0000\u0000LO\u0001"+
		"\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"NP\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0005\u0004\u0000"+
		"\u0000QR\u0006\u0003\uffff\uffff\u0000R\u0007\u0001\u0000\u0000\u0000"+
		"ST\u0005\u0005\u0000\u0000TU\u0005\u0006\u0000\u0000UV\u0003\f\u0006\u0000"+
		"VW\u0005\u0007\u0000\u0000WZ\u0003\u0006\u0003\u0000XY\u0005\b\u0000\u0000"+
		"Y[\u0003\u0006\u0003\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\]\u0006\u0004\uffff\uffff\u0000]\t"+
		"\u0001\u0000\u0000\u0000^_\u0005\t\u0000\u0000_`\u0005\u0006\u0000\u0000"+
		"`a\u0005\u001c\u0000\u0000ab\u0005\n\u0000\u0000bc\u0003\f\u0006\u0000"+
		"cd\u0005\u000b\u0000\u0000de\u0003\f\u0006\u0000ef\u0005\u0007\u0000\u0000"+
		"fg\u0003\u0006\u0003\u0000gh\u0006\u0005\uffff\uffff\u0000h\u000b\u0001"+
		"\u0000\u0000\u0000ij\u0006\u0006\uffff\uffff\u0000jk\u0005\u0015\u0000"+
		"\u0000kl\u0003\f\u0006\u0004lm\u0006\u0006\uffff\uffff\u0000mz\u0001\u0000"+
		"\u0000\u0000no\u0005\u0006\u0000\u0000op\u0003\f\u0006\u0000pq\u0005\u0007"+
		"\u0000\u0000qr\u0006\u0006\uffff\uffff\u0000rz\u0001\u0000\u0000\u0000"+
		"st\u0003\u0016\u000b\u0000tu\u0006\u0006\uffff\uffff\u0000uz\u0001\u0000"+
		"\u0000\u0000vw\u0003\u0018\f\u0000wx\u0006\u0006\uffff\uffff\u0000xz\u0001"+
		"\u0000\u0000\u0000yi\u0001\u0000\u0000\u0000yn\u0001\u0000\u0000\u0000"+
		"ys\u0001\u0000\u0000\u0000yv\u0001\u0000\u0000\u0000z\u00b4\u0001\u0000"+
		"\u0000\u0000{|\n\u000f\u0000\u0000|}\u0005\f\u0000\u0000}~\u0003\f\u0006"+
		"\u0010~\u007f\u0006\u0006\uffff\uffff\u0000\u007f\u00b3\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\n\u000e\u0000\u0000\u0081\u0082\u0005\r\u0000\u0000"+
		"\u0082\u0083\u0003\f\u0006\u000f\u0083\u0084\u0006\u0006\uffff\uffff\u0000"+
		"\u0084\u00b3\u0001\u0000\u0000\u0000\u0085\u0086\n\r\u0000\u0000\u0086"+
		"\u0087\u0005\u000e\u0000\u0000\u0087\u0088\u0003\f\u0006\u000e\u0088\u0089"+
		"\u0006\u0006\uffff\uffff\u0000\u0089\u00b3\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\n\f\u0000\u0000\u008b\u008c\u0005\u000f\u0000\u0000\u008c\u008d"+
		"\u0003\f\u0006\r\u008d\u008e\u0006\u0006\uffff\uffff\u0000\u008e\u00b3"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\n\u000b\u0000\u0000\u0090\u0091\u0005"+
		"\u0010\u0000\u0000\u0091\u0092\u0003\f\u0006\f\u0092\u0093\u0006\u0006"+
		"\uffff\uffff\u0000\u0093\u00b3\u0001\u0000\u0000\u0000\u0094\u0095\n\n"+
		"\u0000\u0000\u0095\u0096\u0005\u0011\u0000\u0000\u0096\u0097\u0003\f\u0006"+
		"\u000b\u0097\u0098\u0006\u0006\uffff\uffff\u0000\u0098\u00b3\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\n\t\u0000\u0000\u009a\u009b\u0005\u0012\u0000"+
		"\u0000\u009b\u009c\u0003\f\u0006\n\u009c\u009d\u0006\u0006\uffff\uffff"+
		"\u0000\u009d\u00b3\u0001\u0000\u0000\u0000\u009e\u009f\n\b\u0000\u0000"+
		"\u009f\u00a0\u0005\u0013\u0000\u0000\u00a0\u00a1\u0003\f\u0006\t\u00a1"+
		"\u00a2\u0006\u0006\uffff\uffff\u0000\u00a2\u00b3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\n\u0007\u0000\u0000\u00a4\u00a5\u0005\u0014\u0000\u0000\u00a5"+
		"\u00a6\u0003\f\u0006\b\u00a6\u00a7\u0006\u0006\uffff\uffff\u0000\u00a7"+
		"\u00b3\u0001\u0000\u0000\u0000\u00a8\u00a9\n\u0006\u0000\u0000\u00a9\u00aa"+
		"\u0005\u0015\u0000\u0000\u00aa\u00ab\u0003\f\u0006\u0007\u00ab\u00ac\u0006"+
		"\u0006\uffff\uffff\u0000\u00ac\u00b3\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\n\u0005\u0000\u0000\u00ae\u00af\u0005\u0016\u0000\u0000\u00af\u00b0\u0003"+
		"\f\u0006\u0006\u00b0\u00b1\u0006\u0006\uffff\uffff\u0000\u00b1\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b2{\u0001\u0000\u0000\u0000\u00b2\u0080\u0001\u0000"+
		"\u0000\u0000\u00b2\u0085\u0001\u0000\u0000\u0000\u00b2\u008a\u0001\u0000"+
		"\u0000\u0000\u00b2\u008f\u0001\u0000\u0000\u0000\u00b2\u0094\u0001\u0000"+
		"\u0000\u0000\u00b2\u0099\u0001\u0000\u0000\u0000\u00b2\u009e\u0001\u0000"+
		"\u0000\u0000\u00b2\u00a3\u0001\u0000\u0000\u0000\u00b2\u00a8\u0001\u0000"+
		"\u0000\u0000\u00b2\u00ad\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\r\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0005\u0017\u0000\u0000\u00b8\u00b9\u0005\u0006\u0000"+
		"\u0000\u00b9\u00ba\u0003\u0012\t\u0000\u00ba\u00bb\u0005\u0007\u0000\u0000"+
		"\u00bb\u00bc\u0006\u0007\uffff\uffff\u0000\u00bc\u000f\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0005\u0018\u0000\u0000\u00be\u00bf\u0005\u001c\u0000"+
		"\u0000\u00bf\u00c1\u0005\u0006\u0000\u0000\u00c0\u00c2\u0003\u0014\n\u0000"+
		"\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u0007\u0000\u0000"+
		"\u00c4\u00c5\u0003\u0006\u0003\u0000\u00c5\u00c6\u0006\b\uffff\uffff\u0000"+
		"\u00c6\u0011\u0001\u0000\u0000\u0000\u00c7\u00d3\u0006\t\uffff\uffff\u0000"+
		"\u00c8\u00c9\u0003\f\u0006\u0000\u00c9\u00d0\u0006\t\uffff\uffff\u0000"+
		"\u00ca\u00cb\u0005\u0019\u0000\u0000\u00cb\u00cc\u0003\f\u0006\u0000\u00cc"+
		"\u00cd\u0006\t\uffff\uffff\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3"+
		"\u00c8\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4"+
		"\u0013\u0001\u0000\u0000\u0000\u00d5\u00d6\u0006\n\uffff\uffff\u0000\u00d6"+
		"\u00d7\u0005\u001c\u0000\u0000\u00d7\u00dd\u0006\n\uffff\uffff\u0000\u00d8"+
		"\u00d9\u0005\u0019\u0000\u0000\u00d9\u00da\u0005\u001c\u0000\u0000\u00da"+
		"\u00dc\u0006\n\uffff\uffff\u0000\u00db\u00d8\u0001\u0000\u0000\u0000\u00dc"+
		"\u00df\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0001\u0000\u0000\u0000\u00de\u0015\u0001\u0000\u0000\u0000\u00df"+
		"\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u001c\u0000\u0000\u00e1"+
		"\u00e2\u0005\u0006\u0000\u0000\u00e2\u00e3\u0003\u0012\t\u0000\u00e3\u00e4"+
		"\u0005\u0007\u0000\u0000\u00e4\u00e5\u0006\u000b\uffff\uffff\u0000\u00e5"+
		"\u0017\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\u001a\u0000\u0000\u00e7"+
		"\u00ef\u0006\f\uffff\uffff\u0000\u00e8\u00e9\u0005\u001d\u0000\u0000\u00e9"+
		"\u00ef\u0006\f\uffff\uffff\u0000\u00ea\u00eb\u0005\u001c\u0000\u0000\u00eb"+
		"\u00ef\u0006\f\uffff\uffff\u0000\u00ec\u00ed\u0005\u001b\u0000\u0000\u00ed"+
		"\u00ef\u0006\f\uffff\uffff\u0000\u00ee\u00e6\u0001\u0000\u0000\u0000\u00ee"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ee\u00ea\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ef\u0019\u0001\u0000\u0000\u0000\u000e"+
		" (:?MZy\u00b2\u00b4\u00c1\u00d0\u00d3\u00dd\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}