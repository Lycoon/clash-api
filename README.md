![ClashAPI logo](/src/main/resources/logo.png)

<p align="center">
  <a href="https://github.com/Lycoon/clash-api/actions/workflows/check-ci.yml">
    <img alt="Check CI status" src="https://github.com/Lycoon/clash-api/actions/workflows/check-ci.yml/badge.svg?branch=dev">
  </a>
  <img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/Lycoon/clash-api">
</p>

ClashAPI is a very simple yet very complete Kotlin wrapper for the Clash of Clans mobile game API. 
It allows developers to easily do requests to the game API without bothering about JSON and HTTP handling.
It is intended to be lightweight and as intuitive as possible to use.

## How does it work?
I analyzed JSON responses from the Clash of Clans API to recreate the models as Java structures so you don't have to deal with deserialization and data categorization each time. You can therefore simply access game data through your Java/Kotlin (JVM) classes and methods, all documented!

## Setup
ClashAPI is available on Maven Central. You can add it to your project using Maven or Gradle.

### Maven
Inside your `<dependencies>` scope of your `pom.xml` file, add the following:
```xml
<dependency>
    <groupId>io.github.lycoon</groupId>
    <artifactId>clash-api</artifactId>
    <version>5.0.0</version>
</dependency>
```

### Gradle
Inside your `dependencies` scope of your `build.gradle` file, add the following:
```gradle
implementation 'io.github.lycoon:clash-api:5.0.0'
```

## Quick start
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

## Report bugs
You've found a bug? Let me know by opening an issue. 

## Disclaimer
*This material is unofficial and is not endorsed by Supercell. For more information see Supercell's Fan Content Policy: www.supercell.com/fan-content-policy.*
