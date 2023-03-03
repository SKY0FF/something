import java.util.Scanner;
import static java.lang.System.out;

public class index {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        out.print("Введи число из которого нужно извлечь корень: ");
        int sqrt_x = in.nextInt(); // само число из которого нужно извлечь корень

        int amount_sqrt_x = (int)(Math.ceil(Math.log10(sqrt_x))); // вычисляем сколько цифр в этом числе

        int x; // переменная для количества разрядов
        int y = 1; // переменная для числа первого разряда из которого нужно вычислить корень

        if(amount_sqrt_x%2 != 0) // определяет сколько разрядов
        {
            x = (amount_sqrt_x/2)+1;
        }
        else {
            x = amount_sqrt_x/2;
        }

        for(int i = 1; i < x; i++) // определяет число первого разряда
        {
            y *= 100;
        }

        int first_rank = sqrt_x/y; // число первого разряда

        int z = first_rank - (sqrt(first_rank)*sqrt(first_rank)); // составляющее цифра к которой добавиться числа из другого разряда

        int z_2 = sqrt(first_rank)*2;// составляющая цифра к которой нужно подобрать и умножить что-то там

        int y2 = 1; // вспомогательная переменная
        if(y==10000){
            y2=100;
        }

        int desired = (z*100)+(sqrt_x%y/y2); // число которое нужно найти путем подбора

        if (desired == 0){ // если искомое число 0 значит мы уже нашли корень, если нет то продолжаем
            out.println("Корень из " + sqrt_x + " равен " + sqrt(first_rank));
            System.exit(0);
        }

        int n = search(desired, z_2);// вторая цифра ответа

        if (sqrt_x == ((sqrt(first_rank)*10+n)*(sqrt(first_rank)*10+n))){
            int answer = ((sqrt(first_rank))*10)+n;
            out.println("Корень из " + sqrt_x + " равен " + answer);
            System.exit(0);
        }

        int i = sqrt_x%(y/y2);
        if(i == (sqrt_x%y/y2)){
            i = 0;
        }

        int desired_2 = ((desired - ((z_2 * 10) + n) * n)*100)+i;// другое число которое нужно найти путем подбора
        int z_3 = (sqrt(first_rank)*10+n) * 2;// составляющая число к которой нужно подобрать и умножить что-то там

        int n_2 = search(desired_2, z_3);// 3 число ответа

        if ((sqrt(first_rank)*100+n*10+n_2)*(sqrt(first_rank)*100+n*10+n_2) == sqrt_x){
            int answer = sqrt(first_rank)*100+n*10+n_2;
            out.println("Корень из " + sqrt_x + " равен " + answer);
            System.exit(0);
        }

        int desired_3 = ((desired_2 - ((z_3 * 10) + n_2) * n_2)*100);// число которое нужно найти путем подбора
        int z_4 = (sqrt(first_rank)*100+n*10+n_2) * 2;//составляющая число к которой нужно подобрать и умножить что-то там

        int n_3 = search(desired_3, z_4);// 4 число ответа

        int desired_4 = ((desired_3 - ((z_4 * 10) + n_3) * n_3)*100);// число которое нужно найти путем подбора
        int z_5 = (sqrt(first_rank)*1000+n*100+n_2*10+n_3) * 2;//составляющая число к которой нужно подобрать и умножить что-то там

        int n_4 = search(desired_4, z_5);// 5 число ответа

        int desired_5 = ((desired_4 - ((z_5 * 10) + n_4) * n_4)*100);// число которое нужно найти путем подбора
        int z_6 = (sqrt(first_rank)*10000+n*1000+n_2*100+n_3*10+n_4) * 2;//составляющая число к которой нужно подобрать и умножить что-то там

        int n_5 = search(desired_5, z_6);// 6 число ответа

        int desired_6 = ((desired_5 - ((z_6 * 10) + n_5) * n_5)*100);// число которое нужно найти путем подбора
        int z_7 = (sqrt(first_rank)*100000+n*10000+n_2*1000+n_3*100+n_4*10+n_5) * 2;//составляющая число к которой нужно подобрать и умножить что-то там

        int n_6 = search(desired_6, z_7);// 7  число ответа

        int desired_7 = ((desired_6 - ((z_7 * 10) + n_6) * n_6)*100);// число которое нужно найти путем подбора
        int z_8 = (sqrt(first_rank)*1000000+n*100000+n_2*10000+n_3*1000+n_4*100+n_5*10+n_6) * 2;//составляющая число к которой нужно подобрать и умножить что-то там

        int n_7 = search(desired_7, z_8);//8 число ответа

        if(sqrt_x > 10000){
            out.println("Корень из "+ sqrt_x + " равен " + (sqrt(first_rank)*100+n*10+n_2) + "," + n_3 + n_4 + n_5 + n_6 + n_7);
        }
        else if(sqrt_x > 100){
            out.println("Корень из "+ sqrt_x + " равен " + (sqrt(first_rank)*10+n) + "," + n_2 + n_3 + n_4 + n_5 + n_6 + n_7);
        }

        else if(sqrt_x < 100){
            out.println("Корень из "+ sqrt_x + " равен " + (sqrt(first_rank)) + "," + n + n_2 + n_3 + n_4 + n_5 + n_6 + n_7);
        }

    }
    public static int search(int x, int y){ // высчитывает число n
        int i;
        int z = 0;
        for(i = 1; i < 11; i++){
            int n = x - ((y * 10) + i) * i;
            if (n < 0){
                z = 1;
                break;
            }
            else if(n == 0) {
                break;
            }

            if(i == 10){
                z = 1;
                break;
            }
        }
        return i-z;
    }
    public static int sqrt(int n){ // вычисляет корень не превышающий число
        if(n == 1) // если импортированное число 1, то возвращаем 1
        {
            return 1;
        }
        else
        {
            int left_border = 0; // левая граница
            int right_border = n; // правая граница
            int temporarily; // среднее между границ
            int t = n; // вспомогательная перменная
            for (;;) { // бесконечный цикл вычисляющий корень не превосходящий корня разрядов
                temporarily = (right_border + left_border) / 2;
                if (temporarily == t || temporarily * temporarily == n) {
                    break;
                }
                if (temporarily * temporarily < n) {
                    left_border = temporarily;
                } else {
                    right_border = temporarily;
                }
                t = temporarily;
            }
            return temporarily; // возврат корня не превосходящего корня разрядов
        }
    }
}