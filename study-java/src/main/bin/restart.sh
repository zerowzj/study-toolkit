#!/bin/bash
get_pid(){
    pid=`ps -ef |grep teacher-web/ |grep -v grep |awk '{print $2}'`
    echo "$pid"
}

start(){
    echo `pwd`
    sh startup.sh
    pid=`get_pid`
    echo "STARTED PID: $pid"
}

pid=`get_pid`
if [ -z "$pid" ]; then
    start;
else
    kill -9 $pid
	if [ $? -eq 0 ]; then
		echo "STOPPED PID: $pid"
		sleep 1;
		start;
    else
        echo "ERROR: Stop fail!"
        exit 1
    fi
fi

