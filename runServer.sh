#!/bin/bash
mvn compile exec:java -Dexec.mainClass="org.simoes.lpd.Main"
#mvn compile exec:java -Dexec.mainClass="open.lpd.server.impl.LpdServer" -Dexec.args="--host 0.0.0.0 --port 515 --script 'echo 1=$1 2=$2'"
