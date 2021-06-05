CC= javac
RR= java
RM= rm
JFLAG= -sourcepath src -d cls
CFLAG= -classpath cls

build:
	@$(CC) $(JFLAG) src/ElasticSet.java
	@echo building ElasticSet.java
	@$(CC) $(JFLAG) src/MyElasticSet.java
	@echo building MyElasticSet.java
	@$(CC) $(JFLAG) src/EmptyCollectionException.java
	@echo building EmptyCollectionException.java
	@$(CC) $(JFLAG) src/TestSet1.java
	@echo building TestSet1.java
	@$(CC) $(JFLAG) src/TestSet2.java
	@echo building TestSet2.java
	@echo build completed successfully!
test1:
	@echo running TestSet1...
	@$(RR) $(CFLAG) TestSet1
test2:
	@echo running TestSet2...
	@$(RR) $(CFLAG) TestSet2
run: 
	@echo running TestSet1...
	@$(RR) $(CFLAG) TestSet1
	@echo running TestSet2...
	@$(RR) $(CFLAG) TestSet2

buildandrun:
	make build
	make run

clean:
	@$(RM) cls/*.class
	@echo now everything is clean!