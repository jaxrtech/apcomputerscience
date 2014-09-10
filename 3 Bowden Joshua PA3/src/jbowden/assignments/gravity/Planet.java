package jbowden.assignments.gravity;

/**
 * Represents the planets in the solar system.
 */
enum Planet {
    MERCURY("Mercury", 0.38),
    VENUS("Venus", 0.78),
    EARTH("Earth", 1.00),
    MARS("Mars", 0.39),
    JUPITER("Jupiter", 2.65),
    SATURN("Saturn", 1.17),
    URANUS("Uranus", 1.05),
    NEPTUNE("Neptune", 1.23),
    PLUTO("Pluto", 0.05);

    /**
     * The name of the planet
     */
    private final String name;

    /**
     * The gravity factor relative to Earth
     */
    private final double gravity;

    Planet(String name, double gravity) {
        this.name = name;
        this.gravity = gravity;
    }

    /**
     * Returns the `Planet` from the specifies index (0 indexed)
     * @param index  the index (0 indexed)
     * @return the `Planet`
     * @throws java.lang.IndexOutOfBoundsException  the index specified does not map to a `Planet`.
     */
    public static Planet fromIndex(int index) {
        return Planet.values()[index];
    }

    public String getName() {
        return name;
    }

    public double getGravity() {
        return gravity;
    }
}
