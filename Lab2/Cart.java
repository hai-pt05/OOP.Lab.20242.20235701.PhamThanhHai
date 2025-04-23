package Aims;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0; // Biến để theo dõi số lượng DVD trong giỏ

    // Thêm một DVD vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đã thêm vào giỏ hàng của bạn");
            
            // Kiểm tra xem giỏ có gần đầy không
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("Giỏ đã đầy");
            } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
                System.out.println("Giỏ gần đầy");
            }
        } else {
            System.out.println("Giỏ đã đầy, không thể thêm!");
        }
    }

    // Xóa một DVD khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("Giỏ trống, không thể xoá!");
            return;
        }

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) { // So sánh đối tượng disc
                // Dịch chuyển các phần tử phía sau lên để lấp chỗ trống
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Xóa phần tử cuối
                qtyOrdered--;
                System.out.println("Đã xoá khỏi giỏ hàng của bạn");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm này trong giỏ hàng của bạn!");
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // Thêm phương thức để hiển thị thông tin giỏ (tùy chọn để kiểm tra)
    public void displayCart() {
        if (qtyOrdered == 0) {
            System.out.println("Giỏ hàng trống!");
            return;
        }
        System.out.println("Các sản phẩm trong giỏ hàng:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCost());
        }
        System.out.println("Số lượng sản phẩm: " + qtyOrdered);
        System.out.println("Tổng chi phí: " + totalCost());
    }
}