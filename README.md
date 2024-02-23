# Einarmiger-Bandit---JavaFX

Add WalzeService class extending javafx.concurrent.Service
- Created a new class WalzeService extending javafx.concurrent.Service
- Implemented constructor to initialize bildAnzahl
- Implemented createTask() method to return a new instance of WalzeTask


Add WalzeTask class extending javafx.concurrent.Task
- Created a new class WalzeTask extending javafx.concurrent.Task
- Implemented constructor to initialize imageAnzahl and index
- Implemented call() method to perform random image changes and return the current index


Add BanditJavaFX class implementing a slot machine game
- Created BanditJavaFX class implementing a slot machine game using JavaFX
- Implemented start() method to initialize the GUI and handle mouse click events
- Implemented evaluation() method to check win or loss condition of the game


Add ImageBinding class for binding Image objects to Integer properties"
- Added ImageBinding class to bind Image objects to Integer properties in JavaFX applications
- Implemented computeValue() method to calculate the current Image based on the Integer property value
- Implemented getImage() method to retrieve the Image object for the specified index, considering the offset
