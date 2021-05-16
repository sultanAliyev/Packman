public class Position{
	//x, y coordinates
	int x, y = 0;
	int value; 
	
	//following constructors, getters and setters
	public Position(){}

	public Position(int x, int y){ 
		this.x = x;
		this.y = y;
	}

	public Position(int x, int y, int value){
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int getX(){return x;}

	public int getY(){return y;}

	public void setX(int x){this.x = x;}

	public void setY(int y){this.y = y;}

	public boolean equals(Position pos){
		if (pos.getX() == x && pos.getY() == y){
			return true;
		}
		return false;
	}

	@Override
	public String toString(){return getX() + " " + getY();}

}