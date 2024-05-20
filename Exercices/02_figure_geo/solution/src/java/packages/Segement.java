package packages;

public class Segement extends Figure {

    private Point p1 ;
    private Point p2 ;


    public Segement(Point p1 , Point p2) {
        this.p1 = p1 ;
        this.p2 = p2;
    }


    @Override
    public void deplacer(int a, int b) {
        p1.move(a, b);
        p2.move(a, b);
    }

    @Override
    public String afficher() {
        String ch ="Segement \n\t";
        ch+=this.p1.toString()+"\t";
        ch+=this.p2.toString();

        return ch ; 
    }

    @Override
    public void agrandir(int facteur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agrandir'");
    }
    
}
