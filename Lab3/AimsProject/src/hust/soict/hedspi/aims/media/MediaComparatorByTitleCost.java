package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    // compare - Sắp xếp theo title (tăng dần), nếu title giống nhau thì theo cost (giảm dần)
    public int compare(Media m1, Media m2) {
        if (m1 == null || m2 == null) {
            throw new NullPointerException("Cannot compare null Media objects");
        }
        // So sánh theo title (tăng dần)
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // Nếu title giống nhau, so sánh theo cost (giảm dần)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
