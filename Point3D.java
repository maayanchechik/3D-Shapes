/**
 * This class represents a three-dimensional point the x,y and z coordinate
 * values can get either negative, positive or zero double values.
 * 
 * @author Maayan Chechik ID : 214307472 Version 29.03.19
 */
public class Point3D {
	private double _x;
	private double _y;
	private double _z;

	/**
	 * Constructs and initializes a Point3D to (0,0,0).
	 */
	public Point3D() {
		final double DEFAULT_NUM = 0;
		_x = DEFAULT_NUM;
		_y = DEFAULT_NUM;
		_z = DEFAULT_NUM;
	}

	/**
	 * Constructs and initializes a Point3D from the specified xyz coordinates.
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 */
	public Point3D(double x, double y, double z) {
		_x = x;
		_y = y;
		_z = z;
	}
// SHAY: Correct
	/**
	 * Constructs and initializes a Point3D according to the specified Point3D.
	 * 
	 * @param other the Point3D which the new instance initialization will be based
	 *              on
	 */
	public Point3D(Point3D other) {
		_x = other._x;
		_y = other._y;
		_z = other._z;
	}

	/**
	 * @return the x coordinate
	 */
	public double getX() {
		return _x;
	}

	/**
	 * @return the y coordinate
	 */
	public double getY() {
		return _y;
	}

	/**
	 * @return the z coordinate
	 */
	public double getZ() {
		return _z;
	}

	/**
	 * sets the x coordinate to the given x
	 * 
	 * @param num x value to set
	 */
	public void setX(double num) {
		_x = num;
	}

	/**
	 * sets the y coordinate to the given y
	 * 
	 * @param num y value to set
	 */
	public void setY(double num) {
		_y = num;
	}

	/**
	 * sets the z coordinate to the given y
	 * 
	 * @param num z value to set
	 */
	public void setZ(double num) {
		_z = num;
	}

	/**
	 * Returns a string representation of this Point3D.
	 * 
	 * @return a string representation of this Point3D.
	 */
	public String toString() {
		return "(" + _x + "," + _y + "," + _z + ")";
	}

	/**
	 * Determines whether or not two points are equal.
	 * 
	 * @param other a Point3D object to be compared with this Point3D
	 * 
	 * @return true if this Point is equal to other point, false otherwise
	 */

	public boolean equals(Point3D other) {
		return ((_x == other._x) && (_y == other._y) && (_z == other._z));
	}
// SHAY: Correct
	/**
	 * Checks if this point is above the other point.
	 * 
	 * @param other The point to check whether this point is above it
	 * @return true if this point is above the other point, false otherwise
	 */
	public boolean isAbove(Point3D other) {
		if (_z > other._z) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if this point is under the other point.
	 * 
	 * @param other The point to check whether this point is under it
	 * @return true if this point is under the other point, false otherwise
	 */
	public boolean isUnder(Point3D other) {
		if (isAbove(other) || _z == other._z) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if this point is to the left of the other point.
	 * 
	 * @param other The point to check whether this point is left of it
	 * @return true if this point is to the left of the other point, false otherwise
	 */
	public boolean isLeft(Point3D other) {
		if (_y < other._y) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if this point is to the right of the other point.
	 * 
	 * @param other The point to check whether this point is right of it
	 * @return true if this point is to the right of the other point, false
	 *         otherwise
	 */
	public boolean isRight(Point3D other) {
		if (isLeft(other) || _y==other._y) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if this point is behind the other point.
	 * 
	 * @param other The point to check whether this point behind it
	 * @return true if this point is behind the other point, false otherwise
	 */
	public boolean isBehind(Point3D other) {
		if (_x < other._x) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if this point is in front of the other point.
	 * 
	 * @param other The point to check if this point is in front of it
	 * @return true if this point is in front of the other point, false otherwise
	 */
	public boolean isInFrontOf(Point3D other) {
		if (isBehind(other) || _x==other._x) {
			return false;
		}
		return true;
	}

	/**
	 * Moves the Point3D in location (x,y,z), by dx along the x axis, by dy along
	 * the y axis and dz along the z axis so that it now represents the Point3D in
	 * the following 3D coordinates (x+dx,y+dy,z+dz).
	 * 
	 * @param dx the addition for coordinate x value
	 * @param dy the addition for coordinate y value
	 * @param dx the addition for coordinate z value
	 */
	public void move(double dx, double dy, double dz) {
		_x += dx;
		_y += dy;
		_z += dz;
	}

	/**
	 * Returns the distance between this point and other point p.
	 * 
	 * @param p the other point
	 * 
	 * @return the distance between this point and point p
	 */
	public double distance(Point3D p) {
		final int SQUARE = 2;
		double xs = Math.pow((_x - p._x), SQUARE);
		double ys = Math.pow((_y - p._y), SQUARE);
		double zs = Math.pow((_z - p._z), SQUARE);
		double distance = Math.sqrt(xs + ys + zs);
		return distance; // ((X1-X2)^2 + (Y1-Y2)^2 + (Z1-Z2)^2)^0.5 - coordinate1 = coordinate and
							// coordinate2 = other point's coordinate
	}

} // End of class Point3D