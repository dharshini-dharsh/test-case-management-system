package com.dharshu.testcasemanagement;

import java.util.Scanner;

import com.dharshu.testcasemanagement.exception.TestCaseNotFoundException;
import com.dharshu.testcasemanagement.model.TestCase;
import com.dharshu.testcasemanagement.model.TestPriority;
import com.dharshu.testcasemanagement.model.TestStatus;
import com.dharshu.testcasemanagement.service.TestCaseService;
import com.dharshu.testcasemanagement.util.InputValidator;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final TestCaseService service =
            new TestCaseService();

    private static int nextId = 1;

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("      TEST CASE MANAGEMENT SYSTEM");
        System.out.println("==========================================");

        loadSampleData();

        while (true) {

            displayMenu();

            int choice = InputValidator.readPositiveInt(
                    scanner,
                    "Enter your choice: "
            );

            switch (choice) {

                case 1:
                    addTestCase();
                    break;

                case 2:
                    service.viewAllTestCases();
                    break;

                case 3:
                    searchById();
                    break;

                case 4:
                    searchByModule();
                    break;

                case 5:
                    executeTestCase();
                    break;

                case 6:
                    deleteTestCase();
                    break;

                case 7:
                    service.showSummary();
                    break;

                case 8:
                    System.out.println(
                            "\nThank you for using the system."
                    );
                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please enter 1 to 8."
                    );
            }
        }
    }

    private static void displayMenu() {

        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add Test Case");
        System.out.println("2. View All Test Cases");
        System.out.println("3. Search Test Case by ID");
        System.out.println("4. Search Test Cases by Module");
        System.out.println("5. Execute Test Case");
        System.out.println("6. Delete Test Case");
        System.out.println("7. View Test Summary");
        System.out.println("8. Exit");
        System.out.println("===============================");
    }

    private static void addTestCase() {

        System.out.println("\n--- ADD TEST CASE ---");

        String title = InputValidator.readNonEmptyString(
                scanner,
                "Enter test case title: "
        );

        String module = InputValidator.readNonEmptyString(
                scanner,
                "Enter module: "
        );

        String description = InputValidator.readNonEmptyString(
                scanner,
                "Enter description: "
        );

        TestPriority priority = readPriority();

        TestCase testCase = new TestCase(
                nextId++,
                title,
                module,
                description,
                priority
        );

        service.addTestCase(testCase);

        System.out.println(
                "Test case added successfully."
        );
    }

    private static void searchById() {

        int id = InputValidator.readPositiveInt(
                scanner,
                "Enter test case ID: "
        );

        try {

            TestCase testCase = service.findById(id);

            System.out.println(testCase);

        } catch (TestCaseNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void searchByModule() {

        String module = InputValidator.readNonEmptyString(
                scanner,
                "Enter module name: "
        );

        service.searchByModule(module);
    }

    private static void executeTestCase() {

        System.out.println("\n--- EXECUTE TEST CASE ---");

        int id = InputValidator.readPositiveInt(
                scanner,
                "Enter test case ID: "
        );

        TestStatus status = readExecutionStatus();

        String actualResult =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter actual result: "
                );

        String executionNotes =
                InputValidator.readNonEmptyString(
                        scanner,
                        "Enter execution notes: "
                );

        try {

            service.executeTestCase(
                    id,
                    status,
                    actualResult,
                    executionNotes
            );

            System.out.println(
                    "Test case executed successfully."
            );

        } catch (TestCaseNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void deleteTestCase() {

        int id = InputValidator.readPositiveInt(
                scanner,
                "Enter test case ID: "
        );

        try {

            service.deleteTestCase(id);

        } catch (TestCaseNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static TestPriority readPriority() {

        while (true) {

            System.out.println("\nSelect Priority:");
            System.out.println("1. LOW");
            System.out.println("2. MEDIUM");
            System.out.println("3. HIGH");
            System.out.println("4. CRITICAL");

            int choice = InputValidator.readPositiveInt(
                    scanner,
                    "Enter choice: "
            );

            switch (choice) {

                case 1:
                    return TestPriority.LOW;

                case 2:
                    return TestPriority.MEDIUM;

                case 3:
                    return TestPriority.HIGH;

                case 4:
                    return TestPriority.CRITICAL;

                default:
                    System.out.println(
                            "Invalid priority. Please choose 1 to 4."
                    );
            }
        }
    }

    private static TestStatus readExecutionStatus() {

        while (true) {

            System.out.println("\nSelect Execution Result:");
            System.out.println("1. PASS");
            System.out.println("2. FAIL");
            System.out.println("3. BLOCKED");

            int choice = InputValidator.readPositiveInt(
                    scanner,
                    "Enter choice: "
            );

            switch (choice) {

                case 1:
                    return TestStatus.PASS;

                case 2:
                    return TestStatus.FAIL;

                case 3:
                    return TestStatus.BLOCKED;

                default:
                    System.out.println(
                            "Invalid execution result. Please choose 1 to 3."
                    );
            }
        }
    }

    private static void loadSampleData() {

        service.addTestCase(
                new TestCase(
                        nextId++,
                        "Verify Login with Valid Credentials",
                        "Login",
                        "Verify user can login with valid username and password.",
                        TestPriority.HIGH
                )
        );

        service.addTestCase(
                new TestCase(
                        nextId++,
                        "Verify Login with Invalid Password",
                        "Login",
                        "Verify error message for invalid password.",
                        TestPriority.MEDIUM
                )
        );

        service.addTestCase(
                new TestCase(
                        nextId++,
                        "Verify Product Search",
                        "Product",
                        "Verify product search returns relevant products.",
                        TestPriority.HIGH
                )
        );
    }
}