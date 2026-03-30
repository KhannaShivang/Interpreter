# JAIL 🔒
### Just Another Interpreted Language
 
JAIL is a custom interpreted programming language built in Java. It features a clean, readable syntax with a tree-walk interpreter and supports everything you need to write real programs.
 
---
 
## 📋 Table of Contents
 
- [Overview](#overview)
- [Installation & Setup](#installation--setup)
- [Usage](#usage)
- [Syntax & Examples](#syntax--examples)
 
---
 
## Overview
 
JAIL is a dynamically-typed, interpreted language implemented from scratch in Java. It was built as a hands-on deep dive into language design and interpreter construction, following the Java implementation path from *Crafting Interpreters*.
 
**Key characteristics:**
- Dynamically typed
- Tree-walk interpreter
- Supports both script files and an interactive REPL
- Familiar C-style syntax that's easy to pick up
 
---
 
## Installation & Setup
 
### Prerequisites
 
- **Java 8+** — Make sure Java is installed and available on your PATH.
 
```bash
java -version
```
 
### Building from Source
 
1. Clone the repository:
 
```bash
git clone https://github.com/yourusername/jail.git
cd jail
```
 
2. Compile the source files:
 
```bash
javac -d out src/com/jail/*.java
```
 
3. (Optional) Package into a JAR:
 
```bash
jar cfm jail.jar manifest.txt -C out .
```
 
---
 
## Usage
 
### Run a JAIL script
 
```bash
java -jar jail.jar path/to/your/script.jail
```
 
### Start the interactive REPL
 
```bash
java -jar jail.jar
```
 
You'll see the JAIL prompt:
 
```
JAIL REPL — type 'exit' to quit
> 
```
 
---
 
## Syntax & Examples
 
### Hello, World!
 
```
print "Hello, World!";
```
 
---
 
### Variables & Types
 
JAIL supports numbers, strings, booleans, and nil.
 
```
var name = "JAIL";
var version = 1.0;
var isAwesome = true;
var nothing = nil;
 
print name;       // JAIL
print version;    // 1
print isAwesome;  // true
```
 
---
 
### Control Flow
 
**If / Else:**
 
```
var x = 10;
 
if (x > 5) {
    print "x is greater than 5";
} else {
    print "x is 5 or less";
}
```
 
**While loop:**
 
```
var i = 0;
while (i < 5) {
    print i;
    i = i + 1;
}
```
 
**For loop:**
 
```
for (var i = 0; i < 5; i = i + 1) {
    print i;
}
```
 
---
 
### Functions
 
```
fun greet(name) {
    print "Hello, " + name + "!";
}
 
greet("World");   // Hello, World!
```
 
Functions can return values:
 
```
fun add(a, b) {
    return a + b;
}
 
print add(3, 4);  // 7
```
 
---
 
### Error Handling
 
JAIL reports both compile-time and runtime errors with helpful messages:
 
```
// Runtime error example
var x = "hello" - 1;
// [line 1] Error: Operands must be numbers.
```
 
Undefined variable access:
 
```
print undeclared;
// [line 1] Error: Undefined variable 'undeclared'.
```
 
