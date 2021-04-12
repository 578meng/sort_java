import java.util.Scanner;
import java.lang.*;
import java.io.*;
class MyArray{
    public  int length = 10;
    private  int data[] = new int[length];


    public void add() throws IOException  // 添加数据123456
    {
        Scanner  scanner  =  new  Scanner(System. in );
        for(int i = 0; this.length > i; i++) {
            this.data[i] = scanner.nextInt();
        }
        System.out.println("数据输入成功");
        for(int i = 0; this.length > i; i++) {
            System.out.print(this.data[i]+"  ");
        }
        System.out.println();
    }

//    冒泡排序
    public void bubble(){
        int[] array = this.data;
        int count = 0;
        int mid; // 定义一个中间变量，起到临时存储数据的作用
        for (int i = 0; i < array.length; i++) {
            // 执行冒泡排序法
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]) {
                    mid = array[i];
                    array[i] = array[j];
                    array[j] = mid;
                }
            }
        }
        System.out.println("\n使用冒泡法排序后的数组:");
        for (int i = 0; i < array.length; i++) {
            // 遍历排好序的array数组中的元素
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    public static int getMiddle(int[] array, int left, int right) {
        int temp;
        // 进行一趟快速排序,返回中心点位置
        int mid = array[left];
        // 把中心置于a[0]
        while (left < right) {
            while (left < right && array[right] >= mid)
                right--;
            temp = array[right];
            // 将比中心点小的数据移动到左边
            array[right] = array[left];
            array[left] = temp;
            while (left < right && array[left] <= mid)
                left++;
            temp = array[right];
            // 将比中心点大的数据移动到右边
            array[right] = array[left];
            array[left] = temp;
        }
        array[left] = mid;
        // 中心移到正确位置
        return left; // 返回中心点
    }
    public static int[] quickSort(int[] array, int left, int right) {// 快速排序法
        if (left < right - 1) {
            // 如果开始点和结点没有重叠的时候，也就是指针没有执行到结尾
            int mid = getMiddle(array, left, right);
            // 重新获取中间点
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
        return array;
    }
    public void userQS(){
        int array[] =this.data;
        int[] rs = quickSort(array, 0, 9);

        System.out.println("排序之后：");
        for (int i = 0; i < rs.length; i++) {
            // 遍历排好序的array数组中的元素
            System.out.print(" " + rs[i]);
        }
        System.out.println();
    }
    public void selectSort(){
        int array[] = this.data;
        int index,keyValue,temp;
        System.out.println("排序之前：");
        for (int i = 0; i < array.length; i++) {
            // 遍历排好序的array数组中的元素
            System.out.print(" " + array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            // 使用选择排序法的核心
            index = i;
            keyValue = array[i];
            for (int j = i; j < array.length; j++)
                if (array[j] < keyValue) {
                    index = j;
                    keyValue = array[j];
                }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        System.out.println("排序之后：");
        for (int i = 0; i < array.length; i++) {
            // 遍历排好序的array数组中的元素
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }
}
public class  Main
{


    //菜单
    public static void main(String[] args) throws IOException //将异常抛出，调用这个方法去处理异常,如果main方法也将异常抛出，则交给Java虚拟机来处理,下同.
    {
        boolean c = true && false;
        int a;
        MyArray data = new MyArray();

        while (true){
            Scanner in=new Scanner(System.in);
            System.out.println("\n*************数组排序*************");
            System.out.println("*****        1.输入10个int数据  ******");
            System.out.println("*****        2.冒泡排序         ******");
            System.out.println("*****        3.快速排序         ******");
            System.out.println("*****        4.选择排序         ******");
            System.out.println("*****        0.退出            ******");
            System.out.println("******************************************");
            System.out.print("请选择(0~5):");
            a=in.nextInt();
            while(a<0||a>5)
            {
                System.out.print("输入无效，请重新输入:");
                a=in.nextInt();
            }
            switch(a)
            {
                case 1: data.add();break;
                case 2: data.bubble();break;
                case 3: data.userQS();break;
                case 4: data.selectSort();break;
                case 0:System.out.println("成功退出！！！");System.exit(0);break;
            }
            System.out.println();
        }
    }
}