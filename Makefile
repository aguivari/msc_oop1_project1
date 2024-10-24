JAVAFXDIR=~/MSC/Java/javafx/javafx-sdk-21.0.2/lib
JAVAFXOPT=javafx.controls,javafx.fxml
JFLAGS = --module-path $(JAVAFXDIR) --add-modules $(JAVAFXOPT)
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

SRC=.

DIR_AUX=$(SRC)/AuxClasses
CLASSES_AUX=$(DIR_AUX)/Utils.java

DIR_BASE=$(SRC)/BaseClasses
CLASSES_BASE=$(DIR_BASE)/Person.java \
			$(DIR_BASE)/Patient.java \
			$(DIR_BASE)/Consultant.java \
			$(DIR_BASE)/Person.java \
			$(DIR_BASE)/Date.java 			

DIR_ENUM=$(SRC)/Enums
CLASSES_ENUM=$(DIR_ENUM)/ContractType.java \
			$(DIR_ENUM)/DateFormat.java \
			$(DIR_ENUM)/Gender.java \
			$(DIR_ENUM)/Speciality.java

DIR_INTERFACES=$(SRC)/Interfaces
CLASSES_INTERFACES=$(DIR_INTERFACES)/ConsultantInterface.java \
	$(DIR_INTERFACES)/ConsultantInterfaceImpl.java \
	$(DIR_INTERFACES)/PatientInterface.java \
	$(DIR_INTERFACES)/PatientInterfaceImpl.java \
	$(DIR_INTERFACES)/MeasurementsInterface.java \
	$(DIR_INTERFACES)/MeasurementsInterfaceImpl.java

DIR_RECORDS=$(SRC)/Records
CLASSES_RECORDS=$(DIR_RECORDS)/Measurement.java

DIR_APPS=$(SRC)/TestApplications
CLASSES_APPS=HealthCollector.java \
			$(DIR_APPS)/PatientTesterCLI.java \
			$(DIR_APPS)/PatientTesterWrite.java \
			$(DIR_APPS)/PatientTesterRead.java 
			

CLASSES_JAVAFX_APPS=$(DIR_APPS)/PatientTesterGUI.java

CLASSES = $(CLASSES_BASE) \
		$(CLASSES_AUX) \
		$(CLASSES_ENUM) \
		$(CLASSES_APPS) \
		$(CLASSES_INTERFACES) \
		$(CLASSES_RECORDS)

classes: $(CLASSES:.java=.class)

javafx: $(CLASSES_JAVAFX_APPS:.java=.class)

clean:
	$(RM) -R */*.class *.class

distclean: clean
	$(RM) *.zip files/*.bin

default: classes

all: clean classes

PROJECTFILES= $(CLASSES) \
	Makefile \
	README.md \

dist: clean
	zip msc_oop1_1 $(PROJECTFILES)
