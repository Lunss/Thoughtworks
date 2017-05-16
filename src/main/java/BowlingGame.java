package main.java;
public class BowlingGame {
    public int getBowlingScore(String bowlingCode) {
        class Ge{
            int flag; 
            int first;
            int second;

            public Ge(String s,int last) {
                if (s.length() == 1) {
                   if(last == 0) {
                       flag = 1;
                       first = 10;
                       second = 0;
                   }else{
                       flag = 0;second=0;
                       char a = s.charAt(0);
                       if(a=='X'){
                           first = 10;
                       }else if(a=='-'){
                           first = 0;
                       }else{
                           first = a-'0';
                       }
                   }
                } else if (s.length() == 2) {
                    flag = 0;
                    char a1 = s.charAt(0);
                    char a2 = s.charAt(1);
                    if (a1 == '-') {
                        first = 0;
                    } else if (a1 == 'X') {
                        first = 10;
                    } else {
                        first = a1 - '0';
                    }
                    if (a2 == '-') {
                        second = 0;
                    } else if (a2 == 'X') {
                        second = 10;
                    } else if (a2 == '/') {
                        flag = 2;
                        flag = 2;
                        second = 10 - first;
                    } else {
                        second = a2 - '0';
                    }
                }
            }
        }
       	String[] ss = bowlingCode.split("\\|");
        Ge[] ges = new Ge[11];
        int sum = 0;
        int j=0;
        for(int i =0;i<ss.length;i++){
            if(ss[i].length()>0){
                if(i!=ss.length - 1)
                    ges[j++] = new Ge(ss[i],0);
                else
                    ges[j++] = new Ge(ss[i],1);
                //System.out.println(ges[j-1].flag);
            }
        }
        for(int i=0;i<10;i++){
            int cur=0;
            if(ges[i].flag == 0){
                cur = ges[i].first + ges[i].second;
            }else if(ges[i].flag == 1){
                if(ges[i+1].flag == 1){
                    cur = ges[i].first + ges[i+1].first + ges[i+2].first;
                }else{
                    cur = ges[i].first+ges[i+1].first+ges[i+1].second;
                }
            }else{
                cur = 10 + ges[i+1].first;
            }
            //System.out.println(cur);
            sum += cur;
        }
        System.out.println(sum);
        return 0;
    }
}