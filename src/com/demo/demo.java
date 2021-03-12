package com.demo;


import java.util.Scanner;

/**
 * @author kotwaru
 */
public class demo {

    public static void main(String[] args) {
//        rabbit(10);//菲波拉契数列
//        countPrime(1,10);//判断101-200 之间有多少个素数,并输出所有素数
//        find(100,1000);//水仙花数,100-1000
//        split(101);//因式分解
//        find2(24,60);//最大公约数，最小公倍数
//        tongji();//统计出其中英文字母、空格、数字和其它字符的个数。
//        find3();//完数
//        qiu(100,1);
//        System.out.println(Monkey(1,2,1,10));  //猴子吃桃 方程解法
//        System.out.println(total(1));  //猴子吃桃 一般方式
    }

    /**
     * 题目：古典问题：有一对兔子,从出生后第3 个月起每个月都生一对兔子,小兔子长到第三个月后每个月
     * 又生一对兔子,假如兔子都不死,问每个月的兔子总数为多少？
     * 菲波拉契数列 0 1 1 2 3 5 8,后一个数等于前两个数之和
     * 解题思路：1 1 2 3 5 8 13。
     */
    public static void rabbit(int month) {
        int num_before = 1;
        int num_after = 1;
        int temp = 0;
        for (int i = 1; i <= month; i++) {
            if (i == 1 || i == 2) {
                System.out.println("第" + i + "个月," + num_after + "只兔子");
                continue;
            }
            temp = num_after + num_before;
            num_before = num_after;
            num_after = temp;
            System.out.println("第" + i + "个月," + num_after + "只兔子");
        }
    }

    /**
     * 判断101-200 之间有多少个素数,并输出所有素数
     * 素数，即质数，除1和本身外无其他因数，反之，合数。
     */
    public static void countPrime(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            boolean prime = true;//默认是质数
            for (int j = 2; j <= Math.sqrt(i); j++) {//以开方数为对称点
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 水仙花数,100-1000
     * 153 = 1^3+5^3+3^3
     */
    public static void find(int start, int end) {
        //默认start < end,且数据合法,start > 100, end < 1000
        int count = 0;
        for (int i = start; i <= end; i++) {
            int bai = i / 100 % 10;
            int shi = i / 10 % 10;
            int ge = i % 10;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                count++;
                System.out.println(String.format("第 %d 个水仙花数：%d", count, i));
            }
        }
    }

    /**
     * 因式分解
     */
    public static String split(int splited) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(splited+"=");
        int temp = splited;
        for (int i = 1; i <= temp; i++) {
            if (temp % i == 0) {
                stringBuffer.append(i + "*");
                temp = temp / i;
                if (i != 1) {
                    i = 1;
                }
            }
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        System.out.println(substring);
        return substring;
    }

    /**
     * 最大公约数，最小公倍数
     */
    public static void find2(int num1,int num2){
        int max = num1 > num2 ? num1:num2;
        int min = num1 > num2 ? num2:num1;
        int ji = max*min;
        while (min != 0){
            int temp = max%min;
            max = min;
            min = temp;
        }
        System.out.println("最大公约数："+ max);
        System.out.println("最小公倍数："+ ji/max);
    }

    //输入一行字符,分别统计出其中英文字母、空格、数字和其它字符的个数。英文字母(65-90,97-122),空格（10）,数字（48 - 57）
    public static void tongji(){
        Scanner s1 = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = s1.nextLine();
        char[] ch=str.toCharArray();
        int zg=0,kg=0,sg=0,qg=0,chg=0;
        for(int i = 0 ; i < ch.length; i++){
            if(ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >= 'A' && ch[i] <= 'Z'){
                zg++;
            }else if(ch[i] == ' '){
                kg++;
            }else if(ch[i] >= '0' && ch[i] <= '9'){
                sg++;
            }else if(Character.isLetter(ch[i])) {//中文
                chg++;
            }
            else{
                qg++;
            }
        }
        System.out.println(str+" 中的英文字母有"+zg+"个，"+"中文有"+chg+"个，"+"空格的个数有"+kg+"个，"+"数字的个数有"+sg+"个,"+"其它字符有"+qg+"个。");
    }

    /**
     * 一个数如果恰好等于它的因子之和,这个数就称为"完数"。例如6=1＋2＋3
     * 除6以外的完全数，它们被3除余1，9除余1，还有1/2被27除余1
     * 1000以内的完数
     */
    public static void find3(){
        int c = 0;
        for(int i = 0; i < 10000; i++){
            int sum = 0;//
            /*当代数学家奥斯丁·欧尔证明，若有奇完全数，则其形式必然是12^p+1或36^p+9的形式，其中p是素数。在10^300以下的自然数中奇完全数是不存在的
            所以最大的自然是它的一半
            **/
            for(int j = 1; j <= i/2; j++){
                if(i % j == 0){
                    sum += j;
                }
            }
            if(sum == i && i != 0){
                c++;
                System.out.println(i);
            }
        }
    }

    /**
     * 一球从100 米高度自由落下,每次落地后反跳回原高度的一半;再落下,
     * 相当于 hn = h*(1/2)^n n是弹跳次数
     * 等比数列前n项和：a1(1-q^n)/(1-q) (q≠1)，这里的是弹跳所以首项是1/2
     */
    public static void qiu(int high,int count){
        double h = (double)high;
        double hn;
        double H;
        hn = high * Math.pow(0.5,count);//pow(a,b) = a^b
        H = high + high * (1 - Math.pow(0.5,count));
        System.out.println(String.format("第 %d 次：高度为 %f ，总路程为：%f",count,hn,H));
    }

    /**
     * 有1、2、3、4 四个数字,能组成多少个互不相同且无重复数字的三位数？都是多少？
     * 数量:4!
     */
    public static void listNum(){
        int count = 0;
        System.out.println("这些数字为：");
        for (int i = 1 ;i<=4;i++){
            for (int j = 1;j<=4;j++){
                for (int k = 1; k<=4; k++){
                    if(i!=j && i!=k && j!=k){
                        count++;
                        System.out.println(i*100+j*10+k);
                    }
                }
            }
        }
        System.out.println("共"+count+"个");
    }

    /**
     * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个   第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下   的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     * 设猴子摘了X个桃
     * 第一天：x/2 - 1
     * 第二天：(x/2 - 1 ) * 1/2 - 1 = x/4 - 1/2 - 1
     * 第三天：(x/4 - 1/2 -1 ) * 1/2 -1 = x/8 -1/4 - 1/2 - 1
     * .....  中间实际是个等比数列
     * 第 n 天：x/x^ - a1(1-q^n)/(1-q) -1 -> ( x - 2 ) / x^n - 2
     */
    /**
     *
     * @param last 剩余数
     * @param Proportion 比例  （吃的比例） 1/2 输 2, 1/3 输 3
     * @param and 偏正 （每次多吃了几个）
     * @param day 天数 （吃了几天）
     * @return
     */
    public static double Monkey(int last, int Proportion, int and, int day){
        double sum;
        //由于最后一天没吃，所以实际吃了 day - 1 次
        sum = ((double) last + 2 * and) * Math.pow((double) Proportion, (double) day - 1) - (double) Proportion;
        return sum;
    }

    //逆向的
    public static int total(int day){
        if(day == 10){
            return 1;
        }
        else{
            return (total(day+1)+1)*2;
        }
    }

}
