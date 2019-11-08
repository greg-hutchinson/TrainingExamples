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

    @Override
    String toString() {
        new ToString().toString()
    }

    class ToString {
            StringBuilder builder = new StringBuilder()
        public String toString() {
            appendClassName()
            appendSysId()
            appendMap()
            appendThings()
            appendTotalWeight()
            builder.toString()
        }

        def appendClassName() {
            builder.append(this.getClass().toString())
        }

        private String appendThings() {
            things.each {Thing thing ->
                builder.append(thing.getDescription() + "\n")
            }
        }

        private String appendFormattedMap() {
            new MapFormatter().appendFormattedMap()
        }

        class MapFormatter {
            void appendFormattedMap() {
                map.each { key, value ->
                    builder.append(getFormattedEntry(key, value))
                }
            }

            private String getFormattedEntry(key, value) {
                if (value instanceof CharSequence)
                    return "\t$key: $value\n"
                return "\t$key: (Binary content)"
            }
        }
    }
}