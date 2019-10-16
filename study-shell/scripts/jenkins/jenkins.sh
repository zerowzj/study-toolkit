#!/bin/sh
# chkconfig: 2345 90 10
# description: Jenkins server

JEKINS_DIR=/server/jenkins
JEKINS_WAR=$JEKINS_DIR/jenkins.war
LOG_FILE=$JEKINS_DIR/logs/stdout.log

PID=`ps -ef |grep $JEKINS_WAR |grep -v grep |awk '{print $2}'`

case "$1" in
    start)
      if [ -z "$PID" ]
      then
          echo "Starting Jenkins..."
          nohup java -jar $JEKINS_WAR > $LOG_FILE 2>&1 &
      else
          echo "$PID exists, process is already running or crashed"
      fi
    ;;
    stop)
      if [ -n "$PID" ]
      then
          echo "Stop Jenkins..."
          kill -9 $PID
      fi
      echo "Jenkins stopped"
    ;;
esac