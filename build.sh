#!/bin/bash

# Define variables for paths
PACKAGE="caju"
SRC_DIR="src"
TARGET_DIR="target"
LEXER_DAT="$PACKAGE/lexer/lexer.dat"

# Compile SableCC grammar files
java -jar sablecc.jar ${SRC_DIR}/*.sable
if [ $? -ne 0 ]; then
  echo "Error: SableCC compilation failed."
  exit 1
fi

# Find and compile all Java files
javac $(find ${SRC_DIR}/ -name '*.java') -d ${TARGET_DIR}
if [ $? -ne 0 ]; then
  echo "Error: Java compilation failed."
  exit 1
fi

# Copy lexer.dat file to the target directory
cp ${SRC_DIR}/${LEXER_DAT} ${TARGET_DIR}/${LEXER_DAT}
if [ $? -ne 0 ]; then
  echo "Error: Failed to copy lexer.dat."
  exit 1
fi

# Uncomment for running.
#java -cp ${TARGET_DIR} $PACKAGE.Main
#if [ $? -ne 0 ]; then
#  echo "Error: Failed to run the main class."
#  exit 1
#fi
