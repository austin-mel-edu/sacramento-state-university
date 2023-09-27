// Generated from morsecode.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class morsecodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, DASH=2, SPACE=3, WS=4;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "'-'", "' '", "WS"
	};
	public static final int
		RULE_morsecode = 0, RULE_letter = 1, RULE_a = 2, RULE_b = 3, RULE_c = 4, 
		RULE_d = 5, RULE_e = 6, RULE_f = 7, RULE_g = 8, RULE_h = 9, RULE_i = 10, 
		RULE_j = 11, RULE_k = 12, RULE_l = 13, RULE_m = 14, RULE_n = 15, RULE_o = 16, 
		RULE_p = 17, RULE_q = 18, RULE_r = 19, RULE_s = 20, RULE_t = 21, RULE_u = 22, 
		RULE_v = 23, RULE_w = 24, RULE_x = 25, RULE_y = 26, RULE_z = 27, RULE_one = 28, 
		RULE_two = 29, RULE_three = 30, RULE_four = 31, RULE_five = 32, RULE_six = 33, 
		RULE_seven = 34, RULE_eight = 35, RULE_nine = 36, RULE_zero = 37;
	public static final String[] ruleNames = {
		"morsecode", "letter", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
		"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", 
		"y", "z", "one", "two", "three", "four", "five", "six", "seven", "eight", 
		"nine", "zero"
	};

	@Override
	public String getGrammarFileName() { return "morsecode.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public morsecodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MorsecodeContext extends ParserRuleContext {
		public LetterContext letter(int i) {
			return getRuleContext(LetterContext.class,i);
		}
		public TerminalNode EOF() { return getToken(morsecodeParser.EOF, 0); }
		public TerminalNode SPACE(int i) {
			return getToken(morsecodeParser.SPACE, i);
		}
		public List<LetterContext> letter() {
			return getRuleContexts(LetterContext.class);
		}
		public List<TerminalNode> SPACE() { return getTokens(morsecodeParser.SPACE); }
		public MorsecodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_morsecode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterMorsecode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitMorsecode(this);
		}
	}

	public final MorsecodeContext morsecode() throws RecognitionException {
		MorsecodeContext _localctx = new MorsecodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_morsecode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); letter();
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77); match(SPACE);
				setState(78); letter();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SPACE );
			setState(83); match(EOF);
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

	public static class LetterContext extends ParserRuleContext {
		public OContext o() {
			return getRuleContext(OContext.class,0);
		}
		public OneContext one() {
			return getRuleContext(OneContext.class,0);
		}
		public FourContext four() {
			return getRuleContext(FourContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public ThreeContext three() {
			return getRuleContext(ThreeContext.class,0);
		}
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public LContext l() {
			return getRuleContext(LContext.class,0);
		}
		public IContext i() {
			return getRuleContext(IContext.class,0);
		}
		public EightContext eight() {
			return getRuleContext(EightContext.class,0);
		}
		public ZContext z() {
			return getRuleContext(ZContext.class,0);
		}
		public JContext j() {
			return getRuleContext(JContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public GContext g() {
			return getRuleContext(GContext.class,0);
		}
		public KContext k() {
			return getRuleContext(KContext.class,0);
		}
		public TwoContext two() {
			return getRuleContext(TwoContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public FiveContext five() {
			return getRuleContext(FiveContext.class,0);
		}
		public UContext u() {
			return getRuleContext(UContext.class,0);
		}
		public QContext q() {
			return getRuleContext(QContext.class,0);
		}
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public DContext d() {
			return getRuleContext(DContext.class,0);
		}
		public RContext r() {
			return getRuleContext(RContext.class,0);
		}
		public SixContext six() {
			return getRuleContext(SixContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public HContext h() {
			return getRuleContext(HContext.class,0);
		}
		public ZeroContext zero() {
			return getRuleContext(ZeroContext.class,0);
		}
		public WContext w() {
			return getRuleContext(WContext.class,0);
		}
		public PContext p() {
			return getRuleContext(PContext.class,0);
		}
		public SevenContext seven() {
			return getRuleContext(SevenContext.class,0);
		}
		public MContext m() {
			return getRuleContext(MContext.class,0);
		}
		public VContext v() {
			return getRuleContext(VContext.class,0);
		}
		public NContext n() {
			return getRuleContext(NContext.class,0);
		}
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public NineContext nine() {
			return getRuleContext(NineContext.class,0);
		}
		public LetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterLetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitLetter(this);
		}
	}

	public final LetterContext letter() throws RecognitionException {
		LetterContext _localctx = new LetterContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_letter);
		try {
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85); a();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86); b();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87); c();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(88); d();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(89); e();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(90); f();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(91); g();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(92); h();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(93); i();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(94); j();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(95); k();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(96); l();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(97); m();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(98); n();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(99); o();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(100); p();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(101); q();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(102); r();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(103); s();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(104); t();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(105); u();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(106); v();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(107); w();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(108); x();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(109); y();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(110); z();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(111); one();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(112); two();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(113); three();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(114); four();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(115); five();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(116); six();
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(117); seven();
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(118); eight();
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(119); nine();
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(120); zero();
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

	public static class AContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitA(this);
		}
	}

	public final AContext a() throws RecognitionException {
		AContext _localctx = new AContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_a);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(DOT);
			setState(124); match(DASH);
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

	public static class BContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public BContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitB(this);
		}
	}

	public final BContext b() throws RecognitionException {
		BContext _localctx = new BContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_b);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(DASH);
			setState(127); match(DOT);
			setState(128); match(DOT);
			setState(129); match(DOT);
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

	public static class CContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitC(this);
		}
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(DASH);
			setState(132); match(DOT);
			setState(133); match(DASH);
			setState(134); match(DOT);
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

	public static class DContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public DContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_d; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitD(this);
		}
	}

	public final DContext d() throws RecognitionException {
		DContext _localctx = new DContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_d);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); match(DASH);
			setState(137); match(DOT);
			setState(138); match(DOT);
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

	public static class EContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitE(this);
		}
	}

	public final EContext e() throws RecognitionException {
		EContext _localctx = new EContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_e);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); match(DOT);
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

	public static class FContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitF(this);
		}
	}

	public final FContext f() throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_f);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(DOT);
			setState(143); match(DOT);
			setState(144); match(DASH);
			setState(145); match(DOT);
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

	public static class GContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public GContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterG(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitG(this);
		}
	}

	public final GContext g() throws RecognitionException {
		GContext _localctx = new GContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_g);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(DASH);
			setState(148); match(DASH);
			setState(149); match(DOT);
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

	public static class HContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public HContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_h; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterH(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitH(this);
		}
	}

	public final HContext h() throws RecognitionException {
		HContext _localctx = new HContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_h);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(DOT);
			setState(152); match(DOT);
			setState(153); match(DOT);
			setState(154); match(DOT);
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

	public static class IContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public IContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_i; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitI(this);
		}
	}

	public final IContext i() throws RecognitionException {
		IContext _localctx = new IContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_i);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(DOT);
			setState(157); match(DOT);
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

	public static class JContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public JContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_j; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterJ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitJ(this);
		}
	}

	public final JContext j() throws RecognitionException {
		JContext _localctx = new JContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_j);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(DOT);
			setState(160); match(DASH);
			setState(161); match(DASH);
			setState(162); match(DASH);
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

	public static class KContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public KContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_k; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterK(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitK(this);
		}
	}

	public final KContext k() throws RecognitionException {
		KContext _localctx = new KContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_k);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); match(DASH);
			setState(165); match(DOT);
			setState(166); match(DASH);
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

	public static class LContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public LContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_l; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitL(this);
		}
	}

	public final LContext l() throws RecognitionException {
		LContext _localctx = new LContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_l);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(DOT);
			setState(169); match(DASH);
			setState(170); match(DOT);
			setState(171); match(DOT);
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

	public static class MContext extends ParserRuleContext {
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public MContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_m; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitM(this);
		}
	}

	public final MContext m() throws RecognitionException {
		MContext _localctx = new MContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_m);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(DASH);
			setState(174); match(DASH);
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

	public static class NContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public NContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitN(this);
		}
	}

	public final NContext n() throws RecognitionException {
		NContext _localctx = new NContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_n);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(DASH);
			setState(177); match(DOT);
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

	public static class OContext extends ParserRuleContext {
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public OContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_o; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterO(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitO(this);
		}
	}

	public final OContext o() throws RecognitionException {
		OContext _localctx = new OContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_o);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(DASH);
			setState(180); match(DASH);
			setState(181); match(DASH);
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

	public static class PContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public PContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitP(this);
		}
	}

	public final PContext p() throws RecognitionException {
		PContext _localctx = new PContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); match(DOT);
			setState(184); match(DASH);
			setState(185); match(DASH);
			setState(186); match(DOT);
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

	public static class QContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public QContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_q; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitQ(this);
		}
	}

	public final QContext q() throws RecognitionException {
		QContext _localctx = new QContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_q);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); match(DASH);
			setState(189); match(DASH);
			setState(190); match(DOT);
			setState(191); match(DASH);
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

	public static class RContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193); match(DOT);
			setState(194); match(DASH);
			setState(195); match(DOT);
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

	public static class SContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitS(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(DOT);
			setState(198); match(DOT);
			setState(199); match(DOT);
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

	public static class TContext extends ParserRuleContext {
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitT(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_t);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); match(DASH);
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

	public static class UContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public UContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_u; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterU(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitU(this);
		}
	}

	public final UContext u() throws RecognitionException {
		UContext _localctx = new UContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_u);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(DOT);
			setState(204); match(DOT);
			setState(205); match(DASH);
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

	public static class VContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public VContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_v; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterV(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitV(this);
		}
	}

	public final VContext v() throws RecognitionException {
		VContext _localctx = new VContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_v);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(DOT);
			setState(208); match(DOT);
			setState(209); match(DOT);
			setState(210); match(DASH);
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

	public static class WContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public WContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_w; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitW(this);
		}
	}

	public final WContext w() throws RecognitionException {
		WContext _localctx = new WContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_w);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); match(DOT);
			setState(213); match(DASH);
			setState(214); match(DASH);
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

	public static class XContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public XContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitX(this);
		}
	}

	public final XContext x() throws RecognitionException {
		XContext _localctx = new XContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(DASH);
			setState(217); match(DOT);
			setState(218); match(DOT);
			setState(219); match(DASH);
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

	public static class YContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public YContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitY(this);
		}
	}

	public final YContext y() throws RecognitionException {
		YContext _localctx = new YContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_y);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221); match(DASH);
			setState(222); match(DOT);
			setState(223); match(DASH);
			setState(224); match(DASH);
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

	public static class ZContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public ZContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_z; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterZ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitZ(this);
		}
	}

	public final ZContext z() throws RecognitionException {
		ZContext _localctx = new ZContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_z);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(DASH);
			setState(227); match(DASH);
			setState(228); match(DOT);
			setState(229); match(DOT);
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

	public static class OneContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public OneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitOne(this);
		}
	}

	public final OneContext one() throws RecognitionException {
		OneContext _localctx = new OneContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_one);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(DOT);
			setState(232); match(DASH);
			setState(233); match(DASH);
			setState(234); match(DASH);
			setState(235); match(DASH);
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

	public static class TwoContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public TwoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_two; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterTwo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitTwo(this);
		}
	}

	public final TwoContext two() throws RecognitionException {
		TwoContext _localctx = new TwoContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_two);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(DOT);
			setState(238); match(DOT);
			setState(239); match(DASH);
			setState(240); match(DASH);
			setState(241); match(DASH);
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

	public static class ThreeContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public ThreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_three; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterThree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitThree(this);
		}
	}

	public final ThreeContext three() throws RecognitionException {
		ThreeContext _localctx = new ThreeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_three);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(DOT);
			setState(244); match(DOT);
			setState(245); match(DOT);
			setState(246); match(DASH);
			setState(247); match(DASH);
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

	public static class FourContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public FourContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_four; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterFour(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitFour(this);
		}
	}

	public final FourContext four() throws RecognitionException {
		FourContext _localctx = new FourContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_four);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249); match(DOT);
			setState(250); match(DOT);
			setState(251); match(DOT);
			setState(252); match(DOT);
			setState(253); match(DASH);
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

	public static class FiveContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public FiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_five; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterFive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitFive(this);
		}
	}

	public final FiveContext five() throws RecognitionException {
		FiveContext _localctx = new FiveContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_five);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255); match(DOT);
			setState(256); match(DOT);
			setState(257); match(DOT);
			setState(258); match(DOT);
			setState(259); match(DOT);
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

	public static class SixContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public TerminalNode DASH() { return getToken(morsecodeParser.DASH, 0); }
		public SixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_six; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterSix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitSix(this);
		}
	}

	public final SixContext six() throws RecognitionException {
		SixContext _localctx = new SixContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_six);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261); match(DASH);
			setState(262); match(DOT);
			setState(263); match(DOT);
			setState(264); match(DOT);
			setState(265); match(DOT);
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

	public static class SevenContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public SevenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seven; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterSeven(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitSeven(this);
		}
	}

	public final SevenContext seven() throws RecognitionException {
		SevenContext _localctx = new SevenContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_seven);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(DASH);
			setState(268); match(DASH);
			setState(269); match(DOT);
			setState(270); match(DOT);
			setState(271); match(DOT);
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

	public static class EightContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(morsecodeParser.DOT); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(morsecodeParser.DOT, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public EightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterEight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitEight(this);
		}
	}

	public final EightContext eight() throws RecognitionException {
		EightContext _localctx = new EightContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_eight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); match(DASH);
			setState(274); match(DASH);
			setState(275); match(DASH);
			setState(276); match(DOT);
			setState(277); match(DOT);
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

	public static class NineContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(morsecodeParser.DOT, 0); }
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public NineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterNine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitNine(this);
		}
	}

	public final NineContext nine() throws RecognitionException {
		NineContext _localctx = new NineContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_nine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279); match(DASH);
			setState(280); match(DASH);
			setState(281); match(DASH);
			setState(282); match(DASH);
			setState(283); match(DOT);
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

	public static class ZeroContext extends ParserRuleContext {
		public TerminalNode DASH(int i) {
			return getToken(morsecodeParser.DASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(morsecodeParser.DASH); }
		public ZeroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zero; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).enterZero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof morsecodeListener ) ((morsecodeListener)listener).exitZero(this);
		}
	}

	public final ZeroContext zero() throws RecognitionException {
		ZeroContext _localctx = new ZeroContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_zero);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(DASH);
			setState(286); match(DASH);
			setState(287); match(DASH);
			setState(288); match(DASH);
			setState(289); match(DASH);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\6\u0126\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\6\2R\n\2\r\2\16"+
		"\2S\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3|\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3"+
		"%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\2\2(\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL\2\2\u0123\2N"+
		"\3\2\2\2\4{\3\2\2\2\6}\3\2\2\2\b\u0080\3\2\2\2\n\u0085\3\2\2\2\f\u008a"+
		"\3\2\2\2\16\u008e\3\2\2\2\20\u0090\3\2\2\2\22\u0095\3\2\2\2\24\u0099\3"+
		"\2\2\2\26\u009e\3\2\2\2\30\u00a1\3\2\2\2\32\u00a6\3\2\2\2\34\u00aa\3\2"+
		"\2\2\36\u00af\3\2\2\2 \u00b2\3\2\2\2\"\u00b5\3\2\2\2$\u00b9\3\2\2\2&\u00be"+
		"\3\2\2\2(\u00c3\3\2\2\2*\u00c7\3\2\2\2,\u00cb\3\2\2\2.\u00cd\3\2\2\2\60"+
		"\u00d1\3\2\2\2\62\u00d6\3\2\2\2\64\u00da\3\2\2\2\66\u00df\3\2\2\28\u00e4"+
		"\3\2\2\2:\u00e9\3\2\2\2<\u00ef\3\2\2\2>\u00f5\3\2\2\2@\u00fb\3\2\2\2B"+
		"\u0101\3\2\2\2D\u0107\3\2\2\2F\u010d\3\2\2\2H\u0113\3\2\2\2J\u0119\3\2"+
		"\2\2L\u011f\3\2\2\2NQ\5\4\3\2OP\7\5\2\2PR\5\4\3\2QO\3\2\2\2RS\3\2\2\2"+
		"SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7\2\2\3V\3\3\2\2\2W|\5\6\4\2X|\5\b\5"+
		"\2Y|\5\n\6\2Z|\5\f\7\2[|\5\16\b\2\\|\5\20\t\2]|\5\22\n\2^|\5\24\13\2_"+
		"|\5\26\f\2`|\5\30\r\2a|\5\32\16\2b|\5\34\17\2c|\5\36\20\2d|\5 \21\2e|"+
		"\5\"\22\2f|\5$\23\2g|\5&\24\2h|\5(\25\2i|\5*\26\2j|\5,\27\2k|\5.\30\2"+
		"l|\5\60\31\2m|\5\62\32\2n|\5\64\33\2o|\5\66\34\2p|\58\35\2q|\5:\36\2r"+
		"|\5<\37\2s|\5> \2t|\5@!\2u|\5B\"\2v|\5D#\2w|\5F$\2x|\5H%\2y|\5J&\2z|\5"+
		"L\'\2{W\3\2\2\2{X\3\2\2\2{Y\3\2\2\2{Z\3\2\2\2{[\3\2\2\2{\\\3\2\2\2{]\3"+
		"\2\2\2{^\3\2\2\2{_\3\2\2\2{`\3\2\2\2{a\3\2\2\2{b\3\2\2\2{c\3\2\2\2{d\3"+
		"\2\2\2{e\3\2\2\2{f\3\2\2\2{g\3\2\2\2{h\3\2\2\2{i\3\2\2\2{j\3\2\2\2{k\3"+
		"\2\2\2{l\3\2\2\2{m\3\2\2\2{n\3\2\2\2{o\3\2\2\2{p\3\2\2\2{q\3\2\2\2{r\3"+
		"\2\2\2{s\3\2\2\2{t\3\2\2\2{u\3\2\2\2{v\3\2\2\2{w\3\2\2\2{x\3\2\2\2{y\3"+
		"\2\2\2{z\3\2\2\2|\5\3\2\2\2}~\7\3\2\2~\177\7\4\2\2\177\7\3\2\2\2\u0080"+
		"\u0081\7\4\2\2\u0081\u0082\7\3\2\2\u0082\u0083\7\3\2\2\u0083\u0084\7\3"+
		"\2\2\u0084\t\3\2\2\2\u0085\u0086\7\4\2\2\u0086\u0087\7\3\2\2\u0087\u0088"+
		"\7\4\2\2\u0088\u0089\7\3\2\2\u0089\13\3\2\2\2\u008a\u008b\7\4\2\2\u008b"+
		"\u008c\7\3\2\2\u008c\u008d\7\3\2\2\u008d\r\3\2\2\2\u008e\u008f\7\3\2\2"+
		"\u008f\17\3\2\2\2\u0090\u0091\7\3\2\2\u0091\u0092\7\3\2\2\u0092\u0093"+
		"\7\4\2\2\u0093\u0094\7\3\2\2\u0094\21\3\2\2\2\u0095\u0096\7\4\2\2\u0096"+
		"\u0097\7\4\2\2\u0097\u0098\7\3\2\2\u0098\23\3\2\2\2\u0099\u009a\7\3\2"+
		"\2\u009a\u009b\7\3\2\2\u009b\u009c\7\3\2\2\u009c\u009d\7\3\2\2\u009d\25"+
		"\3\2\2\2\u009e\u009f\7\3\2\2\u009f\u00a0\7\3\2\2\u00a0\27\3\2\2\2\u00a1"+
		"\u00a2\7\3\2\2\u00a2\u00a3\7\4\2\2\u00a3\u00a4\7\4\2\2\u00a4\u00a5\7\4"+
		"\2\2\u00a5\31\3\2\2\2\u00a6\u00a7\7\4\2\2\u00a7\u00a8\7\3\2\2\u00a8\u00a9"+
		"\7\4\2\2\u00a9\33\3\2\2\2\u00aa\u00ab\7\3\2\2\u00ab\u00ac\7\4\2\2\u00ac"+
		"\u00ad\7\3\2\2\u00ad\u00ae\7\3\2\2\u00ae\35\3\2\2\2\u00af\u00b0\7\4\2"+
		"\2\u00b0\u00b1\7\4\2\2\u00b1\37\3\2\2\2\u00b2\u00b3\7\4\2\2\u00b3\u00b4"+
		"\7\3\2\2\u00b4!\3\2\2\2\u00b5\u00b6\7\4\2\2\u00b6\u00b7\7\4\2\2\u00b7"+
		"\u00b8\7\4\2\2\u00b8#\3\2\2\2\u00b9\u00ba\7\3\2\2\u00ba\u00bb\7\4\2\2"+
		"\u00bb\u00bc\7\4\2\2\u00bc\u00bd\7\3\2\2\u00bd%\3\2\2\2\u00be\u00bf\7"+
		"\4\2\2\u00bf\u00c0\7\4\2\2\u00c0\u00c1\7\3\2\2\u00c1\u00c2\7\4\2\2\u00c2"+
		"\'\3\2\2\2\u00c3\u00c4\7\3\2\2\u00c4\u00c5\7\4\2\2\u00c5\u00c6\7\3\2\2"+
		"\u00c6)\3\2\2\2\u00c7\u00c8\7\3\2\2\u00c8\u00c9\7\3\2\2\u00c9\u00ca\7"+
		"\3\2\2\u00ca+\3\2\2\2\u00cb\u00cc\7\4\2\2\u00cc-\3\2\2\2\u00cd\u00ce\7"+
		"\3\2\2\u00ce\u00cf\7\3\2\2\u00cf\u00d0\7\4\2\2\u00d0/\3\2\2\2\u00d1\u00d2"+
		"\7\3\2\2\u00d2\u00d3\7\3\2\2\u00d3\u00d4\7\3\2\2\u00d4\u00d5\7\4\2\2\u00d5"+
		"\61\3\2\2\2\u00d6\u00d7\7\3\2\2\u00d7\u00d8\7\4\2\2\u00d8\u00d9\7\4\2"+
		"\2\u00d9\63\3\2\2\2\u00da\u00db\7\4\2\2\u00db\u00dc\7\3\2\2\u00dc\u00dd"+
		"\7\3\2\2\u00dd\u00de\7\4\2\2\u00de\65\3\2\2\2\u00df\u00e0\7\4\2\2\u00e0"+
		"\u00e1\7\3\2\2\u00e1\u00e2\7\4\2\2\u00e2\u00e3\7\4\2\2\u00e3\67\3\2\2"+
		"\2\u00e4\u00e5\7\4\2\2\u00e5\u00e6\7\4\2\2\u00e6\u00e7\7\3\2\2\u00e7\u00e8"+
		"\7\3\2\2\u00e89\3\2\2\2\u00e9\u00ea\7\3\2\2\u00ea\u00eb\7\4\2\2\u00eb"+
		"\u00ec\7\4\2\2\u00ec\u00ed\7\4\2\2\u00ed\u00ee\7\4\2\2\u00ee;\3\2\2\2"+
		"\u00ef\u00f0\7\3\2\2\u00f0\u00f1\7\3\2\2\u00f1\u00f2\7\4\2\2\u00f2\u00f3"+
		"\7\4\2\2\u00f3\u00f4\7\4\2\2\u00f4=\3\2\2\2\u00f5\u00f6\7\3\2\2\u00f6"+
		"\u00f7\7\3\2\2\u00f7\u00f8\7\3\2\2\u00f8\u00f9\7\4\2\2\u00f9\u00fa\7\4"+
		"\2\2\u00fa?\3\2\2\2\u00fb\u00fc\7\3\2\2\u00fc\u00fd\7\3\2\2\u00fd\u00fe"+
		"\7\3\2\2\u00fe\u00ff\7\3\2\2\u00ff\u0100\7\4\2\2\u0100A\3\2\2\2\u0101"+
		"\u0102\7\3\2\2\u0102\u0103\7\3\2\2\u0103\u0104\7\3\2\2\u0104\u0105\7\3"+
		"\2\2\u0105\u0106\7\3\2\2\u0106C\3\2\2\2\u0107\u0108\7\4\2\2\u0108\u0109"+
		"\7\3\2\2\u0109\u010a\7\3\2\2\u010a\u010b\7\3\2\2\u010b\u010c\7\3\2\2\u010c"+
		"E\3\2\2\2\u010d\u010e\7\4\2\2\u010e\u010f\7\4\2\2\u010f\u0110\7\3\2\2"+
		"\u0110\u0111\7\3\2\2\u0111\u0112\7\3\2\2\u0112G\3\2\2\2\u0113\u0114\7"+
		"\4\2\2\u0114\u0115\7\4\2\2\u0115\u0116\7\4\2\2\u0116\u0117\7\3\2\2\u0117"+
		"\u0118\7\3\2\2\u0118I\3\2\2\2\u0119\u011a\7\4\2\2\u011a\u011b\7\4\2\2"+
		"\u011b\u011c\7\4\2\2\u011c\u011d\7\4\2\2\u011d\u011e\7\3\2\2\u011eK\3"+
		"\2\2\2\u011f\u0120\7\4\2\2\u0120\u0121\7\4\2\2\u0121\u0122\7\4\2\2\u0122"+
		"\u0123\7\4\2\2\u0123\u0124\7\4\2\2\u0124M\3\2\2\2\4S{";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}