#!/bin/bash
#Find the newest jar:
jar=$(ls -t dist/lib/*.jar |grep -v "src.jar" | head -n 1)
echo "$jar"
java -classpath "./lib/log4j-1.2.8.jar;${jar}" org.simoes.lpd.Main
