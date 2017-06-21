# hands

This is a **Java** exercice about finding the correct pker Hands in 5 cards.

## The package contains :

* Some starting code describing domain objects
* Some Interfaces explaining what business code should do
  - mostly about organizing and sorting hands
* All the needed Unit test 

So the trainee must read the unit tests, and implement the business code so that the test passes. 
It's designed for Java beginners, so there are a lot of small steps and it's well guided

## Card colors

* **s** for spade: ♠️
* **d** for diamond: ♦️
* **h** for heart: ♥️
* **c** for club: ♣️

**Ah** is the Ace of Heart


## Where to start ?

You must pass the tests in that exact order:

* DeckGeneratotTest
* DeckTest
* HandTest

## The map

The `group()` map will allow to build a nice map for your algorithm.

Let's say you have: **2c 4s 4h Ah Ad**

| Key  | Value         |
| ---- | ------------- |
| 2    | [ **2c**]     |
| 4    | [ **4s, 4h**] |
| 14   | [ **Ah, Ad**] |

Remember that this is a TreeMap, keys are ordered.
So you have `map.size() == 3`. It proves that your hand is either a Double Pair or a Trips


Let's say you have: **2c 4s 4h 4d Ad**

| Key  | Value         |
| ---- | ------------- |
| 2    | [ **2c**]     |
| 4    | [ **4s, 4h, 4d**] |
| 14   | [ **Ad**] |

You also have `map.size() == 3`.

So your algorithm must find difference between Double Pair and Trips. The `Hand` class has a `number(cardValue)` method for this.

If you have `map.size()==3 && hand.number(map.keySet().first()) ==3 ` then you have a trips.







