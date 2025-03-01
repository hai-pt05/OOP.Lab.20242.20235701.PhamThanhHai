public class Vector {
    private double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getter và Setter
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }

    // Phương thức cộng hai vector
    public Vector cong(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    // Phương thức trừ hai vector
    public Vector tru(Vector v) {
        return new Vector(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    // Phương thức nhân vector với một hằng số
    public Vector nhanHangSo(double k) {
        return new Vector(this.x * k, this.y * k, this.z * k);
    }

    // Phương thức tính tích vô hướng của hai vector
    public double tichVoHuong(Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    // Phương thức hiển thị thông tin vector
    public void hienThi() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}
