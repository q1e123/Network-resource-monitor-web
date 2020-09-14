package com.q1e123.NetworkResourceMonitorWeb.model;

public class EnvironmentVariables {
    private int id;
    private String variable;
    private String variableValue;
    private int usageId;

    public EnvironmentVariables(int id, String variable, String variableValue, int usageId) {
        this.id = id;
        this.variable = variable;
        this.variableValue = variableValue;
        this.usageId = usageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }

    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int usageId) {
        this.usageId = usageId;
    }
}
