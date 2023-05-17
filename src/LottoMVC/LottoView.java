package LottoMVC;

import java.util.Scanner;
import java.util.TreeSet;

public class LottoView {
    private Scanner scanner;

    public LottoView() {
        scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        System.out.println("====================================");
        System.out.println("======= 원하는 메뉴를 선택하세요 =======");
        System.out.println("=======      1. 자동 로또     =======");
        System.out.println("=======      2. 수동 로또     =======");
        System.out.println("=======      3. 당첨 번호     =======");
        System.out.println("=======      4. 나의 등수     =======");
        System.out.println("=======      5. 종료 하기     =======");
        System.out.println("====================================");
        System.out.println("몇번으로 이동할까요?: ");
        return scanner.nextInt();
    }

    public void showErrorMessage() {
        System.out.println("잘못 입력하였습니다.");
    }

    public int getMyLottoRankChoice() {
        System.out.println("=======      4. 나의 등수     =======");
        System.out.println("①자동로또 / ②수동로또 중 어느 것과 비교할까요? 숫자로 입력");
        return scanner.nextInt();
    }

    public void showInvalidRankChoice() {
        System.out.println("잘못된 선택입니다. 어떤 로또인지 1, 2 중에 선택하세요.");
    }

    public void showAutoLotto(TreeSet<Integer> autoLotto) {
        System.out.println("자동로또" + autoLotto);
    }

    public void showSelectLotto(TreeSet<Integer> selectLotto) {
        System.out.println("수동로또" + selectLotto);
    }

    public void showWinNumbers(TreeSet<Integer> winNumber) {
        System.out.println(winNumber);
    }

    public void showMatchedNumbers(int matchedCount) {
        System.out.println(matchedCount + "개 맞았습니다.");
    }

    public void showRank(int matchedCount) {
        if (matchedCount == 6) {
            System.out.println("1등 당첨");
        } else if (matchedCount == 5) {
            System.out.println("2등 당첨");
        } else if (matchedCount == 4) {
            System.out.println("3등 당첨");
        } else if (matchedCount == 3) {
            System.out.println("4등 당첨");
        } else if (matchedCount == 2) {
            System.out.println("5등 당첨");
        } else {
            System.out.println("미당첨");
        }
    }
}
