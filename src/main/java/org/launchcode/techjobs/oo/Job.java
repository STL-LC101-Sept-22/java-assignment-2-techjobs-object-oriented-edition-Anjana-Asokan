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
    public Job(){
       this.id = nextId;
        nextId++;
    }
    public Job( String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        StringBuilder str1 = new StringBuilder();

        if(name.isEmpty() && employer.getValue().isEmpty() && location.getValue().isEmpty() && positionType.getValue().isEmpty() && coreCompetency.getValue().isEmpty() )
        {
            str1.append("\nOOPS! This job does not seem to exist.\n");
        }
        else
        {
            str1.append("\nID:  "+id);
            str1.append("\nName: "+(name.isEmpty()?"Data not available":name));
            str1.append("\nEmployer: "+(employer.getValue().isEmpty()?"Data not available":employer.getValue()));
            str1.append("\nLocation: "+(location.getValue().isEmpty()?"Data not available":location.getValue()));
            str1.append("\nPosition Type: "+(positionType.getValue().isEmpty()?"Data not available":positionType.getValue()));
            str1.append("\nCore Competency: "+(coreCompetency.getValue().isEmpty()?"Data not available":coreCompetency.getValue())+"\n");

        }

        return str1.toString();

    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

}

