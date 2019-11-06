
# My Guidelines for Refactoring

First some Principals: (Heuristic)
- Definition of the word Re-Factor
    from Math to factor is to break down a number into its lowest prime numbers. This implies
    that we should be able to do the same with code. Specifically functions.
- DRY (Don't Repeat Yourself)
- Methods should do 1 and only 1 thing (No side effects)
- Methods with fewer parameters are easier to understand than those with more parameters
- Method size - Methods with less lines of code are easier to understand than Methods with more lines of code
- Methods with no conditional or looping logic are easier to understand than Methods with conditions or loops
- Many methods can be thought of as attributes, so they should start with the verb get.
- interrogating the data of an object to make decisions is a red flag - perhaps delegate
- And most importantly - "Strings are evil"

Depending on the language (Java) you are using maximum method size should not exceed 10-15 lines. (Smalltalk considers methods
longer than 5 lines long), but what techniques can you use to get this smaller.

Heuristic - Rule of thumb

## Refactor Consider making getters for conditional values on a field

## Refactor loops into their own methods.

## Try and make things look like attributes (private). Naming then becomes easier (i.e. getters)

## Prefer ***return*** statements as compared to ***else*** statements - This can only occur when the if-then-else is the only thing within a method.

## If many methods only apply after the refactor, consider a private inner class to document the fact.

Let's apply the above rules to the following code. The class has an id and a map

```Java
public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(getClass().toString() + "(");
    if (getSysId() != null)
        builder.append(getSysId() + ")");
    else
        builder.append("null)");

    map.forEach((k, v) ->
        if (value instanceof CharSequence) {
            builder.append("$key: $value\n");
        }
        else
            builder.append("$key: Binary ");
    )
    builder.append(")");
    builder.toString();
}
```

Remember - methods should do 1 and only 1 thing. This method does conform to this rule - everything within this method is only doing stuff that relates to creating a prettyString. However, it is a long method. Let's try Refactor loops into their own methods. (Use IDE - extract method). Then, let's use the first rule above as well. This now looks perhaps like this.

```Java
public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(getClass().toString() + "(");
    builder.append(getSysIdPrintString());
    builder.append(getMapToString());        
    builder.append(")");
    builder.toString();
}

//Rule 1 - above
private String getSysIdPrintString() {
    if (getSysId() != null)
        return getSysId() + ")";
    return "null)";
}

private void getMapToString() {
    StringBuilder builder = new StringBuilder();
    map.forEach((k, v) ->
        if (value instanceof CharSequence) {
            builder.append("$key: $value\n");
        }
        else
            builder.append("$key: Binary ");
    )    
    return builder.toString();
}
```
Of course this last method can now be thought of as:

```Java
private void getMapToString() {
    StringBuilder builder = new StringBuilder();
    map.forEach((k, v) ->
        builder.append (getKeyValue (k,v));
    )    
    return builder.toString();
}

private String getKeyValue(String key, String value) {
    if (value instanceof CharSequence)
        return "$key: $value\n";
    return "$key: Binary ";
}
```
