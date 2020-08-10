package com.serverless;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task {
  private final String id;
  private final String description;

  public Task() {
    this.id = "";
    this.description = "";
  }
  public Task(String taskId) {
    this.id = taskId;
    this.description = "Automatize execution";
  }

  public String getId() {
    return this.id;
  }
  public String getDescription() {
    return this.description;
  }

  public List<Task> list() {
    List<Task> results = new ArrayList<Task>();
    results.add(new Task("Task 1"));
    results.add(new Task("Task 2"));
    results.add(new Task("Task 3"));
    results.add(new Task("Task 4"));
    return results;
  }
  
}