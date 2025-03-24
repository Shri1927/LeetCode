package Stack;

public class minSwapsToBalace {
    
    static int minSwaps(String s) {
        int open=0, close=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '['){
                open++;
            }else{
                if(open<=0){
                    close++;
                }else{
                    open--;
                }
            }
        }
        return (open+1)/2;
    }

    public static void main(String[] args) {
        String str = "]]][[[";
        int res = minSwaps(str);
        System.out.println(res);
    }
}
