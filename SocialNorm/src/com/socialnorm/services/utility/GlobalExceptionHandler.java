package com.socialnorm.services.utility;
/**
 * Trevor Moore
 * CST-341
 * 11/8/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * Global exception handler that extends RuntimeException. We used the following resources for GEH:
 * https://www.tutorialspoint.com/spring/spring_exception_handling_example.htm
 * @author Trevor
 *
 */
public class GlobalExceptionHandler extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String exceptionMsg;
	   
	/**
	 * Constructor for class, passing in string arg
	 * @param exceptionMsg type String
	 */
	public GlobalExceptionHandler(String exceptionMsg)
	{
		this.exceptionMsg = exceptionMsg;
	}
	/**
	 * Getter for message
	 * @return String
	 */
	public String getExceptionMsg()
	{
		return this.exceptionMsg;
	}
	/**
	 * Setter for message
	 * @param exceptionMsg type String
	 */
	public void setExceptionMsg(String exceptionMsg)
	{
		this.exceptionMsg = exceptionMsg;
	}
}
