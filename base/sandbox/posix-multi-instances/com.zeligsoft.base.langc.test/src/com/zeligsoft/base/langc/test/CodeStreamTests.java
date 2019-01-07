package com.zeligsoft.base.langc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import com.zeligsoft.base.langc.m2t.CodeStream;

@SuppressWarnings("nls")
public class CodeStreamTests extends TestCase {

	// java.io.UnixFileSystem (where the tests run on the build machine) seems to provide
	// filestamps only on the 1-second boundaries, when running on Linux the test will pause
	// until the next second
	private static final boolean isUnixFileSystem
		= System.getProperty("os.name", "DefaultOS").startsWith("Linux");

	private void pause()
	{
		synchronized( this )
		{
			long delay
				= isUnixFileSystem
					? ( ( System.currentTimeMillis() + 1000 ) / 1000 * 1000 - System.currentTimeMillis() + 10 )
					: 20;

			try { wait( delay ); }
			catch( InterruptedException e ) { /* empty */ }
		}
	}

	public void testMissingFile() throws IOException
	{
		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		file.delete();
		assertFalse( file.exists() );

		int sample = 42;
		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample );
		stm.close();

		file = new File( pathname );
		assertTrue( file.exists() );

		assertEquals( 1, file.length() );
		FileInputStream in = new FileInputStream( file );
		assertEquals( sample, in.read() );
		assertEquals( -1, in.read() );
		in.close();
		file.deleteOnExit();
	}

	public void testSameContent() throws IOException
	{
		int sample = 42;

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime == file.lastModified() );

		assertEquals( 1, file.length() );
		FileInputStream in = new FileInputStream( file );
		assertEquals( sample, in.read() );
		assertEquals( -1, in.read() );
		in.close();
		file.deleteOnExit();
	}

	public void testDifferentContent() throws IOException
	{
		int sample01 = 42;
		int sample02 = sample01 + 1;

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample01 );
		stm.write( sample02 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( 2, file.length() );
		FileInputStream in = new FileInputStream( file );
		assertEquals( sample01, in.read() );
		assertEquals( sample02, in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testShorterFile() throws IOException
	{
		int sample01 = 42;

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample01 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( 1, file.length() );
		FileInputStream in = new FileInputStream( file );
		assertEquals( sample01, in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testLongerFile() throws IOException
	{
		int sample01 = 42;
		int sample02 = sample01 + 1;
		int sample03 = sample01 + 2;

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.write( sample02 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample01 );
		stm.write( sample02 );
		stm.write( sample03 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( 3, file.length() );
		FileInputStream in = new FileInputStream( file );
		assertEquals( sample01, in.read() );
		assertEquals( sample02, in.read() );
		assertEquals( sample03, in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testShorterFileWithNewContent() throws IOException
	{
		int sample01 = 42;

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.write( sample01 );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample01 );
		stm.write( sample01 + 1 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( 2, file.length() );
		FileInputStream in = new FileInputStream( file );
		assertEquals( sample01, in.read() );
		assertEquals( sample01 + 1, in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testBuffMissingFile() throws IOException
	{
		byte[] sample = new byte[]{ 42, 43, 44, 45 };

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		file.delete();
		assertFalse( file.exists() );

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample );
		stm.close();

		file = new File( pathname );
		assertTrue( file.exists() );

		assertEquals( sample.length, file.length() );
		FileInputStream in = new FileInputStream( file );
		for( int i = 0; i < sample.length; ++i )
			assertEquals( sample[i], in.read() );
		assertEquals( -1, in.read() );
		in.close();
		file.deleteOnExit();
	}

	public void testBuffSameContent() throws IOException
	{
		byte[] sample = new byte[]{ 42, 43, 44, 45 };

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime == file.lastModified() );

		assertEquals( sample.length, file.length() );
		FileInputStream in = new FileInputStream( file );
		for( int i = 0; i < sample.length; ++i )
			assertEquals( sample[i], in.read() );
		assertEquals( -1, in.read() );
		in.close();
		file.deleteOnExit();
	}

	public void testBuffDifferentContent() throws IOException
	{
		byte[] sample01 = new byte[]{ 42, 43, 44, 45 };
		byte[] sample02 = new byte[]{ 42, 43, 46, 47 };

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample02 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( sample02.length, file.length() );
		FileInputStream in = new FileInputStream( file );
		for( int i = 0; i < sample02.length; ++i )
			assertEquals( sample02[i], in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testBuffShorterFile() throws IOException
	{
		byte[] sample01 = new byte[]{ 42, 43, 44, 45 };
		byte[] sample02 = new byte[]{ 42, 43 };

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample02 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( sample02.length, file.length() );
		FileInputStream in = new FileInputStream( file );
		for( int i = 0; i < sample02.length; ++i )
			assertEquals( sample02[i], in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testBuffLongerFile() throws IOException
	{
		byte[] sample01 = new byte[]{ 42, 43, 44, 45 };
		byte[] sample02 = new byte[]{ 42, 43, 44, 45, 46, 47, 48, 49 };

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample02 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( sample02.length, file.length() );
		FileInputStream in = new FileInputStream( file );
		for( int i = 0; i < sample02.length; ++i )
			assertEquals( sample02[i], in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testBuffShorterFileWithNewContent() throws IOException
	{
		byte[] sample01 = new byte[]{ 42, 43, 44, 45 };
		byte[] sample02 = new byte[]{ 42, 46, 44 };

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname );
		stm.write( sample02 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( sample02.length, file.length() );
		FileInputStream in = new FileInputStream( file );
		for( int i = 0; i < sample02.length; ++i )
			assertEquals( sample02[i], in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testBuffDiffOnBoundary() throws IOException
	{
		byte[] sample01 = new byte[]{ 42, 43, 44, 45 };
		byte[] sample02 = new byte[]{ 42, 44, 46, 47 };

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname, 2 );
		stm.write( sample02 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( sample02.length, file.length() );
		FileInputStream in = new FileInputStream( file );
		for( int i = 0; i < sample02.length; ++i )
			assertEquals( sample02[i], in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testBuffDiffBeforeBoundary() throws IOException
	{
		byte[] sample01 = new byte[]{ 42, 43, 44, 45 };
		byte[] sample02 = new byte[]{ 42, 46, 44, 45 };

		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		FileOutputStream out = new FileOutputStream( file );
		out.write( sample01 );
		out.close();

		long modTime = file.lastModified();
		pause();

		CodeStream stm = CodeStream.create( pathname, 2 );
		stm.write( sample02 );
		stm.close();

		assertTrue( file.exists() );
		assertTrue( modTime < file.lastModified() );

		assertEquals( sample02.length, file.length() );
		FileInputStream in = new FileInputStream( file );
		for( int i = 0; i < sample02.length; ++i )
			assertEquals( sample02[i], in.read() );
		assertEquals( -1, in.read() );

		in.close();
		file.deleteOnExit();
	}

	public void testDeferredCreate() throws IOException
	{
		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		file.delete();

		assertFalse( new File( pathname ).exists() );

		CodeStream stm = CodeStream.createProvisional( pathname );
		assertNotNull( stm );

		assertFalse( new File( pathname ).exists() );

		file.deleteOnExit();
	}

	public void testProvisionalWriteOnNewFile() throws IOException
	{
		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		file.delete();
		assertFalse( new File( pathname ).exists() );

		CodeStream stm = CodeStream.createProvisional( pathname );
		assertNotNull( stm );
		assertFalse( new File( pathname ).exists() );
		assertTrue( stm.isProvisional() );
		stm.write( 'a' );
		assertTrue( stm.isProvisional() );
		assertFalse( new File( pathname ).exists() );
		stm.close();
		assertFalse( new File( pathname ).exists() );
	}

	public void testRealWriteOnNewFile() throws IOException
	{
		File file = File.createTempFile( "cstm", null );
		String pathname = file.getAbsolutePath();
		file.delete();
		assertFalse( new File( pathname ).exists() );

		// write real content, make sure the file is created
		CodeStream stm = CodeStream.createProvisional( pathname );
		assertNotNull( stm );
		assertFalse( new File( pathname ).exists() );
		stm.write( 'b' );
		assertFalse( new File( pathname ).exists() );

		stm.enableWrites();
		assertFalse( new File( pathname ).exists() );
		stm.write( 'c' );
		assertTrue( new File( pathname ).exists() );
		stm.close();

		FileInputStream in = new FileInputStream( file );
		assertEquals( 'b', in.read() );
		assertEquals( 'c', in.read() );
		assertEquals( -1, in.read() );
		in.close();

		// create a new stream, with provisional content, make sure file
		// gets deleted
		stm = CodeStream.createProvisional( pathname );
		assertNotNull( stm );
		assertTrue( new File( pathname ).exists() );
		stm.write( 'd' );
		stm.write( 'e' );
		assertTrue( new File( pathname ).exists() );
		stm.close();
		assertFalse( new File( pathname ).exists() );
	}
}
