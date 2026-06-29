import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class HeroDAO {

    Connection conn;

    public HeroDAO() {
        conn = Koneksi.getConnection();
    }

    public void tambahHero(Hero h) {
        String sql = "INSERT INTO hero (nama, level) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, h.getNama());
            ps.setInt(2, h.getLevel());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ambilSemuaHero() {
        String sql = "SELECT * FROM hero";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nama") + " | " +
                        rs.getInt("level")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateLevel(int id, int level) {
        // Parameter pertama (?) = nilai level baru yang akan diupdate ke hero
// 🟡 Parameter kedua (?) = id hero yang dipilih untuk diubah
        String sql = "UPDATE hero SET level = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, level);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hapusHero(int id) {
        // Parameter (?) = id hero yang akan dihapus dari database
        String sql = "DELETE FROM hero WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}