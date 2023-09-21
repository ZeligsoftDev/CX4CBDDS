// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/org/eclipse/internal/xpand2/parser/Xpand.g 2015-11-18 22:36:06

package org.eclipse.internal.xpand2.parser;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

@SuppressWarnings("all")
public class XpandLexer extends Lexer {
    public static final int T__50 = 50;
    public static final int TEXT = 6;
    public static final int T__59 = 59;
    public static final int T__55 = 55;
    public static final int T__56 = 56;
    public static final int T__57 = 57;
    public static final int T__58 = 58;
    public static final int T__51 = 51;
    public static final int T__52 = 52;
    public static final int T__53 = 53;
    public static final int T__54 = 54;
    public static final int T__60 = 60;
    public static final int T__61 = 61;
    public static final int HexDigit = 13;
    public static final int Letter = 14;
    public static final int LINE_COMMENT = 18;
    public static final int StringLiteral = 7;
    public static final int RG = 19;
    public static final int T__66 = 66;
    public static final int T__67 = 67;
    public static final int T__68 = 68;
    public static final int T__69 = 69;
    public static final int T__62 = 62;
    public static final int OctalEscape = 12;
    public static final int JavaIDDigit = 15;
    public static final int T__63 = 63;
    public static final int T__64 = 64;
    public static final int T__65 = 65;
    public static final int COMMENT = 5;
    public static final int T__37 = 37;
    public static final int T__38 = 38;
    public static final int T__39 = 39;
    public static final int T__33 = 33;
    public static final int T__34 = 34;
    public static final int T__35 = 35;
    public static final int T__36 = 36;
    public static final int UnicodeEscape = 11;
    public static final int T__30 = 30;
    public static final int T__31 = 31;
    public static final int T__32 = 32;
    public static final int T__48 = 48;
    public static final int T__49 = 49;
    public static final int T__44 = 44;
    public static final int T__45 = 45;
    public static final int T__46 = 46;
    public static final int T__47 = 47;
    public static final int LG = 4;
    public static final int T__40 = 40;
    public static final int T__41 = 41;
    public static final int T__42 = 42;
    public static final int T__43 = 43;
    public static final int T__91 = 91;
    public static final int T__100 = 100;
    public static final int T__92 = 92;
    public static final int T__93 = 93;
    public static final int T__94 = 94;
    public static final int T__90 = 90;
    public static final int Identifier = 9;
    public static final int T__99 = 99;
    public static final int IntLiteral = 8;
    public static final int T__95 = 95;
    public static final int T__96 = 96;
    public static final int T__97 = 97;
    public static final int T__98 = 98;
    public static final int T__26 = 26;
    public static final int T__27 = 27;
    public static final int T__28 = 28;
    public static final int T__29 = 29;
    public static final int T__22 = 22;
    public static final int T__23 = 23;
    public static final int T__24 = 24;
    public static final int T__25 = 25;
    public static final int T__20 = 20;
    public static final int T__21 = 21;
    public static final int T__70 = 70;
    public static final int T__71 = 71;
    public static final int T__72 = 72;
    public static final int T__77 = 77;
    public static final int T__78 = 78;
    public static final int T__79 = 79;
    public static final int T__73 = 73;
    public static final int WS = 16;
    public static final int EOF = -1;
    public static final int T__74 = 74;
    public static final int T__75 = 75;
    public static final int T__76 = 76;
    public static final int T__80 = 80;
    public static final int T__81 = 81;
    public static final int T__82 = 82;
    public static final int T__83 = 83;
    public static final int EscapeSequence = 10;
    public static final int ML_COMMENT = 17;
    public static final int T__88 = 88;
    public static final int T__89 = 89;
    public static final int T__84 = 84;
    public static final int T__85 = 85;
    public static final int T__86 = 86;
    public static final int T__87 = 87;

    // delegates
    // delegators

    public XpandLexer() {
        ;
    }

