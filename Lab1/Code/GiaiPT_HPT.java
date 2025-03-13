// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class GiaiPT_HPT {
   public GiaiPT_HPT() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("1. Phương trình bậc nhất một ẩn (ax + b = 0)");
      System.out.println("2. Hệ phương trình bậc nhất hai ẩn");
      System.out.println("3. Phương trình bậc hai (ax^2 + bx + c = 0)");
      System.out.print("Nhập loại PT cần giải: ");
      int var2 = var1.nextInt();
      switch (var2) {
         case 1:
            PT1nghiem(var1);
            break;
         case 2:
            HPT2nghiem(var1);
            break;
         case 3:
            PTB2(var1);
            break;
         default:
            System.out.println("Không hợp lệ.");
      }

      var1.close();
   }

   private static void PT1nghiem(Scanner var0) {
      System.out.print("hệ số a: ");
      double var1 = var0.nextDouble();
      System.out.print("hệ số b: ");
      double var3 = var0.nextDouble();
      if (var1 == 0.0) {
         if (var3 == 0.0) {
            System.out.println("PT có vô số nghiệm.");
         } else {
            System.out.println("PT vô nghiệm.");
         }
      } else {
         double var5 = -var3 / var1;
         System.out.println("Nghiệm của PT là: x = " + var5);
      }

   }

   private static void HPT2nghiem(Scanner var0) {
      System.out.print("hệ số a11: ");
      double var1 = var0.nextDouble();
      System.out.print("hệ số a12: ");
      double var3 = var0.nextDouble();
      System.out.print("hệ số b1: ");
      double var5 = var0.nextDouble();
      System.out.print("hệ số a21: ");
      double var7 = var0.nextDouble();
      System.out.print("hệ số a22: ");
      double var9 = var0.nextDouble();
      System.out.print("hệ số b2: ");
      double var11 = var0.nextDouble();
      double var13 = var1 * var9 - var3 * var7;
      double var15 = var5 * var9 - var11 * var3;
      double var17 = var1 * var11 - var7 * var5;
      if (var13 == 0.0) {
         if (var15 == 0.0 && var17 == 0.0) {
            System.out.println("HPT có vô số nghiệm.");
         } else {
            System.out.println("HPT vô nghiệm.");
         }
      } else {
         double var19 = var15 / var13;
         double var21 = var17 / var13;
         System.out.println("Nghiệm của HPT là:");
         System.out.println("x1 = " + var19);
         System.out.println("x2 = " + var21);
      }

   }

   private static void PTB2(Scanner var0) {
      System.out.print("hệ số a: ");
      double var1 = var0.nextDouble();
      System.out.print("hệ số b: ");
      double var3 = var0.nextDouble();
      System.out.print("hệ số c: ");
      double var5 = var0.nextDouble();
      if (var1 == 0.0) {
         System.out.println("hệ số a phải khác 0");
      } else {
         double var7 = var3 * var3 - 4.0 * var1 * var5;
         if (var7 < 0.0) {
            System.out.println("PT vô nghiệm.");
         } else {
            double var9;
            if (var7 == 0.0) {
               var9 = -var3 / (2.0 * var1);
               System.out.println("PT có nghiệm kép: x = " + var9);
            } else {
               var9 = (-var3 + Math.sqrt(var7)) / (2.0 * var1);
               double var11 = (-var3 - Math.sqrt(var7)) / (2.0 * var1);
               System.out.println("PT có hai nghiệm phân biệt:");
               System.out.println("x1 = " + var9);
               System.out.println("x2 = " + var11);
            }
         }

      }
   }
}
