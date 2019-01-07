package com.zeligsoft.base.langc.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.ExpressionStatement;
import com.zeligsoft.base.langc.FileName;
import com.zeligsoft.base.langc.FolderName;
import com.zeligsoft.base.langc.Function;
import com.zeligsoft.base.langc.FunctionCall;
import com.zeligsoft.base.langc.FunctionImplementation;
import com.zeligsoft.base.langc.LinkableArtifact;
import com.zeligsoft.base.langc.UserElement;
import com.zeligsoft.base.langc.test.util.LangCTestRunner;

@SuppressWarnings("nls")
public class LinkableArtifactTests extends TestCase {

	public void testSimpleLA() {

		LinkableArtifact la = LangCTestRunner.run("langcmodel::linkableartifact::laWithSimpleFunction");
		assertNotNull( la );

		assertEquals( "la01", la.getName() );

		Collection<FolderName> publicFolders = getPublicFolders( la );
		assertEquals( 1, publicFolders.size() );
		FolderName[] folders = publicFolders.toArray( new FolderName[1] );
		assertEquals( "folder01", folders[0].getName() );
		assertNull( folders[0].getParent() );

		assertEquals( 1, la.getRootElements().size() );
		Function function = (Function)la.getRootElements().get( 0 );
		assertNotNull( function );
		assertEquals( "function01", function.getName().getName() );
		assertEquals( "filename01", function.getName().getParent().getName() );
		assertNull( function.getDefaultImpl() );
	}

	public void testLAWithDefaultFunctionImpl() {

		LinkableArtifact la = LangCTestRunner.run("langcmodel::linkableartifact::laWithDefaultFunctionImpl");
		assertNotNull( la );

		assertEquals( "la02", la.getName() );

		Collection<FolderName> publicFolders = getPublicFolders( la );
		assertEquals( 0, publicFolders.size() );

		assertEquals( 1, la.getRootElements().size() );
		Function function = (Function)la.getRootElements().get( 0 );
		assertNotNull( function );
		assertEquals( "function02", function.getName().getName() );
		assertEquals( "filename", function.getName().getParent().getName() );

		FunctionImplementation functionImpl = function.getDefaultImpl();
		assertNotNull( functionImpl );
		assertEquals( function, functionImpl.getFunction() );
		assertEquals( function, functionImpl.eContainer() );
		assertNotNull( functionImpl.getBody() );
		assertEquals( 1, functionImpl.getBody().getStatements().size() );
	}

