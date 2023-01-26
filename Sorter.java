import java.lang.Thread;

public class Sorter {

    public static void main(String[] args) {

        int[] list = new int[10];

        Sorter sorter = new Sorter();

        sorter.fromLengthToOne(list);
        sorter.arrayMixer(list);
        sorter.insertionSort(list);
    }

    public int[] fromLengthToOne(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = array.length-i;
        }        
        return array;
    }

    public int[] arrayMixer(int[] array) {

        fromLengthToOne(array);
        for (int i = 0; i < array.length*2; i++) {
            int index1 = (int)(Math.floor(Math.random()*array.length));
            int index2 = (int)(Math.floor(Math.random()*array.length));
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return array;
    }

    public int[] mergeSort(int[] array) {
        return array;
    }

    public int[] insertionSort(int[] array) {

        arrayToGraph(array);
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    arrayToGraph(array);
                    mySleep(100);
                }
                else {
                    break;
                }
            }
        }
        return array;
    }

    public int[] selectionSort(int[] list) {
        
        arrayToGraph(list);
        for (int i = 0; i < list.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < list.length; j++) {
                if (list[minIndex] > list[j]) {
                    minIndex = j;
                }
                if (j == list.length-1) {
                    if(minIndex != i) {
                        int temp = list[minIndex];
                        list[minIndex] = list[i];
                        list[i] = temp;
                        arrayToGraph(list);
                        mySleep(150);
                    }
                }
            }
        }
        return list;
    }

    public int[] bubbleSort(int[] list) {

        arrayToGraph(list);
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length-1; j++) {
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    arrayToGraph(list);
                    mySleep(100);
                }
            }
        }
        return list;
    }

    public void mySleep(int miliSecond) {
        try {
            Thread.sleep(miliSecond);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public void displayArray(int[] list) {

        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    } 

    public void arrayToGraph(int[] list) {

        for (int i = list.length; i > 0; i--) {
            for (int j = 0; j < list.length; j++) {
                if (list[j]-i > -1) {
                    System.out.print("[]");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
        
    }
}