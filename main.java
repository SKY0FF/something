import java.util.Optional;

import static java.lang.System.out;
public class main {
    public static void main(String[] args) {
        int sqrt_x = 555; // само число из которого нужно извлечь корень
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
        out.println("6) Корень из числа первого разряда: " + sqrt(firstrank));
        int z = firstrank - sqrt(firstrank); // число первого разряда - корень из числа первого разряда
        // ТАКЖЕ ЭТО ПЕРВОЕ ЧИСЛО ОТВЕТА
        int z2 = (z*100) + (sqrt_x%100); // через 2 дня зашел в код, что это такое?

        System.out.println(z2);
        out.println(z); // вывод первого числа ответа
        out.println(sqrt(3) + " " + sqrt_x/y);
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