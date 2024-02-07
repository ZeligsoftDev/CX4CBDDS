grammar Xpand;
@parser::members {
	private XpandFactory factory;
	
	public XpandParser(final TokenStream stream, final XpandFactory factory) {
		this(stream);
		this.factory = factory != null ? factory : new XpandFactory("nofile");;
	}
	
	protected Identifier id(final Token t) {
		if (t == null)
			return null;
		final CommonToken ct = (CommonToken) t;
		final Identifier id = new Identifier(t.getText());
		id.setStart(ct.getStartIndex());
		id.setEnd(ct.getStopIndex());
		id.setLine(ct.getLine());
		return id;
	}

    private static final <T extends SyntaxElement> void addLocation(final T ele, final CommonToken start, final CommonToken end) {
        if (ele != null) {
            ele.setStart(start != null ? start.getStartIndex() : 0);
            ele.setLine(start != null ? start.getLine() : 0);
            ele.setEnd(end != null ? (end.getStopIndex() + 1) : -1);
        }
    }

}

@parser::header { 	
package org.eclipse.internal.xpand2.parser; 

import org.eclipse.internal.xtend.expression.ast.*;
import org.eclipse.internal.xpand2.ast.*;
import org.eclipse.emf.common.util.BasicEList;

}

@lexer::header { 	
package org.eclipse.internal.xpand2.parser; 
	
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.eclipse.internal.xtend.expression.ast.*;
import org.eclipse.internal.xpand2.ast.*;

}


