import java.util.Optional;

import static java.lang.System.out;
public class main {
    public static void main(String[] args) {
        int sqrt_x = 2655; // само число из которого нужно извлечь корень
        out.println("1) Число из которого нужно извлечь корень: " + sqrt_x);
        int amount_sqrt_x = (int)(Math.ceil(Math.log10(sqrt_x))); // вычисляем сколько цифр в этом числе
        out.println("2) Сколько цифр в числе из которого нужно извлечь корень: " + amount_sqrt_x);
        int x = 0; // переменная для количества разрядов
        int y = 1; // переменная для числа первого разряда из которого нужно вычислить корень
        if(amount_sqrt_x%2 != 0) // определяет сколько разрядов
        {
            x = (amount_sqrt_x/2)+1;
        }
        else {
            x = amount_sqrt_x/2;
        }
        out.println("3) Разрядов в этом числе: " + x);
        for(int i = 1; i < x; i++) // определяет число первого разряда
        {
            y *= 100;
        }
        out.println("4) Это на сколько нужно делить число, чтобы получить число первого разряда: " + y);
        int firstrank = sqrt_x/y; // число первого разряда
        out.println("5) Число первого разряда: " + firstrank);
        out.println("6) Корень из числа первого разряда/первое число ответа: " + sqrt(firstrank));//Вот первое число ответа
        int z = firstrank - (sqrt(firstrank)*sqrt(firstrank)); // Составляющее цифра к которой добавиться числа из другого разряда
        out.println("7) Составляющее цифра к которой добавиться числа из другого разряда: " + z);
        int z2 = sqrt(firstrank)*2;//Составляющая цифра к которой нужно подобрать и умножить что-то там
        out.println("8) Составляющая цифра к которой нужно подобрать и умножить что-то там: " + z2);

        //Теперь нужно сделать так чтобы к переменной z добавились числа из 2 разряда(название переменной desired - с англ искомый)
        //Это число которое получится нужно получить из формулы z2n * n, где n нужно подобрать(название unknown - типо неизвестное)
        //Также из формулы z2n * n, n это второе число ответа
        //дальше из desired нужно вычесть unknown, пусть переменная будет называться alpha
        //к alpha нужно добавить числа 3 разряда, если их нет то будут нули, это число тоже самое что и desired
        //Два числа ответа нужно *2 и к нему, по формуле xn*n высчитать desired
        //ну и так до бесконечности можно
        //бля ща 2 часа ночи, но я хочу удивить так сказать никиту
        //а то он думает что я нихуя не делаю
        //кста про гит хаб нужно будет сказать)
        //ссылку сюда закину https://dzen.ru/media/mathematic/kak-izvlekat-kvadratnyi-koren-v-stolbik-pokazyvaiu-prostoi-algoritm-5f2789e4e0c3a01da2d75397
        
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
            int temporarily = (left_border + right_border) / 2; // среднее между границ
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