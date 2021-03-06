package eecs2030.lab2;

/**
 * A class that represents two dimensional spatial vectors (a direction and a
 * magnitude). Every vector has a real-valued x-component and a y-component. The
 * class provides some basic mathematical operations such as vector addition and
 * subtraction, and scalar multiplicaton.
 * 
 * @author EECS2030 Fall 2016
 * 
 */
public final class Vector2 {
	private double x;
	private double y;

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2() {
		this(0.0, 0.0);
	}

	public Vector2(Vector2 other) {
		this(other.getX(), other.getY());
	}

	/**
	 * Returns the x component of the vector.
	 * 
	 * @return the x component of the vector.
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Returns the y component of the vector.
	 * 
	 * @return the y component of the vector.
	 */
	public double getY() {
		return this.y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2 subtract(Vector2 other) {
		set(this.getX() - other.getX(), this.getY() - other.getY());
		return this;
	}

	public Vector2 add(Vector2 other) {
		set(this.getX() + other.getX(), this.getY() + other.getY());
		return this;
	}

	public Vector2 multiply(double s) {
		set(this.getX() * s, this.getY() * s);
		return this;
	}

	public double mag() {
		return Math.hypot(this.getX(), this.getY());
	}

	public static Vector2 add(Vector2 a, Vector2 b) {
		return new Vector2(a.getX() + b.getX(), a.getY() + b.getY());
	}

	public static Vector2 subtract(Vector2 a, Vector2 b) {
		return new Vector2(a.getX() - b.getX(), a.getY() - b.getY());
	}

	public static Vector2 multiply(double s, Vector2 a) {
		return new Vector2(a.getX() * s, a.getY() * s);
	}

	public static Vector2 dirVector(double theta) {
		double rad = Math.toRadians(theta);
		return new Vector2(Math.cos(rad), Math.sin(rad));
	}

	@Override
	public int hashCode() {
		return (int) (100 * (this.getX() + this.getY()));
	}

	public boolean equals(java.lang.Object obj) {
		if (obj != null && obj.getClass() == Vector2.class) {
			Vector2 vectorObj = (Vector2) obj;
			return this.getX() == vectorObj.getX() && this.getY() == vectorObj.getY();
		}
		return false;
	}

	public boolean similarTo(Vector2 other, double tol) {
		if (Math.abs(this.mag() - other.mag()) < tol) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a string representation of the vector. The string is the name of
	 * the vector, followed by the comma separated components of the vector
	 * inside parentheses.
	 * 
	 * @return a string representation of the vector
	 */
	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}

}
