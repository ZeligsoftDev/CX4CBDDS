// Security Classification: Unclassified
//

Use of the DDS Publish-Subscribe Messaging API requires the creation of QoS
profiles. These settings may be specified in application code, but the easiest
way to specifiy them (and the way used in all of the provided example
components) is in a specially formatted XML file. When components using DDS
are launched, the DDS runtime will look for a file named either 
"USER_QOS_PROFILES.xml" or "NDDS_QOS_PROFILES.xml" in the current
directory, and will also load QoS profiles from the file(s) set as the 
"$NDDS_QOS_PROFILES" environment variable. Note that DDS will try and load 
QoS profiles from both sources, so in order to avoid conflicts both files
should not have QoS profiles with the same profile name.

The main distictions to focus on at the beginning of development will be:
network transmission vs. shared-memory-only, reliable messaging vs.
best-effort messaging, and optional support for SNA PSAT (publish-subscribe
attachment transfer). There are many more options configurable through DDS QoS
profiles; see chapter 15 of the RTI DDS manual for more details.

This folder contains example QoS profiles for developers to build from in
order to use DDS in a variety of situations. 

Examples: 

local_host_only - This profile is set up to enable DDS message passing only
over shared memory, i.e. when both the publisher and subscriber(s) are on the
same node. It uses the "best-effort" reliability setting, meaning that lost or
corrupted messages are discarded without being resent. (Over shared memory,
corrupted messages are typically quite rare). 

network_reliable - This profile is set up to enable DDS message passing over
the network interfaces eth0, eth1, ib0, and ib1: typically the names of the
first and second ethernet networking devices and the first and second
infiniband network devices, respectively. A reliable reliability setting is
used, which guarantees message transfer at the expense of increased message
latency, and a durability setting is enabled to allow late-joining components
to pick up messages sent before they deployed.

network_best_effort - This profile is set up to enable DDS message passing over
the network interfaces eth0, eth1, ib0, and ib1: typically the names of the
first and second ethernet networking devices and the first and second
infiniband network devices, respectively. Unlike the previous example, this
profile uses a "best-effort" reliability setting, so any corrupted messages
are transmitted corrupted, and any dropped messages are lost. However,
messages are sent with a much lower latency.