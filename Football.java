import java.util.Scanner;

public class Football {

    public static void main(String[] args) {

        // not allowed to use loops

        int uviWonGames = 0;
        int uviTieGames = 0;
        int uviTotalScore = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter results for 3 games");
        System.out.println("the first game");
        int uniG1=scan.nextInt();
        int oppoG1=scan.nextInt();

        System.out.println("the second game");
        int uniG2=scan.nextInt();
        int oppoG2=scan.nextInt();

        System.out.println("the third game");
        int uniG3=scan.nextInt();
        int oppoG3=scan.nextInt();


        int scoreUniG1 = (uniG1 > oppoG1 ) ? 3 : (uniG1 < oppoG1 ) ? -4 :  2  ;
        int scoreUniG2 = (uniG2 > oppoG2 ) ? 3 : (uniG2 < oppoG2 ) ? -4 :  2  ;
        int scoreUniG3 = (uniG3 > oppoG3 ) ? 2*uniG3 : (uniG3 < oppoG3 ) ? -4 :  2  ;

        boolean gotBonus1 = (scoreUniG3 >= 3 && uniG3-oppoG3 > 3)  ? true : false  ;
        boolean gotBonus2 = (scoreUniG1 == 3 && scoreUniG2 == 3 && uniG1-oppoG1 > 2 && uniG2-oppoG2 > 2) ? true : false;
        boolean gotBonus3 = (scoreUniG1+scoreUniG2+scoreUniG3 == 6) ? true : false;

        //check won games
            if (scoreUniG1 == 3){
                uviWonGames++;
            }
            if (scoreUniG2 == 3){
                uviWonGames++;
            }
             if (scoreUniG3 >= 3){
                 uviWonGames++;
             }

             // check tie games

        if (scoreUniG1 == 2){
            uviTieGames++;
        }
        if (scoreUniG2 == 2){
            uviTieGames++;
        }
        if (scoreUniG3 == 2){
            uviTieGames++;
        }

        //total score with bonus or without
        
       if(gotBonus1 || gotBonus2 || gotBonus3 ){
           uviTotalScore = scoreUniG3 + scoreUniG2 + scoreUniG3 + 5;
       } else  {
           uviTotalScore = scoreUniG3 + scoreUniG2 + scoreUniG3;
       }




        System.out.printf("Number of games which the university team won: %s\n", uviWonGames);
        System.out.printf("Number of games with tie result: %s\n", uviTieGames);
        System.out.printf("Final score of the university team: %s\n", uviTotalScore);

    }

    }

