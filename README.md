API Chess Game
=================
API Chess Game is an API server that manages a chess game. You can play 2 players alternating.

### Assumptions
- The game start when you call first the ``/start`` endpoint.
- The active player will send in a payload the initial and final position of the move.
- The game will be ended when one of the players return the status ``BLACK_WIN, WHITE_WIN, FORFEIT, STALEMATE``
- Postman file with sample requests  on  ``/swagger/ChessGame.postman_collection.json``
### Requirements
* Java 17 JRE 
* Gradle 2.2

###  Build the project:
``./gradle build``

### Run the tests:
``./gradle test``

Access to the tests report in the folder: ``../build/reports/tests/test/index.html``
### Entry Points

| URI    | Methode | Usage          
|--------|---------|----------------|
| /start | GET     | Statr the game |
| /play  | POST    | Make a move    |


```javascript
{
    "player":{
        "whiteSide":"true"
    },
    "start":{
        "x":0, 
            "y":1
    },
    "end":{
        "x":0,
            "y":2
    }
}
```
