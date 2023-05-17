package LottoGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoGameRenew {
    private static TreeSet<Integer> selectLotto = new TreeSet<>();
    private static TreeSet<Integer> winNumber = new TreeSet<>();
    private static TreeSet<Integer> autoLotto = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean running = true;
        while (running) {

            // 초기 화면: 메뉴선택
            System.out.println("====================================");
            System.out.println("======= 원하는 메뉴를 선택하세요 =======");
            System.out.println("=======      1. 자동 로또     =======");
            System.out.println("=======      2. 수동 로또     =======");
            System.out.println("=======      3. 당첨 번호     =======");
            System.out.println("=======      4. 나의 등수     =======");
            System.out.println("=======      5. 종료 하기     =======");
            System.out.println("====================================");
            System.out.println("몇번으로 이동할까요?: ");
            int choiceNum = scanner.nextInt();
            System.out.println("이동합니다.");

            switch (choiceNum) {
                case 1:
                    controllerAutoLotto();
                    break;
                case 2:
                    controllerSelectLotto();
                    break;
                case 3:
                    controllerWinLotto();
                    break;
                case 4:
                    controllerMyRank(selectLotto, winNumber, autoLotto);
                    break;
                case 5:
                    System.out.println("종료합니다.");
                    running = false;
                    controllerExit();
                    break;
                default:
                    System.out.println("잘못 입력하였습니다.");
                    break;
            }
        }
    }

    private static void controllerExit() {
        System.exit(0);
    }

    private static void controllerMyRank(TreeSet<Integer> selectLotto, TreeSet<Integer> winNumber, TreeSet<Integer> autoLotto) {
        System.out.println("=======      4. 나의 등수     =======");
        System.out.println("당첨결과를 알아보겠습니다.");
        System.out.println("①자동로또 / ②수동로또 중 어느 것과 비교할까요? 숫자로 입력");
        Scanner scanner = new Scanner(System.in);
        int findMyLottoRank = scanner.nextInt();

        if (findMyLottoRank == 1) {
            if(autoLotto.isEmpty()) {
                System.out.println("아직 자동로또를 발행하지 않으셨네요.");
                controllerAutoLotto();
            } else {
                System.out.println("자동로또" + autoLotto);
                System.out.println("당첨번호" + winNumber);
                autoLotto.retainAll(winNumber);
                int matchAutoLotto = autoLotto.size();
                System.out.println(autoLotto.size() + "개 맞았습니다.");
                if (matchAutoLotto == 6) {
                    System.out.println("1등 당첨");
                } else if (matchAutoLotto == 5) {
                    System.out.println("2등 당첨");
                } else if (matchAutoLotto == 4) {
                    System.out.println("3등 당첨");
                } else if (matchAutoLotto == 3) {
                    System.out.println("4등 당첨");
                } else if (matchAutoLotto == 2) {
                    System.out.println("5등 당첨");
                } else {
                    System.out.println("미당첨");
                }
            }
        } else if (findMyLottoRank == 2) {
            if(selectLotto.isEmpty()) {
                System.out.println("아직 수동로또를 발행하지 않으셨네요.");
                controllerSelectLotto();
            } else {
                System.out.println("수동로또" + selectLotto);
                System.out.println("당첨번호" + winNumber);
                selectLotto.retainAll(winNumber); //일치하는 번호 골라내기
                int matchLotto = selectLotto.size(); // 몇개 있는지 세기
                System.out.println(selectLotto.size() + "개 맞았습니다.");
                if (matchLotto == 6) {
                    System.out.println("1등 당첨");
                } else if (matchLotto == 5) {
                    System.out.println("2등 당첨");
                } else if (matchLotto == 4) {
                    System.out.println("3등 당첨");
                } else if (matchLotto == 3) {
                    System.out.println("4등 당첨");
                } else if (matchLotto == 2) {
                    System.out.println("5등 당첨");
                } else {
                    System.out.println("미당첨");
                }
            }
        } else {
            System.out.println("잘못된 선택이에요. 어떤 로또인지 1,2 중에 선택하세요.");
            System.exit(0);
        }
    }

    private static void controllerWinLotto() {
        System.out.println("=======      3. 당첨 번호     =======");
        System.out.println("이번회차 당첨번호 추첨입니다.");
        while (winNumber.size() < 6) {
            Random random = new Random();
            int number = random.nextInt(45) + 1;
            winNumber.add(number);
        }
        System.out.println(winNumber);
    }

    private static void controllerSelectLotto() {
        System.out.println("=======      2. 수동 로또     =======");
        if (selectLotto.isEmpty()) {
            System.out.println("1부터 45 사이의 숫자 6개를 입력해주세요.");
            while (selectLotto.size() < 6) {
                // 중복없이 6개의 숫자를 입력받으면 끝나게 함

                System.out.println("로또번호 입력: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    int scanNum = scanner.nextInt();
                    if (scanNum < 1 || scanNum > 45) {
                        System.out.println("1과 45 사이의 숫자로만 입력해주세요.");
                        continue;
                    }
                    selectLotto.add(scanNum);
                } catch (InputMismatchException e) {
                    System.out.println("숫자로만 입력하세요..");
                }
            }
            System.out.println("현재까지 선택한 숫자" + selectLotto);
            System.out.println("===== 나의 수동 로또 번호를 다시 한번 확인하세요. =====");
            System.out.println(selectLotto);
        } else {
            System.out.println("이미 수동로또를 가지고 있어요.");
            System.out.println("나의 수동로또: " + selectLotto);
        }
    }


    private static void controllerAutoLotto() {
        System.out.println("=======      1. 자동 로또     =======");
        if (autoLotto.isEmpty()) {
            System.out.println("자동으로 6개 번호를 추출합니다..");
            while (autoLotto.size() < 6) {
                Random random = new Random();
                int number = random.nextInt(45) + 1;
                autoLotto.add(number);
            }
            System.out.println(autoLotto);
        } else {
            System.out.println("이미 자동로또 번호를 생성하셨습니다.");
            System.out.println("나의 자동로또: "+autoLotto);
        }
    }
}



