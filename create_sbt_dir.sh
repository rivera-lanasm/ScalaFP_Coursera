#!/bin/sh
mkdir -p src/main/java
mkdir src/main/resources
mkdir src/main/scala

mkdir -p src/test/java
mkdir src/test/resources
mkdir src/test/scala

mkdir lib project target

# create an initial build.sbt file
echo 'name := "MyProject"
version := "1.0"
scalaVersion := "2.12.10"' > build.sbt