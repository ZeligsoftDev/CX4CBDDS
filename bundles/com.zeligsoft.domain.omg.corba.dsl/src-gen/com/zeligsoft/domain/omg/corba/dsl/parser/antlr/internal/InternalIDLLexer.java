package com.zeligsoft.domain.omg.corba.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIDLLexer extends Lexer {
    public static final int T__143=143;
    public static final int T__50=50;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int RULE_HEX_LITERAL=6;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=5;
    public static final int RULE_BOOLEAN_LITERAL=10;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INTEGER_LITERAL=9;
    public static final int T__66=66;
    public static final int RULE_OCTAL_ESCAPE=15;
    public static final int RULE_ML_COMMENT=17;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int RULE_UNICODE_ESCAPE=16;
    public static final int T__37=37;
    public static final int RULE_FLOATING_PT_LITERAL=8;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_CHARACTER_LITERAL=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__99=99;
    public static final int RULE_HEX_ESCAPE=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_ESCAPE_SEQUENCE=13;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int RULE_UNUSED_LITERAL=12;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=18;
    public static final int RULE_ANY_OTHER=19;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators

    public InternalIDLLexer() {;} 
    public InternalIDLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalIDLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g"; }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11:7: ( '#include' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11:9: '#include'
            {
            match("#include"); 


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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:12:7: ( '<' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:12:9: '<'
            {
            match('<'); 

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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:13:7: ( '>' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:13:9: '>'
            {
            match('>'); 

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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:14:7: ( '.' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:14:9: '.'
            {
            match('.'); 

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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:15:7: ( '#ifdef' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:15:9: '#ifdef'
            {
            match("#ifdef"); 


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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:16:7: ( '#ifndef' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:16:9: '#ifndef'
            {
            match("#ifndef"); 


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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:17:7: ( '#undef' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:17:9: '#undef'
            {
            match("#undef"); 


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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:18:7: ( '#if' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:18:9: '#if'
            {
            match("#if"); 


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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:19:7: ( '#elif' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:19:9: '#elif'
            {
            match("#elif"); 


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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:20:7: ( '!' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:20:9: '!'
            {
            match('!'); 

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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:21:7: ( 'defined' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:21:9: 'defined'
            {
            match("defined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:22:7: ( '==' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:22:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:23:7: ( '!=' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:23:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:24:7: ( '>=' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:24:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:25:7: ( '<=' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:25:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:26:7: ( '#else' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:26:9: '#else'
            {
            match("#else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:27:7: ( '#error' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:27:9: '#error'
            {
            match("#error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:28:7: ( '#define ' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:28:9: '#define '
            {
            match("#define "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:29:7: ( '#endif' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:29:9: '#endif'
            {
            match("#endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:30:7: ( '#pragma' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:30:9: '#pragma'
            {
            match("#pragma"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:31:7: ( 'prefix' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:31:9: 'prefix'
            {
            match("prefix"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:32:7: ( 'conntype' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:32:9: 'conntype'
            {
            match("conntype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:33:7: ( '::' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:33:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:34:7: ( 'ciao' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:34:9: 'ciao'
            {
            match("ciao"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:35:7: ( 'lem' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:35:9: 'lem'
            {
            match("lem"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:36:7: ( 'ami4ccm interface' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:36:9: 'ami4ccm interface'
            {
            match("ami4ccm interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:37:7: ( 'ami4ccm receptacle' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:37:9: 'ami4ccm receptacle'
            {
            match("ami4ccm receptacle"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:38:7: ( 'ami4ccm idl' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:38:9: 'ami4ccm idl'
            {
            match("ami4ccm idl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:39:7: ( 'ndds' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:39:9: 'ndds'
            {
            match("ndds"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:40:7: ( 'typesupport' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:40:9: 'typesupport'
            {
            match("typesupport"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:41:7: ( 'componentInterface' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:41:9: 'componentInterface'
            {
            match("componentInterface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:42:7: ( 'componentHome' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:42:9: 'componentHome'
            {
            match("componentHome"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:43:7: ( 'dds4ccm' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:43:9: 'dds4ccm'
            {
            match("dds4ccm"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:44:7: ( 'impl' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:44:9: 'impl'
            {
            match("impl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:45:7: ( '#file' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:45:9: '#file'
            {
            match("#file"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:46:7: ( '#excluded_file' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:46:9: '#excluded_file'
            {
            match("#excluded_file"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:47:7: ( 'import' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:47:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:48:7: ( ';' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:48:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:49:7: ( 'module' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:49:9: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:50:7: ( '{' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:50:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:51:7: ( '}' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:51:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:52:7: ( 'abstract' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:52:9: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:53:7: ( 'local' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:53:9: 'local'
            {
            match("local"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:54:7: ( 'interface' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:54:9: 'interface'
            {
            match("interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:55:7: ( ':' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:55:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:56:7: ( ',' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:56:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:57:7: ( 'attribute' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:57:9: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:58:7: ( 'getraises' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:58:9: 'getraises'
            {
            match("getraises"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:59:7: ( 'setraises' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:59:9: 'setraises'
            {
            match("setraises"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:60:7: ( 'readonly' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:60:9: 'readonly'
            {
            match("readonly"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:61:7: ( 'raises' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:61:9: 'raises'
            {
            match("raises"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:62:7: ( '(' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:62:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:63:7: ( ')' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:63:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:64:7: ( 'oneway' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:64:9: 'oneway'
            {
            match("oneway"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:65:7: ( 'void' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:65:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:66:7: ( 'context' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:66:9: 'context'
            {
            match("context"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:67:7: ( 'float' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:67:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:68:7: ( 'double' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:68:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:69:7: ( 'long' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:69:9: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:70:7: ( 'short' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:70:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:71:7: ( 'unsigned' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:71:9: 'unsigned'
            {
            match("unsigned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:72:7: ( 'char' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:72:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:73:7: ( 'wchar' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:73:9: 'wchar'
            {
            match("wchar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:74:7: ( 'boolean' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:74:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:75:7: ( 'octet' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:75:9: 'octet'
            {
            match("octet"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:76:7: ( 'any' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:76:9: 'any'
            {
            match("any"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:77:7: ( 'Object' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:77:9: 'Object'
            {
            match("Object"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:78:7: ( 'ValueBase' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:78:9: 'ValueBase'
            {
            match("ValueBase"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:79:7: ( 'string' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:79:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:80:7: ( 'wstring' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:80:9: 'wstring'
            {
            match("wstring"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:81:7: ( 'exception' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:81:9: 'exception'
            {
            match("exception"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:82:7: ( '[' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:82:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:83:7: ( ']' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:83:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:84:7: ( 'struct' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:84:9: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:85:7: ( 'typedef' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:85:9: 'typedef'
            {
            match("typedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:86:7: ( 'union' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:86:9: 'union'
            {
            match("union"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:87:7: ( 'switch' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:87:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:88:7: ( 'case' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:88:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:89:7: ( 'default' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:89:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:90:7: ( 'enum' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:90:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:91:8: ( 'sequence' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:91:10: 'sequence'
            {
            match("sequence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:92:8: ( 'native' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:92:10: 'native'
            {
            match("native"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:93:8: ( 'fixed' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:93:10: 'fixed'
            {
            match("fixed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:94:8: ( 'const' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:94:10: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:95:8: ( '=' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:95:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:96:8: ( '|' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:96:10: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:97:8: ( '^' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:97:10: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:98:8: ( '&' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:98:10: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:99:8: ( '<<' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:99:10: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:100:8: ( '>>' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:100:10: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:101:8: ( '+' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:101:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:102:8: ( '-' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:102:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:103:8: ( '*' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:103:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:104:8: ( '/' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:104:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:105:8: ( '%' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:105:10: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:106:8: ( '~' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:106:10: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:107:8: ( 'component' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:107:10: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:108:8: ( 'supports' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:108:10: 'supports'
            {
            match("supports"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:109:8: ( 'provides' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:109:10: 'provides'
            {
            match("provides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:110:8: ( 'uses' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:110:10: 'uses'
            {
            match("uses"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:111:8: ( 'multiple' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:111:10: 'multiple'
            {
            match("multiple"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:112:8: ( 'publishes' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:112:10: 'publishes'
            {
            match("publishes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:113:8: ( 'emits' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:113:10: 'emits'
            {
            match("emits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:114:8: ( 'consumes' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:114:10: 'consumes'
            {
            match("consumes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "T__124"
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:115:8: ( 'home' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:115:10: 'home'
            {
            match("home"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__124"

    // $ANTLR start "T__125"
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:116:8: ( 'manages' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:116:10: 'manages'
            {
            match("manages"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__125"

    // $ANTLR start "T__126"
    public final void mT__126() throws RecognitionException {
        try {
            int _type = T__126;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:117:8: ( 'primarykey' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:117:10: 'primarykey'
            {
            match("primarykey"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__126"

    // $ANTLR start "T__127"
    public final void mT__127() throws RecognitionException {
        try {
            int _type = T__127;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:118:8: ( 'factory' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:118:10: 'factory'
            {
            match("factory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__127"

    // $ANTLR start "T__128"
    public final void mT__128() throws RecognitionException {
        try {
            int _type = T__128;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:119:8: ( 'finder' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:119:10: 'finder'
            {
            match("finder"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__128"

    // $ANTLR start "T__129"
    public final void mT__129() throws RecognitionException {
        try {
            int _type = T__129;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:120:8: ( 'custom' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:120:10: 'custom'
            {
            match("custom"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__129"

    // $ANTLR start "T__130"
    public final void mT__130() throws RecognitionException {
        try {
            int _type = T__130;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:121:8: ( 'eventtype' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:121:10: 'eventtype'
            {
            match("eventtype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__130"

    // $ANTLR start "T__131"
    public final void mT__131() throws RecognitionException {
        try {
            int _type = T__131;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:122:8: ( 'truncatable' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:122:10: 'truncatable'
            {
            match("truncatable"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__131"

    // $ANTLR start "T__132"
    public final void mT__132() throws RecognitionException {
        try {
            int _type = T__132;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:123:8: ( 'public' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:123:10: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__132"

    // $ANTLR start "T__133"
    public final void mT__133() throws RecognitionException {
        try {
            int _type = T__133;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:124:8: ( 'private' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:124:10: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__133"

    // $ANTLR start "T__134"
    public final void mT__134() throws RecognitionException {
        try {
            int _type = T__134;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:125:8: ( 'porttype' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:125:10: 'porttype'
            {
            match("porttype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__134"

    // $ANTLR start "T__135"
    public final void mT__135() throws RecognitionException {
        try {
            int _type = T__135;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:126:8: ( 'port' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:126:10: 'port'
            {
            match("port"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__135"

    // $ANTLR start "T__136"
    public final void mT__136() throws RecognitionException {
        try {
            int _type = T__136;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:127:8: ( 'mirrorport' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:127:10: 'mirrorport'
            {
            match("mirrorport"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__136"

    // $ANTLR start "T__137"
    public final void mT__137() throws RecognitionException {
        try {
            int _type = T__137;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:128:8: ( 'connector' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:128:10: 'connector'
            {
            match("connector"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__137"

    // $ANTLR start "T__138"
    public final void mT__138() throws RecognitionException {
        try {
            int _type = T__138;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:129:8: ( 'typename' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:129:10: 'typename'
            {
            match("typename"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__138"

    // $ANTLR start "T__139"
    public final void mT__139() throws RecognitionException {
        try {
            int _type = T__139;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:130:8: ( 'valuetype' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:130:10: 'valuetype'
            {
            match("valuetype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__139"

    // $ANTLR start "T__140"
    public final void mT__140() throws RecognitionException {
        try {
            int _type = T__140;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:131:8: ( 'alias' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:131:10: 'alias'
            {
            match("alias"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__140"

    // $ANTLR start "T__141"
    public final void mT__141() throws RecognitionException {
        try {
            int _type = T__141;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:132:8: ( 'in' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:132:10: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__141"

    // $ANTLR start "T__142"
    public final void mT__142() throws RecognitionException {
        try {
            int _type = T__142;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:133:8: ( 'out' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:133:10: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__142"

    // $ANTLR start "T__143"
    public final void mT__143() throws RecognitionException {
        try {
            int _type = T__143;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:134:8: ( 'inout' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:134:10: 'inout'
            {
            match("inout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__143"

    // $ANTLR start "RULE_UNUSED_LITERAL"
    public final void mRULE_UNUSED_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_UNUSED_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11709:21: ( '(\\'?\\')' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11709:23: '(\\'?\\')'
            {
            match("('?')"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNUSED_LITERAL"

    // $ANTLR start "RULE_INTEGER_LITERAL"
    public final void mRULE_INTEGER_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_INTEGER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11711:22: ( ( '0' .. '9' )+ ( 'l' | 'L' )? )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11711:24: ( '0' .. '9' )+ ( 'l' | 'L' )?
            {
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11711:24: ( '0' .. '9' )+
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
            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11711:25: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11711:36: ( 'l' | 'L' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


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
    // $ANTLR end "RULE_INTEGER_LITERAL"

    // $ANTLR start "RULE_HEX_LITERAL"
    public final void mRULE_HEX_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_HEX_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11713:18: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ ( 'l' | 'L' )? )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11713:20: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ ( 'l' | 'L' )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11713:34: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='F')||(LA3_0>='a' && LA3_0<='f')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11713:64: ( 'l' | 'L' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='L'||LA4_0=='l') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


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
    // $ANTLR end "RULE_HEX_LITERAL"

    // $ANTLR start "RULE_FLOATING_PT_LITERAL"
    public final void mRULE_FLOATING_PT_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_FLOATING_PT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:26: ( ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? | '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? | ( '0' .. '9' )+ ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ( 'f' | 'F' | 'd' | 'D' )? | ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' ) ) )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:28: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? | '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? | ( '0' .. '9' )+ ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ( 'f' | 'F' | 'd' | 'D' )? | ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' ) )
            {
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:28: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? | '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? | ( '0' .. '9' )+ ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ( 'f' | 'F' | 'd' | 'D' )? | ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' ) )
            int alt24=4;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:29: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )?
                    {
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:29: ( '0' .. '9' )+
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
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:30: '0' .. '9'
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

                    match('.'); 
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:45: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:46: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:57: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='E'||LA9_0=='e') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:58: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:68: ( '+' | '-' )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0=='+'||LA7_0=='-') ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }

                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:79: ( '0' .. '9' )+
                            int cnt8=0;
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:80: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt8 >= 1 ) break loop8;
                                        EarlyExitException eee =
                                            new EarlyExitException(8, input);
                                        throw eee;
                                }
                                cnt8++;
                            } while (true);


                            }
                            break;

                    }

                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:93: ( 'f' | 'F' | 'd' | 'D' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='D'||LA10_0=='F'||LA10_0=='d'||LA10_0=='f') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:112: '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )?
                    {
                    match('.'); 
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:116: ( '0' .. '9' )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:117: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:128: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='E'||LA14_0=='e') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:129: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:139: ( '+' | '-' )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0=='+'||LA12_0=='-') ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }

                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:150: ( '0' .. '9' )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:151: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt13 >= 1 ) break loop13;
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);


                            }
                            break;

                    }

                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:164: ( 'f' | 'F' | 'd' | 'D' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='D'||LA15_0=='F'||LA15_0=='d'||LA15_0=='f') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:183: ( '0' .. '9' )+ ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ( 'f' | 'F' | 'd' | 'D' )?
                    {
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:183: ( '0' .. '9' )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:184: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:205: ( '+' | '-' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='+'||LA17_0=='-') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:216: ( '0' .. '9' )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:217: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:228: ( 'f' | 'F' | 'd' | 'D' )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0=='D'||LA19_0=='F'||LA19_0=='d'||LA19_0=='f') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:247: ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )
                    {
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:247: ( '0' .. '9' )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:248: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:259: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='E'||LA23_0=='e') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:260: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:270: ( '+' | '-' )?
                            int alt21=2;
                            int LA21_0 = input.LA(1);

                            if ( (LA21_0=='+'||LA21_0=='-') ) {
                                alt21=1;
                            }
                            switch (alt21) {
                                case 1 :
                                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }

                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:281: ( '0' .. '9' )+
                            int cnt22=0;
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( ((LA22_0>='0' && LA22_0<='9')) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11715:282: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt22 >= 1 ) break loop22;
                                        EarlyExitException eee =
                                            new EarlyExitException(22, input);
                                        throw eee;
                                }
                                cnt22++;
                            } while (true);


                            }
                            break;

                    }

                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


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
    // $ANTLR end "RULE_FLOATING_PT_LITERAL"

    // $ANTLR start "RULE_CHARACTER_LITERAL"
    public final void mRULE_CHARACTER_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_CHARACTER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11717:24: ( '\\'' ( RULE_ESCAPE_SEQUENCE | ~ ( ( '\\'' | '\\\\' ) ) ) '\\'' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11717:26: '\\'' ( RULE_ESCAPE_SEQUENCE | ~ ( ( '\\'' | '\\\\' ) ) ) '\\''
            {
            match('\''); 
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11717:31: ( RULE_ESCAPE_SEQUENCE | ~ ( ( '\\'' | '\\\\' ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='\'') ) {
                alt25=1;
            }
            else if ( ((LA25_0>='\u0000' && LA25_0<='&')||(LA25_0>='(' && LA25_0<='[')||(LA25_0>=']' && LA25_0<='\uFFFF')) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11717:32: RULE_ESCAPE_SEQUENCE
                    {
                    mRULE_ESCAPE_SEQUENCE(); 

                    }
                    break;
                case 2 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11717:53: ~ ( ( '\\'' | '\\\\' ) )
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

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARACTER_LITERAL"

    // $ANTLR start "RULE_BOOLEAN_LITERAL"
    public final void mRULE_BOOLEAN_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11719:22: ( ( 'TRUE' | 'FALSE' ) )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11719:24: ( 'TRUE' | 'FALSE' )
            {
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11719:24: ( 'TRUE' | 'FALSE' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='T') ) {
                alt26=1;
            }
            else if ( (LA26_0=='F') ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11719:25: 'TRUE'
                    {
                    match("TRUE"); 


                    }
                    break;
                case 2 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11719:32: 'FALSE'
                    {
                    match("FALSE"); 


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
    // $ANTLR end "RULE_BOOLEAN_LITERAL"

    // $ANTLR start "RULE_ESCAPE_SEQUENCE"
    public final void mRULE_ESCAPE_SEQUENCE() throws RecognitionException {
        try {
            int _type = RULE_ESCAPE_SEQUENCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11721:22: ( '\\'\\\\\\' (\\'b\\'|\\'t\\'|\\'n\\'|\\'f\\'|\\'r\\'|\\'v\\'|\\'a\\'|\\'?\\'|\\'\"\\'|\\'\\'\\'|\\'\\\\\\') | RULE_UNICODE_ESCAPE | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11721:24: '\\'\\\\\\' (\\'b\\'|\\'t\\'|\\'n\\'|\\'f\\'|\\'r\\'|\\'v\\'|\\'a\\'|\\'?\\'|\\'\"\\'|\\'\\'\\'|\\'\\\\\\') | RULE_UNICODE_ESCAPE | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE'
            {
            match("'\\' ('b'|'t'|'n'|'f'|'r'|'v'|'a'|'?'|'\"'|'''|'\\') | RULE_UNICODE_ESCAPE | RULE_OCTAL_ESCAPE | RULE_HEX_ESCAPE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ESCAPE_SEQUENCE"

    // $ANTLR start "RULE_HEX_ESCAPE"
    public final void mRULE_HEX_ESCAPE() throws RecognitionException {
        try {
            int _type = RULE_HEX_ESCAPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11723:17: ( '\\'\\\\\\' (\\'x\\'|\\'X\\') ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' )+ (\\'l\\'|\\'L\\')?' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11723:19: '\\'\\\\\\' (\\'x\\'|\\'X\\') ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' )+ (\\'l\\'|\\'L\\')?'
            {
            match("'\\' ('x'|'X') ( '0'..'9' | 'a'..'f' | 'A'..'F' )+ ('l'|'L')?"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_ESCAPE"

    // $ANTLR start "RULE_OCTAL_ESCAPE"
    public final void mRULE_OCTAL_ESCAPE() throws RecognitionException {
        try {
            int _type = RULE_OCTAL_ESCAPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11725:19: ( '\\'\\\\\\' (\\'0\\'..\\'3\\') (\\'0\\'..\\'7\\') (\\'0\\'..\\'7\\')\\r\\n\\t|\\t\\'\\\\\\' (\\'0\\'..\\'7\\') (\\'0\\'..\\'7\\')\\r\\n\\t|\\t\\'\\\\\\' (\\'0\\'..\\'7\\')' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11725:21: '\\'\\\\\\' (\\'0\\'..\\'3\\') (\\'0\\'..\\'7\\') (\\'0\\'..\\'7\\')\\r\\n\\t|\\t\\'\\\\\\' (\\'0\\'..\\'7\\') (\\'0\\'..\\'7\\')\\r\\n\\t|\\t\\'\\\\\\' (\\'0\\'..\\'7\\')'
            {
            match("'\\' ('0'..'3') ('0'..'7') ('0'..'7')\r\n\t|\t'\\' ('0'..'7') ('0'..'7')\r\n\t|\t'\\' ('0'..'7')"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTAL_ESCAPE"

    // $ANTLR start "RULE_UNICODE_ESCAPE"
    public final void mRULE_UNICODE_ESCAPE() throws RecognitionException {
        try {
            int _type = RULE_UNICODE_ESCAPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11727:21: ( '\\'\\\\\\' \\'u\\' ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' ) ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' ) ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' ) ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' )' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11727:23: '\\'\\\\\\' \\'u\\' ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' ) ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' ) ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' ) ( \\'0\\'..\\'9\\' | \\'a\\'..\\'f\\' | \\'A\\'..\\'F\\' )'
            {
            match("'\\' 'u' ( '0'..'9' | 'a'..'f' | 'A'..'F' ) ( '0'..'9' | 'a'..'f' | 'A'..'F' ) ( '0'..'9' | 'a'..'f' | 'A'..'F' ) ( '0'..'9' | 'a'..'f' | 'A'..'F' )"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNICODE_ESCAPE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11729:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11729:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11729:11: ( '^' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='^') ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11729:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11729:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>='0' && LA28_0<='9')||(LA28_0>='A' && LA28_0<='Z')||LA28_0=='_'||(LA28_0>='a' && LA28_0<='z')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
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
            	    break loop28;
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='\"') ) {
                alt31=1;
            }
            else if ( (LA31_0=='\'') ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop29:
                    do {
                        int alt29=3;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0=='\\') ) {
                            alt29=1;
                        }
                        else if ( ((LA29_0>='\u0000' && LA29_0<='!')||(LA29_0>='#' && LA29_0<='[')||(LA29_0>=']' && LA29_0<='\uFFFF')) ) {
                            alt29=2;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:62: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop29;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop30:
                    do {
                        int alt30=3;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0=='\\') ) {
                            alt30=1;
                        }
                        else if ( ((LA30_0>='\u0000' && LA30_0<='&')||(LA30_0>='(' && LA30_0<='[')||(LA30_0>=']' && LA30_0<='\uFFFF')) ) {
                            alt30=2;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11731:129: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop30;
                        }
                    } while (true);

                    match('\''); 

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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11733:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11733:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11733:24: ( options {greedy=false; } : . )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0=='*') ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1=='/') ) {
                        alt32=2;
                    }
                    else if ( ((LA32_1>='\u0000' && LA32_1<='.')||(LA32_1>='0' && LA32_1<='\uFFFF')) ) {
                        alt32=1;
                    }


                }
                else if ( ((LA32_0>='\u0000' && LA32_0<=')')||(LA32_0>='+' && LA32_0<='\uFFFF')) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11733:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop32;
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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11735:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11735:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11735:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>='\u0000' && LA33_0<='\t')||(LA33_0>='\u000B' && LA33_0<='\f')||(LA33_0>='\u000E' && LA33_0<='\uFFFF')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11735:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop33;
                }
            } while (true);

            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11735:40: ( ( '\\r' )? '\\n' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0=='\n'||LA35_0=='\r') ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11735:41: ( '\\r' )? '\\n'
                    {
                    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11735:41: ( '\\r' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0=='\r') ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11735:41: '\\r'
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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11737:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11737:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11737:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>='\t' && LA36_0<='\n')||LA36_0=='\r'||LA36_0==' ') ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:
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
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11739:16: ( . )
            // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:11739:18: .
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
        // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:8: ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | RULE_UNUSED_LITERAL | RULE_INTEGER_LITERAL | RULE_HEX_LITERAL | RULE_FLOATING_PT_LITERAL | RULE_CHARACTER_LITERAL | RULE_BOOLEAN_LITERAL | RULE_ESCAPE_SEQUENCE | RULE_HEX_ESCAPE | RULE_OCTAL_ESCAPE | RULE_UNICODE_ESCAPE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt37=140;
        alt37 = dfa37.predict(input);
        switch (alt37) {
            case 1 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:10: T__20
                {
                mT__20(); 

                }
                break;
            case 2 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:16: T__21
                {
                mT__21(); 

                }
                break;
            case 3 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:22: T__22
                {
                mT__22(); 

                }
                break;
            case 4 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:28: T__23
                {
                mT__23(); 

                }
                break;
            case 5 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:34: T__24
                {
                mT__24(); 

                }
                break;
            case 6 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:40: T__25
                {
                mT__25(); 

                }
                break;
            case 7 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:46: T__26
                {
                mT__26(); 

                }
                break;
            case 8 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:52: T__27
                {
                mT__27(); 

                }
                break;
            case 9 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:58: T__28
                {
                mT__28(); 

                }
                break;
            case 10 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:64: T__29
                {
                mT__29(); 

                }
                break;
            case 11 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:70: T__30
                {
                mT__30(); 

                }
                break;
            case 12 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:76: T__31
                {
                mT__31(); 

                }
                break;
            case 13 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:82: T__32
                {
                mT__32(); 

                }
                break;
            case 14 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:88: T__33
                {
                mT__33(); 

                }
                break;
            case 15 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:94: T__34
                {
                mT__34(); 

                }
                break;
            case 16 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:100: T__35
                {
                mT__35(); 

                }
                break;
            case 17 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:106: T__36
                {
                mT__36(); 

                }
                break;
            case 18 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:112: T__37
                {
                mT__37(); 

                }
                break;
            case 19 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:118: T__38
                {
                mT__38(); 

                }
                break;
            case 20 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:124: T__39
                {
                mT__39(); 

                }
                break;
            case 21 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:130: T__40
                {
                mT__40(); 

                }
                break;
            case 22 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:136: T__41
                {
                mT__41(); 

                }
                break;
            case 23 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:142: T__42
                {
                mT__42(); 

                }
                break;
            case 24 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:148: T__43
                {
                mT__43(); 

                }
                break;
            case 25 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:154: T__44
                {
                mT__44(); 

                }
                break;
            case 26 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:160: T__45
                {
                mT__45(); 

                }
                break;
            case 27 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:166: T__46
                {
                mT__46(); 

                }
                break;
            case 28 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:172: T__47
                {
                mT__47(); 

                }
                break;
            case 29 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:178: T__48
                {
                mT__48(); 

                }
                break;
            case 30 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:184: T__49
                {
                mT__49(); 

                }
                break;
            case 31 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:190: T__50
                {
                mT__50(); 

                }
                break;
            case 32 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:196: T__51
                {
                mT__51(); 

                }
                break;
            case 33 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:202: T__52
                {
                mT__52(); 

                }
                break;
            case 34 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:208: T__53
                {
                mT__53(); 

                }
                break;
            case 35 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:214: T__54
                {
                mT__54(); 

                }
                break;
            case 36 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:220: T__55
                {
                mT__55(); 

                }
                break;
            case 37 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:226: T__56
                {
                mT__56(); 

                }
                break;
            case 38 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:232: T__57
                {
                mT__57(); 

                }
                break;
            case 39 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:238: T__58
                {
                mT__58(); 

                }
                break;
            case 40 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:244: T__59
                {
                mT__59(); 

                }
                break;
            case 41 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:250: T__60
                {
                mT__60(); 

                }
                break;
            case 42 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:256: T__61
                {
                mT__61(); 

                }
                break;
            case 43 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:262: T__62
                {
                mT__62(); 

                }
                break;
            case 44 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:268: T__63
                {
                mT__63(); 

                }
                break;
            case 45 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:274: T__64
                {
                mT__64(); 

                }
                break;
            case 46 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:280: T__65
                {
                mT__65(); 

                }
                break;
            case 47 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:286: T__66
                {
                mT__66(); 

                }
                break;
            case 48 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:292: T__67
                {
                mT__67(); 

                }
                break;
            case 49 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:298: T__68
                {
                mT__68(); 

                }
                break;
            case 50 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:304: T__69
                {
                mT__69(); 

                }
                break;
            case 51 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:310: T__70
                {
                mT__70(); 

                }
                break;
            case 52 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:316: T__71
                {
                mT__71(); 

                }
                break;
            case 53 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:322: T__72
                {
                mT__72(); 

                }
                break;
            case 54 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:328: T__73
                {
                mT__73(); 

                }
                break;
            case 55 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:334: T__74
                {
                mT__74(); 

                }
                break;
            case 56 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:340: T__75
                {
                mT__75(); 

                }
                break;
            case 57 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:346: T__76
                {
                mT__76(); 

                }
                break;
            case 58 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:352: T__77
                {
                mT__77(); 

                }
                break;
            case 59 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:358: T__78
                {
                mT__78(); 

                }
                break;
            case 60 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:364: T__79
                {
                mT__79(); 

                }
                break;
            case 61 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:370: T__80
                {
                mT__80(); 

                }
                break;
            case 62 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:376: T__81
                {
                mT__81(); 

                }
                break;
            case 63 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:382: T__82
                {
                mT__82(); 

                }
                break;
            case 64 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:388: T__83
                {
                mT__83(); 

                }
                break;
            case 65 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:394: T__84
                {
                mT__84(); 

                }
                break;
            case 66 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:400: T__85
                {
                mT__85(); 

                }
                break;
            case 67 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:406: T__86
                {
                mT__86(); 

                }
                break;
            case 68 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:412: T__87
                {
                mT__87(); 

                }
                break;
            case 69 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:418: T__88
                {
                mT__88(); 

                }
                break;
            case 70 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:424: T__89
                {
                mT__89(); 

                }
                break;
            case 71 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:430: T__90
                {
                mT__90(); 

                }
                break;
            case 72 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:436: T__91
                {
                mT__91(); 

                }
                break;
            case 73 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:442: T__92
                {
                mT__92(); 

                }
                break;
            case 74 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:448: T__93
                {
                mT__93(); 

                }
                break;
            case 75 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:454: T__94
                {
                mT__94(); 

                }
                break;
            case 76 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:460: T__95
                {
                mT__95(); 

                }
                break;
            case 77 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:466: T__96
                {
                mT__96(); 

                }
                break;
            case 78 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:472: T__97
                {
                mT__97(); 

                }
                break;
            case 79 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:478: T__98
                {
                mT__98(); 

                }
                break;
            case 80 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:484: T__99
                {
                mT__99(); 

                }
                break;
            case 81 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:490: T__100
                {
                mT__100(); 

                }
                break;
            case 82 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:497: T__101
                {
                mT__101(); 

                }
                break;
            case 83 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:504: T__102
                {
                mT__102(); 

                }
                break;
            case 84 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:511: T__103
                {
                mT__103(); 

                }
                break;
            case 85 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:518: T__104
                {
                mT__104(); 

                }
                break;
            case 86 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:525: T__105
                {
                mT__105(); 

                }
                break;
            case 87 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:532: T__106
                {
                mT__106(); 

                }
                break;
            case 88 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:539: T__107
                {
                mT__107(); 

                }
                break;
            case 89 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:546: T__108
                {
                mT__108(); 

                }
                break;
            case 90 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:553: T__109
                {
                mT__109(); 

                }
                break;
            case 91 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:560: T__110
                {
                mT__110(); 

                }
                break;
            case 92 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:567: T__111
                {
                mT__111(); 

                }
                break;
            case 93 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:574: T__112
                {
                mT__112(); 

                }
                break;
            case 94 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:581: T__113
                {
                mT__113(); 

                }
                break;
            case 95 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:588: T__114
                {
                mT__114(); 

                }
                break;
            case 96 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:595: T__115
                {
                mT__115(); 

                }
                break;
            case 97 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:602: T__116
                {
                mT__116(); 

                }
                break;
            case 98 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:609: T__117
                {
                mT__117(); 

                }
                break;
            case 99 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:616: T__118
                {
                mT__118(); 

                }
                break;
            case 100 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:623: T__119
                {
                mT__119(); 

                }
                break;
            case 101 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:630: T__120
                {
                mT__120(); 

                }
                break;
            case 102 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:637: T__121
                {
                mT__121(); 

                }
                break;
            case 103 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:644: T__122
                {
                mT__122(); 

                }
                break;
            case 104 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:651: T__123
                {
                mT__123(); 

                }
                break;
            case 105 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:658: T__124
                {
                mT__124(); 

                }
                break;
            case 106 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:665: T__125
                {
                mT__125(); 

                }
                break;
            case 107 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:672: T__126
                {
                mT__126(); 

                }
                break;
            case 108 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:679: T__127
                {
                mT__127(); 

                }
                break;
            case 109 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:686: T__128
                {
                mT__128(); 

                }
                break;
            case 110 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:693: T__129
                {
                mT__129(); 

                }
                break;
            case 111 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:700: T__130
                {
                mT__130(); 

                }
                break;
            case 112 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:707: T__131
                {
                mT__131(); 

                }
                break;
            case 113 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:714: T__132
                {
                mT__132(); 

                }
                break;
            case 114 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:721: T__133
                {
                mT__133(); 

                }
                break;
            case 115 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:728: T__134
                {
                mT__134(); 

                }
                break;
            case 116 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:735: T__135
                {
                mT__135(); 

                }
                break;
            case 117 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:742: T__136
                {
                mT__136(); 

                }
                break;
            case 118 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:749: T__137
                {
                mT__137(); 

                }
                break;
            case 119 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:756: T__138
                {
                mT__138(); 

                }
                break;
            case 120 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:763: T__139
                {
                mT__139(); 

                }
                break;
            case 121 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:770: T__140
                {
                mT__140(); 

                }
                break;
            case 122 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:777: T__141
                {
                mT__141(); 

                }
                break;
            case 123 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:784: T__142
                {
                mT__142(); 

                }
                break;
            case 124 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:791: T__143
                {
                mT__143(); 

                }
                break;
            case 125 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:798: RULE_UNUSED_LITERAL
                {
                mRULE_UNUSED_LITERAL(); 

                }
                break;
            case 126 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:818: RULE_INTEGER_LITERAL
                {
                mRULE_INTEGER_LITERAL(); 

                }
                break;
            case 127 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:839: RULE_HEX_LITERAL
                {
                mRULE_HEX_LITERAL(); 

                }
                break;
            case 128 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:856: RULE_FLOATING_PT_LITERAL
                {
                mRULE_FLOATING_PT_LITERAL(); 

                }
                break;
            case 129 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:881: RULE_CHARACTER_LITERAL
                {
                mRULE_CHARACTER_LITERAL(); 

                }
                break;
            case 130 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:904: RULE_BOOLEAN_LITERAL
                {
                mRULE_BOOLEAN_LITERAL(); 

                }
                break;
            case 131 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:925: RULE_ESCAPE_SEQUENCE
                {
                mRULE_ESCAPE_SEQUENCE(); 

                }
                break;
            case 132 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:946: RULE_HEX_ESCAPE
                {
                mRULE_HEX_ESCAPE(); 

                }
                break;
            case 133 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:962: RULE_OCTAL_ESCAPE
                {
                mRULE_OCTAL_ESCAPE(); 

                }
                break;
            case 134 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:980: RULE_UNICODE_ESCAPE
                {
                mRULE_UNICODE_ESCAPE(); 

                }
                break;
            case 135 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:1000: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 136 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:1008: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 137 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:1020: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 138 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:1036: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 139 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:1052: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 140 :
                // ../com.zeligsoft.domain.omg.corba.dsl/src-gen/com/zeligsoft/domain/omg/corba/dsl/parser/antlr/internal/InternalIDL.g:1:1060: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA24_eotS =
        "\7\uffff\1\10\1\uffff";
    static final String DFA24_eofS =
        "\11\uffff";
    static final String DFA24_minS =
        "\2\56\1\uffff\1\53\2\uffff\2\60\1\uffff";
    static final String DFA24_maxS =
        "\1\71\1\146\1\uffff\1\71\2\uffff\2\71\1\uffff";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\4\2\uffff\1\3";
    static final String DFA24_specialS =
        "\11\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\4\1\uffff\12\1\12\uffff\1\5\1\3\1\5\35\uffff\1\5\1\3\1\5",
            "",
            "\1\6\1\uffff\1\6\2\uffff\12\7",
            "",
            "",
            "\12\7",
            "\12\7",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "11715:28: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? | '.' ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' )? | ( '0' .. '9' )+ ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ( 'f' | 'F' | 'd' | 'D' )? | ( '0' .. '9' )+ ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ( 'f' | 'F' | 'd' | 'D' ) )";
        }
    }
    static final String DFA37_eotS =
        "\1\uffff\1\67\1\100\1\103\1\104\1\107\1\113\1\115\2\113\1\127\5\113\1\uffff\1\113\3\uffff\3\113\1\166\1\uffff\11\113\3\uffff\1\u008e\4\uffff\1\u0095\2\uffff\1\113\2\u009b\1\67\2\113\1\uffff\1\67\22\uffff\3\113\3\uffff\10\113\2\uffff\14\113\1\u00c6\1\uffff\4\113\3\uffff\10\113\3\uffff\23\113\15\uffff\1\113\1\uffff\1\u009b\3\uffff\1\u00a1\2\113\3\uffff\1\u00f1\4\uffff\16\113\1\u0106\5\113\1\u010c\10\113\1\uffff\17\113\1\u0126\23\113\3\uffff\2\113\5\uffff\11\113\1\u0147\4\113\1\u014e\1\u014f\1\u0150\1\113\1\uffff\1\113\1\u0153\3\113\1\uffff\1\113\1\u0158\3\113\1\u015e\23\113\1\uffff\1\u0172\7\113\1\u017a\6\113\1\u0181\2\113\1\u0184\1\uffff\1\u0187\13\113\1\uffff\3\113\1\u0197\2\113\3\uffff\1\113\1\u019b\1\uffff\3\113\1\u019f\1\uffff\5\113\1\uffff\2\113\1\u01a7\7\113\1\u01af\7\113\1\u01b7\1\uffff\1\113\1\u01b9\1\u01ba\3\113\1\u01be\1\uffff\1\u01bf\5\113\1\uffff\1\u01c5\1\113\2\uffff\1\u00a1\1\uffff\1\u0187\3\113\1\u01cc\1\u01cd\4\113\1\u01d2\4\113\1\uffff\2\113\1\u01d9\1\uffff\3\113\1\uffff\1\u01dd\4\113\1\u01e2\1\113\1\uffff\1\u01e4\6\113\1\uffff\1\u01eb\1\u01ec\1\u01ed\2\113\1\u01f0\1\u01f1\1\uffff\1\113\2\uffff\1\u01f3\2\113\2\uffff\2\113\1\u01f8\2\113\1\uffff\1\113\1\u00a1\1\uffff\1\u01ff\1\u0200\1\u0201\2\uffff\2\113\1\u0204\1\113\1\uffff\3\113\1\u0209\2\113\1\uffff\3\113\1\uffff\1\113\1\u0210\2\113\1\uffff\1\113\1\uffff\1\113\1\u0215\4\113\3\uffff\2\113\2\uffff\1\113\1\uffff\1\u021d\1\113\1\u021f\1\u0220\1\uffff\3\113\6\uffff\1\u0224\1\113\1\uffff\1\113\1\u0227\1\u0228\1\113\1\uffff\1\u022a\1\113\1\uffff\1\u022e\2\113\1\uffff\1\u0231\2\113\1\u0234\1\uffff\3\113\1\u0238\1\u0239\1\u023a\1\113\1\uffff\1\u023c\2\uffff\3\113\1\uffff\1\113\1\u0241\2\uffff\1\u0242\1\uffff\1\u0245\3\uffff\1\u0248\1\113\1\uffff\1\113\1\u024b\1\uffff\1\113\1\u024d\1\u024e\3\uffff\1\u024f\1\uffff\1\u0250\1\u0251\1\u0252\1\u0253\2\uffff\2\113\4\uffff\2\113\1\uffff\1\u0258\7\uffff\2\113\1\u025b\1\u025c\1\uffff\2\113\2\uffff\1\113\1\u0260\1\113\1\uffff\3\113\1\u0265\1\uffff";
    static final String DFA37_eofS =
        "\u0266\uffff";
    static final String DFA37_minS =
        "\1\0\1\144\1\74\1\75\1\60\1\75\1\144\1\75\1\157\1\141\1\72\1\145\1\142\1\141\1\162\1\155\1\uffff\1\141\3\uffff\2\145\1\141\1\47\1\uffff\1\143\2\141\1\156\1\143\1\157\1\142\1\141\1\155\3\uffff\1\101\4\uffff\1\52\2\uffff\1\157\2\56\1\0\1\122\1\101\1\uffff\1\0\2\uffff\1\146\1\uffff\1\154\15\uffff\1\146\1\163\1\165\3\uffff\1\145\1\142\1\162\1\155\2\141\2\163\2\uffff\1\155\1\143\1\151\1\163\1\164\1\171\1\151\1\144\1\164\1\160\1\165\1\160\1\60\1\uffff\1\144\1\154\1\156\1\162\3\uffff\1\164\1\161\1\157\1\162\1\151\1\160\1\141\1\151\3\uffff\1\145\2\164\1\151\1\154\1\157\1\156\1\143\1\151\1\145\1\150\1\164\1\157\1\152\1\154\1\143\1\165\1\151\1\145\15\uffff\1\155\1\uffff\1\56\1\uffff\1\42\1\0\1\134\1\125\1\114\3\uffff\1\144\1\151\3\uffff\1\141\1\64\1\142\1\146\1\166\1\155\1\154\1\164\1\156\1\160\1\157\1\162\1\145\1\164\1\60\1\141\1\147\1\64\1\164\1\162\1\60\1\141\1\163\1\151\1\145\1\156\1\154\1\145\1\165\1\uffff\1\165\1\164\1\141\3\162\1\165\1\162\1\151\1\164\1\160\1\144\1\163\1\167\1\145\1\60\1\144\1\165\1\141\1\145\1\144\1\164\1\151\1\157\1\163\1\141\1\162\1\154\1\145\1\165\1\145\1\155\1\164\1\156\1\145\1\0\2\uffff\1\105\1\123\5\uffff\1\156\1\165\1\143\1\154\2\151\2\141\1\151\1\60\2\145\1\164\1\157\3\60\1\157\1\uffff\1\154\1\60\1\143\1\162\1\151\1\uffff\1\163\1\60\1\166\1\144\1\143\1\60\2\162\1\164\1\154\1\151\1\147\1\157\2\141\1\145\1\164\1\156\2\143\2\157\1\145\1\141\1\164\1\uffff\1\60\1\145\1\164\1\144\1\145\1\157\1\147\1\156\1\60\1\162\1\151\1\145\1\143\1\145\1\160\1\60\1\163\1\164\1\60\1\0\1\60\1\105\1\145\1\154\1\143\1\145\1\170\1\144\1\162\1\164\1\143\1\171\1\uffff\1\171\1\143\1\170\1\60\1\155\1\156\3\uffff\1\155\1\60\1\uffff\1\143\1\141\1\142\1\60\1\uffff\1\145\1\165\1\145\2\141\1\uffff\1\164\1\146\1\60\1\145\1\160\1\145\1\162\2\151\1\156\1\60\1\147\1\164\1\150\1\162\1\156\1\163\1\171\1\60\1\uffff\1\164\2\60\2\162\1\156\1\60\1\uffff\1\60\1\156\1\141\1\164\1\102\1\164\1\uffff\1\60\1\164\1\uffff\1\0\1\165\1\uffff\1\60\1\144\1\164\1\155\2\60\1\145\1\171\1\145\1\150\1\60\2\160\2\164\1\uffff\2\145\1\60\1\uffff\1\155\1\143\1\165\1\uffff\1\60\1\160\1\146\1\155\1\164\1\60\1\141\1\uffff\1\60\1\154\1\163\1\160\2\163\1\143\1\uffff\3\60\1\164\1\154\2\60\1\uffff\1\171\2\uffff\1\60\1\171\1\145\2\uffff\1\147\1\156\1\60\1\141\1\151\1\uffff\1\171\1\60\1\uffff\3\60\2\uffff\1\163\1\153\1\60\1\145\1\uffff\2\145\1\157\1\60\1\163\1\156\1\uffff\1\40\2\164\1\uffff\1\160\1\60\1\145\1\141\1\uffff\1\143\1\uffff\1\145\1\60\1\157\3\145\3\uffff\1\163\1\171\2\uffff\1\160\1\uffff\1\60\1\144\2\60\1\uffff\1\163\1\157\1\160\6\uffff\1\60\1\145\1\uffff\1\163\2\60\1\162\1\uffff\1\60\1\164\1\151\1\60\1\145\1\157\1\uffff\1\60\1\142\1\145\1\60\1\uffff\1\162\2\163\3\60\1\145\1\uffff\1\60\2\uffff\1\145\1\156\1\145\1\uffff\1\171\1\60\2\uffff\1\60\1\uffff\1\60\1\144\2\uffff\1\60\1\162\1\uffff\1\154\1\60\1\uffff\1\164\2\60\3\uffff\1\60\1\uffff\4\60\2\uffff\1\156\1\157\4\uffff\1\164\1\145\1\uffff\1\60\7\uffff\1\164\1\155\2\60\1\uffff\2\145\2\uffff\1\162\1\60\1\146\1\uffff\1\141\1\143\1\145\1\60\1\uffff";
    static final String DFA37_maxS =
        "\1\uffff\1\165\1\75\1\76\1\71\1\75\1\157\1\75\2\165\1\72\1\157\1\164\1\144\1\171\1\156\1\uffff\1\165\3\uffff\1\145\1\167\1\145\1\47\1\uffff\1\165\1\157\1\154\2\163\1\157\1\142\1\141\1\170\3\uffff\1\172\4\uffff\1\57\2\uffff\1\157\1\170\1\146\1\uffff\1\122\1\101\1\uffff\1\uffff\2\uffff\1\156\1\uffff\1\170\15\uffff\1\146\1\163\1\165\3\uffff\1\157\1\142\1\162\1\156\2\141\2\163\2\uffff\1\155\1\156\1\151\1\163\1\164\1\171\1\151\1\144\1\164\1\160\1\165\1\160\1\172\1\uffff\1\144\1\154\1\156\1\162\3\uffff\2\164\1\157\1\162\1\151\1\160\1\141\1\151\3\uffff\1\145\2\164\1\151\1\154\1\157\1\170\1\143\1\163\1\145\1\150\1\164\1\157\1\152\1\154\1\143\1\165\1\151\1\145\15\uffff\1\155\1\uffff\1\146\1\uffff\1\164\1\uffff\1\134\1\125\1\114\3\uffff\1\156\1\163\3\uffff\1\151\1\64\1\142\1\146\2\166\1\154\2\164\1\160\1\157\1\162\1\145\1\164\1\172\1\141\1\147\1\64\1\164\1\162\1\172\1\141\1\163\1\151\1\145\1\156\1\157\1\145\1\165\1\uffff\1\165\1\164\1\141\3\162\1\165\1\162\1\165\1\164\1\160\1\144\1\163\1\167\1\145\1\172\1\144\1\165\1\141\1\145\1\144\1\164\1\151\1\157\1\163\1\141\1\162\1\154\1\145\1\165\1\145\1\155\1\164\1\156\1\145\1\uffff\2\uffff\1\105\1\123\5\uffff\1\156\1\165\1\143\1\154\2\151\2\141\1\151\1\172\1\164\1\145\1\165\1\157\3\172\1\157\1\uffff\1\154\1\172\1\143\1\162\1\151\1\uffff\1\163\1\172\1\166\1\163\1\143\1\172\2\162\1\164\1\154\1\151\1\147\1\157\2\141\1\145\1\164\1\156\2\143\2\157\1\145\1\141\1\164\1\uffff\1\172\1\145\1\164\1\144\1\145\1\157\1\147\1\156\1\172\1\162\1\151\1\145\1\143\1\145\1\160\1\172\1\163\1\164\1\172\1\uffff\1\172\1\105\1\145\1\154\1\143\1\145\1\170\1\144\1\162\1\164\1\163\1\171\1\uffff\1\171\1\143\1\170\1\172\1\155\1\156\3\uffff\1\155\1\172\1\uffff\1\143\1\141\1\142\1\172\1\uffff\1\145\1\165\1\145\2\141\1\uffff\1\164\1\146\1\172\1\145\1\160\1\145\1\162\2\151\1\156\1\172\1\147\1\164\1\150\1\162\1\156\1\163\1\171\1\172\1\uffff\1\164\2\172\2\162\1\156\1\172\1\uffff\1\172\1\156\1\141\1\164\1\102\1\164\1\uffff\1\172\1\164\1\uffff\1\uffff\1\165\1\uffff\1\172\1\144\1\164\1\155\2\172\1\145\1\171\1\145\1\150\1\172\2\160\2\164\1\uffff\2\145\1\172\1\uffff\1\155\1\143\1\165\1\uffff\1\172\1\160\1\146\1\155\1\164\1\172\1\141\1\uffff\1\172\1\154\1\163\1\160\2\163\1\143\1\uffff\3\172\1\164\1\154\2\172\1\uffff\1\171\2\uffff\1\172\1\171\1\145\2\uffff\1\147\1\156\1\172\1\141\1\151\1\uffff\1\171\1\170\1\uffff\3\172\2\uffff\1\163\1\153\1\172\1\145\1\uffff\2\145\1\157\1\172\1\163\1\156\1\uffff\1\40\2\164\1\uffff\1\160\1\172\1\145\1\141\1\uffff\1\143\1\uffff\1\145\1\172\1\157\3\145\3\uffff\1\163\1\171\2\uffff\1\160\1\uffff\1\172\1\144\2\172\1\uffff\1\163\1\157\1\160\6\uffff\1\172\1\145\1\uffff\1\163\2\172\1\162\1\uffff\1\172\1\164\1\162\1\172\1\145\1\157\1\uffff\1\172\1\142\1\145\1\172\1\uffff\1\162\2\163\3\172\1\145\1\uffff\1\172\2\uffff\1\145\1\156\1\145\1\uffff\1\171\1\172\2\uffff\1\172\1\uffff\1\172\1\156\2\uffff\1\172\1\162\1\uffff\1\154\1\172\1\uffff\1\164\2\172\3\uffff\1\172\1\uffff\4\172\2\uffff\1\156\1\157\4\uffff\1\164\1\145\1\uffff\1\172\7\uffff\1\164\1\155\2\172\1\uffff\2\145\2\uffff\1\162\1\172\1\146\1\uffff\1\141\1\143\1\145\1\172\1\uffff";
    static final String DFA37_acceptS =
        "\20\uffff\1\46\1\uffff\1\50\1\51\1\56\4\uffff\1\65\11\uffff\1\110\1\111\1\126\1\uffff\1\130\1\133\1\134\1\135\1\uffff\1\137\1\140\6\uffff\1\u0087\1\uffff\1\u008b\1\u008c\1\uffff\1\7\1\uffff\1\22\1\24\1\43\1\17\1\131\1\2\1\16\1\132\1\3\1\4\1\u0080\1\15\1\12\3\uffff\1\u0087\1\14\1\125\10\uffff\1\27\1\55\15\uffff\1\46\4\uffff\1\50\1\51\1\56\10\uffff\1\175\1\64\1\65\23\uffff\1\110\1\111\1\126\1\127\1\130\1\133\1\134\1\135\1\u0089\1\u008a\1\136\1\137\1\140\1\uffff\1\177\1\uffff\1\176\5\uffff\1\u0088\1\u008b\1\1\2\uffff\1\21\1\23\1\44\35\uffff\1\172\44\uffff\2\u0081\2\uffff\1\5\1\6\1\10\1\11\1\20\22\uffff\1\31\5\uffff\1\102\31\uffff\1\173\40\uffff\1\164\6\uffff\1\30\1\76\1\116\2\uffff\1\73\4\uffff\1\35\5\uffff\1\42\23\uffff\1\67\7\uffff\1\144\6\uffff\1\120\2\uffff\1\151\2\uffff\1\u0082\17\uffff\1\124\3\uffff\1\53\3\uffff\1\171\7\uffff\1\174\7\uffff\1\74\7\uffff\1\101\1\uffff\1\71\1\123\3\uffff\1\114\1\77\5\uffff\1\147\2\uffff\1\u0086\3\uffff\1\72\1\25\4\uffff\1\161\6\uffff\1\156\3\uffff\1\122\4\uffff\1\45\1\uffff\1\47\6\uffff\1\105\1\112\1\115\2\uffff\1\63\1\66\1\uffff\1\155\4\uffff\1\103\3\uffff\1\u0083\1\u0084\1\u0085\1\13\1\117\1\41\2\uffff\1\162\4\uffff\1\70\6\uffff\1\113\4\uffff\1\152\7\uffff\1\154\1\uffff\1\106\1\100\3\uffff\1\143\2\uffff\1\163\1\26\1\uffff\1\150\2\uffff\1\33\1\52\2\uffff\1\167\2\uffff\1\145\3\uffff\1\121\1\142\1\62\1\uffff\1\75\4\uffff\1\146\1\166\2\uffff\1\141\1\32\1\34\1\57\2\uffff\1\54\1\uffff\1\60\1\61\1\170\1\104\1\107\1\157\1\153\4\uffff\1\165\2\uffff\1\36\1\160\3\uffff\1\40\4\uffff\1\37";
    static final String DFA37_specialS =
        "\1\3\60\uffff\1\2\3\uffff\1\6\147\uffff\1\5\114\uffff\1\0\117\uffff\1\1\112\uffff\1\4\u00e0\uffff}>";
    static final String[] DFA37_transitionS = {
            "\11\67\2\66\2\67\1\66\22\67\1\66\1\5\1\65\1\1\1\67\1\54\1\47\1\61\1\30\1\31\1\52\1\50\1\24\1\51\1\4\1\53\1\57\11\60\1\12\1\20\1\2\1\7\1\3\2\67\5\64\1\63\10\64\1\40\4\64\1\62\1\64\1\41\4\64\1\43\1\67\1\44\1\46\1\64\1\67\1\14\1\37\1\11\1\6\1\42\1\34\1\25\1\56\1\17\2\64\1\13\1\21\1\15\1\32\1\10\1\64\1\27\1\26\1\16\1\35\1\33\1\36\3\64\1\22\1\45\1\23\1\55\uff81\67",
            "\1\73\1\72\1\75\2\uffff\1\70\6\uffff\1\74\4\uffff\1\71",
            "\1\77\1\76",
            "\1\101\1\102",
            "\12\105",
            "\1\106",
            "\1\111\1\110\11\uffff\1\112",
            "\1\114",
            "\1\120\2\uffff\1\116\2\uffff\1\117",
            "\1\124\6\uffff\1\123\1\122\5\uffff\1\121\5\uffff\1\125",
            "\1\126",
            "\1\130\11\uffff\1\131",
            "\1\133\11\uffff\1\136\1\132\1\135\5\uffff\1\134",
            "\1\140\2\uffff\1\137",
            "\1\142\6\uffff\1\141",
            "\1\143\1\144",
            "",
            "\1\150\7\uffff\1\151\5\uffff\1\146\5\uffff\1\147",
            "",
            "",
            "",
            "\1\155",
            "\1\156\2\uffff\1\157\13\uffff\1\160\1\162\1\uffff\1\161",
            "\1\164\3\uffff\1\163",
            "\1\165",
            "",
            "\1\171\12\uffff\1\170\6\uffff\1\172",
            "\1\174\15\uffff\1\173",
            "\1\177\7\uffff\1\176\2\uffff\1\175",
            "\1\u0080\4\uffff\1\u0081",
            "\1\u0082\17\uffff\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0089\1\u0088\7\uffff\1\u008a\1\uffff\1\u0087",
            "",
            "",
            "",
            "\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "",
            "",
            "",
            "\1\u0093\4\uffff\1\u0094",
            "",
            "",
            "\1\u0098",
            "\1\105\1\uffff\12\u009a\12\uffff\3\105\21\uffff\1\u0099\13\uffff\3\105\21\uffff\1\u0099",
            "\1\105\1\uffff\12\u009a\12\uffff\3\105\35\uffff\3\105",
            "\47\u009d\1\u009e\64\u009d\1\u009c\uffa3\u009d",
            "\1\u009f",
            "\1\u00a0",
            "",
            "\0\u00a1",
            "",
            "",
            "\1\u00a4\7\uffff\1\u00a3",
            "",
            "\1\u00a5\1\uffff\1\u00a7\3\uffff\1\u00a6\5\uffff\1\u00a8",
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
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "",
            "",
            "\1\u00ac\3\uffff\1\u00ae\5\uffff\1\u00ad",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b2\1\u00b1",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "",
            "",
            "\1\u00b7",
            "\1\u00b8\12\uffff\1\u00b9",
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
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\16\113\1\u00c5\4\113\1\u00c4\6\113",
            "",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "",
            "",
            "\1\u00cb",
            "\1\u00cd\2\uffff\1\u00cc",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "",
            "",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00db\11\uffff\1\u00da",
            "\1\u00dc",
            "\1\u00de\11\uffff\1\u00dd",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
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
            "",
            "\1\u00e9",
            "",
            "\1\105\1\uffff\12\u009a\12\uffff\3\105\35\uffff\3\105",
            "",
            "\1\u00a1\4\uffff\1\u00ea\64\uffff\1\u00a1\5\uffff\1\u00a1\3\uffff\1\u00a1\7\uffff\1\u00a1\3\uffff\1\u00a1\1\uffff\1\u00a1",
            "\47\u00a1\1\u00eb\uffd8\u00a1",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "",
            "",
            "\1\u00ef\11\uffff\1\u00f0",
            "\1\u00f2\11\uffff\1\u00f3",
            "",
            "",
            "",
            "\1\u00f5\7\uffff\1\u00f4",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa\10\uffff\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe\4\uffff\1\u0100\1\u00ff",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112\2\uffff\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e\13\uffff\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\40\u00a1\1\u013a\uffdf\u00a1",
            "",
            "",
            "\1\u013b",
            "\1\u013c",
            "",
            "",
            "",
            "",
            "",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\23\113\1\u0146\6\113",
            "\1\u0149\16\uffff\1\u0148",
            "\1\u014a",
            "\1\u014b\1\u014c",
            "\1\u014d",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0151",
            "",
            "\1\u0152",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "",
            "\1\u0157",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0159",
            "\1\u015b\11\uffff\1\u015c\4\uffff\1\u015a",
            "\1\u015d",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "\1\u017f",
            "\1\u0180",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0182",
            "\1\u0183",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\47\u00a1\1\u0186\1\u0185\uffd7\u00a1",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\1\u0192\17\uffff\1\u0191",
            "\1\u0193",
            "",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0198",
            "\1\u0199",
            "",
            "",
            "",
            "\1\u019a",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "",
            "\1\u01a5",
            "\1\u01a6",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\1\u01ae",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5",
            "\1\u01b6",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u01b8",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01bb",
            "\1\u01bc",
            "\1\u01bd",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01c0",
            "\1\u01c1",
            "\1\u01c2",
            "\1\u01c3",
            "\1\u01c4",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01c6",
            "",
            "\47\u00a1\1\u01c7\uffd8\u00a1",
            "\1\u01c8",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01ce",
            "\1\u01cf",
            "\1\u01d0",
            "\1\u01d1",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01d3",
            "\1\u01d4",
            "\1\u01d5",
            "\1\u01d6",
            "",
            "\1\u01d7",
            "\1\u01d8",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u01da",
            "\1\u01db",
            "\1\u01dc",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\1\u01e1",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01e3",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01e5",
            "\1\u01e6",
            "\1\u01e7",
            "\1\u01e8",
            "\1\u01e9",
            "\1\u01ea",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01ee",
            "\1\u01ef",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u01f2",
            "",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01f4",
            "\1\u01f5",
            "",
            "",
            "\1\u01f6",
            "\1\u01f7",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u01f9",
            "\1\u01fa",
            "",
            "\1\u01fb",
            "\1\u01fe\61\uffff\1\u01fc\25\uffff\1\u01fd",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "",
            "\1\u0202",
            "\1\u0203",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0205",
            "",
            "\1\u0206",
            "\1\u0207",
            "\1\u0208",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u020a",
            "\1\u020b",
            "",
            "\1\u020c",
            "\1\u020d",
            "\1\u020e",
            "",
            "\1\u020f",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0211",
            "\1\u0212",
            "",
            "\1\u0213",
            "",
            "\1\u0214",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0216",
            "\1\u0217",
            "\1\u0218",
            "\1\u0219",
            "",
            "",
            "",
            "\1\u021a",
            "\1\u021b",
            "",
            "",
            "\1\u021c",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u021e",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u0221",
            "\1\u0222",
            "\1\u0223",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0225",
            "",
            "\1\u0226",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0229",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u022b",
            "\1\u022c\10\uffff\1\u022d",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u022f",
            "\1\u0230",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0232",
            "\1\u0233",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u0235",
            "\1\u0236",
            "\1\u0237",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u023b",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "",
            "\1\u023d",
            "\1\u023e",
            "\1\u023f",
            "",
            "\1\u0240",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\12\113\7\uffff\7\113\1\u0244\1\u0243\21\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0247\11\uffff\1\u0246",
            "",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0249",
            "",
            "\1\u024a",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u024c",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "",
            "\1\u0254",
            "\1\u0255",
            "",
            "",
            "",
            "",
            "\1\u0256",
            "\1\u0257",
            "",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0259",
            "\1\u025a",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "\1\u025d",
            "\1\u025e",
            "",
            "",
            "\1\u025f",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            "\1\u0261",
            "",
            "\1\u0262",
            "\1\u0263",
            "\1\u0264",
            "\12\113\7\uffff\32\113\4\uffff\1\113\1\uffff\32\113",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | RULE_UNUSED_LITERAL | RULE_INTEGER_LITERAL | RULE_HEX_LITERAL | RULE_FLOATING_PT_LITERAL | RULE_CHARACTER_LITERAL | RULE_BOOLEAN_LITERAL | RULE_ESCAPE_SEQUENCE | RULE_HEX_ESCAPE | RULE_OCTAL_ESCAPE | RULE_UNICODE_ESCAPE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_234 = input.LA(1);

                        s = -1;
                        if ( (LA37_234==' ') ) {s = 314;}

                        else if ( ((LA37_234>='\u0000' && LA37_234<='\u001F')||(LA37_234>='!' && LA37_234<='\uFFFF')) ) {s = 161;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_314 = input.LA(1);

                        s = -1;
                        if ( (LA37_314=='(') ) {s = 389;}

                        else if ( (LA37_314=='\'') ) {s = 390;}

                        else if ( ((LA37_314>='\u0000' && LA37_314<='&')||(LA37_314>=')' && LA37_314<='\uFFFF')) ) {s = 161;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_49 = input.LA(1);

                        s = -1;
                        if ( (LA37_49=='\\') ) {s = 156;}

                        else if ( ((LA37_49>='\u0000' && LA37_49<='&')||(LA37_49>='(' && LA37_49<='[')||(LA37_49>=']' && LA37_49<='\uFFFF')) ) {s = 157;}

                        else if ( (LA37_49=='\'') ) {s = 158;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA37_0 = input.LA(1);

                        s = -1;
                        if ( (LA37_0=='#') ) {s = 1;}

                        else if ( (LA37_0=='<') ) {s = 2;}

                        else if ( (LA37_0=='>') ) {s = 3;}

                        else if ( (LA37_0=='.') ) {s = 4;}

                        else if ( (LA37_0=='!') ) {s = 5;}

                        else if ( (LA37_0=='d') ) {s = 6;}

                        else if ( (LA37_0=='=') ) {s = 7;}

                        else if ( (LA37_0=='p') ) {s = 8;}

                        else if ( (LA37_0=='c') ) {s = 9;}

                        else if ( (LA37_0==':') ) {s = 10;}

                        else if ( (LA37_0=='l') ) {s = 11;}

                        else if ( (LA37_0=='a') ) {s = 12;}

                        else if ( (LA37_0=='n') ) {s = 13;}

                        else if ( (LA37_0=='t') ) {s = 14;}

                        else if ( (LA37_0=='i') ) {s = 15;}

                        else if ( (LA37_0==';') ) {s = 16;}

                        else if ( (LA37_0=='m') ) {s = 17;}

                        else if ( (LA37_0=='{') ) {s = 18;}

                        else if ( (LA37_0=='}') ) {s = 19;}

                        else if ( (LA37_0==',') ) {s = 20;}

                        else if ( (LA37_0=='g') ) {s = 21;}

                        else if ( (LA37_0=='s') ) {s = 22;}

                        else if ( (LA37_0=='r') ) {s = 23;}

                        else if ( (LA37_0=='(') ) {s = 24;}

                        else if ( (LA37_0==')') ) {s = 25;}

                        else if ( (LA37_0=='o') ) {s = 26;}

                        else if ( (LA37_0=='v') ) {s = 27;}

                        else if ( (LA37_0=='f') ) {s = 28;}

                        else if ( (LA37_0=='u') ) {s = 29;}

                        else if ( (LA37_0=='w') ) {s = 30;}

                        else if ( (LA37_0=='b') ) {s = 31;}

                        else if ( (LA37_0=='O') ) {s = 32;}

                        else if ( (LA37_0=='V') ) {s = 33;}

                        else if ( (LA37_0=='e') ) {s = 34;}

                        else if ( (LA37_0=='[') ) {s = 35;}

                        else if ( (LA37_0==']') ) {s = 36;}

                        else if ( (LA37_0=='|') ) {s = 37;}

                        else if ( (LA37_0=='^') ) {s = 38;}

                        else if ( (LA37_0=='&') ) {s = 39;}

                        else if ( (LA37_0=='+') ) {s = 40;}

                        else if ( (LA37_0=='-') ) {s = 41;}

                        else if ( (LA37_0=='*') ) {s = 42;}

                        else if ( (LA37_0=='/') ) {s = 43;}

                        else if ( (LA37_0=='%') ) {s = 44;}

                        else if ( (LA37_0=='~') ) {s = 45;}

                        else if ( (LA37_0=='h') ) {s = 46;}

                        else if ( (LA37_0=='0') ) {s = 47;}

                        else if ( ((LA37_0>='1' && LA37_0<='9')) ) {s = 48;}

                        else if ( (LA37_0=='\'') ) {s = 49;}

                        else if ( (LA37_0=='T') ) {s = 50;}

                        else if ( (LA37_0=='F') ) {s = 51;}

                        else if ( ((LA37_0>='A' && LA37_0<='E')||(LA37_0>='G' && LA37_0<='N')||(LA37_0>='P' && LA37_0<='S')||LA37_0=='U'||(LA37_0>='W' && LA37_0<='Z')||LA37_0=='_'||(LA37_0>='j' && LA37_0<='k')||LA37_0=='q'||(LA37_0>='x' && LA37_0<='z')) ) {s = 52;}

                        else if ( (LA37_0=='\"') ) {s = 53;}

                        else if ( ((LA37_0>='\t' && LA37_0<='\n')||LA37_0=='\r'||LA37_0==' ') ) {s = 54;}

                        else if ( ((LA37_0>='\u0000' && LA37_0<='\b')||(LA37_0>='\u000B' && LA37_0<='\f')||(LA37_0>='\u000E' && LA37_0<='\u001F')||LA37_0=='$'||(LA37_0>='?' && LA37_0<='@')||LA37_0=='\\'||LA37_0=='`'||(LA37_0>='\u007F' && LA37_0<='\uFFFF')) ) {s = 55;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA37_389 = input.LA(1);

                        s = -1;
                        if ( (LA37_389=='\'') ) {s = 455;}

                        else if ( ((LA37_389>='\u0000' && LA37_389<='&')||(LA37_389>='(' && LA37_389<='\uFFFF')) ) {s = 161;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA37_157 = input.LA(1);

                        s = -1;
                        if ( (LA37_157=='\'') ) {s = 235;}

                        else if ( ((LA37_157>='\u0000' && LA37_157<='&')||(LA37_157>='(' && LA37_157<='\uFFFF')) ) {s = 161;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA37_53 = input.LA(1);

                        s = -1;
                        if ( ((LA37_53>='\u0000' && LA37_53<='\uFFFF')) ) {s = 161;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}