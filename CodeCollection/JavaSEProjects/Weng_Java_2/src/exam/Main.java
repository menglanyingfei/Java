package exam;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-16
 * ?
 */
public class Main {

	static Scanner in = new Scanner(System.in);
    static int width = 0;// 宽度
    static int height = 0;// 高度
    static int[][] field_old;// 旧的网格
    static int[][] field_new;// 新的网格
    static int times;// 步数
 
    public static void main(String[] args) {
        // 首先输入两个正整数，范围为[3,102]，依次表示网格的宽度和高度。
        width = in.nextInt();
        height = in.nextInt();
 
        // 初始化数组
        initial();
 
        // 然后，以一个正整数，范围为[1,10000]，表示要求细胞自动机执行的步数。
        times = in.nextInt();
 
        // 细胞自动机执行
        run(times);
 
        System.out.println(count(field_old));// 输出一个正整数，表示执行完毕后，剩下的活着的细胞的数量。
    }
 
    // 初始化数组
    public static void initial() {
        field_old = new int[height][width];
        field_new = new int[height][width];
 
        for (int i = 0; i < field_old.length; i++) {
            for (int j = 0; j < field_old[i].length; j++) {
                field_old[i][j] = 0;
                field_new[i][j] = 0;
            }
        }
 
        // 然后输入多组正整数，依次表示一个活着的细胞的网格位置，每组数字中，第一个表示行号，第二个表示列号，均从0开始编号。
        while (true) {
            int i = in.nextInt();
            int j = in.nextInt();
 
            if (i == -1 && j == -1) {
                break;// 最后，以“-1 -1”表示不再有活着的细胞。-1 -1不是有效的位置。
            }
 
            field_old[i][j] = 1;
            field_new[i][j] = 1;
        }
    }
 
    // 细胞自动机执行
    public static void run(int times) {
        int number = 0;
 
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < field_old.length; j++) {
                for (int k = 0; k < field_old[j].length; k++) {
                    number = getNeighbour(j, k);// 计算周围活着的细胞
 
                    if (field_old[j][k] == 1 && (number == 2 || number == 3)) {
                        field_new[j][k] = 1;
                    } else {
                        field_new[j][k] = 0;
                    }
 
                    if (field_old[j][k] == 0 && number == 3) {
                        field_new[j][k] = 1;
                    }
                }
            }
 
            for (int j = 0; j < field_new.length; j++) {
                for (int k = 0; k < field_new[j].length; k++) {
                    field_old[j][k] = field_new[j][k];// 把新的复制到旧的
                }
            }
        }
    }
 
    // 计算周围活着的细胞
    public static int getNeighbour(int i, int j) {
        int number = 0;
 
        if (i == 0 && j == 0) {// 左上角
            number = field_old[i][j + 1] + field_old[i + 1][j + 1] + field_old[i + 1][j];
        } else if (i == 0 && j == width - 1) {// 右上角
            number = field_old[i][j - 1] + field_old[i + 1][j - 1] + field_old[i + 1][j];
        } else if (i == height - 1 && j == 0) {// 左下角
            number = field_old[i - 1][j] + field_old[i - 1][j + 1] + field_old[i][j + 1];
        } else if (i == height - 1 && j == width - 1) {// 右下角
            number = field_old[i - 1][j] + field_old[i - 1][j - 1] + field_old[i][j - 1];
        } else if (i == 0) {// 首行其他
            number = field_old[i][j - 1] + field_old[i + 1][j - 1] + field_old[i + 1][j] + field_old[i + 1][j + 1]
                    + field_old[i][j + 1];
        } else if (i == height - 1) {// 末行其他
            number = field_old[i][j - 1] + field_old[i - 1][j - 1] + field_old[i - 1][j] + field_old[i - 1][j + 1]
                    + field_old[i][j + 1];
        } else if (j == 0) {// 最左其他
            number = field_old[i - 1][j] + field_old[i - 1][j + 1] + field_old[i][j + 1] + field_old[i + 1][j + 1]
                    + field_old[i + 1][j];
        } else if (j == width - 1) {// 最右其他
            number = field_old[i - 1][j] + field_old[i - 1][j - 1] + field_old[i][j - 1] + field_old[i + 1][j - 1]
                    + field_old[i + 1][j];
        } else {// 其他
            number = field_old[i - 1][j - 1] + field_old[i - 1][j] + field_old[i - 1][j + 1] + field_old[i][j + 1]
                    + field_old[i + 1][j + 1] + field_old[i + 1][j] + field_old[i + 1][j - 1] + field_old[i][j - 1];
        }
 
        return number;
    }
 
    // 剩下的活着的细胞的数量
    public static int count(int[][] field) {
        int number = 0;
 
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    number++;
                }
            }
        }
 
        return number;
    }

}
