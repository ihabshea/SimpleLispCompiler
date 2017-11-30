/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ihab
 */
public abstract class token {
        public static Collection<token> tokenize(String expression){
               ArrayList<token> tokens = new ArrayList<>();
               StringCharacterIterator  itr = new StringCharacterIterator(expression);
               for(char c= itr.first(); c!= StringCharacterIterator.DONE; c = itr.next()){
                   if(Character.isWhitespace(c)){
                       continue;
                   }
                   if(c == '('){
                       tokens.add(new lParen());
                       continue;
                   }
                   if(c == ')'){
                       tokens.add(new rParen());
                       continue;
                   }
                   if(Character.isDigit(c)){
                       int number;
                       number = parseNumber(itr);
                       tokens.add(new NumericToken(number));
                       continue;
                   }
                 if(operator.isOperator(c)){
                       operator Operator = operator.parseOperator(c);
                        tokens.add(new OperatorToken(Operator));
                   }
               }
               return tokens;
        }
        	private static int parseNumber(StringCharacterIterator itr) {
		int accumulator = 0;
		
		for (char c = itr.current(); c != StringCharacterIterator.DONE; c = itr.next()) {
			// Stop once we reach a non-numeric character.
			// We have to rewind the iterator since we went too far.
			if (! Character.isDigit(c)) {
				itr.previous();
				return accumulator;
			}
			
			accumulator *= 10;
			accumulator += Character.getNumericValue(c);
		}
		
		return accumulator;
	}
}
