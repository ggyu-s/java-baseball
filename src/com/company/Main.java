package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int ball = 0;
        int strike =0 ;
        int noStrike = 0;
        boolean isGame = true;

        Scanner scan = new Scanner(System.in);

        System.out.println("JAVA World");

        String[] number ={"1","2","3","4","5","6","7","8","9"};
        String[] y = new String[3];

        for(int i = 0 ; i < 3; i++){
            while (true){
                String q  = number[(int) (Math.random() * 8)];
                if(!Arrays.toString(y).contains(q)){
                    y[i] = q;
                    break;
                }
            }
        }

        while(isGame){
            System.out.println(Arrays.toString(y));
            System.out.print("3개의 숫자를 입력해 주세요 : ");
            String num = scan.next();
            String[] b = num.split("");
            for (int i=0; i < y.length; i++){
                if (Arrays.toString(y).contains(b[i])) {
                    noStrike = 0;
                    for (int j = 0; j < y.length; j++) {
                        if (y[j].equals(b[i]) && j == i) {
                            strike++;
                            noStrike = 1;
                        }
                    }
                    if (noStrike == 0) {
                        ball++;
                    }
                }
            }
            if (strike >= 1 && ball >= 1){
                System.out.println(ball + "볼"+ " " + strike + "스트라이크");
            } else if(strike == 0 && ball >= 1){
                System.out.println(ball + "볼");
            } else if(strike >= 1 && ball == 0){
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }

            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                int newGame = scan.nextInt();
                if(newGame == 2) {
                    isGame = false;
                } else {
                    y = new String[3];
                    for(int i = 0 ; i < 3; i++){

                        while (true){
                            String q  = number[(int) (Math.random() * 8)];
                            if(!Arrays.toString(y).contains(q)){
                                y[i] = q;
                                break;
                            }
                        }
                    }
                }
            }
            strike = 0;
            ball = 0;
        }
    }
}
