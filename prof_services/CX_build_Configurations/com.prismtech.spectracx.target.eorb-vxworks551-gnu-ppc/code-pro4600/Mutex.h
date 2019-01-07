#ifndef __MUTEX_H
#define __MUTEX_H

#include "eOrbC/os/posix/pthread.h"

class Mutex {
public:
	inline Mutex();
	inline ~Mutex();
	inline void enterMutex();
	inline void leaveMutex();

protected:
	pthread_mutex_t mutex_;
};

class MutexLock {
public:
	inline MutexLock(Mutex&);
	inline ~MutexLock();
protected:
	Mutex& mutex_;
};

inline Mutex::Mutex() {
	pthread_mutex_init(&mutex_, (pthread_mutexattr_t *) 0);
}

inline Mutex::~Mutex() {
	pthread_mutex_destroy(&mutex_);
}

inline void Mutex::enterMutex() {
	pthread_mutex_lock(&mutex_);
}

inline void Mutex::leaveMutex() {
	pthread_mutex_unlock(&mutex_);
}

inline MutexLock::MutexLock(Mutex& mutex) :
	mutex_(mutex) {
	mutex_.enterMutex();
}

inline MutexLock::~MutexLock() {
	mutex_.leaveMutex();
}

#endif     // __MUTEX_H
// End-Of-File
//------------------------------------------------------------------------------

