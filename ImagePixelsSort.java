/*
 * Anusha Peddigari
 * 001023769
 */
package Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author 16175
 */
public class ImagePixelsSort {

    ArrayList<Integer> pixelIntensity;

    public ImagePixelsSort() {
        pixelIntensity = new ArrayList<Integer>();
        
        try {
            
            BufferedImage image = ImageIO.read(this.getClass().getResource("Boston.jpeg"));

            
            getPixels(image);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public float printPixelARGB(int pixel) {

        
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        float intensity = (float) (0.2989 * red + 0.5870 * green + 0.1140 * blue);

        return intensity;
    }

    public void getPixels(BufferedImage image) {

        int w = image.getWidth();
        int h = image.getHeight();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int pixel = image.getRGB(j, i);
                int intens = (int) printPixelARGB(pixel);
                pixelIntensity.add(intens);
            }
        }
    }

    static class MergeSort {

        void merge(int arr[], int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            int left[] = new int[n1];
            int right[] = new int[n2];

            for (int i = 0; i < n1; ++i) {
                left[i] = (Integer) arr[l + i];
            }
            for (int j = 0; j < n2; ++j) {
                right[j] = (Integer) arr[m + 1 + j];
            }

            int i = 0, j = 0;

            int k = l;
            while (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = left[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        void sort(int arr[], int l, int r) {
            if (l < r) {

                int m = (l + r) / 2;

                sort(arr, l, m);
                sort(arr, m + 1, r);

                merge(arr, l, m, r);
            }
        }

        public void print(int[] arr) {

            System.out.print(Arrays.toString(arr));

        }
    }

    public static class HeapSort {

        public void sort(int arr[]) {
            int n = arr.length;

            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }

            for (int i = n - 1; i >= 0; i--) {

                int temp = (Integer) arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr, i, 0);
            }
        }

        void heapify(int arr[], int n, int i) {
            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;

            if (l < n && (Integer) arr[l] > (Integer) arr[largest]) {
                largest = l;
            }

            if (r < n && (Integer) arr[r] > (Integer) arr[largest]) {
                largest = r;
            }

            if (largest != i) {
                int swap = (Integer) arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                heapify(arr, n, largest);
            }
        }

        public void print(int arr[]) {

            System.out.print(Arrays.toString(arr));
        }
    }

    public static void main(String args[]) {
        ImagePixelsSort obj = new ImagePixelsSort();

        int[] arr = new int[obj.pixelIntensity.size()];

        for (int i = 0; i < obj.pixelIntensity.size(); i++) {
            if (obj.pixelIntensity.get(i) != null) {
                arr[i] = obj.pixelIntensity.get(i);
            }
        }

        System.out.println("Array length to sort: " + arr.length);

        System.out.println("Array before sorting : " + Arrays.toString(arr));

        System.out.println("-------------------------------------------------------------------");

        // Merge Sort
        Instant start = Instant.now();

        int[] arr1 = new int[obj.pixelIntensity.size()];

        for (int i = 0; i < obj.pixelIntensity.size(); i++) {
            if (obj.pixelIntensity.get(i) != null) {
                arr1[i] = obj.pixelIntensity.get(i);
            }
        }
        MergeSort ms = new MergeSort();
        int lo = 0;
        int hi = arr1.length - 1;
        ms.sort(arr1, lo, hi);
        Instant end = Instant.now();
        Duration msTime = Duration.between(start, end);
        System.out.println("printing array after merge sort");
        ms.print(arr1);
        System.out.println();
        System.out.println("Merge Sort Time in nanoseconds: " + msTime.getNano());

        System.out.println("-------------------------------------------------------------------");

        // Heap Sort
        start = Instant.now();

        int[] arr2 = new int[obj.pixelIntensity.size()];

        for (int i = 0; i < obj.pixelIntensity.size(); i++) {
            if (obj.pixelIntensity.get(i) != null) {
                arr2[i] = obj.pixelIntensity.get(i);
            }
        }

        HeapSort hs = new HeapSort();
        hs.sort(arr2);
        end = Instant.now();
        Duration hsTime = Duration.between(start, end);
        System.out.println("printing array after heap sort");
        hs.print(arr2);
        System.out.println();
        System.out.println("Heap Sort Time in nanoseconds: " + hsTime.getNano());

        System.out.println("-------------------------------------------------------------------");
    }
}
