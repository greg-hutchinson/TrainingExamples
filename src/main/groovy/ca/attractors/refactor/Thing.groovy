package ca.attractors.refactor

abstract  class Thing {
    abstract int getWeight();

    String getDescription() {
        getClass().toString() + " is " + getWeightDescription()
    }

    private String getWeightDescription() {
        if (getWeight() > 200)
            return "heavy"
        "light"
    }
}
