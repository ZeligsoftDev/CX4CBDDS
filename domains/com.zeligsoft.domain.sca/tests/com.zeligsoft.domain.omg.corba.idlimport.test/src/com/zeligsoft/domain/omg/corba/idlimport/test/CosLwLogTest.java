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
package com.zeligsoft.domain.omg.corba.idlimport.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;

/**
 * 
 * @author smcfee
 *
 * Tests for iterative IDL import. They involve continuously writing over the same IDLFile and 
 * merging model contents together.
 */
public class CosLwLogTest extends IDLImportTestCase {

	final static String compName = "ReimportTestsModel::Comp::Comp"; //$NON-NLS-1$
	
	protected static final String COSLWLOG_MODEL_NAME = "CosLwLog"; //$NON-NLS-1$
	
	protected static final String COSLWLOG_MODEL_FILE_NAME = COSLWLOG_MODEL_NAME + ".emx"; //$NON-NLS-1$
	
	protected static final String COSLWLOG_MODEL_FILE_PATH = "models/" //$NON-NLS-1$
		+ COSLWLOG_MODEL_FILE_NAME;
	
	
	public CosLwLogTest() {
		modelName = COSLWLOG_MODEL_NAME;
		modelfilePath = COSLWLOG_MODEL_FILE_PATH;
	}
	
	/**
	 * The suite of tests owned by this test case.
	 * @return
	 */
	public static Test suite() {
		return new TestSuite(CosLwLogTest.class, "Iterative IDL Import Tests"); //$NON-NLS-1$
	}
	
