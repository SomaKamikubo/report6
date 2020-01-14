package jp.ac.uryukyu.ie.e195708;


import java.awt.image.ImagingOpException;
import java.util.*;


class GameMaster {
    public static void main(String[]args) {
        ArrayList<Integer> mycard_3 = new ArrayList<>();
        ArrayList<Integer> mycard_1 = new ArrayList<>();
        ArrayList<Integer> mycard_2 = new ArrayList<>();
        ArrayList<Integer> mycard_4 = new ArrayList<>();
        computer computer_1 = new computer("山田", mycard_1);
        computer computer_2 = new computer("田中", mycard_2);
        computer computer_3 = new computer("佐藤", mycard_3);

        Player player = new Player("p", mycard_4);


        //void stage () {


            //トランプを作る
            ArrayList<Integer> card = new ArrayList<>();
            for (int a = 0; a < 4; ) {
                for (int i = 1; i < 14; ) {
                    card.add(i);
                    i += 1;
                }
                a += 1;
            }


            //カードを配る
            Random r = new Random();
            int count = 0;
            for (int a = 0; a < 3; a++) {
                for (int i = 0; i < 13; i++) {
                    int number = r.nextInt(card.size());
                    if (count == 0) {
                        computer_1.mycard.add(card.get(number));
                    }
                    if (count == 1) {
                        computer_2.mycard.add(card.get(number));
                    }
                    if (count == 2) {
                        computer_3.mycard.add(card.get(number));
                    }

                    card.remove(number);
                }
                count += 1;
            }

            //余ったカードをプレイヤーの手札とする
            player.mycard.addAll(card);

            //配られたカードを小さい順に並べる
            Collections.sort(computer_1.mycard);
            Collections.sort(computer_2.mycard);
            Collections.sort(computer_3.mycard);
            Collections.sort(player.mycard);

            System.out.println(computer_1.name + computer_1.mycard);
            System.out.println(computer_2.name + computer_2.mycard);
            System.out.println(computer_3.name + computer_3.mycard);
            System.out.println(player.name + player.mycard);


            while (true) {
                Scanner scanner_1 = new Scanner(System.in);
                System.out.println("あなたの番です、カードを出してください。カードを出さない場合は０、自分の手札を見たい場合は１００を入力してください。");
                int take_away = scanner_1.nextInt();
                boolean check = player.mycard.contains(take_away);
                if (take_away == 0) {
                    System.out.println("パスしました");
                    break;
                } else if (take_away == 100) {
                    System.out.println(player.mycard);
                } else if (check){
                    System.out.println(player.name + ":" + take_away);
                    player.mycard.remove(player.mycard.indexOf(take_away));
                    if (player.mycard.size() == 0){
                        System.out.println("上がり！！！");
                        break;
                    }
                    //break;
                } else {
                    System.out.println(take_away + "はあなたの手札に含まれていません。もう一度手札を確認してカードを出してください");
                    System.out.println(player.name + player.mycard);
                }

            }

        }


}








