#!/bin/bash
app='sentinel-dashboard.jar'
args='-Xms300m -Xmx300m'
cmd=$1
pid=`ps -ef|grep java|grep $app|awk '{print $2}'`

startup(){
  nohup java $args -jar $app >> logs/start.out 2>&1 &
}

if [ ! $cmd ]; then
  echo "Please specify args 'start|restart|stop'"
  exit
fi

if [ $cmd == 'start' ]; then
  if [ ! $pid ]; then
    startup
  else
    echo "$app is running! pid=$pid"
  fi
fi

if [ $cmd == 'restart' ]; then
  if [ $pid ]
    then
      echo "$pid will be killed after 3 seconds!"
      sleep 3
      kill -9 $pid
  fi
  startup
fi

# 停止
if [ $cmd == 'stop' ]; then
  if [ $pid ]; then
    echo "$pid will be killed after 3 seconds!"
    sleep 3
    kill -9 $pid
  fi
  echo "$app is stopped"
fi