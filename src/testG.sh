#! /bin/sh

javac Compiler.java

for file in $(ls ~/IdeaProjects/2022-compilation-zidani-riazi/test/input/*.l)
#for file in $(ls ~/IdeaProjects/2022-compilation-zidani-riazi/testTS/input/*.l)
#file=~/IdeaProjects/2022-compilation-zidani-riazi/test/input/affect3.l
#file=~/IdeaProjects/2022-compilation-zidani-riazi/test/input/si5.l
do
  echo $file
  java Compiler $file -v 2
done
