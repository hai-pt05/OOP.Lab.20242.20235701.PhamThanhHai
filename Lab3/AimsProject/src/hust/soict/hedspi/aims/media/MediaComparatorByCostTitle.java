package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    // compare - Sắp xếp theo cost (giảm dần), nếu cost giống nhau thì theo title (tăng dần)
    public int compare(Media m1, Media m2) {
        if (m1 == null || m2 == null) {
            throw new NullPointerException("Cannot compare null Media objects");
        }
        // So sánh theo cost (giảm dần)
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        // Nếu cost giống nhau, so sánh theo title (tăng dần)
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
