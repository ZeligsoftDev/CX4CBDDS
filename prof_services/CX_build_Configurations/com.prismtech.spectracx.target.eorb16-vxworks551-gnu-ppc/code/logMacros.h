#ifndef __LOG_MACROS_H
#define __LOG_MACROS_H

/*
 * RECORD_ACCESSOR is used to access records at a specific index in a sequence.
 *
 * For example, to access the producerId of a record at index = 4 of a
 * ProducerLogRecordSequence named logRecords you would type the following
 * RECORD_ACCESSOR(logRecords, 4).producerId.
 *
 */
#define RECORD_ACCESSOR(records, index) (*records)[index]



#endif // __LOG_MACROS_H
// End-Of-File
//------------------------------------------------------------------------------