	/**
	 *
	 * 
	 *
	 */
	public void testImportLogIDL() {
		
		ArrayList<String> idlFiles = new ArrayList<String>();
		idlFiles.add("idl/coslwlog/CosLwLogAdministrator.idl"); //$NON-NLS-1$
		idlFiles.add("idl/coslwlog/CosLwLogConsumer.idl"); //$NON-NLS-1$
		idlFiles.add("idl/coslwlog/CosLwLogProducer.idl"); //$NON-NLS-1$
		idlFiles.add("idl/coslwlog/CosLwLogService.idl"); //$NON-NLS-1$
		idlFiles.add("idl/coslwlog/CosLwLogStatus.idl"); //$NON-NLS-1$
		
		List<String> includes = new ArrayList<String>();
		List<String> defines = new ArrayList<String>();
		defines.add("_PRE_3_0_COMPILER_"); //$NON-NLS-1$

		final boolean importOk = importIDL(idlFiles, includes, defines);
		
		// make sure that there were no issues
		assertTrue(importOk);
		
		String qualifiedPath = "CosLwLog" + "::" + IMPORTED_PACKAGE_NAME;
		
		// START get the imports we need to check against
		
		Model idlPrimitives = null; 
		for (Package ip : model.getImportedPackages()) {
			if (ip instanceof Model && ip.getName().equals("IDLPrimitives")){
				idlPrimitives = (Model)ip;
				break;
			}
		}
		// END
		
		DataType corbuULong = (DataType) idlPrimitives.getPackagedElement("CORBAULong");
		DataType corbuULongLong = (DataType) idlPrimitives.getPackagedElement("CORBAULongLong");
		
		/*
		 * START check that the idl/coslwlog/CosLwLogStatus.idl import was ok
		 * 
		 */
		String status = qualifiedPath + "::CosLwLogStatus::CosLwLog";
		Package logStatus = (Package)lookup(status);
		assertEquals(logStatus.getPackagedElements().size(), 16);
		
		
		String CosLwLog_ConstantsPath = status + "::CosLwLog_Constants";
		Class CosLwLog_Constants = (Class)lookup(CosLwLog_ConstantsPath);
		assertNotNull(CosLwLog_Constants);
		Property administrativeEvent = (Property)lookup(CosLwLog_ConstantsPath + "::ADMINISTRATIVE_EVENT");
		assertEquals("8", administrativeEvent.getDefault());
		Property degradedAlarm = (Property)lookup(CosLwLog_ConstantsPath + "::DEGRADED_ALARM");
		assertEquals("3", degradedAlarm.getDefault());
		Property exceptionError = (Property)lookup(CosLwLog_ConstantsPath + "::EXCEPTION_ERROR");
		assertEquals("4", exceptionError.getDefault());
		Property failureAlarm = (Property)lookup(CosLwLog_ConstantsPath + "::FAILURE_ALARM");
		assertEquals("2", failureAlarm.getDefault());
		Property flowControlError = (Property)lookup(CosLwLog_ConstantsPath + "::FLOW_CONTROL_ERROR");
		assertEquals("5", flowControlError.getDefault());
		Property rangeError = (Property)lookup(CosLwLog_ConstantsPath + "::RANGE_ERROR");
		assertEquals("6", rangeError.getDefault());
		Property securityAlarm = (Property)lookup(CosLwLog_ConstantsPath + "::SECURITY_ALARM");
		assertEquals("1", securityAlarm.getDefault());
		Property statisticReport = (Property)lookup(CosLwLog_ConstantsPath + "::STATISTIC_REPORT");
		assertEquals("9", statisticReport.getDefault());
		Property usageError = (Property)lookup(CosLwLog_ConstantsPath + "::USAGE_ERROR");
		assertEquals("7", usageError.getDefault());
		
		Enumeration administrativeStateType = (Enumeration)lookup(status + "::AdministrativeState");
		assertEnum(administrativeStateType);
		assertEnumLiteralCount(administrativeStateType, 2); 
		
		Enumeration logFullActionType = (Enumeration)lookup(status + "::LogFullAction");
		assertEnum(logFullActionType);
		assertEnumLiteralCount(logFullActionType, 2);
		
		Enumeration operationalStateType = (Enumeration)lookup(status + "::OperationalState");
		assertEnum(operationalStateType);
		assertEnumLiteralCount(operationalStateType, 2);
		
		Interface logStatusType = (Interface)lookup(status + "::LogStatus");
		assertInterface(logStatusType);
		
		DataType availabilityStatusType = (DataType)lookup(status + "::AvailabilityStatus");
		assertStruct(availabilityStatusType);
		assertStructFieldCount(availabilityStatusType, 2);
		
		DataType invalidParamType = (DataType)lookup(status + "::InvalidParam");
		assertException(invalidParamType);
		assertEquals(1, invalidParamType.getAllAttributes().size());
		
		DataType logLevelType = (DataType)lookup(status + "::LogLevel");
		assertTypedef(logLevelType);
		
		DataType logLevelSequenceType = (DataType)lookup(status + "::LogLevelSequence");
		assertSequence(logLevelSequenceType);
		assertEquals(1, logLevelSequenceType.getAllAttributes().size());
		
		DataType logRecordType = (DataType)lookup(status + "::LogRecord");
		assertStruct(logRecordType);
		assertStructFieldCount(logRecordType, 3);
		
		DataType logRecordSequenceType = (DataType)lookup(status + "::LogRecordSequence");
		assertSequence(logRecordSequenceType);
		assertEquals(1, logRecordSequenceType.getAllAttributes().size());
		
		DataType logTimeType = (DataType)lookup(status + "::LogTime");
		assertStruct(logTimeType);
		assertStructFieldCount(logTimeType, 2);
		
		DataType producerLogRecordType = (DataType)lookup(status + "::ProducerLogRecord");
		assertStruct(producerLogRecordType);
		assertStructFieldCount(producerLogRecordType, 4);
		
		DataType producerLogRecordSequenceType = (DataType)lookup(status + "::ProducerLogRecordSequence");
		assertSequence(producerLogRecordSequenceType);
		assertEquals(1, producerLogRecordSequenceType.getAllAttributes().size());
		
		DataType recordIdType = (DataType)lookup(status + "::RecordId");
		assertTypedef(recordIdType);
		assertGeneralizationCount(recordIdType, 1);
		
		DataType stringSeqType = (DataType)lookup(status + "::StringSeq");
		assertSequence(stringSeqType);
		assertEquals(1, stringSeqType.getAllAttributes().size());
		
		/*
		 * END check that the idl/coslwlog/CosLwLogStatus.idl import was ok
		 * 
		 */
		
		
		
		
		
		/*
		 * START check that the idl/coslwlog/CosLwLogAdministrator.idl import was ok
		 */
		String administrator = qualifiedPath + "::CosLwLogAdministrator::CosLwLog::LogAdministrator";
		Interface logAdministrator = (Interface)lookup(administrator);
		assertEquals(logAdministrator.getOwnedOperations().size(), 5);
		assertGeneralizationCount(logAdministrator, 1);
		
		Operation administrator_clear_log = (Operation)lookup(administrator + "::clear_log");
		assertOperation(administrator_clear_log);
		
		Operation administrator_destroy = (Operation)lookup(administrator + "::destroy");
		assertOperation(administrator_destroy);
		
		String setAdministrativeStatePath = administrator + "::set_administrative_state";
		Operation setAdministrativeState = (Operation)lookup(setAdministrativeStatePath);
		assertOperation(setAdministrativeState);
		Parameter setAdministrativeStateParamState = (Parameter)lookup(setAdministrativeStatePath + "::state");
		assertInParameter(setAdministrativeStateParamState);
		assertParameterType(setAdministrativeStateParamState, administrativeStateType);
		
		String setLogFullActionPath = administrator + "::set_log_full_action";
		Operation setLogFullAction = (Operation)lookup(setLogFullActionPath);
		assertOperation(setLogFullAction);
		Parameter setLogFullActionParamAction = (Parameter)lookup(setLogFullActionPath + "::action");
		assertInParameter(setLogFullActionParamAction);
		assertParameterType(setLogFullActionParamAction, logFullActionType);
		
		String setMaxSizePath = administrator + "::set_max_size";
		Operation setMaxSize = (Operation)lookup(setMaxSizePath);
		assertOperation(setMaxSize);
		Parameter setMaxSizeParamSize = (Parameter)lookup(setMaxSizePath + "::size");
		assertInParameter(setMaxSizeParamSize);
		assertParameterType(setMaxSizeParamSize, corbuULongLong);

		/*
		 * END check that the idl/coslwlog/CosLwLogAdministrator.idl import was ok
		 */
		
		
		
		
		/* 
		 * START check that the idl/coslwlog/CosLwLogConsumer.idl import was ok
		 */
		String consumer = qualifiedPath + "::CosLwLogConsumer::CosLwLog::LogConsumer";
		Interface logConsumer = (Interface)lookup(consumer);
		assertEquals(logConsumer.getOwnedOperations().size(), 5);
		assertGeneralizationCount(logConsumer, 1);
		
		String getRecordIdFromTimePath = consumer + "::get_record_id_from_time";
		Operation getRecordIdFromTime = (Operation)lookup(getRecordIdFromTimePath);
		assertOperation(getRecordIdFromTime);
		//ensure we have a return parameter of type RecordId
		Parameter getRecordIdFromTimeParamReturn = getRecordIdFromTime.getReturnResult();
		assertParameter(getRecordIdFromTimeParamReturn);
		assertOperationReturnType(getRecordIdFromTime, recordIdType);
		
		Parameter getRecordIdFromTimeParamFromTime = (Parameter)lookup(getRecordIdFromTimePath + "::fromTime");
		assertInParameter(getRecordIdFromTimeParamFromTime);
		assertParameterType(getRecordIdFromTimeParamFromTime, logTimeType);		
		
		
		String retrieveRecordsByLevelPath = consumer + "::retrieve_records_by_level";
		Operation retrieveRecordsByLevel = (Operation)lookup(retrieveRecordsByLevelPath);
		assertOperation(retrieveRecordsByLevel);
		//ensure we have a return parameter of type LogRecordSequence
		Parameter retrieveRecordsByLevelParamReturn = getRecordIdFromTime.getReturnResult();
		assertParameter(retrieveRecordsByLevelParamReturn);
		assertOperationReturnType(retrieveRecordsByLevel, logRecordSequenceType);
		
		Parameter retrieveRecordsByLevelParamCurrentId = (Parameter)lookup(retrieveRecordsByLevelPath + "::currentId");
		assertInOutParameter(retrieveRecordsByLevelParamCurrentId);
		assertParameterType(retrieveRecordsByLevelParamCurrentId, recordIdType);
		
		Parameter retrieveRecordsByLevelParamHowMany = (Parameter)lookup(retrieveRecordsByLevelPath + "::howMany");
		assertInOutParameter(retrieveRecordsByLevelParamHowMany);
		assertParameterType(retrieveRecordsByLevelParamHowMany, corbuULong);
		
		Parameter retrieveRecordsByLevelParamValueList = (Parameter)lookup(retrieveRecordsByLevelPath + "::valueList");
		assertInParameter(retrieveRecordsByLevelParamValueList);
		assertParameterType(retrieveRecordsByLevelParamValueList, logLevelSequenceType);
		
		
		
		String retrieveRecordsByProducerIdPath = consumer + "::retrieve_records_by_producer_id";
		Operation retrieveRecordsByProducerId = (Operation)lookup(retrieveRecordsByProducerIdPath);
		assertOperation(retrieveRecordsByProducerId);
		Parameter retrieveRecordsByProducerIdParamReturn = retrieveRecordsByProducerId.getReturnResult();
		assertParameter(retrieveRecordsByProducerIdParamReturn);
		assertOperationReturnType(retrieveRecordsByProducerId, logRecordSequenceType);
		
		Parameter retrieveRecordsByProducerIdParamCurrentId = (Parameter)lookup(retrieveRecordsByProducerIdPath + "::currentId");
		assertInOutParameter(retrieveRecordsByProducerIdParamCurrentId);
		assertParameterType(retrieveRecordsByProducerIdParamCurrentId, recordIdType);
		
		Parameter retrieveRecordsByProducerIdParamHowMany = (Parameter)lookup(retrieveRecordsByProducerIdPath + "::howMany");
		assertInOutParameter(retrieveRecordsByProducerIdParamHowMany);
		assertParameterType(retrieveRecordsByProducerIdParamHowMany, corbuULong);
		
		Parameter retrieveRecordsByProducerIdParamValueList = (Parameter)lookup(retrieveRecordsByProducerIdPath + "::valueList");
		assertInParameter(retrieveRecordsByProducerIdParamValueList);
		assertParameterType(retrieveRecordsByProducerIdParamValueList, stringSeqType);
		
		
		String retrieveRecordsByProducerNamePath = consumer + "::retrieve_records_by_producer_name";
		Operation retrieveRecordsByProducerName = (Operation)lookup(retrieveRecordsByProducerNamePath);
		assertOperation(retrieveRecordsByProducerName);
		Parameter retrieveRecordsByProducerNameParamReturn = retrieveRecordsByProducerName.getReturnResult();
		assertParameter(retrieveRecordsByProducerNameParamReturn);
		assertOperationReturnType(retrieveRecordsByProducerName, logRecordSequenceType);
		
		Parameter retrieveRecordsByProducerNameParamCurrentId = (Parameter)lookup(retrieveRecordsByProducerNamePath + "::currentId");
		assertInOutParameter(retrieveRecordsByProducerNameParamCurrentId);
		assertParameterType(retrieveRecordsByProducerNameParamCurrentId, recordIdType);
		
		Parameter retrieveRecordsByProducerNameParamHowMany = (Parameter)lookup(retrieveRecordsByProducerNamePath + "::howMany");
		assertInOutParameter(retrieveRecordsByProducerNameParamHowMany);
		assertParameterType(retrieveRecordsByProducerNameParamHowMany, corbuULong);
		
		Parameter retrieveRecordsByProducerNameParamValueList = (Parameter)lookup(retrieveRecordsByProducerNamePath + "::valueList");
		assertInParameter(retrieveRecordsByProducerNameParamValueList);
		assertParameterType(retrieveRecordsByProducerNameParamValueList, stringSeqType);
		
		
		String retrieveRecordsPath = consumer + "::retrieve_records";
		Operation retrieveRecords = (Operation)lookup(retrieveRecordsPath);
		assertOperation(retrieveRecords);
		Parameter retrieveRecordsParamReturn = retrieveRecords.getReturnResult();
		assertParameter(retrieveRecordsParamReturn);
		assertOperationReturnType(retrieveRecords, logRecordSequenceType);
		
		Parameter retrieveRecordsParamCurrentId = (Parameter)lookup(retrieveRecordsPath + "::currentId");
		assertInOutParameter(retrieveRecordsParamCurrentId);
		assertParameterType(retrieveRecordsParamCurrentId, recordIdType);
		
		Parameter retrieveRecordsParamHowMany = (Parameter)lookup(retrieveRecordsPath + "::howMany");
		assertInOutParameter(retrieveRecordsParamHowMany);
		assertParameterType(retrieveRecordsParamHowMany, corbuULong);
	
		/* 
		 * END check that the idl/coslwlog/CosLwLogConsumer.idl import was ok
		 */
		
		
		
		/*
		 * START check that the idl/coslwlog/CosLwLogProducer.idl import was ok
		 */
		String producer = qualifiedPath + "::CosLwLogProducer::CosLwLog::LogProducer";
		Interface logProducer = (Interface)lookup(producer);
		assertEquals(logProducer.getOwnedOperations().size(), 2);
		assertGeneralizationCount(logProducer, 1);
		
		String writeRecordPath = producer + "::write_record";
		Operation writeRecord = (Operation)lookup(writeRecordPath);
		assertOperation(writeRecord);
		Parameter writeRecordParamRecord = (Parameter)lookup(writeRecordPath + "::record");
		assertInParameter(writeRecordParamRecord);
		assertParameterType(writeRecordParamRecord, producerLogRecordType);

		String writeRecordsPath = producer + "::write_records";
		Operation writeRecords = (Operation)lookup(writeRecordsPath);
		assertOperation(writeRecords);
		Parameter writeRecordsParamRecords = (Parameter)lookup(writeRecordsPath + "::records");
		assertInParameter(writeRecordsParamRecords);
		assertParameterType(writeRecordsParamRecords, producerLogRecordSequenceType);		
		
		/*
		 * END check that the idl/coslwlog/CosLwLogProducer.idl import was ok
		 */
		
		
		//check that the idl/coslwlog/CosLwLogService.idl import was ok
		String service = qualifiedPath + "::CosLwLogService::CosLwLog::Log";
		Interface logService = (Interface)lookup(service);
		assertGeneralizationCount(logService, 3);
	}	
}
