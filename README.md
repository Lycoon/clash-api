![ClashAPI logo](/src/main/resources/logo.png)

ClashAPI is a very simple yet very complete Java wrapper for the Clash of Clans mobile game API. It allows developers to easily do requests to the game API without bothering about JSON and HTTP handling.

## How does it work?
I analyzed JSON responses from the Clash of Clans API to recreate the models as Java structures so you don't have to deal with deserialization and data categorization each time. You can therefore simply access game data through classes and methods, all documented!

## How to use it?
```java
// 1. Create an instance of ClashAPI by providing your Clash of Clans API token to the constructor
ClashAPI clashAPI = new ClashAPI("token");

// 2. And do the requests you need. Yes, it's as simple :)
Player player = clashAPI.getPlayer("#AAAA00");

int townhallLevel = player.getTownHallLevel();
String clanRole = player.getRole();
List<Troop> heroes = player.getHeroes();
...
```

## What's the token?
In order to make calls to the Clash of Clans API, Supercell (developer of the game) asks you to sign up on [this website](https://developer.clashofclans.com/#/register). Then, head to your [profile](https://developer.clashofclans.com/#/account) and create a new key. Once you are done, the key will generate the token. Copy it and provide it to the `ClashAPI` constructor.

Though this token is linked to the IP address you gave, I would advise **not to hardcode it** inside your code, for safety sake. Paste it in a separate file that you would access from your code. It will prevent your token being spread if you ever share your files.

## Dependencies
* GSON `2.8.8`
* OkHttp `4.9.2`

## Disclaimer
*This material is unofficial and is not endorsed by Supercell. For more information see Supercell's Fan Content Policy: www.supercell.com/fan-content-policy.*
