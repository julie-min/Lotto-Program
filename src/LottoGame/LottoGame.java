package LottoGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/*
[원하는 메뉴 선택] (Controller)
-자동로또
-수동로또
-당첨번호조회
-당첨등수조회
-프로그램종료

[자동로또]
자동으로 랜덤 숫자 생성
-중복없이, 1~45 숫자 중에 6개 선택
나의 로또 번호 최종 출력 6개

[수동로또]
사용자 숫자 6개 입력 (View)
- 중복없이 6개의 treeset 채워질때까지 (Model)
- 1~45사이의 숫자만: try/catch (Model)
나의 로또 번호 최종 출력 6개 (View)

[당첨번호조회]
이번회차 당첨번호 추첨 공지 (View)
- 6개의 랜덤한 숫자 생성 (Model)
- 중복없이, 1~45의 숫자중에 6개 선택 (Model)

[당첨등수조회]
당첨결과비교 공지 (View)
- 일치하는 번호 교집합 찾아내기 (Model)
- 일치하는 번호가 몇개인지 세기 (
- 등수 공개

[프로그램종료]
 */
public class LottoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        TreeSet<Integer> userNumbers = new TreeSet<>();
        TreeSet<Integer> winningNumbers = new TreeSet<>();

        // 1. 6개의 숫자 입력받기
        System.out.println("1부터 45까지의 숫자 중 6개를 골라주세요.");
        while (userNumbers.size() < 6) {
            System.out.print((userNumbers.size() + 1) + "번째 숫자: ");
            int number;
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                scanner.nextLine(); // 입력 버퍼를 비우기 위해 추가
                continue;
            }

            if (number < 1 || number > 45) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                continue;
            }

            if (!userNumbers.add(number)) {
                System.out.println("중복된 숫자입니다. 다시 입력해주세요.");
            }
        }

        // 2. 최종 도전번호 출력
        System.out.print("내가 선택한 번호 : ");
        for (int number : userNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 3. 로또 시작
        System.out.println("로또 번호 발표!");

        // 4. 당첨번호 출력
        System.out.print("당첨번호: ");
        while (winningNumbers.size() < 6) {
            int number = random.nextInt(45) + 1; // 1부터 45까지의 난수 생성
            if (winningNumbers.add(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();

        // 5. 당첨여부 확인
        userNumbers.retainAll(winningNumbers); // 당첨번호와 일치하는 번호 추출
        int matchedCount = userNumbers.size();
        if (matchedCount == 6) {
            System.out.println("1등 당첨!");
        } else if (matchedCount == 5) {
            System.out.println("2등 당첨!");
        } else if (matchedCount == 4) {
            System.out.println("3등 당첨!");
        } else if (matchedCount == 3) {
            System.out.println("4등 당첨!");
        } else if (matchedCount == 2) {
            System.out.println("5등 당첨!");
        } else {
            System.out.println("다음기회에..");
        }
    }
}
