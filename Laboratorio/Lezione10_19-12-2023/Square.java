import java.awt.Rectangle;
import java.lang.IllegalArgumentException;
import java.lang.Comparable;

public class Square extends Rectangle implements Comparable {
	public Square(int x, int y, int lato) {
		// int upperLeftX = x - (lato / 2);
		// int upperLeftY = y - (lato / 2);
		super(x - (lato / 2), y - (lato / 2), lato, lato);
	}

	public double getArea() {
		return this.getHeight() * this.getWidth();
	}

	public void setSize(int width, int height) {
		if (width != height)
			throw new IllegalArgumentException();
		super.setSize(width, height);
	}

	public void setSize(int dim) {
		super.setSize(dim, dim);
	}

	public int compareTo(Object o) {
		Square other = (Square) o;
		if (this.getArea() < other.getArea())
			return -1;
		if (this.getArea() > other.getArea())
			return 1;
		else
			return 0;
	}
}
