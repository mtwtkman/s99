#! /bin/sh

name="s99"

case $1 in
  "build") docker build . -t $name;;
  "new") docker run -ti --rm -v `pwd`:/app $name sbt new sbt/scala-seed.g8;;
  "in") docker run -ti --rm --name $name -v `pwd`:/app -w="/app/s99/" $name sh;;
  "*") $1;;
esac
