ANTLR_LIB=/usr/local/lib/antlr-4.8-complete.jar
SUBMISSION_ARCHIVE=step4.zip
ANTLR_OPTIONS=-no-listener -visitor

class_files: antlr_files
	javac -cp .:$(ANTLR_LIB) src/*.java Test/*.java -d bin/

antlr_files:
	java -jar $(ANTLR_LIB) $(ANTLR_OPTIONS) Micro.g4 -o antlr_outputs/
	cp antlr_outputs/*.java src/


submission:
	zip $(SUBMISSION_ARCHIVE) src/*.java README

clean:
	rm -f bin/*class antlr_outputs/* $(SUBMISSION_ARCHIVE)
