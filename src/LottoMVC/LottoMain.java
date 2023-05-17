package LottoMVC;

public class LottoMain {
    public static void main(String[] args) {
        LottoModel model = new LottoModel();
        LottoView view = new LottoView();
        LottoController controller = new LottoController(model, view);

        controller.startGame();
    }
}
