package com.dharshu.testcasemanagement.model;

import java.time.LocalDateTime;

public class TestCase {

    private int id;
    private String title;
    private String module;
    private String description;
    private TestPriority priority;
    private TestStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime executedAt;

    private String actualResult;
    private String executionNotes;

    public TestCase(
            int id,
            String title,
            String module,
            String description,
            TestPriority priority) {

        this.id = id;
        this.title = title;
        this.module = module;
        this.description = description;
        this.priority = priority;

        this.status = TestStatus.NOT_EXECUTED;
        this.createdAt = LocalDateTime.now();

        this.executedAt = null;
        this.actualResult = "Not Executed";
        this.executionNotes = "Test case has not been executed yet.";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getModule() {
        return module;
    }

    public String getDescription() {
        return description;
    }

    public TestPriority getPriority() {
        return priority;
    }

    public TestStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExecutedAt() {
        return executedAt;
    }

    public String getActualResult() {
        return actualResult;
    }

    public String getExecutionNotes() {
        return executionNotes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(TestPriority priority) {
        this.priority = priority;
    }

    public void setStatus(TestStatus status) {
        this.status = status;
    }

    public void executeTest(
            TestStatus status,
            String actualResult,
            String executionNotes) {

        this.status = status;
        this.actualResult = actualResult;
        this.executionNotes = executionNotes;
        this.executedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return "\nTest Case ID    : " + id +
                "\nTitle           : " + title +
                "\nModule          : " + module +
                "\nDescription     : " + description +
                "\nPriority        : " + priority +
                "\nStatus          : " + status +
                "\nActual Result   : " + actualResult +
                "\nExecution Notes : " + executionNotes +
                "\nCreated At      : " + createdAt +
                "\nExecuted At     : " + executedAt +
                "\n----------------------------------------";
    }
}