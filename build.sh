#!/bin/bash

# Define variables for paths
PACKAGE="caju"
SRC_DIR="src"
TARGET_DIR="target"
LEXER_DAT="$PACKAGE/lexer/lexer.dat"

# Cleanup previous builds.
rm -rf ${SRC_DIR}/${PACKAGE}/{analysis,lexer,node,parser} $TARGET_DIR

# Build target.
java -jar sablecc.jar ${SRC_DIR}/*.sable &&
  javac $(find ${SRC_DIR}/ -name '*.java') -d ${TARGET_DIR} &&
  cp ${SRC_DIR}/${LEXER_DAT} ${TARGET_DIR}/${LEXER_DAT}

# Uncomment for running.
#java -cp ${TARGET_DIR} $PACKAGE.Main
