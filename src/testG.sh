#! /bin/sh

javac Compiler.java

#for file in $(ls ~/IdeaProjects/2022-compilation-zidani-riazi/test/input/*.l)
#for file in $(ls ~/IdeaProjects/2022-compilation-zidani-riazi/testTS/input/*.l)
#file=~/IdeaProjects/2022-compilation-zidani-riazi/test/input/appel-param1.l
file=~/IdeaProjects/2022-compilation-zidani-riazi/test/input/affect2.l
#do
  echo $file
  java Compiler $file 
#done
filen=~/IdeaProjects/2022-compilation-zidani-riazi/test/input/affect2.nasm
nasm -f elf -dwarf -g $filen
fileo=~/IdeaProjects/2022-compilation-zidani-riazi/test/input/affect2.o
ld -m elf_i386 -o affect2 $fileo