    public XpandLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }

    public XpandLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);

    }

    public String getGrammarFileName() {
        return "src/org/eclipse/internal/xpand2/parser/Xpand.g";
    }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:15:7: ( 'IMPORT' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:15:9: 'IMPORT'
            {
                match("IMPORT");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:16:7: ( 'EXTENSION' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:16:9: 'EXTENSION'
            {
                match("EXTENSION");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:17:7: ( 'AROUND' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:17:9: 'AROUND'
            {
                match("AROUND");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:18:7: ( '(' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:18:9: '('
            {
                match('(');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:19:7: ( ',' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:19:9: ','
            {
                match(',');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:20:7: ( '*' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:20:9: '*'
            {
                match('*');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:21:7: ( ')' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:21:9: ')'
            {
                match(')');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:22:7: ( 'FOR' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:22:9: 'FOR'
            {
                match("FOR");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:23:7: ( 'ENDAROUND' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:23:9: 'ENDAROUND'
            {
                match("ENDAROUND");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:24:7: ( '::' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:24:9: '::'
            {
                match("::");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:25:7: ( 'DEFINE' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:25:9: 'DEFINE'
            {
                match("DEFINE");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:26:7: ( 'ENDDEFINE' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:26:9: 'ENDDEFINE'
            {
                match("ENDDEFINE");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:27:7: ( '-' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:27:9: '-'
            {
                match('-');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:28:7: ( 'ERROR' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:28:9: 'ERROR'
            {
                match("ERROR");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:29:7: ( 'EXPAND' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:29:9: 'EXPAND'
            {
                match("EXPAND");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:30:7: ( 'FOREACH' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:30:9: 'FOREACH'
            {
                match("FOREACH");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:31:7: ( 'SEPARATOR' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:31:9: 'SEPARATOR'
            {
                match("SEPARATOR");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:32:7: ( 'ONFILECLOSE' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:32:9: 'ONFILECLOSE'
            {
                match("ONFILECLOSE");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:33:7: ( 'FILE' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:33:9: 'FILE'
            {
                match("FILE");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:34:7: ( 'ENDFILE' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:34:9: 'ENDFILE'
            {
                match("ENDFILE");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:35:7: ( 'AS' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:35:9: 'AS'
            {
                match("AS");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:36:7: ( 'ITERATOR' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:36:9: 'ITERATOR'
            {
                match("ITERATOR");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:37:7: ( 'ENDFOREACH' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:37:9: 'ENDFOREACH'
            {
                match("ENDFOREACH");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:38:7: ( 'IF' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:38:9: 'IF'
            {
                match("IF");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:39:7: ( 'ENDIF' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:39:9: 'ENDIF'
            {
                match("ENDIF");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:40:7: ( 'ELSEIF' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:40:9: 'ELSEIF'
            {
                match("ELSEIF");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:41:7: ( 'ELSE' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:41:9: 'ELSE'
            {
                match("ELSE");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:42:7: ( 'LET' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:42:9: 'LET'
            {
                match("LET");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:43:7: ( 'ENDLET' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:43:9: 'ENDLET'
            {
                match("ENDLET");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:44:7: ( 'PROTECT' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:44:9: 'PROTECT'
            {
                match("PROTECT");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:45:7: ( 'CSTART' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:45:9: 'CSTART'
            {
                match("CSTART");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:46:7: ( 'CEND' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:46:9: 'CEND'
            {
                match("CEND");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:47:7: ( 'ID' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:47:9: 'ID'
            {
                match("ID");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:7: ( 'DISABLE' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:9: 'DISABLE'
            {
                match("DISABLE");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:7: ( 'ENDPROTECT' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:9: 'ENDPROTECT'
            {
                match("ENDPROTECT");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:50:7: ( 'let' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:50:9: 'let'
            {
                match("let");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:51:7: ( '=' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:51:9: '='
            {
                match('=');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:52:7: ( ':' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:52:9: ':'
            {
                match(':');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:53:7: ( '->' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:53:9: '->'
            {
                match("->");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:54:7: ( '?' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:54:9: '?'
            {
                match('?');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:55:7: ( 'if' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:55:9: 'if'
            {
                match("if");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:56:7: ( 'then' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:56:9: 'then'
            {
                match("then");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:57:7: ( 'else' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:57:9: 'else'
            {
                match("else");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:58:7: ( 'switch' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:58:9: 'switch'
            {
                match("switch");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:59:7: ( '{' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:59:9: '{'
            {
                match('{');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:60:7: ( 'case' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:60:9: 'case'
            {
                match("case");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:61:7: ( 'default' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:61:9: 'default'
            {
                match("default");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:62:7: ( '}' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:62:9: '}'
            {
                match('}');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:63:7: ( '||' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:63:9: '||'
            {
                match("||");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:64:7: ( '&&' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:64:9: '&&'
            {
                match("&&");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:65:7: ( 'implies' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:65:9: 'implies'
            {
                match("implies");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:66:7: ( '==' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:66:9: '=='
            {
                match("==");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:67:7: ( '!=' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:67:9: '!='
            {
                match("!=");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:68:7: ( '>=' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:68:9: '>='
            {
                match(">=");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:69:7: ( '<=' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:69:9: '<='
            {
                match("<=");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:70:7: ( '>' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:70:9: '>'
            {
                match('>');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:71:7: ( '<' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:71:9: '<'
            {
                match('<');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:72:7: ( '+' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:72:9: '+'
            {
                match('+');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:73:7: ( '/' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:73:9: '/'
            {
                match('/');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:74:7: ( '!' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:74:9: '!'
            {
                match('!');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:75:7: ( '.' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:75:9: '.'
            {
                match('.');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:76:7: ( 'GLOBALVAR' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:76:9: 'GLOBALVAR'
            {
                match("GLOBALVAR");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:77:7: ( 'new' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:77:9: 'new'
            {
                match("new");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:78:7: ( 'false' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:78:9: 'false'
            {
                match("false");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:79:7: ( 'true' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:79:9: 'true'
            {
                match("true");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:80:7: ( 'null' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:80:9: 'null'
            {
                match("null");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:81:7: ( 'typeSelect' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:81:9: 'typeSelect'
            {
                match("typeSelect");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:82:7: ( 'collect' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:82:9: 'collect'
            {
                match("collect");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:83:7: ( 'select' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:83:9: 'select'
            {
                match("select");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:84:7: ( 'selectFirst' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:84:9: 'selectFirst'
            {
                match("selectFirst");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:85:7: ( 'reject' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:85:9: 'reject'
            {
                match("reject");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:86:7: ( 'exists' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:86:9: 'exists'
            {
                match("exists");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:87:7: ( 'notExists' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:87:9: 'notExists'
            {
                match("notExists");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:88:7: ( 'sortBy' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:88:9: 'sortBy'
            {
                match("sortBy");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:89:7: ( 'forAll' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:89:9: 'forAll'
            {
                match("forAll");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:90:7: ( '|' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:90:9: '|'
            {
                match('|');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:91:7: ( 'Collection' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:91:9: 'Collection'
            {
                match("Collection");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:92:7: ( 'List' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:92:9: 'List'
            {
                match("List");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:93:7: ( 'Set' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:93:9: 'Set'
            {
                match("Set");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:94:7: ( '[' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:94:9: '['
            {
                match('[');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:95:8: ( ']' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:95:10: ']'
            {
                match(']');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "T__100"

    // $ANTLR start "IntLiteral"
    public final void mIntLiteral() throws RecognitionException {
        try {
            int _type = IntLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:560:12: ( ( '0' .. '9' )+ )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:560:14: ( '0' .. '9' )+
            {
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:560:14: ( '0' .. '9' )+
                int cnt1 = 0;
                loop1: do {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);

                    if (((LA1_0 >= '0' && LA1_0 <= '9'))) {
                        alt1 = 1;
                    }

                    switch (alt1) {
                    case 1:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:560:14: '0' .. '9'
                    {
                        matchRange('0', '9');

                    }
                        break;

                    default:
                        if (cnt1 >= 1)
                            break loop1;
                        EarlyExitException eee = new EarlyExitException(1, input);
                        throw eee;
                    }
                    cnt1++;
                } while (true);

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "IntLiteral"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:563:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            // '\"' | '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )* '\\'' )
            int alt4 = 2;
            int LA4_0 = input.LA(1);

            if ((LA4_0 == '\"')) {
                alt4 = 1;
            } else if ((LA4_0 == '\'')) {
                alt4 = 2;
            } else {
                NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
            case 1:
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:563:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
            {
                match('\"');
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:563:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
                loop2: do {
                    int alt2 = 3;
                    int LA2_0 = input.LA(1);

                    if ((LA2_0 == '\\')) {
                        alt2 = 1;
                    } else if (((LA2_0 >= '\u0000' && LA2_0 <= '!') || (LA2_0 >= '#' && LA2_0 <= '[') || (LA2_0 >= ']' && LA2_0 <= '\uFFFF'))) {
                        alt2 = 2;
                    }

                    switch (alt2) {
                    case 1:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:563:14: EscapeSequence
                    {
                        mEscapeSequence();

                    }
                        break;
                    case 2:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:563:31: ~ ( '\\\\' | '\"' )
                    {
                        if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '[')
                                || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
                            input.consume();

                        } else {
                            MismatchedSetException mse = new MismatchedSetException(null, input);
                            recover(mse);
                            throw mse;
                        }

                    }
                        break;

                    default:
                        break loop2;
                    }
                } while (true);

                match('\"');

            }
                break;
            case 2:
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:564:8: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )*
            // '\\''
            {
                match('\'');
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:564:13: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )*
                loop3: do {
                    int alt3 = 3;
                    int LA3_0 = input.LA(1);

                    if ((LA3_0 == '\\')) {
                        alt3 = 1;
                    } else if (((LA3_0 >= '\u0000' && LA3_0 <= '&') || (LA3_0 >= '(' && LA3_0 <= '[') || (LA3_0 >= ']' && LA3_0 <= '\uFFFF'))) {
                        alt3 = 2;
                    }

                    switch (alt3) {
                    case 1:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:564:15: EscapeSequence
                    {
                        mEscapeSequence();

                    }
                        break;
                    case 2:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:564:32: ~ ( '\\'' | '\\\\' )
                    {
                        if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= '[')
                                || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
                            input.consume();

                        } else {
                            MismatchedSetException mse = new MismatchedSetException(null, input);
                            recover(mse);
                            throw mse;
                        }

                    }
                        break;

                    default:
                        break loop3;
                    }
                } while (true);

                match('\'');

            }
                break;

            }
            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "StringLiteral"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:569:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' |
            // '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
            int alt5 = 3;
            int LA5_0 = input.LA(1);

            if ((LA5_0 == '\\')) {
                switch (input.LA(2)) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't': {
                    alt5 = 1;
                }
                    break;
                case 'u': {
                    alt5 = 2;
                }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7': {
                    alt5 = 3;
                }
                    break;
                default:
                    NoViableAltException nvae = new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

            } else {
                NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
            case 1:
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:569:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' |
            // '\\'' | '\\\\' )
            {
                match('\\');
                if (input.LA(1) == '\"' || input.LA(1) == '\'' || input.LA(1) == '\\' || input.LA(1) == 'b' || input.LA(1) == 'f' || input.LA(1) == 'n'
                        || input.LA(1) == 'r' || input.LA(1) == 't') {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

            }
                break;
            case 2:
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:570:9: UnicodeEscape
            {
                mUnicodeEscape();

            }
                break;
            case 3:
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:571:9: OctalEscape
            {
                mOctalEscape();

            }
                break;

            }
        } finally {
        }
    }

    // $ANTLR end "EscapeSequence"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:576:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7'
            // ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt6 = 3;
            int LA6_0 = input.LA(1);

            if ((LA6_0 == '\\')) {
                int LA6_1 = input.LA(2);

                if (((LA6_1 >= '0' && LA6_1 <= '3'))) {
                    int LA6_2 = input.LA(3);

                    if (((LA6_2 >= '0' && LA6_2 <= '7'))) {
                        int LA6_4 = input.LA(4);

                        if (((LA6_4 >= '0' && LA6_4 <= '7'))) {
                            alt6 = 1;
                        } else {
                            alt6 = 2;
                        }
                    } else {
                        alt6 = 3;
                    }
                } else if (((LA6_1 >= '4' && LA6_1 <= '7'))) {
                    int LA6_3 = input.LA(3);

                    if (((LA6_3 >= '0' && LA6_3 <= '7'))) {
                        alt6 = 2;
                    } else {
                        alt6 = 3;
                    }
                } else {
                    NoViableAltException nvae = new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            } else {
                NoViableAltException nvae = new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
            case 1:
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:576:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
            {
                match('\\');
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:576:14: ( '0' .. '3' )
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:576:15: '0' .. '3'
                {
                    matchRange('0', '3');

                }

                // src/org/eclipse/internal/xpand2/parser/Xpand.g:576:25: ( '0' .. '7' )
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:576:26: '0' .. '7'
                {
                    matchRange('0', '7');

                }

                // src/org/eclipse/internal/xpand2/parser/Xpand.g:576:36: ( '0' .. '7' )
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:576:37: '0' .. '7'
                {
                    matchRange('0', '7');

                }

            }
                break;
            case 2:
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:577:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
            {
                match('\\');
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:577:14: ( '0' .. '7' )
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:577:15: '0' .. '7'
                {
                    matchRange('0', '7');

                }

                // src/org/eclipse/internal/xpand2/parser/Xpand.g:577:25: ( '0' .. '7' )
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:577:26: '0' .. '7'
                {
                    matchRange('0', '7');

                }

            }
                break;
            case 3:
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:578:9: '\\\\' ( '0' .. '7' )
            {
                match('\\');
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:578:14: ( '0' .. '7' )
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:578:15: '0' .. '7'
                {
                    matchRange('0', '7');

                }

            }
                break;

            }
        } finally {
        }
    }

    // $ANTLR end "OctalEscape"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:583:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:583:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
                match('\\');
                match('u');
                mHexDigit();
                mHexDigit();
                mHexDigit();
                mHexDigit();

            }

        } finally {
        }
    }

    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:586:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:586:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
                if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'F') || (input.LA(1) >= 'a' && input.LA(1) <= 'f')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

            }

        } finally {
        }
    }

    // $ANTLR end "HexDigit"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:589:5: ( ( '^' )? Letter ( Letter | JavaIDDigit )* )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:589:9: ( '^' )? Letter ( Letter | JavaIDDigit )*
            {
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:589:9: ( '^' )?
                int alt7 = 2;
                int LA7_0 = input.LA(1);

                if ((LA7_0 == '^')) {
                    alt7 = 1;
                }
                switch (alt7) {
                case 1:
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:589:10: '^'
                {
                    match('^');

                }
                    break;

                }

                mLetter();
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:589:23: ( Letter | JavaIDDigit )*
                loop8: do {
                    int alt8 = 2;
                    int LA8_0 = input.LA(1);

                    if ((LA8_0 == '$' || (LA8_0 >= '0' && LA8_0 <= '9') || (LA8_0 >= 'A' && LA8_0 <= 'Z') || LA8_0 == '_' || (LA8_0 >= 'a' && LA8_0 <= 'z')
                            || (LA8_0 >= '\u00C0' && LA8_0 <= '\u00D6') || (LA8_0 >= '\u00D8' && LA8_0 <= '\u00F6') || (LA8_0 >= '\u00F8' && LA8_0 <= '\u1FFF')
                            || (LA8_0 >= '\u3040' && LA8_0 <= '\u318F') || (LA8_0 >= '\u3300' && LA8_0 <= '\u337F') || (LA8_0 >= '\u3400' && LA8_0 <= '\u3D2D')
                            || (LA8_0 >= '\u4E00' && LA8_0 <= '\u9FFF') || (LA8_0 >= '\uF900' && LA8_0 <= '\uFAFF'))) {
                        alt8 = 1;
                    }

                    switch (alt8) {
                    case 1:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:
                    {
                        if (input.LA(1) == '$' || (input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z')
                                || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z') || (input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')
                                || (input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6') || (input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF')
                                || (input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F') || (input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F')
                                || (input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D') || (input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF')
                                || (input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF')) {
                            input.consume();

                        } else {
                            MismatchedSetException mse = new MismatchedSetException(null, input);
                            recover(mse);
                            throw mse;
                        }

                    }
                        break;

                    default:
                        break loop8;
                    }
                } while (true);

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "Identifier"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:594:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' |
            // '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' |
            // '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' |
            // '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:
            {
                if (input.LA(1) == '$' || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')
                        || (input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6') || (input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')
                        || (input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF') || (input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F')
                        || (input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F') || (input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D')
                        || (input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF') || (input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

            }

        } finally {
        }
    }

    // $ANTLR end "Letter"

    // $ANTLR start "JavaIDDigit"
    public final void mJavaIDDigit() throws RecognitionException {
        try {
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:611:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' |
            // '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' |
            // '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' |
            // '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' |
            // '\\u1040' .. '\\u1049' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:
            {
                if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= '\u0660' && input.LA(1) <= '\u0669')
                        || (input.LA(1) >= '\u06F0' && input.LA(1) <= '\u06F9') || (input.LA(1) >= '\u0966' && input.LA(1) <= '\u096F')
                        || (input.LA(1) >= '\u09E6' && input.LA(1) <= '\u09EF') || (input.LA(1) >= '\u0A66' && input.LA(1) <= '\u0A6F')
                        || (input.LA(1) >= '\u0AE6' && input.LA(1) <= '\u0AEF') || (input.LA(1) >= '\u0B66' && input.LA(1) <= '\u0B6F')
                        || (input.LA(1) >= '\u0BE7' && input.LA(1) <= '\u0BEF') || (input.LA(1) >= '\u0C66' && input.LA(1) <= '\u0C6F')
                        || (input.LA(1) >= '\u0CE6' && input.LA(1) <= '\u0CEF') || (input.LA(1) >= '\u0D66' && input.LA(1) <= '\u0D6F')
                        || (input.LA(1) >= '\u0E50' && input.LA(1) <= '\u0E59') || (input.LA(1) >= '\u0ED0' && input.LA(1) <= '\u0ED9')
                        || (input.LA(1) >= '\u1040' && input.LA(1) <= '\u1049')) {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

            }

        } finally {
        }
    }

    // $ANTLR end "JavaIDDigit"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:628:5: ( ( ' ' | '\\r' | '\\t' | '\ ' | '\\n' ) )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:628:8: ( ' ' | '\\r' | '\\t' | '\ ' | '\\n' )
            {
                if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || (input.LA(1) >= '\f' && input.LA(1) <= '\r') || input.LA(1) == ' ') {
                    input.consume();

                } else {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }

                _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "WS"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:632:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:632:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
                match("/*");

                // src/org/eclipse/internal/xpand2/parser/Xpand.g:632:14: ( options {greedy=false; } : . )*
                loop9: do {
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);

                    if ((LA9_0 == '*')) {
                        int LA9_1 = input.LA(2);

                        if ((LA9_1 == '/')) {
                            alt9 = 2;
                        } else if (((LA9_1 >= '\u0000' && LA9_1 <= '.') || (LA9_1 >= '0' && LA9_1 <= '\uFFFF'))) {
                            alt9 = 1;
                        }

                    } else if (((LA9_0 >= '\u0000' && LA9_0 <= ')') || (LA9_0 >= '+' && LA9_0 <= '\uFFFF'))) {
                        alt9 = 1;
                    }

                    switch (alt9) {
                    case 1:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:632:42: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop9;
                    }
                } while (true);

                match("*/");

                _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:636:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:636:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
                match("//");

                // src/org/eclipse/internal/xpand2/parser/Xpand.g:636:12: (~ ( '\\n' | '\\r' ) )*
                loop10: do {
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);

                    if (((LA10_0 >= '\u0000' && LA10_0 <= '\t') || (LA10_0 >= '\u000B' && LA10_0 <= '\f') || (LA10_0 >= '\u000E' && LA10_0 <= '\uFFFF'))) {
                        alt10 = 1;
                    }

                    switch (alt10) {
                    case 1:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:636:12: ~ ( '\\n' | '\\r' )
                    {
                        if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
                                || (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF')) {
                            input.consume();

                        } else {
                            MismatchedSetException mse = new MismatchedSetException(null, input);
                            recover(mse);
                            throw mse;
                        }

                    }
                        break;

                    default:
                        break loop10;
                    }
                } while (true);

                // src/org/eclipse/internal/xpand2/parser/Xpand.g:636:26: ( '\\r' )?
                int alt11 = 2;
                int LA11_0 = input.LA(1);

                if ((LA11_0 == '\r')) {
                    alt11 = 1;
                }
                switch (alt11) {
                case 1:
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:636:26: '\\r'
                {
                    match('\r');

                }
                    break;

                }

                match('\n');
                _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "LG"
    public final void mLG() throws RecognitionException {
        try {
            int _type = LG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:639:5: ( '\\u00AB' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:639:7: '\\u00AB'
            {
                match('\u00AB');

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "LG"

    // $ANTLR start "RG"
    public final void mRG() throws RecognitionException {
        try {
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:641:3: ( '\\u00BB' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:641:5: '\\u00BB'
            {
                match('\u00BB');

            }

        } finally {
        }
    }

    // $ANTLR end "RG"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:644:9: ( 'REM' RG ( options {greedy=false; } : . )*
            // '\\u00ABENDREM' )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:645:2: 'REM' RG ( options {greedy=false; } : . )*
            // '\\u00ABENDREM'
            {
                match("REM");

                mRG();
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:645:11: ( options {greedy=false; } : . )*
                loop12: do {
                    int alt12 = 2;
                    int LA12_0 = input.LA(1);

                    if ((LA12_0 == '\u00AB')) {
                        int LA12_1 = input.LA(2);

                        if ((LA12_1 == 'E')) {
                            int LA12_3 = input.LA(3);

                            if ((LA12_3 == 'N')) {
                                int LA12_4 = input.LA(4);

                                if ((LA12_4 == 'D')) {
                                    int LA12_5 = input.LA(5);

                                    if ((LA12_5 == 'R')) {
                                        int LA12_6 = input.LA(6);

                                        if ((LA12_6 == 'E')) {
                                            int LA12_7 = input.LA(7);

                                            if ((LA12_7 == 'M')) {
                                                alt12 = 2;
                                            } else if (((LA12_7 >= '\u0000' && LA12_7 <= 'L') || (LA12_7 >= 'N' && LA12_7 <= '\uFFFF'))) {
                                                alt12 = 1;
                                            }

                                        } else if (((LA12_6 >= '\u0000' && LA12_6 <= 'D') || (LA12_6 >= 'F' && LA12_6 <= '\uFFFF'))) {
                                            alt12 = 1;
                                        }

                                    } else if (((LA12_5 >= '\u0000' && LA12_5 <= 'Q') || (LA12_5 >= 'S' && LA12_5 <= '\uFFFF'))) {
                                        alt12 = 1;
                                    }

                                } else if (((LA12_4 >= '\u0000' && LA12_4 <= 'C') || (LA12_4 >= 'E' && LA12_4 <= '\uFFFF'))) {
                                    alt12 = 1;
                                }

                            } else if (((LA12_3 >= '\u0000' && LA12_3 <= 'M') || (LA12_3 >= 'O' && LA12_3 <= '\uFFFF'))) {
                                alt12 = 1;
                            }

                        } else if (((LA12_1 >= '\u0000' && LA12_1 <= 'D') || (LA12_1 >= 'F' && LA12_1 <= '\uFFFF'))) {
                            alt12 = 1;
                        }

                    } else if (((LA12_0 >= '\u0000' && LA12_0 <= '\u00AA') || (LA12_0 >= '\u00AC' && LA12_0 <= '\uFFFF'))) {
                        alt12 = 1;
                    }

                    switch (alt12) {
                    case 1:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:645:39: .
                    {
                        matchAny();

                    }
                        break;

                    default:
                        break loop12;
                    }
                } while (true);

                match("\u00ABENDREM");

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "COMMENT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:648:6: ( RG (~ ( LG ) )* ( LG )? )
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:649:3: RG (~ ( LG ) )* ( LG )?
            {
                mRG();
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:649:6: (~ ( LG ) )*
                loop13: do {
                    int alt13 = 2;
                    int LA13_0 = input.LA(1);

                    if (((LA13_0 >= '\u0000' && LA13_0 <= '\u00AA') || (LA13_0 >= '\u00AC' && LA13_0 <= '\uFFFF'))) {
                        alt13 = 1;
                    }

                    switch (alt13) {
                    case 1:
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:649:6: ~ ( LG )
                    {
                        if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\u00AA') || (input.LA(1) >= '\u00AC' && input.LA(1) <= '\uFFFF')) {
                            input.consume();

                        } else {
                            MismatchedSetException mse = new MismatchedSetException(null, input);
                            recover(mse);
                            throw mse;
                        }

                    }
                        break;

                    default:
                        break loop13;
                    }
                } while (true);

                // src/org/eclipse/internal/xpand2/parser/Xpand.g:649:13: ( LG )?
                int alt14 = 2;
                int LA14_0 = input.LA(1);

                if ((LA14_0 == '\u00AB')) {
                    alt14 = 1;
                }
                switch (alt14) {
                case 1:
                // src/org/eclipse/internal/xpand2/parser/Xpand.g:649:14: LG
                {
                    mLG();

                }
                    break;

                }

            }

            state.type = _type;
            state.channel = _channel;
        } finally {
        }
    }

    // $ANTLR end "TEXT"

    public void mTokens() throws RecognitionException {
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:8: ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 |
        // T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40
        // | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 |
        // T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67
        // | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 |
        // T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94
        // | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | IntLiteral | StringLiteral | Identifier | WS | ML_COMMENT
        // | LINE_COMMENT | LG | COMMENT | TEXT )
        int alt15 = 90;
        alt15 = dfa15.predict(input);
        switch (alt15) {
        case 1:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:10: T__20
        {
            mT__20();

        }
            break;
        case 2:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:16: T__21
        {
            mT__21();

        }
            break;
        case 3:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:22: T__22
        {
            mT__22();

        }
            break;
        case 4:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:28: T__23
        {
            mT__23();

        }
            break;
        case 5:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:34: T__24
        {
            mT__24();

        }
            break;
        case 6:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:40: T__25
        {
            mT__25();

        }
            break;
        case 7:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:46: T__26
        {
            mT__26();

        }
            break;
        case 8:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:52: T__27
        {
            mT__27();

        }
            break;
        case 9:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:58: T__28
        {
            mT__28();

        }
            break;
        case 10:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:64: T__29
        {
            mT__29();

        }
            break;
        case 11:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:70: T__30
        {
            mT__30();

        }
            break;
        case 12:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:76: T__31
        {
            mT__31();

        }
            break;
        case 13:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:82: T__32
        {
            mT__32();

        }
            break;
        case 14:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:88: T__33
        {
            mT__33();

        }
            break;
        case 15:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:94: T__34
        {
            mT__34();

        }
            break;
        case 16:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:100: T__35
        {
            mT__35();

        }
            break;
        case 17:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:106: T__36
        {
            mT__36();

        }
            break;
        case 18:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:112: T__37
        {
            mT__37();

        }
            break;
        case 19:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:118: T__38
        {
            mT__38();

        }
            break;
        case 20:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:124: T__39
        {
            mT__39();

        }
            break;
        case 21:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:130: T__40
        {
            mT__40();

        }
            break;
        case 22:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:136: T__41
        {
            mT__41();

        }
            break;
        case 23:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:142: T__42
        {
            mT__42();

        }
            break;
        case 24:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:148: T__43
        {
            mT__43();

        }
            break;
        case 25:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:154: T__44
        {
            mT__44();

        }
            break;
        case 26:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:160: T__45
        {
            mT__45();

        }
            break;
        case 27:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:166: T__46
        {
            mT__46();

        }
            break;
        case 28:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:172: T__47
        {
            mT__47();

        }
            break;
        case 29:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:178: T__48
        {
            mT__48();

        }
            break;
        case 30:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:184: T__49
        {
            mT__49();

        }
            break;
        case 31:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:190: T__50
        {
            mT__50();

        }
            break;
        case 32:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:196: T__51
        {
            mT__51();

        }
            break;
        case 33:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:202: T__52
        {
            mT__52();

        }
            break;
        case 34:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:208: T__53
        {
            mT__53();

        }
            break;
        case 35:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:214: T__54
        {
            mT__54();

        }
            break;
        case 36:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:220: T__55
        {
            mT__55();

        }
            break;
        case 37:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:226: T__56
        {
            mT__56();

        }
            break;
        case 38:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:232: T__57
        {
            mT__57();

        }
            break;
        case 39:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:238: T__58
        {
            mT__58();

        }
            break;
        case 40:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:244: T__59
        {
            mT__59();

        }
            break;
        case 41:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:250: T__60
        {
            mT__60();

        }
            break;
        case 42:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:256: T__61
        {
            mT__61();

        }
            break;
        case 43:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:262: T__62
        {
            mT__62();

        }
            break;
        case 44:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:268: T__63
        {
            mT__63();

        }
            break;
        case 45:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:274: T__64
        {
            mT__64();

        }
            break;
        case 46:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:280: T__65
        {
            mT__65();

        }
            break;
        case 47:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:286: T__66
        {
            mT__66();

        }
            break;
        case 48:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:292: T__67
        {
            mT__67();

        }
            break;
        case 49:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:298: T__68
        {
            mT__68();

        }
            break;
        case 50:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:304: T__69
        {
            mT__69();

        }
            break;
        case 51:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:310: T__70
        {
            mT__70();

        }
            break;
        case 52:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:316: T__71
        {
            mT__71();

        }
            break;
        case 53:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:322: T__72
        {
            mT__72();

        }
            break;
        case 54:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:328: T__73
        {
            mT__73();

        }
            break;
        case 55:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:334: T__74
        {
            mT__74();

        }
            break;
        case 56:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:340: T__75
        {
            mT__75();

        }
            break;
        case 57:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:346: T__76
        {
            mT__76();

        }
            break;
        case 58:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:352: T__77
        {
            mT__77();

        }
            break;
        case 59:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:358: T__78
        {
            mT__78();

        }
            break;
        case 60:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:364: T__79
        {
            mT__79();

        }
            break;
        case 61:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:370: T__80
        {
            mT__80();

        }
            break;
        case 62:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:376: T__81
        {
            mT__81();

        }
            break;
        case 63:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:382: T__82
        {
            mT__82();

        }
            break;
        case 64:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:388: T__83
        {
            mT__83();

        }
            break;
        case 65:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:394: T__84
        {
            mT__84();

        }
            break;
        case 66:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:400: T__85
        {
            mT__85();

        }
            break;
        case 67:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:406: T__86
        {
            mT__86();

        }
            break;
        case 68:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:412: T__87
        {
            mT__87();

        }
            break;
        case 69:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:418: T__88
        {
            mT__88();

        }
            break;
        case 70:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:424: T__89
        {
            mT__89();

        }
            break;
        case 71:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:430: T__90
        {
            mT__90();

        }
            break;
        case 72:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:436: T__91
        {
            mT__91();

        }
            break;
        case 73:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:442: T__92
        {
            mT__92();

        }
            break;
        case 74:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:448: T__93
        {
            mT__93();

        }
            break;
        case 75:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:454: T__94
        {
            mT__94();

        }
            break;
        case 76:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:460: T__95
        {
            mT__95();

        }
            break;
        case 77:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:466: T__96
        {
            mT__96();

        }
            break;
        case 78:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:472: T__97
        {
            mT__97();

        }
            break;
        case 79:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:478: T__98
        {
            mT__98();

        }
            break;
        case 80:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:484: T__99
        {
            mT__99();

        }
            break;
        case 81:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:490: T__100
        {
            mT__100();

        }
            break;
        case 82:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:497: IntLiteral
        {
            mIntLiteral();

        }
            break;
        case 83:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:508: StringLiteral
        {
            mStringLiteral();

        }
            break;
        case 84:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:522: Identifier
        {
            mIdentifier();

        }
            break;
        case 85:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:533: WS
        {
            mWS();

        }
            break;
        case 86:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:536: ML_COMMENT
        {
            mML_COMMENT();

        }
            break;
        case 87:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:547: LINE_COMMENT
        {
            mLINE_COMMENT();

        }
            break;
        case 88:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:560: LG
        {
            mLG();

        }
            break;
        case 89:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:563: COMMENT
        {
            mCOMMENT();

        }
            break;
        case 90:
        // src/org/eclipse/internal/xpand2/parser/Xpand.g:1:571: TEXT
        {
            mTEXT();

        }
            break;

        }

    }

    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS = "\1\uffff\3\54\4\uffff\1\54\1\76\1\54\1\102\6\54\1\116\1\uffff\4"
            + "\54\1\uffff\2\54\1\uffff\1\135\1\uffff\1\137\1\141\1\143\1\uffff" + "\1\146\1\uffff\4\54\5\uffff\1\54\3\uffff\2\54\1\161\1\162\5\54\1"
            + "\171\2\54\2\uffff\2\54\2\uffff\12\54\2\uffff\1\u0088\14\54\13\uffff" + "\12\54\2\uffff\6\54\1\uffff\1\u00ab\4\54\1\u00b0\1\54\1\u00b2\5"
            + "\54\1\u00b8\1\uffff\15\54\1\u00c6\21\54\1\u00da\2\54\1\uffff\1\u00dd" + "\3\54\1\uffff\1\54\1\uffff\1\u00e2\2\54\1\u00e5\1\54\1\uffff\1\54"
            + "\1\u00e8\1\u00e9\1\54\1\u00eb\4\54\1\u00f0\3\54\1\uffff\1\u00f4" + "\4\54\1\uffff\10\54\1\u0101\2\54\1\u0104\1\54\1\uffff\2\54\1\uffff"
            + "\4\54\1\uffff\2\54\1\uffff\2\54\2\uffff\1\54\1\uffff\4\54\1\uffff" + "\3\54\1\uffff\1\54\1\u0119\2\54\1\u011c\2\54\1\u011f\4\54\1\uffff"
            + "\1\u0124\1\54\1\uffff\1\u0126\1\u0127\1\54\1\u0129\4\54\1\u012e" + "\3\54\1\u0132\1\u0133\1\u0135\1\u0136\4\54\1\uffff\1\u013b\1\u013c"
            + "\1\uffff\2\54\1\uffff\2\54\1\u0141\1\54\1\uffff\1\54\2\uffff\1\u0144" + "\1\uffff\1\u0145\2\54\1\u0148\1\uffff\1\54\1\u014a\1\54\2\uffff"
            + "\1\54\2\uffff\1\u014d\1\u014e\2\54\2\uffff\1\u0151\3\54\1\uffff" + "\2\54\2\uffff\2\54\1\uffff\1\54\1\uffff\2\54\2\uffff\2\54\1\uffff"
            + "\1\u015e\1\u015f\1\u0160\2\54\1\u0163\4\54\1\u0168\1\u0169\3\uffff" + "\1\u016a\1\u016b\1\uffff\1\54\1\u016d\1\u016e\1\54\4\uffff\1\u0170"
            + "\2\uffff\1\u0171\2\uffff";
    static final String DFA15_eofS = "\u0172\uffff";
    static final String DFA15_minS = "\1\11\1\104\1\114\1\122\4\uffff\1\111\1\72\1\105\1\76\1\105\1\116"
            + "\1\105\1\122\1\105\1\145\1\75\1\uffff\1\146\1\150\1\154\1\145\1" + "\uffff\1\141\1\145\1\uffff\1\174\1\uffff\3\75\1\uffff\1\52\1\uffff"
            + "\1\114\1\145\1\141\1\145\5\uffff\1\105\3\uffff\1\120\1\105\2\44" + "\1\120\1\104\1\122\1\123\1\117\1\44\1\122\1\114\2\uffff\1\106\1"
            + "\123\2\uffff\1\120\1\164\1\106\1\124\1\163\1\117\1\124\1\116\1\154" + "\1\164\2\uffff\1\44\1\160\1\145\1\165\1\160\1\163\2\151\1\154\1"
            + "\162\1\163\1\154\1\146\13\uffff\1\117\1\167\1\154\1\164\1\154\1" + "\162\1\152\1\115\1\117\1\122\2\uffff\1\105\2\101\1\117\1\105\1\125"
            + "\1\uffff\1\44\1\105\1\111\2\101\1\44\1\111\1\44\1\164\1\124\1\101" + "\1\104\1\154\1\44\1\uffff\1\154\1\156\3\145\1\163\1\164\1\145\1"
            + "\164\1\145\1\154\1\141\1\102\1\44\1\154\1\105\1\163\1\101\1\145" + "\1\u00bb\1\122\1\101\2\116\1\122\1\105\1\111\1\106\1\105\2\122\1"
            + "\44\1\116\1\101\1\uffff\1\44\1\116\1\102\1\122\1\uffff\1\114\1\uffff" + "\1\44\1\105\1\122\1\44\1\145\1\uffff\1\151\2\44\1\123\1\44\1\164"
            + "\2\143\1\102\1\44\1\145\1\165\1\101\1\uffff\1\44\1\170\1\145\1\154" + "\1\143\1\uffff\2\124\1\123\1\104\1\117\1\106\1\114\1\122\1\44\1"
            + "\124\1\117\1\44\1\106\1\uffff\1\104\1\103\1\uffff\1\105\1\114\1" + "\101\1\105\1\uffff\1\103\1\124\1\uffff\1\143\1\145\2\uffff\1\145"
            + "\1\uffff\1\163\1\150\1\164\1\171\1\uffff\1\143\1\154\1\114\1\uffff" + "\1\151\1\44\1\154\1\164\1\44\1\117\1\111\1\44\1\125\1\111\2\105"
            + "\1\uffff\1\44\1\124\1\uffff\2\44\1\110\1\44\1\105\1\124\1\103\1" + "\124\1\44\1\164\1\163\1\154\4\44\2\164\1\126\1\163\1\uffff\2\44"
            + "\1\uffff\1\122\1\117\1\uffff\2\116\1\44\1\101\1\uffff\1\105\2\uffff" + "\1\44\1\uffff\1\44\1\117\1\114\1\44\1\uffff\1\151\1\44\1\145\2\uffff"
            + "\1\151\2\uffff\2\44\1\101\1\164\2\uffff\1\44\1\116\1\104\1\105\1" + "\uffff\2\103\2\uffff\1\122\1\117\1\uffff\1\157\1\uffff\1\143\1\162"
            + "\2\uffff\1\122\1\163\1\uffff\3\44\1\110\1\124\1\44\1\123\1\156\1" + "\164\1\163\2\44\3\uffff\2\44\1\uffff\1\105\2\44\1\164\4\uffff\1"
            + "\44\2\uffff\1\44\2\uffff";
    static final String DFA15_maxS = "\1\ufaff\1\124\1\130\1\123\4\uffff\1\117\1\72\1\111\1\76\1\145\1"
            + "\116\1\151\1\122\1\157\1\145\1\75\1\uffff\1\155\1\171\1\170\1\167" + "\1\uffff\1\157\1\145\1\uffff\1\174\1\uffff\3\75\1\uffff\1\57\1\uffff"
            + "\1\114\1\165\1\157\1\145\5\uffff\1\105\3\uffff\1\120\1\105\2\ufaff" + "\1\124\1\104\1\122\1\123\1\117\1\ufaff\1\122\1\114\2\uffff\1\106"
            + "\1\123\2\uffff\1\120\1\164\1\106\1\124\1\163\1\117\1\124\1\116\1" + "\154\1\164\2\uffff\1\ufaff\1\160\1\145\1\165\1\160\1\163\2\151\1"
            + "\154\1\162\1\163\1\154\1\146\13\uffff\1\117\1\167\1\154\1\164\1" + "\154\1\162\1\152\1\115\1\117\1\122\2\uffff\1\105\1\101\1\120\1\117"
            + "\1\105\1\125\1\uffff\1\ufaff\1\105\1\111\2\101\1\ufaff\1\111\1\ufaff" + "\1\164\1\124\1\101\1\104\1\154\1\ufaff\1\uffff\1\154\1\156\3\145"
            + "\1\163\1\164\1\145\1\164\1\145\1\154\1\141\1\102\1\ufaff\1\154\1" + "\105\1\163\1\101\1\145\1\u00bb\1\122\1\101\2\116\1\122\1\105\1\117"
            + "\1\106\1\105\2\122\1\ufaff\1\116\1\101\1\uffff\1\ufaff\1\116\1\102" + "\1\122\1\uffff\1\114\1\uffff\1\ufaff\1\105\1\122\1\ufaff\1\145\1"
            + "\uffff\1\151\2\ufaff\1\123\1\ufaff\1\164\2\143\1\102\1\ufaff\1\145" + "\1\165\1\101\1\uffff\1\ufaff\1\170\1\145\1\154\1\143\1\uffff\2\124"
            + "\1\123\1\104\1\117\1\106\1\114\1\122\1\ufaff\1\124\1\117\1\ufaff" + "\1\106\1\uffff\1\104\1\103\1\uffff\1\105\1\114\1\101\1\105\1\uffff"
            + "\1\103\1\124\1\uffff\1\143\1\145\2\uffff\1\145\1\uffff\1\163\1\150" + "\1\164\1\171\1\uffff\1\143\1\154\1\114\1\uffff\1\151\1\ufaff\1\154"
            + "\1\164\1\ufaff\1\117\1\111\1\ufaff\1\125\1\111\2\105\1\uffff\1\ufaff" + "\1\124\1\uffff\2\ufaff\1\110\1\ufaff\1\105\1\124\1\103\1\124\1\ufaff"
            + "\1\164\1\163\1\154\4\ufaff\2\164\1\126\1\163\1\uffff\2\ufaff\1\uffff" + "\1\122\1\117\1\uffff\2\116\1\ufaff\1\101\1\uffff\1\105\2\uffff\1"
            + "\ufaff\1\uffff\1\ufaff\1\117\1\114\1\ufaff\1\uffff\1\151\1\ufaff" + "\1\145\2\uffff\1\151\2\uffff\2\ufaff\1\101\1\164\2\uffff\1\ufaff"
            + "\1\116\1\104\1\105\1\uffff\2\103\2\uffff\1\122\1\117\1\uffff\1\157" + "\1\uffff\1\143\1\162\2\uffff\1\122\1\163\1\uffff\3\ufaff\1\110\1"
            + "\124\1\ufaff\1\123\1\156\1\164\1\163\2\ufaff\3\uffff\2\ufaff\1\uffff" + "\1\105\2\ufaff\1\164\4\uffff\1\ufaff\2\uffff\1\ufaff\2\uffff";
    static final String DFA15_acceptS = "\4\uffff\1\4\1\5\1\6\1\7\13\uffff\1\50\4\uffff\1\55\2\uffff\1\60"
            + "\1\uffff\1\62\3\uffff\1\72\1\uffff\1\75\4\uffff\1\120\1\121\1\122" + "\1\123\1\124\1\uffff\1\125\1\130\1\132\14\uffff\1\12\1\46\2\uffff"
            + "\1\47\1\15\12\uffff\1\64\1\45\15\uffff\1\61\1\114\1\65\1\74\1\66" + "\1\70\1\67\1\71\1\126\1\127\1\73\12\uffff\1\30\1\41\6\uffff\1\25"
            + "\16\uffff\1\51\42\uffff\1\10\4\uffff\1\117\1\uffff\1\34\5\uffff" + "\1\44\15\uffff\1\77\5\uffff\1\131\15\uffff\1\33\2\uffff\1\23\4\uffff"
            + "\1\116\2\uffff\1\40\2\uffff\1\52\1\101\1\uffff\1\53\4\uffff\1\56" + "\3\uffff\1\102\14\uffff\1\31\2\uffff\1\16\24\uffff\1\100\2\uffff"
            + "\1\1\2\uffff\1\17\4\uffff\1\35\1\uffff\1\32\1\3\1\uffff\1\13\4\uffff" + "\1\37\3\uffff\1\110\1\54\1\uffff\1\105\1\112\4\uffff\1\113\1\107"
            + "\4\uffff\1\24\2\uffff\1\20\1\42\2\uffff\1\36\1\uffff\1\63\2\uffff" + "\1\104\1\57\2\uffff\1\26\14\uffff\1\2\1\11\1\14\2\uffff\1\21\4\uffff"
            + "\1\76\1\111\1\27\1\43\1\uffff\1\115\1\103\1\uffff\1\22\1\106";
    static final String DFA15_specialS = "\u0172\uffff}>";
    static final String[] DFA15_transitionS = {
            "\2\56\1\uffff\2\56\22\uffff\1\56\1\36\1\53\1\uffff\1\54\1\uffff" + "\1\35\1\53\1\4\1\7\1\6\1\41\1\5\1\13\1\43\1\42\12\52\1\11\1"
                    + "\uffff\1\40\1\22\1\37\1\23\1\uffff\1\3\1\54\1\20\1\12\1\2\1" + "\10\1\44\1\54\1\1\2\54\1\16\2\54\1\15\1\17\1\54\1\55\1\14\7"
                    + "\54\1\50\1\uffff\1\51\2\54\1\uffff\2\54\1\31\1\32\1\26\1\46" + "\2\54\1\24\2\54\1\21\1\54\1\45\3\54\1\47\1\27\1\25\6\54\1\30"
                    + "\1\34\1\33\55\uffff\1\57\17\uffff\1\60\4\uffff\27\54\1\uffff" + "\37\54\1\uffff\u1f08\54\u1040\uffff\u0150\54\u0170\uffff\u0080"
                    + "\54\u0080\uffff\u092e\54\u10d2\uffff\u5200\54\u5900\uffff\u0200" + "\54",
            "\1\64\1\uffff\1\63\6\uffff\1\61\6\uffff\1\62",
            "\1\70\1\uffff\1\66\3\uffff\1\67\5\uffff\1\65",
            "\1\71\1\72",
            "",
            "",
            "",
            "",
            "\1\74\5\uffff\1\73",
            "\1\75",
            "\1\77\3\uffff\1\100",
            "\1\101",
            "\1\103\37\uffff\1\104",
            "\1\105",
            "\1\106\43\uffff\1\107",
            "\1\110",
            "\1\112\15\uffff\1\111\33\uffff\1\113",
            "\1\114",
            "\1\115",
            "",
            "\1\117\6\uffff\1\120",
            "\1\121\11\uffff\1\122\6\uffff\1\123",
            "\1\124\13\uffff\1\125",
            "\1\127\11\uffff\1\130\7\uffff\1\126",
            "",
            "\1\131\15\uffff\1\132",
            "\1\133",
            "",
            "\1\134",
            "",
            "\1\136",
            "\1\140",
            "\1\142",
            "",
            "\1\144\4\uffff\1\145",
            "",
            "\1\147",
            "\1\150\11\uffff\1\152\5\uffff\1\151",
            "\1\153\15\uffff\1\154",
            "\1\155",
            "",
            "",
            "",
            "",
            "",
            "\1\156",
            "",
            "",
            "",
            "\1\157",
            "\1\160",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\164\3\uffff\1\163",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\172",
            "\1\173",
            "",
            "",
            "\1\174",
            "\1\175",
            "",
            "",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1\2\uffff\1\u00a2\1\uffff\1\u00a3\2\uffff\1\u00a4\2" + "\uffff\1\u00a5\3\uffff\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "\1\54\13\uffff\12\54\7\uffff\4\54\1\u00aa\25\54\4\uffff\1\54" + "\1\uffff\32\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54"
                    + "\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e" + "\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00b1",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3\5\uffff\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\54\13\uffff\12\54\7\uffff\10\54\1\u00d9\21\54\4\uffff\1" + "\54\1\uffff\32\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08"
                    + "\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e" + "\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u00db",
            "\1\u00dc",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "",
            "\1\u00e1",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00e3",
            "\1\u00e4",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00e6",
            "",
            "\1\u00e7",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ea",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0102",
            "\1\u0103",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0105",
            "",
            "\1\u0106",
            "\1\u0107",
            "",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "",
            "\1\u010c",
            "\1\u010d",
            "",
            "\1\u010e",
            "\1\u010f",
            "",
            "",
            "\1\u0110",
            "",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "",
            "\1\u0118",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u011a",
            "\1\u011b",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u011d",
            "\1\u011e",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0125",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0128",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\5\54\1\u0134\24\54\4\uffff\1\54" + "\1\uffff\32\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54"
                    + "\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e" + "\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u013d",
            "\1\u013e",
            "",
            "\1\u013f",
            "\1\u0140",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0142",
            "",
            "\1\u0143",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0146",
            "\1\u0147",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u0149",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u014b",
            "",
            "",
            "\1\u014c",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u014f",
            "\1\u0150",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "",
            "\1\u0155",
            "\1\u0156",
            "",
            "",
            "\1\u0157",
            "\1\u0158",
            "",
            "\1\u0159",
            "",
            "\1\u015a",
            "\1\u015b",
            "",
            "",
            "\1\u015c",
            "\1\u015d",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0161",
            "\1\u0162",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u016c",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "\1\u016f",
            "",
            "",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32" + "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"
                    + "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff" + "\u5200\54\u5900\uffff\u0200\54", "", "" };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }

        public String getDescription() {
            return "1:1: Tokens : ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | IntLiteral | StringLiteral | Identifier | WS | ML_COMMENT | LINE_COMMENT | LG | COMMENT | TEXT );";
        }
    }

}