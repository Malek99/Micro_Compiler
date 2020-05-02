ANTLR_LIB=antlr-4.8-complete.jar
ANTLR_OPTIONS=-no-listener -visitor

class_files: antlr_files
	mkdir -p bin
	javac -cp .:$(ANTLR_LIB) src/*.java -d bin/

antlr_files:
	mkdir -p antlr_outputs
	java -jar $(ANTLR_LIB) $(ANTLR_OPTIONS) Micro.g4 -o antlr_outputs/
	cp antlr_outputs/*.java src/


clean:
	rm -rf bin/ antlr_outputs/ 
