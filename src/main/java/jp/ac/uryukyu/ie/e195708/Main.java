package jp.ac.uryukyu.ie.e195708;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> mycard_1 = new ArrayList<>();
        ArrayList<Integer> mycard_2 = new ArrayList<>();
        ArrayList<Integer> mycard_3 = new ArrayList<>();
        computer computer_1 = new computer("山田",mycard_1);
        computer computer_2 = new computer("田中", mycard_2);
        computer computer_3 = new computer("佐藤", mycard_3);


        //トランプを作る
        ArrayList<Integer> card = new ArrayList<>();
        for (int a = 0; a < 4; ) {
            for (int i = 1; i < 14; ) {
                card.add(i);
                i += 1;
            }
            a += 1;
        }
        System.out.println(card);



        //カードを配る
        Random r = new Random();
        int count = 0;
        for (int a = 0; a < 3; a++) {
            for (int i = 0; i < 13; i++) {
                int number = r.nextInt(card.size());
                if (count == 0){ computer_1.mycard.add(card.get(number)); }
                if (count == 1){ computer_2.mycard.add(card.get(number)); }
                if (count == 2){ computer_3.mycard.add(card.get(number)); }

                card.remove(number);
            }
            count +=1;
        }

        //配られたカードを小さい順に並べる
        Collections.sort(computer_1.mycard);
        Collections.sort(computer_2.mycard);
        Collections.sort(computer_3.mycard);
        Collections.sort(card);

        System.out.println("1:"+computer_1.mycard);
        System.out.println("2:"+computer_2.mycard);
        System.out.println("3:"+computer_3.mycard);
        System.out.println("player:"+card);


    }
}
