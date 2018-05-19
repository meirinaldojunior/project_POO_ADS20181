package project_poo_ads20181.negocio;

import project_poo_ads20181.classes.Categoria;
import java.util.ArrayList;
import project_poo_ads20181.acesso.DAOCategoria;
import project_poo_ads20181.acesso.DAOCategoriaImplementa;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;


public class RNCategoria {

    public void validaProduto(Categoria ct)throws GeralException{
        validarAtributos(ct);
        if(ct.getNomeCategoria()==null){
            throw new GeralException ("Categoria inválida!");
        }
    }

	private void validarAtributos(Categoria ct) {
		// TODO Auto-generated method stub
		
	}
	
}
