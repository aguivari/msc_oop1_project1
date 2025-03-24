# Repository for Java application for Class Project - OOP2

## Course: [MSc in Software Design With Artificial Intelligence](https://tus.ie/courses/msc-in-software-design-with-artificial-intelligence/)
## personal github: [aguivari/msc_oop1_project1](https://github.com/aguivari/msc_oop1_project1)
## TUS github Mirror: [tussoftwaredesign/ca-aguivari](https://github.com/tussoftwaredesign/ca-aguivari/)

The OOP2 Project is being presented as an extension for the OOP1 project, with a separate branch for this.

Branch name for OOP2 extension is called "oop2_project"

## Application: Simple Health Collector Application for Basic Biomedical information

## Project File & Directory Structure:
```
+Project
+--AuxClasses/          ->> Auxiliary Classes used by the applications
+--BaseClasses/         ->> Base Classes used by the applications
+--Enums/               ->> Base Eunumerations used by the applications
+--Interfaces/          ->> Interfaces used by the applications
+--Records/             ->> Records used by the applications
+--files/               ->> binary files used to testing objects read & write to/from disk
+--HealthCollector.java ->> Main application
+--Makefile             ->> Makefile for easy handling of compilation & clean up
+--mirrorgit.sh         ->> script to mirror personal & TUS git repos
\--README.md            ->> This file
```

#### This project will me regularly mirrored between this personal GIT repo and the repo provided by TUS

## Included programs

### HealthCollector (CLI)

Includes a command line / text program to use the main interfaces
with basic operations like adding patients, consultants and measumenres
and some database operations, like save, restore, etc.

To run on computer's default Locale, use _make run_

To run in Brazilian Portuguese Locale, use _make run_pt_

## Project Requirements from Assignment

### Fundamentals:
- lambdas: for example: Consumer, Predicate, Supplier, Function etc.. ❌
- streams ❌
    - terminal operations
        - min(), max(), count(), findAny(), findFirst(), allMatch(), anyMatch(), noneMatch(), forEach()
        - collect() - Collectors.toMap(), Collectors.groupingBy() and Collectors.partitioningBy()
    - intermediate operations e.g. filter(), distinct(), limit(), map() and sorted()
- switch expressions and pattern matching ❌
- sealed classes and interfaces ✅
- Date/Time API ❌
- records ✅

### Advanced:
- collections/generics - for example: use of Comparator.comparing() for sorting ❌
- concurrency e.g. using ExecutorService to process a list of Callable’s ❌
- NIO2 ❌
- Localisation ❌

### Extra marks:
- any topics from Java 22 and/or 23 - be sure to clearly explain these topics and what you had to do to get the newer code to compile/run ❌
    - specifically, only unnamed variables and patterns required here (permanent in Java 22).  ❌
        - https://docs.oracle.com/en/java/javase/22/language/unnamed-variables-and-patterns.html#GUID-D54E1CF1-BDFD-4B57-8A6E-5B4C87F4D58A ❌
