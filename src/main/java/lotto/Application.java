package lotto;


public class Application {
    public static void main(String[] args) {
        LottoContoller lottoContoller = new LottoContoller();
        try {
            lottoContoller.lottoPlay();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
