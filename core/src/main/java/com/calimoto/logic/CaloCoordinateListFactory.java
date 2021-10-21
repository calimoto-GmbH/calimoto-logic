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
 * Factory for {@link CaloCoordinateList}
 * @param <Coordinate>
 *     type of {@link CaloCoordinate} contained in the {@link CaloCoordinateList} produced by this factory
 * @param <ListType>
 *     type of {@link CaloCoordinateList} produced by this factory
 */
public interface CaloCoordinateListFactory<Coordinate extends CaloCoordinate, ListType extends CaloCoordinateList<Coordinate>>
{
	/**
	 * Create a new empty {@link CaloCoordinateList}
	 */
	@NonNull
	public ListType create();
	
	/**
	 * Create a new empty {@link CaloCoordinateList} with the specified initial capacity (might be ignored)
	 * @param initialCapacity
	 * 			the initial capacity
	 * @return
	 * 			A new {@link CaloCoordinateList} with the specified initial capacity, if implemented by this list type
	 */
	@NonNull
	public ListType create(int initialCapacity);
	
	/**
	 * Create a deep copy of a {@link CaloCoordinateList}
	 * @param listToClone
	 * 			the list to clone
	 * @param coordinateFactory
	 * 			factory to use for cloning the individual {@link CaloCoordinate}s
	 * @return
	 * 			the cloned list
	 */
	@NonNull
	public default ListType deepCopy(
			@NonNull final CaloCoordinateList<? extends CaloCoordinate> listToClone,
			@NonNull final CaloCoordinateFactory<Coordinate> coordinateFactory)
	{
		ListType list = create(listToClone.size());
		list.addAll(listToClone, coordinateFactory);
		return list;
	}
	
	/**
	 * Create a shallow copy of a {@link CaloCoordinateList}
	 * @param listToClone
	 * 			the list to clone
	 * @return
	 * 		the cloned list
	 */
	@NonNull
	public default ListType shallowCopy(
			@NonNull final CaloCoordinateList<? extends Coordinate> listToClone)
	{
		ListType list = create(listToClone.size());
		list.addAll(listToClone);
		return list;
	}
}
