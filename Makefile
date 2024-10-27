#set Java FX location below
JAVAFXDIR=~/MSC/Java/javafx/javafx-sdk-21.0.2/lib
JAVAFXOPT=javafx.controls,javafx.fxml
JFXFLAGS = --module-path $(JAVAFXDIR) --add-modules $(JAVAFXOPT)
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

SRC=.

DIR_AUX=$(SRC)/AuxClasses
CLASSES_AUX=$(DIR_AUX)/Utils.java \
			$(DIR_AUX)/Date.java 

DIR_BASE=$(SRC)/BaseClasses
CLASSES_BASE=$(DIR_BASE)/Person.java \
			$(DIR_BASE)/Patient.java \
			$(DIR_BASE)/Consultant.java \


DIR_ENUM=$(SRC)/Enums
CLASSES_ENUM=$(DIR_ENUM)/ContractType.java \
			$(DIR_ENUM)/DateFormat.java \
			$(DIR_ENUM)/Gender.java \
			$(DIR_ENUM)/Speciality.java

DIR_INTERFACES=$(SRC)/Interfaces
CLASSES_INTERFACES=$(DIR_INTERFACES)/ConsultantAPIDefinitions.java \
	$(DIR_INTERFACES)/ConsultantAPI.java \
	$(DIR_INTERFACES)/PatientAPIDefinitions.java \
	$(DIR_INTERFACES)/PatientAPI.java \
	$(DIR_INTERFACES)/MeasurementAPI.java \
	$(DIR_INTERFACES)/MeasurementAPIDefinitions.java

DIR_RECORDS=$(SRC)/Records
CLASSES_RECORDS=$(DIR_RECORDS)/Measurement.java

DIR_APPS=$(SRC)/TestApplications
CLASSES_APPS=HealthCollector.java \
			$(DIR_APPS)/PatientTesterCLI.java \
			$(DIR_APPS)/PatientTesterWrite.java \
			$(DIR_APPS)/PatientTesterRead.java \
			$(DIR_APPS)/ConsultantTesterWrite.java \
			$(DIR_APPS)/ConsultantTesterRead.java \
			$(DIR_APPS)/MeasurementsTesterWrite.java \
			$(DIR_APPS)/MeasurementsTesterRead.java
			

CLASSES_JAVAFX_APPS=$(DIR_APPS)/PatientTesterGUI.java

CLASSES = $(CLASSES_BASE) \
		$(CLASSES_AUX) \
		$(CLASSES_ENUM) \
		$(CLASSES_RECORDS) \
		$(CLASSES_INTERFACES) \
		$(CLASSES_APPS)
		

classes: $(CLASSES:.java=.class)

javafx: 
	$(JC) $(JFXFLAGS) $(CLASSES_JAVAFX_APPS)

clean:
	$(RM) -R */*.class *.class

distclean: clean
	$(RM) *.zip files/*.bin

default: classes

all: clean classes

PROJECTFILES= $(CLASSES) $(CLASSES_JAVAFX_APPS) \
	Makefile \
	README.md \

dist: clean
	zip msc_oop1_1 $(PROJECTFILES)
