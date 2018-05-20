#!/bin/sh

if [ -z "$2" ]
then
  echo Usage: $0 Directory ClassName
  exit 1
fi

for f in $(find $1 -name '*.jar')
do
  jar tf $f | grep "$2" && echo "[in $f]" && file-roller $f
done
