# jedit
An editor with text-to-speech and speech-to-text capabilities.

Build continuous integration
--------------------------------

[![Build Status](https://travis-ci.com/apugoneappu/jedit.svg?branch=greatest)](https://travis-ci.com/apugoneappu/jedit)

Usage instructions - 
----------------------------------
1) Change directory to the directory of the .java file which is to be run.
2) Change the parameters of the function `voce.SpeechInterface.init("path_to_lib_folder", false, true, "path_to_grammar_folder", "filename_of_digits file(without extension)");`
3) Change the parameters of the function `voce.SpeechInterface.init("path_to_lib_folder", true, false, "", "");`
4) To compile your code, use the following command pattern :
    javac -cp path_to_lib_folder/*:. classname.java
5) To run the code, use the following command:
    javac -cp path_to_lib_folder/*:. classname

Example :

1) cd ./samples/synthesisTest/java
2) javac -cp ../../../lib/*:. synthesisTest.java
3) java -cp ../../../lib/*:. synthesisTest

References - 
1) [Voce: Open source speech interaction](http://voce.sourceforge.net)

