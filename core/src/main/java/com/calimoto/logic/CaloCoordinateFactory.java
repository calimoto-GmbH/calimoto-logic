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
 * Factory to implement by the client required to work with {@link CaloCoordinate}.
 * @param <Coordinate>
 * 		type of the coordinates
 * @author Luca Osten
 */
public interface CaloCoordinateFactory<Coordinate extends CaloCoordinate>
{
	/**
	 * Create a new {@link CaloCoordinate} instance.
	 * @param latitude
	 * 			latitude of the coordinate
	 * @param longitude
	 * 			longitude of the coordinate
	 * @return new {@link CaloCoordinate} instance
	 */
	@NonNull
	public Coordinate create(double latitude, double longitude);
	
	/**
	 * Create a new {@link CaloCoordinate} instance.
	 * @param coordinate
	 * 			{@link CaloCoordinate} to clone
	 * @return new {@link CaloCoordinate} instance
	 */
	@NonNull
	public default Coordinate clone(@NonNull final CaloCoordinate coordinate)
	{
		return create(coordinate.getLatitude(), coordinate.getLongitude());
	}
	
}
