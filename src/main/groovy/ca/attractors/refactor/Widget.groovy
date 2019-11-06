package ca.attractors.refactor

class Widget {
    String sysId      //XXX-X-XX
    Map map = new HashMap()
    List things = []


    Widget(String sysId) {
        if (sysId.length() != 6)
            throw new IllegalArgumentException("$sysId must be exactly 5 characters long")
        this.sysId = sysId
    }

    static void main(String[] args) {
        Widget widget =  new Widget("123456")
        widget.map =  [a : "Alpha", b: "Beta", c: "This is a test".getBytes() ]
        widget.things.add(new Pencil())
        widget.things.add(new Pen())
        println(widget.toString())
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
                builder.append("\t$key: (Binary content)")
        }
        things.each {Thing thing ->
            builder.append(thing.getDescription() + "\n")
        }
        builder.append("And the total weight is ${getWeight()} grams")
        builder.toString()
    }

    int getThingsWeight() {
        int total = 500         //Widget weight
        // Add all things weight to this weight
        things.each {Thing thing ->
            total += thing.getWeight()
        }
        total
    }

}