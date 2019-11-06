package ca.attractors.refactor

class SystemIdentifier {
    private String id

    SystemIdentifier(String id) {
        if (id.length() != 6)
            throw new IllegalArgumentException("$id must be exactly 5 characters long")
        this.id = id
    }

    @Override
    String toString() {
        StringBuilder keyBuilder = new StringBuilder()
        keyBuilder.append(id.substring(0, 3))
        keyBuilder.append('-')
        keyBuilder.append(id.substring(3, 4))
        keyBuilder.append('-')
        keyBuilder.append(id.substring(4, 6))
        keyBuilder.toString()
    }
}
