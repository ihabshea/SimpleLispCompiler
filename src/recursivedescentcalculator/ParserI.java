package recursivedescentcalculator;


import java.util.Collection;
import java.util.Iterator;
import tokens.NumericToken;
import tokens.OperatorToken;
import tokens.lParen;
import tokens.operator;
import tokens.token;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ihab
 */
public class ParserI {
    public int evaluate(Collection<token> tokens){
        return Evaluate(tokens.iterator());
    }
    public int Evaluate(Iterator<token> itr){
        if(!itr.hasNext()){
            
        }
        token first = itr.next();
        if(first instanceof NumericToken){
            NumericToken token = (NumericToken) first;
            return token.getNumber();
        }else if(first instanceof lParen){
            token operatorToken = itr.next();
            operator Operator = ((OperatorToken) operatorToken).getOperator();	
            int lhs = Evaluate(itr);
            if(!itr.hasNext()){
                
            }
            int rhs = Evaluate(itr);
            if(!itr.hasNext()){
                throw new IllegalArgumentException("Missing right parenthesis");
            }
            token rightparenToken = itr.next();
            return evaluation(Operator, lhs, rhs);
        }
        throw new IllegalArgumentException("Shitpants!");
    }
    	private int evaluation(operator operator, int lhs, int rhs) {
		switch(operator) {
			case TIMES:
				return lhs * rhs;
			case DIVIDE:
				return lhs / rhs;
			case PLUS:
				return lhs + rhs;
			case MINUS:
				return lhs - rhs;
			default:
				return 0;
		}
	}
}
