#!/bin/bash

find src -name "*.java" > sources.txt
rm -rf bin && mkdir -p bin
javac -d bin @sources.txt
java -cp bin pucrs.myflight.consoleApp.App