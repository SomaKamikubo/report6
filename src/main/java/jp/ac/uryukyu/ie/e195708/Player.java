package jp.ac.uryukyu.ie.e195708;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class Player extends computer {

    Player(String name, ArrayList<Integer> mycard) {
        super(name, mycard);
    }


    //Player player = new Player("dr", master.mycard_4);


    //void myTrun() {

        /*while (true) {
            Scanner scanner_1 = new Scanner(System.in);
            System.out.println("あなたの番です、カードを出してください。カードを出さない場合は０、自分の手札を見たい場合は１００を入力してください。");
            int take_away = scanner_1.nextInt();
            if (take_away == 0) {
                System.out.println("パスしました");
                break;
            } else if (take_away == 100) {
                System.out.println(player.mycard);
            } else if (Arrays.asList(master.mycard_4).contains(take_away)) {
                System.out.println(player.name + ":" + take_away);
                master.mycard_4.remove(take_away);
                System.out.println("ok");
                break;
            } else {
                System.out.println(take_away + "はあなたの手札に含まれていません。もう一度手札を確認してカードを出してください");
                System.out.println(player.name + master.mycard_4);
            }

        }*/
    }



