package ca.attractors.refactor

class Widget {
    String sysId      //XXX-X-XX
    Map map = new HashMap()
    List things = []

    private Widget() {}

    Widget(String sysId) {
        if (sysId.length() != 6)
            throw new IllegalArgumentException("$sysId must be exactly 5 characters long")
        this.sysId = sysId
    }

    public String toString() {
        StringBuilder builder = new StringBuilder()
        StringBuilder keyBuilder = new StringBuilder()
        builder.append(getClass().toString() + "(")
        keyBuilder.append(sysId.substring(0,3))
        keyBuilder.append('-')
        keyBuilder.append(sysId.substring(3,4))
        keyBuilder.append('-')
        keyBuilder.append(sysId.substring(4,6))
        builder.append(keyBuilder.toString())
        builder.append(")\n")

        map.each { key, value ->
            if (value instanceof CharSequence) {
                builder.append("\t$key: $value\n")
            } else
                builder.append("\t$key: (Binary content)\n")
        }
        things.each {Thing thing ->
            String desc
            if (thing.getWeight() > 200)
                desc =  "heavy"
            else
                desc = "light"
            builder.append(thing.getClass().toString() + " is $desc\n")
        }

        builder.append("And the total weight is ${getWeight()} grams")
        builder.toString()
    }

    int getWeight() {
        int total = 500         //Widget weight
        // Add all things weight to this weight
        things.each {Thing thing ->
            total += thing.getWeight()
        }
        total
    }
}