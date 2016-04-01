package Lap2;

public class RoomDimension {

	private  double  length , width  ;

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double  getArea()
	{
		return length*width;
	}
	
	
}
