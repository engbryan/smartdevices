#!/bin/bash

if ! test -f jdk-17.0.2/bin/java; then

	echo "download jdk ..."

	JDK_URL="https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_linux-x64_bin.tar.gz -O openjdk-17-linux.tar.gz"

	FILE="openjdk-17-linux.tar.gz"

	wget $JDK_URL -O $FILE

	if [ "$?" != "0" ]; then

		curl $JDK_URL -o $FILE
	fi

	tar xzf openjdk-17-linux.tar.gz
fi

export JAVA_HOME="$PWD/jdk-17.0.2"
