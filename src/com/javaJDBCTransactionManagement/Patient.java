package com.javaJDBCTransactionManagement;

public class Patient 
{
	
	private int patientId;
	private String patientName;
	private String patientProblem;
	private double patientBill;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(int patientId, String patientName, String patientProblem, double patientBill) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientProblem = patientProblem;
		this.patientBill = patientBill;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientProblem() {
		return patientProblem;
	}

	public void setPatientProblem(String patientProblem) {
		this.patientProblem = patientProblem;
	}

	public double getPatientBill() {
		return patientBill;
	}

	public void setPatientBill(double patientBill) {
		this.patientBill = patientBill;
	}

	@Override
	public String toString() 
	{
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientProblem=" + patientProblem
				+ ", patientBill=" + patientBill + "]";
	}
	

}
