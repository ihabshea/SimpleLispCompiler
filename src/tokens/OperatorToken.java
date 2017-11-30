/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

/**
 *
 * @author ihab
 */
public class OperatorToken extends token {
    public final operator Operator;
    OperatorToken(operator Operator) {
        this.Operator  = Operator;
    }

    @Override
    public String toString() {
        return Operator.toString();
    }
    
    public operator getOperator(){
        return Operator;
    }
}
