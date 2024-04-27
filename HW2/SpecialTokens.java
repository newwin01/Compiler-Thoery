public class SpecialTokens {

    public static String getSpecialTokens(String token) {

        Character tempChar = token.charAt(0);
        //Logical Operator

        if ( tempChar.equals('<')) {
            
            if (token.length() == 1) {
                return "Less Than Operator";
            } else {
                if ( ((Character)token.charAt(1)).equals('=') )  
                    return "Less Than Or Equal Operator";
            } 

        } else if (tempChar.equals('>')) {
            
            if (token.length() == 1) {
                return "Greater Than Operator";
            } else {
                if ( ((Character)token.charAt(1)).equals('=') )  
                    return "Greater Than Or Equal Operator";
            } 

        } else if (tempChar.equals('=')) {
            
            if (token.length() == 1) {
                return "Assign Operator";
            } else {
                if ( ((Character)token.charAt(1)).equals('=') )  
                    return "Equal Operator";
            } 

        } else if (tempChar.equals('!')) {

            if ( ((Character)token.charAt(1)).equals('=') )  
                return "Not Equal Operator";


            // Arithmatic Operations
        } else if (tempChar.equals('+')) {
            return "Addition Operator";
        } else if (tempChar.equals('-')) {
            return "Subtraction Operator";
        } else if (tempChar.equals('*')) {
            return "Multiplication Operator";
        } else if (tempChar.equals('/')) {
            return "Division Operator";
        }

        //Paranthesis
        else if (tempChar.equals('(')) {
            return "Left Paranthesis";
        } else if (tempChar.equals(')')){
            return "Right Paranthesis";
        } 

        //Statement Terminator
        else if (tempChar.equals(';')) {
            return "Statement Terminator";
        }

        //Puncation

        else if (tempChar.equals(',')) {
            return "Punctation Token, Comma";
        }

        //Logical Operator

        else if (tempChar.equals('&')) {
            if (  ((Character)token.charAt(1)).equals('&') )  
                return "And Operator";
        }

        else if (tempChar.equals('|')) {
            if (  ((Character)token.charAt(1)).equals('|') )  
                return "Or Operator";
        }

        return null;
    }
    
}
