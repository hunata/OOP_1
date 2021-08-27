package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    private static int staticField;

    public void printPhanSo() {
        System.out.format("%d/%d\n", tuSo, mauSo);
    }

    public void inputPhanSo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("TuSo: ");
        this.tuSo = sc.nextInt();
        System.out.print("MauSo: ");
        this.mauSo = sc.nextInt();
    }

    public static PhanSo fromString(String str) {
        String[] parts = str.split("/");
        PhanSo ps = new PhanSo();
        ps.tuSo = Integer.parseInt(parts[0]);
        ps.mauSo = Integer.parseInt(parts[1]);
        return ps;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.tuSo, this.mauSo);
    }

    public void RutGonPhanSo() {
        int ucln = uocChungLonNhat(Math.abs(this.tuSo), Math.abs(this.mauSo));
        this.tuSo = this.tuSo / ucln;
        this.mauSo = this.mauSo / ucln;
    }

    private static int uocChungLonNhat(int a, int b) {
        int ucln = 0;
        if (a >= b) {
            for (int i = 1; i <= b; i++) {
                if (a % i == 0 && b % i == 0) {
                    if (ucln < i) {
                        ucln = i;
                    }
                }
            }
        } else if (a < b) {
            for (int i = 1; i <= a; i++) {
                if (a % i == 0 && b % i == 0) {
                    if (ucln < i) {
                        ucln = i;
                    }
                }
            }

        }
        return ucln;
    }

    public static ArrayList quyDongHaiPhanSo(PhanSo ps1, PhanSo ps2) {
        ArrayList<PhanSo> result = new ArrayList<>();
        int boiChungNhoNhat = (ps1.mauSo * ps2.mauSo) / uocChungLonNhat(Math.abs(ps1.mauSo), Math.abs(ps2.mauSo));
        ps1.tuSo *= boiChungNhoNhat / ps1.mauSo;
        ps1.mauSo = boiChungNhoNhat;
        ps2.tuSo *= boiChungNhoNhat / ps2.mauSo;
        ps2.mauSo = boiChungNhoNhat;
        result.add(ps1);
        result.add(ps2);
        return result;
    }

    public int compareTo(PhanSo another) {
        long tmp1 = this.tuSo * another.mauSo;
        long tmp2 = this.mauSo * another.tuSo;

        if (tmp1 > tmp2)
            return 1; // this > another

        if (tmp1 < tmp2)
            return -1; // this < another

        return 0; // this == another
    }

    public boolean isAmDuong() {
        if (this.tuSo > 0 && this.mauSo > 0) {
            return true;
        } else if (this.tuSo < 0 && this.mauSo > 0) {
            return false;
        } else if (this.tuSo > 0 && this.mauSo < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static PhanSo tongPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo ps3 = new PhanSo();
        ps3.tuSo = ps1.tuSo * ps2.mauSo + ps2.tuSo * ps1.mauSo;
        ps3.mauSo = ps1.mauSo * ps2.mauSo;
        ps3.RutGonPhanSo();
        return ps3;
    }

    public static PhanSo hieuPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo ps3 = new PhanSo();
        ps3.tuSo = ps1.tuSo * ps2.mauSo - ps2.tuSo * ps1.mauSo;
        ps3.mauSo = ps1.mauSo * ps2.mauSo;
        ps3.RutGonPhanSo();
        return ps3;
    }

    public static PhanSo tichPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo ps3 = new PhanSo();
        ps3.tuSo = ps1.tuSo * ps2.tuSo;
        ps3.mauSo = ps1.mauSo * ps2.mauSo;
        ps3.RutGonPhanSo();
        return ps3;
    }

    public static PhanSo thuongPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo ps3 = new PhanSo();
        ps3.tuSo = ps1.tuSo * ps2.mauSo;
        ps3.mauSo = ps1.mauSo * ps2.tuSo;
        ps3.RutGonPhanSo();
        return ps3;
    }

    public boolean isPhanSoToiGian() {
        int kq = uocChungLonNhat(Math.abs(this.tuSo), Math.abs(this.mauSo));
        if (kq == 1) {
            return true;
        }
        return false;
    }
}






