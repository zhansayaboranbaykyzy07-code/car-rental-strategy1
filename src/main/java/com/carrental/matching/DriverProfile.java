package com.carrental.matching;

public class DriverProfile {
    private final String name;
    private final int experienceYears;
    private final boolean prefersEco;

    public DriverProfile(String name, int experienceYears, boolean prefersEco) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.prefersEco = prefersEco;
    }

    public String getName() { return name; }
    public int getExperienceYears() { return experienceYears; }
    public boolean isPrefersEco() { return prefersEco; }
}