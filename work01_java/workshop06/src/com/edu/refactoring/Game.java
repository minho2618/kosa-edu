package com.edu.refactoring;

/**
 * 간단한 가위바위보 게임 클래스입니다.
 * 
 * 게임은 플레이어의 입력(가위, 주먹, 보)에 따라 컴퓨터와 대결을 진행하며,
 * 미리 설정된 게임 횟수 또는 승/패 조건에 따라 종료됩니다.
 * 
 * 게임 유형은 3가지 중 선택할 수 있습니다:
 * 1. 5판 3선승
 * 2. 3판 2선승
 * 3. 1판 1선승
 * 
 * @author Yoonyeol Lee, Minho Lee, Sungwoo Park
 * 
 */
public class Game {
    
    // ==============================
    // ▶ 게임 상태 변수
    // ==============================

    /** 전체 게임 횟수 (최대 몇 판까지 진행할 것인지) */
    public int game = 0;

    /** 승패를 판정하기 위한 기준 승수 (예: 3선승제) */
    public int judge = 0;

    /** 플레이어의 승리 횟수 */
    public int win = 0;

    /** 컴퓨터의 승리 횟수 */
    public int lose = 0;

    /** 현재까지 진행된 게임 횟수 */
    public int gameCount = 0;

    
    // ==============================
    // ▶ 게임 설정
    // ==============================

    /**
     * 게임 규칙을 설정합니다.
     * 
     * 사용자가 선택한 타입에 따라 게임 횟수와 승리 기준이 달라집니다.
     * 
     * @param type 게임 유형
     *             1: 5판 3선승
     *             2: 3판 2선승
     *             3: 1판 1선승
     */
    public void setGameRule(int type) {
        switch (type) {
            case 1:
                game = 5;
                judge = 3;
                break;
            case 2:
                game = 3;
                judge = 2;
                break;
            case 3:
                game = 1;
                judge = 1;
                break;
        }
    }

    
    // ==============================
    // ▶ 게임 진행
    // ==============================

    /**
     * 한 판의 게임을 진행합니다.
     * 
     * 플레이어의 입력("가위", "주먹", "보")을 받아
     * 컴퓨터의 랜덤 선택과 비교하여 결과를 출력합니다.
     *
     * @param n 플레이어의 선택 (문자열)
     */
    public void playGame(String n) {
        playGameResult(playGameInput(n));
    }

    /**
     * 문자열 입력을 숫자로 변환합니다.
     *
     * @param str "가위", "주먹", "보"
     * @return 숫자 코드 (1: 가위, 2: 주먹, 3: 보), 그 외: 0
     */
    public int playGameInput(String str) {
        if (str.equals("가위")) {
            return 1;
        } else if (str.equals("주먹")) {
            return 2;
        } else if (str.equals("보")) {
            return 3;
        }
        return 0;
    }

    /**
     * 게임 결과를 판정하고 출력합니다.
     *
     * @param in 플레이어가 선택한 숫자 코드
     */
    public void playGameResult(int in) {
        // 컴퓨터는 1~3 사이의 랜덤 숫자를 선택 (1: 가위, 2: 주먹, 3: 보)
        int com = (int) (Math.random() * 3) + 1;
        gameCount++;

        if (com == in) {
            System.out.println("비겼습니다!!!");
        } else if ((com == 1 && in == 2) || (com == 2 && in == 3) || (com == 3 && in == 1)) {
            win++;
            System.out.println("이겼습니다!!!");
        } else {
            lose++;
            System.out.println("졌습니다!!!");
        }
    }

    
    // ==============================
    // ▶ 게임 종료 여부 & 결과
    // ==============================

    /**
     * 게임이 종료되었는지 확인합니다.
     *
     * 종료 조건:
     * - 정해진 판 수(game) 만큼 게임을 다 했거나
     * - 플레이어 또는 컴퓨터가 승리 조건(judge)을 달성한 경우
     *
     * @return true: 게임 종료됨, false: 계속 진행
     */
    public boolean isFinished() {
        return gameCount >= game || win >= judge || lose >= judge;
    }

    /**
     * 게임이 종료된 후 최종 결과를 반환합니다.
     *
     * @return 최종 결과 메시지 (무승부, 컴퓨터 승, 컴퓨터 패)
     */
    public String gameResult() {
        String result = "";

        if (isFinished()) {
            if (win == lose) {
                result = "무승부";
            } else if (win > lose) {
                result = "컴퓨터 패";
            } else {
                result = "컴퓨터 승";
            }
        }

        return "\n### " + result + "!!!";
    }
}
