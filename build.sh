#!/bin/bash

#Start minikube cluster if not exists
docker ps | grep -q minikube || minikube start

#Set minikube enviroment vars
eval $(minikube -p minikube docker-env)

. set_java_home.sh

#Build top level dependency
cd smart-model && ./mvnw clean install exec:java

#Fix java package option
echo 'option java_package = "org.acme.grpc";' >> target/classes/proto/dto.proto

cd ..

#Build device implementations
for APP in $(find . -name pom.xml | grep -Ev "model|feature" | cut -d "/" -f2); do

	#Build implementation
	cd $APP && ./mvnw clean package

	if [ "$?" != "0" ]; then
                exit
        fi

	IMAGE="smart-devices/$APP"

	#Build docker image for implementation
	docker build -f docker/Dockerfile.jvm -t $IMAGE .

	cd ..
done

echo "Build finished"

