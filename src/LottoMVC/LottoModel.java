package LottoMVC;

import java.util.Random;
import java.util.TreeSet;

public class LottoModel {
    private TreeSet<Integer> selectLotto;
    private TreeSet<Integer> winNumber;
    private TreeSet<Integer> autoLotto;

    public LottoModel() {
        selectLotto = new TreeSet<>();
        winNumber = new TreeSet<>();
        autoLotto = new TreeSet<>();
    }

    public TreeSet<Integer> getSelectLotto() {
        return selectLotto;
    }

    public TreeSet<Integer> getWinNumber() {
        return winNumber;
    }

    public TreeSet<Integer> getAutoLotto() {
        return autoLotto;
    }

    public void generateWinNumber() {
        while (winNumber.size() < 6) {
            Random random = new Random();
            int number = random.nextInt(45) + 1;
            winNumber.add(number);
        }
    }

    public void generateAutoLotto() {
        autoLotto.clear();
        while (autoLotto.size() < 6) {
            Random random = new Random();
            int number = random.nextInt(45) + 1;
            autoLotto.add(number);
        }
    }
}
