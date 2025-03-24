package Stack;

public class minSwaptoBalanceBrackets {
    
    static int minimumNumberOfSwaps(String s) {
        // code here
        int open =0, close=0,unBalaceBrackets=0,swaps=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '['){
                open++;
                if(unBalaceBrackets>0){
                    swaps+=unBalaceBrackets;
                    unBalaceBrackets--;
                }
            }else{
                close++;
                unBalaceBrackets = close-open;
            }
        }
        return swaps;
    }
}
