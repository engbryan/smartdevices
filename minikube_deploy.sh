#!/bin/bash

#Start minikube cluster if not exists
docker ps | grep -q minikube || minikube start

#Set minikube enviroment vars
eval $(minikube -p minikube docker-env)

killall kubectl

#Find kubernetes specs
for APP in $(find . -name kubernetes.yml | cut -d"/" -f2); do

	cd $APP
	
	minikube kubectl -- delete -f target/kubernetes/kubernetes.yml 2> /dev/null
	
	minikube kubectl -- apply -f target/kubernetes/kubernetes.yml

	sleep 5

	minikube kubectl -- get pods | grep $APP | grep Running

	while [ "$?" != "0" ] 
	do
		minikube kubectl -- get pods | grep $APP | grep Running

		sleep 5
	done

	PORT=$(grep kubernetes.port-forward src/main/resources/application.properties | cut -d"=" -f2)

	minikube kubectl -- port-forward service/$APP $PORT:9000 &

	cd ..
done 

minikube kubectl -- get pods

