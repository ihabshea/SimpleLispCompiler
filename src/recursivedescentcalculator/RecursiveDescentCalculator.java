/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivedescentcalculator;

import java.util.Collection;
import tokens.token;

/**
 *
 * @author ihab
 */
/*
EBNF: 
    lexp -> number | ( operator lexp-seq )
    number -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
    operator -> * | / | - | +
    lexp-seq -> lexp {lexp}
    (- 34 (* 3 42 ))
*/
public class RecursiveDescentCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String t = "( - 8 (* 2 (+6 8)))";
        Collection<token> tokens = token.tokenize(t);
        int result = new ParserI().evaluate(tokens);
        System.out.println(Integer.toString(result));
    }
    
}
