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
        System.out.println("Phân số thứ nhat ");
        String input = sc.nextLine();
        PhanSo ps1 = PhanSo.fromString(input);
        // Rút gọn phân số
        PhanSo.RutGonPhanSo(ps1);
        ps1.printPhanSo();

        System.out.println("Phân số thứ hai");
        input =sc.nextLine();
        PhanSo ps2 =PhanSo.fromString(input);
        PhanSo.RutGonPhanSo(ps2);
        ps2.printPhanSo();

        // Tổng
        PhanSo ps3 = PhanSo.tongPhanSo(ps1,ps2);
        ps3.printPhanSo();

        //Hieu
        PhanSo ps4 = PhanSo.hieuPhanSo(ps1,ps2);
        ps4.printPhanSo();

        //Tích
        PhanSo ps5 = PhanSo.tichPhanSo(ps1,ps2);
        ps5.printPhanSo();

        //Thuong
        PhanSo ps6 = PhanSo.thuongPhanSo(ps1,ps2);
        ps6.printPhanSo();

        //Kiểm tra phân số tối giản
        if(PhanSo.isPhanSoToiGian(ps1)){
            System.out.println("đây là phân số tối giản");
        } else System.out.println("đây không là phân số tối giản");

        //Quy đồng
        ArrayList<PhanSo>  ps7 = PhanSo.quyDongHaiPhanSo(ps1,ps2);
        ps7.get(0).printPhanSo();
        ps7.get(1).printPhanSo();

        //So sánh
        String kq = PhanSo.soSanhPhanSo(ps1, ps2);
        System.out.println(kq);

        //Kiểm tra âm dương
        String kq1 = PhanSo.isAmDUongPhanSo(ps1);
        System.out.println(kq1);
    }
}


//        PhanSo ps = new PhanSo();
//        ps.init(1,3);
//        ps.print();
//        PhanSo.fromString("1/4");
//
//
//        PhanSo ps2 = new PhanSo();
//        ps.init(2,3);
//        ps.print();
//        PhanSo.fromString("1/5");


//        PhanSo.testStaticField("1/4");



