JFLAGS = --module-path ~/MSC/Java/javafx/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Person.java\
	Patient.java\
	PatientTesterCLI.java\
	PatientTesterGUI.java

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

default: classes

all: clean classes
