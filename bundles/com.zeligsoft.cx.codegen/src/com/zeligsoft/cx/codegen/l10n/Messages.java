/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.cx.codegen.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
	public static String EObjectLocator_MissingAttribute;
	public static String EObjectLocator_BadAttribute;

	public static String UserEditableRegion_StoreObjectLabel;
	public static String UserEditableRegion_CannotSaveChanges;
	public static String UserEditableRegion_CannotConvertToPlainFS;
	public static String UserEditableRegion_CannotConvertToCXGenFS;
	public static String UserEditableRegion_CannotCreateParent;

	public static String ParsingOutputStream_MissingSpecifier;
	public static String ParsingOutputStream_OverlappingRegion;
	public static String ParsingOutputStream_DuplicateRegionLabel;
	public static String ParsingOutputStream_UnexpectedEnding;
	public static String ParsingOutputStream_ProblemCreateError;

	public static String CXGenFileStore_OpenFailed;
	public static String CXGenFileStore_SaveFailed;
	public static String CXGenFileStore_FileInaccessible;
	public static String CXGenFileStore_BadUri;

	public static String CXGenFileHandle_CannotCreateParent;
	public static String CXGenFileHandle_FileExists;
	public static String CXGenFileHandle_OpeningFile;
	public static String CXGenFileHandle_CannotWriteFile;
	public static String CXGenFileHandle_CannotEncodeFile;

	public static String Formatter_CantFormat;
	public static String Formatter_IllegalTree;
	public static String Formatter_BadLocation;

	static
	{
		NLS.initializeMessages( "com.zeligsoft.cx.codegen.l10n.messages", Messages.class );
	}

	private Messages() { /* empty */ }
}
