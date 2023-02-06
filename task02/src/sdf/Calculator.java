package sdf;

public class Calculator {

    private Integer $last;
    boolean isLive = true;

    public Calculator(String[] input, Integer $last) {

        this.$last = $last;
        
        // check if the input has length of 3
        if (input.length == 3) {

            // convert $last to value
            if (input[0].equals("$last")) {
                input[0] = String.valueOf($last);
            }
            if (input[2].equals("$last")) {
                input[2] = String.valueOf($last);
            }

            switch (input[1]) {
                case Constants.ADD:
                    addOperation(Integer.valueOf(input[0]), Integer.valueOf(input[2]));
                    break;
                case Constants.MINUS:
                    substractOperation(Integer.valueOf(input[0]), Integer.valueOf(input[2]));
                    break;
                case Constants.TIMES, Constants.MULTIPLY:
                    multiplyOperation(Integer.valueOf(input[0]), Integer.valueOf(input[2]));
                    break;
                case Constants.DIVIDE:
                    divideOperation(Integer.valueOf(input[0]), Integer.valueOf(input[2]));
                    break;
                default: {}
            }

        }
        
    }

    public boolean getStatus() {
        return isLive;
    }

    public Integer getResult() {
        return $last;
    }

    public Integer addOperation(Integer a, Integer b) {
        $last = a + b;
        return $last;
    }

    public Integer substractOperation(Integer a, Integer b) {
        $last = a - b;
        return $last;
    }

    public Integer multiplyOperation(Integer a, Integer b) {
        $last = a * b;
        return $last;
    }

    public Integer divideOperation(Integer a, Integer b) throws ArithmeticException{
        $last = a/b;
        return $last;
    }
    
}
