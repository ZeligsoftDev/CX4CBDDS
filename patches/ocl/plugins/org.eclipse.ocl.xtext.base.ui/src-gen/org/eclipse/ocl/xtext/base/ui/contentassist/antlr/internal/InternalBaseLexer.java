package org.eclipse.ocl.xtext.base.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBaseLexer extends Lexer {
    public static final int RULE_LETTER_CHARACTER=8;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_ESCAPED_CHARACTER=7;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int EOF=-1;
    public static final int RULE_SIMPLE_ID=5;
    public static final int RULE_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_SINGLE_QUOTED_STRING=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int RULE_DOUBLE_QUOTED_STRING=9;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_ESCAPED_ID=6;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalBaseLexer() {;}
    public InternalBaseLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBaseLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBase.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:11:7: ( '|?' )
            // InternalBase.g:11:9: '|?'
            {
            match("|?");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:12:7: ( '*' )
            // InternalBase.g:12:9: '*'
            {
            match('*');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:13:7: ( '+' )
            // InternalBase.g:13:9: '+'
            {
            match('+');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:14:7: ( '?' )
            // InternalBase.g:14:9: '?'
            {
            match('?');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:15:7: ( '..' )
            // InternalBase.g:15:9: '..'
            {
            match("..");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:16:7: ( '[' )
            // InternalBase.g:16:9: '['
            {
            match('[');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:17:7: ( ']' )
            // InternalBase.g:17:9: ']'
            {
            match(']');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:18:7: ( '::' )
            // InternalBase.g:18:9: '::'
            {
            match("::");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:19:7: ( ',' )
            // InternalBase.g:19:9: ','
            {
            match(',');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:20:7: ( 'extends' )
            // InternalBase.g:20:9: 'extends'
            {
            match("extends");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:21:7: ( '&&' )
            // InternalBase.g:21:9: '&&'
            {
            match("&&");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:22:7: ( '(' )
            // InternalBase.g:22:9: '('
            {
            match('(');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:23:7: ( ')' )
            // InternalBase.g:23:9: ')'
            {
            match(')');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:24:7: ( '|1' )
            // InternalBase.g:24:9: '|1'
            {
            match("|1");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "RULE_ESCAPED_CHARACTER"
    public final void mRULE_ESCAPED_CHARACTER() throws RecognitionException {
        try {
            // InternalBase.g:2121:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) )
            // InternalBase.g:2121:35: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            {
            match('\\');
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ESCAPED_CHARACTER"

    // $ANTLR start "RULE_LETTER_CHARACTER"
    public final void mRULE_LETTER_CHARACTER() throws RecognitionException {
        try {
            // InternalBase.g:2123:32: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
            // InternalBase.g:2123:34: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LETTER_CHARACTER"

    // $ANTLR start "RULE_DOUBLE_QUOTED_STRING"
    public final void mRULE_DOUBLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2125:27: ( '\"' ( RULE_ESCAPED_CHARACTER | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalBase.g:2125:29: '\"' ( RULE_ESCAPED_CHARACTER | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"');
            // InternalBase.g:2125:33: ( RULE_ESCAPED_CHARACTER | ~ ( ( '\\\\' | '\"' ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBase.g:2125:34: RULE_ESCAPED_CHARACTER
            	    {
            	    mRULE_ESCAPED_CHARACTER();

            	    }
            	    break;
            	case 2 :
            	    // InternalBase.g:2125:57: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE_QUOTED_STRING"

    // $ANTLR start "RULE_SINGLE_QUOTED_STRING"
    public final void mRULE_SINGLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_SINGLE_QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2127:27: ( '\\'' ( RULE_ESCAPED_CHARACTER | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalBase.g:2127:29: '\\'' ( RULE_ESCAPED_CHARACTER | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\'');
            // InternalBase.g:2127:34: ( RULE_ESCAPED_CHARACTER | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\\') ) {
                    alt2=1;
                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBase.g:2127:35: RULE_ESCAPED_CHARACTER
            	    {
            	    mRULE_ESCAPED_CHARACTER();

            	    }
            	    break;
            	case 2 :
            	    // InternalBase.g:2127:58: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\'');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SINGLE_QUOTED_STRING"

    // $ANTLR start "RULE_ML_SINGLE_QUOTED_STRING"
    public final void mRULE_ML_SINGLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_ML_SINGLE_QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2129:30: ( '/\\'' ( options {greedy=false; } : . )* '\\'/' )
            // InternalBase.g:2129:32: '/\\'' ( options {greedy=false; } : . )* '\\'/'
            {
            match("/'");

            // InternalBase.g:2129:38: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\'') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='.')||(LA3_1>='0' && LA3_1<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBase.g:2129:66: .
            	    {
            	    matchAny();

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("'/");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_SINGLE_QUOTED_STRING"

    // $ANTLR start "RULE_SIMPLE_ID"
    public final void mRULE_SIMPLE_ID() throws RecognitionException {
        try {
            int _type = RULE_SIMPLE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2131:16: ( RULE_LETTER_CHARACTER ( RULE_LETTER_CHARACTER | '0' .. '9' )* )
            // InternalBase.g:2131:18: RULE_LETTER_CHARACTER ( RULE_LETTER_CHARACTER | '0' .. '9' )*
            {
            mRULE_LETTER_CHARACTER();
            // InternalBase.g:2131:40: ( RULE_LETTER_CHARACTER | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBase.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SIMPLE_ID"

    // $ANTLR start "RULE_ESCAPED_ID"
    public final void mRULE_ESCAPED_ID() throws RecognitionException {
        try {
            int _type = RULE_ESCAPED_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2133:17: ( '_' RULE_SINGLE_QUOTED_STRING )
            // InternalBase.g:2133:19: '_' RULE_SINGLE_QUOTED_STRING
            {
            match('_');
            mRULE_SINGLE_QUOTED_STRING();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ESCAPED_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2135:10: ( ( '0' .. '9' )+ )
            // InternalBase.g:2135:12: ( '0' .. '9' )+
            {
            // InternalBase.g:2135:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBase.g:2135:13: '0' .. '9'
            	    {
            	    matchRange('0','9');

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2137:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalBase.g:2137:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*");

            // InternalBase.g:2137:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBase.g:2137:52: .
            	    {
            	    matchAny();

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/");


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2139:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalBase.g:2139:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--");

            // InternalBase.g:2139:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBase.g:2139:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalBase.g:2139:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalBase.g:2139:41: ( '\\r' )? '\\n'
                    {
                    // InternalBase.g:2139:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalBase.g:2139:41: '\\r'
                            {
                            match('\r');

                            }
                            break;

                    }

                    match('\n');

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2141:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBase.g:2141:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBase.g:2141:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalBase.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBase.g:2143:16: ( . )
            // InternalBase.g:2143:18: .
            {
            matchAny();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalBase.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ML_SINGLE_QUOTED_STRING | RULE_SIMPLE_ID | RULE_ESCAPED_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt11=24;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // InternalBase.g:1:10: T__16
                {
                mT__16();

                }
                break;
            case 2 :
                // InternalBase.g:1:16: T__17
                {
                mT__17();

                }
                break;
            case 3 :
                // InternalBase.g:1:22: T__18
                {
                mT__18();

                }
                break;
            case 4 :
                // InternalBase.g:1:28: T__19
                {
                mT__19();

                }
                break;
            case 5 :
                // InternalBase.g:1:34: T__20
                {
                mT__20();

                }
                break;
            case 6 :
                // InternalBase.g:1:40: T__21
                {
                mT__21();

                }
                break;
            case 7 :
                // InternalBase.g:1:46: T__22
                {
                mT__22();

                }
                break;
            case 8 :
                // InternalBase.g:1:52: T__23
                {
                mT__23();

                }
                break;
            case 9 :
                // InternalBase.g:1:58: T__24
                {
                mT__24();

                }
                break;
            case 10 :
                // InternalBase.g:1:64: T__25
                {
                mT__25();

                }
                break;
            case 11 :
                // InternalBase.g:1:70: T__26
                {
                mT__26();

                }
                break;
            case 12 :
                // InternalBase.g:1:76: T__27
                {
                mT__27();

                }
                break;
            case 13 :
                // InternalBase.g:1:82: T__28
                {
                mT__28();

                }
                break;
            case 14 :
                // InternalBase.g:1:88: T__29
                {
                mT__29();

                }
                break;
            case 15 :
                // InternalBase.g:1:94: RULE_DOUBLE_QUOTED_STRING
                {
                mRULE_DOUBLE_QUOTED_STRING();

                }
                break;
            case 16 :
                // InternalBase.g:1:120: RULE_SINGLE_QUOTED_STRING
                {
                mRULE_SINGLE_QUOTED_STRING();

                }
                break;
            case 17 :
                // InternalBase.g:1:146: RULE_ML_SINGLE_QUOTED_STRING
                {
                mRULE_ML_SINGLE_QUOTED_STRING();

                }
                break;
            case 18 :
                // InternalBase.g:1:175: RULE_SIMPLE_ID
                {
                mRULE_SIMPLE_ID();

                }
                break;
            case 19 :
                // InternalBase.g:1:190: RULE_ESCAPED_ID
                {
                mRULE_ESCAPED_ID();

                }
                break;
            case 20 :
                // InternalBase.g:1:206: RULE_INT
                {
                mRULE_INT();

                }
                break;
            case 21 :
                // InternalBase.g:1:215: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT();

                }
                break;
            case 22 :
                // InternalBase.g:1:231: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT();

                }
                break;
            case 23 :
                // InternalBase.g:1:247: RULE_WS
                {
                mRULE_WS();

                }
                break;
            case 24 :
                // InternalBase.g:1:255: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER();

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\1\26\3\uffff\1\26\2\uffff\1\26\1\uffff\1\42\1\26\2\uffff\3\26\1\42\2\uffff\1\26\14\uffff\1\42\14\uffff\4\42\1\63\1\uffff";
    static final String DFA11_eofS =
        "\64\uffff";
    static final String DFA11_minS =
        "\1\0\1\61\3\uffff\1\56\2\uffff\1\72\1\uffff\1\170\1\46\2\uffff\2\0\2\47\2\uffff\1\55\14\uffff\1\164\14\uffff\1\145\1\156\1\144\1\163\1\60\1\uffff";
    static final String DFA11_maxS =
        "\1\uffff\1\77\3\uffff\1\56\2\uffff\1\72\1\uffff\1\170\1\46\2\uffff\2\uffff\1\52\1\47\2\uffff\1\55\14\uffff\1\164\14\uffff\1\145\1\156\1\144\1\163\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\uffff\1\6\1\7\1\uffff\1\11\2\uffff\1\14\1\15\4\uffff\1\22\1\24\1\uffff\1\27\1\30\1\1\1\16\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\22\1\13\1\14\1\15\1\17\1\20\1\21\1\25\1\23\1\24\1\26\1\27\5\uffff\1\12";
    static final String DFA11_specialS =
        "\1\1\15\uffff\1\2\1\0\44\uffff}>";
    static final String[] DFA11_transitionS = DFA11_transitionS_.DFA11_transitionS;
    private static final class DFA11_transitionS_ {
        static final String[] DFA11_transitionS = {
                "\11\26\2\25\2\26\1\25\22\26\1\25\1\26\1\16\3\26\1\13\1\17\1\14\1\15\1\2\1\3\1\11\1\24\1\5\1\20\12\23\1\10\4\26\1\4\1\26\32\22\1\6\1\26\1\7\1\26\1\21\1\26\4\22\1\12\25\22\1\26\1\1\uff83\26",
                "\1\30\15\uffff\1\27",
                "",
                "",
                "",
                "\1\34",
                "",
                "",
                "\1\37",
                "",
                "\1\41",
                "\1\43",
                "",
                "",
                "\0\46",
                "\0\47",
                "\1\50\2\uffff\1\51",
                "\1\52",
                "",
                "",
                "\1\54",
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
                "",
                "\1\56",
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
                "",
                "\1\57",
                "\1\60",
                "\1\61",
                "\1\62",
                "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
                ""
        };
    }

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    static class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ML_SINGLE_QUOTED_STRING | RULE_SIMPLE_ID | RULE_ESCAPED_ID | RULE_INT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA11_15 = input.LA(1);

                        s = -1;
                        if ( ((LA11_15>='\u0000' && LA11_15<='\uFFFF')) ) {s = 39;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA11_0 = input.LA(1);

                        s = -1;
                        if ( (LA11_0=='|') ) {s = 1;}

                        else if ( (LA11_0=='*') ) {s = 2;}

                        else if ( (LA11_0=='+') ) {s = 3;}

                        else if ( (LA11_0=='?') ) {s = 4;}

                        else if ( (LA11_0=='.') ) {s = 5;}

                        else if ( (LA11_0=='[') ) {s = 6;}

                        else if ( (LA11_0==']') ) {s = 7;}

                        else if ( (LA11_0==':') ) {s = 8;}

                        else if ( (LA11_0==',') ) {s = 9;}

                        else if ( (LA11_0=='e') ) {s = 10;}

                        else if ( (LA11_0=='&') ) {s = 11;}

                        else if ( (LA11_0=='(') ) {s = 12;}

                        else if ( (LA11_0==')') ) {s = 13;}

                        else if ( (LA11_0=='\"') ) {s = 14;}

                        else if ( (LA11_0=='\'') ) {s = 15;}

                        else if ( (LA11_0=='/') ) {s = 16;}

                        else if ( (LA11_0=='_') ) {s = 17;}

                        else if ( ((LA11_0>='A' && LA11_0<='Z')||(LA11_0>='a' && LA11_0<='d')||(LA11_0>='f' && LA11_0<='z')) ) {s = 18;}

                        else if ( ((LA11_0>='0' && LA11_0<='9')) ) {s = 19;}

                        else if ( (LA11_0=='-') ) {s = 20;}

                        else if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {s = 21;}

                        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\u001F')||LA11_0=='!'||(LA11_0>='#' && LA11_0<='%')||(LA11_0>=';' && LA11_0<='>')||LA11_0=='@'||LA11_0=='\\'||LA11_0=='^'||LA11_0=='`'||LA11_0=='{'||(LA11_0>='}' && LA11_0<='\uFFFF')) ) {s = 22;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 :
                        int LA11_14 = input.LA(1);

                        s = -1;
                        if ( ((LA11_14>='\u0000' && LA11_14<='\uFFFF')) ) {s = 38;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }


}