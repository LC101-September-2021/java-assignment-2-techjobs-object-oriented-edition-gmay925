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
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getName() instanceof String);
        assertEquals("Product tester", testJob.getName());
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job2 = new Job("Product tester", new Employer("Walmart"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob.equals(test_job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', test_job.toString().charAt(0));
        assertEquals('\n', test_job.toString().charAt(test_job.toString().length()-1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: "+ testJob.getId() +
                "\nName: "+ testJob.getName() +
                "\nEmployer: "+ testJob.getEmployer().toString() +
                "\nLocation: "+ testJob.getLocation().toString() +
                "\nPosition Type: " + testJob.getPositionType().toString() +
                "\nCore Competency: " + testJob.getCoreCompetency().toString() + "\n", testJob.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("Product Tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + testJob.getId() +
                "\nName: Product Tester" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available\n", testJob.toString());
    }
    @Test
    public void testToStringHandlesOnlyIdField(){
        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nOOPS! This job does not seem to exist.\n", testJob.toString());
    }


}