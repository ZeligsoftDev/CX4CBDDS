#ifndef __OE_EXECUTABLE_DEVICE_ENVIRONMENT_H
#define __OE_EXECUTABLE_DEVICE_ENVIRONMENT_H

#include <map>
#include <list>
#include <string>

#include "CF.h"
#include "oeCorbaExceptionMacros.h"

class OEFileInfo {
	public :
		std::string strLocalFilename;
		CF::LoadableDevice::LoadType type;
		unsigned int refCount;
};
typedef std::map<std::string, OEFileInfo> FileMap;

typedef pid_t pid_type;
typedef pthread_t tid_type;

// needed to collect information about a process/thread
class OEExecInfo {
public:
	CF::ExecutableDevice::ProcessID_Type id;
	PROCESS_INFORMATION pi;

	bool operator == (const OEExecInfo &rhs) const
	{
		return (id == rhs.id);
	}

	bool operator == (const pid_type pid) const
	{
		return (id == pid);
	}
};
typedef std::list<OEExecInfo> ExecInfoList;

//Spawn a new process
bool SpawnProcess(int argc, char** argv, unsigned long ulStackSize, 
		unsigned long ulPriority, CF::ExecutableDevice::ProcessID_Type& id, ExecInfoList& execInfoList, std::string &strErr);

//Kill a running process
bool KillProcess(CF::ExecutableDevice::ProcessID_Type id, ExecInfoList& execInfoList, std::string &strErr);

//Platform dependent load
bool LoadFile(CF::FileSystem_ptr fs, const char *fileName, std::string deviceId, CF::LoadableDevice::LoadType loadKind, FileMap& fileMap, std::string& strErr OE_ENV_ARGN);

//Platform dependent unload
bool UnloadFile(const char *fileName, FileMap& fileMap, std::string& strErr);

//Provides boolean of what LoadType is supported
#define IS_SUPPORTED_LOADTYPE(type) (type==CF::LoadableDevice::EXECUTABLE)

#endif     // __OE_EXECUTABLE_DEVICE_ENVIRONMENT_H
// End-Of-File
//------------------------------------------------------------------------------
