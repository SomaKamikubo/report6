package jp.ac.uryukyu.ie.e195708;


import java.util.ArrayList;
import java.util.Collections;

/**
 * コンピューターの行動の実装
 * mycard 手札
 * garbageCard　場に出たカード
 * victory 勝利確認
 */
class computer {
    String name;
    ArrayList<Integer> mycard = new ArrayList<>();
    static ArrayList<Integer> garbageCard = new ArrayList<>();
    boolean victory = false;

    computer(String name) { this.name = name; }

    /**
     * 連続で全員がパスしたか確認するメソッド
     * パスした場合、garbageCardに０を加えるようにしているため、０が３つあった場合パスしたことがわかるように出力
     */
    void passCheck(){
        int coun = 0;
        for (int s = 0; s< garbageCard.size();s++) {
            int a = garbageCard.get(s);
            if (a == 0) {
                coun += 1;
                if (coun == 3) {
                    garbageCard.clear();
                    System.out.println("全員がパスしました。");
                }
            }
        }
    }

    /**
     * コンピューターの簡易操作
     * まず手札があるか確認、なかったら勝利なので何も出力しない
     * あった場合、自分の手札から出せる最小のカードを出す
     * @param computer　コンピューターの手札
     * @param name　コンピューターの名前
     */
    void computerAct (ArrayList < Integer > computer, String name){
        int count = 0;
        if(computer.size() == 0) {
            System.out.println("");
        }
        if(computer.size() != 0) {
            for (int i = 0; i < computer.size();i++ ) {
            int takeNumber = computer.get(i);

            if (garbageCard.size() == 0) {
                garbageCard.add(takeNumber);//一番低いカードを出させる
                System.out.println(name + ":" + takeNumber);
                computer.remove((Integer) takeNumber);//出したカードを自分の手札から消す
                garbageCard.removeIf(n -> n == 0);//カードを出したのでパスのカウントを０にする
                Collections.sort(garbageCard);//カードを小さい順に並べる
                count += 1;
                if (computer.size() == 0) {//手札がなくなったら勝ち
                    System.out.println("バイバイ〜");
                }
                break;
            } else {
                if (takeNumber > garbageCard.get(garbageCard.size() - 1)) {
                    System.out.println(name + "：" + takeNumber);
                    garbageCard.add(takeNumber);
                    computer.remove(((Integer) takeNumber));
                    garbageCard.removeIf(n -> n == 0);//カードを出したのでパスのカウントを０にする
                    Collections.sort(garbageCard);//カードを小さい順に並べる
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
            garbageCard.add(0);
            Collections.sort(garbageCard);
            passCheck();
        }

        }
    }
}

