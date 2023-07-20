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
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobThree.getName() instanceof String);
        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobThree.getName());
        assertEquals("ACME", jobThree.getEmployer().getValue());
        assertEquals("Desert", jobThree.getLocation().getValue());
        assertEquals("Quality control", jobThree.getPositionType().getValue());
        assertEquals("Persistence", jobThree.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job jobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobFive = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobFour.equals(jobFive));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testJob = aJob.toString();
        assertEquals('\n', testJob.charAt(0));
        assertEquals('\n', testJob.charAt(testJob.length()-1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedJob ="\n" + "ID: " + aJob.getId() +"\n" +
                            "Name: " + aJob.getName() +"\n" +
                            "Employer: " + aJob.getEmployer() + "\n" +
                            "Location: " + aJob.getLocation() + "\n" +
                            "Position Type: " + aJob.getPositionType() + "\n" +
                            "Core Competency: " + aJob.getCoreCompetency() + "\n";
        assertEquals(expectedJob, aJob.toString());

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobTestEmpty = new Job("", new Employer(""), new Location(""), new PositionType(""),
                new CoreCompetency(""));

        String ExpectedEmptyJob = "\n" + "ID: " + jobTestEmpty.getId() +"\n" +
                "Name: Data not available" +"\n" +
                "Employer: Data not available" + "\n" +
                "Location: Data not available" + "\n" +
                "Position Type: Data not available" +  "\n" +
                "Core Competency: Data not available" +  "\n";

        assertEquals(ExpectedEmptyJob, jobTestEmpty.toString());
    }

}
