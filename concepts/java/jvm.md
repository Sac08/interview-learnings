Core Components

JDK = JRE + Development Tools (javac, debugger, javadoc)

Responsibility: Complete development environment


JRE = JVM + Java Libraries

Responsibility: Runtime environment for executing Java programs


JVM = Runtime environment with JIT compiler

Responsibility: Execute bytecode, memory management, platform abstraction


JIT = Compiles frequently used bytecode to native machine code

Responsibility: Runtime optimization for performance



Code Execution Flow
.java → javac → .class (bytecode) → JVM → native machine code
Platform Independence

Bytecode is platform-neutral
Each OS has platform-specific JVM
JVM translates bytecode to machine code
"Write Once, Run Anywhere"

JIT Compilation

Monitors code execution frequency
Hot spots (frequently called code) compiled to native code
First executions: interpreted (slower)
After threshold: compiled (faster)

Java Memory Model
Heap Memory
Young Generation: Eden + Survivor Spaces (S0, S1)
Old Generation: Long-lived objects
Stack Memory

Per-thread storage
Local variables, method parameters, call frames

Method Area

Class metadata, static variables, constant pool

Garbage Collection
Responsibilities

Automatic memory management
Identify and remove unreachable objects
Prevent memory leaks
Optimize memory usage
Free up heap spac