

import packages.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("================== Processus du deplacement ============");

        FigComp f  = new FigComp();

        Point p1 = new Point(1 ,2);
        Point p2 = new Point(4,3);
        Point p3 = new Point(8,3);
        Point p4 = new Point(1,3);


        Rectangle r = new Rectangle(3,2 , p1);
        Segement s = new Segement(p2, p3);
        Cercle c = new Cercle(1, p4);


        f.add(r);
        f.add(s);
        f.add(c);

        /*deplacer  */
        int a = 3 ;
        int b = 4 ;
        
        System.out.println("========= Avant le deplacement : =============");
        System.out.println(f.afficher());

        f.deplacer(a, b);

        
        System.out.println("============== Aprés le deplacemnt : ===============");

        System.out.println(f.afficher());




    
    }
    
} 


    