package Paquete;

import java.util.Date;

public class Loan {

    private int codeLoan;
    private int codeGame;
    private int codeuser;
    private String date;

    public Loan (){
        
    }
    
    public Loan(int codeLoan, int codeGame, int codeuser, String date) {
        this.codeLoan = codeLoan;
        this.codeGame = codeGame;
        this.codeuser = codeuser;
        this.date = date;
    }

    public int getCodeLoan() {
        return codeLoan;
    }

    public void setCodeLoan(int codeLoan) {
        this.codeLoan = codeLoan;
    }

    public int getCodeGame() {
        return codeGame;
    }

    public void setCodeGame(int codeGame) {
        this.codeGame = codeGame;
    }

    public int getCodeuser() {
        return codeuser;
    }

    public void setCodeuser(int codeuser) {
        this.codeuser = codeuser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
