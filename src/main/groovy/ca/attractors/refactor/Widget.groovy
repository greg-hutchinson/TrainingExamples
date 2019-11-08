package ca.attractors.refactor

class Widget {
    SystemIdentifier sysId
    Map map = new HashMap()
    List things = []

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
        builder.append("(${sysId.toString()})\n")
        builder.append("${getFormattedMap()}\n")
        builder.append("${getFormattedThings()}")
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