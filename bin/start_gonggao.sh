#!/usr/bin/env bash

bin=`dirname "$0"`
bin=`cd "$bin"; pwd`

lib=$bin/../lib
classes=$bin/../classes
logs=$bin/../logs

if [[ ! -d $logs ]]; then
  echo "Log file does not exists, creating one..."
  mkdir $logs
fi

# HEAP_OPTS="-Xmx4096m -Xms2048m -XX:NewSize=1024m" # -d64 for 64-bit awesomeness
#HEAP_OPTS="-Xmx512m -Xms512m -XX:NewSize=256m"
HEAP_OPTS="-Xmx1024m -Xms1024m -XX:NewSize=128m"
# HEAP_OPTS="-Xmx512m -Xms256m -XX:NewSize=64m"
GC_OPTS="-verbosegc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -XX:+UseParNewGC"
#JAVA_DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,address=1044,server=y,suspend=y"
#GC_OPTS="-XX:+UseConcMarkSweepGC -XX:+UseParNewGC"
JAVA_OPTS="-server -d64"

MAIN_CLASS="com.tcredit.spiders.listpage.main.GonggaoMain"

CLASSPATH=$classes/:$lib/*

PIDFILE=$bin/../spider-gonggao.pid

if [ -f $PIDFILE ]; then
  echo "File $PIDFILE exists shutdown may not be proper"
  echo "Please check PID" `cat $PIDFILE`
  echo "Make sure the process is shutdown and the file" $PIDFILE "is removed before starting"
 else
  echo "File $PIDFILE does not exists"
  java $JAVA_OPTS $HEAP_OPTS $GC_OPTS -classpath $CLASSPATH  -Dlog.home=$logs $MAIN_CLASS $1 &
  echo $! > ${PIDFILE}
 fi
