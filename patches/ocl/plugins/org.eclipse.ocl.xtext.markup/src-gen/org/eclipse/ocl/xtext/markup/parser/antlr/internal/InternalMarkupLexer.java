package org.eclipse.ocl.xtext.markup.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMarkupLexer extends Lexer {
    public static final int RULE_ESCAPED=12;
    public static final int RULE_WORD=8;
    public static final int RULE_STRING=6;
    public static final int RULE_VERTICAL_WS=13;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_HORIZONTAL_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_NUMBER=10;
    public static final int RULE_LETTER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_NL=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalMarkupLexer() {;}
    public InternalMarkupLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMarkupLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMarkup.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMarkup.g:11:7: ( 'b' )
            // InternalMarkup.g:11:9: 'b'
            {
            match('b');

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
            // InternalMarkup.g:12:7: ( 'e' )
            // InternalMarkup.g:12:9: 'e'
            {
            match('e');

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
            // InternalMarkup.g:13:7: ( 'bullet' )
            // InternalMarkup.g:13:9: 'bullet'
            {
            match("bullet");


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
            // InternalMarkup.g:14:7: ( 'figure' )
            // InternalMarkup.g:14:9: 'figure'
            {
            match("figure");


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
            // InternalMarkup.g:15:7: ( 'figureRef' )
            // InternalMarkup.g:15:9: 'figureRef'
            {
            match("figureRef");


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
            // InternalMarkup.g:16:7: ( 'footnote' )
            // InternalMarkup.g:16:9: 'footnote'
            {
            match("footnote");


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
            // InternalMarkup.g:17:7: ( 'heading' )
            // InternalMarkup.g:17:9: 'heading'
            {
            match("heading");


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
            // InternalMarkup.g:18:7: ( 'oclCode' )
            // InternalMarkup.g:18:9: 'oclCode'
            {
            match("oclCode");


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
            // InternalMarkup.g:19:7: ( 'oclEval' )
            // InternalMarkup.g:19:9: 'oclEval'
            {
            match("oclEval");


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
            // InternalMarkup.g:20:7: ( 'oclText' )
            // InternalMarkup.g:20:9: 'oclText'
            {
            match("oclText");


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
            // InternalMarkup.g:21:7: ( ':' )
            // InternalMarkup.g:21:9: ':'
            {
            match(':');

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
            // InternalMarkup.g:22:7: ( '[' )
            // InternalMarkup.g:22:9: '['
            {
            match('[');

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
            // InternalMarkup.g:23:7: ( ']' )
            // InternalMarkup.g:23:9: ']'
            {
            match(']');

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
            // InternalMarkup.g:24:7: ( '#' )
            // InternalMarkup.g:24:9: '#'
            {
            match('#');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMarkup.g:25:7: ( ',' )
            // InternalMarkup.g:25:9: ','
            {
            match(',');

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "RULE_NUMBER"
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            // InternalMarkup.g:1290:22: ( '0' .. '9' )
            // InternalMarkup.g:1290:24: '0' .. '9'
            {
            matchRange('0','9');

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMBER"

    // $ANTLR start "RULE_LETTER"
    public final void mRULE_LETTER() throws RecognitionException {
        try {
            // InternalMarkup.g:1292:22: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
            // InternalMarkup.g:1292:24: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
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
    // $ANTLR end "RULE_LETTER"

    // $ANTLR start "RULE_ESCAPED"
    public final void mRULE_ESCAPED() throws RecognitionException {
        try {
            // InternalMarkup.g:1294:23: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' | '<' | '>' | '[' | ']' ) )
            // InternalMarkup.g:1294:25: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' | '<' | '>' | '[' | ']' )
            {
            match('\\');
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='<'||input.LA(1)=='>'||(input.LA(1)>='[' && input.LA(1)<=']')||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
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
    // $ANTLR end "RULE_ESCAPED"

    // $ANTLR start "RULE_VERTICAL_WS"
    public final void mRULE_VERTICAL_WS() throws RecognitionException {
        try {
            // InternalMarkup.g:1296:27: ( ( '\\n' | '\\r' ) )
            // InternalMarkup.g:1296:29: ( '\\n' | '\\r' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
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
    // $ANTLR end "RULE_VERTICAL_WS"

    // $ANTLR start "RULE_HORIZONTAL_WS"
    public final void mRULE_HORIZONTAL_WS() throws RecognitionException {
        try {
            // InternalMarkup.g:1298:29: ( ( ' ' | '\\t' ) )
            // InternalMarkup.g:1298:31: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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
    // $ANTLR end "RULE_HORIZONTAL_WS"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMarkup.g:1300:10: ( ( RULE_NUMBER )+ )
            // InternalMarkup.g:1300:12: ( RULE_NUMBER )+
            {
            // InternalMarkup.g:1300:12: ( RULE_NUMBER )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMarkup.g:1300:12: RULE_NUMBER
            	    {
            	    mRULE_NUMBER();

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMarkup.g:1302:13: ( '\"' ( RULE_ESCAPED | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalMarkup.g:1302:15: '\"' ( RULE_ESCAPED | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"');
            // InternalMarkup.g:1302:19: ( RULE_ESCAPED | ~ ( ( '\\\\' | '\"' ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\\') ) {
                    alt2=1;
                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMarkup.g:1302:20: RULE_ESCAPED
            	    {
            	    mRULE_ESCAPED();

            	    }
            	    break;
            	case 2 :
            	    // InternalMarkup.g:1302:33: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop2;
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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMarkup.g:1304:9: ( RULE_LETTER ( RULE_LETTER | RULE_NUMBER )* )
            // InternalMarkup.g:1304:11: RULE_LETTER ( RULE_LETTER | RULE_NUMBER )*
            {
            mRULE_LETTER();
            // InternalMarkup.g:1304:23: ( RULE_LETTER | RULE_NUMBER )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMarkup.g:
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
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_WORD"
    public final void mRULE_WORD() throws RecognitionException {
        try {
            int _type = RULE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMarkup.g:1306:11: ( ( RULE_ESCAPED | ~ ( ( '\\\\' | '\"' | '[' | ']' | ':' | '#' | ',' | RULE_HORIZONTAL_WS | RULE_VERTICAL_WS ) ) )+ )
            // InternalMarkup.g:1306:13: ( RULE_ESCAPED | ~ ( ( '\\\\' | '\"' | '[' | ']' | ':' | '#' | ',' | RULE_HORIZONTAL_WS | RULE_VERTICAL_WS ) ) )+
            {
            // InternalMarkup.g:1306:13: ( RULE_ESCAPED | ~ ( ( '\\\\' | '\"' | '[' | ']' | ':' | '#' | ',' | RULE_HORIZONTAL_WS | RULE_VERTICAL_WS ) ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='\b')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\u001F')||LA4_0=='!'||(LA4_0>='$' && LA4_0<='+')||(LA4_0>='-' && LA4_0<='9')||(LA4_0>=';' && LA4_0<='Z')||(LA4_0>='^' && LA4_0<='\uFFFF')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMarkup.g:1306:14: RULE_ESCAPED
            	    {
            	    mRULE_ESCAPED();

            	    }
            	    break;
            	case 2 :
            	    // InternalMarkup.g:1306:27: ~ ( ( '\\\\' | '\"' | '[' | ']' | ':' | '#' | ',' | RULE_HORIZONTAL_WS | RULE_VERTICAL_WS ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||input.LA(1)=='!'||(input.LA(1)>='$' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='Z')||(input.LA(1)>='^' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WORD"

    // $ANTLR start "RULE_NL"
    public final void mRULE_NL() throws RecognitionException {
        try {
            int _type = RULE_NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMarkup.g:1308:9: ( ( ( RULE_HORIZONTAL_WS )* RULE_VERTICAL_WS )+ )
            // InternalMarkup.g:1308:11: ( ( RULE_HORIZONTAL_WS )* RULE_VERTICAL_WS )+
            {
            // InternalMarkup.g:1308:11: ( ( RULE_HORIZONTAL_WS )* RULE_VERTICAL_WS )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0=='\r'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMarkup.g:1308:12: ( RULE_HORIZONTAL_WS )* RULE_VERTICAL_WS
            	    {
            	    // InternalMarkup.g:1308:12: ( RULE_HORIZONTAL_WS )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0=='\t'||LA5_0==' ') ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalMarkup.g:1308:12: RULE_HORIZONTAL_WS
            	    	    {
            	    	    mRULE_HORIZONTAL_WS();

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);

            	    mRULE_VERTICAL_WS();

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NL"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMarkup.g:1310:9: ( ( RULE_HORIZONTAL_WS )+ )
            // InternalMarkup.g:1310:11: ( RULE_HORIZONTAL_WS )+
            {
            // InternalMarkup.g:1310:11: ( RULE_HORIZONTAL_WS )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMarkup.g:1310:11: RULE_HORIZONTAL_WS
            	    {
            	    mRULE_HORIZONTAL_WS();

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
            // InternalMarkup.g:1312:16: ( . )
            // InternalMarkup.g:1312:18: .
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
        // InternalMarkup.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | RULE_INT | RULE_STRING | RULE_ID | RULE_WORD | RULE_NL | RULE_WS | RULE_ANY_OTHER )
        int alt8=22;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // InternalMarkup.g:1:10: T__16
                {
                mT__16();

                }
                break;
            case 2 :
                // InternalMarkup.g:1:16: T__17
                {
                mT__17();

                }
                break;
            case 3 :
                // InternalMarkup.g:1:22: T__18
                {
                mT__18();

                }
                break;
            case 4 :
                // InternalMarkup.g:1:28: T__19
                {
                mT__19();

                }
                break;
            case 5 :
                // InternalMarkup.g:1:34: T__20
                {
                mT__20();

                }
                break;
            case 6 :
                // InternalMarkup.g:1:40: T__21
                {
                mT__21();

                }
                break;
            case 7 :
                // InternalMarkup.g:1:46: T__22
                {
                mT__22();

                }
                break;
            case 8 :
                // InternalMarkup.g:1:52: T__23
                {
                mT__23();

                }
                break;
            case 9 :
                // InternalMarkup.g:1:58: T__24
                {
                mT__24();

                }
                break;
            case 10 :
                // InternalMarkup.g:1:64: T__25
                {
                mT__25();

                }
                break;
            case 11 :
                // InternalMarkup.g:1:70: T__26
                {
                mT__26();

                }
                break;
            case 12 :
                // InternalMarkup.g:1:76: T__27
                {
                mT__27();

                }
                break;
            case 13 :
                // InternalMarkup.g:1:82: T__28
                {
                mT__28();

                }
                break;
            case 14 :
                // InternalMarkup.g:1:88: T__29
                {
                mT__29();

                }
                break;
            case 15 :
                // InternalMarkup.g:1:94: T__30
                {
                mT__30();

                }
                break;
            case 16 :
                // InternalMarkup.g:1:100: RULE_INT
                {
                mRULE_INT();

                }
                break;
            case 17 :
                // InternalMarkup.g:1:109: RULE_STRING
                {
                mRULE_STRING();

                }
                break;
            case 18 :
                // InternalMarkup.g:1:121: RULE_ID
                {
                mRULE_ID();

                }
                break;
            case 19 :
                // InternalMarkup.g:1:129: RULE_WORD
                {
                mRULE_WORD();

                }
                break;
            case 20 :
                // InternalMarkup.g:1:139: RULE_NL
                {
                mRULE_NL();

                }
                break;
            case 21 :
                // InternalMarkup.g:1:147: RULE_WS
                {
                mRULE_WS();

                }
                break;
            case 22 :
                // InternalMarkup.g:1:155: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER();

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\1\23\1\26\3\31\5\uffff\1\41\1\44\1\31\1\44\1\uffff\1\45\1\uffff\1\31\1\uffff\1\31\2\uffff\2\31\1\uffff\2\31\6\uffff\1\41\3\uffff\1\45\1\uffff\23\31\1\102\1\104\5\31\1\uffff\1\31\1\uffff\1\31\1\114\1\115\1\116\1\117\1\31\1\121\4\uffff\1\122\2\uffff";
    static final String DFA8_eofS =
        "\123\uffff";
    static final String DFA8_minS =
        "\6\0\5\uffff\3\0\1\42\1\uffff\1\11\1\uffff\1\0\1\uffff\1\0\2\uffff\2\0\1\uffff\2\0\6\uffff\1\0\3\uffff\1\11\1\uffff\32\0\1\uffff\1\0\1\uffff\7\0\4\uffff\1\0\2\uffff";
    static final String DFA8_maxS =
        "\6\uffff\5\uffff\3\uffff\1\164\1\uffff\1\40\1\uffff\1\uffff\1\uffff\1\uffff\2\uffff\2\uffff\1\uffff\2\uffff\6\uffff\1\uffff\3\uffff\1\40\1\uffff\32\uffff\1\uffff\1\uffff\1\uffff\7\uffff\4\uffff\1\uffff\2\uffff";
    static final String DFA8_acceptS =
        "\6\uffff\1\13\1\14\1\15\1\16\1\17\4\uffff\1\23\1\uffff\1\24\1\uffff\1\1\1\uffff\1\23\1\2\2\uffff\1\22\2\uffff\1\13\1\14\1\15\1\16\1\17\1\20\1\uffff\1\21\1\26\1\25\1\uffff\1\24\32\uffff\1\3\1\uffff\1\4\7\uffff\1\7\1\10\1\11\1\12\1\uffff\1\6\1\5";
    static final String DFA8_specialS =
        "\1\23\1\55\1\41\1\31\1\13\1\30\5\uffff\1\52\1\43\1\33\4\uffff\1\44\1\uffff\1\14\2\uffff\1\34\1\57\1\uffff\1\2\1\15\6\uffff\1\46\5\uffff\1\45\1\35\1\60\1\3\1\20\1\47\1\40\1\61\1\4\1\10\1\17\1\24\1\50\1\42\1\62\1\6\1\11\1\21\1\25\1\36\1\26\1\0\1\7\1\12\1\22\1\27\1\uffff\1\53\1\uffff\1\1\1\5\1\16\1\32\1\37\1\54\1\56\4\uffff\1\51\2\uffff}>";
    static final String[] DFA8_transitionS = DFA8_transitionS_.DFA8_transitionS;
    private static final class DFA8_transitionS_ {
        static final String[] DFA8_transitionS = {
                "\11\17\1\20\1\21\2\17\1\21\22\17\1\20\1\17\1\14\1\11\10\17\1\12\3\17\12\13\1\6\6\17\32\15\1\7\1\16\1\10\1\17\1\15\1\17\1\15\1\1\2\15\1\2\1\3\1\15\1\4\6\15\1\5\13\15\uff85\17",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\24\24\1\22\5\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\10\24\1\27\5\24\1\30\13\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\4\24\1\32\25\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\2\24\1\33\27\24\uff85\25",
                "",
                "",
                "",
                "",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\42\1\uffff\40\25\1\uffff\1\25\1\uffff\uffa2\25",
                "\0\43",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\1\25\4\uffff\1\25\24\uffff\1\25\1\uffff\1\25\34\uffff\3\25\4\uffff\1\25\3\uffff\1\25\7\uffff\1\25\3\uffff\1\25\1\uffff\1\25",
                "",
                "\1\46\1\47\2\uffff\1\47\22\uffff\1\46",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\13\24\1\50\16\24\uff85\25",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\6\24\1\51\23\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\16\24\1\52\13\24\uff85\25",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\1\53\31\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\13\24\1\54\16\24\uff85\25",
                "",
                "",
                "",
                "",
                "",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\42\1\uffff\40\25\1\uffff\1\25\1\uffff\uffa2\25",
                "",
                "",
                "",
                "\1\46\1\47\2\uffff\1\47\22\uffff\1\46",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\13\24\1\55\16\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\24\24\1\56\5\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\23\24\1\57\6\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\3\24\1\60\26\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\2\24\1\61\1\24\1\62\16\24\1\63\6\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\4\24\1\64\25\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\21\24\1\65\10\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\15\24\1\66\14\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\10\24\1\67\21\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\16\24\1\70\13\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\25\24\1\71\4\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\4\24\1\72\25\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\23\24\1\73\6\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\4\24\1\74\25\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\16\24\1\75\13\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\15\24\1\76\14\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\3\24\1\77\26\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\1\100\31\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\27\24\1\101\2\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\21\24\1\103\10\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\23\24\1\105\6\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\6\24\1\106\23\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\4\24\1\107\25\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\13\24\1\110\16\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\23\24\1\111\6\24\uff85\25",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\4\24\1\112\25\24\uff85\25",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\4\24\1\113\25\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\5\24\1\120\24\24\uff85\25",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "",
                "",
                "",
                "",
                "\11\25\2\uffff\2\25\1\uffff\22\25\1\uffff\1\25\2\uffff\10\25\1\uffff\3\25\12\24\1\uffff\6\25\32\24\1\uffff\1\25\1\uffff\1\25\1\24\1\25\32\24\uff85\25",
                "",
                ""
        };
    }

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    static class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | RULE_INT | RULE_STRING | RULE_ID | RULE_WORD | RULE_NL | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA8_61 = input.LA(1);

                        s = -1;
                        if ( (LA8_61=='t') ) {s = 69;}

                        else if ( ((LA8_61>='0' && LA8_61<='9')||(LA8_61>='A' && LA8_61<='Z')||LA8_61=='_'||(LA8_61>='a' && LA8_61<='s')||(LA8_61>='u' && LA8_61<='z')) ) {s = 20;}

                        else if ( ((LA8_61>='\u0000' && LA8_61<='\b')||(LA8_61>='\u000B' && LA8_61<='\f')||(LA8_61>='\u000E' && LA8_61<='\u001F')||LA8_61=='!'||(LA8_61>='$' && LA8_61<='+')||(LA8_61>='-' && LA8_61<='/')||(LA8_61>=';' && LA8_61<='@')||LA8_61=='\\'||LA8_61=='^'||LA8_61=='`'||(LA8_61>='{' && LA8_61<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA8_69 = input.LA(1);

                        s = -1;
                        if ( (LA8_69=='e') ) {s = 75;}

                        else if ( ((LA8_69>='0' && LA8_69<='9')||(LA8_69>='A' && LA8_69<='Z')||LA8_69=='_'||(LA8_69>='a' && LA8_69<='d')||(LA8_69>='f' && LA8_69<='z')) ) {s = 20;}

                        else if ( ((LA8_69>='\u0000' && LA8_69<='\b')||(LA8_69>='\u000B' && LA8_69<='\f')||(LA8_69>='\u000E' && LA8_69<='\u001F')||LA8_69=='!'||(LA8_69>='$' && LA8_69<='+')||(LA8_69>='-' && LA8_69<='/')||(LA8_69>=';' && LA8_69<='@')||LA8_69=='\\'||LA8_69=='^'||LA8_69=='`'||(LA8_69>='{' && LA8_69<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 2 :
                        int LA8_26 = input.LA(1);

                        s = -1;
                        if ( (LA8_26=='a') ) {s = 43;}

                        else if ( ((LA8_26>='0' && LA8_26<='9')||(LA8_26>='A' && LA8_26<='Z')||LA8_26=='_'||(LA8_26>='b' && LA8_26<='z')) ) {s = 20;}

                        else if ( ((LA8_26>='\u0000' && LA8_26<='\b')||(LA8_26>='\u000B' && LA8_26<='\f')||(LA8_26>='\u000E' && LA8_26<='\u001F')||LA8_26=='!'||(LA8_26>='$' && LA8_26<='+')||(LA8_26>='-' && LA8_26<='/')||(LA8_26>=';' && LA8_26<='@')||LA8_26=='\\'||LA8_26=='^'||LA8_26=='`'||(LA8_26>='{' && LA8_26<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 3 :
                        int LA8_43 = input.LA(1);

                        s = -1;
                        if ( (LA8_43=='d') ) {s = 48;}

                        else if ( ((LA8_43>='0' && LA8_43<='9')||(LA8_43>='A' && LA8_43<='Z')||LA8_43=='_'||(LA8_43>='a' && LA8_43<='c')||(LA8_43>='e' && LA8_43<='z')) ) {s = 20;}

                        else if ( ((LA8_43>='\u0000' && LA8_43<='\b')||(LA8_43>='\u000B' && LA8_43<='\f')||(LA8_43>='\u000E' && LA8_43<='\u001F')||LA8_43=='!'||(LA8_43>='$' && LA8_43<='+')||(LA8_43>='-' && LA8_43<='/')||(LA8_43>=';' && LA8_43<='@')||LA8_43=='\\'||LA8_43=='^'||LA8_43=='`'||(LA8_43>='{' && LA8_43<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 4 :
                        int LA8_48 = input.LA(1);

                        s = -1;
                        if ( (LA8_48=='i') ) {s = 55;}

                        else if ( ((LA8_48>='0' && LA8_48<='9')||(LA8_48>='A' && LA8_48<='Z')||LA8_48=='_'||(LA8_48>='a' && LA8_48<='h')||(LA8_48>='j' && LA8_48<='z')) ) {s = 20;}

                        else if ( ((LA8_48>='\u0000' && LA8_48<='\b')||(LA8_48>='\u000B' && LA8_48<='\f')||(LA8_48>='\u000E' && LA8_48<='\u001F')||LA8_48=='!'||(LA8_48>='$' && LA8_48<='+')||(LA8_48>='-' && LA8_48<='/')||(LA8_48>=';' && LA8_48<='@')||LA8_48=='\\'||LA8_48=='^'||LA8_48=='`'||(LA8_48>='{' && LA8_48<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 5 :
                        int LA8_70 = input.LA(1);

                        s = -1;
                        if ( ((LA8_70>='0' && LA8_70<='9')||(LA8_70>='A' && LA8_70<='Z')||LA8_70=='_'||(LA8_70>='a' && LA8_70<='z')) ) {s = 20;}

                        else if ( ((LA8_70>='\u0000' && LA8_70<='\b')||(LA8_70>='\u000B' && LA8_70<='\f')||(LA8_70>='\u000E' && LA8_70<='\u001F')||LA8_70=='!'||(LA8_70>='$' && LA8_70<='+')||(LA8_70>='-' && LA8_70<='/')||(LA8_70>=';' && LA8_70<='@')||LA8_70=='\\'||LA8_70=='^'||LA8_70=='`'||(LA8_70>='{' && LA8_70<='\uFFFF')) ) {s = 21;}

                        else s = 76;

                        if ( s>=0 ) return s;
                        break;
                    case 6 :
                        int LA8_55 = input.LA(1);

                        s = -1;
                        if ( (LA8_55=='n') ) {s = 62;}

                        else if ( ((LA8_55>='0' && LA8_55<='9')||(LA8_55>='A' && LA8_55<='Z')||LA8_55=='_'||(LA8_55>='a' && LA8_55<='m')||(LA8_55>='o' && LA8_55<='z')) ) {s = 20;}

                        else if ( ((LA8_55>='\u0000' && LA8_55<='\b')||(LA8_55>='\u000B' && LA8_55<='\f')||(LA8_55>='\u000E' && LA8_55<='\u001F')||LA8_55=='!'||(LA8_55>='$' && LA8_55<='+')||(LA8_55>='-' && LA8_55<='/')||(LA8_55>=';' && LA8_55<='@')||LA8_55=='\\'||LA8_55=='^'||LA8_55=='`'||(LA8_55>='{' && LA8_55<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 7 :
                        int LA8_62 = input.LA(1);

                        s = -1;
                        if ( (LA8_62=='g') ) {s = 70;}

                        else if ( ((LA8_62>='0' && LA8_62<='9')||(LA8_62>='A' && LA8_62<='Z')||LA8_62=='_'||(LA8_62>='a' && LA8_62<='f')||(LA8_62>='h' && LA8_62<='z')) ) {s = 20;}

                        else if ( ((LA8_62>='\u0000' && LA8_62<='\b')||(LA8_62>='\u000B' && LA8_62<='\f')||(LA8_62>='\u000E' && LA8_62<='\u001F')||LA8_62=='!'||(LA8_62>='$' && LA8_62<='+')||(LA8_62>='-' && LA8_62<='/')||(LA8_62>=';' && LA8_62<='@')||LA8_62=='\\'||LA8_62=='^'||LA8_62=='`'||(LA8_62>='{' && LA8_62<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 8 :
                        int LA8_49 = input.LA(1);

                        s = -1;
                        if ( (LA8_49=='o') ) {s = 56;}

                        else if ( ((LA8_49>='0' && LA8_49<='9')||(LA8_49>='A' && LA8_49<='Z')||LA8_49=='_'||(LA8_49>='a' && LA8_49<='n')||(LA8_49>='p' && LA8_49<='z')) ) {s = 20;}

                        else if ( ((LA8_49>='\u0000' && LA8_49<='\b')||(LA8_49>='\u000B' && LA8_49<='\f')||(LA8_49>='\u000E' && LA8_49<='\u001F')||LA8_49=='!'||(LA8_49>='$' && LA8_49<='+')||(LA8_49>='-' && LA8_49<='/')||(LA8_49>=';' && LA8_49<='@')||LA8_49=='\\'||LA8_49=='^'||LA8_49=='`'||(LA8_49>='{' && LA8_49<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 9 :
                        int LA8_56 = input.LA(1);

                        s = -1;
                        if ( (LA8_56=='d') ) {s = 63;}

                        else if ( ((LA8_56>='0' && LA8_56<='9')||(LA8_56>='A' && LA8_56<='Z')||LA8_56=='_'||(LA8_56>='a' && LA8_56<='c')||(LA8_56>='e' && LA8_56<='z')) ) {s = 20;}

                        else if ( ((LA8_56>='\u0000' && LA8_56<='\b')||(LA8_56>='\u000B' && LA8_56<='\f')||(LA8_56>='\u000E' && LA8_56<='\u001F')||LA8_56=='!'||(LA8_56>='$' && LA8_56<='+')||(LA8_56>='-' && LA8_56<='/')||(LA8_56>=';' && LA8_56<='@')||LA8_56=='\\'||LA8_56=='^'||LA8_56=='`'||(LA8_56>='{' && LA8_56<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 10 :
                        int LA8_63 = input.LA(1);

                        s = -1;
                        if ( (LA8_63=='e') ) {s = 71;}

                        else if ( ((LA8_63>='0' && LA8_63<='9')||(LA8_63>='A' && LA8_63<='Z')||LA8_63=='_'||(LA8_63>='a' && LA8_63<='d')||(LA8_63>='f' && LA8_63<='z')) ) {s = 20;}

                        else if ( ((LA8_63>='\u0000' && LA8_63<='\b')||(LA8_63>='\u000B' && LA8_63<='\f')||(LA8_63>='\u000E' && LA8_63<='\u001F')||LA8_63=='!'||(LA8_63>='$' && LA8_63<='+')||(LA8_63>='-' && LA8_63<='/')||(LA8_63>=';' && LA8_63<='@')||LA8_63=='\\'||LA8_63=='^'||LA8_63=='`'||(LA8_63>='{' && LA8_63<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 11 :
                        int LA8_4 = input.LA(1);

                        s = -1;
                        if ( (LA8_4=='e') ) {s = 26;}

                        else if ( ((LA8_4>='0' && LA8_4<='9')||(LA8_4>='A' && LA8_4<='Z')||LA8_4=='_'||(LA8_4>='a' && LA8_4<='d')||(LA8_4>='f' && LA8_4<='z')) ) {s = 20;}

                        else if ( ((LA8_4>='\u0000' && LA8_4<='\b')||(LA8_4>='\u000B' && LA8_4<='\f')||(LA8_4>='\u000E' && LA8_4<='\u001F')||LA8_4=='!'||(LA8_4>='$' && LA8_4<='+')||(LA8_4>='-' && LA8_4<='/')||(LA8_4>=';' && LA8_4<='@')||LA8_4=='\\'||LA8_4=='^'||LA8_4=='`'||(LA8_4>='{' && LA8_4<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 12 :
                        int LA8_20 = input.LA(1);

                        s = -1;
                        if ( ((LA8_20>='0' && LA8_20<='9')||(LA8_20>='A' && LA8_20<='Z')||LA8_20=='_'||(LA8_20>='a' && LA8_20<='z')) ) {s = 20;}

                        else if ( ((LA8_20>='\u0000' && LA8_20<='\b')||(LA8_20>='\u000B' && LA8_20<='\f')||(LA8_20>='\u000E' && LA8_20<='\u001F')||LA8_20=='!'||(LA8_20>='$' && LA8_20<='+')||(LA8_20>='-' && LA8_20<='/')||(LA8_20>=';' && LA8_20<='@')||LA8_20=='\\'||LA8_20=='^'||LA8_20=='`'||(LA8_20>='{' && LA8_20<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 13 :
                        int LA8_27 = input.LA(1);

                        s = -1;
                        if ( (LA8_27=='l') ) {s = 44;}

                        else if ( ((LA8_27>='0' && LA8_27<='9')||(LA8_27>='A' && LA8_27<='Z')||LA8_27=='_'||(LA8_27>='a' && LA8_27<='k')||(LA8_27>='m' && LA8_27<='z')) ) {s = 20;}

                        else if ( ((LA8_27>='\u0000' && LA8_27<='\b')||(LA8_27>='\u000B' && LA8_27<='\f')||(LA8_27>='\u000E' && LA8_27<='\u001F')||LA8_27=='!'||(LA8_27>='$' && LA8_27<='+')||(LA8_27>='-' && LA8_27<='/')||(LA8_27>=';' && LA8_27<='@')||LA8_27=='\\'||LA8_27=='^'||LA8_27=='`'||(LA8_27>='{' && LA8_27<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 14 :
                        int LA8_71 = input.LA(1);

                        s = -1;
                        if ( ((LA8_71>='0' && LA8_71<='9')||(LA8_71>='A' && LA8_71<='Z')||LA8_71=='_'||(LA8_71>='a' && LA8_71<='z')) ) {s = 20;}

                        else if ( ((LA8_71>='\u0000' && LA8_71<='\b')||(LA8_71>='\u000B' && LA8_71<='\f')||(LA8_71>='\u000E' && LA8_71<='\u001F')||LA8_71=='!'||(LA8_71>='$' && LA8_71<='+')||(LA8_71>='-' && LA8_71<='/')||(LA8_71>=';' && LA8_71<='@')||LA8_71=='\\'||LA8_71=='^'||LA8_71=='`'||(LA8_71>='{' && LA8_71<='\uFFFF')) ) {s = 21;}

                        else s = 77;

                        if ( s>=0 ) return s;
                        break;
                    case 15 :
                        int LA8_50 = input.LA(1);

                        s = -1;
                        if ( (LA8_50=='v') ) {s = 57;}

                        else if ( ((LA8_50>='0' && LA8_50<='9')||(LA8_50>='A' && LA8_50<='Z')||LA8_50=='_'||(LA8_50>='a' && LA8_50<='u')||(LA8_50>='w' && LA8_50<='z')) ) {s = 20;}

                        else if ( ((LA8_50>='\u0000' && LA8_50<='\b')||(LA8_50>='\u000B' && LA8_50<='\f')||(LA8_50>='\u000E' && LA8_50<='\u001F')||LA8_50=='!'||(LA8_50>='$' && LA8_50<='+')||(LA8_50>='-' && LA8_50<='/')||(LA8_50>=';' && LA8_50<='@')||LA8_50=='\\'||LA8_50=='^'||LA8_50=='`'||(LA8_50>='{' && LA8_50<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 16 :
                        int LA8_44 = input.LA(1);

                        s = -1;
                        if ( (LA8_44=='C') ) {s = 49;}

                        else if ( (LA8_44=='E') ) {s = 50;}

                        else if ( (LA8_44=='T') ) {s = 51;}

                        else if ( ((LA8_44>='0' && LA8_44<='9')||(LA8_44>='A' && LA8_44<='B')||LA8_44=='D'||(LA8_44>='F' && LA8_44<='S')||(LA8_44>='U' && LA8_44<='Z')||LA8_44=='_'||(LA8_44>='a' && LA8_44<='z')) ) {s = 20;}

                        else if ( ((LA8_44>='\u0000' && LA8_44<='\b')||(LA8_44>='\u000B' && LA8_44<='\f')||(LA8_44>='\u000E' && LA8_44<='\u001F')||LA8_44=='!'||(LA8_44>='$' && LA8_44<='+')||(LA8_44>='-' && LA8_44<='/')||(LA8_44>=';' && LA8_44<='@')||LA8_44=='\\'||LA8_44=='^'||LA8_44=='`'||(LA8_44>='{' && LA8_44<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 17 :
                        int LA8_57 = input.LA(1);

                        s = -1;
                        if ( (LA8_57=='a') ) {s = 64;}

                        else if ( ((LA8_57>='0' && LA8_57<='9')||(LA8_57>='A' && LA8_57<='Z')||LA8_57=='_'||(LA8_57>='b' && LA8_57<='z')) ) {s = 20;}

                        else if ( ((LA8_57>='\u0000' && LA8_57<='\b')||(LA8_57>='\u000B' && LA8_57<='\f')||(LA8_57>='\u000E' && LA8_57<='\u001F')||LA8_57=='!'||(LA8_57>='$' && LA8_57<='+')||(LA8_57>='-' && LA8_57<='/')||(LA8_57>=';' && LA8_57<='@')||LA8_57=='\\'||LA8_57=='^'||LA8_57=='`'||(LA8_57>='{' && LA8_57<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 18 :
                        int LA8_64 = input.LA(1);

                        s = -1;
                        if ( (LA8_64=='l') ) {s = 72;}

                        else if ( ((LA8_64>='0' && LA8_64<='9')||(LA8_64>='A' && LA8_64<='Z')||LA8_64=='_'||(LA8_64>='a' && LA8_64<='k')||(LA8_64>='m' && LA8_64<='z')) ) {s = 20;}

                        else if ( ((LA8_64>='\u0000' && LA8_64<='\b')||(LA8_64>='\u000B' && LA8_64<='\f')||(LA8_64>='\u000E' && LA8_64<='\u001F')||LA8_64=='!'||(LA8_64>='$' && LA8_64<='+')||(LA8_64>='-' && LA8_64<='/')||(LA8_64>=';' && LA8_64<='@')||LA8_64=='\\'||LA8_64=='^'||LA8_64=='`'||(LA8_64>='{' && LA8_64<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 19 :
                        int LA8_0 = input.LA(1);

                        s = -1;
                        if ( (LA8_0=='b') ) {s = 1;}

                        else if ( (LA8_0=='e') ) {s = 2;}

                        else if ( (LA8_0=='f') ) {s = 3;}

                        else if ( (LA8_0=='h') ) {s = 4;}

                        else if ( (LA8_0=='o') ) {s = 5;}

                        else if ( (LA8_0==':') ) {s = 6;}

                        else if ( (LA8_0=='[') ) {s = 7;}

                        else if ( (LA8_0==']') ) {s = 8;}

                        else if ( (LA8_0=='#') ) {s = 9;}

                        else if ( (LA8_0==',') ) {s = 10;}

                        else if ( ((LA8_0>='0' && LA8_0<='9')) ) {s = 11;}

                        else if ( (LA8_0=='\"') ) {s = 12;}

                        else if ( ((LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||LA8_0=='a'||(LA8_0>='c' && LA8_0<='d')||LA8_0=='g'||(LA8_0>='i' && LA8_0<='n')||(LA8_0>='p' && LA8_0<='z')) ) {s = 13;}

                        else if ( (LA8_0=='\\') ) {s = 14;}

                        else if ( ((LA8_0>='\u0000' && LA8_0<='\b')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\u001F')||LA8_0=='!'||(LA8_0>='$' && LA8_0<='+')||(LA8_0>='-' && LA8_0<='/')||(LA8_0>=';' && LA8_0<='@')||LA8_0=='^'||LA8_0=='`'||(LA8_0>='{' && LA8_0<='\uFFFF')) ) {s = 15;}

                        else if ( (LA8_0=='\t'||LA8_0==' ') ) {s = 16;}

                        else if ( (LA8_0=='\n'||LA8_0=='\r') ) {s = 17;}

                        if ( s>=0 ) return s;
                        break;
                    case 20 :
                        int LA8_51 = input.LA(1);

                        s = -1;
                        if ( (LA8_51=='e') ) {s = 58;}

                        else if ( ((LA8_51>='0' && LA8_51<='9')||(LA8_51>='A' && LA8_51<='Z')||LA8_51=='_'||(LA8_51>='a' && LA8_51<='d')||(LA8_51>='f' && LA8_51<='z')) ) {s = 20;}

                        else if ( ((LA8_51>='\u0000' && LA8_51<='\b')||(LA8_51>='\u000B' && LA8_51<='\f')||(LA8_51>='\u000E' && LA8_51<='\u001F')||LA8_51=='!'||(LA8_51>='$' && LA8_51<='+')||(LA8_51>='-' && LA8_51<='/')||(LA8_51>=';' && LA8_51<='@')||LA8_51=='\\'||LA8_51=='^'||LA8_51=='`'||(LA8_51>='{' && LA8_51<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 21 :
                        int LA8_58 = input.LA(1);

                        s = -1;
                        if ( (LA8_58=='x') ) {s = 65;}

                        else if ( ((LA8_58>='0' && LA8_58<='9')||(LA8_58>='A' && LA8_58<='Z')||LA8_58=='_'||(LA8_58>='a' && LA8_58<='w')||(LA8_58>='y' && LA8_58<='z')) ) {s = 20;}

                        else if ( ((LA8_58>='\u0000' && LA8_58<='\b')||(LA8_58>='\u000B' && LA8_58<='\f')||(LA8_58>='\u000E' && LA8_58<='\u001F')||LA8_58=='!'||(LA8_58>='$' && LA8_58<='+')||(LA8_58>='-' && LA8_58<='/')||(LA8_58>=';' && LA8_58<='@')||LA8_58=='\\'||LA8_58=='^'||LA8_58=='`'||(LA8_58>='{' && LA8_58<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 22 :
                        int LA8_60 = input.LA(1);

                        s = -1;
                        if ( (LA8_60=='R') ) {s = 67;}

                        else if ( ((LA8_60>='0' && LA8_60<='9')||(LA8_60>='A' && LA8_60<='Q')||(LA8_60>='S' && LA8_60<='Z')||LA8_60=='_'||(LA8_60>='a' && LA8_60<='z')) ) {s = 20;}

                        else if ( ((LA8_60>='\u0000' && LA8_60<='\b')||(LA8_60>='\u000B' && LA8_60<='\f')||(LA8_60>='\u000E' && LA8_60<='\u001F')||LA8_60=='!'||(LA8_60>='$' && LA8_60<='+')||(LA8_60>='-' && LA8_60<='/')||(LA8_60>=';' && LA8_60<='@')||LA8_60=='\\'||LA8_60=='^'||LA8_60=='`'||(LA8_60>='{' && LA8_60<='\uFFFF')) ) {s = 21;}

                        else s = 68;

                        if ( s>=0 ) return s;
                        break;
                    case 23 :
                        int LA8_65 = input.LA(1);

                        s = -1;
                        if ( (LA8_65=='t') ) {s = 73;}

                        else if ( ((LA8_65>='0' && LA8_65<='9')||(LA8_65>='A' && LA8_65<='Z')||LA8_65=='_'||(LA8_65>='a' && LA8_65<='s')||(LA8_65>='u' && LA8_65<='z')) ) {s = 20;}

                        else if ( ((LA8_65>='\u0000' && LA8_65<='\b')||(LA8_65>='\u000B' && LA8_65<='\f')||(LA8_65>='\u000E' && LA8_65<='\u001F')||LA8_65=='!'||(LA8_65>='$' && LA8_65<='+')||(LA8_65>='-' && LA8_65<='/')||(LA8_65>=';' && LA8_65<='@')||LA8_65=='\\'||LA8_65=='^'||LA8_65=='`'||(LA8_65>='{' && LA8_65<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 24 :
                        int LA8_5 = input.LA(1);

                        s = -1;
                        if ( (LA8_5=='c') ) {s = 27;}

                        else if ( ((LA8_5>='0' && LA8_5<='9')||(LA8_5>='A' && LA8_5<='Z')||LA8_5=='_'||(LA8_5>='a' && LA8_5<='b')||(LA8_5>='d' && LA8_5<='z')) ) {s = 20;}

                        else if ( ((LA8_5>='\u0000' && LA8_5<='\b')||(LA8_5>='\u000B' && LA8_5<='\f')||(LA8_5>='\u000E' && LA8_5<='\u001F')||LA8_5=='!'||(LA8_5>='$' && LA8_5<='+')||(LA8_5>='-' && LA8_5<='/')||(LA8_5>=';' && LA8_5<='@')||LA8_5=='\\'||LA8_5=='^'||LA8_5=='`'||(LA8_5>='{' && LA8_5<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 25 :
                        int LA8_3 = input.LA(1);

                        s = -1;
                        if ( (LA8_3=='i') ) {s = 23;}

                        else if ( (LA8_3=='o') ) {s = 24;}

                        else if ( ((LA8_3>='0' && LA8_3<='9')||(LA8_3>='A' && LA8_3<='Z')||LA8_3=='_'||(LA8_3>='a' && LA8_3<='h')||(LA8_3>='j' && LA8_3<='n')||(LA8_3>='p' && LA8_3<='z')) ) {s = 20;}

                        else if ( ((LA8_3>='\u0000' && LA8_3<='\b')||(LA8_3>='\u000B' && LA8_3<='\f')||(LA8_3>='\u000E' && LA8_3<='\u001F')||LA8_3=='!'||(LA8_3>='$' && LA8_3<='+')||(LA8_3>='-' && LA8_3<='/')||(LA8_3>=';' && LA8_3<='@')||LA8_3=='\\'||LA8_3=='^'||LA8_3=='`'||(LA8_3>='{' && LA8_3<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 26 :
                        int LA8_72 = input.LA(1);

                        s = -1;
                        if ( ((LA8_72>='0' && LA8_72<='9')||(LA8_72>='A' && LA8_72<='Z')||LA8_72=='_'||(LA8_72>='a' && LA8_72<='z')) ) {s = 20;}

                        else if ( ((LA8_72>='\u0000' && LA8_72<='\b')||(LA8_72>='\u000B' && LA8_72<='\f')||(LA8_72>='\u000E' && LA8_72<='\u001F')||LA8_72=='!'||(LA8_72>='$' && LA8_72<='+')||(LA8_72>='-' && LA8_72<='/')||(LA8_72>=';' && LA8_72<='@')||LA8_72=='\\'||LA8_72=='^'||LA8_72=='`'||(LA8_72>='{' && LA8_72<='\uFFFF')) ) {s = 21;}

                        else s = 78;

                        if ( s>=0 ) return s;
                        break;
                    case 27 :
                        int LA8_13 = input.LA(1);

                        s = -1;
                        if ( ((LA8_13>='0' && LA8_13<='9')||(LA8_13>='A' && LA8_13<='Z')||LA8_13=='_'||(LA8_13>='a' && LA8_13<='z')) ) {s = 20;}

                        else if ( ((LA8_13>='\u0000' && LA8_13<='\b')||(LA8_13>='\u000B' && LA8_13<='\f')||(LA8_13>='\u000E' && LA8_13<='\u001F')||LA8_13=='!'||(LA8_13>='$' && LA8_13<='+')||(LA8_13>='-' && LA8_13<='/')||(LA8_13>=';' && LA8_13<='@')||LA8_13=='\\'||LA8_13=='^'||LA8_13=='`'||(LA8_13>='{' && LA8_13<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 28 :
                        int LA8_23 = input.LA(1);

                        s = -1;
                        if ( (LA8_23=='g') ) {s = 41;}

                        else if ( ((LA8_23>='0' && LA8_23<='9')||(LA8_23>='A' && LA8_23<='Z')||LA8_23=='_'||(LA8_23>='a' && LA8_23<='f')||(LA8_23>='h' && LA8_23<='z')) ) {s = 20;}

                        else if ( ((LA8_23>='\u0000' && LA8_23<='\b')||(LA8_23>='\u000B' && LA8_23<='\f')||(LA8_23>='\u000E' && LA8_23<='\u001F')||LA8_23=='!'||(LA8_23>='$' && LA8_23<='+')||(LA8_23>='-' && LA8_23<='/')||(LA8_23>=';' && LA8_23<='@')||LA8_23=='\\'||LA8_23=='^'||LA8_23=='`'||(LA8_23>='{' && LA8_23<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 29 :
                        int LA8_41 = input.LA(1);

                        s = -1;
                        if ( (LA8_41=='u') ) {s = 46;}

                        else if ( ((LA8_41>='0' && LA8_41<='9')||(LA8_41>='A' && LA8_41<='Z')||LA8_41=='_'||(LA8_41>='a' && LA8_41<='t')||(LA8_41>='v' && LA8_41<='z')) ) {s = 20;}

                        else if ( ((LA8_41>='\u0000' && LA8_41<='\b')||(LA8_41>='\u000B' && LA8_41<='\f')||(LA8_41>='\u000E' && LA8_41<='\u001F')||LA8_41=='!'||(LA8_41>='$' && LA8_41<='+')||(LA8_41>='-' && LA8_41<='/')||(LA8_41>=';' && LA8_41<='@')||LA8_41=='\\'||LA8_41=='^'||LA8_41=='`'||(LA8_41>='{' && LA8_41<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 30 :
                        int LA8_59 = input.LA(1);

                        s = -1;
                        if ( ((LA8_59>='0' && LA8_59<='9')||(LA8_59>='A' && LA8_59<='Z')||LA8_59=='_'||(LA8_59>='a' && LA8_59<='z')) ) {s = 20;}

                        else if ( ((LA8_59>='\u0000' && LA8_59<='\b')||(LA8_59>='\u000B' && LA8_59<='\f')||(LA8_59>='\u000E' && LA8_59<='\u001F')||LA8_59=='!'||(LA8_59>='$' && LA8_59<='+')||(LA8_59>='-' && LA8_59<='/')||(LA8_59>=';' && LA8_59<='@')||LA8_59=='\\'||LA8_59=='^'||LA8_59=='`'||(LA8_59>='{' && LA8_59<='\uFFFF')) ) {s = 21;}

                        else s = 66;

                        if ( s>=0 ) return s;
                        break;
                    case 31 :
                        int LA8_73 = input.LA(1);

                        s = -1;
                        if ( ((LA8_73>='0' && LA8_73<='9')||(LA8_73>='A' && LA8_73<='Z')||LA8_73=='_'||(LA8_73>='a' && LA8_73<='z')) ) {s = 20;}

                        else if ( ((LA8_73>='\u0000' && LA8_73<='\b')||(LA8_73>='\u000B' && LA8_73<='\f')||(LA8_73>='\u000E' && LA8_73<='\u001F')||LA8_73=='!'||(LA8_73>='$' && LA8_73<='+')||(LA8_73>='-' && LA8_73<='/')||(LA8_73>=';' && LA8_73<='@')||LA8_73=='\\'||LA8_73=='^'||LA8_73=='`'||(LA8_73>='{' && LA8_73<='\uFFFF')) ) {s = 21;}

                        else s = 79;

                        if ( s>=0 ) return s;
                        break;
                    case 32 :
                        int LA8_46 = input.LA(1);

                        s = -1;
                        if ( (LA8_46=='r') ) {s = 53;}

                        else if ( ((LA8_46>='0' && LA8_46<='9')||(LA8_46>='A' && LA8_46<='Z')||LA8_46=='_'||(LA8_46>='a' && LA8_46<='q')||(LA8_46>='s' && LA8_46<='z')) ) {s = 20;}

                        else if ( ((LA8_46>='\u0000' && LA8_46<='\b')||(LA8_46>='\u000B' && LA8_46<='\f')||(LA8_46>='\u000E' && LA8_46<='\u001F')||LA8_46=='!'||(LA8_46>='$' && LA8_46<='+')||(LA8_46>='-' && LA8_46<='/')||(LA8_46>=';' && LA8_46<='@')||LA8_46=='\\'||LA8_46=='^'||LA8_46=='`'||(LA8_46>='{' && LA8_46<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 33 :
                        int LA8_2 = input.LA(1);

                        s = -1;
                        if ( ((LA8_2>='0' && LA8_2<='9')||(LA8_2>='A' && LA8_2<='Z')||LA8_2=='_'||(LA8_2>='a' && LA8_2<='z')) ) {s = 20;}

                        else if ( ((LA8_2>='\u0000' && LA8_2<='\b')||(LA8_2>='\u000B' && LA8_2<='\f')||(LA8_2>='\u000E' && LA8_2<='\u001F')||LA8_2=='!'||(LA8_2>='$' && LA8_2<='+')||(LA8_2>='-' && LA8_2<='/')||(LA8_2>=';' && LA8_2<='@')||LA8_2=='\\'||LA8_2=='^'||LA8_2=='`'||(LA8_2>='{' && LA8_2<='\uFFFF')) ) {s = 21;}

                        else s = 22;

                        if ( s>=0 ) return s;
                        break;
                    case 34 :
                        int LA8_53 = input.LA(1);

                        s = -1;
                        if ( (LA8_53=='e') ) {s = 60;}

                        else if ( ((LA8_53>='0' && LA8_53<='9')||(LA8_53>='A' && LA8_53<='Z')||LA8_53=='_'||(LA8_53>='a' && LA8_53<='d')||(LA8_53>='f' && LA8_53<='z')) ) {s = 20;}

                        else if ( ((LA8_53>='\u0000' && LA8_53<='\b')||(LA8_53>='\u000B' && LA8_53<='\f')||(LA8_53>='\u000E' && LA8_53<='\u001F')||LA8_53=='!'||(LA8_53>='$' && LA8_53<='+')||(LA8_53>='-' && LA8_53<='/')||(LA8_53>=';' && LA8_53<='@')||LA8_53=='\\'||LA8_53=='^'||LA8_53=='`'||(LA8_53>='{' && LA8_53<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 35 :
                        int LA8_12 = input.LA(1);

                        s = -1;
                        if ( ((LA8_12>='\u0000' && LA8_12<='\uFFFF')) ) {s = 35;}

                        else s = 36;

                        if ( s>=0 ) return s;
                        break;
                    case 36 :
                        int LA8_18 = input.LA(1);

                        s = -1;
                        if ( (LA8_18=='l') ) {s = 40;}

                        else if ( ((LA8_18>='0' && LA8_18<='9')||(LA8_18>='A' && LA8_18<='Z')||LA8_18=='_'||(LA8_18>='a' && LA8_18<='k')||(LA8_18>='m' && LA8_18<='z')) ) {s = 20;}

                        else if ( ((LA8_18>='\u0000' && LA8_18<='\b')||(LA8_18>='\u000B' && LA8_18<='\f')||(LA8_18>='\u000E' && LA8_18<='\u001F')||LA8_18=='!'||(LA8_18>='$' && LA8_18<='+')||(LA8_18>='-' && LA8_18<='/')||(LA8_18>=';' && LA8_18<='@')||LA8_18=='\\'||LA8_18=='^'||LA8_18=='`'||(LA8_18>='{' && LA8_18<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 37 :
                        int LA8_40 = input.LA(1);

                        s = -1;
                        if ( (LA8_40=='l') ) {s = 45;}

                        else if ( ((LA8_40>='0' && LA8_40<='9')||(LA8_40>='A' && LA8_40<='Z')||LA8_40=='_'||(LA8_40>='a' && LA8_40<='k')||(LA8_40>='m' && LA8_40<='z')) ) {s = 20;}

                        else if ( ((LA8_40>='\u0000' && LA8_40<='\b')||(LA8_40>='\u000B' && LA8_40<='\f')||(LA8_40>='\u000E' && LA8_40<='\u001F')||LA8_40=='!'||(LA8_40>='$' && LA8_40<='+')||(LA8_40>='-' && LA8_40<='/')||(LA8_40>=';' && LA8_40<='@')||LA8_40=='\\'||LA8_40=='^'||LA8_40=='`'||(LA8_40>='{' && LA8_40<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 38 :
                        int LA8_34 = input.LA(1);

                        s = -1;
                        if ( ((LA8_34>='0' && LA8_34<='9')) ) {s = 34;}

                        else if ( ((LA8_34>='\u0000' && LA8_34<='\b')||(LA8_34>='\u000B' && LA8_34<='\f')||(LA8_34>='\u000E' && LA8_34<='\u001F')||LA8_34=='!'||(LA8_34>='$' && LA8_34<='+')||(LA8_34>='-' && LA8_34<='/')||(LA8_34>=';' && LA8_34<='Z')||LA8_34=='\\'||(LA8_34>='^' && LA8_34<='\uFFFF')) ) {s = 21;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 39 :
                        int LA8_45 = input.LA(1);

                        s = -1;
                        if ( (LA8_45=='e') ) {s = 52;}

                        else if ( ((LA8_45>='0' && LA8_45<='9')||(LA8_45>='A' && LA8_45<='Z')||LA8_45=='_'||(LA8_45>='a' && LA8_45<='d')||(LA8_45>='f' && LA8_45<='z')) ) {s = 20;}

                        else if ( ((LA8_45>='\u0000' && LA8_45<='\b')||(LA8_45>='\u000B' && LA8_45<='\f')||(LA8_45>='\u000E' && LA8_45<='\u001F')||LA8_45=='!'||(LA8_45>='$' && LA8_45<='+')||(LA8_45>='-' && LA8_45<='/')||(LA8_45>=';' && LA8_45<='@')||LA8_45=='\\'||LA8_45=='^'||LA8_45=='`'||(LA8_45>='{' && LA8_45<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 40 :
                        int LA8_52 = input.LA(1);

                        s = -1;
                        if ( (LA8_52=='t') ) {s = 59;}

                        else if ( ((LA8_52>='0' && LA8_52<='9')||(LA8_52>='A' && LA8_52<='Z')||LA8_52=='_'||(LA8_52>='a' && LA8_52<='s')||(LA8_52>='u' && LA8_52<='z')) ) {s = 20;}

                        else if ( ((LA8_52>='\u0000' && LA8_52<='\b')||(LA8_52>='\u000B' && LA8_52<='\f')||(LA8_52>='\u000E' && LA8_52<='\u001F')||LA8_52=='!'||(LA8_52>='$' && LA8_52<='+')||(LA8_52>='-' && LA8_52<='/')||(LA8_52>=';' && LA8_52<='@')||LA8_52=='\\'||LA8_52=='^'||LA8_52=='`'||(LA8_52>='{' && LA8_52<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 41 :
                        int LA8_80 = input.LA(1);

                        s = -1;
                        if ( ((LA8_80>='0' && LA8_80<='9')||(LA8_80>='A' && LA8_80<='Z')||LA8_80=='_'||(LA8_80>='a' && LA8_80<='z')) ) {s = 20;}

                        else if ( ((LA8_80>='\u0000' && LA8_80<='\b')||(LA8_80>='\u000B' && LA8_80<='\f')||(LA8_80>='\u000E' && LA8_80<='\u001F')||LA8_80=='!'||(LA8_80>='$' && LA8_80<='+')||(LA8_80>='-' && LA8_80<='/')||(LA8_80>=';' && LA8_80<='@')||LA8_80=='\\'||LA8_80=='^'||LA8_80=='`'||(LA8_80>='{' && LA8_80<='\uFFFF')) ) {s = 21;}

                        else s = 82;

                        if ( s>=0 ) return s;
                        break;
                    case 42 :
                        int LA8_11 = input.LA(1);

                        s = -1;
                        if ( ((LA8_11>='0' && LA8_11<='9')) ) {s = 34;}

                        else if ( ((LA8_11>='\u0000' && LA8_11<='\b')||(LA8_11>='\u000B' && LA8_11<='\f')||(LA8_11>='\u000E' && LA8_11<='\u001F')||LA8_11=='!'||(LA8_11>='$' && LA8_11<='+')||(LA8_11>='-' && LA8_11<='/')||(LA8_11>=';' && LA8_11<='Z')||LA8_11=='\\'||(LA8_11>='^' && LA8_11<='\uFFFF')) ) {s = 21;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 43 :
                        int LA8_67 = input.LA(1);

                        s = -1;
                        if ( (LA8_67=='e') ) {s = 74;}

                        else if ( ((LA8_67>='0' && LA8_67<='9')||(LA8_67>='A' && LA8_67<='Z')||LA8_67=='_'||(LA8_67>='a' && LA8_67<='d')||(LA8_67>='f' && LA8_67<='z')) ) {s = 20;}

                        else if ( ((LA8_67>='\u0000' && LA8_67<='\b')||(LA8_67>='\u000B' && LA8_67<='\f')||(LA8_67>='\u000E' && LA8_67<='\u001F')||LA8_67=='!'||(LA8_67>='$' && LA8_67<='+')||(LA8_67>='-' && LA8_67<='/')||(LA8_67>=';' && LA8_67<='@')||LA8_67=='\\'||LA8_67=='^'||LA8_67=='`'||(LA8_67>='{' && LA8_67<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 44 :
                        int LA8_74 = input.LA(1);

                        s = -1;
                        if ( (LA8_74=='f') ) {s = 80;}

                        else if ( ((LA8_74>='0' && LA8_74<='9')||(LA8_74>='A' && LA8_74<='Z')||LA8_74=='_'||(LA8_74>='a' && LA8_74<='e')||(LA8_74>='g' && LA8_74<='z')) ) {s = 20;}

                        else if ( ((LA8_74>='\u0000' && LA8_74<='\b')||(LA8_74>='\u000B' && LA8_74<='\f')||(LA8_74>='\u000E' && LA8_74<='\u001F')||LA8_74=='!'||(LA8_74>='$' && LA8_74<='+')||(LA8_74>='-' && LA8_74<='/')||(LA8_74>=';' && LA8_74<='@')||LA8_74=='\\'||LA8_74=='^'||LA8_74=='`'||(LA8_74>='{' && LA8_74<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 45 :
                        int LA8_1 = input.LA(1);

                        s = -1;
                        if ( (LA8_1=='u') ) {s = 18;}

                        else if ( ((LA8_1>='0' && LA8_1<='9')||(LA8_1>='A' && LA8_1<='Z')||LA8_1=='_'||(LA8_1>='a' && LA8_1<='t')||(LA8_1>='v' && LA8_1<='z')) ) {s = 20;}

                        else if ( ((LA8_1>='\u0000' && LA8_1<='\b')||(LA8_1>='\u000B' && LA8_1<='\f')||(LA8_1>='\u000E' && LA8_1<='\u001F')||LA8_1=='!'||(LA8_1>='$' && LA8_1<='+')||(LA8_1>='-' && LA8_1<='/')||(LA8_1>=';' && LA8_1<='@')||LA8_1=='\\'||LA8_1=='^'||LA8_1=='`'||(LA8_1>='{' && LA8_1<='\uFFFF')) ) {s = 21;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 46 :
                        int LA8_75 = input.LA(1);

                        s = -1;
                        if ( ((LA8_75>='0' && LA8_75<='9')||(LA8_75>='A' && LA8_75<='Z')||LA8_75=='_'||(LA8_75>='a' && LA8_75<='z')) ) {s = 20;}

                        else if ( ((LA8_75>='\u0000' && LA8_75<='\b')||(LA8_75>='\u000B' && LA8_75<='\f')||(LA8_75>='\u000E' && LA8_75<='\u001F')||LA8_75=='!'||(LA8_75>='$' && LA8_75<='+')||(LA8_75>='-' && LA8_75<='/')||(LA8_75>=';' && LA8_75<='@')||LA8_75=='\\'||LA8_75=='^'||LA8_75=='`'||(LA8_75>='{' && LA8_75<='\uFFFF')) ) {s = 21;}

                        else s = 81;

                        if ( s>=0 ) return s;
                        break;
                    case 47 :
                        int LA8_24 = input.LA(1);

                        s = -1;
                        if ( (LA8_24=='o') ) {s = 42;}

                        else if ( ((LA8_24>='0' && LA8_24<='9')||(LA8_24>='A' && LA8_24<='Z')||LA8_24=='_'||(LA8_24>='a' && LA8_24<='n')||(LA8_24>='p' && LA8_24<='z')) ) {s = 20;}

                        else if ( ((LA8_24>='\u0000' && LA8_24<='\b')||(LA8_24>='\u000B' && LA8_24<='\f')||(LA8_24>='\u000E' && LA8_24<='\u001F')||LA8_24=='!'||(LA8_24>='$' && LA8_24<='+')||(LA8_24>='-' && LA8_24<='/')||(LA8_24>=';' && LA8_24<='@')||LA8_24=='\\'||LA8_24=='^'||LA8_24=='`'||(LA8_24>='{' && LA8_24<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 48 :
                        int LA8_42 = input.LA(1);

                        s = -1;
                        if ( (LA8_42=='t') ) {s = 47;}

                        else if ( ((LA8_42>='0' && LA8_42<='9')||(LA8_42>='A' && LA8_42<='Z')||LA8_42=='_'||(LA8_42>='a' && LA8_42<='s')||(LA8_42>='u' && LA8_42<='z')) ) {s = 20;}

                        else if ( ((LA8_42>='\u0000' && LA8_42<='\b')||(LA8_42>='\u000B' && LA8_42<='\f')||(LA8_42>='\u000E' && LA8_42<='\u001F')||LA8_42=='!'||(LA8_42>='$' && LA8_42<='+')||(LA8_42>='-' && LA8_42<='/')||(LA8_42>=';' && LA8_42<='@')||LA8_42=='\\'||LA8_42=='^'||LA8_42=='`'||(LA8_42>='{' && LA8_42<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 49 :
                        int LA8_47 = input.LA(1);

                        s = -1;
                        if ( (LA8_47=='n') ) {s = 54;}

                        else if ( ((LA8_47>='0' && LA8_47<='9')||(LA8_47>='A' && LA8_47<='Z')||LA8_47=='_'||(LA8_47>='a' && LA8_47<='m')||(LA8_47>='o' && LA8_47<='z')) ) {s = 20;}

                        else if ( ((LA8_47>='\u0000' && LA8_47<='\b')||(LA8_47>='\u000B' && LA8_47<='\f')||(LA8_47>='\u000E' && LA8_47<='\u001F')||LA8_47=='!'||(LA8_47>='$' && LA8_47<='+')||(LA8_47>='-' && LA8_47<='/')||(LA8_47>=';' && LA8_47<='@')||LA8_47=='\\'||LA8_47=='^'||LA8_47=='`'||(LA8_47>='{' && LA8_47<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 50 :
                        int LA8_54 = input.LA(1);

                        s = -1;
                        if ( (LA8_54=='o') ) {s = 61;}

                        else if ( ((LA8_54>='0' && LA8_54<='9')||(LA8_54>='A' && LA8_54<='Z')||LA8_54=='_'||(LA8_54>='a' && LA8_54<='n')||(LA8_54>='p' && LA8_54<='z')) ) {s = 20;}

                        else if ( ((LA8_54>='\u0000' && LA8_54<='\b')||(LA8_54>='\u000B' && LA8_54<='\f')||(LA8_54>='\u000E' && LA8_54<='\u001F')||LA8_54=='!'||(LA8_54>='$' && LA8_54<='+')||(LA8_54>='-' && LA8_54<='/')||(LA8_54>=';' && LA8_54<='@')||LA8_54=='\\'||LA8_54=='^'||LA8_54=='`'||(LA8_54>='{' && LA8_54<='\uFFFF')) ) {s = 21;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }


}