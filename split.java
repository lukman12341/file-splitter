package browserhistory;
import java.util.Scanner;
import java.util.Stack;

public class split {
    private StringBuilder text;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public split() {
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Menampilkan semua teks yang ditulis
    public void show() {
        System.out.println("Isi Teks: " + text.toString());
    }

    // Mengembalikan isi teks ke isi sebelumnya
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada aksi untuk di-undo.");
            return;
        }
        redoStack.push(text.toString()); // Simpan teks saat ini ke redo stack
        text = new StringBuilder(undoStack.pop()); // Kembali ke teks sebelumnya
        System.out.println("Undo berhasil.");
    }

    // Memulihkan pengembalian isi teks ke isi yang lebih baru
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada aksi untuk di-redo.");
            return;
        }
        undoStack.push(text.toString()); // Simpan teks saat ini ke undo stack
        text = new StringBuilder(redoStack.pop()); // Kembali ke teks yang lebih baru
        System.out.println("Redo berhasil.");
    }

    // Menambahkan teks ke dalam text editor
    public void write(String newText) {
        undoStack.push(text.toString()); // Simpan teks saat ini ke undo stack
        text.append(newText); // Tambahkan teks baru
        redoStack.clear(); // Kosongkan redo stack setelah aksi baru
        System.out.println("Teks ditambahkan.");
    }

    // Fungsi utama untuk menjalankan program
    public static void main(String[] args) {
        split editor = new split();
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("\nPilihan:");
            System.out.println("1. Tampilkan Teks");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Tulis Teks");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan (1/2/3/4/5): ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    editor.show();
                    break;
                case "2":
                    editor.undo();
                    break;
                case "3":
                    editor.redo();
                    break;
                case "4":
                    System.out.print("Masukkan teks yang ingin ditambahkan: ");
                    String newText = scanner.nextLine();
                    editor.write(newText);
                    break;
                case "5":
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}



