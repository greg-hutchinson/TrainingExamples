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
        builder.toString()
    }
}