package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals("Validating different job IDs for default constructors", job1.getId(), job2.getId() );
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job3.getName());
        assertEquals( "ACME", job3.getEmployer().getValue());
        assertEquals( "Desert", job3.getLocation().getValue());
        assertEquals( "Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());

        assertTrue( job3 instanceof Job);
        assertTrue( job3.getEmployer() instanceof Employer);
        assertTrue( job3.getLocation() instanceof Location);
        assertTrue( job3.getPositionType() instanceof PositionType);
        assertTrue( job3.getCoreCompetency() instanceof CoreCompetency);

    }
    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse( job4.getId() == job5.getId() );
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //String expectedString = "\n" +job6.getName()+ "\n";
        String actualString = job6.toString();
        int lastInd = actualString.length() - 1;
        assertEquals( '\n', actualString.charAt(0));
        assertEquals( '\n', actualString.charAt(lastInd));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actualString = job7.toString();
        String expectedString = "\nID: " + job7.getId() + "\nName: " + job7.getName() + "\nEmployer: " + job7.getEmployer().getValue() + "\nLocation: " + job7.getLocation().getValue()+ "\nPosition Type: " + job7.getPositionType().getValue() + "\nCore Competency: " + job7.getCoreCompetency().getValue() + "\n";
        assertEquals( expectedString, actualString );
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job8 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actualString = job8.toString();
        String expectedString = "\nID: " + job8.getId() + "\nName: " + job8.getName() + "\nEmployer: " + job8.getEmployer().getValue() + "\nLocation: Data not available"  + "\nPosition Type: " + job8.getPositionType().getValue() + "\nCore Competency: " + job8.getCoreCompetency().getValue() + "\n";
        assertEquals( expectedString, actualString );
    }

    @Test
    public void testToStringHandlesAllEmptyField(){
        Job job9 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String actualString = job9.toString();
        String expectedString = "\nOOPS! This job does not seem to exist.\n";
        assertEquals("Validating all empty field", expectedString, actualString );
    }

}
