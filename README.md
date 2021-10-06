# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 기능 목록

1. 플레이어(사용자)
    * 사용자 입력 받기 
      - `Player.readInput()` 
      - nextstep.utils 의 console API 활용
    
   * 입력 검증하기
      - `Player.isValid(input)`
      1. 사용자 제시 숫자 입력
         - 1~9 사이의 숫자 3자리
         - 기타 : 잘못된 입력
      2. 게임 재실행 여부 입력
         - '1': 게임 재실행
         - '2': 게임 종료
         - 기타 : 잘못된 입력

2. 상대방(컴퓨터)
    * 정답 random 초기화
      - `Computer.resetTarget()`
      - 1~9 사이의 _서로 다른_ 숫자 3자리
         
    * 힌트 제공
      - `Computer.generateHint()`
      - 같은 수가 같은 자리에 있으면 스트라이크
      - 같은 수가 다른 자리에 있으면 볼
      - 같은 수가 전혀 없으면 낫싱 혹은 포볼
      
    * 정답 맞는지 확인
      - `Computer.isTarget(input)`

3. 전체
   * 게임 실행
   * 게임 재실행
