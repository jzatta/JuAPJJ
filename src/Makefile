
OBJ=$(subst .java,.class,$(shell find *.java))

JC=javac
JAVA=java

all: $(OBJ)

runJulianoTester: JulianoTester.class
	$(JAVA) JulianoTester

%.class: %.java
	$(JC) $<

clean:
	rm -rf Classes