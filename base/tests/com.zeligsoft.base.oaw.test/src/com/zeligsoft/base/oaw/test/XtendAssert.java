package com.zeligsoft.base.oaw.test;

import java.util.Iterator;

import java.util.StringTokenizer;

import junit.framework.AssertionFailedError;
import junit.framework.ComparisonFailure;
@SuppressWarnings("nls")
public class XtendAssert
{
	private static class IterableTokens implements Iterable<String>
	{
		private final StringTokenizer tokenizer;
		public IterableTokens( StringTokenizer t ) { this.tokenizer = t; }

		public Iterator<String> iterator()
		{
			return new Iterator<String>()
			{
				public void remove() { }
				public boolean hasNext() { return tokenizer.hasMoreTokens(); }
				public String next()     { return tokenizer.nextToken(); }
			};
		}
	}

	public static void assertTokens( String actual, String...expectedTokens )
	{
		if( actual == null )
			throw new AssertionFailedError( "Unexpected null result" );

		int i = 0;
		for( String token1 : new IterableTokens( new StringTokenizer( actual ) ) )
			for( String token2 : new IterableTokens( new StringTokenizer( token1, ";(){}[]&*,", true ) ) )
				if( i >= expectedTokens.length )
					throw new AssertionFailedError( "Too many tokens, still found " + token2 );
				else if( ! token2.equals( expectedTokens[i] ) )
					throw new ComparisonFailure( "Unexpected token at index " + i, expectedTokens[i], token2 );
				else
					++i;

		if( i < expectedTokens.length )
			throw new AssertionFailedError( "Too few tokens, could not find " + expectedTokens[i] );
	}
}
