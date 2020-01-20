package jp.ac.uryukyu.ie.e195708;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class computerTest {

    @Test
    void passCheck() {
        ArrayList<Integer> garbageCard = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            garbageCard.add(0);
        }


        int coun = 0;
        for (int s = 0; s < garbageCard.size(); s++) {
            int a = garbageCard.get(s);
            if (a == 0) {
                coun += 1;
                if (coun == 3) {
                    garbageCard.clear();
                    System.out.println("全員がパスしました。");
                }
            }
        }
        assertEquals(0,computer.garbageCard.size());
    }


}