	public void testLAsWithFunctionImpls() {

		com.zeligsoft.base.langc.System sys = LangCTestRunner.run("langcmodel::linkableartifact::lasWithFunctionImpls");
		assertNotNull( sys );

		assertEquals( 2, sys.getArtifacts().size() );
		LinkableArtifact arta = sys.getArtifacts().get( 0 );
		LinkableArtifact artb = sys.getArtifacts().get( 1 );
		assertEquals( "la03a", arta.getName() );
		assertEquals( "la03b", artb.getName() );

		assertEquals( 1, arta.getRootElements().size() );
		assertEquals( 1, arta.getFunctionImplementations().size() );
		Function callera = (Function)arta.getRootElements().get( 0 );
		FunctionImplementation impla = arta.getFunctionImplementations().get( 0 );
		Function calleea = impla.getFunction();
		assertNotNull( callera );
		assertNotNull( impla );
		assertNotNull( calleea );

		assertEquals( 1, artb.getRootElements().size() );
		assertEquals( 1, artb.getFunctionImplementations().size() );
		Function callerb = (Function)artb.getRootElements().get( 0 );
		FunctionImplementation implb = artb.getFunctionImplementations().get( 0 );
		Function calleeb = impla.getFunction();
		assertNotNull( callerb );
		assertNotNull( implb );
		assertNotNull( calleeb );

		assertTrue( callera == callerb );
		assertTrue( calleea == calleeb );
		assertTrue( impla != implb );

		assertNotNull( callera.getDefaultImpl() );
		assertNotNull( callera.getDefaultImpl().getBody() );
		assertEquals( 1, callera.getDefaultImpl().getBody().getStatements().size() );

		ExpressionStatement exprStmt = (ExpressionStatement)callera.getDefaultImpl().getBody().getStatements().get( 0 );
		assertNotNull( exprStmt );

		FunctionCall funcCall = (FunctionCall)exprStmt.getExpr();
		assertTrue( calleea == funcCall.getFunction() );

		// at this point its confirmed that the elements are associated as expected, now
		// check that the traversal rules work properly

		List<UserElement> objectsa
			= LangCTestRunner.run( "generator::objects::objectsIn", callera, arta );
		assertNotNull( objectsa );
		assertEquals( 2, objectsa.size() );
		assertTrue( objectsa.contains( callera.getDefaultImpl()) );
		assertTrue( objectsa.contains( impla ) );

		List<UserElement> objectsb
			= LangCTestRunner.run( "generator::objects::objectsIn", callera, artb );
		assertNotNull( objectsb );
		assertEquals( 2, objectsb.size() );
		assertTrue( objectsb.contains( callerb.getDefaultImpl()) );
		assertTrue( objectsb.contains( implb ) );

		Map<UserElement, FileName> declFilesa = new HashMap<UserElement, FileName>();
		addDeclFile( declFilesa, callera );
		addDeclFile( declFilesa, calleea );
		for( UserElement elementa : objectsa )
			addDeclFile( declFilesa, elementa );

		Map<UserElement, FileName> declFilesb = new HashMap<UserElement, FileName>();
		addDeclFile( declFilesb, callerb );
		addDeclFile( declFilesb, calleeb );
		for( UserElement elementb : objectsb )
			addDeclFile( declFilesb, elementb );

		assertEquals( "filename", declFilesa.get( callera ).getName() );
		assertEquals( "filename", declFilesb.get( callerb ).getName() );
		assertEquals( "filename", declFilesa.get( calleea ).getName() );
		assertEquals( "filename", declFilesb.get( calleeb ).getName() );
		assertEquals( "filename", declFilesa.get( callera.getDefaultImpl() ).getName() );
		assertEquals( "filename", declFilesb.get( callerb.getDefaultImpl() ).getName() );
		assertEquals( "filename", declFilesa.get( impla ).getName() );
		assertEquals( "filename", declFilesb.get( implb ).getName() );

		Map<UserElement, FileName> defnFilesa = new HashMap<UserElement, FileName>();
		addDefnFile( defnFilesa, callera, arta );
		addDefnFile( defnFilesa, calleea, arta );
		for( UserElement elementa : objectsa )
			addDefnFile( defnFilesa, elementa, arta );

		Map<UserElement, FileName> defnFilesb = new HashMap<UserElement, FileName>();
		addDefnFile( defnFilesb, callerb, artb );
		addDefnFile( defnFilesb, calleeb, artb );
		for( UserElement elementb : objectsb )
			addDefnFile( defnFilesb, elementb, artb );

		assertEquals( "filename", defnFilesa.get( callera ).getName() );
		assertEquals( "filename", defnFilesb.get( callerb ).getName() );
		assertEquals( "filenameA", defnFilesa.get( calleea ).getName() );
		assertEquals( "filenameB", defnFilesb.get( calleeb ).getName() );
		assertEquals( "filename", defnFilesa.get( callera.getDefaultImpl() ).getName() );
		assertEquals( "filename", defnFilesb.get( callerb.getDefaultImpl() ).getName() );
		assertEquals( "filenameA", defnFilesa.get( impla ).getName() );
		assertEquals( "filenameB", defnFilesb.get( implb ).getName() );
	}

	private static void addDeclFile( Map<UserElement, FileName> map, UserElement element ) {
		FileName filename
			= LangCTestRunner.run( "generator::filepartitioner::declarationFile", element );
		map.put(element, filename);
	}

	private static void addDefnFile( Map<UserElement, FileName> map, UserElement element, LinkableArtifact artifact ) {
		FileName filename
			= LangCTestRunner.run( "generator::filepartitioner::definitionFile", element, artifact );
		map.put(element, filename);
	}

	private Collection<FolderName> getPublicFolders( LinkableArtifact la ) {
		return LangCTestRunner.run( "generator::objects::publicFolders", la );
	}
	
	public void testSimplePublicFolder() {
		LinkableArtifact artifact = LangCTestRunner.run("langcmodel::publicfolders::simpleArtifact");
		assertNotNull( artifact );

		assertEquals( "artifact01", artifact.getName() );
		assertEquals( 2, artifact.getRootElements().size() );

		Collection<FolderName> publicFolders
			= LangCTestRunner.run( "generator::objects::publicFolders", artifact );
		assertNotNull( publicFolders );

		assertEquals( 1, publicFolders.size() );
	}
}
