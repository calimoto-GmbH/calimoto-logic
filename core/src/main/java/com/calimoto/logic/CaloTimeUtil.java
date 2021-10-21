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
 * Util class for time operations.
 * @author Luca Osten
 */
public class CaloTimeUtil
{
	// pre calculated time units in milliseconds
	private static final long SECOND_IN_MILLIS = 1000L;
	private static final long MINUTE_IN_MILLIS = 60L * SECOND_IN_MILLIS;
	private static final long HOUR_IN_MILLIS = 60L * MINUTE_IN_MILLIS;
	private static final long DAY_IN_MILLIS = 24L * HOUR_IN_MILLIS;
	private static final long WEEK_IN_MILLIS = 7L * DAY_IN_MILLIS;
	
	/**
	 * Convert the given number of seconds into milliseconds.
	 * @param seconds
	 * 		number of seconds to convert
	 * @return given number of seconds into milliseconds
	 */
	public static long secondsToMillis(final int seconds)
	{
		return SECOND_IN_MILLIS * seconds;
	}
	
	/**
	 * Convert the given number of minutes into milliseconds.
	 * @param minutes
	 * 		number of minutes to convert
	 * @return given number of minutes into milliseconds
	 */
	public static long minutesToMillis(final int minutes)
	{
		return MINUTE_IN_MILLIS * minutes;
	}
	
	/**
	 * Convert the given number of hours into milliseconds.
	 * @param hours
	 * 		number of hours to convert
	 * @return given number of hours into milliseconds
	 */
	public static long hoursToMillis(final int hours)
	{
		return HOUR_IN_MILLIS * hours;
	}
	
	/**
	 * Convert the given number of days into milliseconds.
	 * @param days
	 * 		number of days to convert
	 * @return given number of days into milliseconds
	 */
	public static long daysToMillis(final int days)
	{
		return DAY_IN_MILLIS * days;
	}
	
	/**
	 * Convert the given number of weeks into milliseconds.
	 * @param weeks
	 * 		number of weeks to convert
	 * @return given number of weeks into milliseconds
	 */
	public static long weeksToMillis(final int weeks)
	{
		return WEEK_IN_MILLIS * weeks;
	}
	
}
