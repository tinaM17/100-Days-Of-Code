package Day7;

class Solution {
    public int romanToInt(String s) {
      //Step1:- convert the String into a character array 
        char[] ch=s.toCharArray();

        //initialize our sum variable
        int sum=0;
        int n=ch.length;

        //Step2:-runs a for loop within the character array from 0 to n-1
        for(int i=0;i<n;i++){

           //Step3:- runs a switch case for the each of the characters
            switch(ch[i]) {

                case 'I': //this is our corner cases i.e; if I placed before V (5) and X (10) then add 4 and 9. and increment i by 1;
                           if(i<n-1 && ch[i+1]=='V'){
                             sum+=4;
                             i++;
                             }
                          else if(i<n-1 && ch[i+1]=='X'){
                             sum+=9;
                             i++;}
                         //Otherwise simply add it's actual value
                          else 
                             sum+=1;
                          break;
                case 'V':sum+=5;
                          break;
                case 'X': //this is our corner cases i.e;if X placed before L (50) and C (100) then add 40 and 90. and increment i by 1;
                           if(i<n-1 && ch[i+1]=='L') {
                             sum+=40;
                             i++;}
                          else if(i<n-1 && ch[i+1]=='C'){
                             sum+=90;
                             i++;}
                        //Otherwise simply add it's actual value
                          else 
                             sum+=10;
                          break;
                case 'L':sum+=50;
                          break;
                case 'C': //this is our corner cases i.e; If C placed before D (500) and M (1000) then add 400 and 900. and increment i by 1;
                           if(i<n-1 && ch[i+1]=='D'){
                             sum+=400;
                             i++;}
                          else if(i<n-1 && ch[i+1]=='M'){
                             sum+=900;
                             i++; }
                        //Otherwise simply add it's actual value
                          else 
                             sum+=100;
                          break;
                case 'D':sum+=500;
                          break;
                case 'M':sum+=1000;
                          break;
            }
        }
        return sum;
    }
}
