package jp.ac.uryukyu.ie.e195708;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Player extends computer {

    Player(String name) {
        super(name);
    }



    void myTurn (ArrayList < Integer > pry, String names) {
        while (true) {
            //自分のターン
            Scanner scanner = new Scanner(System.in);//出したカードを記録するリスト
            System.out.println("カードを出してください。カードを出さない場合は０を入力してください");
            System.out.println("あなたの手札です。" + pry);
            int take_away = scanner.nextInt();
            boolean check = pry.contains(take_away);//出したカードが自分の手札にあるか確認する


            //パスする
            if (take_away == 0) {
                System.out.println(names+"："+"pass");
                gaverageCard.add(0);
                Collections.sort(gaverageCard);
                passCheck();
                break;



            } else if (check) {//自分の手札からカードを出す
                if (gaverageCard.size() == 0) {
                    gaverageCard.add(take_away);//出したカードを記録する
                    System.out.println(names + ":" + take_away);
                    pry.remove((Integer) take_away);//出したカードを自分の手札から消す
                    gaverageCard.removeIf(n -> n == 0);//カードを出したのでパスのカウントを０にする
                    Collections.sort(gaverageCard);//カードを小さい順に並べる
                    if (pry.size() == 0) {//手札がなくなったら勝ち
                        System.out.println("あがり！！！"+"とても強いね！！１");
                        victory = true;
                    }
                    break;
                }else {
                    if (take_away > gaverageCard.get(gaverageCard.size() - 1)) {//出したカードより大きい数字を出している場合
                        gaverageCard.add(take_away);//出したカードを記録する
                        System.out.println(names + ":" + take_away);
                        pry.remove((Integer) take_away);//出したカードを自分の手札から消す
                        gaverageCard.removeIf(n -> n == 0);//カードを出したのでパスのカウントを０にする
                        Collections.sort(gaverageCard);//カードを小さい順に並べる
                        if (pry.size() == 0) {//手札がなくなったら勝ち
                            System.out.println("おしまい！！！");
                            victory = true;
                        }
                        break;
                    } else {//出したカードより小さい数字を出した場合
                        System.out.println(gaverageCard.get(gaverageCard.size() - 1) + "より大きいカードを出してください。出せるカードがない場合は０を入力してパスしてください。");
                    }
                }
            }
            else{
                System.out.println(take_away + "はあなたの手札に含まれていません。もう一度手札を確認してカードを出してください");
                System.out.println(names + pry);
            }
        }
     }
}



