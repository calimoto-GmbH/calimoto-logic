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

import java.util.ArrayList;
import java.util.List;

/**
 * Interface to access a list of {@link CaloCoordinate}.
 * @param <Coordinate>
 * 		type of the coordinates
 */
public interface CaloCoordinateList<Coordinate extends CaloCoordinate>
{
	/**
	 * Get the size of this list.
	 * @return size of this list
	 */
	public int size();
	
	/**
	 * Get the {@link CaloCoordinate} at the given index.
	 * @param index
	 * 		index of the {@link CaloCoordinate} to get
	 * @return {@link CaloCoordinate} at the given index
	 */
	@NonNull
	public Coordinate get(int index);
	
	/**
	 * Set the {@link CaloCoordinate} at the given index.
	 * @param index
	 * 		index of the {@link CaloCoordinate} to set
	 * @param coordinate
	 * 		{@link CaloCoordinate} to set
	 */
	public void set(int index, @NonNull Coordinate coordinate);
	
	/**
	 * Add the {@link CaloCoordinate} at the given index.
	 * @param index
	 * 		index to add the {@link CaloCoordinate} at
	 * @param coordinate
	 * 		{@link CaloCoordinate} to add
	 */
	public void add(int index, @NonNull Coordinate coordinate);
	
	/**
	 * Add the {@link CaloCoordinate} at the end of the list
	 * @param coordinate
	 * 		{@link CaloCoordinate} to add
	 */
	public default void add(@NonNull Coordinate coordinate)
	{
		add(size(), coordinate);
	}
	
	/**
	 * Add all elements of the given {@link CaloCoordinateList} at the end of this list.
	 * Performs a shallow copy of the elements. <p></p>
	 * For a deep copy or copying a {@link CaloCoordinateList} containing an incompatible type of {@link CaloCoordinate},
	 * use {@link #addAll(CaloCoordinateList, CaloCoordinateFactory)}
	 * @param listToAdd
	 * 			List to be added.
	 */
	public default void addAll(@NonNull final CaloCoordinateList<? extends Coordinate> listToAdd)
	{
		for (int i = 0; i < listToAdd.size(); i++)
		{
			add(listToAdd.get(i));
		}
	}
	
	/**
	 * Add all elements of the given {@link CaloCoordinateList} at the end of this list by cloning the individual elements.
	 * @param listToAdd
	 * 			List to be added.
	 * @param coordinateFactory
	 * 			{@link CaloCoordinateFactory} for cloning the elements
	 */
	public default void addAll(
			@NonNull final CaloCoordinateList<? extends CaloCoordinate> listToAdd,
			@NonNull final CaloCoordinateFactory<Coordinate> coordinateFactory)
	{
		for (int i = 0; i < listToAdd.size(); i++)
		{
			add(coordinateFactory.clone(listToAdd.get(i)));
		}
	}
	
	/**
	 * Remove the element at the given index.
	 * @param index
	 * 		index to remove
	 */
	public void remove(int index);
	
	/**
	 * Remove all elements from this list.
	 */
	public void removeAll();
	
	/**
	 * Transform to a {@link List} of Coordinates
	 */
	@NonNull
	public default List<Coordinate> toList()
	{
		final List<Coordinate> list = new ArrayList<>(this.size());
		for (int i = 0; i < size(); i++)
		{
			list.add(get(i));
		}
		return list;
	}
	
	/**
	 * Wraps a List of Coordinates in a {@link CaloCoordinateList}
	 * @param listOfCoordinates
	 * 			list to wrap
	 * @param <Coordinate>
	 *     		{@link CaloCoordinate} type
	 * @return
	 * 			{@link CaloCoordinateList} wrapping the input list
	 */
	@NonNull
	public static <Coordinate extends CaloCoordinate>
	CaloCoordinateList<Coordinate> fromList(@NonNull final List<Coordinate> listOfCoordinates)
	{
		return CaloCoordinateListFactorySimple.fromList(listOfCoordinates);
	}
	
}
