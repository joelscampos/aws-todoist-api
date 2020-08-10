package com.serverless;

public class Task {
  private final String id;
  private final String description;

  public Task() {
    this.id = "Task1";
    this.description = "Automatize execution";
  }

  public String getId() {
    return this.id;
  }
  public String getDescription() {
    return this.description;
  }
  
}