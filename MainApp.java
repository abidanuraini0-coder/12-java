public class MainApp {

    public static void main(String[] args) {

        HeroDAO dao = new HeroDAO();

        // ================= SEED DATA (JALANKAN SEKALI) =================
        System.out.println("=== INSERT DATA (AWAL) ===");
        dao.tambahHero(new Hero(1, "Alucard", 50));
        dao.tambahHero(new Hero(2, "Layla", 30));

        // ================= READ AWAL =================
        System.out.println("\n=== DATA SEBELUM UPDATE & DELETE ===");
        dao.ambilSemuaHero();

        // ================= UPDATE =================
        System.out.println("\n=== UPDATE LEVEL HERO ===");
        dao.updateLevel(1, 100);
        System.out.println("Level hero berhasil diupdate!");

        // ================= DELETE =================
        System.out.println("\n=== DELETE HERO ===");
        dao.hapusHero(2);
        System.out.println("Hero berhasil dihapus!");

        // ================= READ AKHIR =================
        System.out.println("\n=== DATA SETELAH UPDATE & DELETE ===");
        dao.ambilSemuaHero();
    }
}