package models;

import java.time.LocalDate;

public class Task {
  private String task_name;
  private String task_descrition;
  private String  task_date;
  private String  task_due;
  private double max_grade;
  
public String getTask_name() {
    return task_name;
}
public void setTask_name(String task_name) {
    this.task_name = task_name;
}
public String getTask_descrition() {
    return task_descrition;
}
public void setTask_descrition(String task_descrition) {
    this.task_descrition = task_descrition;
}
public String  getTask_date() {
    return task_date;
}
public void setAsk_date(String  ask_date) {
    this.task_date = ask_date;
}
public String  getTask_due() {
    return task_due;
}
public void setTask_due(String  task_due) {
    this.task_due = task_due;
}
public double getMax_grade() {
    return max_grade;
}
public void setMax_grade(double max_grade) {
    this.max_grade = max_grade;
}
}
