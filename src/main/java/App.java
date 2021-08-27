import entities.PhanSo;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /*
            Khai báo kiểu dữ liệu phân số (PHANSO)
            Nhập/Xuất phân số
            Rút gọn phân số
            Tính tổng, hiệu, tích, thương hai phân số
            Kiểm tra phân số tối giản
            Quy đồng hai phân số
            Kiểm tra phân số âm hay dương
            So sánh hai phân số
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào phân số  ");
        String inputPs1 = sc.nextLine();

        PhanSo ps1 = PhanSo.fromString(inputPs1);
        ps1.printPhanSo();
        // Rút gọn phân số
        ps1.RutGonPhanSo();
        ps1.printPhanSo();

        PhanSo ps2 = PhanSo.fromString("4/8");
        System.out.println(ps2);

        // Tổng
        PhanSo ps3 = PhanSo.tongPhanSo(ps1, ps2);
        ps3.printPhanSo();

        //Hieu
        PhanSo ps4 = PhanSo.hieuPhanSo(ps1, ps2);
        ps4.printPhanSo();

        //Tích
        PhanSo ps5 = PhanSo.tichPhanSo(ps1, ps2);
        ps5.printPhanSo();

        //Thuong
        PhanSo ps6 = PhanSo.thuongPhanSo(ps1, ps2);
        ps6.printPhanSo();

        //Kiểm tra phân số tối giản
        if (ps1.isPhanSoToiGian()) {
            System.out.println("đây là phân số tối giản");
        } else System.out.println("đây không là phân số tối giản");

        //Quy đồng
        ArrayList<PhanSo> ps7 = PhanSo.quyDongHaiPhanSo(ps1, ps2);
        ps7.get(0).printPhanSo();
        ps7.get(1).printPhanSo();

       //So sánh
        if (ps1.compareTo(ps2) < 0) {
            // System.out.format("%d/%d < %d/%d\n", ps1.getTuSo(), ps1.getMauSo(), ps2.getTuSo(), ps2.getMauSo());
            // System.out.format("%s < %s", ps1.getDisplayString(), ps2.getDisplayString());
            System.out.format("%s < %s\n", ps1, ps2);
        } else if (ps1.compareTo(ps2) > 0) {
            // System.out.format("%d/%d > %d/%d\n", ps1.getTuSo(), ps1.getMauSo(), ps2.getTuSo(), ps2.getMauSo());
            System.out.format("%s > %s\n", ps1, ps2);
        } else {
            // System.out.format("%d/%d == %d/%d\n", ps1.getTuSo(), ps1.getMauSo(), ps2.getTuSo(), ps2.getMauSo());
            System.out.format("%s == %s\n", ps1, ps2);
        }
      //Kiểm tra âm dương
        if (ps1.isAmDuong()) {
            System.out.format("%s là phân số dương.", ps1);
        } else System.out.format("%s là phân số âm.", ps1);
    }
}
