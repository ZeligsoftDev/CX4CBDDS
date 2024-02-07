grammar Xtend;
@parser::members {
	private ExtensionFactory factory = new ExtensionFactory();
	public XtendParser(TokenStream stream, ExtensionFactory factory) {
		this(stream);
		if (factory != null) {
		  this.factory = factory;
		}
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

    @Override
    public void reportError(RecognitionException e) {
        System.err.println(super.getErrorMessage(e, tokenNames));
        throw new RuntimeException(e);
    }
}

@parser::header { 	
package org.eclipse.internal.xtend.xtend.parser; 
	
import org.eclipse.internal.xtend.expression.ast.*;
import org.eclipse.internal.xtend.xtend.ast.*;
import org.eclipse.emf.common.util.BasicEList;
}

@lexer::header { 	
package org.eclipse.internal.xtend.xtend.parser; 
	
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.eclipse.internal.xtend.expression.ast.*;
import org.eclipse.internal.xtend.xtend.ast.*;
}


file  returns [ExtensionFile r] 
@init{ final CommonToken startToken = (CommonToken) input.LT(1); 
final List<NamespaceImportStatement> nsimports = new BasicEList<NamespaceImportStatement>();
final List<ExtensionImportStatement> extimports = new BasicEList<ExtensionImportStatement>();
final List<Extension> extensions = new BasicEList<Extension>();
final List<Around> arounds = new BasicEList<Around>();
final List<Check> checks = new BasicEList<Check>();}
@after{ addLocation(r, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	(nsi=nsImport {if (nsi!=null) nsimports.add(nsi);})*
	(exti=extImport {if (exti!=null) extimports.add(exti);})*
	(ext=extension {if(ext!=null) extensions.add(ext);} | a = around {if (a!=null) arounds.add(a);} | c = check {if (c!=null) checks.add(c);})*
	 EOF
	 { $r = factory.createExtensionFile(nsimports,extimports,extensions,arounds,checks);}
;


nsImport  returns [NamespaceImportStatement r]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(r, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'import' t=type {$r = factory.createNsImport(t);} ';' 
;


extImport  returns [ExtensionImportStatement r]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(r, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'extension' t=type (exported='reexport')? ';' { $r = factory.createExtensionFileImport(t,id(exported));}
;


check returns [Check ext]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(ext, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	'context' t=type('#'f=identifier)? ('if' guard=expression)? (sev1='ERROR'|'WARNING') msg=expression ':'
	expr=expression ';'
	{ext = factory.createCheck(t, f, guard, sev1!=null, msg, expr);}
;

around  returns [Around r]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(r, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
    'around' pc=pointcut '(' (p=declaredParameterList (','? wildparams='*')? | wildparams='*')? ')' ':'
    	expr=expression ';'
	  { $r = factory.createAround(pc,p,wildparams!=null,expr);}
;
    
pointcut  returns [Identifier r]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(r, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	( a='*' {$r = id(a);}
	 |b=identifier{$r = b;})
	  ( a1='*' {if ($r!=null)$r.append(id(a1));}
	   |b1=identifier {if ($r!=null)$r.append(b1);}
	   |c1='::' {if ($r!=null)$r.append(id(c1));})*
;



extension  returns [Extension r]
@init{ final CommonToken startToken = (CommonToken) input.LT(1);
final List<Identifier> javaParamTypes=new BasicEList<Identifier>();}
@after{ addLocation((AbstractExtension)r, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	(priv='private')? (cached='cached')? (rType=type)? name=identifier '(' (params=declaredParameterList)? ')' ':'
	
	( 'JAVA' jt=javaType '.' m=identifier '('(pt=javaType {if (pt!=null) javaParamTypes.add(pt);}(',' pt=javaType {if (pt!=null) javaParamTypes.add(pt);})*)? ')' ';'
	{ $r = factory.createJavaExtension(name,rType,params,jt,m,javaParamTypes, id(cached),id(priv));}
	|	expr=expression ';'
	{ $r = factory.createExpressionExtension(name,rType,params,expr,  id(cached),id(priv)); }
	)

|	(priv='private')? create='create' rType=type (rtn=identifier)? name=identifier '(' (params=declaredParameterList)? ')' ':'
		expr=expression ';'
	 { $r = factory.createCreateExtension(id(create),rType,rtn,name,params,expr,id(priv)); }
;


javaType  returns [Identifier r]
@init{ final CommonToken startToken = (CommonToken) input.LT(1); }
@after{ addLocation(r, startToken, /*endToken*/ (CommonToken) input.LT(-1)); }
:
	i=identifier {$r = i;} 
	(d='.' {if ($r!=null)$r.append(id(d));}(i1=identifier {if ($r!=null)$r.append(i1);}|i2='Collection' {$r.append(id(i2));}| 
	i3='List' {if ($r!=null)$r.append(id(i3));}|i4='Set'{if ($r!=null)$r.append(id(i4));}))*
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
	x=ifExpression {$e=x;} ( '->' right=ifExpression {$e=factory.createChainExpression($e,right); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1));})*
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
   (name=('+'| '-') r=multiplicativeExpression {$e = factory.createBinaryOperation(id(name),$e,r); addLocation(e, startToken, /*endToken*/ (CommonToken) input.LT(-1)); })*
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
	x=primaryExpression {$e=x;} ( '.' op=featureCall { if (op!=null) { op.setTarget($e);$e=op;}} )*
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

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* ('\r'? '\n'|EOF) {$channel=HIDDEN;}
    ;
    

XPAND_TAG_OPEN 
	: '\u00AB';
XPAND_TAG_CLOSE
	: '\u00BB';	
