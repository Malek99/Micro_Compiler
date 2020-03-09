class_files: antlr_files
	javac -cp .:/usr/local/lib/antlr-4.8-complete.jar src/*.java Test/*.java -d bin/

antlr_files:
	java -jar /usr/local/lib/antlr-4.8-complete.jar -no-listener Micro.g4 -o antlr_outputs/
	cp antlr_outputs/*.java src/


submission:
	zip step2.zip src/*.java README

clean:
	rm -f bin/*class antlr_outputs/* submission.zip

