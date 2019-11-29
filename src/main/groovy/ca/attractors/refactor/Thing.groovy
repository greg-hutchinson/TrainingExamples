package ca.attractors.refactor

abstract  class Thing {
    abstract int getWeight();

    public String getDescription() {
        if (getWeight() > 200)
            return "heavy"
        "light"
    }


}
