/**
 * This class represents a three-dimensional box The box is represented by its
 * lower-left-front point and three integers for the length (x axis), width (y
 * axis) and height (z axis) of the box. the box dimensions must be equal or
 * greater than 1.
 * 
 * @author Maayan Chechik ID : 214307472 Version 29.03.19
 */
public class Box3D {
	private Point3D _base;
	private int _length;
	private int _width;
	private int _height;

	/**
	 * Constructs and initializes a box with a default base point and all dimensions
	 * to 1.
	 */
	public Box3D() {
		final int size = 1;
		_base = new Point3D();// SHAY: Correct
		_length = size;
		_width = size;
		_height = size;
	}

	/**
	 * Constructs and initializes a box object from a given base point and 3
	 * integers as the dimensions of the Box
	 * 
	 * @param p the base point of the box
	 * @param length the length of the box
	 * @param width  the width of the box
	 * @param height the height of the box
	 */
	public Box3D(Point3D p, int length, int width, int height) {
		_base = new Point3D(p.getX(), p.getY(), p.getZ());
		if (length > 0) {
			_length = length;
		} else {
			_length = 1;
		}
		if (width > 0) {
			_width = width;
		} else {
			_width = 1;
		}
		if (height > 0) {
			_height = height;
		} else {
			_height = 1;
		}// SHAY: Correct
	}

	/**
	 * Constructs and initializes a Box3D object from a given Box3D.
	 * 
	 * @param other the box to copy from. Contains the initialization of the base
	 *              point and all dimensions.
	 */
	public Box3D(Box3D other) {
		_base = new Point3D(other._base.getX(), other._base.getY(), other._base.getZ());
		_length = other._length;
		_width = other._width;
		_height = other._height;
	}// SHAY: Correct

	/**
	 * returns the length dimension
	 * 
	 * @return the length of the box
	 */
	public int getLength() {
		return _length;
	}

	/**
	 * returns the width dimension
	 * 
	 * @return the width of the box
	 */
	public int getWidth() {
		return _width;
	}

	/**
	 * returns the height dimension
	 * 
	 * @return the height of the box
	 */
	public int getHeight() {
		return _height;
	}

	/**
	 * returns the lower-left-front (base) Point3D of the box
	 * 
	 * @return the base point of the box
	 */
	public Point3D getBase() {
		Point3D tempBase = new Point3D(_base);
		return tempBase;// SHAY: Correct
	}

	/**
	 * Sets the length of the box only if the given value is equal or greater than
	 * 1.
	 * 
	 * @param num the length to set
	 */
	public void setLength(int num) {
		if (num > 0) {
			_length = num;
		}
	}

	/**
	 * Sets the width of the box only if the given value is equal or greater than 1.
	 * 
	 * @param num the width to set
	 */
	public void setWidth(int num) {
		if (num > 0) {
			_width = num;
		}
	}

	/**
	 * Sets the height of the box only if the given value is equal or greater than
	 * 1.
	 * 
	 * @param num the height to set
	 */
	public void setHeight(int num) {
		if (num > 0) {
			_height = num;
		}
	}

	/**
	 * Sets the base point of the box
	 * 
	 * @param p the Point3D to set
	 */
	public void setBase(Point3D p) {
		Point3D tempBase = new Point3D(p);
		_base = tempBase;// SHAY: Correct
	}

	/**
	 * Returns a string representation of this Box3D object.
	 * 
	 * @return a string representation of this Box3D object.
	 */
	public String toString() // Use toString of Point3D
	{
		String result = "The base point is " + _base.toString() + ", length = " + _length + ", width = " + _width
				+ ", height = " + _height;
		return result;
	}// SHAY: Correct

	/**
	 * Determines whether or not the two boxes are equal.
	 * 
	 * @param other a Box3D object to be compared with this Box3D
	 * 
	 * @return true if this box is equal to other box, false otherwise
	 */
	public boolean equals(Box3D other) {
		boolean eqBases = _base.equals(other._base);// SHAY: Correct
		boolean eqLengths = _length == other._length;
		boolean eqWidths = _width == other._width;
		boolean eqHeights = _height == other._height;
		return eqBases && eqLengths && eqWidths && eqHeights;
	}

	/**
	 * Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) without
	 * changing the box dimensions
	 * 
	 * @return the new box in its new location
	 */
	public Box3D move(double dx, double dy, double dz) {
		Box3D tempBox = new Box3D(this);
		tempBox._base.move(dx, dy, dz);
		return tempBox;// SHAY: Correct
	}

	/**
	 * Calculates and returns the upper-right-back point of this box
	 * 
	 * @return the upper-right-back point of this box
	 */
	public Point3D getUpRightBackPoint() {
		Point3D farPoint = new Point3D(_base);
		farPoint.move(-_length, _width, _height);
		return farPoint;
	}

	/**
	 * Calculates and returns the center point of the box
	 * 
	 * @return the center point of the box
	 */
	public Point3D getCenter() {
		Point3D centerPoint = new Point3D(_base);
		centerPoint.move(-_length / 2.0, _width / 2.0, _height / 2.0);
		return centerPoint;
	}

	/**
	 * Computes the distance between two boxes based on the distance of their center
	 * points.
	 * 
	 * @return the distance between two Box3D objects
	 */
	public double distance(Box3D other) {
		double distance = getCenter().distance(other.getCenter());
		return distance;
	}

	/**
	 * Computes the volume of the box.
	 * 
	 * @return volume of the Box3D object
	 */
	public int getVolume() {
		// The volume of of a box is length*width*height.
		return _length * _width * _height; 
	}

	/**
	 * Computes the surface area of a box.
	 * 
	 * @return the surface area of a Box3D object
	 */
	public int getSurfaceArea() {
		// The surface area of a box is 2[(height*width)+(height*length)+(width*length)].
		int frontArea = _width * _height;
		int upArea = _width * _length;
		int sideArea = _length * _height;
		int surfaceArea = 2 * (frontArea + upArea + sideArea);
		return surfaceArea;
	}

	/**
	 * Determines whether this box has a greater volume in compare to other box.
	 * 
	 * @param other a Box3D object whose volume will be compared with the volume of
	 *              this Box3D
	 *              
	 * @return true if this box has a greater volume than other box, otherwise false
	 */
	public boolean isLargerCapacity(Box3D other) {
		return getVolume() > other.getVolume();
	}

	/**
	 * Determines whether this box can contain the other box.
	 * 
	 * @param other a Box3D object to check if it can be contained within this box
	 * 
	 * @return true if this box can contain other box, otherwise false
	 */
	public boolean contains(Box3D other) {
		return (_length > other._length) && (_width > other._width) && (_height > other._height);
	}

	/**
	 * Checks if this box is above the other box
	 * 
	 * @param other The box to check if this box is above it
	 * @return true if this box is above the other box, false otherwise
	 */
	public boolean isAbove(Box3D other) {
		Point3D topOther = other.getUpRightBackPoint();
		return _base.isAbove(topOther);
	}

}