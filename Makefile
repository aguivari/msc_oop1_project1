JC = javac
JAVA_RUNTIME = java
JFLAGS =

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

SRC=.

APP_NAME=HealthCollector

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

CLASSES_APPS=$(APP_NAME).java
			
CLASSES=$(CLASSES_ENUM) \
		$(CLASSES_RECORDS) \
		$(CLASSES_BASE) \
		$(CLASSES_AUX) \
		$(CLASSES_INTERFACES) \
		$(CLASSES_APPS)
		
classes: $(CLASSES:.java=.class)

clean:
	$(RM) -R */*.class *.class

dataclean: 
	$(RM) files/*.bin

distclean: clean dataclean
	$(RM) *.zip

default: classes

all: clean classes

PROJECTFILES= $(CLASSES) Makefile README.md

dist: clean
	zip msc_oop1_1 $(PROJECTFILES)

run_pt:
	$(JAVA_RUNTIME) -Duser.language=pt -Duser.region=BR $(APP_NAME)

run:
	$(JAVA_RUNTIME) $(APP_NAME)