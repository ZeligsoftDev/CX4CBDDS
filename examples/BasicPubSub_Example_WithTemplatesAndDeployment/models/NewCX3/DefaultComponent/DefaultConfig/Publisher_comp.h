/*********************************************************************
	Rhapsody	: 8.0.5 
	Login		: Paul Elder
	Component	: DefaultComponent 
	Configuration 	: DefaultConfig
	Model Element	: Publisher_comp
//!	Generated Date	: Fri, 18, Jul 2014  
	File Path	: DefaultComponent\DefaultConfig\Publisher_comp.h
*********************************************************************/

#ifndef Publisher_comp_H
#define Publisher_comp_H

//## auto_generated
#include <oxf\oxf.h>
//## package Examples::Publisher_comp


//## type IMData_conn
struct IMData_conn {
    CORBAString fromUserId;		//## attribute fromUserId
    CORBAString toUserId;		//## attribute toUserId
    CORBAString message;		//## attribute message
};

//## type IMData_connSeq
typedef  IMData_connSeq;

//## package Examples::Publisher_comp

//## class Publisher_comp
class Publisher_comp {
    ////    Constructors and destructors    ////
    
public :

    //## auto_generated
    Publisher_comp();
    
    //## auto_generated
    ~Publisher_comp();
};

#endif
/*********************************************************************
	File Path	: DefaultComponent\DefaultConfig\Publisher_comp.h
*********************************************************************/
