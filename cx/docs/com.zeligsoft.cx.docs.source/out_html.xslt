<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes">
	<xsl:output method="html" version="1.0" encoding="ISO-8859-1" indent="yes"/>
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>

	<xsl:variable name="productName">Spectra CX</xsl:variable>
	<xsl:variable name="companyName">PrismTech</xsl:variable>
	<xsl:variable name="productSupport">support@prismtech.com</xsl:variable>
	<xsl:variable name="RSx">Rational Software Modeler</xsl:variable>


	<xsl:template match="pn">
			<xsl:value-of select="$productName"/>	
	</xsl:template>

	<xsl:template match="RSx">
			<xsl:value-of select="$RSx"/>	
	</xsl:template>

	<xsl:template match="cn">
			<xsl:value-of select="$companyName"/>	
	</xsl:template>

	<xsl:template match="ps">
			<xsl:value-of select="$productSupport"/>	
	</xsl:template>

	<xsl:template match="/root/helpTopics/helpTopic">
		<!-- set the file name here. Not all file names in the xml file end in .html so we need to check for it -->
		<xsl:variable name="filename">
			<xsl:value-of select="concat('../com.zeligsoft.cx.docs/output/',@outputFile)"/>
		</xsl:variable>
		<!-- Create the file  -->
		<xsl:result-document href="{$filename}">
			<head>
				<title>
					<xsl:value-of select="@title"/>
				</title>
				<link rel="stylesheet" type="text/css" href="../helpStyle.css"/>
			</head>
			<html>
				<body>
					<xsl:apply-templates select="@*|node()"/>
					<xsl:call-template name="writeFfooter"/>
				</body>
			</html>
		</xsl:result-document>
	</xsl:template>
	
	
	<!-- ======================================================================= -->
	  <!-- Start running footer -->
	<xsl:template name="writeFfooter">
		<div class="runningfooter" id="dochomefooter">
			<a href="http://www.prismtech.com/contact" shape="rect" target="_blank">Provide feedback</a> <br clear="none" />  <!-- this is pointing at our Contact Us Website page -->
			<hr />  
			Copyright <sup>&#169;</sup> 2010 Zeligsoft Ltd. All rights reserved.
			
		</div>
	</xsl:template>


</xsl:stylesheet>
