package LottoMVC;

import java.util.InputMismatchException;
import java.util.TreeSet;

public class LottoController {
    private LottoModel model;
    private LottoView view;

    public LottoController(LottoModel model, LottoView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        boolean running = true;
        while (running) {
            int choiceNum = view.getMenuChoice();
            System.out.println("이동합니다.");

            switch (choiceNum) {
                case 1:
                    generateAutoLotto();
                    break;
                case 2:
                    generateSelectLotto();
                    break;
                case 3:
                    generateWinNumbers();
                    break;
                case 4:
                    checkMyRank();
                    break;
                case 5:
                    System.out.println("종료합니다.");
                    running = false;
                    break;
                default:
                    view.showErrorMessage();
                    break;
            }
        }
    }

    private void generateAutoLotto() {
        model.generateAutoLotto();
        TreeSet<Integer> autoLotto = model.getAutoLotto();
        view.showAutoLotto(autoLotto);
    }

    private void generateSelectLotto() {
        TreeSet<Integer> selectLotto = model.getSelectLotto();
        if (selectLotto.isEmpty()) {
            System.out.println("1부터 45 사이의 숫자 6개를 입력해주세요.");
            while (selectLotto.size() < 6) {
                System.out.println("로또번호 입력: ");
                try {
                    int scanNum = view.getMenuChoice();
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
            view.showSelectLotto(selectLotto);
        } else {
            System.out.println("이미 수동로또를 가지고 있어요.");
            view.showSelectLotto(selectLotto);
        }
    }

    private void generateWinNumbers() {
        model.generateWinNumber();
        TreeSet<Integer> winNumber = model.getWinNumber();
        view.showWinNumbers(winNumber);
    }

    private void checkMyRank() {
        TreeSet<Integer> selectLotto = model.getSelectLotto();
        TreeSet<Integer> winNumber = model.getWinNumber();
        TreeSet<Integer> autoLotto = model.getAutoLotto();

        int findMyLottoRank = view.getMyLottoRank();

        if (findMyLottoRank == 1) {
            if (autoLotto.isEmpty()) {
                System.out.println("아직 자동로또를 발행하지 않으셨네요.");
                generateAutoLotto();
            } else {
                view.showAutoLotto(autoLotto);
                view.showWinNumbers(winNumber);
                int matchAutoLotto = model.getMatchedLottoCount(autoLotto, winNumber);
                view.showMatchedCount(matchAutoLotto);
                view.showRank(matchAutoLotto);
            }
        } else if (findMyLottoRank == 2) {
            if (selectLotto.isEmpty()) {
                System.out.println("아직 수동로또를 발행하지 않으셨네요.");
                generateSelectLotto();
            } else {
                view.showSelectLotto(selectLotto);
                view.showWinNumbers(winNumber);
                int matchLotto = model.getMatchedLottoCount(selectLotto, winNumber);
                view.showMatchedCount(matchLotto);
                view.showRank(matchLotto);
            }
        } else {
            System.out.println("잘못된 선택이에요. 어떤 로또인지 1,2 중에 선택하세요.");
        }
    }
}
