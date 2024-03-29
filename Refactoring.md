
# My Guidelines for Refactoring

First some Principals: (Heuristic)
- Definition of the word Re-Factor
    from Math to factor is to break down a number into its lowest prime numbers. This implies
    that we should be able to do the same with code. Specifically functions.
- DRY (Don't Repeat Yourself)
- Methods should do 1 and only 1 thing (No side effects)

# Readability
- Methods with fewer parameters are easier to understand than those with more parameters
- Methods with less lines of code are easier to understand than Methods with more lines of code
- Methods with no conditional logic are easier to understand than methods with conditional logic
- Methods with no loops are easier to understand than methods with loops
- Methods that follow a naming pattern are easier to understand than ones that are unique (getters)

- Many methods can be thought of as attributes, so they should start with the verb get.
- interrogating the data of an object to make decisions is a red flag - perhaps delegate
- Beware of comments that describe lines of code
- And most importantly - "Strings are evil" - use objects

Depending on the language (Java) you are using maximum method size should not exceed 10-15 lines. (Smalltalk considers methods
longer than 5 lines long), but what techniques can you use to get this smaller.

Heuristic - Rule of thumb

## Refactor Consider making getters for conditional values on a field

## Refactor loops into their own methods.

## Try and make things look like attributes (private). Naming then becomes easier (i.e. getters)

## Prefer ***return*** statements as compared to ***else*** statements - This can only occur when the if-then-else is the only thing within a method.

## If many methods only apply after the refactor, consider a private inner class to document the fact.

Let's apply the above rules to the following code. The class has an id and a map
