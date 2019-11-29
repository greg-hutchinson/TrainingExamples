package ca.attractors.refactor

class Widget {
    public static final int ROBOT_WEIGHT = 500
    SystemId sysId
    Map map = [:]
    List things = []

    private Widget() {}

    Widget(String sysId) {
        this(new SystemId(sysId))
    }

    Widget(SystemId sysId) {
        this.sysId = sysId
    }

    public String toString() {
        return new ToString().toString()
    }






    class ToString {
        public String toString() {
            StringBuilder builder = new StringBuilder()
            builder.append(Widget.class.toString() )
            builder.append("(" + sysId.toString() + ")\n")
            builder.append(getFormattedMap())
            builder.append(getFormattedThings())
            builder.append("And the total weight is ${getWeight()} grams")
            builder.toString()
        }

        private String getFormattedThings() {
            StringBuilder builder = new StringBuilder()
            things.each {Thing thing ->
                builder.append(thing.getClass().toString() + " is ${thing.getDescription()}\n")
            }
            builder.toString()
        }

        private String getFormattedMap() {
            StringBuilder builder = new StringBuilder()
            map.each { key, value ->
                builder.append(getFormattedKeyValue(key, value))
            }
            builder.toString()
        }

        private String getFormattedKeyValue(def key, def value) {
            if (value instanceof CharSequence)
                return "\t$key: $value\n"
            "\t$key: (Binary content)\n"
        }

        int getWeight() {
            getWidgetWeight() + getThingsWeight()
        }

        private int getThingsWeight() {
            int total = 0
            things.each {Thing thing ->
                total += thing.getWeight()
            }
            total
        }

        int getWidgetWeight() {
            ROBOT_WEIGHT
        }
    }
}