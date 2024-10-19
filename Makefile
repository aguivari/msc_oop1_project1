JAVAFXDIR=~/MSC/Java/javafx/javafx-sdk-21.0.2/lib
JAVAFXOPT=javafx.controls,javafx.fxml
JFLAGS = --module-path $(JAVAFXDIR) --add-modules $(JAVAFXOPT)
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Person.java\
	Patient.java\
	Consultant.java\
	Utils.java\
	PatientTesterCLI.java\
	PatientTesterGUI.java

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class 

distclean: clean
	$(RM) *.zip

default: classes

all: clean classes

dist: clean
	zip msc_oop1_project1 *
