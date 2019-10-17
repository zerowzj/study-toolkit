#!/bin/sh
# chkconfig: 2345 90 10
# description: Jenkins server

JENKINS_PORT=8080
JEKINS_DIR=/server/jenkins
JEKINS_WAR=$JEKINS_DIR/jenkins.war
LOG_FILE=$JEKINS_DIR/logs/jenkins.log
PID_FILE=/var/run/jenkins.pid

# jenkins工作目录，默认位于 /root/.jenkins
#export JENKINS_HOME=/server/jenkins/

PID=`ps -ef |grep $JEKINS_WAR |grep -v grep |awk '{print $2}'`

case "$1" in
    start)
      if [ -z "$PID" ]
      then
          echo "Starting Jenkins..."
          nohup java -jar $JEKINS_WAR --httpPort=$PORT > $LOG_FILE 2>&1 &
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