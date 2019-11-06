package ca.attractors.refactor

class Widget {
    String sysId      //XXX-X-XX
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
        if (sysId.length() != 6)
            throw new IllegalArgumentException("$sysId must be exactly 5 characters long")
        this.sysId = sysId
    }

    int getWeight() {
        weight = 500      //Weight of a widget
        things.each {Thing thing ->
            weight += thing.getWeight()
        }
        weight
    }

    public String toString() {
        StringBuilder builder = new StringBuilder()
        builder.append(getClass().toString())
        builder.append("(${getFormattedID()}) \n")
        builder.append("${getFormattedMap()} \n")
        builder.append("${getFormattedThings()} \n")
        builder.toString()
    }

    private String getFormattedThings() {
        StringBuilder builder = new StringBuilder()
        things.each {Thing thing ->
            String desc = "light"
            if (thing.getWeight() > 200)
                desc = "heavy"
            builder.append("${thing.getClass().toString()} is $desc\n")
        }
        builder.toString()
    }

    private String getFormattedMap() {
        new MapFormatter().getFormattedMap()
    }

    private String getFormattedID() {
        StringBuilder keyBuilder = new StringBuilder()
        keyBuilder.append(sysId.substring(0, 3))
        keyBuilder.append('-')
        keyBuilder.append(sysId.substring(3, 4))
        keyBuilder.append('-')
        keyBuilder.append(sysId.substring(4, 6))
        keyBuilder.toString()
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