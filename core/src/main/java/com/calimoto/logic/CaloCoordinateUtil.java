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

/**
 * Util class to perform distance calculations.
 * @author Luca Osten
 */
public class CaloCoordinateUtil
{
	/**
	 * Pre calculation for 2 * PI
	 */
	private static final double RES_2xPI = 2.0 * CaloMath.PI;
	
	/**
	 * Pre calculation for PI / 180
	 */
	private static final double RES_PId180 = CaloMath.PI / 180.0;
	
	/**
	 * Pre calculation for 90 / PI
	 */
	private static final double RES_90dPI = 90.0 / CaloMath.PI;
	
	/**
	 * Pre calculation for 360 / PI
	 */
	private static final double RES_360dPI = 360.0 / CaloMath.PI;
	
	/**
	 * Normalize the latitude so a lat|lon coordinate can be used like a x|y point.
	 * @param latitude
	 * 		latitude to normalize
	 * @return normalized latitude
	 */
	public static double normalizeLatitude(final double latitude)
	{
		final double sinus = CaloMath.sin(latitude * RES_PId180);
		final double normalized = RES_90dPI * CaloMath.log((1 + sinus) / (1 - sinus));
		return CaloMath.min(CaloMath.max(-180, normalized), 180);
	}
	
	/**
	 * Denormalize the latitude which essentially reverts {@link #normalizeLatitude(double)}.
	 * @param latitude
	 * 		latitude to denormalize
	 * @return denormalized latitude
	 */
	public static double denormalizeLatitude(final double latitude)
	{
		final double y = latitude / 360;
		return 90 - RES_360dPI * CaloMath.atan(CaloMath.exp(-y * RES_2xPI));
	}
	
	/**
	 * Calculate the distance between to locations.
	 * @param start
	 * 		{@link CaloCoordinate} of the starting location
	 * @param end
	 * 		{@link CaloCoordinate} of the ending location
	 * @return distance between the locations in meters
	 */
	public static double calculateDistance(
			@NonNull final CaloCoordinate start,
			@NonNull final CaloCoordinate end)
	{
		final double p = 0.017453292519943295; // CaloMath.PI / 180
		final double a = 0.5 - CaloMath.cos((end.getLatitude() - start.getLatitude()) * p) / 2
				+ CaloMath.cos(start.getLatitude() * p) * CaloMath.cos(end.getLatitude() * p)
				* (1 - CaloMath.cos((end.getLongitude() - start.getLongitude()) * p)) / 2;
		return 12742000.0 * CaloMath.asin(CaloMath.sqrt(a)); // 2 * R; R = 6371000 meters
	}
	
	/**
	 * Get the length of 1 degree of latitude in meters.
	 * @return length of 1 degree of latitude in meters
	 */
	public static double lengthLatitudeInMeters()
	{
		return 111132.954;
	}
	
	/**
	 * Get the length of 1 degree of longitude in meters.
	 * @param latitude
	 * 		latitude at which to get the longitude length
	 * @return length of 1 degree of longitude in meters
	 */
	public static double lengthLongitudeInMeters(final double latitude)
	{
		return 40075.017 * CaloMath.cos(latitude) / 360.0;
	}
	
}
