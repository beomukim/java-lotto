## 구현 기능 목록

### 도메인 로직


- 돈을 입력 받음
  - (e) 1000원으로 떨어지지 않으면 예외 처리 @Money
- 개수만큼 로또를 만듦
  - (e) 1 ~ 45 사이의 중복되지 않는 숫자 6개 @LottoMaker
- 로또 판별
  - 당첨로또 enum 객체로 관리 @WinningLotto
  - 당첨번호와 보너스번호를 비교하여 당첨 로또 판별 @LottoMachine
  - 당첨 금액과 구입 금액으로 수익률 계산 @LottoMachine #caculateProfit