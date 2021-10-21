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
import java.util.Iterator;
import java.util.List;

/**
 *	Simple implementation of {@link CaloCoordinateListFactory} constructing a wrapper around a {@link List}
 * @param <Coordinate>
 *     type of {@link CaloCoordinate} contained
 *
 * @author Felix Weinreich
 */
public class CaloCoordinateListFactorySimple<Coordinate extends CaloCoordinate>
		implements CaloCoordinateListFactory<Coordinate, CaloCoordinateList<Coordinate>>
{
	/**
	 * Simple Wrapper around a {@link List} of Coordinates
	 * @param <Coordinate>
	 *     type of {@link CaloCoordinate} contained
	 */
	private static class CaloCoordinateListSimple<Coordinate extends CaloCoordinate> implements CaloCoordinateList<Coordinate>
	{
		private final List<Coordinate> list;
		
		private CaloCoordinateListSimple(@NonNull List<Coordinate> list)
		{
			this.list = list;
		}
		
		@Override
		public int size()
		{
			return list.size();
		}
		
		@NonNull
		@Override
		public Coordinate get(int index)
		{
			return list.get(index);
		}
		
		@Override
		public void set(int index, @NonNull Coordinate coordinate)
		{
			list.set(index, coordinate);
		}
		
		@Override
		public void add(int index, @NonNull Coordinate coordinate)
		{
			list.add(index, coordinate);
		}
		
		@Override
		public void remove(int index)
		{
			list.remove(index);
		}
		
		@Override
		public void removeAll()
		{
			list.clear();
		}
		
		@NonNull
		@Override
		public List<Coordinate> toList()
		{
			return this.list;
		}
	}
	
	@NonNull
	@Override
	public CaloCoordinateListSimple<Coordinate> create()
	{
		return new CaloCoordinateListSimple<>(new ArrayList<>());
	}
	
	@NonNull
	@Override
	public CaloCoordinateListSimple<Coordinate> create(int initialCapacity)
	{
		return new CaloCoordinateListSimple<>(new ArrayList<>(initialCapacity));
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
		return new CaloCoordinateListSimple<>(listOfCoordinates);
	}
}
