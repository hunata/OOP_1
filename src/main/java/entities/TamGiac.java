package entities;

public class TamGiac {
    private Diem d1, d2, d3;

    public TamGiac() {
        this.d1 = Diem.generate();
        this.d2 = Diem.generate();
        this.d3 = Diem.generate();
    }

    public TamGiac(Diem d1, Diem d2, Diem d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

//    @Override
//    public String toString() {
//        final StringBuffer sb = new StringBuffer("TamGiac{\n");
//        sb.append(" d1=").append(d1).append("\n");
//        sb.append(" d2=").append(d2).append("\n");
//        sb.append(" d3=").append(d3).append("\n");
//        sb.append('}');
//        return sb.toString();
//    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TamGiac{\n");
        sb.append(" d1 = ").append("(").append(d1.getX()).append(", ").append(d1.getY()).append(")").append("\n");
        sb.append(" d2 = ").append("(").append(d2.getX()).append(", ").append(d2.getY()).append(")").append("\n");
        sb.append(" d3 = ").append("(").append(d3.getX()).append(", ").append(d3.getY()).append(")").append("\n");
        sb.append('}');
        return sb.toString();
    }
    public double tinhChuViTamGiac(){
        double a = this.d1.distance(this.d2);
        double b = this.d1.distance(this.d3);
        double c = this.d2.distance(this.d3);
        return a+b+c;
    }

    public double tinhDienTichTamGiac(){
        double a = this.d1.distance(this.d2);
        double b = this.d1.distance(this.d3);
        double c = this.d2.distance(this.d3);
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
