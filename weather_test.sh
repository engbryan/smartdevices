#!/bin/bash

./set_java_home.sh

cd simulator-device 

$JAVA_HOME/bin/java -cp target/simulator-device-1.0.0.jar org.acme.WeatherClient
