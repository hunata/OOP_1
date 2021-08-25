package entities;

import java.util.ArrayList;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    private static int staticField;

    public void printPhanSo() {
        System.out.format("%d/%d\n", tuSo, mauSo);
    }


    public static PhanSo fromString(String str) {
        String[] parts = str.split("/");
//        parts = parts.
        PhanSo ps = new PhanSo();
        ps.tuSo = Integer.parseInt(parts[0]);
        ps.mauSo = Integer.parseInt(parts[1]);
        return ps;
    }

//    public static PhanSo RutGonPhanSo(PhanSo ps){
//        PhanSo ps1 = new PhanSo();
////        int ucln = ps.UocChungLonNhat(ps.tuSo, ps.mauSo);
//        ps1.tuSo = ps.tuSo/ps.UocChungLonNhat(ps.tuSo, ps.mauSo);
//        ps1.mauSo = ps.mauSo/ps.UocChungLonNhat(ps.tuSo, ps.mauSo);
//        return ps1;
//    }

    public static PhanSo RutGonPhanSo(PhanSo ps) {
        int ucln = ps.uocChungLonNhat(ps.tuSo, ps.mauSo);
        ps.tuSo = ps.tuSo / ucln;
        ps.mauSo = ps.mauSo / ucln;
        return ps;
    }

    public static int uocChungLonNhat(int a, int b) {
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
        int boiChungNhoNhat = (ps1.mauSo * ps2.mauSo) / uocChungLonNhat(ps1.mauSo, ps2.mauSo);
        ps1.tuSo *= boiChungNhoNhat / ps1.mauSo;
        ps1.mauSo = boiChungNhoNhat;
        ps2.tuSo *= boiChungNhoNhat / ps2.mauSo;
        ps2.mauSo = boiChungNhoNhat;
        result.add(ps1);
        result.add(ps2);
        return result;
    }

    public static String soSanhPhanSo(PhanSo ps1, PhanSo ps2) {
        ArrayList<PhanSo> ps = PhanSo.quyDongHaiPhanSo(ps1, ps2);
        if (ps.get(0).tuSo > ps.get(1).tuSo) {
            return "Phân số 1 nhỏ hơn phân số 2";
        } else if (ps.get(0).tuSo < ps.get(1).tuSo) {
            return "Phân số 1 lớn hơn phân số 2";
        } else return "Hai phân số bằng nhau";
    }

    public static String isAmDUongPhanSo(PhanSo ps) {
        if (ps.tuSo > 0 && ps.mauSo > 0) {
            return " Phân số này là phân số dương";
        } else if (ps.tuSo < 0 && ps.mauSo > 0) {
            return " Phân số này là phân số âm";
        } else if (ps.tuSo > 0 && ps.mauSo < 0) {
            return " Phân số này là phân số âm";
        } else {
            return " Phân số này là phân số dương";
        }
    }

    public static PhanSo tongPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo ps3 = new PhanSo();
        ps3.tuSo = ps1.tuSo * ps2.mauSo + ps2.tuSo * ps1.mauSo;
        ps3.mauSo = ps1.mauSo * ps2.mauSo;
        ps3 = RutGonPhanSo(ps3);
        return ps3;
    }

    public static PhanSo hieuPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo ps3 = new PhanSo();
        ps3.tuSo = ps1.tuSo * ps2.mauSo - ps2.tuSo * ps1.mauSo;
        ps3.mauSo = ps1.mauSo * ps2.mauSo;
        ps3 = RutGonPhanSo(ps3);
        return ps3;
    }

    public static PhanSo tichPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo ps3 = new PhanSo();
        ps3.tuSo = ps1.tuSo * ps2.tuSo;
        ps3.mauSo = ps1.mauSo * ps2.mauSo;
        ps3 = RutGonPhanSo(ps3);
        return ps3;
    }

    public static PhanSo thuongPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo ps3 = new PhanSo();
        ps3.tuSo = ps1.tuSo * ps2.mauSo;
        ps3.mauSo = ps1.mauSo * ps2.tuSo;
        ps3 = RutGonPhanSo(ps3);
        return ps3;
    }

    public static boolean isPhanSoToiGian(PhanSo ps) {
        int kq = ps.uocChungLonNhat(ps.tuSo, ps.mauSo);
        if (kq == 1) {
            return true;
        }
        return false;
    }

}

//    public void init(int tuSo, int mauSo) {
//        this.tuSo = tuSo;
//        this.mauSo = mauSo;
//        staticField ++;
//    }
//
//    public static void testStaticField(String str) {
//        System.out.println("str");
//        System.out.println(staticField);
//    }

//    public static void fromString (String str){
////        staticField =100;
//        System.out.println(str);
//        System.out.println(staticField);
//    }






