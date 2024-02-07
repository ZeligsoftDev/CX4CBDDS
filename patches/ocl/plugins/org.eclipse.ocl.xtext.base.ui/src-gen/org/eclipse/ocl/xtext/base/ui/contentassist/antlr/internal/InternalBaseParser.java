package org.eclipse.ocl.xtext.base.ui.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalBaseParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'|?'", "'*'", "'+'", "'?'", "'..'", "'['", "']'", "'::'", "','", "'extends'", "'&&'", "'('", "')'", "'|1'"
    };
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


        public InternalBaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);

        }


    public String[] getTokenNames() { return InternalBaseParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBase.g"; }



     	private BaseGrammarAccess grammarAccess;

        public void setGrammarAccess(BaseGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }

        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // InternalBase.g:68:1: entryRuleMultiplicityBoundsCS : ruleMultiplicityBoundsCS EOF ;
    public final void entryRuleMultiplicityBoundsCS() throws RecognitionException {
        try {
            // InternalBase.g:69:1: ( ruleMultiplicityBoundsCS EOF )
            // InternalBase.g:70:1: ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicityBoundsCS"


    // $ANTLR start "ruleMultiplicityBoundsCS"
    // InternalBase.g:77:1: ruleMultiplicityBoundsCS : ( ( rule__MultiplicityBoundsCS__Group__0 ) ) ;
    public final void ruleMultiplicityBoundsCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:81:2: ( ( ( rule__MultiplicityBoundsCS__Group__0 ) ) )
            // InternalBase.g:82:1: ( ( rule__MultiplicityBoundsCS__Group__0 ) )
            {
            // InternalBase.g:82:1: ( ( rule__MultiplicityBoundsCS__Group__0 ) )
            // InternalBase.g:83:1: ( rule__MultiplicityBoundsCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup());
            }
            // InternalBase.g:84:1: ( rule__MultiplicityBoundsCS__Group__0 )
            // InternalBase.g:84:2: rule__MultiplicityBoundsCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityBoundsCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getGroup());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicityBoundsCS"


    // $ANTLR start "entryRuleMultiplicityCS"
    // InternalBase.g:96:1: entryRuleMultiplicityCS : ruleMultiplicityCS EOF ;
    public final void entryRuleMultiplicityCS() throws RecognitionException {
        try {
            // InternalBase.g:97:1: ( ruleMultiplicityCS EOF )
            // InternalBase.g:98:1: ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicityCS"


    // $ANTLR start "ruleMultiplicityCS"
    // InternalBase.g:105:1: ruleMultiplicityCS : ( ( rule__MultiplicityCS__Group__0 ) ) ;
    public final void ruleMultiplicityCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:109:2: ( ( ( rule__MultiplicityCS__Group__0 ) ) )
            // InternalBase.g:110:1: ( ( rule__MultiplicityCS__Group__0 ) )
            {
            // InternalBase.g:110:1: ( ( rule__MultiplicityCS__Group__0 ) )
            // InternalBase.g:111:1: ( rule__MultiplicityCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getGroup());
            }
            // InternalBase.g:112:1: ( rule__MultiplicityCS__Group__0 )
            // InternalBase.g:112:2: rule__MultiplicityCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getGroup());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicityCS"


    // $ANTLR start "entryRuleMultiplicityStringCS"
    // InternalBase.g:124:1: entryRuleMultiplicityStringCS : ruleMultiplicityStringCS EOF ;
    public final void entryRuleMultiplicityStringCS() throws RecognitionException {
        try {
            // InternalBase.g:125:1: ( ruleMultiplicityStringCS EOF )
            // InternalBase.g:126:1: ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityStringCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicityStringCS"


    // $ANTLR start "ruleMultiplicityStringCS"
    // InternalBase.g:133:1: ruleMultiplicityStringCS : ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) ) ;
    public final void ruleMultiplicityStringCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:137:2: ( ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) ) )
            // InternalBase.g:138:1: ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) )
            {
            // InternalBase.g:138:1: ( ( rule__MultiplicityStringCS__StringBoundsAssignment ) )
            // InternalBase.g:139:1: ( rule__MultiplicityStringCS__StringBoundsAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment());
            }
            // InternalBase.g:140:1: ( rule__MultiplicityStringCS__StringBoundsAssignment )
            // InternalBase.g:140:2: rule__MultiplicityStringCS__StringBoundsAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityStringCS__StringBoundsAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicityStringCS"


    // $ANTLR start "entryRulePathNameCS"
    // InternalBase.g:152:1: entryRulePathNameCS : rulePathNameCS EOF ;
    public final void entryRulePathNameCS() throws RecognitionException {
        try {
            // InternalBase.g:153:1: ( rulePathNameCS EOF )
            // InternalBase.g:154:1: rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePathNameCS"


    // $ANTLR start "rulePathNameCS"
    // InternalBase.g:161:1: rulePathNameCS : ( ( rule__PathNameCS__Group__0 ) ) ;
    public final void rulePathNameCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:165:2: ( ( ( rule__PathNameCS__Group__0 ) ) )
            // InternalBase.g:166:1: ( ( rule__PathNameCS__Group__0 ) )
            {
            // InternalBase.g:166:1: ( ( rule__PathNameCS__Group__0 ) )
            // InternalBase.g:167:1: ( rule__PathNameCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup());
            }
            // InternalBase.g:168:1: ( rule__PathNameCS__Group__0 )
            // InternalBase.g:168:2: rule__PathNameCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PathNameCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getGroup());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRuleFirstPathElementCS"
    // InternalBase.g:182:1: entryRuleFirstPathElementCS : ruleFirstPathElementCS EOF ;
    public final void entryRuleFirstPathElementCS() throws RecognitionException {
        try {
            // InternalBase.g:183:1: ( ruleFirstPathElementCS EOF )
            // InternalBase.g:184:1: ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFirstPathElementCS"


    // $ANTLR start "ruleFirstPathElementCS"
    // InternalBase.g:191:1: ruleFirstPathElementCS : ( ( rule__FirstPathElementCS__ReferredElementAssignment ) ) ;
    public final void ruleFirstPathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:195:2: ( ( ( rule__FirstPathElementCS__ReferredElementAssignment ) ) )
            // InternalBase.g:196:1: ( ( rule__FirstPathElementCS__ReferredElementAssignment ) )
            {
            // InternalBase.g:196:1: ( ( rule__FirstPathElementCS__ReferredElementAssignment ) )
            // InternalBase.g:197:1: ( rule__FirstPathElementCS__ReferredElementAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment());
            }
            // InternalBase.g:198:1: ( rule__FirstPathElementCS__ReferredElementAssignment )
            // InternalBase.g:198:2: rule__FirstPathElementCS__ReferredElementAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FirstPathElementCS__ReferredElementAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFirstPathElementCS"


    // $ANTLR start "entryRuleNextPathElementCS"
    // InternalBase.g:210:1: entryRuleNextPathElementCS : ruleNextPathElementCS EOF ;
    public final void entryRuleNextPathElementCS() throws RecognitionException {
        try {
            // InternalBase.g:211:1: ( ruleNextPathElementCS EOF )
            // InternalBase.g:212:1: ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNextPathElementCS"


    // $ANTLR start "ruleNextPathElementCS"
    // InternalBase.g:219:1: ruleNextPathElementCS : ( ( rule__NextPathElementCS__ReferredElementAssignment ) ) ;
    public final void ruleNextPathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:223:2: ( ( ( rule__NextPathElementCS__ReferredElementAssignment ) ) )
            // InternalBase.g:224:1: ( ( rule__NextPathElementCS__ReferredElementAssignment ) )
            {
            // InternalBase.g:224:1: ( ( rule__NextPathElementCS__ReferredElementAssignment ) )
            // InternalBase.g:225:1: ( rule__NextPathElementCS__ReferredElementAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment());
            }
            // InternalBase.g:226:1: ( rule__NextPathElementCS__ReferredElementAssignment )
            // InternalBase.g:226:2: rule__NextPathElementCS__ReferredElementAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NextPathElementCS__ReferredElementAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNextPathElementCS"


    // $ANTLR start "entryRuleTemplateBindingCS"
    // InternalBase.g:238:1: entryRuleTemplateBindingCS : ruleTemplateBindingCS EOF ;
    public final void entryRuleTemplateBindingCS() throws RecognitionException {
        try {
            // InternalBase.g:239:1: ( ruleTemplateBindingCS EOF )
            // InternalBase.g:240:1: ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTemplateBindingCS"


    // $ANTLR start "ruleTemplateBindingCS"
    // InternalBase.g:247:1: ruleTemplateBindingCS : ( ( rule__TemplateBindingCS__Group__0 ) ) ;
    public final void ruleTemplateBindingCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:251:2: ( ( ( rule__TemplateBindingCS__Group__0 ) ) )
            // InternalBase.g:252:1: ( ( rule__TemplateBindingCS__Group__0 ) )
            {
            // InternalBase.g:252:1: ( ( rule__TemplateBindingCS__Group__0 ) )
            // InternalBase.g:253:1: ( rule__TemplateBindingCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup());
            }
            // InternalBase.g:254:1: ( rule__TemplateBindingCS__Group__0 )
            // InternalBase.g:254:2: rule__TemplateBindingCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateBindingCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getGroup());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTemplateBindingCS"


    // $ANTLR start "entryRuleTemplateParameterSubstitutionCS"
    // InternalBase.g:266:1: entryRuleTemplateParameterSubstitutionCS : ruleTemplateParameterSubstitutionCS EOF ;
    public final void entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        try {
            // InternalBase.g:267:1: ( ruleTemplateParameterSubstitutionCS EOF )
            // InternalBase.g:268:1: ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTemplateParameterSubstitutionCS"


    // $ANTLR start "ruleTemplateParameterSubstitutionCS"
    // InternalBase.g:275:1: ruleTemplateParameterSubstitutionCS : ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) ) ;
    public final void ruleTemplateParameterSubstitutionCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:279:2: ( ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) ) )
            // InternalBase.g:280:1: ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) )
            {
            // InternalBase.g:280:1: ( ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment ) )
            // InternalBase.g:281:1: ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment());
            }
            // InternalBase.g:282:1: ( rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment )
            // InternalBase.g:282:2: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTemplateParameterSubstitutionCS"


    // $ANTLR start "entryRuleTypeParameterCS"
    // InternalBase.g:296:1: entryRuleTypeParameterCS : ruleTypeParameterCS EOF ;
    public final void entryRuleTypeParameterCS() throws RecognitionException {
        try {
            // InternalBase.g:297:1: ( ruleTypeParameterCS EOF )
            // InternalBase.g:298:1: ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeParameterCS"


    // $ANTLR start "ruleTypeParameterCS"
    // InternalBase.g:305:1: ruleTypeParameterCS : ( ( rule__TypeParameterCS__Group__0 ) ) ;
    public final void ruleTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:309:2: ( ( ( rule__TypeParameterCS__Group__0 ) ) )
            // InternalBase.g:310:1: ( ( rule__TypeParameterCS__Group__0 ) )
            {
            // InternalBase.g:310:1: ( ( rule__TypeParameterCS__Group__0 ) )
            // InternalBase.g:311:1: ( rule__TypeParameterCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup());
            }
            // InternalBase.g:312:1: ( rule__TypeParameterCS__Group__0 )
            // InternalBase.g:312:2: rule__TypeParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getGroup());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeParameterCS"


    // $ANTLR start "entryRuleTypeRefCS"
    // InternalBase.g:324:1: entryRuleTypeRefCS : ruleTypeRefCS EOF ;
    public final void entryRuleTypeRefCS() throws RecognitionException {
        try {
            // InternalBase.g:325:1: ( ruleTypeRefCS EOF )
            // InternalBase.g:326:1: ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeRefCS"


    // $ANTLR start "ruleTypeRefCS"
    // InternalBase.g:333:1: ruleTypeRefCS : ( ( rule__TypeRefCS__Alternatives ) ) ;
    public final void ruleTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:337:2: ( ( ( rule__TypeRefCS__Alternatives ) ) )
            // InternalBase.g:338:1: ( ( rule__TypeRefCS__Alternatives ) )
            {
            // InternalBase.g:338:1: ( ( rule__TypeRefCS__Alternatives ) )
            // InternalBase.g:339:1: ( rule__TypeRefCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRefCSAccess().getAlternatives());
            }
            // InternalBase.g:340:1: ( rule__TypeRefCS__Alternatives )
            // InternalBase.g:340:2: rule__TypeRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRefCS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRefCSAccess().getAlternatives());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRefCS"


    // $ANTLR start "entryRuleTypedRefCS"
    // InternalBase.g:352:1: entryRuleTypedRefCS : ruleTypedRefCS EOF ;
    public final void entryRuleTypedRefCS() throws RecognitionException {
        try {
            // InternalBase.g:353:1: ( ruleTypedRefCS EOF )
            // InternalBase.g:354:1: ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedRefCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypedRefCS"


    // $ANTLR start "ruleTypedRefCS"
    // InternalBase.g:361:1: ruleTypedRefCS : ( ruleTypedTypeRefCS ) ;
    public final void ruleTypedRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:365:2: ( ( ruleTypedTypeRefCS ) )
            // InternalBase.g:366:1: ( ruleTypedTypeRefCS )
            {
            // InternalBase.g:366:1: ( ruleTypedTypeRefCS )
            // InternalBase.g:367:1: ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypedRefCS"


    // $ANTLR start "entryRuleTypedTypeRefCS"
    // InternalBase.g:380:1: entryRuleTypedTypeRefCS : ruleTypedTypeRefCS EOF ;
    public final void entryRuleTypedTypeRefCS() throws RecognitionException {
        try {
            // InternalBase.g:381:1: ( ruleTypedTypeRefCS EOF )
            // InternalBase.g:382:1: ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypedTypeRefCS"


    // $ANTLR start "ruleTypedTypeRefCS"
    // InternalBase.g:389:1: ruleTypedTypeRefCS : ( ( rule__TypedTypeRefCS__Group__0 ) ) ;
    public final void ruleTypedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:393:2: ( ( ( rule__TypedTypeRefCS__Group__0 ) ) )
            // InternalBase.g:394:1: ( ( rule__TypedTypeRefCS__Group__0 ) )
            {
            // InternalBase.g:394:1: ( ( rule__TypedTypeRefCS__Group__0 ) )
            // InternalBase.g:395:1: ( rule__TypedTypeRefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getGroup());
            }
            // InternalBase.g:396:1: ( rule__TypedTypeRefCS__Group__0 )
            // InternalBase.g:396:2: rule__TypedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypedTypeRefCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getGroup());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypedTypeRefCS"


    // $ANTLR start "entryRuleUnreservedName"
    // InternalBase.g:408:1: entryRuleUnreservedName : ruleUnreservedName EOF ;
    public final void entryRuleUnreservedName() throws RecognitionException {
        try {
            // InternalBase.g:409:1: ( ruleUnreservedName EOF )
            // InternalBase.g:410:1: ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnreservedNameRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnreservedName"


    // $ANTLR start "ruleUnreservedName"
    // InternalBase.g:417:1: ruleUnreservedName : ( ruleUnrestrictedName ) ;
    public final void ruleUnreservedName() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:421:2: ( ( ruleUnrestrictedName ) )
            // InternalBase.g:422:1: ( ruleUnrestrictedName )
            {
            // InternalBase.g:422:1: ( ruleUnrestrictedName )
            // InternalBase.g:423:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnreservedNameAccess().getUnrestrictedNameParserRuleCall());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnreservedName"


    // $ANTLR start "entryRuleUnrestrictedName"
    // InternalBase.g:436:1: entryRuleUnrestrictedName : ruleUnrestrictedName EOF ;
    public final void entryRuleUnrestrictedName() throws RecognitionException {
        try {
            // InternalBase.g:437:1: ( ruleUnrestrictedName EOF )
            // InternalBase.g:438:1: ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnrestrictedName"


    // $ANTLR start "ruleUnrestrictedName"
    // InternalBase.g:445:1: ruleUnrestrictedName : ( ruleIdentifier ) ;
    public final void ruleUnrestrictedName() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:449:2: ( ( ruleIdentifier ) )
            // InternalBase.g:450:1: ( ruleIdentifier )
            {
            // InternalBase.g:450:1: ( ruleIdentifier )
            // InternalBase.g:451:1: ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameAccess().getIdentifierParserRuleCall());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // InternalBase.g:464:1: entryRuleWildcardTypeRefCS : ruleWildcardTypeRefCS EOF ;
    public final void entryRuleWildcardTypeRefCS() throws RecognitionException {
        try {
            // InternalBase.g:465:1: ( ruleWildcardTypeRefCS EOF )
            // InternalBase.g:466:1: ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWildcardTypeRefCS"


    // $ANTLR start "ruleWildcardTypeRefCS"
    // InternalBase.g:473:1: ruleWildcardTypeRefCS : ( ( rule__WildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:477:2: ( ( ( rule__WildcardTypeRefCS__Group__0 ) ) )
            // InternalBase.g:478:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            {
            // InternalBase.g:478:1: ( ( rule__WildcardTypeRefCS__Group__0 ) )
            // InternalBase.g:479:1: ( rule__WildcardTypeRefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup());
            }
            // InternalBase.g:480:1: ( rule__WildcardTypeRefCS__Group__0 )
            // InternalBase.g:480:2: rule__WildcardTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WildcardTypeRefCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getGroup());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWildcardTypeRefCS"


    // $ANTLR start "entryRuleID"
    // InternalBase.g:492:1: entryRuleID : ruleID EOF ;
    public final void entryRuleID() throws RecognitionException {
        try {
            // InternalBase.g:493:1: ( ruleID EOF )
            // InternalBase.g:494:1: ruleID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleID"


    // $ANTLR start "ruleID"
    // InternalBase.g:501:1: ruleID : ( ( rule__ID__Alternatives ) ) ;
    public final void ruleID() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:505:2: ( ( ( rule__ID__Alternatives ) ) )
            // InternalBase.g:506:1: ( ( rule__ID__Alternatives ) )
            {
            // InternalBase.g:506:1: ( ( rule__ID__Alternatives ) )
            // InternalBase.g:507:1: ( rule__ID__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getAlternatives());
            }
            // InternalBase.g:508:1: ( rule__ID__Alternatives )
            // InternalBase.g:508:2: rule__ID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ID__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDAccess().getAlternatives());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleIdentifier"
    // InternalBase.g:520:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // InternalBase.g:521:1: ( ruleIdentifier EOF )
            // InternalBase.g:522:1: ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalBase.g:529:1: ruleIdentifier : ( ruleID ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:533:2: ( ( ruleID ) )
            // InternalBase.g:534:1: ( ruleID )
            {
            // InternalBase.g:534:1: ( ruleID )
            // InternalBase.g:535:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierAccess().getIDParserRuleCall());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierAccess().getIDParserRuleCall());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleLOWER"
    // InternalBase.g:548:1: entryRuleLOWER : ruleLOWER EOF ;
    public final void entryRuleLOWER() throws RecognitionException {
        try {
            // InternalBase.g:549:1: ( ruleLOWER EOF )
            // InternalBase.g:550:1: ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLOWER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLOWERRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLOWER"


    // $ANTLR start "ruleLOWER"
    // InternalBase.g:557:1: ruleLOWER : ( RULE_INT ) ;
    public final void ruleLOWER() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:561:2: ( ( RULE_INT ) )
            // InternalBase.g:562:1: ( RULE_INT )
            {
            // InternalBase.g:562:1: ( RULE_INT )
            // InternalBase.g:563:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall());
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLOWERAccess().getINTTerminalRuleCall());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLOWER"


    // $ANTLR start "entryRuleUPPER"
    // InternalBase.g:580:1: entryRuleUPPER : ruleUPPER EOF ;
    public final void entryRuleUPPER() throws RecognitionException {
        try {
            // InternalBase.g:581:1: ( ruleUPPER EOF )
            // InternalBase.g:582:1: ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUPPER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUPPERRule());
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUPPER"


    // $ANTLR start "ruleUPPER"
    // InternalBase.g:589:1: ruleUPPER : ( ( rule__UPPER__Alternatives ) ) ;
    public final void ruleUPPER() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:593:2: ( ( ( rule__UPPER__Alternatives ) ) )
            // InternalBase.g:594:1: ( ( rule__UPPER__Alternatives ) )
            {
            // InternalBase.g:594:1: ( ( rule__UPPER__Alternatives ) )
            // InternalBase.g:595:1: ( rule__UPPER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUPPERAccess().getAlternatives());
            }
            // InternalBase.g:596:1: ( rule__UPPER__Alternatives )
            // InternalBase.g:596:2: rule__UPPER__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UPPER__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUPPERAccess().getAlternatives());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUPPER"


    // $ANTLR start "rule__MultiplicityCS__Alternatives_1"
    // InternalBase.g:610:1: rule__MultiplicityCS__Alternatives_1 : ( ( ruleMultiplicityBoundsCS ) | ( ruleMultiplicityStringCS ) );
    public final void rule__MultiplicityCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:614:1: ( ( ruleMultiplicityBoundsCS ) | ( ruleMultiplicityStringCS ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_INT) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=17 && LA1_0<=19)) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBase.g:615:1: ( ruleMultiplicityBoundsCS )
                    {
                    // InternalBase.g:615:1: ( ruleMultiplicityBoundsCS )
                    // InternalBase.g:616:1: ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0());
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleMultiplicityBoundsCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0());
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:621:6: ( ruleMultiplicityStringCS )
                    {
                    // InternalBase.g:621:6: ( ruleMultiplicityStringCS )
                    // InternalBase.g:622:1: ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1());
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleMultiplicityStringCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1());
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Alternatives_1"


    // $ANTLR start "rule__MultiplicityCS__Alternatives_2"
    // InternalBase.g:632:1: rule__MultiplicityCS__Alternatives_2 : ( ( '|?' ) | ( ( rule__MultiplicityCS__IsNullFreeAssignment_2_1 ) ) );
    public final void rule__MultiplicityCS__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:636:1: ( ( '|?' ) | ( ( rule__MultiplicityCS__IsNullFreeAssignment_2_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==29) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalBase.g:637:1: ( '|?' )
                    {
                    // InternalBase.g:637:1: ( '|?' )
                    // InternalBase.g:638:1: '|?'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                    }
                    match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:645:6: ( ( rule__MultiplicityCS__IsNullFreeAssignment_2_1 ) )
                    {
                    // InternalBase.g:645:6: ( ( rule__MultiplicityCS__IsNullFreeAssignment_2_1 ) )
                    // InternalBase.g:646:1: ( rule__MultiplicityCS__IsNullFreeAssignment_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getIsNullFreeAssignment_2_1());
                    }
                    // InternalBase.g:647:1: ( rule__MultiplicityCS__IsNullFreeAssignment_2_1 )
                    // InternalBase.g:647:2: rule__MultiplicityCS__IsNullFreeAssignment_2_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MultiplicityCS__IsNullFreeAssignment_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getIsNullFreeAssignment_2_1());
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Alternatives_2"


    // $ANTLR start "rule__MultiplicityStringCS__StringBoundsAlternatives_0"
    // InternalBase.g:656:1: rule__MultiplicityStringCS__StringBoundsAlternatives_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__MultiplicityStringCS__StringBoundsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:660:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 19:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalBase.g:661:1: ( '*' )
                    {
                    // InternalBase.g:661:1: ( '*' )
                    // InternalBase.g:662:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());
                    }
                    match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:669:6: ( '+' )
                    {
                    // InternalBase.g:669:6: ( '+' )
                    // InternalBase.g:670:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());
                    }
                    match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBase.g:677:6: ( '?' )
                    {
                    // InternalBase.g:677:6: ( '?' )
                    // InternalBase.g:678:1: '?'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2());
                    }
                    match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2());
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityStringCS__StringBoundsAlternatives_0"


    // $ANTLR start "rule__TypeRefCS__Alternatives"
    // InternalBase.g:690:1: rule__TypeRefCS__Alternatives : ( ( ruleTypedRefCS ) | ( ruleWildcardTypeRefCS ) );
    public final void rule__TypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:694:1: ( ( ruleTypedRefCS ) | ( ruleWildcardTypeRefCS ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_SIMPLE_ID && LA4_0<=RULE_ESCAPED_ID)) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBase.g:695:1: ( ruleTypedRefCS )
                    {
                    // InternalBase.g:695:1: ( ruleTypedRefCS )
                    // InternalBase.g:696:1: ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0());
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0());
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:701:6: ( ruleWildcardTypeRefCS )
                    {
                    // InternalBase.g:701:6: ( ruleWildcardTypeRefCS )
                    // InternalBase.g:702:1: ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1());
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWildcardTypeRefCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1());
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRefCS__Alternatives"


    // $ANTLR start "rule__ID__Alternatives"
    // InternalBase.g:712:1: rule__ID__Alternatives : ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) );
    public final void rule__ID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:716:1: ( ( RULE_SIMPLE_ID ) | ( RULE_ESCAPED_ID ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_SIMPLE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ESCAPED_ID) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBase.g:717:1: ( RULE_SIMPLE_ID )
                    {
                    // InternalBase.g:717:1: ( RULE_SIMPLE_ID )
                    // InternalBase.g:718:1: RULE_SIMPLE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0());
                    }
                    match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0());
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:723:6: ( RULE_ESCAPED_ID )
                    {
                    // InternalBase.g:723:6: ( RULE_ESCAPED_ID )
                    // InternalBase.g:724:1: RULE_ESCAPED_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1());
                    }
                    match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1());
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ID__Alternatives"


    // $ANTLR start "rule__UPPER__Alternatives"
    // InternalBase.g:734:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:738:1: ( ( RULE_INT ) | ( '*' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBase.g:739:1: ( RULE_INT )
                    {
                    // InternalBase.g:739:1: ( RULE_INT )
                    // InternalBase.g:740:1: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0());
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0());
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBase.g:745:6: ( '*' )
                    {
                    // InternalBase.g:745:6: ( '*' )
                    // InternalBase.g:746:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1());
                    }
                    match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getAsteriskKeyword_1());
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UPPER__Alternatives"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group__0"
    // InternalBase.g:760:1: rule__MultiplicityBoundsCS__Group__0 : rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 ;
    public final void rule__MultiplicityBoundsCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:764:1: ( rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1 )
            // InternalBase.g:765:2: rule__MultiplicityBoundsCS__Group__0__Impl rule__MultiplicityBoundsCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__MultiplicityBoundsCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityBoundsCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__Group__0"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group__0__Impl"
    // InternalBase.g:772:1: rule__MultiplicityBoundsCS__Group__0__Impl : ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:776:1: ( ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) ) )
            // InternalBase.g:777:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            {
            // InternalBase.g:777:1: ( ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 ) )
            // InternalBase.g:778:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0());
            }
            // InternalBase.g:779:1: ( rule__MultiplicityBoundsCS__LowerBoundAssignment_0 )
            // InternalBase.g:779:2: rule__MultiplicityBoundsCS__LowerBoundAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityBoundsCS__LowerBoundAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__Group__0__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group__1"
    // InternalBase.g:789:1: rule__MultiplicityBoundsCS__Group__1 : rule__MultiplicityBoundsCS__Group__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:793:1: ( rule__MultiplicityBoundsCS__Group__1__Impl )
            // InternalBase.g:794:2: rule__MultiplicityBoundsCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityBoundsCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__Group__1"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group__1__Impl"
    // InternalBase.g:800:1: rule__MultiplicityBoundsCS__Group__1__Impl : ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) ;
    public final void rule__MultiplicityBoundsCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:804:1: ( ( ( rule__MultiplicityBoundsCS__Group_1__0 )? ) )
            // InternalBase.g:805:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            {
            // InternalBase.g:805:1: ( ( rule__MultiplicityBoundsCS__Group_1__0 )? )
            // InternalBase.g:806:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1());
            }
            // InternalBase.g:807:1: ( rule__MultiplicityBoundsCS__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalBase.g:807:2: rule__MultiplicityBoundsCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MultiplicityBoundsCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__Group__1__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group_1__0"
    // InternalBase.g:821:1: rule__MultiplicityBoundsCS__Group_1__0 : rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 ;
    public final void rule__MultiplicityBoundsCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:825:1: ( rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1 )
            // InternalBase.g:826:2: rule__MultiplicityBoundsCS__Group_1__0__Impl rule__MultiplicityBoundsCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__MultiplicityBoundsCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityBoundsCS__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__Group_1__0"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group_1__0__Impl"
    // InternalBase.g:833:1: rule__MultiplicityBoundsCS__Group_1__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:837:1: ( ( '..' ) )
            // InternalBase.g:838:1: ( '..' )
            {
            // InternalBase.g:838:1: ( '..' )
            // InternalBase.g:839:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__Group_1__0__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group_1__1"
    // InternalBase.g:852:1: rule__MultiplicityBoundsCS__Group_1__1 : rule__MultiplicityBoundsCS__Group_1__1__Impl ;
    public final void rule__MultiplicityBoundsCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:856:1: ( rule__MultiplicityBoundsCS__Group_1__1__Impl )
            // InternalBase.g:857:2: rule__MultiplicityBoundsCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityBoundsCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__Group_1__1"


    // $ANTLR start "rule__MultiplicityBoundsCS__Group_1__1__Impl"
    // InternalBase.g:863:1: rule__MultiplicityBoundsCS__Group_1__1__Impl : ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) ;
    public final void rule__MultiplicityBoundsCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:867:1: ( ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) ) )
            // InternalBase.g:868:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            {
            // InternalBase.g:868:1: ( ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 ) )
            // InternalBase.g:869:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1());
            }
            // InternalBase.g:870:1: ( rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 )
            // InternalBase.g:870:2: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__Group_1__1__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group__0"
    // InternalBase.g:884:1: rule__MultiplicityCS__Group__0 : rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1 ;
    public final void rule__MultiplicityCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:888:1: ( rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1 )
            // InternalBase.g:889:2: rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__MultiplicityCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group__0"


    // $ANTLR start "rule__MultiplicityCS__Group__0__Impl"
    // InternalBase.g:896:1: rule__MultiplicityCS__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:900:1: ( ( '[' ) )
            // InternalBase.g:901:1: ( '[' )
            {
            // InternalBase.g:901:1: ( '[' )
            // InternalBase.g:902:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
            }
            match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group__0__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group__1"
    // InternalBase.g:915:1: rule__MultiplicityCS__Group__1 : rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2 ;
    public final void rule__MultiplicityCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:919:1: ( rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2 )
            // InternalBase.g:920:2: rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__MultiplicityCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group__1"


    // $ANTLR start "rule__MultiplicityCS__Group__1__Impl"
    // InternalBase.g:927:1: rule__MultiplicityCS__Group__1__Impl : ( ( rule__MultiplicityCS__Alternatives_1 ) ) ;
    public final void rule__MultiplicityCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:931:1: ( ( ( rule__MultiplicityCS__Alternatives_1 ) ) )
            // InternalBase.g:932:1: ( ( rule__MultiplicityCS__Alternatives_1 ) )
            {
            // InternalBase.g:932:1: ( ( rule__MultiplicityCS__Alternatives_1 ) )
            // InternalBase.g:933:1: ( rule__MultiplicityCS__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getAlternatives_1());
            }
            // InternalBase.g:934:1: ( rule__MultiplicityCS__Alternatives_1 )
            // InternalBase.g:934:2: rule__MultiplicityCS__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityCS__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getAlternatives_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group__1__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group__2"
    // InternalBase.g:944:1: rule__MultiplicityCS__Group__2 : rule__MultiplicityCS__Group__2__Impl rule__MultiplicityCS__Group__3 ;
    public final void rule__MultiplicityCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:948:1: ( rule__MultiplicityCS__Group__2__Impl rule__MultiplicityCS__Group__3 )
            // InternalBase.g:949:2: rule__MultiplicityCS__Group__2__Impl rule__MultiplicityCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__MultiplicityCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityCS__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group__2"


    // $ANTLR start "rule__MultiplicityCS__Group__2__Impl"
    // InternalBase.g:956:1: rule__MultiplicityCS__Group__2__Impl : ( ( rule__MultiplicityCS__Alternatives_2 )? ) ;
    public final void rule__MultiplicityCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:960:1: ( ( ( rule__MultiplicityCS__Alternatives_2 )? ) )
            // InternalBase.g:961:1: ( ( rule__MultiplicityCS__Alternatives_2 )? )
            {
            // InternalBase.g:961:1: ( ( rule__MultiplicityCS__Alternatives_2 )? )
            // InternalBase.g:962:1: ( rule__MultiplicityCS__Alternatives_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getAlternatives_2());
            }
            // InternalBase.g:963:1: ( rule__MultiplicityCS__Alternatives_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16||LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBase.g:963:2: rule__MultiplicityCS__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__MultiplicityCS__Alternatives_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getAlternatives_2());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group__2__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group__3"
    // InternalBase.g:973:1: rule__MultiplicityCS__Group__3 : rule__MultiplicityCS__Group__3__Impl ;
    public final void rule__MultiplicityCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:977:1: ( rule__MultiplicityCS__Group__3__Impl )
            // InternalBase.g:978:2: rule__MultiplicityCS__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group__3"


    // $ANTLR start "rule__MultiplicityCS__Group__3__Impl"
    // InternalBase.g:984:1: rule__MultiplicityCS__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:988:1: ( ( ']' ) )
            // InternalBase.g:989:1: ( ']' )
            {
            // InternalBase.g:989:1: ( ']' )
            // InternalBase.g:990:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());
            }
            match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group__3__Impl"


    // $ANTLR start "rule__PathNameCS__Group__0"
    // InternalBase.g:1011:1: rule__PathNameCS__Group__0 : rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 ;
    public final void rule__PathNameCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1015:1: ( rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 )
            // InternalBase.g:1016:2: rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__PathNameCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PathNameCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group__0"


    // $ANTLR start "rule__PathNameCS__Group__0__Impl"
    // InternalBase.g:1023:1: rule__PathNameCS__Group__0__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) ;
    public final void rule__PathNameCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1027:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) ) )
            // InternalBase.g:1028:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            {
            // InternalBase.g:1028:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_0 ) )
            // InternalBase.g:1029:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0());
            }
            // InternalBase.g:1030:1: ( rule__PathNameCS__OwnedPathElementsAssignment_0 )
            // InternalBase.g:1030:2: rule__PathNameCS__OwnedPathElementsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PathNameCS__OwnedPathElementsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group__0__Impl"


    // $ANTLR start "rule__PathNameCS__Group__1"
    // InternalBase.g:1040:1: rule__PathNameCS__Group__1 : rule__PathNameCS__Group__1__Impl ;
    public final void rule__PathNameCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1044:1: ( rule__PathNameCS__Group__1__Impl )
            // InternalBase.g:1045:2: rule__PathNameCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PathNameCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group__1"


    // $ANTLR start "rule__PathNameCS__Group__1__Impl"
    // InternalBase.g:1051:1: rule__PathNameCS__Group__1__Impl : ( ( rule__PathNameCS__Group_1__0 )* ) ;
    public final void rule__PathNameCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1055:1: ( ( ( rule__PathNameCS__Group_1__0 )* ) )
            // InternalBase.g:1056:1: ( ( rule__PathNameCS__Group_1__0 )* )
            {
            // InternalBase.g:1056:1: ( ( rule__PathNameCS__Group_1__0 )* )
            // InternalBase.g:1057:1: ( rule__PathNameCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup_1());
            }
            // InternalBase.g:1058:1: ( rule__PathNameCS__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBase.g:1058:2: rule__PathNameCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__PathNameCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getGroup_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group__1__Impl"


    // $ANTLR start "rule__PathNameCS__Group_1__0"
    // InternalBase.g:1072:1: rule__PathNameCS__Group_1__0 : rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 ;
    public final void rule__PathNameCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1076:1: ( rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 )
            // InternalBase.g:1077:2: rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__PathNameCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PathNameCS__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group_1__0"


    // $ANTLR start "rule__PathNameCS__Group_1__0__Impl"
    // InternalBase.g:1084:1: rule__PathNameCS__Group_1__0__Impl : ( '::' ) ;
    public final void rule__PathNameCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1088:1: ( ( '::' ) )
            // InternalBase.g:1089:1: ( '::' )
            {
            // InternalBase.g:1089:1: ( '::' )
            // InternalBase.g:1090:1: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            }
            match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group_1__0__Impl"


    // $ANTLR start "rule__PathNameCS__Group_1__1"
    // InternalBase.g:1103:1: rule__PathNameCS__Group_1__1 : rule__PathNameCS__Group_1__1__Impl ;
    public final void rule__PathNameCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1107:1: ( rule__PathNameCS__Group_1__1__Impl )
            // InternalBase.g:1108:2: rule__PathNameCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PathNameCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group_1__1"


    // $ANTLR start "rule__PathNameCS__Group_1__1__Impl"
    // InternalBase.g:1114:1: rule__PathNameCS__Group_1__1__Impl : ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) ;
    public final void rule__PathNameCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1118:1: ( ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) ) )
            // InternalBase.g:1119:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            {
            // InternalBase.g:1119:1: ( ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 ) )
            // InternalBase.g:1120:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1());
            }
            // InternalBase.g:1121:1: ( rule__PathNameCS__OwnedPathElementsAssignment_1_1 )
            // InternalBase.g:1121:2: rule__PathNameCS__OwnedPathElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PathNameCS__OwnedPathElementsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group_1__1__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group__0"
    // InternalBase.g:1137:1: rule__TemplateBindingCS__Group__0 : rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 ;
    public final void rule__TemplateBindingCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1141:1: ( rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1 )
            // InternalBase.g:1142:2: rule__TemplateBindingCS__Group__0__Impl rule__TemplateBindingCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__TemplateBindingCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateBindingCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group__0"


    // $ANTLR start "rule__TemplateBindingCS__Group__0__Impl"
    // InternalBase.g:1149:1: rule__TemplateBindingCS__Group__0__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) ) ;
    public final void rule__TemplateBindingCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1153:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) ) )
            // InternalBase.g:1154:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) )
            {
            // InternalBase.g:1154:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 ) )
            // InternalBase.g:1155:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0());
            }
            // InternalBase.g:1156:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 )
            // InternalBase.g:1156:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group__0__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group__1"
    // InternalBase.g:1166:1: rule__TemplateBindingCS__Group__1 : rule__TemplateBindingCS__Group__1__Impl rule__TemplateBindingCS__Group__2 ;
    public final void rule__TemplateBindingCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1170:1: ( rule__TemplateBindingCS__Group__1__Impl rule__TemplateBindingCS__Group__2 )
            // InternalBase.g:1171:2: rule__TemplateBindingCS__Group__1__Impl rule__TemplateBindingCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__TemplateBindingCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateBindingCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group__1"


    // $ANTLR start "rule__TemplateBindingCS__Group__1__Impl"
    // InternalBase.g:1178:1: rule__TemplateBindingCS__Group__1__Impl : ( ( rule__TemplateBindingCS__Group_1__0 )* ) ;
    public final void rule__TemplateBindingCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1182:1: ( ( ( rule__TemplateBindingCS__Group_1__0 )* ) )
            // InternalBase.g:1183:1: ( ( rule__TemplateBindingCS__Group_1__0 )* )
            {
            // InternalBase.g:1183:1: ( ( rule__TemplateBindingCS__Group_1__0 )* )
            // InternalBase.g:1184:1: ( rule__TemplateBindingCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getGroup_1());
            }
            // InternalBase.g:1185:1: ( rule__TemplateBindingCS__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalBase.g:1185:2: rule__TemplateBindingCS__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    rule__TemplateBindingCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getGroup_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group__1__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group__2"
    // InternalBase.g:1195:1: rule__TemplateBindingCS__Group__2 : rule__TemplateBindingCS__Group__2__Impl ;
    public final void rule__TemplateBindingCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1199:1: ( rule__TemplateBindingCS__Group__2__Impl )
            // InternalBase.g:1200:2: rule__TemplateBindingCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateBindingCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group__2"


    // $ANTLR start "rule__TemplateBindingCS__Group__2__Impl"
    // InternalBase.g:1206:1: rule__TemplateBindingCS__Group__2__Impl : ( ( rule__TemplateBindingCS__OwnedMultiplicityAssignment_2 )? ) ;
    public final void rule__TemplateBindingCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1210:1: ( ( ( rule__TemplateBindingCS__OwnedMultiplicityAssignment_2 )? ) )
            // InternalBase.g:1211:1: ( ( rule__TemplateBindingCS__OwnedMultiplicityAssignment_2 )? )
            {
            // InternalBase.g:1211:1: ( ( rule__TemplateBindingCS__OwnedMultiplicityAssignment_2 )? )
            // InternalBase.g:1212:1: ( rule__TemplateBindingCS__OwnedMultiplicityAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityAssignment_2());
            }
            // InternalBase.g:1213:1: ( rule__TemplateBindingCS__OwnedMultiplicityAssignment_2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBase.g:1213:2: rule__TemplateBindingCS__OwnedMultiplicityAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TemplateBindingCS__OwnedMultiplicityAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityAssignment_2());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group__2__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group_1__0"
    // InternalBase.g:1229:1: rule__TemplateBindingCS__Group_1__0 : rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1 ;
    public final void rule__TemplateBindingCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1233:1: ( rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1 )
            // InternalBase.g:1234:2: rule__TemplateBindingCS__Group_1__0__Impl rule__TemplateBindingCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__TemplateBindingCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateBindingCS__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group_1__0"


    // $ANTLR start "rule__TemplateBindingCS__Group_1__0__Impl"
    // InternalBase.g:1241:1: rule__TemplateBindingCS__Group_1__0__Impl : ( ',' ) ;
    public final void rule__TemplateBindingCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1245:1: ( ( ',' ) )
            // InternalBase.g:1246:1: ( ',' )
            {
            // InternalBase.g:1246:1: ( ',' )
            // InternalBase.g:1247:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            }
            match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group_1__0__Impl"


    // $ANTLR start "rule__TemplateBindingCS__Group_1__1"
    // InternalBase.g:1260:1: rule__TemplateBindingCS__Group_1__1 : rule__TemplateBindingCS__Group_1__1__Impl ;
    public final void rule__TemplateBindingCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1264:1: ( rule__TemplateBindingCS__Group_1__1__Impl )
            // InternalBase.g:1265:2: rule__TemplateBindingCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateBindingCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group_1__1"


    // $ANTLR start "rule__TemplateBindingCS__Group_1__1__Impl"
    // InternalBase.g:1271:1: rule__TemplateBindingCS__Group_1__1__Impl : ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) ) ;
    public final void rule__TemplateBindingCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1275:1: ( ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) ) )
            // InternalBase.g:1276:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) )
            {
            // InternalBase.g:1276:1: ( ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 ) )
            // InternalBase.g:1277:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1());
            }
            // InternalBase.g:1278:1: ( rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 )
            // InternalBase.g:1278:2: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__Group_1__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group__0"
    // InternalBase.g:1294:1: rule__TypeParameterCS__Group__0 : rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 ;
    public final void rule__TypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1298:1: ( rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1 )
            // InternalBase.g:1299:2: rule__TypeParameterCS__Group__0__Impl rule__TypeParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__TypeParameterCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group__0"


    // $ANTLR start "rule__TypeParameterCS__Group__0__Impl"
    // InternalBase.g:1306:1: rule__TypeParameterCS__Group__0__Impl : ( ( rule__TypeParameterCS__NameAssignment_0 ) ) ;
    public final void rule__TypeParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1310:1: ( ( ( rule__TypeParameterCS__NameAssignment_0 ) ) )
            // InternalBase.g:1311:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            {
            // InternalBase.g:1311:1: ( ( rule__TypeParameterCS__NameAssignment_0 ) )
            // InternalBase.g:1312:1: ( rule__TypeParameterCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0());
            }
            // InternalBase.g:1313:1: ( rule__TypeParameterCS__NameAssignment_0 )
            // InternalBase.g:1313:2: rule__TypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group__1"
    // InternalBase.g:1323:1: rule__TypeParameterCS__Group__1 : rule__TypeParameterCS__Group__1__Impl ;
    public final void rule__TypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1327:1: ( rule__TypeParameterCS__Group__1__Impl )
            // InternalBase.g:1328:2: rule__TypeParameterCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group__1"


    // $ANTLR start "rule__TypeParameterCS__Group__1__Impl"
    // InternalBase.g:1334:1: rule__TypeParameterCS__Group__1__Impl : ( ( rule__TypeParameterCS__Group_1__0 )? ) ;
    public final void rule__TypeParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1338:1: ( ( ( rule__TypeParameterCS__Group_1__0 )? ) )
            // InternalBase.g:1339:1: ( ( rule__TypeParameterCS__Group_1__0 )? )
            {
            // InternalBase.g:1339:1: ( ( rule__TypeParameterCS__Group_1__0 )? )
            // InternalBase.g:1340:1: ( rule__TypeParameterCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1());
            }
            // InternalBase.g:1341:1: ( rule__TypeParameterCS__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalBase.g:1341:2: rule__TypeParameterCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TypeParameterCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getGroup_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1__0"
    // InternalBase.g:1355:1: rule__TypeParameterCS__Group_1__0 : rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1 ;
    public final void rule__TypeParameterCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1359:1: ( rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1 )
            // InternalBase.g:1360:2: rule__TypeParameterCS__Group_1__0__Impl rule__TypeParameterCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__TypeParameterCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1__0"


    // $ANTLR start "rule__TypeParameterCS__Group_1__0__Impl"
    // InternalBase.g:1367:1: rule__TypeParameterCS__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__TypeParameterCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1371:1: ( ( 'extends' ) )
            // InternalBase.g:1372:1: ( 'extends' )
            {
            // InternalBase.g:1372:1: ( 'extends' )
            // InternalBase.g:1373:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
            }
            match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1__1"
    // InternalBase.g:1386:1: rule__TypeParameterCS__Group_1__1 : rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2 ;
    public final void rule__TypeParameterCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1390:1: ( rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2 )
            // InternalBase.g:1391:2: rule__TypeParameterCS__Group_1__1__Impl rule__TypeParameterCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__TypeParameterCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1__1"


    // $ANTLR start "rule__TypeParameterCS__Group_1__1__Impl"
    // InternalBase.g:1398:1: rule__TypeParameterCS__Group_1__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1402:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) ) )
            // InternalBase.g:1403:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) )
            {
            // InternalBase.g:1403:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 ) )
            // InternalBase.g:1404:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1());
            }
            // InternalBase.g:1405:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_1 )
            // InternalBase.g:1405:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__OwnedExtendsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1__1__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1__2"
    // InternalBase.g:1415:1: rule__TypeParameterCS__Group_1__2 : rule__TypeParameterCS__Group_1__2__Impl ;
    public final void rule__TypeParameterCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1419:1: ( rule__TypeParameterCS__Group_1__2__Impl )
            // InternalBase.g:1420:2: rule__TypeParameterCS__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1__2"


    // $ANTLR start "rule__TypeParameterCS__Group_1__2__Impl"
    // InternalBase.g:1426:1: rule__TypeParameterCS__Group_1__2__Impl : ( ( rule__TypeParameterCS__Group_1_2__0 )* ) ;
    public final void rule__TypeParameterCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1430:1: ( ( ( rule__TypeParameterCS__Group_1_2__0 )* ) )
            // InternalBase.g:1431:1: ( ( rule__TypeParameterCS__Group_1_2__0 )* )
            {
            // InternalBase.g:1431:1: ( ( rule__TypeParameterCS__Group_1_2__0 )* )
            // InternalBase.g:1432:1: ( rule__TypeParameterCS__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getGroup_1_2());
            }
            // InternalBase.g:1433:1: ( rule__TypeParameterCS__Group_1_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==26) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalBase.g:1433:2: rule__TypeParameterCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    rule__TypeParameterCS__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getGroup_1_2());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1__2__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_2__0"
    // InternalBase.g:1449:1: rule__TypeParameterCS__Group_1_2__0 : rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1 ;
    public final void rule__TypeParameterCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1453:1: ( rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1 )
            // InternalBase.g:1454:2: rule__TypeParameterCS__Group_1_2__0__Impl rule__TypeParameterCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__TypeParameterCS__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__Group_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_2__0"


    // $ANTLR start "rule__TypeParameterCS__Group_1_2__0__Impl"
    // InternalBase.g:1461:1: rule__TypeParameterCS__Group_1_2__0__Impl : ( '&&' ) ;
    public final void rule__TypeParameterCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1465:1: ( ( '&&' ) )
            // InternalBase.g:1466:1: ( '&&' )
            {
            // InternalBase.g:1466:1: ( '&&' )
            // InternalBase.g:1467:1: '&&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
            }
            match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_2__0__Impl"


    // $ANTLR start "rule__TypeParameterCS__Group_1_2__1"
    // InternalBase.g:1480:1: rule__TypeParameterCS__Group_1_2__1 : rule__TypeParameterCS__Group_1_2__1__Impl ;
    public final void rule__TypeParameterCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1484:1: ( rule__TypeParameterCS__Group_1_2__1__Impl )
            // InternalBase.g:1485:2: rule__TypeParameterCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__Group_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_2__1"


    // $ANTLR start "rule__TypeParameterCS__Group_1_2__1__Impl"
    // InternalBase.g:1491:1: rule__TypeParameterCS__Group_1_2__1__Impl : ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) ) ;
    public final void rule__TypeParameterCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1495:1: ( ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) ) )
            // InternalBase.g:1496:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) )
            {
            // InternalBase.g:1496:1: ( ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 ) )
            // InternalBase.g:1497:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1());
            }
            // InternalBase.g:1498:1: ( rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 )
            // InternalBase.g:1498:2: rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__Group_1_2__1__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group__0"
    // InternalBase.g:1512:1: rule__TypedTypeRefCS__Group__0 : rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1 ;
    public final void rule__TypedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1516:1: ( rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1 )
            // InternalBase.g:1517:2: rule__TypedTypeRefCS__Group__0__Impl rule__TypedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__TypedTypeRefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypedTypeRefCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group__0"


    // $ANTLR start "rule__TypedTypeRefCS__Group__0__Impl"
    // InternalBase.g:1524:1: rule__TypedTypeRefCS__Group__0__Impl : ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) ) ;
    public final void rule__TypedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1528:1: ( ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) ) )
            // InternalBase.g:1529:1: ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) )
            {
            // InternalBase.g:1529:1: ( ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 ) )
            // InternalBase.g:1530:1: ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0());
            }
            // InternalBase.g:1531:1: ( rule__TypedTypeRefCS__OwnedPathNameAssignment_0 )
            // InternalBase.g:1531:2: rule__TypedTypeRefCS__OwnedPathNameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypedTypeRefCS__OwnedPathNameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group__0__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group__1"
    // InternalBase.g:1541:1: rule__TypedTypeRefCS__Group__1 : rule__TypedTypeRefCS__Group__1__Impl ;
    public final void rule__TypedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1545:1: ( rule__TypedTypeRefCS__Group__1__Impl )
            // InternalBase.g:1546:2: rule__TypedTypeRefCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypedTypeRefCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group__1"


    // $ANTLR start "rule__TypedTypeRefCS__Group__1__Impl"
    // InternalBase.g:1552:1: rule__TypedTypeRefCS__Group__1__Impl : ( ( rule__TypedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__TypedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1556:1: ( ( ( rule__TypedTypeRefCS__Group_1__0 )? ) )
            // InternalBase.g:1557:1: ( ( rule__TypedTypeRefCS__Group_1__0 )? )
            {
            // InternalBase.g:1557:1: ( ( rule__TypedTypeRefCS__Group_1__0 )? )
            // InternalBase.g:1558:1: ( rule__TypedTypeRefCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getGroup_1());
            }
            // InternalBase.g:1559:1: ( rule__TypedTypeRefCS__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBase.g:1559:2: rule__TypedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TypedTypeRefCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getGroup_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group__1__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__0"
    // InternalBase.g:1573:1: rule__TypedTypeRefCS__Group_1__0 : rule__TypedTypeRefCS__Group_1__0__Impl rule__TypedTypeRefCS__Group_1__1 ;
    public final void rule__TypedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1577:1: ( rule__TypedTypeRefCS__Group_1__0__Impl rule__TypedTypeRefCS__Group_1__1 )
            // InternalBase.g:1578:2: rule__TypedTypeRefCS__Group_1__0__Impl rule__TypedTypeRefCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__TypedTypeRefCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypedTypeRefCS__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__0"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__0__Impl"
    // InternalBase.g:1585:1: rule__TypedTypeRefCS__Group_1__0__Impl : ( '(' ) ;
    public final void rule__TypedTypeRefCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1589:1: ( ( '(' ) )
            // InternalBase.g:1590:1: ( '(' )
            {
            // InternalBase.g:1590:1: ( '(' )
            // InternalBase.g:1591:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
            }
            match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__0__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__1"
    // InternalBase.g:1604:1: rule__TypedTypeRefCS__Group_1__1 : rule__TypedTypeRefCS__Group_1__1__Impl rule__TypedTypeRefCS__Group_1__2 ;
    public final void rule__TypedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1608:1: ( rule__TypedTypeRefCS__Group_1__1__Impl rule__TypedTypeRefCS__Group_1__2 )
            // InternalBase.g:1609:2: rule__TypedTypeRefCS__Group_1__1__Impl rule__TypedTypeRefCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__TypedTypeRefCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypedTypeRefCS__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__1"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__1__Impl"
    // InternalBase.g:1616:1: rule__TypedTypeRefCS__Group_1__1__Impl : ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 ) ) ;
    public final void rule__TypedTypeRefCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1620:1: ( ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 ) ) )
            // InternalBase.g:1621:1: ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 ) )
            {
            // InternalBase.g:1621:1: ( ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 ) )
            // InternalBase.g:1622:1: ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1());
            }
            // InternalBase.g:1623:1: ( rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 )
            // InternalBase.g:1623:2: rule__TypedTypeRefCS__OwnedBindingAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypedTypeRefCS__OwnedBindingAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__1__Impl"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__2"
    // InternalBase.g:1633:1: rule__TypedTypeRefCS__Group_1__2 : rule__TypedTypeRefCS__Group_1__2__Impl ;
    public final void rule__TypedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1637:1: ( rule__TypedTypeRefCS__Group_1__2__Impl )
            // InternalBase.g:1638:2: rule__TypedTypeRefCS__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypedTypeRefCS__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__2"


    // $ANTLR start "rule__TypedTypeRefCS__Group_1__2__Impl"
    // InternalBase.g:1644:1: rule__TypedTypeRefCS__Group_1__2__Impl : ( ')' ) ;
    public final void rule__TypedTypeRefCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1648:1: ( ( ')' ) )
            // InternalBase.g:1649:1: ( ')' )
            {
            // InternalBase.g:1649:1: ( ')' )
            // InternalBase.g:1650:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());
            }
            match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__Group_1__2__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__0"
    // InternalBase.g:1669:1: rule__WildcardTypeRefCS__Group__0 : rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 ;
    public final void rule__WildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1673:1: ( rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1 )
            // InternalBase.g:1674:2: rule__WildcardTypeRefCS__Group__0__Impl rule__WildcardTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__WildcardTypeRefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WildcardTypeRefCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group__0"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__0__Impl"
    // InternalBase.g:1681:1: rule__WildcardTypeRefCS__Group__0__Impl : ( () ) ;
    public final void rule__WildcardTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1685:1: ( ( () ) )
            // InternalBase.g:1686:1: ( () )
            {
            // InternalBase.g:1686:1: ( () )
            // InternalBase.g:1687:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0());
            }
            // InternalBase.g:1688:1: ()
            // InternalBase.g:1690:1:
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0());
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group__0__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__1"
    // InternalBase.g:1700:1: rule__WildcardTypeRefCS__Group__1 : rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 ;
    public final void rule__WildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1704:1: ( rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2 )
            // InternalBase.g:1705:2: rule__WildcardTypeRefCS__Group__1__Impl rule__WildcardTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__WildcardTypeRefCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WildcardTypeRefCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group__1"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__1__Impl"
    // InternalBase.g:1712:1: rule__WildcardTypeRefCS__Group__1__Impl : ( '?' ) ;
    public final void rule__WildcardTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1716:1: ( ( '?' ) )
            // InternalBase.g:1717:1: ( '?' )
            {
            // InternalBase.g:1717:1: ( '?' )
            // InternalBase.g:1718:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group__1__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__2"
    // InternalBase.g:1731:1: rule__WildcardTypeRefCS__Group__2 : rule__WildcardTypeRefCS__Group__2__Impl ;
    public final void rule__WildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1735:1: ( rule__WildcardTypeRefCS__Group__2__Impl )
            // InternalBase.g:1736:2: rule__WildcardTypeRefCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WildcardTypeRefCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group__2"


    // $ANTLR start "rule__WildcardTypeRefCS__Group__2__Impl"
    // InternalBase.g:1742:1: rule__WildcardTypeRefCS__Group__2__Impl : ( ( rule__WildcardTypeRefCS__Group_2__0 )? ) ;
    public final void rule__WildcardTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1746:1: ( ( ( rule__WildcardTypeRefCS__Group_2__0 )? ) )
            // InternalBase.g:1747:1: ( ( rule__WildcardTypeRefCS__Group_2__0 )? )
            {
            // InternalBase.g:1747:1: ( ( rule__WildcardTypeRefCS__Group_2__0 )? )
            // InternalBase.g:1748:1: ( rule__WildcardTypeRefCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2());
            }
            // InternalBase.g:1749:1: ( rule__WildcardTypeRefCS__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBase.g:1749:2: rule__WildcardTypeRefCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__WildcardTypeRefCS__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group__2__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2__0"
    // InternalBase.g:1765:1: rule__WildcardTypeRefCS__Group_2__0 : rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1 ;
    public final void rule__WildcardTypeRefCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1769:1: ( rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1 )
            // InternalBase.g:1770:2: rule__WildcardTypeRefCS__Group_2__0__Impl rule__WildcardTypeRefCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__WildcardTypeRefCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WildcardTypeRefCS__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2__0"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2__0__Impl"
    // InternalBase.g:1777:1: rule__WildcardTypeRefCS__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__WildcardTypeRefCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1781:1: ( ( 'extends' ) )
            // InternalBase.g:1782:1: ( 'extends' )
            {
            // InternalBase.g:1782:1: ( 'extends' )
            // InternalBase.g:1783:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
            }
            match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2__0__Impl"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2__1"
    // InternalBase.g:1796:1: rule__WildcardTypeRefCS__Group_2__1 : rule__WildcardTypeRefCS__Group_2__1__Impl ;
    public final void rule__WildcardTypeRefCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1800:1: ( rule__WildcardTypeRefCS__Group_2__1__Impl )
            // InternalBase.g:1801:2: rule__WildcardTypeRefCS__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WildcardTypeRefCS__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2__1"


    // $ANTLR start "rule__WildcardTypeRefCS__Group_2__1__Impl"
    // InternalBase.g:1807:1: rule__WildcardTypeRefCS__Group_2__1__Impl : ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) ) ;
    public final void rule__WildcardTypeRefCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1811:1: ( ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) ) )
            // InternalBase.g:1812:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) )
            {
            // InternalBase.g:1812:1: ( ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 ) )
            // InternalBase.g:1813:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1());
            }
            // InternalBase.g:1814:1: ( rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 )
            // InternalBase.g:1814:2: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__Group_2__1__Impl"


    // $ANTLR start "rule__MultiplicityBoundsCS__LowerBoundAssignment_0"
    // InternalBase.g:1829:1: rule__MultiplicityBoundsCS__LowerBoundAssignment_0 : ( ruleLOWER ) ;
    public final void rule__MultiplicityBoundsCS__LowerBoundAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1833:1: ( ( ruleLOWER ) )
            // InternalBase.g:1834:1: ( ruleLOWER )
            {
            // InternalBase.g:1834:1: ( ruleLOWER )
            // InternalBase.g:1835:1: ruleLOWER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleLOWER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__LowerBoundAssignment_0"


    // $ANTLR start "rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1"
    // InternalBase.g:1844:1: rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1 : ( ruleUPPER ) ;
    public final void rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1848:1: ( ( ruleUPPER ) )
            // InternalBase.g:1849:1: ( ruleUPPER )
            {
            // InternalBase.g:1849:1: ( ruleUPPER )
            // InternalBase.g:1850:1: ruleUPPER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUPPER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1"


    // $ANTLR start "rule__MultiplicityCS__IsNullFreeAssignment_2_1"
    // InternalBase.g:1859:1: rule__MultiplicityCS__IsNullFreeAssignment_2_1 : ( ( '|1' ) ) ;
    public final void rule__MultiplicityCS__IsNullFreeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1863:1: ( ( ( '|1' ) ) )
            // InternalBase.g:1864:1: ( ( '|1' ) )
            {
            // InternalBase.g:1864:1: ( ( '|1' ) )
            // InternalBase.g:1865:1: ( '|1' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
            }
            // InternalBase.g:1866:1: ( '|1' )
            // InternalBase.g:1867:1: '|1'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
            }
            match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__IsNullFreeAssignment_2_1"


    // $ANTLR start "rule__MultiplicityStringCS__StringBoundsAssignment"
    // InternalBase.g:1882:1: rule__MultiplicityStringCS__StringBoundsAssignment : ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) ;
    public final void rule__MultiplicityStringCS__StringBoundsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1886:1: ( ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) ) )
            // InternalBase.g:1887:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            {
            // InternalBase.g:1887:1: ( ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 ) )
            // InternalBase.g:1888:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0());
            }
            // InternalBase.g:1889:1: ( rule__MultiplicityStringCS__StringBoundsAlternatives_0 )
            // InternalBase.g:1889:2: rule__MultiplicityStringCS__StringBoundsAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MultiplicityStringCS__StringBoundsAlternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityStringCS__StringBoundsAssignment"


    // $ANTLR start "rule__PathNameCS__OwnedPathElementsAssignment_0"
    // InternalBase.g:1898:1: rule__PathNameCS__OwnedPathElementsAssignment_0 : ( ruleFirstPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1902:1: ( ( ruleFirstPathElementCS ) )
            // InternalBase.g:1903:1: ( ruleFirstPathElementCS )
            {
            // InternalBase.g:1903:1: ( ruleFirstPathElementCS )
            // InternalBase.g:1904:1: ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__OwnedPathElementsAssignment_0"


    // $ANTLR start "rule__PathNameCS__OwnedPathElementsAssignment_1_1"
    // InternalBase.g:1913:1: rule__PathNameCS__OwnedPathElementsAssignment_1_1 : ( ruleNextPathElementCS ) ;
    public final void rule__PathNameCS__OwnedPathElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1917:1: ( ( ruleNextPathElementCS ) )
            // InternalBase.g:1918:1: ( ruleNextPathElementCS )
            {
            // InternalBase.g:1918:1: ( ruleNextPathElementCS )
            // InternalBase.g:1919:1: ruleNextPathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__OwnedPathElementsAssignment_1_1"


    // $ANTLR start "rule__FirstPathElementCS__ReferredElementAssignment"
    // InternalBase.g:1930:1: rule__FirstPathElementCS__ReferredElementAssignment : ( ( ruleUnrestrictedName ) ) ;
    public final void rule__FirstPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1934:1: ( ( ( ruleUnrestrictedName ) ) )
            // InternalBase.g:1935:1: ( ( ruleUnrestrictedName ) )
            {
            // InternalBase.g:1935:1: ( ( ruleUnrestrictedName ) )
            // InternalBase.g:1936:1: ( ruleUnrestrictedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0());
            }
            // InternalBase.g:1937:1: ( ruleUnrestrictedName )
            // InternalBase.g:1938:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1());
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FirstPathElementCS__ReferredElementAssignment"


    // $ANTLR start "rule__NextPathElementCS__ReferredElementAssignment"
    // InternalBase.g:1949:1: rule__NextPathElementCS__ReferredElementAssignment : ( ( ruleUnreservedName ) ) ;
    public final void rule__NextPathElementCS__ReferredElementAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1953:1: ( ( ( ruleUnreservedName ) ) )
            // InternalBase.g:1954:1: ( ( ruleUnreservedName ) )
            {
            // InternalBase.g:1954:1: ( ( ruleUnreservedName ) )
            // InternalBase.g:1955:1: ( ruleUnreservedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0());
            }
            // InternalBase.g:1956:1: ( ruleUnreservedName )
            // InternalBase.g:1957:1: ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1());
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextPathElementCS__ReferredElementAssignment"


    // $ANTLR start "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0"
    // InternalBase.g:1968:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1972:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // InternalBase.g:1973:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // InternalBase.g:1973:1: ( ruleTemplateParameterSubstitutionCS )
            // InternalBase.g:1974:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0"


    // $ANTLR start "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1"
    // InternalBase.g:1983:1: rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1 : ( ruleTemplateParameterSubstitutionCS ) ;
    public final void rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:1987:1: ( ( ruleTemplateParameterSubstitutionCS ) )
            // InternalBase.g:1988:1: ( ruleTemplateParameterSubstitutionCS )
            {
            // InternalBase.g:1988:1: ( ruleTemplateParameterSubstitutionCS )
            // InternalBase.g:1989:1: ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1"


    // $ANTLR start "rule__TemplateBindingCS__OwnedMultiplicityAssignment_2"
    // InternalBase.g:1998:1: rule__TemplateBindingCS__OwnedMultiplicityAssignment_2 : ( ruleMultiplicityCS ) ;
    public final void rule__TemplateBindingCS__OwnedMultiplicityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:2002:1: ( ( ruleMultiplicityCS ) )
            // InternalBase.g:2003:1: ( ruleMultiplicityCS )
            {
            // InternalBase.g:2003:1: ( ruleMultiplicityCS )
            // InternalBase.g:2004:1: ruleMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateBindingCS__OwnedMultiplicityAssignment_2"


    // $ANTLR start "rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment"
    // InternalBase.g:2013:1: rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment : ( ruleTypeRefCS ) ;
    public final void rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:2017:1: ( ( ruleTypeRefCS ) )
            // InternalBase.g:2018:1: ( ruleTypeRefCS )
            {
            // InternalBase.g:2018:1: ( ruleTypeRefCS )
            // InternalBase.g:2019:1: ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment"


    // $ANTLR start "rule__TypeParameterCS__NameAssignment_0"
    // InternalBase.g:2030:1: rule__TypeParameterCS__NameAssignment_0 : ( ruleUnrestrictedName ) ;
    public final void rule__TypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:2034:1: ( ( ruleUnrestrictedName ) )
            // InternalBase.g:2035:1: ( ruleUnrestrictedName )
            {
            // InternalBase.g:2035:1: ( ruleUnrestrictedName )
            // InternalBase.g:2036:1: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__NameAssignment_0"


    // $ANTLR start "rule__TypeParameterCS__OwnedExtendsAssignment_1_1"
    // InternalBase.g:2045:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_1 : ( ruleTypedRefCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:2049:1: ( ( ruleTypedRefCS ) )
            // InternalBase.g:2050:1: ( ruleTypedRefCS )
            {
            // InternalBase.g:2050:1: ( ruleTypedRefCS )
            // InternalBase.g:2051:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__OwnedExtendsAssignment_1_1"


    // $ANTLR start "rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1"
    // InternalBase.g:2060:1: rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1 : ( ruleTypedRefCS ) ;
    public final void rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:2064:1: ( ( ruleTypedRefCS ) )
            // InternalBase.g:2065:1: ( ruleTypedRefCS )
            {
            // InternalBase.g:2065:1: ( ruleTypedRefCS )
            // InternalBase.g:2066:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1"


    // $ANTLR start "rule__TypedTypeRefCS__OwnedPathNameAssignment_0"
    // InternalBase.g:2075:1: rule__TypedTypeRefCS__OwnedPathNameAssignment_0 : ( rulePathNameCS ) ;
    public final void rule__TypedTypeRefCS__OwnedPathNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:2079:1: ( ( rulePathNameCS ) )
            // InternalBase.g:2080:1: ( rulePathNameCS )
            {
            // InternalBase.g:2080:1: ( rulePathNameCS )
            // InternalBase.g:2081:1: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__OwnedPathNameAssignment_0"


    // $ANTLR start "rule__TypedTypeRefCS__OwnedBindingAssignment_1_1"
    // InternalBase.g:2090:1: rule__TypedTypeRefCS__OwnedBindingAssignment_1_1 : ( ruleTemplateBindingCS ) ;
    public final void rule__TypedTypeRefCS__OwnedBindingAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:2094:1: ( ( ruleTemplateBindingCS ) )
            // InternalBase.g:2095:1: ( ruleTemplateBindingCS )
            {
            // InternalBase.g:2095:1: ( ruleTemplateBindingCS )
            // InternalBase.g:2096:1: ruleTemplateBindingCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypedTypeRefCS__OwnedBindingAssignment_1_1"


    // $ANTLR start "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1"
    // InternalBase.g:2105:1: rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1 : ( ruleTypedRefCS ) ;
    public final void rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();

        try {
            // InternalBase.g:2109:1: ( ( ruleTypedRefCS ) )
            // InternalBase.g:2110:1: ( ruleTypedRefCS )
            {
            // InternalBase.g:2110:1: ( ruleTypedRefCS )
            // InternalBase.g:2111:1: ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0());
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0());
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1"

    // Delegated rules





    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000E0010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000020410000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001200000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080060L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    }


}