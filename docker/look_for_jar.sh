#!/bin/sh

export LOOK_FOR=$1

for i in `find . -name "*.jar" `
do
  jar tvf $i | grep -r $LOOK_FOR 
  if [ $? -eq 0 ] 
	then echo "$i" 
  fi

done
