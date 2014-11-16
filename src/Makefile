
CLASSES_DIR:=Classes
CROSS_TARGET_V=7
CROSS_SOURCE_V=7
OBJ:=$(subst .java,.class,$(shell find *.java))
OBJ:=$(addprefix $(CLASSES_DIR)/,$(OBJ))

JC=javac -d $(CLASSES_DIR) -source $(CROSS_SOURCE_V) -target $(CROSS_TARGET_V)
JAVA=java -cp $(CLASSES_DIR)

all: $(OBJ)

runJulianoTester: $(CLASSES_DIR)/JulianoTester.class
	$(JAVA) JulianoTester

$(CLASSES_DIR)/%.class: %.java Makefile
	$(JC) $<

$(OBJ): | $(CLASSES_DIR)

$(CLASSES_DIR):
	mkdir $(CLASSES_DIR)

clean:
	rm -rf $(CLASSES_DIR)
