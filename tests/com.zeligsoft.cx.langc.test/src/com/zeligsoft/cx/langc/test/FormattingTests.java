package com.zeligsoft.cx.langc.test;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.BlockInitializer;
import com.zeligsoft.cx.langc.ElementAccess;
import com.zeligsoft.cx.langc.Enumerator;
import com.zeligsoft.cx.langc.LangCFactory;
import com.zeligsoft.cx.langc.Name;

@SuppressWarnings("nls")
public class FormattingTests 
{
	// some enumerators to be referenced in the tests
	private static final Name enumName = LangCFactory.eINSTANCE.createName();

	private static final Name enum1Name = LangCFactory.eINSTANCE.createName();
	private static final Name enum2Name = LangCFactory.eINSTANCE.createName();
	private static final Name enum3Name = LangCFactory.eINSTANCE.createName();

	private static final Enumerator enum1 = LangCFactory.eINSTANCE.createEnumerator();
	private static final Enumerator enum2 = LangCFactory.eINSTANCE.createEnumerator();
	private static final Enumerator enum3 = LangCFactory.eINSTANCE.createEnumerator();

	static
	{
		enumName.setParent( null );
		enumName.setName( "AnEnum" );

		enum1Name.setParent( enumName );
		enum1Name.setName( "ENUM_1" );

		enum2Name.setParent( enumName );
		enum2Name.setName( "ENUM_2" );

		enum3Name.setParent( enumName );
		enum3Name.setName( "ENUM_3" );

		enum1.setName( enum1Name );
		enum2.setName( enum2Name );
		enum3.setName( enum3Name );
	}

	@Test
	public void testSimpleBlockInit() throws IOException
	{
		// access expressions for the init expression
		ElementAccess access1 = LangCFactory.eINSTANCE.createElementAccess();
		access1.setName( enum1Name );

		ElementAccess access2 = LangCFactory.eINSTANCE.createElementAccess();
		access2.setName( enum2Name );

		ElementAccess access3 = LangCFactory.eINSTANCE.createElementAccess();
		access3.setName( enum3Name );

		BlockInitializer init = LangCFactory.eINSTANCE.createBlockInitializer();
		init.getExprs().add( access1 );
		init.getExprs().add( access2 );
		init.getExprs().add( access3 );

		// format the expression into a tmp file
		File tmpFile = File.createTempFile( getClass().getName(), null );
		if( tmpFile.exists() )
			tmpFile.delete();

		CodeWriter code
			= CodeWriter.create(
					tmpFile.getParentFile().getAbsolutePath(),
					tmpFile.getName() );

		assertTrue( init.write( code ) );
		assertTrue( code.write( ';' ) );
		code.close();

		assertTrue( tmpFile.canRead() );
		InputStream in = new BufferedInputStream( new FileInputStream( tmpFile ) );
		byte[] buff = new byte[16384];
		int len = in.read( buff, 0, buff.length - 1 );
		assertTrue( len < buff.length );

		String expected
			= "\n"
			+ "{\n"
			+ "    ENUM_1, ENUM_2, ENUM_3\n"
			+ "};";
		assertEquals( expected, new String( buff, 0, len ) );
	}

	@Test
	public void testBlockOfBlocksInit() throws IOException
	{
		// access expressions for the init expression
		ElementAccess access1 = LangCFactory.eINSTANCE.createElementAccess();
		access1.setName( enum1Name );

		ElementAccess access2 = LangCFactory.eINSTANCE.createElementAccess();
		access2.setName( enum2Name );

		ElementAccess access3 = LangCFactory.eINSTANCE.createElementAccess();
		access3.setName( enum3Name );

		BlockInitializer init1 = LangCFactory.eINSTANCE.createBlockInitializer();
		init1.getExprs().add( access1 );

		BlockInitializer init2 = LangCFactory.eINSTANCE.createBlockInitializer();
		init2.getExprs().add( access2 );

		BlockInitializer init = LangCFactory.eINSTANCE.createBlockInitializer();
		init.getExprs().add( init1 );
		init.getExprs().add( init2 );

		// format the expression into a tmp file
		File tmpFile = File.createTempFile( getClass().getName(), null );
		if( tmpFile.exists() )
			tmpFile.delete();

		CodeWriter code
			= CodeWriter.create(
					tmpFile.getParentFile().getAbsolutePath(),
					tmpFile.getName() );

		assertTrue( init.write( code ) );
		assertTrue( code.write( ';' ) );
		code.close();

		assertTrue( tmpFile.canRead() );
		InputStream in = new BufferedInputStream( new FileInputStream( tmpFile ) );
		byte[] buff = new byte[16384];
		int len = in.read( buff, 0, buff.length - 1 );
		assertTrue( len < buff.length );

		String expected
			= "\n"
			+ "{\n"
			+ "    {\n"
			+ "        ENUM_1\n"
			+ "    }, \n" // TODO test for absence of trailing whitespace
			+ "    {\n"
			+ "        ENUM_2\n"
			+ "    }\n"
			+ "};";
		assertEquals( expected, new String( buff, 0, len ) );
	}
}
