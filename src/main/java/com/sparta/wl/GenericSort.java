package com.sparta.wl;

import java.util.Arrays;

public class GenericSort <T extends Comparable<? super T>>  {
    public static void main(String[] args)
    {
        Integer[] numbers = {3,60,35,2,45,320,5};
        GenericSort<Integer> sorter = new GenericSort<>();
        sorter.selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    void selectionSort(T[] array)
    {
        for (int currentIndex = 0; currentIndex < array.length - 1; currentIndex ++)
        {
            int minIndex = currentIndex;
            for (int i = currentIndex + 1; i < array.length; i ++)
            {
                if (array[i].compareTo(array[minIndex]) < 0)
                {
                    minIndex = i;
                }
            }
            if (minIndex != currentIndex)
            {
                T temp = array[currentIndex];
                array[currentIndex] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
