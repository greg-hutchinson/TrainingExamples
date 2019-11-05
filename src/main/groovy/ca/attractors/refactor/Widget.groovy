package ca.attractors.refactor

class Widget {
    String sysId      //XXX-X-XX
    Map map = new HashMap()

    Widget(String sysId) {
        if (sysId.length() != 6)
            throw new IllegalArgumentException("$sysId must be exactly 5 characters long")
        this.sysId = sysId
    }

    static void main(String[] args) {
        Widget widget =  new Widget("123456")
        widget.map =  [a : "Alpha", b: "Beta", c: "This is a test".getBytes() ]
        println(widget.toString())
    }

    public String toString() {
        StringBuilder builder = new StringBuilder()
        builder.append(getClass().toString())
        builder.append("(${getFormattedID()})\n")
        builder.append(getFormattedMap())
        builder.toString()
    }

    private String getFormattedMap() {
        StringBuilder builder = new StringBuilder()
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

    private String getFormattedID() {
        StringBuilder keyBuilder = new StringBuilder()
        keyBuilder.append(sysId.substring(0, 3))
        keyBuilder.append('-')
        keyBuilder.append(sysId.substring(3, 4))
        keyBuilder.append('-')
        keyBuilder.append(sysId.substring(4, 6))
        keyBuilder.toString()
    }
}