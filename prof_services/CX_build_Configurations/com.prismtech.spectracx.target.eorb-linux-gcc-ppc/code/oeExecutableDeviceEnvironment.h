#ifndef __OE_EXECUTABLE_DEVICE_ENVIRONMENT_H
#define __OE_EXECUTABLE_DEVICE_ENVIRONMENT_H

#include "oeCFExecutableDevice.h"
#include <map>
#include <list>
#include "oeCorbaExceptionMacros.h"

#include <string>
#include <sys/wait.h>
#include <sys/stat.h>

class OEFileInfo {
public:
	std::string strFilename;
	std::string strLocalFilename;
	CF::LoadableDevice::LoadType type;
	unsigned int refCount;
	void * module;
	OEFileInfo *next;

	OEFileInfo (std::string filename, std::string localFilename, CF::LoadableDevice::LoadType loadType, void * mod) :
			strFilename (filename), strLocalFilename (localFilename), type (loadType), refCount (1), module (mod), next (NULL) {};
};

class FileList {
private:
	OEFileInfo *head;
	OEFileInfo *tail;

public:
	FileList () {
		head = tail = NULL;
	};

	void add (std::string filename, std::string localFilename, CF::LoadableDevice::LoadType type, void * module);
	bool remove (std::string filename);
	OEFileInfo * find (std::string filename);
};

OEFileInfo * FindFile (const char * filename, FileList& fileList);

typedef pid_t pid_type;
typedef pthread_t tid_type;

// needed to collect information about a process/thread
class OEExecInfo {
public:
	CF::ExecutableDevice::ProcessID_Type id;
	CF::LoadableDevice::LoadType loadKind;

	bool operator == (const OEExecInfo &rhs) const
	{
		return (id == rhs.id && loadKind == rhs.loadKind);
	}
};
typedef std::list<OEExecInfo> ExecInfoList;


//Spawn a new process
bool SpawnProcess(int argc, char** argv, unsigned long ulStackSize,
		unsigned long ulPriority, CF::ExecutableDevice::ProcessID_Type& id, ExecInfoList& execInfoList, std::string &strErr);

//Kill a running process
bool KillProcess(CF::ExecutableDevice::ProcessID_Type id, ExecInfoList& execInfoList, std::string &strErr);

//Platform dependent load
bool LoadFile(CF::FileSystem_ptr fs, const char *fileName, std::string deviceId, CF::LoadableDevice::LoadType loadKind, FileList& fileList, std::string& strErr OE_ENV_ARGN);

//Platform dependent unload
bool UnloadFile(const char *fileName, FileList& fileList, std::string& strErr);

//Provides boolean of what LoadType is supported
#define IS_SUPPORTED_LOADTYPE(type) (type==CF::LoadableDevice::EXECUTABLE || type==CF::LoadableDevice::SHARED_LIBRARY)

#endif     // __OE_EXECUTABLE_DEVICE_ENVIRONMENT_H
// End-Of-File
//------------------------------------------------------------------------------
