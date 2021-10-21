/*
 *  Licensed to calimoto GmbH under one or more contributor
 *  license agreements. See the LICENSE file distributed with this work for
 *  additional information regarding copyright ownership.
 *
 *  calimoto GmbH licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.calimoto.logic;

/**
 * Custom math class to use instead of the {@link Math} class in case translation tool fails to
 * convert the math functions for Swift or Java Script.
 * @author Luca Osten
 */
public class CaloMath
{
	/**
	 * Value of pi
	 */
	public static final double PI = Math.PI;
	
	/**
	 * Value of Euler's number
	 */
	public static final double E = Math.E;
	
	/**
	 * Return the maximum value of the given values.
	 * @param value
	 * 		value to compare
	 * @param other
	 * 		other value to compare
	 * @return maximum value of the given values
	 */
	public static double max(final double value, final double other)
	{
		return Math.max(value, other);
	}
	
	/**
	 * Return the maximum value of the given values.
	 * @param value
	 * 		value to compare
	 * @param other
	 * 		other value to compare
	 * @return maximum value of the given values
	 */
	public static int max(final int value, final int other)
	{
		return Math.max(value, other);
	}
	
	/**
	 * Return the minimum value of the given values.
	 * @param value
	 * 		value to compare
	 * @param other
	 * 		other value to compare
	 * @return minimum value of the given values
	 */
	public static double min(final double value, final double other)
	{
		return Math.min(value, other);
	}
	
	/**
	 * Return the minimum value of the given values.
	 * @param value
	 * 		value to compare
	 * @param other
	 * 		other value to compare
	 * @return minimum value of the given values
	 */
	public static int min(final int value, final int other)
	{
		return Math.min(value, other);
	}
	
	/**
	 * Return the clamped value that lies between the given minimum and maximum.
	 * @param value
	 * 		value to clamp
	 * @param min
	 * 		minimum allowed
	 * @param max
	 * 		maximum allowed
	 * @return clamped value
	 */
	public static int clamp(final int value, final int min, final int max)
	{
		return Math.max(Math.min(value, max), min);
	}
	
	/**
	 * Return the clamped value that lies between the given minimum and maximum.
	 * @param value
	 * 		value to clamp
	 * @param min
	 * 		minimum allowed
	 * @param max
	 * 		maximum allowed
	 * @return clamped value
	 */
	public static double clamp(final double value, final double min, final double max)
	{
		return Math.max(Math.min(value, max), min);
	}
	
	/**
	 * Return the floored value of the given value.
	 * @param value
	 * 		value to floor
	 * @return floored value
	 */
	public static double floor(final double value)
	{
		return Math.floor(value);
	}
	
	/**
	 * Return the ceiled value of the given value.
	 * @param value
	 * 		value to ceil
	 * @return ceiled value
	 */
	public static double ceil(final double value)
	{
		return Math.ceil(value);
	}
	
	/**
	 * Calculate the absolute value of the given value.
	 * @param value
	 * 		value to use
	 * @return absolute value of the given value
	 */
	public static double abs(final double value)
	{
		return Math.abs(value);
	}
	
	/**
	 * Calculate the sine of the given value.
	 * @param value
	 * 		value to use
	 * @return sine of the given value
	 */
	public static double sin(final double value)
	{
		return Math.sin(value);
	}
	
	/**
	 * Calculate the cosine of the given value.
	 * @param value
	 * 		value to use
	 * @return cosine of the given value
	 */
	public static double cos(final double value)
	{
		return Math.cos(value);
	}
	
	/**
	 * Calculate the tangent of the given value.
	 * @param value
	 * 		value to use
	 * @return tangent of the given value
	 */
	public static double tan(final double value)
	{
		return Math.tan(value);
	}
	
	/**
	 * Calculate the arc sine of the given value.
	 * @param value
	 * 		value to use
	 * @return arc sine of the given value
	 */
	public static double asin(final double value)
	{
		return Math.asin(value);
	}
	
	/**
	 * Calculate the arc cosine of the given value.
	 * @param value
	 * 		value to use
	 * @return arc cosine of the given value
	 */
	public static double acos(final double value)
	{
		return Math.acos(value);
	}
	
	/**
	 * Calculate the arc tangent of the given value.
	 * @param value
	 * 		value to use
	 * @return arc tangent of the given value
	 */
	public static double atan(final double value)
	{
		return Math.atan(value);
	}
	
	/**
	 * Calculate the arc tangent of the given x / y value.
	 * @param y
	 * 		y value to use
	 * @param x
	 * 		x value to use
	 * @return arc tangent of the given value
	 */
	public static double atan2(final double y, final double x)
	{
		return Math.atan2(y, x);
	}
	
	/**
	 * Convert the given angle from radians to degrees.
	 * @param radians
	 * 		angle in radians to convert
	 * @return angle in degrees
	 */
	public static double toDegrees(final double radians)
	{
		return Math.toDegrees(radians);
	}
	
	/**
	 * Convert the given angle from degrees to radians.
	 * @param degrees
	 * 		angle in degrees to convert
	 * @return angle in radians
	 */
	public static double toRadians(final double degrees)
	{
		return Math.toRadians(degrees);
	}
	
	/**
	 * Calculate Euler's number raised to the given power.
	 * @param power
	 * 		power to use
	 * @return Euler's number raised to the given power
	 */
	public static double exp(final double power)
	{
		return Math.exp(power);
	}
	
	/**
	 * Calculate the natural logarithm of the given value.
	 * @param value
	 * 		value to use
	 * @return natural logarithm of the given value
	 */
	public static double log(final double value)
	{
		return Math.log(value);
	}
	
	/**
	 * Calculate the square root of the given value.
	 * @param value
	 * 		value to use
	 * @return square root of the given value
	 */
	public static double sqrt(final double value)
	{
		return Math.sqrt(value);
	}
	
	/**
	 * Calculate the power of the given value.
	 * @param value
	 * 		value to use
	 * @param exponent
	 * 		exponent to use
	 * @return power of the given value
	 */
	public static double pow(final double value, final double exponent)
	{
		return Math.pow(value, exponent);
	}
	
	/**
	 * Function to round number to a certain decimal place.
	 * @param value
	 * 		double value that should be rounded
	 * @param decimalPlaces
	 * 		number of decimal places (may also be a negative number)
	 * @return rounded double value
	 */
	public static double roundDouble(final double value, final int decimalPlaces)
	{
		return Math.round(value * pow(10, decimalPlaces)) / pow(10, decimalPlaces);
	}
	
	/**
	 * Round the given double value to the nearest long value.
	 * @param value
	 * 		double value to round
	 * @return nearest long value
	 */
	public static long round(final double value)
	{
		return Math.round(value);
	}
	
	/**
	 * Returns a pseudo-random double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
	 * @return
	 * 		The random value
	 */
	public static double random()
	{
		return Math.random();
	}
	
}