template returns [Template t] 
@init{ final CommonToken startToken = (CommonToken) input.LT(1);
final List<ImportDeclaration> imports = new BasicEList<ImportDeclaration>();
final List<ExtensionImportDeclaration> extensions = new BasicEList<ExtensionImportDeclaration>();
final List<Definition> defines = new BasicEList<Definition>();
final List<Advice> advices = new BasicEList<Advice>();
}
@after{ addLocation(t, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
    :
	LG
		(COMMENT txt=text)*
		((imp=anImport {if (imp!=null)imports.add(imp);}  | extimp=anExtensionImport {if (extimp!=null) extensions.add(extimp);}) txt=text (COMMENT txt=text)*)*
		((d=define {if (d!=null) defines.add(d);}| a=around{if (a!=null) advices.add(a);}) txt=text (COMMENT txt=text)* )*
	 {t = factory.createTemplate(imports,extensions,defines,advices);}
	|
;


anImport returns [ImportDeclaration imp] 
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(imp, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'IMPORT' id=simpleType {$imp = factory.createImportDeclaration(id);}
;


anExtensionImport returns [ExtensionImportDeclaration imp]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(imp, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'EXTENSION' id=simpleType {imp = factory.createExtensionImportDeclaration(id);}
;


around returns [Advice a]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(a, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	  'AROUND' pc=pointcut
	  ('(' (p=declaredParameterList (',' wildparams='*' )? | wildparams='*' ) ')')? 'FOR' t=type 
	  s=sequence
	  'ENDAROUND'
	  { a = factory.createAround(pc,p,wildparams!=null,t,s);}
;


pointcut returns [Identifier i]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(i, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	(x='*' {$i = id(x);}|i1=identifier {$i = i1;})
	(x1='*' {$i.append(id(x1));}|n1=identifier {$i.append(n1);}|dc='::' {$i.append(id(dc));})*
;


define returns [Definition d]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(d, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	  'DEFINE' name=identifier ('(' p=declaredParameterList ')')? 'FOR' t=type 
	  s=sequence 
	  'ENDDEFINE'
	  { d = factory.createDefinition(name,p,t,s);}
;
	

sequence returns [List<Statement> s=new BasicEList<Statement>()]
:
	 s1=textSequence {$s.addAll(s1);}
	 (s2=statement {if (s2!=null) $s.add(s2);}
	  s1=textSequence {$s.addAll(s1);})*		
;
	
//
// Statements
//
//
	
statement returns [Statement s]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(s, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
  s1=simpleStatement {$s=s1;}
| s2=fileStatement {$s=s2;}
| s3=foreachStatement {$s=s3;}
| s4=ifStatement {$s=s4;}
| s5=letStatement {$s=s5;}
| s6=protectStatement {$s=s6;}
;
	
textSequence returns [List<Statement> s=new BasicEList<Statement>();]
:
	t=text {if (t!=null) $s.add(t);}
  (COMMENT t1=text {if (t1!=null) $s.add(t1);})*
;

text returns [Statement s]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(s, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	(m='-')? t=TEXT {$s = factory.createTextStatement(id(t),id(m));}
;

simpleStatement returns [Statement s]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(s, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
  s1=errorStatement {$s=s1;}
| s2=expandStatement {$s=s2;}
| s3=expressionStmt {$s=s3;}
;

errorStatement returns [ErrorStatement e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
  'ERROR' expr=expression { $e = factory.createErrorStatement(expr); }
;

expandStatement returns [ExpandStatement e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
  'EXPAND' t=definitionName ('(' pl=parameterList ')')? (('FOR' expr=expression)
  | (fe='FOREACH' expr=expression ('SEPARATOR' sep=expression)?))?
  (onFileClose='ONFILECLOSE')?
  
  {e = factory.createExpandStatement(t,pl,expr,fe!=null,sep,onFileClose!=null);}
;


definitionName returns [Identifier id]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(id, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	id1 = simpleType {$id=id1;}
;


expressionStmt returns [ExpressionStatement es]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(es, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	e=expression {$es = factory.createExpressionStatement(e);}
;


fileStatement returns [FileStatement f]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(f, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'FILE' e=expression (option=identifier)?
		s=sequence 
	'ENDFILE'
	{f = factory.createFileStatement(e,option,s);}
;
	

foreachStatement returns [ForEachStatement f]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(f, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	 'FOREACH' e=expression 'AS' v=identifier ('ITERATOR' iter=identifier)? ('SEPARATOR' sep=expression)?
  		s=sequence 
	 'ENDFOREACH'
	 {f = factory.createForEachStatement(e,v,sep,iter,s);}
;

ifStatement returns [IfStatement i] 
@init{ final CommonToken startToken = (CommonToken) input.LT(1); 
IfStatement temp = null;}
@after{ addLocation(i, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
     'IF' e=expression
		s=sequence 
		{$i = factory.createIfStatement(e,s);
		 temp = $i;}
	 (elif=elseIfStatement {temp.setElseIf(elif);
	 			temp = elif; })*
	 (el=elseStatement     {temp.setElseIf(el);
	 			temp = el; })?
	 'ENDIF'
;


elseIfStatement returns [IfStatement i]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(i, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'ELSEIF' e=expression
		s=sequence 
		{$i = factory.createIfStatement(e,s);}
	;
	

elseStatement returns [IfStatement i]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(i, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'ELSE'
		s=sequence
		{$i = factory.createIfStatement(null,s);}
	;
	

letStatement returns [LetStatement l]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(l, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	 'LET' e=expression 'AS' v=identifier
  		s=sequence 
	 'ENDLET'
	 {$l = factory.createLetStatement(e,v,s);}
;
	

protectStatement returns [ProtectStatement l]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(l, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'PROTECT' 
		'CSTART' startC=expression 
		'CEND' endC=expression 
         	'ID' id=expression (disabled='DISABLE')?
 		s=sequence 
	'ENDPROTECT'
	 {l = factory.createProtectStatement(startC,endC,id,disabled!=null,s);}
;

//
// Expressions
//
expression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	x=letExpression {$e=x;}
;


letExpression  returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
   'let' v=identifier '=' varExpr=castedExpression ':' target=expression 
   {$e=factory.createLetExpression(v,varExpr,target);}
|  x=castedExpression {$e=x;}
;


castedExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
    ('(' type ')' castedExpression)=>
	'(' t=type ')' x=chainExpression {$e = factory.createCast(t,x);}
	| x=chainExpression {$e=x;}
;


chainExpression  returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
:
	x=ifExpression {$e=x;} ( '->' right=ifExpression {$e=factory.createChainExpression($e,right); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); })*
;


ifExpression  returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	x=switchExpression {$e=x;}('?' thenPart=switchExpression ':' elsePart=switchExpression {$e=factory.createIf($e,thenPart,elsePart);})?
|	'if' condition=switchExpression 'then' thenPart=switchExpression ('else' elsePart=expression)? {$e=factory.createIf(condition,thenPart,elsePart);}
;


switchExpression  returns [Expression e=null]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); final List<Case> cases = new BasicEList<Case>(); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
   'switch' ('(' pred = orExpression ')')?
   '{'
   ( 
     'case' c=orExpression  ':'  v=orExpression
     {Case _case = factory.createCase(c, v); if (_case!=null) cases.add(_case);}
   )*
   'default' ':' def = orExpression
   '}'
   {$e = factory.createSwitchExpression(pred,cases,def);}
|  x=orExpression {$e=x;}
;


orExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
:
  	x=andExpression {$e=x;} (name='||' r=andExpression 	{$e = factory.createBooleanOperation(id(name),$e,r); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); })*	
;


andExpression 	returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
:
	x=impliesExpression {$e=x;} (name='&&' r=impliesExpression 	{$e = factory.createBooleanOperation(id(name),$e,r); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); })*	
;


impliesExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
:
	x=relationalExpression {$e=x;} (name='implies' r=relationalExpression 	{$e = factory.createBooleanOperation(id(name),$e,r); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); })*	
;

	
relationalExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
:
	x=additiveExpression {$e=x;}
	(name=('==' | '!=' | '>=' | '<=' | '>' | '<') r=additiveExpression {$e = factory.createBinaryOperation(id(name),$e,r); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); })*
;


additiveExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
:
	x=multiplicativeExpression {$e=x;}
   (name=('+'| '-') r=multiplicativeExpression {$e = factory.createBinaryOperation(id(name),$e,r); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1));})*
;


multiplicativeExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
:
	x=unaryExpression {$e=x;}
	(name=('*' | '/') r=unaryExpression {$e = factory.createBinaryOperation(id(name),$e,r); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); })*
;


unaryExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	x=infixExpression {$e=x;}
|	name='!' x=infixExpression	{$e = factory.createOperationCall(id(name),x);}
|	name='-' x=infixExpression	{$e = factory.createOperationCall(id(name),x);}
;


infixExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	x=primaryExpression {$e=x;} ( '.' op=featureCall { if (op!=null) { op.setTarget($e);$e=op; }} )*
;
	

primaryExpression 	 returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
   c=StringLiteral { $e = factory.createStringLiteral(id(c));}	
|   x=featureCall {$e=x;}
|   x=booleanLiteral {$e=x;}
|   x=numberLiteral {$e=x;}
|   x=nullLiteral {$e=x;}
|   x=listLiteral {$e=x;}
|   x=constructorCall {$e=x;}
|   x=globalVarExpression {$e=x;}
|   x=paranthesizedExpression {$e=x;}
;

paranthesizedExpression returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
    '(' x=expression ')' {$e=factory.createParanthesizedExpression(x);}
;


globalVarExpression  returns [GlobalVarExpression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
    'GLOBALVAR' name=identifier {$e = factory.createGlobalVarExpression(name);};


featureCall  returns [FeatureCall e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	id1=identifier '(' (l=parameterList)? ')' {$e = factory.createOperationCall(id1,l);}
|   t=type {$e=factory.createFeatureCall(t,null);}	
|   x=collectionExpression {$e=x;}
;


listLiteral  returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'{' (l=parameterList)? '}' {$e=factory.createListLiteral(l);}
;

constructorCall  returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'new' t=simpleType
	{$e= factory.createConstructorCall(t);}
;


booleanLiteral  returns [Expression e=factory.createBooleanLiteral(id(input.LT(1)))]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'false'|'true'
;

nullLiteral  returns [Expression e=factory.createNullLiteral(id(input.LT(1)))]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'null'
;

numberLiteral  returns [Expression e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
  	a=IntLiteral {$e=factory.createIntegerLiteral(id(a));}
| 	a=IntLiteral b='.' c=IntLiteral {$e=factory.createRealLiteral(id(a).append(id(b)).append(id(c)));}
;


collectionExpression  returns [FeatureCall e]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
  name='typeSelect'
  '(' t=type ')' { $e = factory.createTypeSelectExpression(id(name),t);}
  
   |name=('collect'
  | 'select' 
  | 'selectFirst' 
  | 'reject' 
  | 'exists'
  | 'notExists'
  | 'sortBy' 
  | 'forAll') '(' (var=identifier '|')? x=expression ')' 
 { $e = factory.createCollectionExpression(id(name),var,x);}
;

// helper

declaredParameterList  returns [List<DeclaredParameter> l = new BasicEList<DeclaredParameter>()] 
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(dp, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	dp=declaredParameter {if (dp!=null) $l.add(dp);}(',' dp1=declaredParameter {if (dp1!=null) $l.add(dp1);})*
;

declaredParameter returns [DeclaredParameter dp]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(dp, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	t=type name=identifier {$dp = factory.createDeclaredParameter(t,name);}
;

parameterList  returns [List<Expression> list = new BasicEList<Expression>()] :
    a=expression {if (a!=null) $list.add(a);} (',' b=expression {if(b!=null) $list.add(b);})* 
;

// type

type returns [Identifier id] 
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(id, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	a = collectionType {$id=a;}|
	b = simpleType {$id=b;}
;
	
collectionType  returns [Identifier id ] 
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(id, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
  cl=( 'Collection' | 'List' | 'Set' ) {$id = id(cl);}
  (b='[' id1=simpleType c=']' { $id.append(id(b));$id.append(id1);$id.append(id(c));})?
;

simpleType returns [Identifier id]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(id, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	x=identifier {$id=x;}
	(d='::' end=identifier  {$id.append(id(d)); $id.append(end);})*
;

identifier returns [Identifier r]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(r, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
   x=Identifier {$r=id(x);}
	;
// LEXER

IntLiteral : '0'..'9'+ ;

StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    |  '\'' ( EscapeSequence | ~('\''|'\\') )* '\''
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;
fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

Identifier 
    :   ('^')? Letter (Letter|JavaIDDigit)*
    ;

fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

ML_COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

LG  : '\u00AB';
fragment
RG: '\u00BB';

// comments
COMMENT :
	'REM' RG ( options {greedy=false;} : . )* '\u00ABENDREM'
;

TEXT :
  RG ~(LG)* (LG)?
;

// a dummy rule to force vocabulary to be all characters (except special
// ones that ANTLR uses internally (0 to 2) and the guillemot characters
//fragment
//VOCAB :
//	('\3'..'\u00aa'|'\u00ac'..'\u00ba'|'\u00bc'..'\ufffe')
//;
