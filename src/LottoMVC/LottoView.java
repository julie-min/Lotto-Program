package LottoMVC;


import java.util.Scanner;

public class LottoView {
    Scanner scanner = new Scanner(System.in);
    int introNum;

    {
        introNum = scanner.nextInt();
    }

    // 초기 화면: 메뉴선택
    public void IntroMenu() {
        System.out.println("====================================");
        System.out.println("======= 원하는 메뉴를 선택하세요 =======");
        System.out.println("=======      1. 자동 로또     =======");
        System.out.println("=======      2. 수동 로또     =======");
        System.out.println("=======      3. 당첨 번호     =======");
        System.out.println("=======      4. 나의 등수     =======");
        System.out.println("=======      5. 종료 하기     =======");
        System.out.println("====================================");

    }

    // 1. 자동로또 뷰

    // 2. 수동로또 뷰

    // 3. 당첨 번호 뷰

    // 4. 나의 등수 뷰

    // 5. 종료 뷰

}



