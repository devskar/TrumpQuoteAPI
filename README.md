# TrumpQuote API
A wrapper for www.whatdoestrumpthink.com written in just 1 file.

## License
By using this API wrapper you are you agree to the[Terms of Service and Privacy Policy](https://whatdoestrumpthink.com/terms_of_service.html) of whatdoestrumpthink.com


## Creating the TrumpQuote Object

**Example**:

```java
TrumpQuote api = new TrumpQuote();
```
The api gives us 2 types of quotes:
- Random
- Personalized

#### Examples:

**Random Quote**:

```java
public class Example {

    public static void main(String[] args) throws IOException
    {
        TrumpQuote api = new TrumpQuote();

        TrumpQuote.Quote quote = api.getRandomQuote();
        
        quote.getMessage();
    }
}
```

**Personalized Quote**:

```java
public class Example {

    public static void main(String[] args) throws IOException
    {
        TrumpQuote api = new TrumpQuote();

        TrumpQuote.Quote quote = api.getPersonalizedQuote(args[0]);

        quote.getNickname();
    }
}
```

Notice: only the personalized quote has a getter for nicknames.

You can check this any time by doing:

```Java
public class Example {

    public void example(TrumpQuote.Quote quote)
    {
        boolean bool = quote.hasNickname();
    }
}
```

Be sure to replace the **VERSION** key below with the one of the versions shown above!

**Maven**
```xml
<dependency>
    <groupId>groupId</groupId>
    <artifactId>arifactId</artifactId>
    <version>VERSION</version>
</dependency>
```

## Dependencies:
This project requires **Java 8**.

 * OkHttp
   * Version: **2.11.0**
   * [Github](https://github.com/square/okhttp)
   * [Maven](https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp/3.11.0)
 * org.json
   * Version: **20180813**
   * [Github](https://github.com/douglascrockford/JSON-java)
   * [Maven](https://mvnrepository.com/artifact/org.json/json/20180813)
