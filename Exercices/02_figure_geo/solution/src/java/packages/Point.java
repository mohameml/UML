package packages;

public class Point {
    
    /* attribust  */
    private int x ;
    private int y ; 


    public Point(int x , int y ) {
        this.x = x ;
        this.y = y ;
    }
    
    
    public int  getX() {
        return this.x ;
    }

    public int getY() {
        return this.y ; 
    }

    public void setX(int x) {
        this.x = x ; 
    } 

    public void setY(int y) {
        this.y = y ; 
    }


    @Override 
    public String toString() {
        return "Point(" + this.x + "," + this.y + ")\n" ; 
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point pt = (Point)(o);

            return pt.x == this.x && pt.y == this.y ;
        }


        return false ;
    }


    public void  move(int a, int b) {
        this.x +=a;
        this.y += b ; 
    }

}
