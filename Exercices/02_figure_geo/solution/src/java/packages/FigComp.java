package packages;

import java.util.ArrayList;

public class FigComp extends Figure {

    private ArrayList<Figure> figs ; 

    public FigComp() {
        this.figs = new ArrayList<>();
    }


    public void add(Figure fig) {
        this.figs.add(fig);
    }

    

    @Override
    public void deplacer(int a, int b) {

        for (Figure e : this.figs) {
            e.deplacer(a, b);
            
        }
    }

    @Override
    public String afficher() {
        String ch = new String();
        for (Figure e : this.figs) {
            ch += e.afficher();
            
        }

        return ch ; 
    }

    @Override
    public void agrandir(int facteur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agrandir'");
    }
    
    
}
