// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
public class compute {
        public static void main(String[] var0) {
            p1.time_compute var1 = new p1.time_compute(7, 35, 45);
            p1.time_compute var2 = new p1.time_compute(11, 5, 7);
            int var3 = var2.differenceTime(var1, var2);
            System.out.println("Time duration: " + var3 + " seconds");
            int var5 = var3 / 3600;
            int var6 = var3 % 3600;
            int var7 = var6 / 60;
            int var8 = var6 % 60;
            int var9 = var8 % 60;
            System.out.println("" + var5 + " hours " + var7 + " min " + var9 + " sec ");
        }
    }