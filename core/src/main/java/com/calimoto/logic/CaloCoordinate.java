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

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * Simple coordinate to implement by the client with a latitude and a longitude to work with coordinates.
 * @author Luca Osten
 */
public interface CaloCoordinate
{
	/**
	 * Compare the given {@link CaloCoordinate} objects, e.g. for {@link Comparable#compareTo(Object)}.
	 * @param coordinate
	 * 		{@link CaloCoordinate} to compare
	 * @param other
	 * 		other {@link CaloCoordinate} to compare
	 * @return {@link Double#compare(double, double)} for latitude (if equal for longitude)
	 */
	public static int compareTo(
			@NonNull final CaloCoordinate coordinate,
			@NonNull final CaloCoordinate other)
	{
		final int compare = Double.compare(coordinate.getLatitude(), other.getLatitude());
		if (compare == 0)
		{
			return Double.compare(coordinate.getLongitude(), other.getLongitude());
		}
		return compare;
	}
	
	/**
	 * Create a hash for the given {@link CaloCoordinate}.
	 * @param coordinate
	 * 		{@link CaloCoordinate} to create hash for
	 * @return hash for the given {@link CaloCoordinate}
	 */
	public static int hash(@NonNull final CaloCoordinate coordinate)
	{
		return Objects.hash(coordinate.getLatitude(), coordinate.getLongitude());
	}
	
	/**
	 * Create a string for the given {@link CaloCoordinate}.
	 * @param coordinate
	 * 		{@link CaloCoordinate} to create string for
	 * @return string for the given {@link CaloCoordinate}
	 */
	@NonNull
	public static String toString(@NonNull final CaloCoordinate coordinate)
	{
		return coordinate.getLatitude() + ", " + coordinate.getLongitude();
	}
	
	/**
	 * Check if the given {@link CaloCoordinate} is at the same location.
	 * @param coordinate
	 * 		{@link CaloCoordinate} to compare
	 * @return true if the given {@link CaloCoordinate} is at the same location, else false
	 */
	public default boolean sameLocation(@NonNull final CaloCoordinate coordinate)
	{
		return CaloMath.abs(getLatitude() - coordinate.getLatitude()) < 0.0000011
				&& CaloMath.abs(getLongitude() - coordinate.getLongitude()) < 0.0000011;
	}
	
	/**
	 * Get the {@link CaloCoordinate} of this coordinate.
	 * @return {@link CaloCoordinate} of this coordinate
	 */
	@NonNull
	public CaloCoordinate getCoordinate();
	
	/**
	 * Get the latitude of the coordinate.
	 * @return latitude of the coordinate
	 */
	public double getLatitude();
	
	/**
	 * Get the longitude of the coordinate.
	 * @return longitude of the coordinate
	 */
	public double getLongitude();
	
}
