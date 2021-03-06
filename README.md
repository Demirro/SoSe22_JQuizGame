SoSe22_JQuizGame

#### 28.04.2022
##### English
This week we abstracted our code so that our answer checking logic is no longer hard-coded. For that we implemented a new abstract method *getCorrectAnswer* in Question.
Every question type now has to implement that method and we can count on it being implemented, when checking for answers.
Now we can start expanding the scope of our gameplay by implementing new question types like a single choice question, where the user has to choose between four answers, only one of which is correct.
There are multiple ways of implementing this. The solution in this repo is only one option

Extra:
This repo contains further abstraction of the input checking, which I implemented after our session on thursday. We will talk in detail about it next week.

##### Deutsch
Diese Woche haben wir unseren Code abstrahiert, so dass unsere Antwortprüfungslogik nicht mehr hart kodiert ist. Zu diesem Zweck haben wir eine neue abstrakte Methode *getCorrectAnswer* in Question implementiert.
Jeder Fragetyp muss nun diese Methode implementieren, und wir können uns darauf verlassen, dass sie bei der Prüfung der Antworten implementiert wird.
Jetzt können wir damit beginnen, den Umfang unseres Spiels zu erweitern, indem wir neue Fragetypen implementieren, z. B. eine Single-Choice-Frage, bei der der Benutzer zwischen vier Antworten wählen muss, von denen nur eine richtig ist.
Es gibt mehrere Möglichkeiten, dies zu implementieren. Die Lösung in diesem Repo ist nur eine Möglichkeit

Extra:
Dieses Repo enthält eine weitere Abstraktion der Eingabeprüfung, die ich nach unserer Sitzung am Donnerstag implementiert habe. Wir werden nächste Woche im Detail darüber sprechen.

#### 21.04.2022
##### English
The first (very) basic game logic is implemented. We now have a functioning game loop with two example questions, user input and reactions to this user input.
Winning and loosing is also already implemented. Everything is still to be seen as a prototype and will be further refined as we go.
We made the Question class abstract and thus started implementing the question types with inheritance.
For now we built the BoolQuestion class. It only contains the functionality for the answer (of type boolean). The rest of the question functionality is still in Question.

##### Deutsch
Die erste (sehr) grundlegende Spiellogik ist implementiert. Wir haben jetzt eine funktionierende Spielschleife mit zwei Beispielfragen, Benutzereingaben und Reaktionen auf diese Benutzereingaben.
Auch das Gewinnen und Verlieren ist bereits implementiert. Alles ist noch als Prototyp zu sehen und wird im Laufe der Entwicklung weiter verfeinert werden.
Wir haben die Klasse Question abstrakt gemacht und damit begonnen, die Fragetypen mit Vererbung zu implementieren.
Für den Moment haben wir die Klasse BoolQuestion gebaut. Sie enthält nur die Funktionalität für die Antwort (vom Typ boolean). Der Rest der Fragenfunktionalität befindet sich weiterhin in Question.

### English
With this game we start of our first major project in Java.
During the development we will implement most of the concept learned during both "Softwaretechnologie" courses.
Most of the development happens during our live class Thursdays at 10am.
This repository exists to track the changes and help those who are not attending to follow what happens.

The idea is to make a more or less modular Quiz Game in which new question types as well as catalogues of questions can be added after the development is finished.
At fist the application will work with a limited set of questions and in the CLI.
With time modularity in form of question files (JSONs) and a GUI will be added.

Look at the commits and comments to see what changed after each week and try to follow and program along.
If you want to add to the project or think of a better way to solve a problem or design the game, please be free to fork the project and do a pull request with your changes.

### Deutsch
Mit diesem Spiel startet unser erstes größeres Projekt in Java.
Während der Entwicklung werden wir die meisten der in den beiden "Softwaretechnologie"-Kursen erlernten Konzepte umsetzen.
Der Großteil der Entwicklung findet während unseres Live-Kurses donnerstags um 10 Uhr statt.
Dieses Repository dient dazu, die Änderungen zu verfolgen und denjenigen, die nicht anwesend sind, zu helfen, das Geschehen zu verfolgen.

Die Idee ist, ein mehr oder weniger modulares Quizspiel zu entwickeln, bei dem neue Fragetypen und Fragenkataloge nach Abschluss der Entwicklung hinzugefügt werden können.
Zu Beginn wird die Anwendung mit einer begrenzten Anzahl von Fragen und in der CLI funktionieren.
Mit der Zeit wird Modularität in Form von Fragendateien (JSONs) und zusätulich eine GUI hinzugefügt werden.

Schauen Sie sich die Commits und Kommentare an, um zu sehen, was sich nach jeder Woche geändert hat, und versucht, mitzukommen und mitzuprogrammieren.
Wenn Sie dem Projekt etwas hinzufügen wollen oder einen besseren Weg finden, ein Problem zu lösen oder das Spiel zu entwerfen, können Sie das Projekt gerne forken und einen Pull-Request mit Ihren Änderungen stellen.
