package com.dharshu.testcasemanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.dharshu.testcasemanagement.exception.TestCaseNotFoundException;
import com.dharshu.testcasemanagement.model.TestCase;
import com.dharshu.testcasemanagement.model.TestStatus;

public class TestCaseService {

    private final List<TestCase> testCases = new ArrayList<>();

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public void viewAllTestCases() {

        if (testCases.isEmpty()) {
            System.out.println("\nNo test cases available.");
            return;
        }

        for (TestCase testCase : testCases) {
            System.out.println(testCase);
        }
    }

    public TestCase findById(int id)
            throws TestCaseNotFoundException {

        for (TestCase testCase : testCases) {

            if (testCase.getId() == id) {
                return testCase;
            }
        }

        throw new TestCaseNotFoundException(
                "Test case with ID " + id + " not found."
        );
    }

    public void searchByModule(String module) {

        boolean found = false;

        for (TestCase testCase : testCases) {

            if (testCase.getModule().equalsIgnoreCase(module)) {

                System.out.println(testCase);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "\nNo test cases found for module: " + module
            );
        }
    }

    public void executeTestCase(
            int id,
            TestStatus status,
            String actualResult,
            String executionNotes)
            throws TestCaseNotFoundException {

        TestCase testCase = findById(id);

        testCase.executeTest(
                status,
                actualResult,
                executionNotes
        );
    }

    public void deleteTestCase(int id)
            throws TestCaseNotFoundException {

        TestCase testCase = findById(id);

        testCases.remove(testCase);

        System.out.println(
                "Test case deleted successfully."
        );
    }

    public void showSummary() {

        int total = testCases.size();
        int passed = 0;
        int failed = 0;
        int blocked = 0;
        int notExecuted = 0;

        for (TestCase testCase : testCases) {

            switch (testCase.getStatus()) {

                case PASS:
                    passed++;
                    break;

                case FAIL:
                    failed++;
                    break;

                case BLOCKED:
                    blocked++;
                    break;

                case NOT_EXECUTED:
                    notExecuted++;
                    break;
            }
        }

        System.out.println("\n========== TEST SUMMARY ==========");
        System.out.println("Total Test Cases : " + total);
        System.out.println("Passed           : " + passed);
        System.out.println("Failed           : " + failed);
        System.out.println("Blocked          : " + blocked);
        System.out.println("Not Executed     : " + notExecuted);
        System.out.println("==================================");
    }
}