package com.javaJDBCTransactionManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SavePatient {

	public static void main(String[] args)throws SQLException 
	{


		Connection connection = null;

		//patient values read from the user		
		Scanner scanner = new Scanner(System.in);

		try
		{

			connection = DatabaseConnection.getDBConnection();

			connection.setAutoCommit(false);//commit is false

			while(true)
			{

				System.out.println("enter patient id: ");
				int id = scanner.nextInt();

				scanner.nextLine();

				System.out.println("enter patient name: ");
				String name = scanner.nextLine();

				System.out.println("enter patient problem: ");
				String problem = scanner.nextLine();

				System.out.println("enter patient bill: ");
				double bill = scanner.nextDouble();

				//patient object
				Patient patient = new Patient(id, name, problem, bill);

				String query = "insert into patient(patient_id, patient_name, patient_problem, patient_bill) values(?, ?, ?, ?)";

				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setInt(1, patient.getPatientId());
				preparedStatement.setString(2, patient.getPatientName());
				preparedStatement.setString(3, patient.getPatientProblem());
				preparedStatement.setDouble(4, patient.getPatientBill());

				preparedStatement.executeUpdate();


				//statements for commit and rollback
				System.out.println("\nwant to 'commit/rollback' the patient object?");

				String commitRollbackResponse = scanner.next().toLowerCase();//Commit

				if(commitRollbackResponse.equals("commit"))
				{
					connection.commit();
				}

				if(commitRollbackResponse.equals("rollback"))
				{
					connection.rollback();
				}

				System.out.println("\nwant to insert patient object? yes/no: ");
				String objectInsertResponse = scanner.next().toLowerCase();

				if(objectInsertResponse.equals("no"))
				{
					break;
				}

			}

			connection.commit();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			scanner.close();
			connection.close();
		}

	}

}
