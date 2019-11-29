package ca.attractors.refactor

class SystemId {
    String sysId
    SystemId(String sysId) {
        if (sysId.length() != 6)
            throw new IllegalArgumentException("$sysId must be exactly 5 characters long")
        this.sysId = sysId
    }

    String toString() {
        StringBuilder keyBuilder = new StringBuilder()
        keyBuilder.append(sysId.substring(0, 3))
        keyBuilder.append('-')
        keyBuilder.append(sysId.substring(3, 4))
        keyBuilder.append('-')
        keyBuilder.append(sysId.substring(4, 6))
        keyBuilder.toString()
    }


}
