package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        HashMap<String,String> ht = new HashMap<>();
        InputView inputView = new InputView();
        String s = inputView.enterGameMembersName();
        String[] answer = s.split(",");
        int iterate_num = inputView.enterGameNumber();
        System.out.println(s);

        //참가자 입력 받고 해쉬 테이블에 데이터 입력 완료
        for(int i=0 ; i< answer.length ; i++){
            System.out.println("answer"+i+answer[i]);
        }

        for(int i =0 ; i< answer.length ; i++){
            ht.put(answer[i],"");
        }



        for(int i=0; i<iterate_num ; i++){
            goGame(ht,answer);
        }

        Set<String> keySet = ht.keySet();

        for(String key : keySet){
            System.out.println(key+":"+ht.get(key));
        }

    }

    private static boolean pickNumber(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        System.out.println(randomNum);
        if(randomNum >3){
            return true;
        }
        return false;
    }
    private static void goGame(HashMap<String,String> hs, String[] arr){
        for(int i=0; i< hs.size() ; i++){
            if(pickNumber()){
                String s = hs.get(arr[i])+"-";
                hs.put(arr[i],s);
            }
        }
    }
    private static void whoIsWin(HashMap<String,String> hs,String[] arr){
        String[] s = new String[arr.length];

        for(int i=0 ; i<arr.length ; i++){
            s[i] = hs.get(arr[i]);
        }

    }
    private static int maxLength(String[] str){
        int max = 0;
        for(int i=0; i< str.length ; i++){
            if(max< str[i].length()){
                max = str[i].length();
            }
        }
        return max;
    }

}
