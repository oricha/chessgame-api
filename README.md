API Chessgame
=================

Requirements
---------------
* Java 17 JRE 


Build the project:
---------------
``./gradlew build``


### Entry Points

| URI               | Methode | Usage                        
|-------------------|---------|------------------------------|
| /api              | GET     | Root path for the rest API   |
| /api/start        | GET     | Statr theg ame               |
| /api/players      | POST    | Create a player              |
| /api/players/{id} | GET     | Get a single player          |
| /api/draws/{id}   | GET     | Get a single draw            |


```javascript
{"player":{"whiteSide":"true","humanPlayer":"true"},
    "start":{"piece":{"killed":"false", "white":"false"},"x":0,"y":0},
    "end":{"piece":{"killed":"false", "white":"false"},"x":0,"y":0}
}
```
