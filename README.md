About

This development was designed to be used on a plug-in strategy. Suppliers are able to use the core package to branch the inheritance contained on it and build their own device's "drivers" for our Smart-iX platform.

These developments are made without departing from quarkus-principle need. Which simplifies the process for acquiring new drivers that enriches the platform's market omnipresence.

Smart features are also designed to be added on any device, following a need that the caller would be ignoring what the feature does. Taking as example Alexa, she would simply added a knowledge which that device has a feature identified as XX that does what xx2 voice command command does.

Features are designed to be reused across multiple devices. I.e, PlaySound abstract feature turns on a device either physical or virtual - given the virtual device adds this feature on its feature list and implements an interface "SoundPlayer", which this feature requires the device to be.

Any device can invoke features without needing to be specific about that feature does, because features are designed to be generic across any function and any device that implements the type need for it. The module which would be performing that generic learning action was not written for brevity of this exam task.

Devices can be either physical or virtual. Physical devices contains hardware version, firmware version, and maker. Virtual devices contains version and name. Virtual devices can be used as servers, persistent storage, smart services, and others.

Features can be either commands or services.
Commands are designed to be fired and forgot, and their return types will always be a bollean representing it was or not placed in action. Given their are asynchronous, a ticket number will be created for future reference about its processing statuses.
Services will always return a data type given it can be a result of an internet call containing a dataset.

On this implementation, callers who calls commands should always be poling their ticket's statuses to the called devices. Which is not a good practice given we are using grpc to improve this pooling need to an event-based implementation. That was also omitted for brevity of this exam task.

Quarkus is challenging for first-time users once it revolutionise the way java web is offered. And I fought for its usage to be improved in a scalable and rapid-delivery, and future-readiness capable. Performance being the paramount on this task.

SOLID was using as pattern. And Java was used 12 years ago before this task; Mistakes can be explicitly stated and better approaches can be possible to be achieved.


Instructions

## Smart Devices
Implementations of smart models and smart features with stacks java, quarkus, grpc and kubernetes

### Modules

#### 1. smart-model
Java classes to generate protobuf specifications

#### 2. fluorecent10w-lamp
Java project with quarkus and grpc for simulation of a binary-state smart lamp (on, off)

#### 3. openweather-device
Java project with quarkus and grpc for implementation of a smart service containing openweather consumer API

#### 4. simulator-device
Java project for test implementations grpc smart services

Test

```shell
$ ./lamp_test.sh

$ ./weather_test.sh
```

### Build all moudules

```shell
$ ./build.sh
```

### Minikube deploy pods

```shell
$ ./minikube_deploy.sh
```

