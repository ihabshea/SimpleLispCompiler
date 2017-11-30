package tokens;

/**
 *
 * @author Ihab McShea
 */
public enum operator {
    PLUS('+'),
    MINUS('-'),
    DIVIDE('/'),
    TIMES('*');
    public final char representation;
    private operator(char representation){
        this.representation = representation;
    }

    @Override
    public String toString() {
        return Character.toString(representation);
    }
    public static boolean isOperator(char c){
        for(operator o: operator.values()){
            if(c == o.representation){
                return true;
            }
        }
        return false;
    }
    public static operator parseOperator(char c){
        for(operator o: operator.values()){
            if(o.representation == c){
                return o;
            }
        }
        throw new IllegalArgumentException(c + " is not a valid token.");
    }
    
}
