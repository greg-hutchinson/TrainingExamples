package ca.attractors.refactor

class Widget {
    SystemIdentifier sysId
    Map map = new HashMap()
    List things = []

    static void main(String[] args) {
        Widget widget =  new Widget("123456")
        widget.map =  [a : "Alpha", b: "Beta", c: "This is a test".getBytes() ]
        widget.things.add(new Pencil())
        widget.things.add(new Pen())
        println(widget.toString())
    }

    Widget(String sysId) {
        this(new SystemIdentifier(sysId))
    }

    Widget(SystemIdentifier sysId) {
        this.sysId = sysId
    }

    int getWeight() {       //This one is surely refactored enough !!!
        getThisWeight() + getThingsWeight()
    }

    private int getThisWeight() {
        500
    }

    int getThingsWeight() {
        int total = 0
        things.each {Thing thing ->
            total += thing.getWeight()
        }
        total
    }

    public String toString() {
        StringBuilder builder = new StringBuilder()
        builder.append(getClass().toString())
        builder.append("(${sysId.toString()}) \n")
        builder.append("${getFormattedMap()} \n")
        builder.append("${getFormattedThings()} \n")
        builder.append("And the total weight is ${getWeight()} grams")
        builder.toString()
    }

    private String getFormattedThings() {
        StringBuilder builder = new StringBuilder()
        things.each {Thing thing ->
            builder.append(thing.getDescription() + "\n")
        }
        builder.toString()
    }

    private String getFormattedMap() {
        new MapFormatter().getFormattedMap()
    }

    class MapFormatter {
        StringBuilder builder = new StringBuilder()

        String getFormattedMap() {
            map.each { key, value ->
                builder.append(getFormattedEntry(key, value))
            }
            builder.toString()
        }

        private String getFormattedEntry(key, value) {
            if (value instanceof CharSequence)
                return "\t$key: $value\n"
            return "\t$key: (Binary content)"
        }
    }

}