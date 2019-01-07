#!/bin/sh

if [ -n $BUILD_INITIALIZED ]
then
	source commonVariations.shsource
	source commonComputedVariables.shsource
fi

export JAVA_HOME=${JAVA_5_HOME}

ANT_CMD=${ANT_HOME}/bin/ant

exec "$ANT_CMD" "$@"
