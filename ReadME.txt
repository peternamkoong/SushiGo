Sushi Go!
This project is for the class CPSC 233 Winter 2018 at the University of Calgary. This is specific to Winter 2018 Lecture 2 taught by Sohaib Bajwa.
Sushi Go! is a card game that involves creating card combinations based on hands and hands are switched each turn.

Getting Started
To get started you will need to download the game.zip file and extract the files into a folder. You will need to open up an IDE for java and 
make that folder the source folder. You will then go into the GUI.java file and run that file. The game will then begin.

Prerequisites
To play this game you'll need an OS that has Java installed along with its default packages. You will need an extractor that can extract zip files
and an IDE that can run java files.

Installing
Given that you have an OS that can run Java, you can download the lates Java version here:
https://java.com/en/download/

You can download the Eclipse IDE here:
https://www.eclipse.org/downloads/download.php?file=/oomph/epp/oxygen/R2/eclipse-inst-win64.exe

Once these two are downloaded, install them on your computer.
Open Eclipse and hit File > New > Java Project
Set the Project name to SushiGO and change the location to the folder that contains all the files from the zip file
Then open the GUI.java in eclipse and run either from the MainScreen.java or Start.java to start the GUI version and 
text-based version respectively.

TESTING
In regards to testing, we focused on testing our FinalScore.java file to make sure that the scoring was done correctly.
Seeing as the whole point of the game is to win by having the highest points, that was the most important class to test.

For our tests we created boards for our humans using a combination of all our types of cards and calculate the score manually and test it against our scoring method. We have a test for each of our 9 cards.

For example, in our Pudding test. We create two new Humans and add Puddings into their respective board. We add one for player1 and 0 for player2. According to the rules of the game, if you have less pudding then the other player. You get deducted 6 points.

Contributing
//We would like to thank the country of Japan for creating Sushi.

Versioning
// This version is currently Final Project Version for CPSC 233.

Authors
Daniel Tiu
Peter Namkoong
Scott Holden

License
//This is purely a school project, so we did not look for any licensing. We do not claim that the game Sushi GO! was created by us,
we merely emulated it as a test of our skill.

Acknowledgments
Hat's off to the game Sushi Go! for making a game fun enough to emulate so we can play anywhere, anytime, without cards!