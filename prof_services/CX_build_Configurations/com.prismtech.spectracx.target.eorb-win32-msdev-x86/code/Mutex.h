#ifndef __MUTEX_H
#define __MUTEX_H

#include "eOrb/EORB/Mutex.h"  // EORB Mutex

class Mutex
{
	public :
		inline Mutex();
		inline ~Mutex();
		inline void enterMutex();
		inline void leaveMutex();

	protected :
		EORB::Mutex mutex_;
};

inline Mutex::Mutex()
{
}

inline Mutex::~Mutex()
{
}

inline void Mutex::enterMutex()
{
	mutex_.lock();
}

inline void Mutex::leaveMutex()
{
	mutex_.unlock();
}

class MutexLock
{
	public :
		inline MutexLock(Mutex&);
		inline ~MutexLock();

	protected :
		Mutex& mutex_;

};

inline MutexLock::MutexLock(Mutex& mutex) : mutex_(mutex)
{
	mutex_.enterMutex();
}

inline MutexLock::~MutexLock()
{
	mutex_.leaveMutex();
}

#endif     // __MUTEX_H

// End-Of-File
//------------------------------------------------------------------------------
