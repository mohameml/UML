package packages;

public class Cercle extends Figure{

    /* attribust :  */
    private int rayon ;
    private Point center ; 

    public Cercle(int rayon , Point p) {
        if(rayon < 0 ) {
            throw new IllegalArgumentException("rayon doit étre positive ");

        }

        this.rayon = rayon ;
        
        if(p != null  ) {
            this.center = p ; 

        }
    
    }

    @Override
    public void deplacer(int a, int b) {
        center.move(a, b);
    }

    @Override
    public String afficher() {
        String ch = "Cercle \n\t";
        ch+=center.toString();
        return ch ; 
    }

    @Override
    public void agrandir(int facteur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agrandir'");
    }
    
    
}
