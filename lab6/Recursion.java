package eecs2030.lab6;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A utility class containing recursive methods.
 * 
 * @author EECS2030 Fall 2016
 *
 */
public class Recursion {

	// DON'T ADD ANY STATIC FIELDS; YOU DON'T STATIC FIELDS AND YOUR METHODS
	// WON'T WORK CORRECTLY IF YOU USE STATIC FIELDS

	private Recursion() {
		// empty by design
	}

	/**
	 * Return the sum of the integers 1 through n where n is a strictly positive
	 * integer. Note that the sum might overflow if n is too large; this method
	 * does not check if the sum overflows (i.e., it's the client's problem).
	 * 
	 * @pre n is greater than 0
	 * 
	 * @param n
	 *            a strictly positive number
	 * @return the sum 1 + 2 + ... + n
	 */
	public static int sum(int n) {
		int sum;

		if (n == 0) {
			sum = 0;
		} else if (n == 1) {
			sum = 1;
		} else {
			sum = n + sum(n - 1);
		}
		return sum;
	}

	/**
	 * Returns a new string equal to the reversal of string s. The reversal of
	 * the empty string is equal to the empty string.
	 * 
	 * @pre s is not null
	 * 
	 * @param s
	 *            a string
	 * @return a string equal to the reversal of s
	 */
	public static String reverse(String s) {
		if (s.length() <= 1) {
			return s;
		} else {
			return reverse(s.substring(1)) + s.charAt(0);
		}

	}

	/**
	 * Returns the minimum element in the list t. This method does not modify
	 * the list <code>t</code>.
	 * 
	 * @pre t.size() is greater than 0
	 * 
	 * @param t
	 *            a non-empty list
	 * @return the minimum element in t
	 */
	public static int min(List<Integer> t) {
		int minimum;
		if (t.size() == 1) {
			minimum = t.get(0);
		} else {
			List<Integer> u = new ArrayList<Integer>(t.subList(1, t.size()));
			minimum = Math.min(t.get(0), Collections.min(u));
		}
		return minimum;
	}

	/**
	 * Downsample a picture <code>n</code> times by a factor of 2 using
	 * recursion. See the lab problem for a description of downsampling.
	 * 
	 * @pre the width and height of the picture are both multiples of 2 to the
	 *      power n
	 * 
	 * @pre1 n is greater than or equal to zero
	 * 
	 * @param p
	 *            the picture to downsample
	 * @param n
	 *            the number of times to downsample the picture by a factor of 2
	 * @return the downsampled picture
	 */
	public static Picture downsample(Picture p, int n) {
		if (n == 0) {
			return p;
		} else {
			for (int i = 0; i < p.height(); i += 2) {
				for (int j = 0; j < p.width(); j += 2) {
					Color c1 = p.get(i, j);
					Color c2 = p.get(i, j + 1);
					Color c3 = p.get(i + 1, j);
					Color c4 = p.get(i + 1, j + 1);

					int r = c1.getRed() + c2.getRed() + c3.getRed() + c4.getRed();
					int g = c1.getGreen() + c2.getGreen() + c3.getGreen() + c4.getGreen();
					int b = c1.getBlue() + c2.getBlue() + c3.getBlue() + c4.getBlue();

					Color avg = new Color(r / 4, g / 4, b / 4);

					p.set(i, j, avg);
					p.set(i, j + 1, avg);
					p.set(i + 1, j, avg);
					p.set(i + 1, j + 1, avg);
				}

			}

		}
		return downsample(p, n - 1);

	}

	/**
	 * Binary search for the string <code>s</code> in a list <code>t</code>. If
	 * <code>s</code> is in the list, then this method returns the index of the
	 * location of <code>s</code> in <code>t</code>; otherwise, this method
	 * returns the index where <code>s</code> would be located if it were to be
	 * inserted into the list <code>t</code>.
	 * 
	 * <p>
	 * This method does not modify the list <code>t</code>.
	 * 
	 * @pre t.size() is zero or more
	 * @pre1 t is in sorted order
	 * @pre2 t has no duplicate elements
	 * 
	 * @param s
	 *            a string
	 * @param t
	 *            a list
	 * @return the index of s if s is in the list; otherwise, returns the index
	 *         where s would be located if it were to be inserted into the list
	 */
	public static int bsearch(String s, List<String> t) {
		if (t.size() == 0) {
			return 0;
		} else if (t.size() == 1 && t.get(0) == s) {
			return 0;
		} else if (t.size() == 1 && t.get(0) != s) {
			return 1;
		} else {
			return bsearch(s, t);
		}
	}

	public static void main(String[] args) {
		// RUN THIS TO TEST downsample
		Picture p = new Picture("snowflake.jpg");
		p.show();
		downsample(p, 1).show();
		downsample(p, 2).show();
		downsample(p, 3).show();
	}
}
