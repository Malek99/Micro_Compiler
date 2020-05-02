This project is about making a compiler for a simple educational programming language called “Micro”, using ANTLR parser generator. 

It takes a .micro file as an input, which is the source code file in Micro language, then, it applies the first five steps of the compilation process to produce a two-address code of an assembly language called “Tiny”.

The Micro language’s grammar are specified in the file “Micro.g4” as understood by ANTLR. To run the compiler you should first have GNU make and Java SDK installed, then you can execute these commands:

    make
    java -cp ./bin/:antlr-4.8-complete.jar Main <the .micro file>
