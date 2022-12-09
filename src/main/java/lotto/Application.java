package lotto;


import static lotto.util.ErrorMessage.ERROR_MESSAGE;

import lotto.controller.LottoContoller;

public class Application {
    public static void main(String[] args) {
        LottoContoller lottoContoller = new LottoContoller();
        try {
            lottoContoller.lottoPlay();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}
