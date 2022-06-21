package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.EleitorModel;

/**
 *
 * @author Israel
 */
public class EleitorDAO extends ExecuteSQL{
    public EleitorDAO(Connection con){
        super(con);
    }
    
    public String salvar(EleitorModel eleitor){
        String sql = "INSERT INTO eleitor VALUES(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);  
            ps.setInt(1, eleitor.getCpf());
            ps.setString(2, eleitor.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Eleitor Inserido com sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}