# Building This Project

This project requires Kotlin and JDK 1.8 installed on the machine.

To build the project, just compile the interview-submission.kt by running
kotlinc interview-submission.kt -include-runtime -d name_this_whatever.jar in the terminal
or by using whatever your preferred method of compiling a Kotlin file is

# Running This Project

After compiling the program, run the program running java -jar name_this_whatever.jar
in the terminal

From there, follow the instructions printed to standard output.

# Intellij IDEA

This project can also be imported into the Intellij IDEA IDE and built/run through there.

If for some reason the project does not open correctly and no configurations are set to run/build the project,
you have to first click file -> project structure. Under "Project" set the sdk to Java JDK 1.8,
and set Project Compiler Output to the "out" directory. If the "out" directory does not exist,
create it inside the project directory. After that step is complete, click module and check if the 
src directory is listed as a "Source Folder". If it is not, click on src in the window and then click 
"Mark as Source". From there, Intellij should start the kotlin configuration process and 
you should be able to run the program after the configuration is complete. A noted bug I've found 
is that sometimes after completing this process "Run" has to be clicked twice for the program to run
correctly.

# Information on compiling Kotlin

More information about compiling and running a Kotlin file using the terminal can
be found here https://kotlinlang.org/docs/tutorials/command-line.html