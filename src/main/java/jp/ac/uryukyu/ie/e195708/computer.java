package jp.ac.uryukyu.ie.e195708;


import java.util.ArrayList;
import java.util.Collections;


class computer {


    static ArrayList<Integer> gaverageCard = new ArrayList<>();
    boolean victory = false;

    String name;
    ArrayList<Integer> mycard = new ArrayList<>();

    computer(String name) {
        this.name = name;
    }


    void passCheck(){
        int coun = 0;
        for (int s = 0; s< gaverageCard.size();s++) {
            int a = gaverageCard.get(s);
            if (a == 0) {
                coun += 1;
                if (coun == 3) {
                    gaverageCard.clear();
                    System.out.println("全員がパスしました。");
                }
            }
        }
    }

    void computerAct (ArrayList < Integer > computer, String name){
        int count = 0;
        if(computer.size() == 0) {
            System.out.println("");
        }
        if(computer.size() != 0) {
            for (int i = 0; i < computer.size();i++ ) {
            int takeNumber = computer.get(i);

            if (gaverageCard.size() == 0) {
                gaverageCard.add(takeNumber);//一番低いカードを出させる
                System.out.println(name + ":" + takeNumber);
                computer.remove((Integer) takeNumber);//出したカードを自分の手札から消す
                gaverageCard.removeIf(n -> n == 0);//カードを出したのでパスのカウントを０にする
                Collections.sort(gaverageCard);//カードを小さい順に並べる
                count += 1;
                if (computer.size() == 0) {//手札がなくなったら勝ち
                    System.out.println("バイバイ〜");
                }
                break;
            } else {
                if (takeNumber > gaverageCard.get(gaverageCard.size() - 1)) {
                    System.out.println(name + "：" + takeNumber);
                    gaverageCard.add(takeNumber);
                    computer.remove(((Integer) takeNumber));
                    gaverageCard.removeIf(n -> n == 0);//カードを出したのでパスのカウントを０にする
                    Collections.sort(gaverageCard);//カードを小さい順に並べる
                    count += 1;
                    if (computer.size() == 0) {//手札がなくなったら勝ち
                        System.out.println("お先に！！！！");
                    }
                    break;
                }
            }
        }


        if (count == 0) {
            System.out.println(name + "：pass");
            gaverageCard.add(0);
            Collections.sort(gaverageCard);
            passCheck();
        }

        }
    }
}

