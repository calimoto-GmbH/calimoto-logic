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
 * A simple pair of a start and end {@link CaloCoordinate}.
 * @author Luca Osten
 */
public class CaloCoordinatePair
{
	// attributes
	@NonNull
	public final CaloCoordinate coordinateStart;
	@NonNull
	public final CaloCoordinate coordinateEnd;
	@NonNull
	public final String key;
	
	/**
	 * Create a new {@link CaloCoordinatePair} instance.
	 * @param coordinateStart
	 * 		start {@link CaloCoordinate}
	 * @param coordinateEnd
	 * 		end {@link CaloCoordinate}
	 */
	public CaloCoordinatePair(
			@NonNull final CaloCoordinate coordinateStart,
			@NonNull final CaloCoordinate coordinateEnd)
	{
		this.coordinateStart = coordinateStart;
		this.coordinateEnd = coordinateEnd;
		this.key = coordinateStart.getLatitude() + "," + coordinateStart.getLongitude() + "|" +
				coordinateEnd.getLatitude() + "," + coordinateEnd.getLongitude();
	}
	
	@Override
	public boolean equals(final Object other)
	{
		if (this == other)
		{
			return true;
		}
		if (!(other instanceof CaloCoordinatePair))
		{
			return false;
		}
		final CaloCoordinatePair coordinatePair = (CaloCoordinatePair) other;
		return this.key.equals(coordinatePair.key);
	}
	
	@Override
	public int hashCode()
	{
		return this.key.hashCode();
	}
	
	@NonNull
	@Override
	public String toString()
	{
		return this.key;
	}
	
}
