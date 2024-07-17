//CSC 133 - Assignment 2
//Austin Melendez

//Package
package com.csus.csc133;
//Importing Libraries

import java.util.Vector;

public class GameObjectCollection implements ICollection {

	// Vector to keep track of objects
	private Vector<GameObject> objects;
	
	
	// Constructor
	public GameObjectCollection() {
		
		// Create an arrayList of Game Objects so that we can keep track of them without the client knowing the details
		objects = new Vector<GameObject>();
		
	}

	// This method will allow clients to add objects to the data structure
	@Override
	public void add(GameObject object) {

		// Add the given object to the ArrayList
		objects.add(object);
		
	}

	// This method will provide the client with an iterator which they can use to loop through the objects
	@Override
	public IIterator getIterator() {

		// Create a new GameObjectCollectionIterator() object when a client requests an iterator
		return new GameObjectCollectionIterator();
		
	}
	
	
	// Created when client asks for iterator
	private class GameObjectCollectionIterator implements IIterator {
		
		// Keep track of where we are in the Iterator
		private int currElementIndex;
		
		// Constructor
		public GameObjectCollectionIterator() {
			
			// Set the initial index to -1 because we have no objects added yet
			currElementIndex = -1;

		}
		
		
		// Whether the data structure has another object or not
		@Override
		public boolean hasNext() {
			
			// Check to see if the size of the gameObjects array list is 0 or if the index is equal to the size of the array list - 1
			if(objects.size() <= 0 || currElementIndex == objects.size() - 1) {
				
				// Return false if that is correct (no next objects)
				return false;
				
			} else { 
				
				// Return true if that is not correct (are next objects)
				return true;
				
			}
			
		}
		
		
		// This method will provide the client with the next object
		@Override
		public GameObject getNext() {
			
			// Increment the index
			currElementIndex += 1;
			
			// Return the object that is given at the current index
			return objects.get(currElementIndex);
			
		}
		
	}
	
}