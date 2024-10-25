package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.



    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    //Constructors for Unique ID and Other fields

    public Job() {
        this.id = nextId;
        nextId++;
    };

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    };

   //Check for empty fields

    public boolean isJobValid() {
        return (this.name != null) ||
                (this.employer != null) ||
                (this.location != null) ||
                (this.positionType != null) ||
                (this.coreCompetency != null);
    }
    @Override public String toString() {
        if (!isJobValid()) {
            return "OOPS! This job does not seem to exist.";
        }
        String newline = System.lineSeparator();
        return newline +
                "ID: " + this.getId() + newline +
                "Name: " + this.getName() + newline +
                "Employer: " + this.getEmployer() + newline +
                "Location: " + this.getLocation() + newline +
                "Position Type: " + this.getPositionType() + newline +
                "Core Competency: " + this.getCoreCompetency() + newline;
    }

    // Equals and Hashcode methods

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        if (this.name == null) {
            return "Data not available";
        }
            return name;
    }

    public Employer getEmployer() {
        if (this.employer.getValue() == null || this.employer.getValue().isEmpty()) {
            return new Employer("Data not available");
        }
        return employer;
    }

    public Location getLocation() {
        if (this.location.getValue() == null || this.location.getValue().isEmpty()) {
            return new Location("Data not available");
        }
        return location;
    }

    public PositionType getPositionType() {
        if (this.positionType.getValue() == null || this.positionType.getValue().isEmpty()) {
            return new PositionType("Data not available");
        }
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        if (this.coreCompetency.getValue() == null || this.coreCompetency.getValue().isEmpty()) {
            return new CoreCompetency("Data not available");
        }
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
