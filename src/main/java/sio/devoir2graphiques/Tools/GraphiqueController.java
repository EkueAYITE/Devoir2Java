package sio.devoir2graphiques.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class GraphiqueController
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public GraphiqueController() {
        cnx = ConnexionBDD.getCnx();
    }
    // A vous de jouer
    public HashMap<Integer, Double> GetDataGraphique1() {
        HashMap<Integer, Double> dataSalaires = new HashMap();
            try
            {
                cnx = ConnexionBDD.getCnx();
                ps = cnx.prepareStatement(" SELECT ageEmp, AVG(salaireEmp) AS moyenneSalaire\n" +
                        "                    FROM employe\n" +
                        "                    GROUP BY ageEmp;");
                rs = ps.executeQuery();
                while (rs.next()) {
                    dataSalaires.put(rs.getInt(2),rs.getDouble(1));
                }

            } catch (SQLException e)
            {
                throw new RuntimeException(e);
            }


        return dataSalaires;
    }
    public HashMap<String, Double> GetDataGraphique2() {
        HashMap<String, Double> dataSatSex = new HashMap();
        try
        {
            cnx = ConnexionBDD.getCnx();
            ps = cnx.prepareStatement("SELECT\n" +
                    "    sexe,\n" +
                    "    COUNT(*) AS count\n" +
                    "FROM\n" +
                    "    employe\n" +
                    "GROUP BY\n" +
                    "    sexe;");
            rs = ps.executeQuery();
            while (rs.next()) {
                dataSatSex.put(rs.getString(1),rs.getDouble(2));
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


        return dataSatSex;
    }


}
