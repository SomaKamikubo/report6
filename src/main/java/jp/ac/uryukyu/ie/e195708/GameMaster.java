package jp.ac.uryukyu.ie.e195708;


import java.util.*;

/**
 * ゲームの管理
 */
class GameMaster {

    computer computer_1 = new computer("山田");
    computer computer_2 = new computer("田中");
    computer computer_3 = new computer("佐藤");
    Player player = new Player("player");

    /**
     * 1から13の数を4個ずつ生成
     * それぞれの手札にランダムに配る
     */
    void stage () {
        //トランプを作る
        ArrayList<Integer> card = new ArrayList<>();
        for (int a = 0; a < 4; a++) {
            for (int i = 1; i < 14; i++) {
                card.add(i);
            }
        }
        //カードを配る
        Random r = new Random();
        int count = 0;
        for (int a = 0; a < 3; a++) {
            for (int i = 0; i < 13; i++) {
                int number = r.nextInt(card.size());
                if (count == 0) {
                    computer_1.mycard.add(card.get(number));
                }if (count == 1) {
                    computer_2.mycard.add(card.get(number));
                }if (count == 2) {
                    computer_3.mycard.add(card.get(number));
                }card.remove(number);

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

        //とりあえずプリント
        System.out.println(computer_1.name + computer_1.mycard);
        System.out.println(computer_2.name + computer_2.mycard);
        System.out.println(computer_3.name + computer_3.mycard);
        System.out.println(player.name + player.mycard);




    }


    /**
     * ゲーム開始
     */
    void game(){
        while(!player.victory) {

            player.myTurn(player.mycard,"kamikubo");

            computer_1.computerAct(computer_1.mycard, "山田");

            computer_2.computerAct(computer_2.mycard, "田中");

            computer_3.computerAct(computer_3.mycard, "佐藤");

        }
    }

}








