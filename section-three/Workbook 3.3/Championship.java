public class Championship {
    public static void main(String[] args) {

        int gryffindor = 400;    //gryffindor points
        int ravenclaw = 200;    //ravenclaw points

        int margin = gryffindor - ravenclaw;


        //if gryffindor wins by a margin of 300 points:
        if (margin >= 300) {
             //print: Gryffindor takes the house cup!
             System.out.println("Gryffindor takes the house cup!");
        }

        //if gryffindor wins by a margin of any points:
        else if (margin < 300 && margin > 0) { 
            //print: In second place, Gryffindor!
            System.out.println("In second place, Gryffindor!");
        }

        //if gryffindor loses by a margin of 100 points, they are third:
        else if (margin <= 0 && margin >= -100) {
            //print: In third place, Gryffindor!
            System.out.println("In third place, Gryffindor!");
        }

        //else:
        else {
           //print: In fourth place, Gryffindor!
           System.out.println("In fourth place, Gryffindor!");
        }
    }
}
