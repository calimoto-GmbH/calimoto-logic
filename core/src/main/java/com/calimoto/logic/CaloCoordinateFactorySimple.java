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
 * Simple implementation of a {@link CaloCoordinateFactory}.
 * @author Luca Osten
 */
public class CaloCoordinateFactorySimple implements CaloCoordinateFactory<CaloCoordinate>
{
	/**
	 * Simple implementation of a {@link CaloCoordinate}.
	 * @author Luca Osten
	 */
	private static class CaloCoordinateSimple implements CaloCoordinate
	{
		// attributes
		private final double latitude;
		private final double longitude;
		
		/**
		 * Create a new {@link CaloCoordinateSimple} instance.
		 * @param latitude
		 * 		latitude of the coordinate
		 * @param longitude
		 * 		longitude of the coordinate
		 */
		private CaloCoordinateSimple(final double latitude, final double longitude)
		{
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		@NonNull
		@Override
		public CaloCoordinate getCoordinate()
		{
			return this;
		}
		
		@Override
		public double getLatitude()
		{
			return this.latitude;
		}
		
		@Override
		public double getLongitude()
		{
			return this.longitude;
		}
		
	}
	
	/**
	 * Singleton instance of {@link CaloCoordinateFactorySimple}.
	 */
	public static final CaloCoordinateFactorySimple INSTANCE = new CaloCoordinateFactorySimple();
	
	/**
	 * Private constructor so only singleton instance exists.
	 */
	private CaloCoordinateFactorySimple()
	{
		// empty constructor
	}
	
	@NonNull
	@Override
	public CaloCoordinate create(final double latitude, final double longitude)
	{
		return new CaloCoordinateSimple(latitude, longitude);
	}
	
}
