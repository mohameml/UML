package packages;

public class Rectangle extends Figure {

    private int largeur ;
    private int hauteur ;
    private Point p ;

    

    public Rectangle(int l , int h ,Point p) {
        this.largeur = l ;
        this.hauteur = h ;
        this.p = p ; 
    }

    @Override
    public void deplacer(int a, int b) {
        p.move(a, b);
    }

    @Override
    public String afficher() {
        String ch = "Rectangle \n\t";
        ch+=p.toString();
        return ch ; 
    }

    @Override
    public void agrandir(int facteur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agrandir'");
    }

    
}
