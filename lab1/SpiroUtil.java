package eecs2030.lab1;

public class SpiroUtil {
	public static final double BIG_WHEEL_RADIUS = 1.0;

	public static double hypoX(double wheelRadius, double pencilRadius, double degrees) {

		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}

		double degRad = Math.toRadians(degrees);

		return (BIG_WHEEL_RADIUS - wheelRadius) * Math.cos(degRad)
				+ pencilRadius * Math.cos(((BIG_WHEEL_RADIUS - wheelRadius) / wheelRadius) * degRad);

	
	}

	public static double hypoY(double wheelRadius, double pencilRadius, double degrees) {
		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}

		double degRad = Math.toRadians(degrees);

		return (BIG_WHEEL_RADIUS - wheelRadius) * Math.sin(degRad)
				- pencilRadius * Math.sin(((BIG_WHEEL_RADIUS - wheelRadius) / wheelRadius) * degRad);

	}

	public static Point2 hypo(double wheelRadius, double pencilRadius, double degrees) {
		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}

		Double x = hypoX(wheelRadius, pencilRadius, degrees);
		Double y = hypoY(wheelRadius, pencilRadius, degrees);
		return new Point2(x, y);
	}
}
