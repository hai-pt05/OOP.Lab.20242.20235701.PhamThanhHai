package Aims;

public class Cart_Sec14 {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Phương thức 1: Thêm một DVD (đã có sẵn)
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đã thêm vào giỏ hàng của bạn");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("Giỏ đã đầy");
            } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
                System.out.println("Giỏ gần đầy");
            }
        } else {
            System.out.println("Giỏ đã đầy, không thể thêm!");
        }
    }

    // Phương thức 2 (Sec14.1): Thêm mảng DVD
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("Đã thêm '" + disc.getTitle() + "' vào giỏ hàng của bạn");
            } else {
                System.out.println("Giỏ đã đầy, không thể thêm '" + disc.getTitle() + "'!");
                break;
            }
        }
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("Giỏ đã đầy");
        } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
            System.out.println("Giỏ gần đầy");
        }
    }

    // Phương thức 3 (14.2): Thêm hai DVD 
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Thêm dvd1
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("Đã thêm '" + dvd1.getTitle() + "' vào giỏ hàng của bạn");
        } else {
            System.out.println("Giỏ đã đầy, không thể thêm '" + dvd1.getTitle() + "'!");
            return; // Thoát nếu không thêm được dvd1
        }

        // Thêm dvd2
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("Đã thêm '" + dvd2.getTitle() + "' vào giỏ hàng của bạn");
        } else {
            System.out.println("Giỏ đã đầy, không thể thêm '" + dvd2.getTitle() + "'!");
            return;
        }

        // Kiểm tra trạng thái giỏ sau khi thêm
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("Giỏ đã đầy");
        } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
            System.out.println("Giỏ gần đầy");
        }
    }

    // Xóa một DVD khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("Giỏ trống, không thể xoá!");
            return;
        }
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Đã xoá khỏi giỏ hàng của bạn");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm này trong giỏ hàng của bạn!");
    }

    // Tính tổng chi phí
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // Hiển thị giỏ
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