![ClashAPI logo](/src/main/resources/logo.png)

<p align="center">
    <img alt="GitHub License" src="https://img.shields.io/github/license/Lycoon/clash-api">
    <img alt="Maven Central" src="https://img.shields.io/maven-central/v/io.github.lycoon/clash-api">
    <img alt="Static Badge" src="https://img.shields.io/badge/Java%20version-8%2B-blue">
</p>

<p align="center">
    <b>ClashAPI</b> is a very simple yet very complete JVM wrapper for the <i>Clash of Clans</i> mobile game API
</p>

It allows developers to easily access the game API with their favorite language without bothering 
about JSON and HTTP handling. It is intended to be lightweight and as intuitive as possible to use.
It can be imported in any JVM project, with guaranteed compatibility with Java and Kotlin.

# How does it work?
I read through the documentation of Clash of Clans API to recreate the models as data structures so you don't have to
deal with JSON de/serialization and data categorization each time. You can therefore simply access game data through 
your Java/Kotlin (JVM) classes and methods, all well documented!

## Maven
Inside your `<dependencies>` scope of your `pom.xml` file, add the following:
```xml
<dependency>
    <groupId>io.github.lycoon</groupId>
    <artifactId>clash-api</artifactId>
    <version>5.1.4</version>
</dependency>
```

## Gradle
Inside your `dependencies` scope of your `build.gradle` file, add the following:
```gradle
implementation 'io.github.lycoon:clash-api:5.1.4'
```

# Quick start
## 1. Authenticating
Initializing a ClashAPI instance is very simple. There are two ways of authenticating to the Clash of Clans API:
either by providing your token(s) directly (which you must have generated prior), or your API developer email/password
credentials (which will generate them for you).

### Token method (recommended)
Instancing with token(s) is the safest way to go as in case of a leak, you would just need to revoke the concerned 
key from your developer account. The downside is that your token is linked to a single IP address. In case you
don't know the IP address on which your code will run (e.g. if you are using a cloud service), or if you just
don't want the hassle of updating your token each time your IP changes, you can go with the 'Credentials' way.

```java
// Single token
ClashAPI clashAPI = new ClashAPI("token");
```

This second constructor allows you to provide a list of tokens, which enables you to bypass rate limitations
as the library will cycle through all of them for each request.
```java
// Token list
ArrayList<String> tokens;

tokens = listOf("tokenA", "tokenB", "tokenC");        // (Kotlin)
tokens = Arrays.asList("tokenA", "tokenB", "tokenC"); // (Java)
        
ClashAPI clashAPI = new ClashAPI(tokens);
```

### Credentials method
This method is the simplest but not the safest as in the case of a leak, your credentials would be exposed.
Authenticating with your credentials enables dynamic IP support if you cannot know the IP on which your code will run.
```java
// Developer API credentials
ClashAPI clashAPI = new ClashAPI("email", "password");
```

## 2. Making requests
```java
// Yes, it's as simple :)
Player player = clashAPI.getPlayer("#AAAA00");
int townhallLevel = player.getTownHallLevel();
Role clanRole = player.getRole();
List<Troop> heroes = player.getHeroes();
// ...
```

# What's a token?
In order to make calls to the Clash of Clans API, Supercell (the game developer) requires to provide a token for each
request. You can get a token by signing up on the [developer portal](https://developer.clashofclans.com/#/register). Then, head to your [profile](https://developer.clashofclans.com/#/account) and create 
a new key providing IP addresses you want to allow. Once you are done, the key will generate the token. 
You can now copy it and provide it to the `ClashAPI` constructor.

Though this token is tied to the IP addresses you provided, I would advise **not to hardcode it** inside your code, 
for safety sake. Paste it in a separate file that you would access from your code. It will prevent your token 
being spread if you ever share your files mistakenly. The same goes for the credentials method.

# Disclaimer
*This material is unofficial and is not endorsed by Supercell. For more information see Supercell's Fan Content Policy: www.supercell.com/fan-content-policy.*
