#!/usr/bin/env bash

cd QA_App
echo "Running on port 8090"
sbt test
sbt "run 8090"

