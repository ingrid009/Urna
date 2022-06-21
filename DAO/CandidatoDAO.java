package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.CandidatoModel;

/**
 *
 * @author Israel
 */
public class CandidatoDAO extends ExecuteSQL{
    public CandidatoDAO(Connection con){
        super(con);
    }
    
    public String salvar(CandidatoModel chapa){
        String sql = "INSERT INTO candidato VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);  
            ps.setInt(1, chapa.getNumero());
            ps.setString(2, chapa.getNome());
            if(ps.executeUpdate() > 0){
                return "Candidato Inserido com sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}