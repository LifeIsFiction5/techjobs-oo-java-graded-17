package org.launchcode.techjobs.oo;


import org.junit.Test;

import javax.swing.text.Position;

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
}
