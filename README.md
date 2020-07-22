![ClashAPI logo](/src/main/resources/logo.png)

ClashAPI is a very simple yet very complete Java wrapper for the Clash of Clans mobile game API. It allows developers to easily do request to the game API without bothering about JSON handling.

## How to use it?
```java
// 1. Create an instance of ClashAPI by providing your Clash of Clans API token to the constructor
ClashAPI clashAPI = new ClashAPI("token");

// 2. And do the requests you need... Yes, it's as simple :)
Player player = clashAPI.getPlayer("#AAAA00");
```

## What's the token?
In order to make calls to the Clash of Clans API, Supercell (developer of the game) asks you to sign up on [this website](https://developer.clashofclans.com/#/register). Then, head to your [profile](https://developer.clashofclans.com/#/account) and create a new key. Once you are done, the key will generate the token. Copy it and provide it to the `ClashAPI` constructor.

Though this token is linked to the IP address you gave, I would advise **not to hardcode it** inside your code, for safety sake. Paste it in a separate file that you would access from your code. It will prevent your token being spread if you ever share your files.

## How does it work?
I analyzed JSON responses from the Clash of Clans API to recreate the models as Java structures so you don't have to deal with deserialization and data sorting each time.

## Dependencies
* GSON `2.8.6`
* OkHttp `4.8.0`

*This material is unofficial and is not endorsed by Supercell. For more information see Supercell's Fan Content Policy: www.supercell.com/fan-content-policy.*