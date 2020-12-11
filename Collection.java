/**
 * Matala 13 part a:
 * This class defines the object Collection that describes an array of the Box3D
 * defined in Matala 12. 
 * Author: Maayan Chechik 
 * Date: 20/04/19
 */
public class Collection {
	private Box3D[] _boxes;
	private int _noOfBoxes;
	private final int MAX_NUM_BOXES = 100;
	private final int DEFAULT = 0;

	/**
	 * Constructs and initializes the object Collection, constructing an array of
	 * boxes to the maximum length without constructing the boxes in the array, 
	 * therefore initializing the number of boxes to 0.
	 */
	public Collection() {
		_boxes = new Box3D[MAX_NUM_BOXES];
		_noOfBoxes = 0;
	}

	/**
	 * Determines whether or not a box with the given properties can be added to
	 * this Collection. If it can be added, adds the box to this collection in the
	 * correct placement according to its volume.
	 * 
	 * @param p      the base point of the box
	 * @param length the length of the box
	 * @param width  the width of the box
	 * @param height the height of the box
	 * 
	 * @return true if the box with the given properties can be added to this
	 *         Collection, false otherwise
	 */
	public boolean addBox(Point3D p, int length, int width, int height) {
		if (_noOfBoxes == MAX_NUM_BOXES)
			return false;
		Box3D newBox = new Box3D(p, length, width, height);
		// finds the place in the collection's array that the new box should be put
		int place = 0;
		for (int i = 0; i < _noOfBoxes; i++) {
			if (newBox.isLargerCapacity(_boxes[i])) {
				place++;
			}
		}
		// shifts all the boxes after the new box's place one cell forward
		for (int i = _noOfBoxes; i > place; i--) {
			_boxes[i] = new Box3D(_boxes[i - 1]);
		}
		// adds the box in the correct place to this Collection
		_boxes[place] = newBox;
		_noOfBoxes++;// SHAY: Correct
		return true;
	}

	/**
	 * Finds and returns the Box3D in this Collection with the highest base Point3D.
	 * 
	 * @return the box in the Collection with the highest base point, if there
	 *         aren't any boxes in the collection returns null.
	 */
	public Box3D mostUpperBaseCorner() {
		if (_noOfBoxes == 0)
			return null;
		// Find place of box in collection with highest base point
		int highestPlace = 0;
		for (int i = 1; i < _noOfBoxes; i++) {
			if (_boxes[i].getBase().isAbove(_boxes[highestPlace].getBase())) {
				highestPlace = i;
			}
		}
		// copy the box in saved place to avoid aliasing
		Box3D tempHighest = new Box3D(_boxes[highestPlace]);
		return tempHighest;
	}

	/**
	 * Calculates and returns the total surface area of all the boxes in the
	 * Collection.
	 * 
	 * @return the sum of the surface areas of all the boxes in the Collection
	 */
	public int totalSurfaceArea() {
		int sum = 0;
		for (int i = 0; i < _noOfBoxes; i++) {
			sum += _boxes[i].getSurfaceArea();
		}
		return sum;// SHAY: Correct
	}

	/**
	 * Finds and returns the longest distance between two boxes in the Collection
	 * 
	 * 
	 * @return the longest distance between two boxes in this Collection, if there
	 *         aren't two boxes in the collection to measure distance returns default 0.
	 */
	public double longestDistance() {
		if (_noOfBoxes < 2)
			return DEFAULT;
		// goes through all the pairs of boxes to find the longest distance
		double longestDist = 0;
		for (int i = 0; i < _noOfBoxes; i++) {
			for (int j = 0; j < _noOfBoxes; j++) {
				if (_boxes[i].distance(_boxes[j]) > longestDist) {
					longestDist = _boxes[i].distance(_boxes[j]);
				}
			}
		}
		return longestDist;
	}

	/**
	 * Receives a box and returns the number of boxes in the collection that can
	 * contain said box.
	 * 
	 * @param box the Box3D to check how many boxes contain it
	 * @return the number of boxes that can contain the received box
	 */
	public int howManyContains(Box3D box) {
		int canContain = 0;
		for (int i = 0; i < _noOfBoxes; i++) {
			if (_boxes[i].contains(box))
				canContain++;
		}
		return canContain;
	}

	/**
	 * Receives two indexes for the collection's array and returns the volume of the
	 * smallest box that can contain all the boxes in the collection between the two
	 * received indexes.
	 * 
	 * @param i an index in the Collection's array
	 * @param j an index in the Collection's array
	 * @return the volume of the smallest box found to contain all the boxes in the
	 *         collection between indexes i and j. if the indexes do not create a
	 *         legal range of boxes in the collection's array, returns default 0.
	 */
	public int volumeOfSmallestBox(int i, int j) {
		if (i < 0 || j < 0 || i >= _noOfBoxes || j >= _noOfBoxes) {
			return DEFAULT;
		}
		// Determines which index is the start of the range and which is the end 
		int st;
		int end;
		if (i <= j) {
			st = i;
			end = j;
		} else {
			st = j;
			end = i;
		}
		// creates a box with 0 volume and goes through the collection's array to
		// increase volume only when necessary for the box to contain all boxes
		// in the collection.
		Box3D smallContainer = new Box3D();
		for (; st <= end; st++) {
			if (!smallContainer.contains(_boxes[st])) {
				if (smallContainer.getLength() <= _boxes[st].getLength()) {
					smallContainer.setLength(_boxes[st].getLength() + 1);
				}
				if (smallContainer.getWidth() <= _boxes[st].getWidth()) {
					smallContainer.setWidth(_boxes[st].getWidth() + 1);
				}
				if (smallContainer.getHeight() <= _boxes[st].getHeight()) {
					smallContainer.setHeight(_boxes[st].getHeight() + 1);
				}
			}
		}
		// returns the volume of the box after all adjustments have been made
		return smallContainer.getVolume();
	}

	/**
	 * Gets an array of the boxes in this Collection
	 * 
	 * @return the array of boxes
	 */
	public Box3D[] getBoxes() {
		Box3D[] boxes = new Box3D[_noOfBoxes];
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box3D(_boxes[i]);// SHAY: Correct
		}
		return boxes;
	}

	/**
	 * Gets the number of boxes in this Collection
	 * 
	 * @return number of boxes
	 */
	public int getNumOfBoxes() {
		return _noOfBoxes;
	}

	/**
	 * returns a string representation of this Collection
	 * 
	 * @return String "Box no. 1:"+box1.toString+"\n+"Box no. 2:"+box2.toString+"\n+...
	 */
	public String toString() {
		String st = "";
		for (int i = 0; i < _noOfBoxes; i++) {
			st += "Box no. " + (i + 1) + ": " + _boxes[i].toString() + "\n";
		}
		return st;
	}

}