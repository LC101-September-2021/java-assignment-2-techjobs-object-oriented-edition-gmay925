package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Objects;

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
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
    new Location("Desert"),
    new PositionType("Quality Control"),
    new CoreCompetency("Persistence"));
        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

    assertEquals(job1.getName(), "Product tester");
    assertEquals(job1.getEmployer().getValue(), "ACME");
    assertEquals(job1.getLocation().getValue(), "Desert");
    assertEquals(job1.getPositionType().getValue(), "Quality control");
    assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

@Test
public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        assertTrue(job1.toString().charAt(0) == '\n' && job1.toString().charAt(job1.toString().length() - 1) == '\n');
        assertEquals('\n', job1.toString().charAt(0));
        assertEquals('\n', job1.toString().charAt(job1.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job5 = new Job("test1", new Employer("test2"), new Location("test3"), new PositionType("test4"), new CoreCompetency("test5"));
        assertEquals("\nID: 4\nName: test1\nEmployer: test2\nLocation: test3\nPosition Type: test4\nCore Competency: test5\n", job5.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job6 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: 3\nName: No data available\nEmployer: No data available\nLocation: No data available\nPosition Type: No data available\nCore Competency: No data available\n", job6.toString());
    }
}
