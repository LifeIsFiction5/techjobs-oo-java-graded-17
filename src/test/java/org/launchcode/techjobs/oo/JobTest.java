package org.launchcode.techjobs.oo;


import org.junit.Test;

import javax.swing.text.Position;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here

    //Test Empty Constructor
    @Test
    public void testSettingJobId() {
        Job emptyJobOne = new Job();
        Job emptyJobTwo = new Job();

        assertNotEquals(emptyJobOne.getId(), emptyJobTwo.getId());
    }

    //Test Full Constructor

    Employer testEmployer = new Employer("ACME");
    Location testLocation = new Location("Desert");
    PositionType testPositionType = new PositionType("Quality control");
    CoreCompetency testCoreCompetency = new CoreCompetency("Persistence");

    @Test
    public void testJobConstructorSetsAllFields()  {
        Job testJob = new Job("Product Tester", testEmployer, testLocation, testPositionType, testCoreCompetency);

        //AssertTrue to check the types and non-null conditions
        assertTrue(testJob.getName() != null);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        //AssertEquals to check the assigned values
        assertEquals("Product Tester", testJob.getName());
        assertEquals(testEmployer, testJob.getEmployer());
        assertEquals(testLocation, testJob.getLocation());
        assertEquals(testPositionType, testJob.getPositionType());
        assertEquals(testCoreCompetency, testJob.getCoreCompetency());
    }

    //Test the equals Method
    @Test
    public void testJobsForEquality() {
        Job identicalJobOne = new Job("Product Tester", testEmployer, testLocation, testPositionType, testCoreCompetency);
        Job identicalJobTwo = new Job("Product Tester", testEmployer, testLocation, testPositionType, testCoreCompetency);

        assertNotEquals(identicalJobOne.getId(), identicalJobTwo.getId());
    }

    //Test the toString Method
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job emptyLineTestJob = new Job("Product Tester", testEmployer, testLocation, testPositionType, testCoreCompetency);
        String newLine = System.lineSeparator();
        String jobString = emptyLineTestJob.toString();

        assertTrue("Job string starts with a new line", jobString.startsWith(newLine));
        assertTrue("Job string ends with a new line", jobString.endsWith(newLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJobForData = new Job("Product Tester", testEmployer, testLocation, testPositionType, testCoreCompetency);
        String jobString = testJobForData.toString();
        String newLine = System.lineSeparator();

        assertEquals(newLine+
                                "ID: " + testJobForData.getId() + newLine +
                                "Name: Product Tester" + newLine +
                                "Employer: ACME" + newLine +
                                "Location: Desert" + newLine +
                                "Position Type: Quality control" + newLine +
                                "Core Competency: Persistence" + newLine, testJobForData.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testerJob = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType(),
                new CoreCompetency("Persistence"));
        String newline = System.lineSeparator();

        assertEquals(newline+
                        "ID: " + testerJob.getId() + newline +
                        "Name: Product tester" + newline +
                        "Employer: ACME" + newline +
                        "Location: Desert" + newline +
                        "Position Type: Data not available" + newline +
                        "Core Competency: Persistence" + newline
                , testerJob.toString());
    }
}
