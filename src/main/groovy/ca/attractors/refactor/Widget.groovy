package ca.attractors.refactor

class Widget {
    String sysId = "123456"      //XXX-X-XX
    Map map = new HashMap()

    public static void main(String[] args) {
        println(new Widget().toString())
    }

    String getSysId() {
        return sysId
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


        map.each { key, value ->
            if (value instanceof CharSequence) {
                builder.append("$key: $value\n")
            } else
                builder.append("$key: Binary ")
        }
        builder.append(")")
        builder.toString()
    }
}